(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

;; WARNING - when updating libtess version here, make sure the replace-content
;; in the package task still works as expected, ie. removes CommonJS exports,
;; and exports to either window (browser, browserify) or global (node.js)

(def +lib-version+ "1.2.2")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom {:project 'cljsjs/libtess
      :version +version+
      :description "Polygon tesselation library"
      :url "https://github.com/brendankenny/libtess.js"
      :scm {:url "https://github.com/brendankenny/libtess.js"}
      :license {"SGI" "https://raw.githubusercontent.com/brendankenny/libtess.js/gh-pages/LICENSE"}})

(def github
  "https://raw.githubusercontent.com/")

(def export
  "(((typeof window != 'undefined') && window) || global)")

(deftask package []
  (comp
   (download
    :url (str github "brendankenny/libtess.js/" +lib-version+ "/libtess.cat.js")
    :checksum "753831251e6cdb9ace1b4305d0120256")
   (download
    :url (str github "brendankenny/libtess.js/" +lib-version+ "/libtess.min.js")
    :checksum "2b28522dc90fc23a9f73387db028005e")
   (sift :move {#"^libtess.cat.js"
                "cljsjs/libtess/development/libtess.inc.js"
                #"^libtess.min.js"
                "cljsjs/libtess/production/libtess.min.inc.js"})
   ;; remove CommonJS exports, export to window or global
   (replace-content :in "cljsjs/libtess/development/libtess.inc.js"
                    :match #"(.|\n){147}$" :value (str "\n" export ".libtess=libtess;"))
   (replace-content :in "cljsjs/libtess/production/libtess.min.inc.js"
                    :match #"(.|\n){70}$" :value "")
   (replace-content :in "cljsjs/libtess/production/libtess.min.inc.js"
                    :match #"this\.libtess=" :value (str export ".libtess="))
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.libtess")
   (pom)
   (jar)))
