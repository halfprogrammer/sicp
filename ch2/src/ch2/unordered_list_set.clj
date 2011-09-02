(ns ch2.unordered_list_set)

(defn element-of-set? [s x]
  (cond (empty? s) false
        (= x (first s)) true
        :else (recur (rest s) x)))

(defn adjoin-set [s x]
  (if (element-of-set? s x)
    s
    (conj s x)))

;; (defn empty-set []
;;   ())

;; (defn get-first-data [s]
;;   (first s))

;; (defn get-rest [s]
;;   (rest s))

(defn union-set [s1 s2]
  (cond (empty? s2) s1
        (element-of-set? s1 (first s2)) (recur s1 (rest s2))
        :else (recur (conj s1 (first s2)) (rest s2))))

(defn intersection-set [s1 s2]
  (letfn [(find-intersection [iter-set new-set]
            (cond (empty? iter-set) new-set
                  (element-of-set? s1 (first iter-set)) (recur (rest iter-set) (conj new-set (first iter-set)))
                  :else (recur (rest iter-set) new-set)))]
    (find-intersection s2 ())))