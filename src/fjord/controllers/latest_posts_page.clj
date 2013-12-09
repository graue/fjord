(ns fjord.controllers.latest-posts-page
  (:require [fjord.views.layout :refer [layout]]
            [fjord.views.post-listing :refer [post-listing]]
            [fjord.models.post :as post]))

(defn handle-latest-posts-page
  [offset]
  (let [posts (post/retrieve-latest :offset (or offset 0))]
    (layout
      :title "Recent posts"
      :content (post-listing posts))))
