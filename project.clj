(defproject instacode "0.1.0-SNAPSHOT"
  :description "Instant Live Coding Notebook Generator"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :plugins [[lein-ring "0.12.1"] [lein-cljsbuild "1.1.7"]]
:cljsbuild {:builds
            [{:id "app"
              :source-paths ["src/cljs"]
              :compiler {:output-to "resources/public/js/app.js"
                         :output-dir "resources/public/js/out"
                         :source-map true
                         :optimizations :none
                         :asset-path "/static/js/out"
                         :main "instacode.core"
                         :pretty-print true}}]}
  :ring {:handler instacode.core/handler}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/clojurescript "1.10.516"]
                 [ring/ring-core "1.7.1"]
                 [ring/ring-jetty-adapter "1.7.1"]
                 [ring/ring-devel "1.7.1"]
                 [selmer "1.12.12"]]
  :repl-options {:init-ns instacode.core})
