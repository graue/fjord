(defproject fjord "0.0.1-SNAPSHOT"
  :description "A blogging engine"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.6"]
                 [ring-server "0.3.1"]
                 [hiccup "1.0.4"]]
  :plugins [[lein-ring "0.8.8"]]
  :ring {:handler fjord/handler}
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.5"]
                        [ring/ring-devel "1.2.1"]]}})
