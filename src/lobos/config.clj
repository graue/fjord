(ns lobos.config
  (:use lobos.connectivity))

(def db
  {:classname "org.postgresql.Driver"
   :subprotocol "postgresql"
   :user "dbuser"
   :password "foobar"
   :subname "//localhost:5432/fjord"})

(open-global db)
