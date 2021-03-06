(ns rackspace.util
  (:require [clojure.data.json :as json]))


(defn parse-json-body [response]
  (json/read-str (response :body) :key-fn keyword))

(defn create-temp-file
  ([] (create-temp-file "clj-rax-" ".tmp"))
  ([prefix suffix] (doto (java.io.File/createTempFile prefix suffix) .deleteOnExit)))