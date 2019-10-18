(ns cust-source)

(defn pwr [num pw]
  "Returns power pw of a number. Does not check for
  ArithmeticException. for instance (pwr 10 100) thr-
  ows an exception"
  (loop [x 0 acc 1]
    (if (= pw x)
      acc
      (recur (inc x) (* acc num)))))