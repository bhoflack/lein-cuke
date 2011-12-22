(defproject lein-cuke "0.0.4-SNAPSHOT"
  :description "Cucumber runner for leiningen"
;  :repositories {"cukes" "http://cukes.info/maven"
;                 "clojars" "http://clojars.org/repo"}
  :dependencies [[org.clojure/clojure "1.2.1"]
                 [org.clojure/clojure-contrib "1.2.0"]
                 [org.jruby/jruby-complete "1.6.5"]
                 [cuke4duke "0.4.4"
                  :exclusions [org.jruby/jruby-complete
                               org.clojure/clojure
                               org.clojure/clojure-contrib]]]
  :dev-dependencies [[lein-clojars "0.7.0"]])

