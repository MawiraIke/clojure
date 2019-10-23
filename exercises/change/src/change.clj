(ns change)

(def changes [1 5 10 25 100])

(defn gen-range [co]
  (vec (for [i (range co)]
         1)))

(defn choose-mod [num]
  (let [x (count (gen-range num))
        y (reverse changes)]
    (loop [vx x
           acc {:100 0
                :25  0
                :10  0
                :5   0
                :1   0}]
      (cond
        (> vx (first y))
        (recur (- vx 100) (assoc acc :100 (inc (get acc :100))))

        (> vx (second y))
        (print ">25")

        (> vx (get y 3))
        (print ">10")

        (> vx (get y 4))
        (print ">5")

        (> vx (last y))
        (print ">1")
        ))))

(defn issue []
  ())
