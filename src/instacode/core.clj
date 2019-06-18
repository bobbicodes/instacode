(ns instacode.core
  (:require [clojure.java.io :as io]
            [ring.adapter.jetty :as jetty]
            [ring.util.response :as ring]
            [selmer.parser :as tmpl]))

(defn header [title]
  (tmpl/render-file "header.html" {:title title}))

(defn block
  ([text]
   (tmpl/render-file "block.html" {:text text}))
  ([text code]
   (tmpl/render-file "block.html" {:text text :code code})))

(def footer
  (slurp "resources/footer.html"))

(defn filename [s]
  (clojure.string/lower-case
   (clojure.string/replace s " " "-")))

(defn nb
  ([text]
   (spit "index.html"
         (str (header "Instant notebook")
              (block text)
              footer)))
  ([text code]
   (spit "index.html"
         (str (header "Instant notebook")
              (block text code)
              footer))))

(defn handler [request]
  (-> (ring/response (io/file "index.html"))
      (ring/content-type "text/html")))
