(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.11" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def material-version "1.0.4")
(def +version+ (str material-version "-0"))
(bootlaces! +version+)

(task-options!
  pom {:project     'cljsjs/material
       :version     +version+
       :description "Material Design Lite is a lightweight HTML, CSS and JS framework for sites that follow Google's Material Design guidelines."
       :url         "https://www.getmdl.io"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Apache-2.0" "http://opensource.org/licenses/Apache-2.0"}})

(deftask package []
  (task-options! push {:ensure-branch nil})
  (comp
    (download :url (str "https://storage.googleapis.com/code.getmdl.io/" material-version "/mdl.zip")
              :checksum "e6883041f5cf44642b1539ecf5a25f9c"
              :unzip true)
    (sift :move {#"^material\.js$"        "cljsjs/material/development/material.inc.js"
                 #"^material\.css$"        "cljsjs/material/development/material.inc.css"
                 #"^material\.min\.js$"   "cljsjs/material/production/material.min.inc.js"
                 #"^material\.min\.css$" "cljsjs/material/production/material.min.inc.css"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.material")))
