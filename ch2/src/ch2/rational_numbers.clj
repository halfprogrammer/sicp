(ns ch2.rational_numbers)

(defn gcd [a b]
  (if (zero?  b)
    a
    (recur b (mod a b))))

(defrecord Rat [nr dr])

(defn nr [^Rat r]
  (:nr r))

(defn dr [^Rat r]
  (:dr r))

(defn make-rat [nr dr]
  (let [g (gcd nr dr)
        nr (/ nr g)
        dr (/ dr g)]
   (Rat. nr dr)))

(defn print-rat [^Rat r]
  (println (nr r) "/" (dr r)))

