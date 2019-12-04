(ns aoc19.day03
  (:require [aoc19.core :as core]
            [clojure.string :as s]))

(defmulti next-point (fn [_ direction _] direction))

(defmethod next-point :U [[x y] direction length]
  [x (+ y length)])

(defmethod next-point :D [[x y] direction length]
  [x (- y length)])

(defmethod next-point :R [[x y] direction length]
  [(+ length x) y])

(defmethod next-point :L [[x y] direction length]
  [(- x length) y])

(defn points-between [[x1 y1] [x2 y2]]
  (cond
    (and (< y1 y2) (= x1 x2))
    (for [y (range y1 (inc y2))] [x1 y])

    (and (> y1 y2) (= x1 x2))
    (for [y (range y1 (dec y2) -1)] [x1 y])

    (and (< x1 x2) (= y1 y2))
    (for [x (range x1 (inc x2))] [x y1])

    (and (> x1 x2) (= y1 y2))
    (for [x (range x1 (dec x2) -1)] [x y1])

    (and (= x1 x2) (= y1 y2)) []
    :else (throw (IllegalArgumentException.
                  "No support for diagonal lines"))))

(defn parse-directions [s]
  {:direction (keyword
               (subs s 0 1))
   :length (Integer/parseInt (subs s 1))})

(defn directions-to-coordinates [directions]
  (reduce (fn [acc x] (conj acc (next-point
                                 (last acc)
                                 (:direction x)
                                 (:length x))))
          [[0 0]]
          directions))

(defn coordinates-to-points [coordinates]
  (reduce (fn [acc x]
            (into acc (points-between (last acc) x)))
          [[0 0]]
          coordinates))

(def l1-points
  (let [[l1 _]
        (core/load-file "3")]
    (coordinates-to-points
     (directions-to-coordinates
      (map parse-directions
           (s/split l1 #","))))))

(def l2-points
  (let [[_ l2]
        (core/load-file "3")]
    (coordinates-to-points
     (directions-to-coordinates
      (map parse-directions
           (s/split l2 #","))))))

(def intersections
  (max (for [p1 l1-points
        p2 l2-points
        :when (= p1 p2)]
    p1))
