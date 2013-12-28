(ns fjord.config)

(def dbspec
  {:classname "org.postgresql.Driver"
   :subprotocol "postgresql"
   :user "dbuser"
   :password "foobar"
   :subname "//localhost:5432/fjord"})
