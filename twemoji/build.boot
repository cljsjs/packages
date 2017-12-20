(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.9.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.4.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project 'cljsjs/twemoji
      :version +version+
      :description "Twitter Emoji for Everyone"
      :url "http://twitter.github.io/twemoji/"
      :scm {:url "https://github.com/twitter/twemoji"}
      :license {"MIT license" "https://github.com/twitter/twemoji/blob/gh-pages/LICENSE"}})

(defn download-url [version filename]
  (format "http://twemoji.maxcdn.com/2/%s?%s" filename version))

(defn twemoji-files [version]
  {:js {:name "twemoji.js"
        :url (download-url version "twemoji.js")
        :md5 "241425f7ffff6596f2d19ced513b1f0b"}
   :js-min {:name "twemoji.min.js"
            :url (download-url version "twemoji.min.js")
            :md5 "31c1cef739d66a89d78d6857f5e697c8"}})

(defn download-files [version]
  (let [files (twemoji-files version)]
    (apply comp
      (for [{:keys [name url md5]} (vals files)]
        (download :name name :url url :checksum md5)))))

(deftask package []
  (comp (download-files +lib-version+)
        (sift :move {#"twemoji.js" "cljsjs/twemoji/development/twemoji.inc.js"
                     #"twemoji.min.js" "cljsjs/twemoji/production/twemoji.min.inc.js"})
        (deps-cljs :name "cljsjs.twemoji")
        (pom)
        (show :fileset true)
        (jar)))
