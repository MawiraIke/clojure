(ns binary)

(defn pwr [x n]
  (reduce * (repeat n x)))

(defn to-decimal [ls]
  (loop [sq ls
         acc 0
         idx 0]
    (if (> (.length sq) 0)
      (recur
        (vec (next sq))
        (+ acc (* (first sq) (pwr 2 (- (.length ls) idx 1))))
        (inc idx))
      acc)))

;(to-decimal [4 5 6 5 7 9])