(ns fjord.models.post
  "Storage for posts."
  (:require fjord.config
            [clojure.java.jdbc :refer [query insert!]])
  (:refer fjord.config :rename {dbspec db}))

(defn get-by-id
  [id]
  (first (query db ["SELECT id, title, body
                       FROM posts WHERE id = ?" id])))

(defn retrieve-latest
  "Retrieves latest posts, skipping `offset` (if provided) and limiting
  to `limit` results (if provided, else 10)."
  [& {:keys [offset limit]
      :or {offset 0, limit 10}}]
  (query db ["SELECT id, title, body
                FROM posts
                ORDER BY created_on DESC OFFSET ? LIMIT ?"
             offset
             limit]))

(defn add!
  "Adds a post, assigning it a unique ID and returning that ID."
  [post]
  (:id (first (insert! db :posts post))))
