(defproject cljs "0.1.0-SNAPSHOT"
  :description "Space invaders written in clojure in three.js"
  :url "http://github.com/robashton/three-spaceinvaders"

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-1978"]]

  :plugins [[lein-cljsbuild "0.3.4"]]

  :source-paths ["src"]

  :cljsbuild { 
    :builds [{:id "game"
              :source-paths ["src"]
              :compiler {
                :output-to "cljs.js"
                :output-dir "out"
                :optimizations :none
                :source-map true}}]})
