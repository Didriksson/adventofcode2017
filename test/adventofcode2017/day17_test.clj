(ns adventofcode2017.day17_test
(:require [clojure.test :refer :all]
[adventofcode2017.day17 :refer :all]))

(testing "Testing doStep!"
    (is (= (doStep [0] 3 0) [1 [0 1]]))    
    (is (= (doStep [0 1] 3 1) [1 [0 2 1]]))
    (is (= (doStep [0 2 1] 3 1) [2 [0 2 3 1]]))    
)

(testing "Do several steps"
    (is (= (doSeveralSteps 3 9) [1 [0 9 5  7  2  4  3  8  6  1]]))    
)


