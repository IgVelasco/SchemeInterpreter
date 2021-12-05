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
      (is (= false (error? 7)))
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

  
  (deftest evaluar-escalar-test
    (testing "evaluar-escalar test BROKEN."
      (is (= '(32 (x 6 y 11 z "hola")) (evaluar-escalar 32 '(x 6 y 11 z "hola"))))
      (is (= '("chau" (x 6 y 11 z "hola")) (evaluar-escalar "chau" '(x 6 y 11 z "hola"))))
      (is (= '(11 (x 6 y 11 z "hola"))  (evaluar-escalar 'y '(x 6 y 11 z "hola"))))
      (is (= '("hola" (x 6 y 11 z "hola"))  (evaluar-escalar 'z '(x 6 y 11 z "hola"))))
      (is (= (str "((;ERROR: unbound variable: n) (x 6 y 11 z \"hola\"))") (str (evaluar-escalar 'n '(x 6 y 11 z "hola")))))
    )
  )
  
  (deftest actualizar-ambiente-test
    (testing "actualizar-ambiente test BROKEN."
      (is (= '(a 1 b 2 c 3 d 4) (actualizar-amb '(a 1 b 2 c 3) 'd 4)))
      (is (= '(a 1 b 4 c 3) (actualizar-amb '(a 1 b 2 c 3) 'b 4)))
      (is (= '(a 1 b 2 c 3) (actualizar-amb '(a 1 b 2 c 3) 'b (list (symbol ";ERROR:") 'mal 'hecho))))
      (is (= '(b 7) (actualizar-amb () 'b 7)))
    )
  )
  
  
  (deftest fnc-sumar-test
    (testing "fnc-sumar test BROKEN."
      (is (= 0 (fnc-sumar ())))
      (is (= 3 (fnc-sumar '(3))))
      (is (= 7 (fnc-sumar '(3 4))))
      (is (= 12 (fnc-sumar '(3 4 5))))
      (is (= 18 (fnc-sumar '(3 4 5 6))))
      (is (= (str (symbol "(;ERROR: +: Wrong type in arg1 A)")) (str (fnc-sumar '(A 4 5 6)))))
      (is (= (str (symbol "(;ERROR: +: Wrong type in arg2 A)")) (str (fnc-sumar '(3 A 5 6)))))
      (is (= (str (symbol "(;ERROR: +: Wrong type in arg2 A)")) (str (fnc-sumar '(3 4 A 6)))))
    )
  )
  
  
  (deftest fnc-restar-test
    (testing "fnc-restar test BROKEN."
      (is (= (str (symbol "(;ERROR: -: Wrong number of args given)")) (str (fnc-restar ()))))
      (is (= -3 (fnc-restar '(3))))
      (is (= -1 (fnc-restar '(3 4))))
      (is (= -6 (fnc-restar '(3 4 5))))
      (is (= -12 (fnc-restar '(3 4 5 6))))
      (is (= (str (symbol "(;ERROR: -: Wrong type in arg1 A)")) (str (fnc-restar '(A 4 5 6)))))
      (is (= (str (symbol "(;ERROR: -: Wrong type in arg2 A)")) (str (fnc-restar '(3 A 5 6)))))
      (is (= (str (symbol "(;ERROR: -: Wrong type in arg2 A)")) (str (fnc-restar '(3 4 A 6)))))
    )
  )
  
  
  (deftest fnc-menor-test
    (testing "fnc-restar test BROKEN."
      (is (= (symbol "#t") (fnc-menor '())))
      (is (= (symbol "#t") (fnc-menor '(1))))
      (is (= (symbol "#t") (fnc-menor '(1 2))))
      (is (= (symbol "#t") (fnc-menor '(1 2 3))))
      (is (= (symbol "#t") (fnc-menor '(1 2 3 4))))
      (is (= (symbol "#f") (fnc-menor '(1 2 2 4))))
      (is (= (symbol "#f") (fnc-menor '(1 2 1 4))))
      (is (= (str (symbol "(;ERROR: <: Wrong type in arg1 A)")) (str (fnc-menor '(A 1 2 4)))))
      (is (= (str (symbol "(;ERROR: <: Wrong type in arg2 A)")) (str (fnc-menor '(1 A 1 4)))))
      (is (= (str (symbol "(;ERROR: <: Wrong type in arg2 A)")) (str (fnc-menor '(1 2 A 4)))))
    )
  )

