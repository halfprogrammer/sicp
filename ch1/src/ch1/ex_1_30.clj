(ns ch1.ex_1_30)

(defn summation-iter [term a next b]
  (letfn [(iter [a result]
            (if (> a b)
              result
              (recur (next a) (+ result (term a)))))]
    (iter a 0)))

