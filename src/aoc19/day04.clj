(ns aoc19.day04
  (:require [clojure.string :as s]))

(defn passes [p]
  (let [p-str (str p)]
    (and
     (= 6 (count p-str))
     (let [f (frequencies p-str)]
       (some #{2} (vals f)))
     (= p-str (s/join (sort p-str))))))

(count (for [i (range 145852 616942)
             :when (passes i)]
         i))
