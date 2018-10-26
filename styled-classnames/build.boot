(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.2.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/styled-classnames
       :version     +version+
       :description "styled-components without the components"
       :url         "https://github.com/rgdelato/styled-classnames"
       :scm         {:url "https://github.com/rgdelato/styled-classnames"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (format "https://unpkg.com/styled-classnames@%s/build/styled-classnames.umd.js" +lib-version+)
              :checksum "1E4D7718F538F48495DE91349E68F2DC")
    (download :url (format "https://unpkg.com/styled-classnames@%s/build/styled-classnames.umd.min.js" +lib-version+)
              :checksum "E7BAAC0D744C1CFAB281C9E4E48EF7C5")
    (sift :move {#"styled-classnames\.umd\.js" "cljsjs/styled-classnames/development/styled-classnames.inc.js"
                 #"styled-classnames\.umd\.min\.js" "cljsjs/styled-classnames/production/styled-classnames.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.styled-classnames")
    (pom)
    (jar)))
