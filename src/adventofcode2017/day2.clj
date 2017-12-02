(ns adventofcode2017.day2)
(require '[adventofcode2017.utils :as utils])

(defn checksumMinMax [row]
  (- (apply max row) (apply min row)) 
)

(defn getDivisor [row]
  (first (filter #(or (= (rem % (first row)) 0) (= (rem (first row) % ) 0)) (rest row)))
)

(defn checksumEvenDivisable [row]
  (if (empty? row)
    0
    (let [result (getDivisor row)]
      (if (nil? result)
        (checksumEvenDivisable (rest row))
        (if (= (rem result (first row)) 0)
          (/ result (first row))
          (/ (first row) result)))))
)

(defn checksumSpreadsheet [sheet checkfunction]
  (->>
    (map checkfunction sheet)
    (reduce +))
)

(defn solvePuzzle []
  (let [input (utils/readAs2DArray 2)]
    (println "Running with input: " input)
    (println "Your answer to 1: "  (checksumSpreadsheet input checksumMinMax))
    (println "Your answer to 2: "  (checksumSpreadsheet input checksumEvenDivisable))
    
  )
)