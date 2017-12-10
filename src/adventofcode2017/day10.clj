(ns adventofcode2017.day10)
(require '[clojure.string :as str])
(require '[adventofcode2017.utils :as utils])


(defn offsetPosition [list position]
  (take (count list) (drop position (cycle list)))
)

(defn revertOffset [list position]
  (take (count list) (drop (- (count list) position) (cycle list)))
)


(defn performOneRound [list position skipsize length]
  (let [listToReverse (reverse (take length (offsetPosition list position)))
        restOfList      (take (-(count list) length) 
                          (drop length 
                              (offsetPosition list position)))]
        (revertOffset (concat listToReverse restOfList) position)
  )          
)

(defn recurLengths [list position skipsize lengths]
  (if (empty? lengths)
    list
    (let [result (performOneRound list position skipsize (first lengths))]
      (recur result (mod (+ position skipsize (first lengths)) (count list)) (inc skipsize) (rest lengths))
    )
  )  
)

(defn performAllLengths [listlength lengths]
  (-> 
    (into [] (range listlength))
    (recurLengths 0 0 lengths)
  )
)

(defn solvepuzzle []
  (let [input (utils/readCommaseparatedIntegerlines 10)
        result (performAllLengths 256 input)]
        (println "Solved with puzzle input: " input)
        (println "Answer puzzle 1: " (* (first result) (second result)))
        (println result)
  )
)