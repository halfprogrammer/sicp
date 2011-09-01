(ns ch2.ex_2_28)

(defn fringe [tree]
  (if-not (coll? tree)
    [tree]
    (mapcat fringe tree)))