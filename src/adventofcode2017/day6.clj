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
      cycles
      (recur (inc cycles) (distributeOnce currentState) (conj previousStates currentState)))))

(defn distributeUntilRepeatedInitialState
  ( [list] (distributeUntilRepeatedInitialState 1 (distributeOnce list) list))
  ( [cycles currentState stateToMatch]
    (if (= currentState stateToMatch)
      cycles
      (recur (inc cycles) (distributeOnce currentState) stateToMatch))))


(defn solvepuzzle []
  (let [input (first (utils/readAs2DArray 6))]
    (println "Puzzle answer 1: " (distributeUntilRepeated input))
    (println "Puzzle answer 2: " (distributeUntilRepeatedInitialState input))
  )
)