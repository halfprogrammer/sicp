(ns ch1.ex_1_35
  (:use ch1.fixed_point))

(def golden-ratio (fixed-point #(average % (inc (/ 1 %))) close-enough? 1.0))