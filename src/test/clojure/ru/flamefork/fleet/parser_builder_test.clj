(ns ru.flamefork.fleet.parser-builder-test
  (:use
    [clojure.test]
    [clojure.contrib pprint]
    [ru.flamefork.fleet parser builder]))

(deftest parse-test
  (let [tpl (slurp "src/test/fleet/second/post_tpl.fleet")
        ast (slurp "src/test/fleet/second/post_tpl.ast.clj")]
    (is (= (parse tpl) (read-string ast)))))

(deftest build-test
  (let [ast (read-string (slurp "src/test/fleet/second/post_tpl.ast.clj"))
        clj (slurp "src/test/fleet/second/post_tpl.clj")]
    (is (=
      (build '(post) ast)
      (read-string clj)))))