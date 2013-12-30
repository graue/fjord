(ns fjord.config
  (:require [environ.core :refer [env]]))

(def dbspec
  {:classname "org.postgresql.Driver"
   :subprotocol "postgresql"
   :user (get env :fjord-db-user "dbuser")
   :password (get env :fjord-db-pass "")
   :subname
   (str "//" (get env :fjord-db-host "localhost")
        ":" (get env :fjord-db-port 5432)
        "/" (get env :fjord-db-name "fjord"))})
