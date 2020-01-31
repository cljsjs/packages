(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                 [cljsjs/react-dom "15.4.2-2"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "0.10.0")
(def +lib-folder+ (format "relay-%s" +lib-version+))
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-relay
       :version     +version+
       :description "Relay is a JavaScript framework for building data-driven React applications."
       :url         "https://facebook.github.io/relay/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "https://github.com/facebook/relay/blob/master/LICENSE"}})

(deftask build-relay []
  (let [tmp (boot/tmp-dir!)]
    (with-pre-wrap
      fileset
      ;; Copy all files in fileset to temp directory
      (doseq [f (->> fileset boot/input-files)
              :let [target (io/file tmp (tmpd/path f))]]
        (io/make-parents target)
        (io/copy (tmpd/file f) target))
      (binding [boot.util/*sh-dir* (str (io/file tmp +lib-folder+))]
        ((sh "npm" "install"))
        ((sh "npm" "install" "gulp"))
        ((sh (str (io/file tmp +lib-folder+ "node_modules" ".bin" "gulp")))))
      (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
  (task-options! push {:ensure-branch nil})
  (comp
   (download :url (str "https://github.com/facebook/relay/archive/v" +lib-version+ ".zip")
             :checksum "f80ccaaa607083824b2654e27736c6a7"
             :unzip true)
   (build-relay)
   (sift :move {#"^.*relay\.js$" "cljsjs/react-relay/development/react-relay.inc.js"
                #"^.*relay\.min\.js$" "cljsjs/react-relay/production/react-relay.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.react-relay"
              :requires ["cljsjs.react" "cljsjs.react.dom"])
   (pom)
   (jar)))
