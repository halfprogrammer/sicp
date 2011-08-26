(ns ch1.ch1-1-12)

(defn pascal [n]
  (reduce (fn [tri row]
            (assoc-in (reduce (fn [tri col]
                                (assoc-in tri
                                          [row col]
                                          (+ (get-in tri [(dec row) col])
                                             (get-in tri [(dec row) (dec col)]))))
                              (conj tri [1])
                              (range 1 row))
                      [row row] 1))
          [[1]]
          (range 1 n)))


(defn pascal-rec
  ([row col]
     (if (or (zero? col) (= row col))
       1
       (+ (pascal-rec (dec row) col)
          (pascal-rec (dec row) (dec col)))))
  ([max-row]
     (for [x (range max-row)]
          (for [y (range x)]
            (pascal-rec x y)))))
