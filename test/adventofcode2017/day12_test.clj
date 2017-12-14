(ns adventofcode2017.day12_test
  (:require [clojure.test :refer :all]
  [adventofcode2017.day12 :refer :all]))
  
  (deftest parseEdgesTest
    (testing "parse edge"
      (is (= (parseEdge "0 <-> 2, 5") '( [0 2] [0 5] ) ) )
    )
  )

  (deftest testingGetProgramsInGroup
    (testing "create graph and count"
      (is (= (getProgramsInGroup ["0 <-> 2" "1 <-> 1" "2 <-> 0, 3, 4" "3 <-> 2, 4" "4 <-> 2, 3, 6" "5 <-> 6" "6 <-> 4, 5"] 0) 6 ))
    )  
  )
    