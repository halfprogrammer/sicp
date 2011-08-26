(ns ch1.ex_1_31)

(defn prod [term a nxt b]
  (if (> a b)
    1
    (* (term a) (prod term (nxt a) nxt b))))

(defn prod-iter [term a nxt b]
  (letfn [(iterative [a acc]
            (if (> a b)
              acc
              (recur (nxt a)
                     (* acc (term a)))))]
    (iterative a 1)))

;;; pi/4 = 2/3 * 4/3 * 4/5 * 6/5 * 6/7 * 8/7

(def add-1 (partial + 1))
(def add-2 (partial + 2))
(defn square [x] (* x x))

(def pi-by-4
  (letfn [(term [n]
            (/ (* n (add-2 n))
               (square (add-1 n))))]
   (prod term
         2
         #(+ % 2)
         100)))

