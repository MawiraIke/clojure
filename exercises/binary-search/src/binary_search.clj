(ns binary-search
  (:import (java.util Collections Comparator ArrayList)))

(defn middle [xs]
  (quot (count xs) 2))

(defn search-for [cr sq]
  (loop [sequ sq
         acc 0]
    (let [mid (middle sequ)
          curr (nth sequ mid)]
      (if (= curr cr)
        (if (= acc 0)
          mid
          (+ mid acc))
        (cond
          (< curr cr)
          (recur (subvec sequ (+ mid 1) (count sequ))
                 (+ acc 1 (count (subvec sequ 0 mid))))

          (> curr cr)
          (recur (subvec sequ 0 mid) (if (= acc 0) 0 acc))

          :else
          (print "Unsupported operation"))))))