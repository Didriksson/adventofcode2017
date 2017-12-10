(ns adventofcode2017.day7_test
  (:require [clojure.test :refer :all]
            [adventofcode2017.day7 :refer :all]))


; pbga (66)
; xhth (57)
; ebii (61)
; havc (66)
; ktlj (57)
; fwft (72) -> ktlj, cntj, xhth
; qoyq (66)
; padx (45) -> pbga, havc, qoyq
; tknk (41) -> ugml, padx, fwft
; jptl (61)
; ugml (68) -> gyxo, ebii, jptl
; gyxo (61)
; cntj (57)

(deftest example1
  (testing "In this example, tknk is at the bottom of the tower (the bottom program). 
    And is holding up ugml, padx, and fwft."
    (is (= (getBottomProgram "7_test") "tknk" ))
  )
)

