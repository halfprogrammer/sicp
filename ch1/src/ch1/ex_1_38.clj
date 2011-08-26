(ns ch1.ex_1_38
  (:use ch1.ex_1_37))



;;; Euler finds in constant-fraction
;;; If nr = 1 and dr = 1, 2, 1, 1, 4, 1, 1, 6, 1, 1 ,8 etc
;;; then result is 'e - 2'

(const-frac-iter (constantly 1)
                 (fn [dr]
                   (if (zero? (mod (- dr 2) 3))
                     dr
                     1))
                 100)