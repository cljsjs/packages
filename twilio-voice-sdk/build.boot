(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.4.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'io.github.cljsjs/twilio-voice-sdk
       :version     +version+
       :description "Twilio Voice SDK"
       :url         "https://github.com/twilio/twilio-voice.js"
       :license     {"Apache 2.0" "https://www.apache.org/licenses/LICENSE-2.0"
                     "BSD" "http://opensource.org/licenses/BSD-3-Clause"
                     "MIT" "http://opensource.org/licenses/MIT"}
       :scm         {:url "https://github.com/cljsjs/packages"}})

(defn dist-file [file] (re-pattern (str "^twilio-voice.js-" +lib-version+ "/dist/" file "$")))
(def out-folder "cljsjs/twilio-voice-sdk/")
(defn dev-file [file] (str out-folder "development/" file))
(defn prod-file [file] (str out-folder "production/" file))

(deftask package []
  (comp
   (download :url (format "https://github.com/twilio/twilio-voice.js/archive/refs/tags/%s.zip" +lib-version+)
             :unzip true)

   (sift :move {(dist-file "twilio.js")
                (dev-file "twilio-voice-sdk.inc.js")

                (dist-file "twilio.min.js")
                (prod-file "twilio-voice-sdk.min.inc.js")})

   (deps-cljs :provides ["twilio-voice-sdk" "cljsjs.twilio-voice-sdk"]
              :global-exports '{twilio Twilio})

   (pom)
   (jar)
   (validate)))
