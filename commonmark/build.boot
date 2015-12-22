(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.22.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/commonmark
        :version     +version+
        :description "CommonMark is a rationalized version of Markdown syntax.
                      It provides a library with functions for parsing
                      CommonMark documents to an abstract syntax tree (AST),
                      manipulating the AST, and rendering the document to HTML
                      or to an XML representation of the AST."
        :url         "https://github.com/jgm/commonmark.js"
        :license     {"BSD" "https://github.com/jgm/commonmark.js/blob/master/LICENSE"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download  :url (str "https://codeload.github.com/jgm/commonmark.js/zip/" +lib-version+)
              :checksum "F1570544C2A967891BB9AE2314FE6648"
              :unzip true)
   (sift :move {#"^commonmark.js.*/dist/commonmark.js" "cljsjs/development/commonmark.inc.js"})
   (sift :move {#"^commonmark.js.*/dist/commonmark.min.js" "cljsjs/production/commonmark.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.commonmark")))
