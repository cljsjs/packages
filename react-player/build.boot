(def +lib-version+ "1.5.1")
(def +version+ (str +lib-version+ "-0"))

(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.9.0" :scope "test"]
                  [cljsjs/react "16.0.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
 pom  {:project     'cljsjs/react-player
       :version     +version+
       :description "A React component for playing a variety of URLs, including file paths, YouTube, Facebook, Twitch, SoundCloud, Streamable, Vimeo, Wistia and DailyMotion"
       :url         "https://github.com/CookPete/react-player"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (str "https://unpkg.com/react-player@1.5.1/dist/ReactPlayer.js"))

    (sift :move {#"^ReactPlayer.js$" "cljsjs/react-player/development/react-player.inc.js"})

    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react-player"
               :requires ["cljsjs.react"])
    (pom)
    (jar)
    (validate-checksums)))
