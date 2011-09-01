(ns ch2.eight_queen)

(defn difference [a b]
  (Math/abs (- a b)))

(defn last-safe? [board]
  (let [cur-row (dec (count board))
        cur-col (last board)]
    (not-any? (fn [[other-row other-col]]
                (or (= cur-col other-col)
                    (= (difference cur-row other-row)
                       (difference cur-col other-col))))
              (map vector (iterate inc 0) (butlast board)))))

(defn find-queens [board-size]
  (reduce (fn [safe-boards row]
            (mapcat (fn [safe-board]
                   (filter last-safe? (map #(conj safe-board %) (range board-size))))
                 safe-boards))
          (map vector (range board-size))
          (range 1 board-size)))