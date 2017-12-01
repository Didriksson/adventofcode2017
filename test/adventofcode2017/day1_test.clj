(ns adventofcode2017.day1_test
  (:require [clojure.test :refer :all]
            [adventofcode2017.day1 :refer :all]))

(deftest example1
  (testing "Test 1122 should produce 3"
    (is (=(start [1 1 2 2]) 3))))

(deftest example2
  (testing "Test 1111 should produce 4"
    (is (=(start [1 1 1 1]) 4))))

(deftest example3
  (testing "Test 1234 should produce 0"
    (is (=(start [1 2 3 4]) 0))))

(deftest example4
  (testing "Test 91212129 should produce 9"
    (is (=(start [9 1 2 1 2 1 2 9]) 9))))

(deftest example5
  (testing "Test 1212 should produce 6"
    (is (=(start2ndProblem [1 2 1 2]) 6))))


(deftest example6
  (testing "Test 1221 should produce 0"
    (is (=(start2ndProblem [1 2 2 1]) 0))))

(deftest example7
  (testing "Test 123425 should produce 4"
    (is (=(start2ndProblem [1 2 3 4 2 5]) 4))))

(deftest example8
  (testing "Test 123123 should produce 12"
    (is (=(start2ndProblem [1 2 3 1 2 3]) 12))))

(deftest example9
  (testing "Test 12131415 should produce 4"
    (is (=(start2ndProblem [1 2 1 3 1 4 1 5]) 4))))
                        