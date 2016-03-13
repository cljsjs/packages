(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.14.4")
(def +version+ (str +lib-version+ "-0"))

(def checksums
  {'cljsjs/react {:dev "50E03B4FAF89567CB8CB6756442C3D3F"
                  :min "0E2ADA0AF3C7DB76F14CF1FD2BE7A004"}
   'cljsjs/react-with-addons {:dev "73036B1C9BD246D3A6AD5A7CDC06BF24"
                              :min "D637FE5BABCE3FC79E65FB363F374420"}
   'cljsjs/react-dom {:dev "A6D089C3E0C34D37ADCD600A34FA5B47"
                      :min "5A7BD8595390192BF55B9497BBE50638"}
   'cljsjs/react-dom-server {:dev "3EC4E9162AC9DADA8EEDA959974221E2"
                             :min "E572430583C18985BDBEC957CA99EEB8"}})

(task-options!
 pom  {:project     'cljsjs/react
       :version     +version+
       :description "A Javascript library for building user interfaces"
       :url         "http://facebook.github.io/react/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

;; TODO: Should eventually be included in boot.core
(defn with-files
  "Runs middleware with filtered fileset and merges the result back into complete fileset."
  [p middleware]
  (fn [next-handler]
    (fn [fileset]
      (let [merge-fileset-handler (fn [fileset']
                                    (next-handler (commit! (assoc fileset :tree (merge (:tree fileset) (:tree fileset'))))))
            handler (middleware merge-fileset-handler)
            fileset (assoc fileset :tree (reduce-kv
                                          (fn [tree path x]
                                            (if (p x)
                                              (assoc tree path x)
                                              tree))
                                          (empty (:tree fileset))
                                          (:tree fileset)))]
        (handler fileset)))))

(defn package-part [{:keys [extern-name namespace project dependencies requires]}]
  (with-files (fn [x] (= extern-name (.getName (tmp-file x))))
    (comp
      (download :url (format "http://fb.me/%s-%s.js" (name project) +lib-version+)
                :checksum (:dev (get checksums project)))
      (download :url (format "http://fb.me/%s-%s.min.js" (name project) +lib-version+)
                :checksum (:min (get checksums project)))
      (sift :move {(re-pattern (format "^%s-%s.js$" (name project) +lib-version+))     (format "cljsjs/%1$s/development/%1$s.inc.js" (name project))
                   (re-pattern (format "^%s-%s.min.js$" (name project) +lib-version+)) (format "cljsjs/%1$s/production/%1$s.min.inc.js" (name project))})
      (sift :include #{#"^cljsjs"})
      (deps-cljs :name namespace :requires requires)
      (pom :project project :dependencies (or dependencies []))
      (jar))))

(deftask package-react []
  (package-part
    {:extern-name "react.ext.js"
     :namespace "cljsjs.react"
     :project 'cljsjs/react}))

(deftask package-dom []
  (package-part
    {:extern-name "react-dom.ext.js"
     :namespace "cljsjs.react.dom"
     :requires ["cljsjs.react"]
     :project 'cljsjs/react-dom
     :dependencies [['cljsjs/react +version+]]}))

(deftask package-dom-server []
  (package-part
    {:extern-name "react-dom-server.ext.js"
     :namespace "cljsjs.react.dom.server"
     :requires ["cljsjs.react"]
     :project 'cljsjs/react-dom-server
     :dependencies [['cljsjs/react +version+]]}))

(deftask package-with-addons []
  (package-part
    {:extern-name "react.ext.js"
     :namespace "cljsjs.react"
     :project 'cljsjs/react-with-addons}))

(deftask package []
  (comp
    (package-react)
    (package-dom)
    (package-dom-server)
    (package-with-addons)))
