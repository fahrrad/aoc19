(ns aoc19.day01-test
  (:require  [clojure.test :as t]
             [aoc19.day01 :as sut]))

(t/deftest fuel-requirement-test
  (t/testing "fuel requirement examples"
    (dorun
     ;; examples from question
     (for [[in out] [[12 2] [14 2] [1969 654] [100756 33583]]]
       (t/is (= out (sut/fuel-requirement in)))))))

(t/deftest fuel-for-fuel
  (t/testing "fuel for fuel examples"
    (dorun
     (for [[in out] [[14 2] [1969 966] [100756 50346]]]
       (t/is (= out (sut/fuel-requirement-rec in)))))))
