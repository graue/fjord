(ns fjord.views.post-listing
  (:require [hiccup.core :refer [html]]))

(defn post-listing [posts]
  (html
    (for [post posts]
      [:div.post
       [:h2 (:title post)]
       [:p (:body post)]])))
