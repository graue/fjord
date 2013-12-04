(ns fjord.views.layout
  (:require [hiccup.core :refer [html]]))

(defn layout [& {:keys [title body]}]
  (html
    "<!DOCTYPE html>"
    [:html
     [:head
      [:meta {:charset "utf-8"}]
      [:title title]]
     [:body body]]))
