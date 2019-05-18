(ns instacode.core
  (:require [selmer.parser :as tmpl]))

(defn header [title]
  (tmpl/render-file "header.html" {:title title}))

(defn klipse [snippet]
  (tmpl/render-file "klipse.html" {:snippet snippet}))

(def footer
  (slurp "resources/footer.html"))

(defn filename [s]
  (clojure.string/lower-case
   (clojure.string/replace s " " "-")))

(defn nb
  ([code]
   (spit "index.html"
         (str (header "Instant notebook")
              (klipse code)
              footer)))
  ([title code]
   (spit (str (filename title) ".html")
         (str (header title)
              (klipse code)
              footer))))
