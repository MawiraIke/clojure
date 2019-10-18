(ns atbash-cipher)

(def ^:private alphabets "abcdefghijklmnopqrstuvwxyz")

(defn v->encode [dx]
  "Returns a vector to encode"
  (let [x (vec dx) xs (vec alphabets)
        idx (fn [xs cr]
              (.indexOf xs cr))]
    (loop [ls x acc []]
      (if (> (.length ls) 0)
        (recur (vec (next ls)) (conj acc (idx xs (first ls))))
        acc))))

(defn encode-v [dx]
  "Prints the encoded text"
  (let [acc (atom "")
        ls (vec (map #(str (get (vec (reverse alphabets)) %)) dx))]
    (last (for [i ls]
            (reset! acc (str @acc i))))))

(defn encode [ls]
  (let [dx (v->encode ls)]
    (encode-v dx)))

