(ns aoc19.day01
  (:require [aoc19.core :as core]
            [clojure.edn :as edn]))

(defn fuel-requirement [m]
  (- (quot m 3) 2))


(->> (core/load-file "1")
    (map edn/read-string)
    (map fuel-requirement)
    (apply +))3454026
