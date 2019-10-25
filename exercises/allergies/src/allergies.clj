(ns allergies)

(def sample-data {:eggs     1 :peanuts 2 :shellfish 4 :strawberries 8
                  :tomatoes 16 :chocolate 32 :pollen 64 :cats 128})

(defn sel [x]
  "Returns a vector containing the key and the value
  of the highest value in changes which is less than vx."
  (loop [sq (vec (mapcat (fn [[k v]]
                           [k v]) (reverse sample-data)))]
    (if (>= x (second sq))
      {:k (first sq)}
      (recur (nthnext sq 2)))))

(defn allergies [score]
  (let [mapl (atom {:eggs     0 :peanuts 0 :shellfish 0 :strawberries 0
                    :tomatoes 0 :chocolate 0 :pollen 0 :cats 0})]
    (loop [x score
           mapf (sel x)]
      (if (> x 0)
        (let [nx (- x ((:k mapf) sample-data))]
          (reset! mapl (assoc @mapl (:k mapf) (inc ((:k mapf) @mapl))))
          (recur nx (if (> nx 0) (sel nx) 0)))
        @mapl))))

(defn allergic-to? [score alerg]
  )
