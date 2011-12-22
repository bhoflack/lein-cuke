(ns leiningen.cuke
  (:use [clojure.contrib.str-utils2 :only (join)]
        [leiningen.compile :only [eval-in-project]]))

(def gem-path ".gems")

(defn jruby
  [options]
  (.run (org.jruby.Main.
         (doto (new org.jruby.RubyInstanceConfig)
           (.setEnvironment {"GEM_PATH" gem-path})))
        (.split options " ")))

(defn cuke
  "Run cucumber features"
  [project & args]
  (eval-in-project
   project
   `(.run (org.jruby.Main.
           (doto (new org.jruby.RubyInstanceConfig)
             (.setEnvironment {"GEM_PATH" gem-path})))
          (into-array (map str [(str gem-path "/bin/cucumber" ~@args])))
   (fn [java]
     (.setFork java false))))
