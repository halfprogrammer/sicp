(ns ch1.ex_1_41)

(defn twice [f]
  (fn [x]
    (f (f x))))

;; (((twice (twice twice)) inc) 5) => 21