(ns ex_1_39
  (:use ch1.ex_1_37))

(defn mytan-deg [x]
  (let [x (Math/toRadians x)]
    (const-frac-recur (fn [nr]
                        (if (= 1 nr)
                          x
                          (- (* x x))))
                      #(dec (* 2 %))
                      10)))