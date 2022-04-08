(defproject clojure-api "0.1.0-SNAPSHOT"
  :description "Basic API -- Clojure learning project."
  :url "http://github.com/aspenjames/clojure-api"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [org.clojure/tools.cli "1.0.206"] ; Parse args
                 [compojure "1.6.2"]               ; Request/response routing
                 [ring/ring-core "1.8.2"]          ; Request/response handling
                 [ring/ring-defaults "0.3.3"]      ; Middleware defaults
                 [ring/ring-jetty-adapter "1.8.2"] ; Run Jetty web server
                 [ring/ring-mock "0.4.0"]          ; Mock requests for testing
                 ]
  :main ^:skip-aot clojure-api.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}
             :repl {:plugins [[cider/cider-nrepl "0.27.3"]]}})
