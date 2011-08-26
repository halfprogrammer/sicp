(ns ch1.coinchange)

(defn coin-change
  ([amt denom cur]
       (cond (zero? amt) 1
           (or (neg? amt) (neg? cur)) 0
           :else (+ (coin-change amt denom (dec cur))
                    (coin-change (- amt (nth denom cur)) denom cur))))
  
  ([amt denom]
     (coin-change amt (sort denom) (dec (count denom)))))

;;; Coin Change using Dynamic Programming
(defn create-matrix [rows cols val]
  (vec (take rows (repeat (vec (take cols (repeat val)))))))

(defn my-coin-change [amt denom]
  (let [cost-mat (create-matrix 1 (count denom) 1)]
    (get-in (reduce (fn [cost-mat amt]
                      (let [cur-row (count cost-mat)]  ; This is the index of the row that we will be adding
                        (letfn [(find-total [mat col]
                                  (+ (get-in mat [cur-row (dec col)] 0)
                                     (let [balance (- cur-row (nth denom col))]
                                       (if (neg? balance)
                                         0
                                         (get-in mat [balance col] 0)))))]
                          (reduce (fn [mat denom]
                                    (assoc-in mat
                                              [cur-row denom]
                                              (find-total mat denom)))
                                  (conj cost-mat [0])
                                  (range (count denom))))))
                    cost-mat
                    (range 1 (inc amt)))
            [amt (dec (count denom))])))

