(ns fjord.views.layout
  (:require [hiccup.core :refer [html]]))

(def links
  [{:name "Home" :url "/"}
   {:name "About" :url "/about"}
   {:name "Contact" :url "/contact"}])

(defn layout [& {:keys [title content]}]
  (html
    "<!DOCTYPE html>"
    [:html
     [:head
      [:meta {:charset "utf-8"}]
      [:title title]]
     [:body
      [:header
       [:h1 "Fjord Blog"]
       [:p "Move along, nothing to see here"]]
      [:main
       [:nav
        [:ul
         (for [{:keys [name url]} links]
           [:li
            [:a {:href url} name]])]]
       [:article
        [:h1 title]
        [:p content]]]]]))
