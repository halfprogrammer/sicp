(ns ch2.ex_2_12
  (:use ch2.interval))

(defn make-center-width [c w]
  (make-interval (- c w) (+ c w)))

(defn center [^Interval i]
  (average (lower-bound i) (upper-bound i)))

(defn width [^Interval i]
  (/ (- (upper-bound i) (lower-bound i)) 2))


(defn make-center-percent [c p]
  (let [width (/ (* c p) 100)]
    (make-interval (- c width) (+ c width))))

(defn width-percent [^Interval i]
  (/ (* 100 (width i)) (center i)))
