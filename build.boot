(set-env!
  :dependencies '[[org.clojure/clojure       "1.6.0"       :scope "provided"]
                  [boot/core                 "2.0.0-pre27" :scope "provided"]
                  [tailrecursion/boot-useful "0.1.3"       :scope "test"]])

(require '[tailrecursion.boot-useful :refer :all])

(def +version+ "0.11.2")

(useful! +version+)

(task-options!
  pom  [:project     'cljsjs/reactjs
        :version     +version+
        :description "React.js packaged up with Google Closure externs"
        :url         "https://github.com/cljsjs/reactjs"
        :scm         {:url "https://github.com/cljsjs/reactjs"}
        :license     {:name "Eclipse Public License"
                      :url  "http://www.eclipse.org/legal/epl-v10.html"}])