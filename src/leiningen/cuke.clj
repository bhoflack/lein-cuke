(ns leiningen.cuke
  (:use [clojure.contrib.str-utils2 :only (join)]
        [leiningen.compile :only [eval-in-project]]))

(defn jruby
  [options]
  (.run (org.jruby.Main.
         (doto (new org.jruby.RubyInstanceConfig)
           (.setEnvironment {"GEM_PATH" ".gems"})))
        (.split options " ")))

(defn cuke
  "Run cucumber features"
  [project & args]
  (eval-in-project
   project
   `(do (.run (org.jruby.Main.
               (doto (new org.jruby.RubyInstanceConfig)
                 (.setEnvironment {"GEM_PATH" ".gems"})))
              (into-array (map str [".gems/bin/cucumber" ~@args])))
        (System/exit 0))
   (fn [java]
     (.setFork java false))))
