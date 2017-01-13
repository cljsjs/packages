(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.4" :scope "test"]
                  [cljsjs/moment    "2.9.0-0"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "2.9.0-0")

(task-options!
  pom  {:project     'cljsjs/moment-locale-pt-br
        :version     +version+
        :description "The pt-BR locale for moment.js"
        :url         "https://github.com/moment/moment"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download :url      "https://github.com/moment/moment/archive/2.9.0.zip"
              :checksum "ee7c9584c71459c2c701645a7164a890"
              :unzip    true)
    (sift :move {#"^moment-.*/locale/pt-br.js" "cljsjs/development/moment-locale-pt-br.inc.js"})
    (minify :in  "cljsjs/development/moment-locale-pt-br.inc.js"
            :out "cljsjs/production/moment-locale-pt-br.min.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name     "cljsjs.moment-locale-pt-br"
               :requires ["cljsjs.moment"])))


