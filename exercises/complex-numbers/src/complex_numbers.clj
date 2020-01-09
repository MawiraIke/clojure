(ns complex-numbers
  (:import (clojure.lang PersistentVector)))

(defn pow [base exp]
  (if (zero? base)
    0
    (loop [base base, exp exp, acc 1]
      (if (zero? exp)
        acc
        (recur base (dec exp) (* acc base))))))

(defprotocol Complex
  (complex+ [complex value])
  (complex- [complex value])
  (complex* [complex value])
  (complex-div [complex value]))

(extend-type PersistentVector
  Complex
  (complex+ [[a i b] [c i-2 d]]
    [(+ a c) (* (+ b d) i)])
  (complex- [[a i b] [c i-2 d]]
    [(- a c) (* (- b d) i)])
  (complex* [[a i b] [c i-2 d]]
    [(* a (- c (* b d)))
     (* (* b (+ c (* a d))) i)])
  (complex-div [[a i b] [c i-2 d]]
    [(/ (* a (+ c (* b d))) (+ (pow c 2) (pow d 2)))
     (/ (* b (- c (* a d))) (* (+ (pow c 2) (pow d 2)) i))]))

(defn do-func
  [f [a b e] [c d g]]
  (if (nil? e)
    (f [a 1 b] [c 1 d])
    (f [a b e] [c d g])))

(defn real [[a b]] a)

(defn imaginary [[a b]] b)

(defn abs [[a b]])

(defn conjugate [[a b]] (- a b))

(defn add [cur val] (do-func complex+ cur val))

(defn sub [cur val] (do-func complex- cur val))

(defn mul [cur val] (do-func complex* cur val))

(defn div [cur val] (do-func complex-div cur val))
