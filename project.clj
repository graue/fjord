(defproject fjord "0.0.1-SNAPSHOT"
  :description "A blogging engine"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.6"]
                 [ring-server "0.3.1"]
                 [hiccup "1.0.4"]
                 [environ "0.4.0"]
                 [org.postgresql/postgresql "9.3-1100-jdbc41"]
                 ; Note: java.jdbc dependency must stay in sync with Lobos.
                 [org.clojure/java.jdbc "0.3.0-beta1"]
                 [lobos "1.0.0-beta1"]]
  :plugins [[lein-ring "0.8.8"]
            [lein-environ "0.4.0"]]
  :ring {:handler fjord.app/handler}
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.5"]
                        [ring/ring-devel "1.2.1"]]
         :env {:fjord-db-user "dbuser"
               :fjord-db-table "fjord"}}})
