(ns adventofcode2017.day11
  (:require [clojure.math.numeric-tower :as math]))  
(require '[clojure.string :as str])
(require '[adventofcode2017.utils :as utils])

(defn getDistance [x y z]
  (/
    (+
      (math/abs x)
      (math/abs y)
      (math/abs z)
    )
    2
  )  
)

(defn moveAllSteps [previousDistance steps x y z]
  (let [maxDistance (max (getDistance x y z) previousDistance)]
    (if (empty? steps)
      [maxDistance x y z]
      (condp = (first steps)
        "n"   (recur maxDistance (rest steps) x (inc y) (dec z))
        "ne"  (recur maxDistance (rest steps) (inc x) y (dec z))
        "se"  (recur maxDistance (rest steps) (inc x) (dec y) z)
        "s"   (recur maxDistance (rest steps) x (dec y) (inc z))
        "sw"  (recur maxDistance (rest steps) (dec x) y (inc z))
        "nw"  (recur maxDistance (rest steps) (dec x) (inc y) z)
        "Unexpected value "
      )
    )
  )
)

(defn getSteps [input]
  (let [[maxdistance x y z] (moveAllSteps 0 input 0 0 0)]
    [maxdistance (getDistance x y z)]
  )    
)


(defn solvepuzzle []
  (println "Puzzle answer 1: " (second (getSteps (str/split (first (utils/readfileByLines 11)) #","))))
  (println "Puzzle answer 2: " (first (getSteps (str/split (first (utils/readfileByLines 11)) #","))))
)
