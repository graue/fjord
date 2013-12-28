(ns lobos.migrations
  (:refer-clojure :exclude [alter drop
                            bigint boolean char double float time])
  (:require [lobos.migration :refer [defmigration]]
            [lobos.core :refer :all]
            [lobos.schema :refer :all]
            [lobos.config :refer :all]
            [lobos.helpers :refer :all]))

(defmigration add-posts-table
  (up [] (create
           (tbl :posts
             (varchar :title 200)
             (text :content))))
  (down [] (drop (table :posts))))
