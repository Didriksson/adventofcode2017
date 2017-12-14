(ns adventofcode2017.day12)
(require '[clojure.string :as str])
(require '[adventofcode2017.utils :as utils])
(require '[ubergraph.core :as uber])
(require '[ubergraph.alg :as alg])

(defn parseEdge [edgeString]
  (let [ result (map read-string (str/split (str/replace (str/replace edgeString #"<-> " "") #"," "") #" "))]
    (map (fn [x] [(first result) x ]) (rest result))
  )
)

(defn addEdges [edges graf]
  (if (empty? edges)
    graf
    (recur (rest edges) (uber/add-edges graf (first edges)))
  )  
)

(defn getGroups [input]
  (alg/scc (addEdges (mapcat  parseEdge input) (uber/graph)))  
)

(defn getProgramsInGroup [input node]
  (let [result (getGroups input)]
    (count (first (filter #(some (partial = node) %) result)))
  )  
)

(defn solvepuzzle []
  (println "Result puzzle 1: " (getProgramsInGroup (utils/readfileByLines 12) 0))
  (println "Result puzzle 2: " (count (getGroups (utils/readfileByLines 12))))  
)
