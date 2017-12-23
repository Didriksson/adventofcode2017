(ns adventofcode2017.day15_test
(:require [clojure.test :refer :all]
[adventofcode2017.day15 :refer :all]))

(testing "Testing generating first value"
    (is (= (generateValue 65 16807) 1092455))
    (is (= (generateValue 1092455 16807) 1181022009))
    (is (= (generateValue 1181022009 16807) 245556042))    
)

(testing "Count the mathing values"
    (is (= (generateAndCountValues 5 [65 8921]) 1)
    )    
)
