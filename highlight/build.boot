(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "9.12.0")
(def +version+ (str +lib-version+ "-2"))

(task-options!
  pom  {:project     'cljsjs/highlight
        :version     +version+
        :scm         {:url "https://github.com/cljsjs/packages"}
        :description "JavaScript syntax highlighter"
        :url         "https://highlightjs.org/"
        :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (comp
    (download :url (format "https://github.com/isagalaev/highlight.js/archive/%s.zip" +lib-version+)
              :unzip true)
    (sift :move {#"^highlight\.js-\d*\.\d*.\d*/" ""})
    (run-commands :commands [["npm" "install"]
                             ["node" "tools/build.js" "-t" "cdn" ":none"]])
    (sift :move {#"build/highlight\.min\.js" "cljsjs/production/highlight.min.inc.js"
                 #"build/languages/(.*)\.min\.js" "cljsjs/production/highlight/$1.min.inc.js"
                 #"build/styles/(.*)\.css" "cljsjs/common/highlight/$1.css"})
    (deps-cljs :foreign-libs [{:file #"highlight\.min\.inc\.js"
                               :provides ["highlight.js" "cljsjs.highlight"]
                               :global-exports '{highlight.js hljs}}
                              ;; Each matched file will create foreign lib entry
                              {:file #"cljsjs/production/highlight/(.*)\.min\.inc\.js"
                               :requires ["highlight.js"]
                               :provides ["highlight.js/lib/languages/%1$s" "cljsjs.highlight.langs.%1$s"]}]
               :externs [#"highlight\.ext\.js"])
    (sift :include #{#"^cljsjs" #"^deps\.cljs$"})
    (pom)
    (jar)
    (validate)))
