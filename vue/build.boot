(set-env!
    :resource-paths #{"resources"}
    :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.5.2")
(def +version+ (str +lib-version+ "-0"))

(def npm-project {'cljsjs/vue "vue"})

(task-options!
 pom  {:project     'cljsjs/vue
       :version     +version+
       :description "Simple, Fast & Composable MVVM for building interactive interfaces"
       :url         "https://vuejs.org/"
       :license {"MIT" "http://opensource.org/licenses/MIT"}
       :scm         {:url "https://github.com/cljsjs/packages"}
       })



(deftask package []
  (comp
    (download :url (str "https://cdnjs.cloudflare.com/ajax/libs/vue/" +lib-version+ "/vue.js")
              :checksum "44BEDB6FFC6872187ABDA1279C998E4B")
    (download :url (str "https://cdnjs.cloudflare.com/ajax/libs/vue/" +lib-version+  "/vue.min.js")
              :checksum "49756328F0029F3D41BD6416F06D6FC5")
    (sift :move {#"^vue.js$"      "cljsjs/vue/development/vue.inc.js"
                 #"^vue.min.js" "cljsjs/vue/production/vue.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.vue")
    (pom)
(jar)))