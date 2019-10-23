(ns binary-search-tree)

(defn value [node] (first node))
(defn left [node] (second node))
(defn right [node] (last node))
(defn singleton [n] [n nil nil])

(defn insert [v node]
  "Insert a value into a node. Receives the value and
  node as arguments."
  (if
    (empty? node)
    (singleton v)
    (let [x (value node)]
      (if
        (>= x v)
        [x (insert v (left node)) (right node)]
        [x (left node) (insert v (right node))]))))

(defn from-list [xs]
  (reduce #(insert %2 %1) nil xs))

(defn to-list [node]
  (if
    (empty? node)
    node
    (concat (to-list (left node)) [(value node)] (to-list (right node)))))
