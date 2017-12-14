(ns adventofcode2017.day12)
(require '[clojure.string :as str])
(require '[adventofcode2017.utils :as utils])
(require '[ubergraph.core :as uber])


(defn parseEdge [edgeString]
  (let [ result (map read-string (str/split (str/replace (str/replace edgeString #"<-> " "") #"," "") #" "))]
    (map (fn [x] [(first result) x ]) (rest result))
  )
)

(defn addEdges [edges graf]
  (println edges graf)
  (if (empty? edges)
    graf
    (recur (rest edges) (uber/add-edges graf (first edges)))
  )  
)

(defn getProgramsInGroup [input]
    (uber/pprint (addEdges (map parseEdge input) (uber/graph)))
)