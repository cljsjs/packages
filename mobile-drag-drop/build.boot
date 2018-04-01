(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.3.0-rc.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/mobile-drag-drop
        :version     +version+
        :scm         {:url "https://www.npmjs.com/package/mobile-drag-drop"}
        :description "A drop-in shim to allow you to use existing html5 drag'n'drop code with mobile browsers"
        :url         "https://github.com/timruffles/mobile-drag-drop"
        :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (comp
      (download :url (format "https://unpkg.com/mobile-drag-drop@%s/index.min.js" +lib-version+)
                :target "cljsjs/mobile-drag-drop/development/mobile-drag-drop.inc.js")
      (download :url (format "https://unpkg.com/mobile-drag-drop@%s/scroll-behaviour.min.js" +lib-version+)
                :target "cljsjs/mobile-drag-drop/development/scroll-behaviour.inc.js")
      (download :url (format "https://unpkg.com/mobile-drag-drop@%s/debug.css" +lib-version+)
                :target "cljsjs/mobile-drag-drop/development/debug.inc.css")
      (download :url (format "https://unpkg.com/mobile-drag-drop@%s/default.css" +lib-version+)
                :target "cljsjs/mobile-drag-drop/development/default.inc.css")
      (download :url (format "https://unpkg.com/mobile-drag-drop@%s/icons.css" +lib-version+)
                :target "cljsjs/mobile-drag-drop/development/icons.inc.css")

      (download :url (format "https://unpkg.com/mobile-drag-drop@%s/index.min.js" +lib-version+)
                :target "cljsjs/mobile-drag-drop/production/mobile-drag-drop.min.inc.js")
      (download :url (format "https://unpkg.com/mobile-drag-drop@%s/scroll-behaviour.min.js" +lib-version+)
                :target "cljsjs/mobile-drag-drop/production/scroll-behaviour.inc.js")
      (download :url (format "https://unpkg.com/mobile-drag-drop@%s/debug.css" +lib-version+)
                :target "cljsjs/mobile-drag-drop/production/debug.inc.css")
      (download :url (format "https://unpkg.com/mobile-drag-drop@%s/default.css" +lib-version+)
                :target "cljsjs/mobile-drag-drop/development/default.inc.css")
      (download :url (format "https://unpkg.com/mobile-drag-drop@%s/icons.css" +lib-version+)
                :target "cljsjs/mobile-drag-drop/production/icons.inc.css")
      (deps-cljs :name "cljsjs.mobile-drag-drop")
      (pom)
      (jar))
    (validate-checksums)))
