(ns clock)

(defn time* [hours minutes]
  {:hours hours :minutes minutes})

(defn clock [hours minutes]
  {:hours hours :minutes minutes})

(defn clock->string [clock]
  (str (:hours clock) " hours, " (:minutes clock) " minutes."))

(defn to-min [time]
  (let [hours (:hours time)
        min (:minutes time)]
    {:hours 0 :minutes (+ (* hours 60) min)}))

(defn to-hours [time]
  (let [hours (int (/ time 60))
        minutes (mod time 60)]
    {:hours hours :minutes minutes}))

(defn add-logic [clock time]
  (to-hours (+ (:minutes (to-min clock)) (:minutes (to-min time)))))

(defn add-time [clock time]
  (clock->string (to-hours (+ (:minutes (to-min clock)) (:minutes (to-min time))))))
