(ns ch2.interval)

;;; Interval definition

(defn average [a b]
  (/ (+ a b) 2))

(defrecord Interval [lower-bound upper-bound])

(defn make-interval [lower-bound upper-bound]
  (Interval. lower-bound upper-bound))

(defn lower-bound [^Interval i]
  (:lower-bound i))

(defn upper-bound [^Interval i]
  (:upper-bound i))

;;; Interval arithmetic

(defn add-interval [^Interval a ^Interval b]
  (make-interval (+ (lower-bound a) (lower-bound b))
                 (+ (upper-bound a) (upper-bound b))))

(defn sub-interval [^Interval a ^Interval b]
    (make-interval (- (lower-bound a) (lower-bound b))
                   (- (upper-bound a) (upper-bound b))))

(defn mul-interval [^Interval a ^Interval b]
  (let [p1 (* (lower-bound a) (lower-bound b))
        p2 (* (lower-bound a) (upper-bound b))
        p3 (* (upper-bound a) (lower-bound b))
        p4 (* (upper-bound a) (upper-bound b))]
    (make-interval (min p1 p2 p3 p4) (max p1 p2 p3 p4))))

(defn div-interval [x y]
  (mul-interval x
                (make-interval (/ 1.0 (upper-bound y))
                               (/ 1.0 (lower-bound y)))))

