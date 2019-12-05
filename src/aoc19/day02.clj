(ns aoc19.day02
  (:require [aoc19.core :as core]
            [clojure.edn :as edn]))

;; part 1
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
    core/run
    first)))

;; Part 2
#_(for [noun (range 0 100)
      verb (range 0 100)
      :when (= 19690720 (solve noun verb))]
  (+ (* 100 noun) verb))
