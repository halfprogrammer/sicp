(ns ch2.rat_operations
  (:use ch2.rational_numbers))

(defn add-rat [x y]
  (make-rat (+ (* (nr x) (dr y))
               (* (nr y) (dr x)))
            (* (dr x) (dr y))))

(defn sub-rat [x y]
  (make-rat (- (* (nr x) (dr y))
               (* (nr y) (dr x)))
            (* (dr x) (dr y))))

(defn mul-rat [x y]
  (make-rat (* (nr x) (nr y))
            (* (dr x) (dr y))))

(defn div-rat [x y]
  (make-rat (* (nr x) (dr y))
            (* (dr x) (nr y))))

(defn equal-rat? [x y]
  (= (* (nr x) (dr y))
     (* (nr y) (dr x))))

