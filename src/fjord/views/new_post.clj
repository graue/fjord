(ns fjord.views.new-post
  (:require [hiccup.core :refer [html]]))

(defn new-post []
  (html
    [:form {:method "post", :action "/add"}
     [:p
      [:input {:type "text", :name "title", :id "post-title"}]]
     [:p
      [:textarea {:name "content", :id "post-content"
                  :rows 20, :cols 85}]]
     [:p
      [:input {:type "submit", :value "Post"}]]]))
