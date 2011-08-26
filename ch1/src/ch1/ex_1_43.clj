(ns ch1.ex_1_43
  (:use ch1.ex_1_42))

(defn repeated [f num]
  (fn [x]
    (loop [func identity
           num num]
      (if (zero? num)
        (func x)
        (recur (my-compose func f) (dec num))))))