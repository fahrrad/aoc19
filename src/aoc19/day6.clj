(ns aoc19.day6
  (:require [aoc19.core :as core]
            [clojure.string :as s]
            [clojure.set :as set]))

(def orbits
  (->> (core/load-file "6")
       (map #(s/split % #"\)"))
       (map reverse)
       (map #(into [] %))
       (into {})))

(count orbids)

(defn steps-to-com [planet]
  (if (= "COM" planet)
    0
    (+ 1 (steps-to-com (get orbits planet)))))


(defn path-to-com [planet]
  (if (= "COM" planet)
    []
    (conj (path-to-com (get orbits planet)) planet)))

(steps-to-com "COM")
(steps-to-com "7J9")
(steps-to-com "FCS")

(path-to-com "COM")
(path-to-com "7J9")
(path-to-com "FCS")


(def san-path (reverse  (path-to-com "SAN")))
(def you-path (reverse (path-to-com "YOU")))
(def you-path-set (into #{} (path-to-com "YOU")))

(def first-con (first (remove nil? (map you-path-set san-path))))

(+ -2 (.indexOf san-path first-con)
   (.indexOf you-path first-con))


(->>
 (vals orbits)
 (map steps-to-com )
 (apply + ))

(apply +
       (map steps-to-com
            (keys orbits)))
