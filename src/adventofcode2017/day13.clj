(ns adventofcode2017.day13)
(require '[clojure.string :as str])
(require '[adventofcode2017.utils :as utils])

(defn parseInput [input]
    (into [] 
      (map #(hash-map :depth (Integer/parseInt (first %)) , :range (Integer/parseInt (second %)) :position 0 :direction :down) 
        (map #(str/split % #": ") input)))
)

(defn updateScannerPosition [{position :position depth :depth direction :direction range :range}]
  (if (= direction :down)
    (if (>= position (dec range))
      {:depth depth :range range :position (dec position) :direction :up}
      {:depth depth :range range :position (inc position) :direction :down}
    )
    (if (<= position 0)
      {:depth depth :range range :position (inc position) :direction :down}
      {:depth depth :range range :position (dec position) :direction :up}
    )
  )
)

(defn getScannerAtDepth [depth state]
  (first (filter #(= depth (get % :depth)) state))
)

(defn updatePacketSeverity [{position :position severity :severity} state]
  (let [scanner (getScannerAtDepth position state)]
    (if (not= (get scanner :position) 0)
      [:miss {:position position :severity severity}]
      [:bang {:position position :severity (+ severity (* (get scanner :depth) (get scanner :range)))}]
    )
  )
)

(defn updateAllScanners [state]
  (map updateScannerPosition state)
)

(defn getFirewallDepth [state]
  (apply max (map #(get % :depth) state)) 
)

(defn performTripNoDelay [packet state]
  (if (> (get packet :position) (getFirewallDepth state))
    packet
    (let [newPacketstate (second (updatePacketSeverity packet state))]
      (recur (update newPacketstate :position inc) (updateAllScanners state))
    )
  )   
)

(defn delayTripRecur [packet state]
  (if (> (get packet :position) (getFirewallDepth state))
    :success
    (let [newPacketstate (updatePacketSeverity packet state)]
      (if (= (first newPacketstate) :miss)
        (recur (update (second newPacketstate) :position inc) (updateAllScanners state))
        :failure
      )
    )
  )   
)


(defn tryDelayTrips [state acc]
    (if (= (delayTripRecur {:position 0 :severity 0} state) :success)
      acc
      (recur (updateAllScanners state) (inc acc))
    )
)


(defn solvepuzzle []
  (println "Answer puzzle 1: " (performTripNoDelay {:position 0 :severity 0} (parseInput (utils/readfileByLines 13))))
  (time (println "Answer puzzle 2: " (tryDelayTrips (parseInput (utils/readfileByLines 13)) 0))) 
)