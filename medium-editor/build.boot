(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.2"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "5.22.1")
(def +version+ (str +lib-version+ "-2"))

(task-options!
 pom  {:project     'cljsjs/medium-editor
       :version     +version+
       :description "Medium.com WYSIWYG editor clone"
       :url         "https://daviferreira.github.io/medium-editor/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Custom" "https://raw.githubusercontent.com/yabwe/medium-editor/master/LICENSE"}})

(deftask package []
  (comp
   (download :url      (format "https://github.com/daviferreira/medium-editor/archive/%s.zip" +lib-version+)
             :checksum "3FF0230E2FB079D0114EA604B3F9D4F5"
             :unzip    true)
   (sift :move {#"^medium-editor-([\d\.]*)/dist/js/medium-editor\.js"
                "cljsjs/medium_editor/development/medium-editor.inc.js" 
                #"^medium-editor-([\d\.]*)/dist/js/medium-editor\.min\.js"
                "cljsjs/medium_editor/production/medium-editor.min.inc.js"

                #"^medium-editor-([\d\.]*)/dist/css/medium-editor\.css"
                "cljsjs/medium_editor/common/medium-editor.css"
                #"^medium-editor-([\d\.]*)/dist/css/medium-editor\.min\.css"
                "cljsjs/medium_editor/common/medium-editor.min.css"

                #"^medium-editor-([\d\.]*)/dist/css/themes/bootstrap\.css"
                "cljsjs/medium_editor/common/themes/bootstrap.css"
                #"^medium-editor-([\d\.]*)/dist/css/themes/bootstrap\.min\.css"
                "cljsjs/medium_editor/common/themes/bootstrap.min.css"

                #"^medium-editor-([\d\.]*)/dist/css/themes/default\.css"
                "cljsjs/medium_editor/common/themes/default.css"
                #"^medium-editor-([\d\.]*)/dist/css/themes/default\.min\.css"
                "cljsjs/medium_editor/common/themes/default.min.css"

                #"^medium-editor-([\d\.]*)/dist/css/themes/flat\.css"
                "cljsjs/medium_editor/common/themes/flat.css"
                #"^medium-editor-([\d\.]*)/dist/css/themes/flat\.min\.css"
                "cljsjs/medium_editor/common/themes/flat.min.css"

                #"^medium-editor-([\d\.]*)/dist/css/themes/mani\.css"
                "cljsjs/medium_editor/common/themes/mani.css"
                #"^medium-editor-([\d\.]*)/dist/css/themes/mani\.min\.css"
                "cljsjs/medium_editor/common/themes/mani.min.css"

                #"^medium-editor-([\d\.]*)/dist/css/themes/roman\.css"
                "cljsjs/medium_editor/common/themes/roman.css"
                #"^medium-editor-([\d\.]*)/dist/css/themes/roman\.min\.css"
                "cljsjs/medium_editor/common/themes/roman.min.css"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.medium-editor"
              :requires [])
   (pom)
   (jar)))
