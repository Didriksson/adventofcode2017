(ns adventofcode2017.day1)
(require '[adventofcode2017.utils :as utils])

(defn sumequals
  [x y acc]
  (if (= x y)
    (+ acc x)
    acc
  )
)

(defn recur_start
  [input acc]
  (if (< (count input) 2 )
    acc
    (recur_start (rest input) (sumequals (nth input 0)(nth input 1) acc)) 
  )
)

(defn get_index
  [input index]
  (mod 
    (+ (dec index)
      (/ (count input) 2)) (count input))
)

(defn recur_start_2ndProblem
  [input acc index]
  (if (= (count input) index)
    acc
    (let [second_index (get_index input (inc index))] 
      (recur_start_2ndProblem input 
        (sumequals (nth input index) (nth input second_index) acc) 
          (inc index))
    )
  )
)

(defn start
  "Takes input in the form of a vector and returns value"
  [input]
  (recur_start (conj input (first input)) 0)
)
(defn start2ndProblem
  "Takes input in the form of a vector and returns value"
  [input]
  (recur_start_2ndProblem input 0 0)
)

(defn solvepuzzle
  []
  (println "Enter puzzle input: ")
  (let [input (utils/readInputNumbers 1)]
    (println "Your answer to 1: "  (start input))
    (println "Your answer to 2: "  (start2ndProblem input))
  )
)
