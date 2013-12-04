(ns fjord.app
  (:require [compojure.core :refer [defroutes GET]]
            [compojure.handler :as h]
            [compojure.route :as route]
            [fjord.controllers.latest-posts-page
             :refer [handle-latest-posts-page]]))

(defroutes app-routes
  (GET "/" [offset] (handle-latest-posts-page offset))
  (route/not-found "Not found :("))

(def handler
  (h/site app-routes))
