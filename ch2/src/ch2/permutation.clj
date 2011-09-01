(ns ch2.permutation)

(defn insert-int-all-positions [coll x]
  (map (fn [idx]
         (let [[s1 s2] (split-at idx coll)]
           (concat s1 (list x) s2)))
       (range (inc (count coll)))))

(defn permute [coll]
  (reduce (fn [perms x]
            (mapcat (fn [p]
                      (insert-int-all-positions p x)) perms))
          [[]]
          coll))

