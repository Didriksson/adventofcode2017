(ns adventofcode2017.day4_test
  (:require [clojure.test :refer :all]
            [adventofcode2017.day4 :refer :all]))


(deftest example1
  (testing "aa bb cc dd ee is valid"
    (is (= (noDuplicates? "aa bb cc dd ee") true))
  )
)

(deftest example2
  (testing "aa bb cc dd aa is not valid - the word aa appears more than once."
    (is (= (noDuplicates? "aa bb cc dd aa") false))
  )
)

(deftest example3
  (testing "aa bb cc dd aaa is valid - aa and aaa count as different words."
    (is (= (noDuplicates? "aa bb cc dd aaa") true))
  )
)

(deftest example1_part2
  (testing "abcde fghij is a valid passphrase."    
    (is (= (noAnagrams? "abcde fghij") true))
  )
)

(deftest example2_part2
  (testing "abcde xyz ecdab is not valid - the letters from the third word can be rearranged to form the first word."
    (is (= (noAnagrams? "abcde xyz ecdab") false))
  )
)

(deftest example3_part2
  (testing "iiii oiii ooii oooi oooo is valid."    
    (is (= (noAnagrams? "iiii oiii ooii oooi oooo") true))
  )
)

(deftest example4_part2
  (testing "oiii ioii iioi iiio is not valid - any of these words can be rearranged to form any other word."
    (is (= (noAnagrams? "oiii ioii iioi iiio") false))
  )
)

