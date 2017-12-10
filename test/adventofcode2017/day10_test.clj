(ns adventofcode2017.day10_test
  (:require [clojure.test :refer :all]
  [adventofcode2017.day10 :refer :all]))
  
  (deftest example1
    (testing "First example"
      (is (= (performOneRound [0 1 2 3 4] 0 0 3) [2 1 0 3 4] ) )
    )
  )
    
  (deftest example2
    (testing "Second example"
      (is (= (performOneRound [2 1 0 3 4] 3 1 4) [4 3 0 1 2] ) )
    )
  )

  (deftest example3
    (testing "Third example"
      (is (= (performOneRound [4 3 0 1 2] 1 2 1) [4 3 0 1 2] ) )
    )
  )

  (deftest example4
    (testing "Fourth example"
      (is (= (performOneRound [4 3 0 1 2] 1 2 5) [3 4 2 1 0] ) )
    )
  )  

  (deftest revertAndOffset
    (testing "Testing revert and offset"
      (is (= (revertOffset (offsetPosition [1 2 3 4 5 6] 2) 2) [1 2 3 4 5 6] ) )
    )
  )

  
  
  