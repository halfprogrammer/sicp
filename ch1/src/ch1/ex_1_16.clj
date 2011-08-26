(ns ch1.ch_1_16)

(defn pow
  ([b e acc cur]
     (cond (= cur e) acc
           (<= (* 2 cur) e) (recur b e (* acc acc) (* 2 cur))
           :else (* acc
                    (pow b (- e cur) b 1))))
  ([b e]
     (pow b e b 1)))


;;; Has a nice cache, but suffers from stack overflow
(defn pow-cache
  ([b e acc cur]
     (cond (= cur e) acc
           (<= (* 2 cur) e) (* (pow-cache b (- e (* 2 cur)))
                               acc
                               acc) 
           :else (* acc
                    (pow-cache b (- e cur)))))
  ([b e]
     (if (zero? e)
       1
       (pow-cache b e b 1))))

(def pow-cache (memoize pow-cache))