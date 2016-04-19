(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0"  :scope "test"]])

(require
  '[cljsjs.boot-cljsjs.packaging :refer :all]
  '[boot.core :as boot]
  '[clojure.java.io :as io])

(def +lib-version+ "4.1.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/photoswipe
       :version     +version+
       :description "JavaScript image gallery for mobile and desktop, modular, framework independent"
       :url         "http://photoswipe.com/"
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask generate-ui-dependency []
  (let [tmp (boot/tmp-dir!)
        deps-file (io/file tmp "deps.cljs")
        write-deps-cljs! #(spit deps-file (pr-str %))]
    (boot/with-pre-wrap fileset
      (let [old-deps (->> fileset
                       (boot/input-files)
                       (boot/by-name ["deps.cljs"])
                       (first)
                       (boot/tmp-file)
                       (slurp)
                       (read-string))
            ui-foreign-lib {:file "cljsjs/photoswipe/development/photoswipe-ui-default.inc.js"
                            :file-min "cljsjs/photoswipe/production/photoswipe-ui-default.min.js"
                            :require ["cljsjs.photoswipe"]
                            :provides ["cljsjs.photoswipe-ui-default"]}
            new-deps (update old-deps :foreign-libs conj ui-foreign-lib)]
        (write-deps-cljs! new-deps)
        (-> fileset
          (boot/add-resource tmp)
          (boot/commit!))))))

(deftask package []
  (comp
    (download
      :url (str "https://github.com/dimsemenov/photoswipe/archive/v" +lib-version+ ".zip")
      :checksum "4A619E7F67A17F87DD4F4E219D151BC3"
      :unzip true)
    (sift :move {#"^PhotoSwipe-(.*)/dist/photoswipe.js"
                 "cljsjs/photoswipe/development/photoswipe.inc.js"

                 #"^PhotoSwipe-(.*)/dist/photoswipe.min.js"
                 "cljsjs/photoswipe/production/photoswipe.min.inc.js"

                 #"^PhotoSwipe-(.*)/dist/photoswipe.css"
                 "cljsjs/photoswipe/common/photoswipe.css"})
    (deps-cljs :name "cljsjs.photoswipe")

    ;; PhotoSwipe Default UI
    (sift :move {#"^PhotoSwipe-(.*)/dist/photoswipe-ui-default.js"
                 "cljsjs/photoswipe/development/photoswipe-ui-default.inc.js"

                 #"^PhotoSwipe-(.*)/dist/photoswipe-ui-default.min.js"
                 "cljsjs/photoswipe/production/photoswipe-ui-default.min.inc.js"

                 #"^PhotoSwipe-(.*)/dist/default-skin/(.+)$"
                 "cljsjs/photoswipe/common/$2"})
    (generate-ui-dependency)

    (sift :include #{#"^cljsjs" #"^deps\.cljs$"})
    (pom)
    (jar)))
