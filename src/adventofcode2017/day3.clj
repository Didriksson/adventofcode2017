(ns adventofcode2017.day3
  (:require [clojure.math.numeric-tower :as math]))

(require '[adventofcode2017.utils :as utils])
(use 'clojure.pprint)  

(defn handleRight [board x y]
  (if (nil? (aget board x (dec y)))
    {:x x :y (dec y) :direction :up}
    {:x (inc x) :y y :direction :right}
  )
)

(defn handleUp [board x y]
  (if (nil? (aget board (dec x) y))
    {:x (dec x) :y y :direction :left}
    {:x x :y (dec y) :direction :up}
  )
)

(defn handleLeft [board x y]
  (if (nil? (aget board x (inc y)))
    {:x x :y (inc y) :direction :down}
    {:x (dec x) :y y :direction :left}
  )
)

(defn handleLeft [board x y]
  (if (nil? (aget board x (inc y)))
    {:x x :y (inc y) :direction :down}
    {:x (dec x) :y y :direction :left}
  )
)

(defn handleDown [board x y]
  (if (nil? (aget board (inc x) y))
    {:x (inc x) :y y :direction :right}
    {:x x :y (inc y) :direction :down}
  )
)

(defn nextSpaceAndDirection [board x y previousDirection]
  (case previousDirection
    :right (handleRight board x y)
    :up    (handleUp board x y)
    :left (handleLeft board x y)
    :down (handleDown board x y)
    :nil {:x (inc x) :y y :direction :right}
  )  
)

(defn fillSpace [board maxsize x y value direction]
  (aset board x y value)
  (if (= value maxsize)
    board
    (let [next (nextSpaceAndDirection board x y direction) ]
      (recur board maxsize (get next :x) (get next :y) (inc value) (get next :direction))
    )
  )
)

(defn fillBoard [board]
  (fillSpace board (* (count board) (count board)) (quot (count board) 2) (quot (count board) 2) 1 :nil)
)

(defn createMatrix [size]
  (let [rows size
        cols size
        board (to-array-2d (repeat rows (repeat cols nil)))]
    board
  )
)

(defn getSmallestMatrix [value]
  (first(drop-while #(or (< (* % %) value) (even? %)) (range)))  
)

(defn findItem [board input]
  (let [n (count (first board))
        i (.indexOf (flatten (mapv vec board)) input)]
        (if (or (pos? i) (zero? i))
          (list (quot i n) (mod i n))
        )
  )
)

(defn findSteps [board input]
  (let [coord (findItem board input)]
      (+
        (math/abs (- (quot (count board) 2) (second coord)))
        (math/abs (- (quot (count board) 2) (first coord)))
      )
  )
)

(defn inboard [board x y]
  (and
        (< x (count (first board))) 
        (< y (count (first board))) 
        (> x -1)
        (> y -1)
  )
)

(defn sumAdjacentValues [board x y]
    (let [newCoords (for [  dx [-1 0 1] dy [-1 0 1]
                          :let  [newX (+ x dx)]
                          :let  [newY (+ y dy)]
                          :when (not (= [dx dy] [0 0]))
                          :when (inboard board newX newY)]
                      [newX newY]
                     )]
      (reduce + (remove nil? (map #(aget board (first %)(second %)) newCoords)))
    )
)

(defn fillSpaceAdjacent [board input x y value direction]
  (aset board x y value)
  (if (> value input)
    [board value]
    (let [next (nextSpaceAndDirection board x y direction) ]
      (recur board input (get next :x) (get next :y) (sumAdjacentValues board (get next :x) (get next :y)) (get next :direction))
    )
  )
)

(defn fillFromAdjacentCells [board input] 
    (fillSpaceAdjacent board input (quot (count board) 2) (quot (count board) 2) 1 :nil)
)

(defn getValuelargerThanInput [input] 
  (second (->   (createMatrix 10)
                (fillFromAdjacentCells input)
  ))
)

(defn getNumberofSteps [input]
  (-> (getSmallestMatrix input)
      createMatrix
      fillBoard
      (findSteps input)
  )
)

(defn solvePuzzle []
  (let [input (utils/readInteger 3)]
    (println "Answer puzzle 1: " (getNumberofSteps input))
    (println "Answer puzzle 2: " (getValuelargerThanInput input))
  )
)