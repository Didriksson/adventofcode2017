(ns adventofcode2017.day8_test
  (:require [clojure.test :refer :all]
            [adventofcode2017.day8 :refer :all]))


(deftest example1
  (testing "Because a starts at 0, it is not greater than 1, and so b is not modified."
    (is (= (doStatement "b inc 5 if a > 1" {}) {} ) )
  )
)

(deftest example2
  (testing "a is increased by 1 (to 1) because b is less than 5 (it is 0)."
    (is (= (doStatement "a inc 1 if b < 5" {}) {"a" 1} ))
  )
)

(deftest example3
  (testing "c is decreased by -10 (to 10) because a is now greater than or equal to 1 (it is 1)."
    (is (= (doStatement "c dec -10 if a >= 1" {"a" 1}) {"a" 1 , "c" 10} ))
  )
)

(deftest example4
  (testing "c is increased by -20 (to -10) because c is equal to 10."
    (is (= (doStatement "c inc -20 if c == 10" {"a" 1 , "c" 10}) {"a" 1 , "c" -10} ))
  )
)


