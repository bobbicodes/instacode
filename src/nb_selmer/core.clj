(ns nb-selmer.core
  (:require [selmer.parser :as tmpl]))

(defn header [title]
  (tmpl/render-file "header.html" {:title title}))

(defn klipse [snippet]
  (tmpl/render-file "klipse.html" {:snippet snippet}))

(def footer
  (slurp "resources/footer.html"))

(defn page [title snippet]
  (str (header title)
       (klipse snippet)
       footer))
