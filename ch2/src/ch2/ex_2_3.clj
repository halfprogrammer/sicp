(ns ch2.ex_2_3
  (:use ch2.ex_2_2))

(defrecord Rectangle [diagonal])

(defn make-rectangle
  ([s] (Rectangle. s))
  ([p1 p2] (make-rectangle (make-segment p1 p2))))

(defn make-rectangle-str [^Rectangle r]
  (print-str "Diagonal:" (make-segment-str (:diagonal r))))

(defn print-rectangle [^Rectangle r]
  (print (make-rectangle-str r)))

