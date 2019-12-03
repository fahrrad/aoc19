(ns aoc19.day01
  (:require [aoc19.core :as core]
            [clojure.edn :as edn]))

;; Part 1
(defn fuel-requirement [m]
  (- (quot m 3) 2))

(defn day01-part1 []
  (->> (core/load-file "1")
       (map edn/read-string)
       (map fuel-requirement)
       (apply +)))

;; Part 2
(defn fuel-requirement-rec
  "Calculates the fuel needed for this much fuel"
  [mass]
  (let [fuel (fuel-requirement mass)]
    (if (pos? fuel)
      (+ fuel (fuel-requirement-rec fuel))
      0)))

(defn day01-part2 []
  (->> (core/load-file "1")
       (map edn/read-string)
       (map fuel-requirement-rec)
       (apply +)))
