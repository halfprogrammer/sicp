(ns ch1.ex_1_33)

(defn filtered-accumulate-recur [filter combiner null-val term a nxt b]
  (if (> a b)
    null-val
    (let [rest-val (filtered-accumulate-recur filter
                                              combiner
                                              null-val
                                              term
                                              (nxt a)
                                              nxt
                                              b)]
      (if (filter a)
        (combiner (term a) rest-val)
        rest-val))))

(defn filtered-accumulate-iter [filter combiner null-val term a nxt b]
  (letfn [(iterate [a acc]
            (cond (> a b) acc
                  (filter a) (recur (nxt a) (combiner (term a) acc))
                  :else (recur (nxt a) acc)))]
    (iterate a null-val)))

