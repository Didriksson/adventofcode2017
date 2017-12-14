(ns adventofcode2017.day11_test
  (:require [clojure.test :refer :all]
  [adventofcode2017.day11 :refer :all]))
  
  (deftest example1
    (testing "First example"
      (is (= (second (getSteps ["ne" "ne" "ne"])) 3))
    )
  )

  (deftest example2
    (testing "Second example.."
      (is (= (second (getSteps ["ne"  "ne" "sw" "sw"])) 0))  
    )  
  )

  (deftest example3
    (testing "Third example.."
      (is (= (second (getSteps ["ne" "ne" "s" "s"])) 2))  
    )  
  )

  (deftest example4
    (testing "Third example.."
      (is (= (second (getSteps ["se" "sw" "se" "sw" "sw"])) 3))  
    )  
  )
