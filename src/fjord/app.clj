(ns fjord.app
  (:require [compojure.core :refer [defroutes GET POST]]
            [compojure.handler :as h]
            [compojure.route :as route]
            [fjord.controllers.latest-posts-page
             :refer [handle-latest-posts-page]]
            [fjord.controllers.add-post :refer [handle-add-post]]
            [fjord.views.layout :refer [layout]]
            [fjord.views.new-post :refer [new-post]]))

(defroutes app-routes
  (GET "/" [offset] (handle-latest-posts-page offset))
  (GET "/new" [] (layout :title "New post" :content (new-post)))
  (POST "/add" [title content] (handle-add-post title content))
  (route/not-found "Not found :("))

(def handler
  (h/site app-routes))
