(ns aoc19.day01-test
  (:require  [clojure.test :as t]
             [aoc19.day01 :as sut]))

(t/deftest fuel-requirement-test
  (t/testing "fuel requirement examples"
    (dorun
     ;; examples from question
     (for [[in out] [[12 2] [14 2] [1969 654] [100756 33583]]]
       (t/is (= out (sut/fuel-requirement in)))))))
