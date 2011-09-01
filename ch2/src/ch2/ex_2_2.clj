(ns ch2.ex_2_2)

;;; Definition of Point

(defrecord Point [x y])

(defn make-point [x y]
  (Point. x y))

(defn x [^Point p]
  (:x p))

(defn y [^Point p]
  (:y p))

;; (defn print-point [^Point p]
;;   (print "(" (x p) ", " (y p) ")"))

(defn make-point-str [^Point p]
  (print-str "(" (x p) "," (y p) ")"))

(defn print-point [^Point p]
  (print (make-point-str p)))

;;; Definition of Segment

(defrecord Segment [^Point start-segment ^Point end-segment])

(defn make-segment [^Point start-segment ^Point end-segment]
  (Segment. start-segment end-segment))

(defn start-segment [^Segment s]
  (:start-segment s))

(defn end-segment [^Segment s]
  (:end-segment s))

;;; Libraries based on Segment abstraction
(defn average [a b]
  (/ (+ a b) 2))

(defn make-segment-str [^Segment s]
  (print-str "[" (make-point-str (start-segment s)) ", "
             (make-point-str (end-segment s)) "]"))

(defn print-segment [^Segment s]
  (print (make-segment-str s)))

(defn midpoint-segment [^Segment s]
  (make-point (average (x (start-segment s)) (x (end-segment s)))
              (average (y (start-segment s)) (y (end-segment s)))))


(let [p1 (make-point 1 1)
      p2 (make-point 9 9)
      seg (make-segment p1 p2)]
 (midpoint-segment seg))