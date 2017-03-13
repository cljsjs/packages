(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.1.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/jwt-decode
       :version     +version+
       :description "Decode JWT tokens, mostly useful for browser applications."
       :url         "https://github.com/auth0/jwt-decode"
       :scm         {:url "https://github.com/auth0/jwt-decode"}
       :license     {"MIT" "https://github.com/auth0/jwt-decode/blob/master/LICENSE"}})

(deftask package []
  (comp
    (download
      :url (format "https://github.com/auth0/jwt-decode/archive/v%s.zip" +lib-version+)
      :checksum "56291AD9D58B56334E0E726B5F7EB21D"
      :unzip true)
    (sift :move {#"^jwt-decode.*/build/jwt-decode\.js$"      "cljsjs/auth0/development/jwt-decode.inc.js"
                 #"^jwt-decode.*/build/jwt-decode\.min\.js$" "cljsjs/auth0/production/jwt-decode.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.jwt-decode")
    (pom)
    (jar)))
