(ns anagram)

(defn match? [word-1 word-2]
  (let [idx-1 (.length word-1)
        idx-2 (.length word-2)
        exec (fn [wo-1 wo-2] (clojure.set/difference (set wo-1) (set wo-2)))]
    (if (> idx-1 idx-2)
      (empty? (exec word-1 word-2))
      (empty? (exec word-2 word-1)))))

(defn cnv [acc ls]
  (keys (filter (fn [xs] (if (= true (val xs))
                           (key xs)))
                (zipmap ls acc))))

(defn anagrams-for [word prospect-list]
  (loop [dx 0
         acc []]
    (if (< dx (.length prospect-list))
      (recur
        (+ dx 1)
        (conj acc
              (match? word (get prospect-list dx))))
      (vec (cnv acc prospect-list)))))
