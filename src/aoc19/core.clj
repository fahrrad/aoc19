(ns aoc19.core
  (:require [clojure.java.io :as io]
            [clojure.string :as s]))

(defn load-file
  ([day]
   (load-file day #"\n"))
  ([day separator]
   (s/split (slurp (io/resource (str "day" day ".txt"))) separator)))
