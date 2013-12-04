(ns fjord.test.posts
  (:require [fjord.models.post :as post]
            [clojure.test :refer [deftest is run-tests]]))

(def test-posts
  [{:title "My Awesome Day"
    :body "Today I ate a peach. Yum."}

   {:title "Coding in Clojure"
    :body "Writing Clojure code can be fun, except when it isn't."}

   {:title "Foobar"
    :body "Blah blah blah."}])

(deftest posting
  (with-redefs [fjord.models.post/posts (atom ())]
    (let [test-post (test-posts 0)
          id (post/add! test-post)]
      (is (= (post/get-by-id id)
             (first (post/retrieve-latest :limit 1))
             (assoc test-post :id id))))))

(comment
  (run-tests)
  )
