(ns fjord.app
  (:require [compojure.core :refer [defroutes GET]]
            [compojure.handler :as h]
            [compojure.route :as route]))

(defroutes app-routes
  (GET "/" [] "Hello, world!")
  (route/not-found "Not found :("))

(def handler
  (h/site app-routes))
