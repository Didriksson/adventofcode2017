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

(defn getProgramsInGroup [input]
    (alg/connected-components (addEdges (mapcat  parseEdge input) (uber/graph)))
)