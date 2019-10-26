(ns crypto-square
  (:require [clojure.string :as str]))

(defn decide-r-v [text]
  "Determines the number of rows and columns and then returns a map"
  (let [xs (count text)]
    [7 8]))

(defn normalize-vec [vect]
  (loop [sq vect
         acc []]
    (if (> (count sq) 0)
      (recur (vec (next sq)) (if (and (not= (first sq) \space) (not= (first sq) \.) (not= (first sq) \,))
                               (conj acc (str/lower-case (first sq)))
                               acc))
      acc)))

(defn normalize-plaintext [text]
  (loop [acc ""
         sq (normalize-vec (vec text))]
    (if (> (count sq) 0)
      (recur (str acc (first sq)) (next sq))
      acc)))

(defn square-size [normal-text]
  (let [[rows columns] (decide-r-v normal-text)
        sq (vec normal-text)]
    (loop [acc {}
           idx 0]
      (let [stp-y (if (< idx columns) 0 (int (/ idx columns)))]
        (if (< idx (count normal-text))
          (recur (assoc acc (str stp-y) (if (not-empty (get acc (str stp-y)))
                                          (conj (get acc (str stp-y)) (str (nth sq idx)))
                                          [(str (nth sq idx))]))
                 (inc idx))
          (vec (map (fn [n] (val n)) (sort acc))))))))

(defn get-encode [args]
  (loop [acc ""
         stp-x 0
         stp-y 0]
    (if (and (= stp-y (dec (count args))) (= stp-x (dec (count (last args)))))
      acc
      (recur (str acc (get-in args [stp-y stp-x]))
             (if (not= stp-y (dec (count args))) stp-x (if (< stp-x (dec (count (first args)))) (inc stp-x) 0))
             (if (= stp-y (dec (count args))) 0 (inc stp-y)))
      )))

(defn plaintext-segments []
  ())

(defn ciphertext [text]
  (->> text
       (normalize-plaintext)
       (square-size)
       (get-encode)
       ))

(defn normalize-ciphertext []
  ())
