(ns fjord.controllers.add-post
  (:require [fjord.models.post :as post]
            [ring.util.response :refer [redirect-after-post]]))

(defn handle-add-post [title content]
  (post/add! {:title title, :body content})
  (redirect-after-post "/"))
