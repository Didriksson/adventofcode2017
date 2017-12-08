(ns adventofcode2017.day7)
(require '[adventofcode2017.utils :as utils])
(require '[clojure.string :as str])

(defn parseItem [line]
  {:program (first line) :weight (first (read-string (second line))) :lifts (into [] (drop 3 line))}  
)

(defn parseFile ([] (parseFile 7))(
  [fileending]
    (->> (utils/readfileByLines fileending)
      (map #(str/replace % #"," ""))
      (map #(str/split % #" "))
      (map parseItem)
    )))

(defn getBottomProgram [input]
  (let [right (mapcat #(get % :lifts) (parseFile "7_test"))
       left (map #(get % :program) (parseFile "7_test"))]
       (first (remove (set right) left))
  ))

(defn getNode [program tower]
  (first (filter #(= program (get % :program)) tower))
)

(defn getAllLiftingNodes [program tower]
    (into [] (map #(get % :program) (map #(getNode % tower) (get (getNode program tower) :lifts))))
)

(defn getAllLiftingNodesRecur [program tower allnodes]
  Kanske något med (recur getAllLiftingNodes) typ typ.
  (println program allnodes)
  (if (empty? (getAllLiftingNodes program tower))
    (cons program allnodes)
    (map #(getAllLiftingNodesRecur % tower (cons % allnodes))
      (getAllLiftingNodes program tower))
  )
)