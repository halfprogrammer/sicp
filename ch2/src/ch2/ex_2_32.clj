(ns ch2.ex_2_32)

(defn subsets [coll]
  (if (empty? coll)
    [[]]
    (mapcat (fn [s] [s (conj s (first coll))]) (subset (rest coll)))))


(defn subsets-reduce [coll]
  (reduce (fn [sets new-item]
            (mapcat (fn [s] [s (conj s new-item)]) sets))
          [[]]
          coll))
