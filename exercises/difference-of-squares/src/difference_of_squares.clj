(ns difference-of-squares)

(defn pow [base exp]
  (loop [base base, exp exp, acc 1]
    (if (zero? exp)
      acc
      (recur base (dec exp) (* acc base)))))

(defn sum-of-squares [rep]
  (reduce + (for [i (range 1 (inc rep))]
              (pow i 2))))

(defn square-of-sum [rep]
  (pow (reduce + (range 1 (inc rep))) 2))

(defn difference [rep]
  (- (square-of-sum rep) (sum-of-squares rep)))
