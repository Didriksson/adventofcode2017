(ns adventofcode2017.day14_test
(:require [clojure.test :refer :all]
[adventofcode2017.day14 :refer :all]))

; (testing "testing settings regions all the same"
;     (is (= (checkThyNeighbours [
;         ["E" "U" "U"]
;         ["U" "U" "U"]
;         ["U" "U" "U"]
;         ]) 
;         [
;             ["E" "01" "01"]
;             ["01" "01" "01"]
;             ["01" "01" "01"]
;         ]        
;         )
;     )    
; )

; (testing "testing settings regions all empty"
;     (is (= (checkThyNeighbours [
;         ["E" "E" "E"]
;         ["E" "E" "E"]
;         ["E" "E" "E"]
;         ]) 
;         [
;         ["E" "E" "E"]
;         ["E" "E" "E"]
;         ["E" "E" "E"]
;         ]        
;         )
;     )    
; )

; (testing "testing settings regions isolated"
;     (is (= (checkThyNeighbours [
;             ["U" "E" "U"]
;             ["E" "U" "E"]
;             ["U" "E" "U"]
;         ]) 
;         [
;             ["00" "E" "02"]
;             ["E" "11" "E"]
;             ["20" "E" "22"]
;         ]        
;         )
;     )    
; )

; (testing "testing crocked T shape"
;     (is (= (checkThyNeighbours [
;             ["U" "U" "U"]
;             ["E" "U" "E"]
;             ["U" "E" "U"]
;         ]) 
;         [
;             ["00" "00" "00"]
;             ["E" "00" "E"]
;             ["20" "E" "22"]
;         ]        
;         )
;     )    
; )

; (testing "testing crocked T shape count"
;     (is (= (getNumberOfNeightbourgroups [
;             ["U" "U" "U"]
;             ["E" "U" "E"]
;             ["U" "E" "U"]
;         ]) 
;         3
;         )
;     )    
; )


; (testing "testing full T"
;     (is (= (checkThyNeighbours [
;             ["U" "U" "U"]
;             ["E" "U" "E"]
;             ["U" "U" "U"]
;         ]) 
;         [
;             ["00" "00" "00"]
;             ["E" "00" "E"]
;             ["00" "00" "00"]
;         ]        
;         )
;     )    
; )

; (testing "testing reverse T"
;     (is (= (checkThyNeighbours [
;             ["E" "E" "E"]
;             ["E" "U" "E"]
;             ["E" "U" "E"]
;         ]) 
;         [
;             ["E" "E" "E"]
;             ["E" "11" "E"]
;             ["E" "11" "E"]
;         ]        
;         )
;     )    
; )

; (testing "testing snaking around"
;     (is (= (checkThyNeighbours [
;         ["E" "E" "E" "U"]
;         ["E" "U" "E" "U"]
;         ["E" "U" "U" "U"]
;         ]) 
;         [
;             ["E" "E" "E" "03"]
;             ["E" "03" "E" "03"]
;             ["E" "03" "03" "03"]
;         ]        
;         )
;     )    
; )



; (testing "testing full T Count"
;     (is (= (getNumberOfNeightbourgroups [
;             ["U" "U" "U"]
;             ["E" "U" "E"]
;             ["U" "U" "U"]
;         ]) 
;         1
;         )
;     )    
; )