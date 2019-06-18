(ns instacode.core
  (:require [clojure.java.io :as io]
            [ring.middleware.params :as params]
            [ring.middleware.resource :as resource]
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

(defn page [text code]
  (str (header "Instant notebook")
       (block text code)
       "<form>Text: <input name='text' type='text'>
        Code: <input name='code' type='text'>
        <input type='submit'>
        </form>"
        footer))

(defn handler [{{text "text" code "code"} :params}]
  (-> (ring/response (page text code))
      (ring/content-type "text/html")))

(def app
  (resource/wrap-resource (-> handler params/wrap-params) "public"))

(defn -main []
  (jetty/run-jetty app {:port 8080}))
