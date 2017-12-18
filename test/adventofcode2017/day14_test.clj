(ns adventofcode2017.day14_test
(:require [clojure.test :refer :all]
[adventofcode2017.day14 :refer :all]))

(testing "testing settings regions all the same"
    (is (= (checkThyNeighbours [
        [{:status :empty, :group nil} {:status :used, :group "MITTEN"} {:status :used, :group "HÖGER"}]
        [{:status :used, :group nil} {:status :used, :group nil} {:status :used, :group nil}]]
        [{:status :used, :group nil} {:status :used, :group nil} {:status :used, :group nil}]
        ]) 
        [
            [{:status :used, :group "00"} {:status :used, :group "00"} {:status :used, :group "00"}]
            [{:status :used, :group "00"} {:status :used, :group "00"} {:status :used, :group "00"}]
            [{:status :used, :group "00"} {:status :used, :group "00"} {:status :used, :group "00"}]
        ]        
        )
    )    
)


(testing "testing settings regions all empty"
    (is (= (checkThyNeighbours [
        [{:status :empty, :group nil} {:status :empty, :group nil} {:status :empty, :group nil}]
        [{:status :empty, :group nil} {:status :empty, :group nil} {:status :empty, :group nil}]
        [{:status :empty, :group nil} {:status :empty, :group nil} {:status :empty, :group nil}]
        ]) 
        [
        [{:status :empty, :group nil} {:status :empty, :group nil} {:status :empty, :group nil}]
        [{:status :empty, :group nil} {:status :empty, :group nil} {:status :empty, :group nil}]
        [{:status :empty, :group nil} {:status :empty, :group nil} {:status :empty, :group nil}]
        ]        
        )
    )    
)

(testing "testing settings regions isolated"
    (is (= (checkThyNeighbours [
            [{:status :used, :group nil} {:status :empty, :group nil} {:status :used, :group nil}]
            [{:status :empty, :group nil} {:status :used, :group nil} {:status :empty, :group nil}]
            [{:status :used, :group nil} {:status :empty, :group nil} {:status :used, :group nil}]
        ]) 
        [
            [{:status :used, :group "00"} {:status :empty, :group nil} {:status :used, :group "02"}]
            [{:status :empty, :group nil} {:status :used, :group "11"} {:status :empty, :group nil}]
            [{:status :used, :group "20"} {:status :empty, :group nil} {:status :used, :group "22"}]
        ]        
        )
    )    
)

(testing "testing crocked T shape"
    (is (= (checkThyNeighbours [
            [{:status :used, :group nil} {:status :used, :group nil} {:status :used, :group nil}]
            [{:status :empty, :group nil} {:status :used, :group nil} {:status :empty, :group nil}]
            [{:status :used, :group nil} {:status :empty, :group nil} {:status :used, :group nil}]
        ]) 
        [
            [{:status :used, :group "00"} {:status :used, :group "00"} {:status :used, :group "00"}]
            [{:status :empty, :group nil} {:status :used, :group "00"} {:status :empty, :group nil}]
            [{:status :used, :group "20"} {:status :empty, :group nil} {:status :used, :group "22"}]
        ]        
        )
    )    
)

(testing "testing full T"
    (is (= (checkThyNeighbours [
            [{:status :used, :group nil} {:status :used, :group nil} {:status :used, :group nil}]
            [{:status :empty, :group nil} {:status :used, :group nil} {:status :empty, :group nil}]
            [{:status :used, :group nil} {:status :used, :group nil} {:status :used, :group nil}]
        ]) 
        [
            [{:status :used, :group "00"} {:status :used, :group "00"} {:status :used, :group "00"}]
            [{:status :empty, :group nil} {:status :used, :group "00"} {:status :empty, :group nil}]
            [{:status :used, :group "00"} {:status :used, :group "00"} {:status :used, :group "00"}]
        ]        
        )
    )    
)