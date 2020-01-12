(ns armstrong-numbers)

(defn sum [vect]
  (int (reduce + (map #(Math/pow % (count vect)) vect))))

(defn digits [n]
  (->> n
       (iterate #(quot % 10))
       (take-while pos?)
       (mapv #(mod % 10))
       rseq))

(defn armstrong? [num]
  (if (= (sum (digits num)) num)
    true
    false))
