(ns adventofcode2017.utils)
(require '[clojure.string :as str])

(defn readInputNumbers [day]
    (into [] (map #(Character/digit % 10) 
        (slurp (str "resources/input/input" day ".txt"))))
)

(defn readfileByLines [day]
    (-> (slurp (str "resources/input/input" day ".txt"))   
        (str/split #"\n"))
)

(defn readCommaseparatedIntegerlines [day]
    (map read-string (first (map #(str/split % #",") (readfileByLines day))))
)

(defn toInteger [row]
    (into [] (map read-string row))
)

(defn readInteger [day]
    (read-string (first (readfileByLines day)))
)

(defn readAs2DArray [day]
    (into [] (->> 
            (map #(str/split % #"\t") (readfileByLines day))
            (map toInteger)
            )
    )
)
