(ns aoc19.day03)

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
