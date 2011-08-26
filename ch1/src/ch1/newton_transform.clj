(ns ch1.newton_transform
  (:use ch1.fixed_point))


(def dx 0.000001)


(defn derivative [f]
  (fn [x]
    (/ (- (f (+ x dx)) (f x))
       dx)))


(defn cube [x] (* x x x))


(defn newton-transform [g]
  (fn [x]
    (- x (/ (g x)
            ((derivative g) x)))))


(defn newtons-method [g guess]
  (fixed-point (newton-transform g)
               close-enough?
               guess))


(defn square [x] (* x x))


(defn sqrt-newton-method [x]
  (newtons-method (fn [y]
                    (- (square y) x))
                  1.0))


(defn fixed-point-of-transform [g transform guess]
  (fixed-point (transform g)
               close-enough?
               guess))


(defn average-damp [f]
  (fn [x]
    (average x (f x))))


(defn sqrt-fixed-point-of-transform [x]
  (fixed-point-of-transform (fn [y] (/ x y))
                            average-damp
                            1.0))


(defn sqrt-fixed-point-newton-transform [x]
  (fixed-point-of-transform (fn [y] (- (square y) x))
                            newton-transform
                            1.0))

