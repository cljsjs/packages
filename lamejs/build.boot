(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.1.0")
(def +version+     (str +lib-version+ "-0"))
(def +commit+      "e2e418c209caa7f36b9573a8f563425d2e285a57")

(task-options!
  push {:ensure-clean false}
  pom  {:project      'cljsjs/lamejs
        :version      +version+
        :description  "Fast MP3 encoder written in JavaScript"
        :url          "https://github.com/zhuker/lamejs"
        :license      {"LGPL-3.0" "https://opensource.org/licenses/LGPL-3.0"}
        :scm          {:url "https://github.com/zhuker/lamejs"}})

(deftask package
  []
  (comp
    (download
      :url (format "https://github.com/zhuker/lamejs/archive/%s.zip"
                   +commit+)
      :checksum "69BB29E1739C24666D95FFF71E985FA2"
      :unzip true)
    (sift :move {#"^lamejs-[^\/]*/lame.all.js"
                 "cljsjs/development/lame.inc.js"
                 #"^lamejs-[^\/]*/lame.min.js"
                 "cljsjs/production/lame.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.lamejs")
    (pom)
    (jar)))
