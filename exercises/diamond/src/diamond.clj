(ns diamond
  (:require [clojure.string :as str]))

(def alphabet "abcdefghijklmnopqrstuvwxyz")

(def alphabet2 (map char (range (int \A) (inc (int \Z)))))

(defn perform-print [item n limit]
  (println (str "*" (str/upper-case item) "*")))

(defn diamond [letter]
  "Loops over the letters of the alphabet until the letter (argument) is got. "
  (let [num-letters (- (int letter) (dec (int \A)))]
    (loop [idx 0]
      (if (= (str (nth alphabet idx)) letter)
        (do
          (perform-print (nth alphabet idx) idx num-letters)
          "Done")
        (do
          (perform-print (nth alphabet idx) idx num-letters)
          (recur (inc idx)))))))
