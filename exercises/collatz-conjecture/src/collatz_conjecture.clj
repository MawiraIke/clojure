(ns collatz-conjecture)

(defn collatz [num]
  (loop [kv num
         num 1]
    (if (= kv 1)
      (do
        (println (str num ". " 1))
        "Done")
      (do
        (println (str num ". " kv))
        (recur (if (even? kv)
                 (/ kv 2)
                 (+ (* 3 kv) 1)) (inc num))))))
