(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]
                 [cljsjs/react-dom "0.14.7-0"]
                 [org.webjars.npm/react-relay "0.7.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.7.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-relay
       :version     +version+
       :description "Relay is a JavaScript framework for building data-driven React applications."
       :url         "https://facebook.github.io/relay/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "https://github.com/facebook/relay/blob/master/LICENSE"}})

(deftask package []
  (comp
   (sift :add-jar {'org.webjars.npm/react-relay #"relay(\.min)?\.js$"})
   (sift :move {#"^.*relay\.js$" "cljsjs/react-relay/development/react-relay.inc.js"
                #"^.*relay\.min\.js$" "cljsjs/react-relay/production/react-relay.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.react-relay"
              :requires ["cljsjs.react" "cljsjs.react.dom"])
   (pom)
   (jar)))
