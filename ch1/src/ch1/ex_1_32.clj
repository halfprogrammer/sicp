(ns ch1.ex_1_32)

(defn accumulate-recur [combiner null-val term a nxt b]
  (if (> a b)
    null-val
    (combiner (term a)
              (accumulate-recur combiner
                                null-val
                                term
                                (nxt a)
                                nxt
                                b))))

(defn sum-numbers [a b] (accumulate-recur + 0 identity a inc b))

(defn accumulate-iter [combiner null-val term a nxt b]
  (letfn [(iteration [a acc]
            (if (> a b)
              acc
              (recur (nxt a)
                     (combiner (term a)
                               acc))))]
    (iteration a null-val)))

(defn sum-numbers [a b] (accumulate-iter + 0 identity a inc b))

