(ns armstrong-numbers)

(defn pwr [num pw]
  "Returns power pw of a number. Does not check for
  ArithmeticException. for instance (pwr 10 100) thr-
  ows an exception"
  (loop [x 0 acc 1]
    (if (= pw x)
      acc
      (recur (inc x) (* acc num)))))

(defn armstrong [num]
  (loop [dx num acc 0]
    (if (> (.length dx) 0)
      (recur (vec (next dx)) (+ acc (pwr (first dx) (.length num))))
      acc)))
