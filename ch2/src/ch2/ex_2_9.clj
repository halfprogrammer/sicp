(ns ch2.ex2_9
  (:use ch2.interval))

(defn width [^Interval i]
  (average (lower-bound i) (upper-bound i)))