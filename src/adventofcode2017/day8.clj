(ns adventofcode2017.day8)
(require '[clojure.string :as str])
(require '[adventofcode2017.utils :as utils])

(defn checkCondition [condition registers]
  (let [[reg func o2] (str/split condition #" ")]
    (if (= func "!=")
      (eval (read-string (str "(not= " (get registers reg 0) " " o2 ")")))
      (eval (read-string (str "("func " " (get registers reg 0) " " o2 ")")))
    )
  )
)

(defn doInstruction [operation registers]
  (let [[reg operand value] (str/split operation #" ")]
    (if (= operand "inc")
      (assoc registers reg (+ (get registers reg 0) (read-string value)))
      (assoc registers reg (- (get registers reg 0) (read-string value)))
    )
  )
)

(defn doStatement [instruction registers]
  (let [[operation condition] (str/split instruction #" if ")]
    (if (checkCondition condition registers)
      (doInstruction operation registers)
      registers
    )
  )
)

(defn doAllStatements [statements registers highest]
  (if (empty? statements)
    [registers highest]
    (let [result (doStatement (first statements) registers)]
      (recur (rest statements) (doStatement (first statements) registers) (max (apply max (vals result)) highest))
    )
  )
)

(defn solvepuzzle []
  (let [input (utils/readfileByLines 8)]
    (let [result (doAllStatements input {} 0)]
      (println "Answer puzzle 1" (apply max (vals (first result))))
      (println "Answer puzzle 2" (second result))
    )
  )
)