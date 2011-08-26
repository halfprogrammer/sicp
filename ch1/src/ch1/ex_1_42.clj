(ns ch1.ex_1_42)

(defn my-compose [f g]
  (fn [x]
    (f (g x))))