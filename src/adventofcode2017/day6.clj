(ns adventofcode2017.day6)
(require '[adventofcode2017.utils :as utils])
(require '[clojure.string :as str])

(defn largestBlock [list]
  (.indexOf list (apply max list))  
)

(defn distributeValue [pool index list]
  (if (pos? pool)
    (recur (dec pool) (mod (inc index) (count list)) (assoc list index (inc (get list index))))
    list
  )  
)

(defn distributeOnce [list]
  (let [index (largestBlock list)] 
    (distributeValue (get list index) (mod (inc index) (count list)) (assoc list index 0))
  )
)

(defn distributeUntilRepeated 
  ( [list] (distributeUntilRepeated 0 list '(list)))  
  ( [cycles currentState previousStates]
    (if (some #(= currentState %) previousStates)
      [cycles currentState]
      (recur (inc cycles) (distributeOnce currentState) (conj previousStates currentState)))))

(defn distributeUntilState ( [cycles currentState stateToMatch]
    (if (= currentState stateToMatch)
      cycles
      (recur (inc cycles) (distributeOnce currentState) stateToMatch))))


(defn solvepuzzle []
  (let [input (first (utils/readAs2DArray 6))]
    (let [result1 (distributeUntilRepeated input)]
      (println "Puzzle answer 1: " (second result1))
      (println "Puzzle answer 2: " (- (first result1) (distributeUntilState 0 input (second result1))))
    )
  )
)