(ns leiningen.cuke-gems
  (:use [leiningen.cuke :only [jruby]]))

(defn cuke-gems
  "Run cucumber features"
  [project]
  (jruby "-S gem install -i lib/gems --no-rdoc --no-ri --version 1.1.2 cucumber")
  (jruby "-S gem install -i lib/gems --no-rdoc --no-ri --version 0.4.4 cuke4duke")
)
