(ns aoc19.day02
  (:require [aoc19.core :as core]
            [clojure.edn :as edn]))

;; part 1
(defn run
  ([mmap] (run mmap 0))
  ([mmap ip]
   (let [operate (fn [source-1 source-2 target operation]
                   (assoc mmap target
                          (operation
                           (get mmap source-1)
                           (get mmap source-2))))
         [opcode p1 p2 p3] (drop ip mmap)
         ip (+ ip 4)]
     (case opcode
       99 mmap
       1 (recur (operate p1 p2 p3 +) ip)
       2 (recur (operate p1 p2 p3 *) ip)))))

(defn solve
  ([] (solve 12 2))
  ([noun verb]
   (->
    (core/load-file "2" #",")
    (as->
        m
        (map edn/read-string m)
      (into [] m))
    (assoc 1 noun 2 verb)
    run
    first)))

;; Part 2
#_(for [noun (range 0 100)
      verb (range 0 100)
      :when (= 19690720 (solve noun verb))]
  (+ (* 100 noun) verb))
