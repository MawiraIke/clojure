(ns example)

(defn normalize-plaintext [input]
  (.toLowerCase (clojure.string/replace input #"[^0-9a-zA-Z]" "")))

(defn square-size [input]
  (let [s (Math/sqrt (count input))
        si (Math/round (Math/floor s))]
    (if (== 0 (rem s si))
      si (inc si))))

(defn plaintext-segments [input]
  (let [text (normalize-plaintext input)
        size (square-size text)]
    (vec (map #(apply str %1)
              (partition size size nil text)))))

(defn ciphertext [input]
  (let [segments (plaintext-segments input)
        size (count (first segments))]
    (apply str (for [n (range size)
                     s segments]
                 (nth s n nil)))))

(defn normalize-ciphertext [input]
  (let [cipher                  (ciphertext input)
        cipher-length           (count cipher)
        square-max              (square-size cipher)
        square-longest          (int (Math/ceil (/ (count cipher) square-max)))
        square-shortest         (int (Math/floor (/ (count cipher) square-max)))
        square-count-long-sides (- cipher-length (* square-max square-shortest))]
    (apply str (interpose " "
                          (map #(apply str %1)
                               (concat (partition square-longest square-longest nil
                                                  (take (* square-count-long-sides square-longest) cipher))
                                       (partition square-shortest square-shortest nil
                                                  (take-last (- cipher-length (* square-count-long-sides square-longest)) cipher))))))))
