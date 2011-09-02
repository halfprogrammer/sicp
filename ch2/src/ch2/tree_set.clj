(ns ch2.tree_set)

(defrecord TreeNode [data left right])

(defn element-of-set? [t x]
  (cond (nil? t) false
        (= x (:data t)) true
        (< x (:data t)) (recur (:left t) x)
        :else (recur (:right t) x)))

(defn adjoin-set [t x]
  (cond (nil? t) (TreeNode. x nil nil)
        (= x (:data t)) t
        (< x (:data t)) (TreeNode. (:data t)
                                   (adjoin-set (:left t) x)
                                   (:right t))
        :else (TreeNode. (:data t)
                         (:left t)
                         (adjoin-set (:right t) x))))

(defn traverse-tree [t f]
  (when-not (nil? t)
    (traverse-tree (:left t) f)
    (f t)
    (traverse-tree (:right t) f)))

(defn print-tree [t]
  (traverse-tree t #(print (:data %))))

