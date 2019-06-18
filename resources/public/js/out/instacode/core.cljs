(ns instacode.core)

(defn set-html! [el content]
  (set! (.-innerHTML el) content))

(defn main
  []
  (let [content "Hello World from ClojureScript"
        element (aget (js/document.getElementsByTagName "main") 0)]
    (set-html! element content)))

(main) 
