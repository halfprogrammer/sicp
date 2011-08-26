(ns ch1.ex_1_40
  (:use ch1.newton_transform))

(defn cubic-root [a b c]
  (newtons-method (fn [x]
                   (+ (cube x)
                      (* a (square x))
                      (* b x)
                      c))
                 1.0))

