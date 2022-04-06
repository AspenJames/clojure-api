(ns clojure-api.core
  "Example HTTP API."
  (:gen-class)
  (:require [clojure.tools.cli :refer [parse-opts]]
            [compojure.core :refer [defroutes
                                    GET]]
            [compojure.route :refer [not-found]]
            [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.defaults :refer [api-defaults
                                              wrap-defaults]]))

(defonce server (atom nil))

(defroutes app
  (GET "/" [] "Placeholder")
  (not-found "Route not found"))

(defn run-server!
  "Run the API server on the specified port."
  [port]
  (try
    (reset! server (run-jetty (-> #'app
                                  (wrap-defaults api-defaults))
                              {:join? false
                               :port port
                               :send-server-version? false}))
    (println "API listening on port" port)
    (catch Exception e (println "ERROR:" (.getMessage e)))))

(defn stop-server!
  "Stop the API server, if running."
  []
  (when-not (nil? @server)
    (.stop @server)
    (reset! server nil)))

(def cli-opts
  [["-p" "--port PORT" "Port number"
    :default 4200
    :parse-fn #(Integer/parseInt %)
    :validate [#(< 0 % 0x10000) "Must be a number between 0 and 65536"]]])

(defn -main [& args]
  (let [options (parse-opts args cli-opts)
        port (get-in options [:options :port])
        errors (get options :errors nil)
        _ (when-not (nil? errors) (apply println "ERROR:" errors))]
    (run-server! port)))
