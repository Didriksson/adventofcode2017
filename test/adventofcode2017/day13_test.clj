(ns adventofcode2017.day13_test
  (:require [clojure.test :refer :all]
  [adventofcode2017.day13 :refer :all]))
  
  (def initialState (parseInput ["0: 3" "1: 2" "4: 4" "6: 4"]))
  
  (deftest parseInputTest
    (testing "parse input"
      (is (= initialState [{:depth 0 , :range 3 :position 0 :direction :down} 
                           {:depth 1 , :range 2 :position 0 :direction :down}
                           {:depth 4 , :range 4 :position 0 :direction :down}
                           {:depth 6 , :range 4 :position 0 :direction :down}
                          ]
          ))
    )
  )

  (deftest picoSecond2
    (testing "Testing first tick"
      (is (= (updateAllScanners initialState) 
                [{:depth 0 , :range 3 :position 1 :direction :down} 
                {:depth 1 , :range 2 :position 1 :direction :down}
                {:depth 4 , :range 4 :position 1 :direction :down}
                {:depth 6 , :range 4 :position 1 :direction :down}]
          ))  
    )  
  )

  (deftest picoSecond3
    (testing "Testing third tick"
      (is (= (updateAllScanners (updateAllScanners initialState)) 
                [{:depth 0 , :range 3 :position 2 :direction :down} 
                {:depth 1 , :range 2 :position 0 :direction :up}
                {:depth 4 , :range 4 :position 2 :direction :down}
                {:depth 6 , :range 4 :position 2 :direction :down}]
          ))  
    )  
  )

  (deftest picoSecond4
    (testing "Testing forth tick"
      (is (= (updateAllScanners (updateAllScanners (updateAllScanners initialState)))
                [{:depth 0 , :range 3 :position 1 :direction :up}
                {:depth 1 , :range 2 :position 1 :direction :down}
                {:depth 4 , :range 4 :position 3 :direction :down}
                {:depth 6 , :range 4 :position 3 :direction :down}]
          ))  
    )  
  )

  (deftest testSeverityShouldIncrease
    (testing "Since scanner is present should get severity penalty"
      (is (= (get (second (updatePacketSeverity {:position 4 :severity 2} initialState)) :severity) 18))  
    )
  )
  
  (deftest testSeverityShouldIncrease
    (testing "Perform trip without delay with example input"
      (is (= (get (performTripNoDelay {:position 0 :severity 0} initialState) :severity) 24))   
    )
  )

  (deftest testWithDelay
    (testing "Perform trip with delay example input"
      (is (= (tryDelayTrips initialState 0) 10)) 
    )
  )