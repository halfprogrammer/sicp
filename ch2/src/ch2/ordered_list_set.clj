(ns ch2.ordered_list_set)

(defrecord Node [data next])

(defn print-set [s]
  (when-not (nil? s)
    (print (:data s) " : ")
    (recur (:next s))))

(defn element-of-set? [s x]
  (cond (or (empty? s) (< x (:data s))) false
        (= (:data s) x) true
        :else (recur (:next s) x)))

(defn adjoin-set [s x]
  (cond (empty? s) (Node. x nil)
        (= (:data s) x) s
        (< (:data s) x) (Node. (:data s) (adjoin-set (:next s) x))
        :else (Node. x s)))

(defn intersection-set [s1 s2]
  (letfn [(find-intersection [s new-set]
            (cond (empty? s) new-set
                  (element-of-set? s1 (:data s)) (recur (:next s) (Node. (:data s) new-set))
                  :else (recur (:next s) new-set)))]
    (find-intersection s2 nil)))

(intersection-set (adjoin-set (adjoin-set (adjoin-set nil 1) 5) 4)
(adjoin-set (adjoin-set (adjoin-set nil 11) 16) 4))

(defn union-set [s1 s2]
  (cond (nil? s2) s1
        (element-of-set? s1 (:data s2)) (recur s1 (:next  s2))
        :else (recur (Node. (:data s2) s1) (:next s2))))
