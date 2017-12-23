(ns adventofcode2017.day15)
(require '[clojure.string :as str])
(require '[adventofcode2017.utils :as utils])

(def A_FACTOR 16807)
(def B_FACTOR 48271)
(def A_MULTI 4)
(def B_MULTI 8)

(defn generateValue [previousvalue factor ]
  (rem (*  previousvalue factor ) 2147483647)
)

(defn generateValuePartB [previousvalue factor multiplesOf]
  (let [value (rem (*  previousvalue factor ) 2147483647)]
    (if (= 0 (rem value multiplesOf))
      value
      (generateValuePartB value factor multiplesOf)
    )
  )
)

(defn matches? [v1 v2]
  (= 
    (reverse (take 16 (reverse (Integer/toBinaryString v1))))
    (reverse (take 16 (reverse (Integer/toBinaryString v2))))
  )  
)

(defn generateAndCountValues [iterations startvalues]
  (loop [values startvalues iterations_rem iterations points 0]
    (if (= 0 iterations_rem)
      points
      (do
        (let [gen_aValue (generateValue (first values) A_FACTOR)
              gen_bValue (generateValue (second values) B_FACTOR)]
        (if (matches? gen_aValue gen_bValue)
          (recur [gen_aValue gen_bValue] (dec iterations_rem) (inc points))
          (recur [gen_aValue gen_bValue] (dec iterations_rem) points)          
        )))))
)

(defn generateAndCountValuesPartB [iterations startvalues]
  (loop [values startvalues iterations_rem iterations points 0]
    (if (= 0 iterations_rem)
      points
      (do
        (let [gen_aValue (generateValuePartB (first values) A_FACTOR A_MULTI)
              gen_bValue (generateValuePartB (second values) B_FACTOR B_MULTI)]
        (if (matches? gen_aValue gen_bValue)
          (recur [gen_aValue gen_bValue] (dec iterations_rem) (inc points))
          (recur [gen_aValue gen_bValue] (dec iterations_rem) points)          
        )))))
)


(defn solvepuzzle []
    ;(println "Answer a: " (generateAndCountValues 40000000 [699 124]))
    (println "Answer b: " (generateAndCountValuesPartB 5000000 [699 124]))
)
