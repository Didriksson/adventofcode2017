(ns adventofcode2017.day4)
(require '[adventofcode2017.utils :as utils])
(require '[clojure.string :as str])


(defn noDuplicates? [passphrase]
  (->> 
    (str/split passphrase #" ")
    frequencies
    (every? (fn [x] (= (second x) 1)))
  )
)

(defn noAnagrams? [passphrase]
  (->> 
    (str/split passphrase #" ")
    (map frequencies)
    (frequencies)
    (every? (fn [x] (= (second x) 1)))
  )
)

(defn validAnagrams [items ])

(defn solvepuzzle []
  (let [input (utils/readfileByLines 4)]
    (println "Puzzle 1: " (count (filter noDuplicates? input)))
    (println "Puzzle 2: " (count (filter noAnagrams? 
                                  (filter noDuplicates? input))))
    )
)