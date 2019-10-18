(ns beer-song)

(defn pn [n]
  "Returns a paragraph of a song"
  (format "%d bottles of beer on the wall, %d bottles of beer.\nTake one down and pass it around, %d bottles of beer on the wall.\n" n n (dec n)))

(defn pn1 [n]
  "Returns a paragraph of a song"
  (format "%d bottles of beer on the wall, %d bottles of beer.\nTake one down and pass it around, %d bottle of beer on the wall.\n" n n (dec n)))

(defn pn0 [n]
  "Returns a paragraph of a song"
  (format "%d bottles of beer on the wall, %d bottles of beer.\nTake one down and pass it around, no more bottles of beer on the wall.\n" n n))

(defn pn-0 [n]
  "Returns a paragraph of a song"
  "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.")


(defn verse
  "Returns the nth verse of the song."
  [num]
  (cond (> num 2)
        (pn num)

        (= num 2)
        (pn1 num)

        (= num 1)
        (pn0 num)

        (= num 0)
        (pn-0 num)

        :else
        "Unknown situation"))

(defn p-fx [start end]
  (let [chr (atom "")]
    (loop [idx start]
      (if (>= idx end)
        (do
          (reset! chr (str @chr (verse idx)))
          (recur (dec idx)))
        @chr))))

(defn sing
  "Given a start and an optional end, returns all verses in this interval. If
  end is not given, the whole song from start is sung."
  ([start] (p-fx start 0))
  ([start end] (p-fx start end)))
