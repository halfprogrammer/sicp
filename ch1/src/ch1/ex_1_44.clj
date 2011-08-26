(ns ch1.ex_1_44
  (:use ch1.ex_1_43))


(def dx 0.00001)


(defn smoothen
  ([f] (fn [x]
         (/ (+ (f (- x dx))
               (f x)
               (f (+ x dx)))
            3)))
  ([f n]
     ((repeated smoothen n) f)))