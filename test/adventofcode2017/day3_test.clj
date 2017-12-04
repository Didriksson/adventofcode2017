(ns adventofcode2017.day3_test
  (:require [clojure.test :refer :all]
            [adventofcode2017.day3 :refer :all]))


(deftest createboard
  (testing "Should give a matrix with 17 at edge for 5x5"
    (is (= (aget (fillBoard (createMatrix 5)) 0 0) 17))
  )
)

(deftest example1
  (testing "Data from square 1 is carried 0 steps, since it's at the access port."
    (is (= (getNumberofSteps 1) 0))
  )
)

(deftest example2
  (testing "Data from square 12 is carried 3 steps, such as: down, left, left."
    (is (= (getNumberofSteps 12) 3))
  )
)

(deftest example3
  (testing "Data from square 23 is carried only 2 steps: up twice."
    (is (= (getNumberofSteps 23) 2))
  )
)

(deftest example4
  (testing "Data from square 1024 must be carried 31 steps."
    (is (= (getNumberofSteps 1024) 31))
  )
)

(deftest example1_2ndproblem
  (testing "Square 1 starts with the value 1"
    (
      is (= (aget (first (fillFromAdjacentCells (createMatrix 5) 5)) 1))
    )
  )
)

(deftest example2_2ndproblem
  (testing "Square 2 has only one adjacent filled square (with value 1), so it also stores 1."
    (is (= (aget (first (fillFromAdjacentCells (createMatrix 5) 5)) 1))
    )
  )
)
(deftest example3_2ndproblem
  (testing "Square 3 has both of the above squares as neighbors and stores the sum of their values, 2."
    (is (= (aget (first (fillFromAdjacentCells (createMatrix 5) 5)) 3 1) 2))
  )
)

(deftest example4_2ndproblem
  (testing "Square 4 has all three of the aforementioned squares as neighbors and stores the sum of their values, 4"    
    (is (= (aget (first (fillFromAdjacentCells (createMatrix 5) 5)) 2 1) 4))
  )
)

(deftest example5_2ndproblem
  (testing "Square 5 only has the first and fourth squares as neighbors, so it gets the value 5."    
    (is (= (aget (first (fillFromAdjacentCells (createMatrix 5) 5)) 1 1) 5))
  )
)

(deftest returns4WithInput3
  (testing "Should return first number exceeding input which is 4"
    (is (= (getValuelargerThanInput 3) 4))
  )
)