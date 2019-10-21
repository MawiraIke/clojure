(ns bob)

(def responses {:question      "Sure"
                :yell          "Whoa, chill out!"
                :question-yell "Calm down, I know what I'm doing!"
                :nothing       "Fine. Be that way!"
                :otherwise     "Whatever.'"})

(def state (atom 0))

(defn searchVec [string st]
  (let [xs (map (fn [n] (str n)) (filter (fn [n] (< (.length (str n)) 2)) (vec string)))
        state (atom 0)]
    (->>
      (loop [sq (vec xs)]
        (if (> (count sq) 0)
          (do (if (= (first sq) st)
                (reset! state 1))
              (recur (next sq)))
          @state)))))

(defn response-for [s]
  (cond
    (= (searchVec s "?") 1)
    (if (= (searchVec s "!") 1)
      (get responses :question-yell)
      (get responses :question))

    (= (searchVec s "!") 1)
    (get responses :yell)

    (= (.length s) 0)
    (get responses :nothing)

    :else
    (get responses :otherwise)))



