(ns adventofcode2017.day9_test
(:require [clojure.test :refer :all]
[adventofcode2017.day9 :refer :all]))

(deftest example1
  (testing "<>, empty garbage."
    (is (= (cleanGarbage "<>") "" ) )
  )
)

(deftest example2
  (testing "garbage containing random characters."
    (is (= (cleanGarbage "<random characters>") "" ) )
  )
)

(deftest example3
  (testing "<<<<>, because the extra < are ignored."
    (is (= (cleanGarbage "<<<<>") "" ) )
  )
)

(deftest example4
  (testing "<{!>}>"    
    (is (= (cleanGarbage (removeIgnored "<{!>}>")) "" ) )
  )
)

(deftest example5
  (testing "<!!>"    
    (is (= (cleanGarbage (removeIgnored "<!!!>>")) "" ) )
  )
)

(deftest example6
  (testing "<{o\"i!a,<{i<a>"    
    (is (= (cleanGarbage (removeIgnored "<{o\"i!a,<{i<a>")) "" ) )
  )
)

(deftest example7
  (testing "{} is one group"    
    (is (= (getScore "{}") 1 ))
  )
)

(deftest example8
  (testing "{{{}}}"    
    (is (= (getScore "{{{}}}") 6 ))
  )
)

(deftest example8b
  (testing "{{},{}}"
    (is (= (getScore "{{},{}}") 5))
  )  
)

(deftest example9
  (testing "{<a>,<a>,<a>,<a>}, score of 1."    
    (is (= (getScore "{<a>,<a>,<a>,<a>}") 1 ))
  )
)

(deftest example10
  (testing "{{{},{},{{}}}}, score of 1 + 2 + 3 + 3 + 3 + 4 = 16"
    (is (= (getScore "{{{},{},{{}}}}") 16))  
  )  
)

(deftest example11
  (testing "{{<ab>},{<ab>},{<ab>},{<ab>}}, score of 1 + 2 + 2 + 2 + 2 = 9."    
    (is (= (getScore "{{<ab>},{<ab>},{<ab>},{<ab>}}") 9 ))
  )
)

(deftest example12
  (testing "{{<!!>},{<!!>},{<!!>},{<!!>}}, score of 1 + 2 + 2 + 2 + 2 = 9."    
    (is (= (getScore "{{<!!>},{<!!>},{<!!>},{<!!>}}") 9 ))
  )
)

(deftest example13
  (testing "{{<a!>},{<a!>},{<a!>},{<ab>}}, score of 1 + 2 = 3."    
    (is (= (getScore "{{<a!>},{<a!>},{<a!>},{<ab>}}") 3 ))
  )
)


(deftest additionalTest
  (testing "!>!}"
    (is (= (cleanGarbage (removeIgnored "!>!}")) ""))
  )
)

(deftest additionalTest2
  (testing "!!> !!}"
    (is (= (cleanGarbage (removeIgnored "!!>!!}")) ">}"))
  )
)

(deftest additionalTest3
  (testing "<{ <}"
    (is (= (cleanGarbage (removeIgnored "<{<}")) "<{<}"))
  )
)

(deftest additionalTest4
  (testing "<>"
    (is (= (cleanGarbage (removeIgnored "<>")) ""))
    (is (= (getScore "<>") 0))
  )
)
(deftest anotherOne
  (testing "{{{{{{{<!>!>!<u,!>!!!!!!!>!!!>,<<!!\">},<!!!>,<!>,<}>},"
    (is (= (cleanGarbage (removeIgnored "{{{{{{{<!>!>!<u,!>!!!!!!!>!!!>,<<!!\">},<!!!>,<!>,<}>},")) "{{{{{{{},},"))
  )  
)

(deftest additionalTests
  (testing "{<{}}>}"
    (is (= (getScore "{<{}}>}") 1))  
  )  
)


