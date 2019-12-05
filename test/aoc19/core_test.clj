(ns aoc19.core-test
  (:require [clojure.test :as t]
            [aoc19.core :as sut]
            [clojure.java.io :as io])
  (:import [java.io StringReader]))


(t/deftest run-test
  (t/testing "examples from day 2"
    (let [examples [[1,0,0,0,99] [2,0,0,0,99]
                    [2,3,0,3,99] [2,3,0,6,99]
                    [2,4,4,5,99,0] [2,4,4,5,99,9801]
                    [1,1,1,4,99,5,6,0,99] [30,1,1,4,2,5,6,0,99]]]
      (dorun (for [[in out] (partition 2 examples)]
               (t/is (= out (sut/run in)))))))
  (t/testing "opcode 3 reads 1 value"
    (let [mmap [3 0 99]
          input (io/reader (StringReader. "4"))
          expected-mmap [4 0 99]]
      (is (= expected-mmap
             (binding [*in* input] (sut/run mmap))))))
  (t/testing "opcode 3 reads only 1 line"
    (let [mmap [3 0 3 1 99]
          input (io/reader (StringReader. "4\n5"))
          expected-mmap [4 5 3 1 99]]
      (is (= expected-mmap
             (binding [*in* input] (sut/run mmap))))))
  (t/testing "opcode 4 prints"
    (let [mmap [4 1 99]]
      (= "4"
         (print-str (sut/run mmap)))))
  (t/testing "parsing opcode"
    (t/is (= {}))))
