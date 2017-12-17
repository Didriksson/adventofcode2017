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

(defn solvepuzzle []
  (println "Answer puzzle 1: "
    (count (re-seq #"1" (str/join (map rowToHex (getBinaryString "hwlqcszp" 128)))))
)