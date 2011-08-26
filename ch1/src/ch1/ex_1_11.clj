(ns ch1.ch1-1-11)

;;; f(n) = n  if n < 3
;;; f(n) = f(n-1) + 2 f(n -2) + 3 f(n-3) otherwise

(defn func [n]
  (if (< n 3)
    n
    (+ (func (dec n))
       (* 2 (func (- n 2)))
       (* 3 (func (- n 3))))))

(defn func-iter
  ([n arr cur]
     (cond (> cur n) (last arr)
           (< cur 3) (recur n (conj arr cur) (inc cur))
           :else (recur n
                        (conj arr
                              (+ (nth arr (- cur 1))
                                 (* 2 (nth arr (- cur 2)))
                                 (* 3(nth arr (- cur 3)))))
                        (inc cur))))
  ([n] (func-iter n [] 0)))


