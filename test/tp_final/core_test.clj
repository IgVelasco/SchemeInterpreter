(ns tp-final.core-test
  (:require [clojure.test :refer :all]
            [tp-final.core :refer :all]))

  (deftest verificar-parentesis-test
    (testing "FIXME, I fail."
      (is (= 1 (verificar-parentesis "(hola 'mundo")))
      (is (= -1 (verificar-parentesis "(hola '(mundo)))")))
      (is (= -1 (verificar-parentesis "(hola '(mundo) () 6) 7)")))
      (is (= -1 (verificar-parentesis "(hola '(mundo) () 6) 7) 9)")))
      (is (= 0 (verificar-parentesis "(hola '(mundo) )")))
    )
  )
          
  (deftest buscar-test
    (testing "FIXME, I fail."
      (is (= 3 (buscar 'c '(a 1 b 2 c 3 d 4 e 5))))
      (is (= (symbol "(;ERROR: unbound variable: f)") (buscar 'f '(a 1 b 2 c 3 d 4 e 5))))
    )
  )
  
  
  (deftest error?-test
    (testing "FIXME, I fail."
      (is (= true (error? (list (symbol ";ERROR:") 'mal 'hecho))))
      (is (= false (error? (list 'mal 'hecho))))
      (is (= true (error? (list (symbol ";WARNING:") 'mal 'hecho))))
    )
  )
            