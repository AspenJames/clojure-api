(ns clojure-api.api-test
  (:require [clojure.test :as t]
            [clojure-api.api :as api]
            [ring.mock.request :as mock]))

(t/deftest routes-test
  (t/testing "GET /"
    (let [response (api/app (mock/request :get "/"))
          match? (re-matches #"Hello world" (:body response))
          _ (println match?)]
      (t/testing "status is 200"
        (t/is (= 200 (:status response))))

      (t/testing "body contains \"Hello world\""
        (t/is (re-find #"Hello world" (:body response))))))

  (t/testing "Route not found"
    (let [request-methods [:get :post :patch :put :delete]]
      (loop [method (first request-methods)
             rem (rest request-methods)]
        (t/testing (format "%s request" (str method))
          (let [response (api/app
                          (mock/request (keyword method) "/nonsense/route-that_should.not?be=matched"))]
            (t/testing "status is 404"
              (t/is (= 404 (:status response))))
            (t/testing "body contains \"Route not found\""
              (t/is (re-find #"Route not found" (:body response))))))
        (when (seq rem)
          (recur (first rem) (rest rem)))))))
