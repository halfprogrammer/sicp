(ns ch1.half_interval)

(defn average [& rst]
  (/ (apply + rst)
     (count rst)))

(defn search [f neg pos]
  (let [midpoint (average neg pos)
        test-val (f midpoint)]
    (letfn [(close-enough? [x y]
              (< (Math/abs (- x y)) 0.001))]
      (cond (close-enough? neg pos) midpoint
            (pos? test-val) (recur f neg midpoint)
            (neg? test-val) (recur f midpoint pos)
            :else midpoint))))

(defn half-interval-method [f a b]
  (let [a-val (f a)
        b-val (f b)]
    (cond (and (neg? a-val) (pos? b-val)) (search f a b)
          (and (pos? a-val) (neg? b-val)) (search f b a)
          :else (throw (IllegalArgumentException. "The values should have different signs.")))))

;;; Eg. fniding the root of x^3 - 2x - 3 = 0
;; (half-interval-method #(- (* % % %) (* 2 %) 3) 1.0 2.0)