(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.29.0")
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
   (download 
     :url (format "https://unpkg.com/commonmark@%s/dist/commonmark.js" +lib-version+)
     :target "cljsjs/commonmark/development/commonmark.inc.js")  
   (download 
     :url (format "https://unpkg.com/commonmark@%s/dist/commonmark.min.js" +lib-version+)
     :target "cljsjs/commonmark/production/commonmark.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.commonmark")
   (pom)
   (jar)
   (validate-checksums)))
