(ns ch2.ex_2_27)

(defn my-reverse [lst]
  (if (number? lst)
    lst
    (reduce conj () lst)))

(defn my-deep-reverse [lst]
  (cond (number? lst) lst
        :else (my-reverse (map my-reverse lst))))