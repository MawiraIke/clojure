(ns diamond
  (:require [clojure.string :as str]))

(def alphabet2 (map char (range (int \A) (inc (int \Z)))))

(defn- pad [x]
  (apply str (repeat x "*")))

(defn- one-row [letter [inner-padding outer-padding]]
  (if (= inner-padding 0)
    (str (pad outer-padding) letter (pad outer-padding))
    (str (pad outer-padding) letter (pad inner-padding) letter (pad outer-padding))))

(defn- row-details [num-letters]
  (let [inner-dots (conj (iterate (partial + 2) 1) 0)
        outer-dots (iterate dec (dec num-letters))]
    (take num-letters (map vector inner-dots outer-dots))))

(defn diamond [letter]
  "Loops over the letters of the alphabet until the letter (argument) is got. "
  (let [num-letters (- (int letter) (dec (int \A)))
        top-half (map one-row (take num-letters alphabet2) (row-details num-letters))]
    ;(loop [idx 0]
    ;  (if (= (str (nth alphabet idx)) (str letter))
    ;    (do
    ;      (perform-print (nth alphabet idx) idx num-letters)
    ;      "Done")
    ;    (do
    ;      (perform-print (nth alphabet idx) idx num-letters)
    ;      (recur (inc idx)))))
    (concat top-half (rest (reverse top-half)))))
