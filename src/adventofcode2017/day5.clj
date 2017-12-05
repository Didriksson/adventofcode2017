(ns adventofcode2017.day5)
(require '[adventofcode2017.utils :as utils])
(require '[clojure.string :as str])

(defn doStepInList [increaseFunction pos list]
  [(+ pos (get list pos)) (assoc list pos (increaseFunction pos list))]  
)

(defn recursive_escape [increaseFunction pos list steps size]
  (if (>= pos size)
    steps
    (let [result (doStepInList increaseFunction pos list)]
      (recur increaseFunction (first result) (second result) (inc steps) size)))
)

(defn normalIncrease [pos list]
  (inc (get list pos))
)

(defn getMeOutProblem1 [list]
  (recursive_escape normalIncrease 0 list 0 (count list))
)
  
(defn complexIncrease [pos list]
  (let [offset (get list pos)]
    (if (>= offset 3)
      (dec offset) 
      (inc offset)
    )
  )
)

(defn getMeOutProblem2 [list]
  (recursive_escape complexIncrease 0 list 0 (count list))
)
    
(defn solvepuzzle []
  (let [input (utils/toInteger (utils/readfileByLines 5))]
    (println "Answer problem 1: " (getMeOutProblem1 input))
    (println "Answer problem 2: " (getMeOutProblem2 input))
  )
)