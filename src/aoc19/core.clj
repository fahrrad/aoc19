(ns aoc19.core
  (:require [clojure.java.io :as io]
            [clojure.string :as s]
            [clojure.edn :as edn]))

(defn parse-opcode [opcode]
  (let []))

(defn
  run
  ([mmap] (run mmap 0))
  ([mmap ip]
   (let [operate (fn [source-1 source-2 target operation]
                   (assoc mmap target
                          (operation
                           (get mmap source-1)
                           (get mmap source-2))))
         [opcode p1 p2 p3] (drop ip mmap)]
     (case opcode
       99 mmap
       1 (recur (operate p1 p2 p3 +) (+ 4 ip))
       2 (recur (operate p1 p2 p3 *) (+ 4 ip))
       3 (recur (assoc mmap p1 (Integer/parseInt (read-line))) (+ 2 ip))
       4 (do (prn p1) (recur mmap (+ 2 ip)))))))


(defn load-file
  ([day]
   (load-file day #"\n"))
  ([day separator]
   (s/split (slurp (io/resource (str "day" day ".txt"))) separator)))
