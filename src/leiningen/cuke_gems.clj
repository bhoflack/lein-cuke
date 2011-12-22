(ns leiningen.cuke-gems
  (:use [leiningen.cuke :only [jruby gem-path]]))

(defn cuke-gems
  "Install the Ruby Gems that are necessary to run Cucumber."
  [project & args]
  (jruby (str "-S gem install -i " gem-path "--no-rdoc --no-ri" ~@args "cucumber cuke4duke"))
