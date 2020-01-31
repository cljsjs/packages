(def +lib-version+ "1.0.0-rc.1")
(def +version+ (str +lib-version+ "-0"))

(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
 pom  {:project     'cljsjs/nacl-fast
       :version     +version+
       :description "Port of TweetNaCl cryptographic library to JavaScript (fast version)"
       :url         "https://github.com/dchest/tweetnacl-js"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/dchest/tweetnacl-js/archive/" +lib-version+ ".zip")
              :checksum "a8a3189d4feafb49b78c8443a3374d27"
              :unzip true)

    (sift :move {#"^tweetnacl-js-(.*)/nacl-fast.js$" "cljsjs/nacl-fast/development/nacl-fast.inc.js"
                 #"^tweetnacl-js-(.*)/nacl-fast.min.js$" "cljsjs/nacl-fast/production/nacl-fast.min.inc.js"})

    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.nacl-fast")
    (pom)
    (jar)))
