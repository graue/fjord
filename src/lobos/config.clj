(ns lobos.config
  (:use lobos.connectivity)
  (:require fjord.config))

(def db fjord.config/dbspec)

(open-global db)
