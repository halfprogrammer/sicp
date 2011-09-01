(ns ch2.ex_2_5)

(defn my-cons [a b]
  (int (* (Math/pow 2 a) (Math/pow 3 b))))

(defn factor-out [num fac]
  (if (zero? (mod num fac))
    (recur (/ num fac) fac)
    num))

(defn my-car [c]
  (let [mul-2 (factor-out (int c) 3)]
    (ffirst (drop-while (fn [[idx pow]]
                         (< pow mul-2))
                       (map list
                            (iterate inc 0)
                            (iterate #(* % 2) 1))))))

(defn my-cdr [c]
  (let [mul-3 (factor-out (int c) 2)]
    (ffirst (drop-while (fn [[idx pow]]
                         (< pow mul-3))
                       (map list
                            (iterate inc 0)
                            (iterate #(* % 3) 1))))))


