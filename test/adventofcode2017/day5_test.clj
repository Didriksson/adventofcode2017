(ns adventofcode2017.day5_test
  (:require [clojure.test :refer :all]
            [adventofcode2017.day5 :refer :all]))

;"(0) 3  0  1  -3  - before we have taken any steps."
(deftest example1
  (testing "(1) 3  0  1  -3  - jump with offset 0 (that is, don't jump at all). Fortunately, the instruction is then incremented to 1."
    (is (= (doStepInList normalIncrease 0 [0 3 0 1 -3]) [0 [1 3 0 1 -3]]))
  )
)

(deftest example2
  (testing " 2 (3) 0  1  -3  - step forward because of the instruction we just modified. The first instruction is incremented again, now to 2."
    (is (= (doStepInList normalIncrease 0 [1 3 0 1 -3]) [1 [2 3 0 1 -3]]))
  )
)

(deftest example3
  (testing " 2  4  0  1 (-3) - jump all the way to the end; leave a 4 behind."
    (is (= (doStepInList normalIncrease 1 [2 3 0 1 -3]) [4 [2 4 0 1 -3]]))
  )
)

(deftest example4
  (testing "2 (4) 0  1  -2  - go back to where we just were; increment -3 to -2."
    (is (= (doStepInList normalIncrease 4 [2 4 0 1 -3]) [1 [2 4 0 1 -2]]))
  )
)

(deftest example5
  (testing " 2  5  0  1  -2  - jump 4 steps forward, escaping the maze."
    (is (= (doStepInList normalIncrease 1 [2 4 0 1 -2]) [5 [2 5 0 1 -2]]))
  )
)

(deftest doEverything
  (testing "Same input but in sequence should produce number of steps 5"
    (is (= (getMeOutProblem1 [0 3 0 1 -3]) 5))
    )
)

(deftest doEverythingProblem2
  (testing "Same input problem 2 with new complex complex algoritm 10 steps."
    (is (= (getMeOutProblem2 [0 3 0 1 -3]) 10))
  )
)
