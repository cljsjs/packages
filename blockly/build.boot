(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]
                  [javax.xml.bind/jaxb-api "2.1"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

;;; This should track Blockly releases; see https://github.com/google/blockly/releases
(def +lib-version+ "3.20200123.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/blockly
       :version     +version+
       :description "A library that provides a Scratch-like block UI"
       :url         "http://blockly.org/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/google/blockly/archive/" +lib-version+ ".zip")
             :unzip true)
   (sift :move {#"^blockly-.*/blockly\_compressed\.js"  "cljsjs/blockly/development/blockly.inc.js"
                #"^blockly-.*blocks\_compressed\.js"    "cljsjs/blockly/development/blocks.inc.js" 
                ;; Change the following line to include non-English support
                #"^blockly-.*msg/js/en\.js"             "cljsjs/blockly/development/en.inc.js"
                })
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.blockly"
               :foreign-libs [{:file #"blockly\.inc\.js"
                               :provides ["blockly.js" "cljsjs.blockly"]}
                              {:file #"blocks\.inc\.js"
                               :requires ["blockly.js"]
                               :provides ["cljsjs.blockly.blocks"]}
                              {:file #"en\.inc\.js"
                               :requires ["blockly.js"]
                               :provides ["cljsjs.blockly.en"]}]
               :externs [#"blockly\.ext\.js"]
              )
   (pom)
   (jar)
   ))
    

