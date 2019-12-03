(ns aoc19.day02-test
  (:require [aoc19.day02 :as sut]
            [clojure.test :as t]))

(t/deftest run-test
  (t/testing "examples"
    (let [examples [[1,0,0,0,99] [2,0,0,0,99]
                    [2,3,0,3,99] [2,3,0,6,99]
                    [2,4,4,5,99,0] [2,4,4,5,99,9801]
                    [1,1,1,4,99,5,6,0,99] [30,1,1,4,2,5,6,0,99]]]
      (dorun (for [[in out] (partition 2 examples)]
               (t/is (= out (sut/run in))))))))
