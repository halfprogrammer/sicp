(ns ch1.fixed_point)

(defn fixed-point [f close-enough? first-guess]
  (ffirst (drop-while (fn [pair]
                        (false? (close-enough? (first pair) (second pair))))
                      (partition 2 1 (iterate f first-guess)))))

(defn close-enough? [x y] (< (Math/abs (- x y)) 0.000001))

;; (fixed-point #(+ (Math/sin %) (Math/cos %)) close-enough? 1.0) ; => 1.2587287680106494


(defn fixed-point-classic [f first-guess]
  (letfn [(try-with [guess]
            (let [nxt-guess (f guess)]
              (if (close-enough? guess nxt-guess)
                nxt-guess
                (recur nxt-guess))))]
    (try-with first-guess)))


;;; Sometimes, solutions won't automatically converge to a value. Eg sqrt
;;; For these cases average damping is used
;;; Eg y^2 = x       =>    y = x/y
;;; For some guess y1---  y2 => x/y1
;;; Next iteration   ---  y1 => x/y2
;;; Average damping => (average y x/y)

(defn average [& rest]
  (/ (apply + rest) (count rest)))

(defn sqrt [x]
  (fixed-point (fn [y] (average y (/ x y)))
               close-enough?
               1.0))