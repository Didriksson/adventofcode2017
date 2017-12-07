(ns adventofcode2017.day6_test
  (:require [clojure.test :refer :all]
            [adventofcode2017.day6 :refer :all]))

;"(0) 3  0  1  -3  - before we have taken any steps."
(deftest example1
  (testing "Starting with the next bank (the fourth bank) and then continuing to the first bank, the second bank, and so on, the 7 blocks are spread out over the memory banks. The fourth, first, and second banks get two blocks each, and the third bank gets one back. The final result looks like this: 2 4 1 2."
    (is (= (distributeOnce [ 0 2 7 0]) [2 4 1 2]))
  )
)

;"(0) 3  0  1  -3  - before we have taken any steps."
(deftest example2
  (testing "Same input should take 5 cycles until repeated."
    (is (= (distributeUntilRepeated [ 0 2 7 0]) 5))
  )
)

;"(0) 3  0  1  -3  - before we have taken any steps."
(deftest example2
  (testing "Same input should take 5 cycles until repeated."
    (is (= (first (distributeUntilRepeated [ 2 4 1 2 ])) 4))
  )
)