(ns adventofcode2017.day14)
(require '[clojure.string :as str])
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
    {:status :used  :group nil}
    {:status :empty :group nil}
  )
)

(defn getDefragRow [rowString] 
  (into [] (map getDefragItem rowString))
)

(defn create2DArray [input size]
  (into [] (map getDefragRow (map rowToHex (getBinaryString input size))))  
)

(defn checkAndUpdateNode [data currentPos comparePos]
  (let [current (get-in data currentPos) compare (get-in data comparePos)]
    (if (= (get current :status) :empty)
      data
      (if (= (get compare :status) :empty)
        data
        (assoc-in data currentPos (assoc current :group (get compare :group)))))))

(defn checkAbove [data rownumber]
  (let [indexes (for [x (range (count (first data)))]
    [rownumber x])]
    (loop [state data indexList indexes]
      (if (empty? indexList)
        state
        (recur (checkAndUpdateNode state (first indexList) [(dec (first (first indexList))) 
          (second (first indexList)) ]) (rest indexList))))))

(defn checkThyNeighbours [data]
    (let [indexes (for [x (range (count data)) y (range (count (first data)))]
      [x y])]
      (loop [state data indexList indexes]
        (if (empty? indexList)
          state
          (recur (checkAndUpdateNode state (first (first indexList)) (second (first indexList))) (rest indexList))
        )
      )
    )
)

(defn getNumberOfNeightbourgroups [input]
  (->
    (checkThyNeighbours input)
    (flatten)
    (distinct)
    (count)
    (dec)
  )
)

(defn solvepuzzle []
  (println "Answer puzzle 1: "
    (count (re-seq #"1" (str/join (map rowToHex (getBinaryString "hwlqcszp" 128)))))
  )
)