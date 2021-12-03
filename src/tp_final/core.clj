(ns tp-final.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))




  (defn balanced?
    {:test #(do
              (assert (true? (balanced? "(hello(world))")))
              (assert (false? (balanced? "he)llo()world"))))}
    ([expr] (balanced? (clojure.string/split expr #"") 0))
    ([[x & xs] count]
      (cond (neg? count) false
            (nil? x) (zero? count)
            (= x "(") (recur xs (inc count))
            (= x ")") (recur xs (dec count))
            :else (recur xs count))))


(balanced? "isdbnijand()")


(reduce (fn [sum x]
            (println x ))
        0
        (clojure.string/split "asds" #""))



        (defn count-parenthesis [sum x]

          (cond 
            (neg? sum) (reduced -1)
            (= x "(") (+ sum 1)
            (= x ")") (- sum 1)
            :else sum
          )
  
                )

          (reduce count-parenthesis 0  (clojure.string/split "asds" #""))



        (reduce (fn [sum x]
          (if (< sum 0)
            (reduced -1)
            (cond (= x "(") (+ sum 1)
                  (= x ")") (- sum 1)
                )))
        0
        (clojure.string/split "asds" #""))



        (reduce (fn [sum x]
          (println sum)
          ;; (if (< sum 0)
          ;;   (reduced -1)
            ;; (cond (= x "(") (+ sum 1)
            ;;       (= x ")") (+ sum -1)
      )))
        0
        (seq "asd"))

(map (fn [x] (println x)) (seq "asdd"))

(reduce (fn [sum x] 
  (if (> sum 10) 
    (reduced 10) 
    (+ sum x))) 
0 
[1 2 3 4 5 6 7 8 9 10])

(defn balancing [sum x]
  (cond 
    (neg? sum) (reduced -1)
    (= x "(") (+ sum 1)
    (= x ")") (- sum 1)
    :else sum
  )
)