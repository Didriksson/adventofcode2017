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
  (let [right (mapcat #(get % :lifts) (parseFile input))
       left (map #(get % :program) (parseFile input))]
       (first (remove (set right) left))
))
