(ns ch2.ex_2_37)

(defn dot-product [a b]
  (apply + (map * a b)))

(defn matrix-*-vector [m v]
  (map (fn [row]
         (dot-product row v))
       m))

(defn matrix-transpose [m]
  (apply map vector m))

(defn matrix-*-matrix [m1 m2]
  (let [m2 (matrix-transpose m2)]
    (map (fn [r1]
           (matrix-*-vector m2 r1))
         m1)))


(matrix-*-matrix [[ 0  4 -2]
                  [-4 -3  0]]
                 [[0  1]
                  [1 -1]
                  [2  3]])