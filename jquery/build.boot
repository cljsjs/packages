(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +app-info+
  {:project     'cljsjs/jquery
   :description "The Write Less, Do More, JavaScript Library."
   :url         "http://jquery.com/"
   :license     {"MIT" "http://opensource.org/licenses/MIT"}
   :scm         {:url "https://github.com/cljsjs/packages"}})

(defn- -package [& {:keys [version dev-opts min-opts]}]
  (task-options! pom (assoc +app-info+ :version version))
  (comp
    (download :url (:url dev-opts) :checksum (:checksum dev-opts))
    (download :url (:url min-opts) :checksum (:checksum min-opts))
    (sift :move {#"jquery-([\d\.]*).js" "cljsjs/development/jquery.inc.js"
                 #"jquery-([\d\.]*).min.js" "cljsjs/production/jquery.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.jquery")))

(defn- jquery-url [suffix]
  (str "http://code.jquery.com/jquery-" suffix ".js"))

(deftask package-v1 []
  (-package
    :version  "1.11.3-0"
    :dev-opts {:url (jquery-url "1.11.3")     :checksum "7F38DCBFB11AFF050652FF3B754ADB63"}
    :min-opts {:url (jquery-url "1.11.3.min") :checksum "895323ED2F7258AF4FAE2C738C8AEA49"}))

(deftask package-v2 []
  (-package
    :version  "2.1.4-0"
    :dev-opts {:url (jquery-url "2.1.4")     :checksum "107FBE9555BFC88EC5CAB524C790FE34"}
    :min-opts {:url (jquery-url "2.1.4.min") :checksum "F9C7AFD05729F10F55B689F36BB20172"}))

(deftask package
  "Package the latest known version"
  []
  (package-v2))
