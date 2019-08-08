(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.103.0")
(def +version+ (str +lib-version+ "-1"))

(task-options!
  pom  {:project     'cljsjs/webtorrent
        :version     +version+
        :description "Torrents in the BROWSER!"
        :url         "https://github.com/webtorrent/webtorrent"
        :license     {"MIT" "https://github.com/webtorrent/webtorrent/blob/master/LICENSE"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download :url (format "https://github.com/webtorrent/webtorrent/archive/v%s.zip" +lib-version+)
              :unzip true)
    (sift :move {#"^webtorrent-[^\/]*/webtorrent\.min\.js" "cljsjs/webtorrent/development/webtorrent.inc.js"
                 #"^webtorrent-[^\/]*/webtorrent\.min\.js" "cljsjs/webtorrent/production/webtorrent.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.webtorrent")
    (pom)
    (jar)
    (validate)))
