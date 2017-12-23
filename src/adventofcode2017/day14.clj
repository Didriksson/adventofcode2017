(ns adventofcode2017.day14
  (:require [clojure.math.numeric-tower :as math]))
(require '[clojure.string :as str])
(require 'clojure.set)   
(require '[adventofcode2017.utils :as utils])
(require '[adventofcode2017.day10 :as day10])

(defn fromHex [hexchar]
  (str/replace 
    (format "%4s" 
      (Integer/toBinaryString (Integer/parseInt (str hexchar) 16))) 
  #" " "0")  
)

(defn getRows [input size]
 (map #(str input"-"%) (range size))
)

(defn rowToHex [row]
  (str/join (flatten (map fromHex row)))
)

(defn getBinaryString [input size]
  (map #(day10/getHash %) (getRows input size))
)

(defn getDefragItem [char]
  (if (= char \1)
    "U"
    "E"
  )
)

(defn getDefragRow [rowString] 
  (into [] (map getDefragItem rowString))
)

(defn create2DArray [input size]
  (into [] (map getDefragRow (map rowToHex (getBinaryString input size))))  
)

(defn updateGroup [data nodepos value]
  (println "Updating " nodepos " with " value ". Previous value: " (get-in data nodepos))
  (assoc-in data nodepos (assoc (get data nodepos) :group value))
)

(defn findUnsetNodes [data]
  (into #{} (for [[x row] (map-indexed vector data) 
    [y val] (map-indexed vector row)
    :when (= "U" val) ]
    [x y]
  ))  
)

(defn distanceOneAway [n1 potentialNodes]
  (filter #(= 1 (+ (math/abs (- (first n1) (first %))) (math/abs (- (second n1) (second %))))) potentialNodes)
)

(defn getSnakingGroups [unsetNodes]
  (loop [potentialNodes unsetNodes foundnodes (cons (first unsetNodes) #{})]
    (let [matchingNodes (distinct (apply concat (map #(distanceOneAway % potentialNodes) foundnodes)))]
      (if (or (empty? matchingNodes) (empty? potentialNodes))
        foundnodes
        (recur (clojure.set/difference potentialNodes matchingNodes) (concat matchingNodes foundnodes))
;        (recur (rest potentialNodes) (distinct (concat foundnodes (mapcat #(distanceOneAway % (rest potentialNodes)) (cons (first potentialNodes) foundnodes)))))
      )
    )
  )
)

(defn setNode [data nodepos value]
  (assoc-in data nodepos value)
)

(defn setAllNodesToValue [data nodes value]
  (loop [state data nodestoset nodes]
    (if (empty? nodestoset)
      state
      (recur (setNode state (first nodestoset) value) (rest nodestoset))
    )
  )
)

(defn findAndSetNodeAndRelatedNodes [data]
  (loop [unset (findUnsetNodes data) state data]
    (if (empty? unset)
      state
      (let [newState (setAllNodesToValue state (getSnakingGroups unset) 
                                                      (str/join (first unset)))]
        (recur (findUnsetNodes newState) newState)
      )
    )
  )
)  

(defn checkThyNeighbours [data]
  (findAndSetNodeAndRelatedNodes data)      
)

(defn solvepuzzle []
  (println "Answer puzzle 1: "
    (count (re-seq #"1" (str/join (map rowToHex (getBinaryString "hwlqcszp" 128)))))
  )
)