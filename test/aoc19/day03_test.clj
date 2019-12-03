(ns aoc19.day03-test
  (:require  [clojure.test :as t]
             [aoc19.day03 :as sut]))

(t/deftest next-point-test
  (t/testing "going up"
    (t/is (= [0 5] (sut/next-point [0 0] :U 5))))
  (t/testing "going down"
    (t/is (= [0 0] (sut/next-point [0 5] :D 5))))
  (t/testing "going right"
    (t/is (= [4 0] (sut/next-point [0 0] :R 4))))
  (t/testing "going left"
    (t/is (= [0 0] (sut/next-point [4 0] :L 4)))))

(t/deftest points-between-test
  (t/testing "no diagonal lines"
    (t/is (thrown? IllegalArgumentException
                   (sut/points-between [1 2] [2 3]))))
  (t/testing "p1 is below p2"
    (t/is [[0 0] [0 1] [0 2] [0 3]]
          (sut/points-between [0 0] [0 3])))
  (t/testing "p1 is above p2"
    (t/is [[0 3] [0 2] [0 1] [0 0]]
          (sut/points-between [0 3] [0 1]))))
