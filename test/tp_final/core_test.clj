(ns tp-final.core-test
  (:require [clojure.test :refer :all]
            [tp-final.core :refer :all]))


  (deftest leer-entrada-test
    (testing "leer-entrada TODO"
      (is false)
    )
  )

  (deftest verificar-parentesis-test
    (testing "verificar-parentesis BROKEN, FIXME."
      (is (= 1 (verificar-parentesis "(hola 'mundo")))
      (is (= -1 (verificar-parentesis "(hola '(mundo)))")))
      (is (= -1 (verificar-parentesis "(hola '(mundo) () 6) 7)")))
      (is (= -1 (verificar-parentesis "(hola '(mundo) () 6) 7) 9)")))
      (is (= 0 (verificar-parentesis "(hola '(mundo) )")))
    )
  )
          
  (deftest buscar-test
    (testing "buscar BROKEN, FIXME"
      (is (= 3 (buscar 'c '(a 1 b 2 c 3 d 4 e 5))))
      (is (= (str (symbol "(;ERROR: unbound variable: f)")) (str (buscar 'f '(a 1 b 2 c 3 d 4 e 5)))))
    )
  )
  
  (deftest error?-test
    (testing "error? BROKEN, FIXME"
      (is (= true (error? (list (symbol ";ERROR:") 'mal 'hecho))))
      (is (= false (error? (list 'mal 'hecho))))
      (is (= true (error? (list (symbol ";WARNING:") 'mal 'hecho))))
    )
  )

  (deftest proteger-bool-en-str-test
    (testing "proteger-bool-en-str BROKEN, FIXME"
      (is (= "(or %F %f %t %T)" (proteger-bool-en-str "(or #F #f #t #T)")))
      (is (= "(and (or %F %f %t %T) %T)" (proteger-bool-en-str "(and (or #F #f #t #T) #T)")))
      (is (= "" (proteger-bool-en-str "")))
    )
  )
  
  
  
  (deftest restaurar-bool-test
    (testing "restaurar-bool BROKEN, FIXME"
      (is (= (symbol "(and (or #F #f #t #T) #T)") (restaurar-bool (read-string (proteger-bool-en-str "(and (or #F #f #t #T) #T)")))))
      (is (= (symbol "(and (or #F #f #t #T) #T)") (restaurar-bool (read-string "(and (or %F %f %t %T) %T)") )))
    )
  )
  
  
  
  (deftest fnc-append-test
    (testing "fnc-append-bool BROKEN, FIXME"
      (is (= '(1 2 3 4 5 6 7) (fnc-append '( (1 2) (3) (4 5) (6 7)))))
      (is (= (symbol "(;ERROR: append: Wrong type in arg 3)") (fnc-append '( (1 2) 3 (4 5) (6 7)))))
      (is (= (symbol "(;ERROR: append: Wrong type in arg A)") (fnc-append '( (1 2) A (4 5) (6 7)))))
    )
  ) 
  
  (deftest fnc-equal?-test
    (testing "fnc-equal test BROKEN."
      (is (= (symbol "#t") (fnc-equal? ())))
      (is (= (symbol "#t") (fnc-equal? '(A))))
      (is (= (symbol "#t") (fnc-equal? '(A a))))
      (is (= (symbol "#t") (fnc-equal? '(A a A))))
      (is (= (symbol "#t") (fnc-equal? '(A a A a))))
      (is (= (symbol "#f") (fnc-equal? '(A a A B))))
      (is (= (symbol "#t") (fnc-equal? '(1 1 1 1))))
      (is (= (symbol "#f") (fnc-equal? '(1 1 2 1))))
    )
  )

  (deftest fnc-read-test
    (testing "fnc-read TODO."
      (is false)
    )
  )
  
  
  (deftest fnc-arith-test
    (testing "fnc-arith TODO."
      (is false)
    )
  )

  
  (deftest evaluar-escalar-test
    (testing "fnc-equal test BROKEN."
      (is (= '(32 (x 6 y 11 z "hola")) (evaluar-escalar 32 '(x 6 y 11 z "hola"))))
      (is (= '("chau" (x 6 y 11 z "hola")) (evaluar-escalar "chau" '(x 6 y 11 z "hola"))))
      (is (= '(11 (x 6 y 11 z "hola"))  (evaluar-escalar 'y '(x 6 y 11 z "hola"))))
      (is (= '("hola" (x 6 y 11 z "hola"))  (evaluar-escalar 'z '(x 6 y 11 z "hola"))))
      (is (= (str "((;ERROR: unbound variable: n) (x 6 y 11 z \"hola\"))") (str (evaluar-escalar 'n '(x 6 y 11 z "hola")))))
    )
  )

