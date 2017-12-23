(ns adventofcode2017.day16_test
(:require [clojure.test :refer :all]
[adventofcode2017.day16 :refer :all]))

(testing "Testing spin!"
    (is (= (spin ["a" "b" "c" "d" "e"] 1) ["e""a" "b" "c" "d"]))    
)

(testing "Testing exchange!"
    (is (= (exchange ["e""a" "b" "c" "d"] 3 4) ["e""a" "b" "d" "c"]))    
)

(testing "Testing partner!"
    (is (= (partner ["e""a" "b" "d" "c"] "e" "b") ["b" "a" "e" "d" "c"]))    
)
