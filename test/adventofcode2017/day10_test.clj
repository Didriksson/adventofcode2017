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

  (deftest toAsciiCode
    (testing "Testing convert strings to ascii values"
      (is (= (first (toAscii "1")) 49))
    )  
  )

  (deftest testConvertAndAppendPart2Input
    (testing "Testing the convertion and appending of the knot hash for part 2"
      (is (= (convertAndAppendPart2Input "1,2,3") [49,44,50,44,51,17,31,73,47,23]))  
    )
  )

  (deftest performXorBlocksOf16
    (testing "XOR of doom"
      (is (= (denseHash [65 27 9 1 4 3 40 50 91 7 6 0 2 5 68 22]) '(64)))  
    )  
  )

  (deftest performDenseHashEmpty
    (testing "The empty string"
      (is (= (getHash "") "a2582a3a0e66e6e86e3812dcb672a272"))
    )  
  )
  
  (deftest performDenseHashEmpty
    (testing "AoC 2017"
      (is (= (getHash "AoC 2017") "33efeb34ea91902bb2f59c9920caa6cd"))  
    )  
  )
  