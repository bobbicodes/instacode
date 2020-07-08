(ns instacode.poly-test
  (:require [clojure.test :refer :all]
            [instacode.poly :refer :all]))

(deftest mult-binomial-poly-test
    (is (= [2 15 19 6] (mult-binomial-poly [1 7 6] [2 1]))))
