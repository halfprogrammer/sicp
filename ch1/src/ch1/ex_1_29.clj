(ns ch1.ex_1_29)

;;; Simpson's rule for integration
;;; h/3 [y0 + 4y1 + 2y2 + 4y3 + 2y4 + ... + 2y(n-2) + 4y(n-1) + yn]
;;; h = (b - a)/n
;;; yk = f(a + kh)

(defn simpson-integral [func a b n]
  (let [h (/ (- b a) n)]
    (* (/ h 3)
       (+ 
        (summation #(* 4 (func %))
                   (+ a h)
                   #(+ % h h)
                   (- b h))
        (summation #(* 2 (func %))
                   (+ a h h)
                   #(+ % h h)
                   (- b h))
        (func a)
        (func (+ a (* n h)))))))
