(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.7.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/cropper
        :version     +version+
        :description "JavaScript image cropper"
        :url         "https://fengyuanchen.github.io/cropperjs"
        :scm         {:url "https://github.com/cljsjs/packages"}
        :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download
      :url (str "https://github.com/fengyuanchen/cropperjs/archive/v" +lib-version+ ".zip")
      :checksum "3B28C753B5D7BDBED49B6B8CD4F6249D"
      :unzip true)
    (sift :move {#"^cropperjs-(.*)/dist/cropper.js"      "cljsjs/development/cropper.inc.js"
                 #"^cropperjs-(.*)/dist/cropper.min.js"  "cljsjs/production/cropper.min.inc.js"
                 #"^cropperjs-(.*)/dist/cropper.css"     "cljsjs/common/cropper.css"
                 #"^cropperjs-(.*)/dist/cropper.min.css" "cljsjs/common/cropper.min.css"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.cropper")
    (pom)
    (jar)))
