(ns fjord.test.posts
  (:require [fjord.posts :refer :all]
            [clojure.test :refer [deftest is run-tests]]))

(def test-posts
  [{:title "My Awesome Day"
    :body "Today I ate a peach. Yum."}

   {:title "Coding in Clojure"
    :body "Writing Clojure code can be fun, except when it isn't."}

   {:title "Foobar"
    :body "Blah blah blah."}])

(deftest posting
  (with-redefs [fjord.posts/posts (atom ())]
    (let [test-post (test-posts 0)
          id (add-post! test-post)]
      (is (= (get-post id)
             (first (retrieve-posts :limit 1))
             (assoc test-post :id id))))))

(comment
  (run-tests)
  )
