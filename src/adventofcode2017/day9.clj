(ns adventofcode2017.day9)
(require '[clojure.string :as str])
(require '[adventofcode2017.utils :as utils])


(defn findBracket [stream openedgroups acc]
  (if (empty? stream)
    acc
    (let [char (first stream)]
      (condp = char
        \{  (recur (rest stream) (inc openedgroups) acc)
        \}  (recur (rest stream) (dec openedgroups) (+ acc openedgroups))
            (recur (rest stream) openedgroups acc)
      ))))

(def gbregex #"<(.*?)>")

(defn cleanGarbage [stream]
  (str/replace stream gbregex "")
)

(defn removeIgnored [stream]
  (str/replace stream #"!." "")
)

(defn getScore [stream]
  (-> 
    (removeIgnored stream)
    (cleanGarbage)
    (findBracket 0 0)
  )
)

(defn getGarbageCount [stream]
  (reduce + (map (fn [x] (count (second x))) (re-seq #"<(.*?)>"   (removeIgnored stream))))
)

(defn solvepuzzle []
  (println "Puzzle answer 1: " (getScore (first (utils/readfileByLines 9))))
  (println "Puzzle answer 2: " (getGarbageCount (first (utils/readfileByLines 9))))  
)
