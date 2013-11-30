(ns fjord.posts
  "Storage for posts.

  Currently posts are stored only in memory, not persisted to disk.")

(defonce ^:private posts (atom ()))

(defn get-post
  "Gets a post by ID."
  [id]
  (first (filter #(= (:id %) id) @posts)))

(defn retrieve-posts
  "Retrieves the latest posts, skipping `offset` (if provided) and limiting
  to `limit` results (if provided, else 10)."
  [& {:keys [offset limit]
      :or {offset 0, limit 10}}]
  (take limit (drop offset @posts)))

(defn add-post!
  "Adds a post, assigning it a unique ID and returning that ID."
  [post]
  (let [last-id (-> (retrieve-posts :limit 1) first (get :id 0))
        new-id (inc last-id)
        new-post (assoc post :id new-id)]
    (swap! posts conj new-post)
    new-id))
