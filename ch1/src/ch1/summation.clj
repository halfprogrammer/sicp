(ns ch1.summation)

(defn summation [term a nxt b]
  (if (> a b)
    0
    (+ (term a)
       (summation term (nxt a) nxt b))))

(defn linear-sum [a b]
  (summation identity a inc b))

(defn square-sum [a b]
  (summation #(* % %) a inc b))

;;; (1/1*3) + (1/5*7) + (1/9*11) + ..
(defn pi-sum [a b]
  (summation #(/ 1 (* % (+ % 2)))
             a
             #(+ % 4)
             b))

;;; Integration
;;; [f(a + dx/2) + f(a + dx/2 + dx) + f(a + dx/2 + 2dx) + ...]dx

(defn integral [func, a, b, dx]
  (* dx
     (summation func
                (+ a (/ dx 2))
                #(+ % dx)
                b)))

