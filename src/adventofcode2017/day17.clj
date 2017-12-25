(ns adventofcode2017.day17)
(require '[clojure.string :as str])
(require '[adventofcode2017.utils :as utils])

(defn doStep [buffer steps position]
  (let [  newPosition (inc (rem (+ steps position) (count buffer)))
          split (split-at newPosition buffer)]
    [newPosition (concat (first split) [(inc (nth buffer position))] (second split))]
  )
)

(defn doSeveralSteps [steps iterations]
  (loop [iter_left iterations buffer [0] position 0]
    (if (not(pos? iter_left))
      [position buffer]
      (let [new_state (doStep buffer steps position)]
        (recur (dec iter_left) (second new_state) (first new_state))
      )
    )     
  )  
)

(defn checkNextTo0 [steps iterations]
  (loop [iter 1 item 1 position 1]
    (if (= iter iterations)
      item
      (let [newPosition (inc (rem (+ steps position) iter))]
        (if (= 1 newPosition)
          (recur (inc iter) iter newPosition)
          (recur (inc iter) item newPosition)
        )
      )      
    )
  )  
)

(defn solvepuzzle []
  (let [result (doSeveralSteps 376 2017)]
    (println "Answer puzzle 1: " (nth (second result) (inc (first result))))  
  )
  (println "Answer puzzle 2: " (checkNextTo0 376 50000000))  
)
