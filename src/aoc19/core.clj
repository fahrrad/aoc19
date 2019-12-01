(ns aoc19.core
  (:require [clojure.java.io :as io]
            [clojure.string :as s]))

(defn load-file [day]
  (s/split (slurp (io/resource (str "day" day ".txt"))) #"\n"))
