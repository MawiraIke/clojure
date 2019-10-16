(ns all-your-base)

(defn b-multiplier [num count]
  (loop [x 0
         base num
         loop-t count
         acc 1]
    (if (= loop-t x)
      acc
      (recur (inc x) base loop-t (* acc base)))))

(defn convert [base number]
  (loop [len (.length number)
         x 0
         acc 0]
    (if (= x len)
      acc
      (do
        (print (str (get number x) " * " base "^" (- len x 1) " + "))
        ; Work out the math
        (recur
          len
          (+ x 1)
          (+ acc (* (get number x) (b-multiplier base (- len x 1)))))
        ))))
