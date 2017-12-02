(ns adventofcode2017.day2_test
  (:require [clojure.test :refer :all]
            [adventofcode2017.day2 :refer :all]))

  ; Given spreadsheet:
  (def sheet [[5 1 9 5]
              [7 5 3]
              [2 4 6 8]])

(deftest example1
  (testing "The first row's largest and smallest values are 9 and 1, and their difference is 8."
    (is (=(checksumMinMax [5 1 9 5] ) 8)))
)

(deftest example2
  (testing "The second row's largest and smallest values are 7 and 3, and their difference is 4."
    (is (=(checksumMinMax [7 5 3] ) 4)))
)

(deftest example3
  (testing "The third row's difference is 6."
    (is (=(checksumMinMax [2 4 6 8]) 6)))
)

(deftest example4
  (testing "In this example, the spreadsheet's checksum would be 8 + 4 + 6 = 18"
    (is (=(checksumSpreadsheet sheet checksumMinMax) 18)))
)

(def sheet2ndproblem [[5 9 2 8]
                      [9 4 7 3]
                      [3 8 6 5]])

(deftest example1_2ndproblem
  (testing "In the first row, the only two numbers that evenly divide are 8 and 2; the result of this division is 4."
    (is (=(checksumEvenDivisable [5 9 2 8] ) 4)))
)

(deftest example2_2ndproblem
  (testing "In the second row, the two numbers are 9 and 3; the result is 3."
    (is (=(checksumEvenDivisable [9 4 7 3] ) 3)))
)

(deftest example3_2ndproblem
  (testing "In the third row, the result is 2."
    (is (=(checksumEvenDivisable [3 8 6 5]) 2)))
)
                      
