(require 'leiningen.core
         ['clojure.java.shell :as 'shell])


(def output (atom ""))

(Before (reset! output ""))

(Given #"^I have installed lein-cuke"
       #())

(When #"^I run \"(.*)\""
      #(reset! output
               (apply shell/sh (.split %1 " "))))

(Then #"^I should see \"(.*)\" in the output"
      #(assert (contains? @output %1)))
