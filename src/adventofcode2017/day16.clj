(ns adventofcode2017.day16)
(require '[clojure.string :as str])
(require '[adventofcode2017.utils :as utils])

(defn spin [programs size]
  (vec (concat (take-last size programs) (drop-last size programs)))
)

(defn exchange [programs posA posB]
  (assoc programs posA (programs posB) posB (programs posA))  
)

(defn partner [programs nameA nameB]
  (exchange programs (.indexOf programs nameA) (.indexOf programs nameB))  
)

(defn handleInstruction [instruction programs]
  (condp = (subs instruction 0 1)
    "s"  (spin programs (Integer/parseInt (subs instruction 1))) 
    "x"  (let [args (map read-string (str/split (subs instruction 1) #"/"))]
           (exchange programs (first args) (second args)))        
    "p"  (let [args (str/split (subs instruction 1) #"/")]
           (partner programs (first args) (second args))
         )
  )  
)

(defn parseToList []
  (str/split (first (utils/readfileByLines 16)) #",")  
)

(defn doTheDance [instructions programs]
  (if (empty? instructions)
    programs
    (recur (rest instructions) (handleInstruction (first instructions) programs ))
  )
)

(defn doSeveralDances [instructions programs times]
  (if (not(pos? times))
    programs
    (recur instructions (doTheDance instructions programs) (dec (rem times 30)))
  )
)

(defn solvepuzzle []
  (println "Answer puzzle 1: " (doTheDance (parseToList) (into [] (map str (seq "abcdefghijklmnop")))))
  (println "Answer puzzle 2: " (doSeveralDances (parseToList) (into [] (map str (seq "abcdefghijklmnop"))) 1000000000 ))
)