(ns leiningen.cuke-gems
  (:use [leiningen.cuke :only [jruby]]))

(defn cuke-gems
  "Run cucumber features"
  [project & args]
  (let [base "-S gem install -i lib/gems --no-rdoc --no-ri"
        cucumber "--version 1.1.2 cucumber"
        cuke4duke"--version 0.4.4 cuke4duke"
        extra (apply str (map #(str " " %) `[~@args]))
        cucumber-cmd (str base extra " " cucumber)
        cuke4duke-cmd (str base extra " " cuke4duke)
        ]
    (println "Installing cucumber : " cucumber-cmd)
    (jruby cucumber-cmd)
    (println "Installing cuke4duke : " cuke4duke-cmd)
    (jruby cuke4duke-cmd)))

