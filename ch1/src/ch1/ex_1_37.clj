(ns ch1.ex_1_37)

(defn const-frac-recur [nr-fn dr-fn k]
  (letfn [(rec-fn [idx]
            (if (= idx k)
              (/ (nr-fn idx) (dr-fn idx))
              (/ (nr-fn idx)
                 (+ (dr-fn idx)
                    (rec-fn (inc idx))))))]
    (rec-fn 1)))

;;; Golden ratio
;;; (const-frac-recur (fn [_] constantly 1) (fn [_] constantly 1) 10)


(defn const-frac-iter [nr-fn dr-fn k]
  (letfn [(iter-fn [idx acc]
            (if (zero? idx)
              acc
              (recur (dec idx)
                     (/ (nr-fn idx)
                        (+ (dr-fn idx) acc)))))]
    (iter-fn k 1)))