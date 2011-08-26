(ns ch1.root)

(defn average [& rest]
  (/ (apply + rest) (count rest)))

(defn square [x] (* x x))

(defn cube [x] (* x x x))

(defn sqrt-iter
  ([guess x]
     (letfn [(good-enough? []
               (< (Math/abs (- (square guess) x)) 0.001))
             (improve [] (average guess (/ (double x) guess)))]
       (if (good-enough?)
         guess
         (recur (improve) x))))
  ([x] (sqrt-iter 1 x)))


(defn sqrt-iter-improved
  ([past-guess guess x]
     (letfn [(good-enough? []
               (and (< (Math/abs (- (square guess) x)) 0.001)
                    (< (/ (Math/abs (- guess past-guess))
                          guess)
                       0.0001)))

             (improve []
               (average guess (/ (double x) guess)))]
       (if (good-enough?)
         guess
         (recur guess (improve) x))))
  ([x] (sqrt-iter-improved 1.0 1.0 x)))


(defn cube-root
  ([guess x]
     (letfn [(good-enough? []
               (< (Math/abs (- (cube guess) x)) 0.001))
             
             (improve []
               (/ (+ (/ x (square guess)) (* 2 guess))
                  3.0))]
       
       (if (good-enough?)
         guess
         (recur (improve) x))))
  ([x] (cube-root 1.0 x)))

;;; Generic routine
(defn find-root [prev-guess is-good-enough? improve]
  (let [guess (improve prev-guess)]
    (if (is-good-enough? prev-guess guess)
      guess
      (recur guess is-good-enough? improve))))

(defn find-cube-root [x]
  (letfn [(is-good-enough? [prev-guess guess]
            (< (Math/abs (- (cube guess) x)) 0.001))
          (improve [guess]
               (/ (+ (/ x (square guess)) (* 2 guess))
                  3.0))]
    (find-root 1 is-good-enough? improve)))


(defn find-square-root [x]
  (letfn [(good-enough? [prev-guess guess]
            (< (Math/abs (- (square guess) x)) 0.001))
          (improve [guess] (average guess (/ (double x) guess)))]
    (find-root 1 good-enough? improve)))