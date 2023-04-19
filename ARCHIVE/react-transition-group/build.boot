(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]
                 [cljsjs/react "16.6.0-0"]
                 [cljsjs/react-dom "16.6.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.3.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-transition-group
       :version     +version+
       :description "An easy way to perform animations when a React component enters or leaves the DOM"
       :url         "https://reactcommunity.org/react-transition-group/"
       :scm         {:url "https://github.com/reactjs/react-transition-group"}
       :license     {"BSD-3-Clause" "https://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (comp
   (download :url (format "https://unpkg.com/react-transition-group@%s/dist/react-transition-group.min.js" +lib-version+)
             :target "cljsjs/react-transition-group/production/react-transition-group.min.inc.js")
   (download :url (format "https://unpkg.com/react-transition-group@%s/dist/react-transition-group.js" +lib-version+)
             :target "cljsjs/react-transition-group/development/react-transition-group.inc.js")
   (deps-cljs :provides ["react-transition-group"
                         "react-transition-group/TransitionGroup"
                         "react-transition-group/CSSTransition"
                         "react-transition-group/Transition"
                         "react-transition-group/SwitchTransition"
                         "cljsjs.react-transition-group"]
              :requires ["react" "react-dom"]
              :global-exports '{react-transition-group ReactTransitionGroup
                                react-transition-group/Transition ReactTransitionGroup.Transition
                                react-transition-group/TransitionGroup ReactTransitionGroup.TransitionGroup
                                react-transition-group/CSSTransition ReactTransitionGroup.CSSTransition
                                react-transition-group/SwitchTransition ReactTransitionGroup.SwitchTransition})
   (pom)
   (jar)
   (validate)))
