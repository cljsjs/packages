(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/hashids
        :version     +version+
        :description "A small JavaScript class to generate YouTube-like hashids from one or many numbers. This is a client-side version of Node.js version."
        :url         "https://github.com/ivanakimov/hashids.js"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download :url (format "https://github.com/ivanakimov/hashids.js/archive/%s.zip" +lib-version+)
              :checksum "cafc7be2c2f901cc8fe2cc96292d35dc"
              :unzip true)
    (sift :move {#"^hashids.js-.*/lib/hashids.js" "cljsjs/hashids/development/hashids.inc.js"})
    (sift :move {#"^hashids.js-.*/lib/hashids.min.js" "cljsjs/hashids/production/hashids.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.hashids")
    (pom)
    (jar)))
