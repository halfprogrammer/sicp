(ns ch1.exponentiation)

(defn pow
  ([b e acc]
     (if (<= e 0) acc (recur b (dec e) (* acc b))))
  ([b e]
     (pow b e 1)))


(defn pow-b [b e]
  (if (<= e 0)
    1
    (* b (pow-b b (dec e)))))


(defn square [x] (* x x))


(defn fast-pow
  [b e]
  (cond (zero? e) 1
        (even? e) (square (fast-pow b (/ e 2)))
        :else (* b (fast-pow b (dec e)))))

