(ns change)

(def changes [1 5 10 25 100])

(defn gen-range [co]
  (vec (for [i (range co)]
         1)))

(defn sel [vx y]
  "Returns a vector containing the key and the value
  of the highest value in changes which is less than vx."
  (cond
    (>= vx (first y))
    [:100 100]

    (>= vx (second y))
    [:25 25]

    (>= vx (nth y 2))
    [:10 10]

    (>= vx (nth y 3))
    [:5 5]

    (>= vx (last y))
    [:1 1]))

(defn issue [num]
  (let [x (count (gen-range num))
        y (reverse changes)]
    (loop [vx x
           acc {:100 0
                :25  0
                :10  0
                :5   0
                :1   0}]
      (if (> vx 0)
        (let [[k v] (sel vx y)]
          (recur (- vx v) (assoc acc k (inc (k acc)))))
        acc))))