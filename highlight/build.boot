(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "11.5.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/highlight
        :version     +version+
        :scm         {:url "https://github.com/cljsjs/packages"}
        :description "JavaScript syntax highlighter"
        :url         "https://highlightjs.org/"
        :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask build-and-move-languages []
 (comp
  (download :url (format "https://github.com/isagalaev/highlight.js/archive/%s.zip" +lib-version+)
            :unzip true)
  (sift :move {#"^highlight\.js-\d*\.\d*.\d*/" ""})
  (run-commands :commands [["npm" "install"]
                           ["node" "tools/build.js" "-t" "cdn"]])
  (sift :move {#"build/languages/(.*)\.min\.js" "cljsjs/production/highlight/$1.min.inc.js"
               #"build/styles/(.*)\.css" "cljsjs/common/highlight/$1.css"})))

(deftask package []
  (comp
   (build-and-move-languages)
   ;Building these .js files requires an git repository, thats why they are downloaded from cdnjs
   (download :url (format "https://cdn.jsdelivr.net/gh/highlightjs/cdn-release@%s/build/highlight.min.js" +lib-version+)
             :target "cljsjs/production/highlight.min.inc.js")
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
