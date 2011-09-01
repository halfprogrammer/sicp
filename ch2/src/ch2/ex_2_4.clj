(ns ch2.ex_2_4)

(defn my-cons [x y]
  (fn [m]
    (m x y)))

(defn my-car [c]
  (c (fn [a b] a)))

(defn my-cdr [c]
  (c (fn [a b] b)))