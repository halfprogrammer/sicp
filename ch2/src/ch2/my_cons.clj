(ns ch2.my_cons)

(defn my-cons [a b]
  (fn [x]
    (cond (= x 0) a
          (= x 1) b
          :else (throw (IllegalArgumentException. "function takes either 0 or 1")))))

(defn my-car [cons-cell]
  (cons-cell 0))

(defn my-cdr [cons-cell]
  (cons-cell 1))

