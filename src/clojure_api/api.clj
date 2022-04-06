(ns clojure-api.api
  "Defines API routes"
  (:require [compojure.core :refer [defroutes
                                    GET]]
            [compojure.route :refer [not-found]]))

(defroutes app
  (GET "/" [] "Hello world!")
  (not-found "Route not found"))
