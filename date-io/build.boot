(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.3.8")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/date-io
      :version     +version+
      :description "Abstraction over common javascript date management libraries."
      :url         "https://github.com/dmtrKovalenko/date-io"
      :scm         {:url "https://github.com/cljsjs/packages"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (run-commands :commands [["npm" "install" "--include-dev"]
                            ["npm" "run" "build:dev"]
                            ["npm" "run" "build:prod"]
                            ["rm" "-rf" "./node_modules"]])
   (sift :move {#".*date-io.inc.js"     "cljsjs/date-io/development/date-io.inc.js"
                #".*date-io.min.inc.js" "cljsjs/date-io/production/date-io.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :foreign-libs [{:file #"date-io.inc.js"
                              :file-min #"date-io.min.inc.js"
                              :provides ["@date-io/moment"
                                         "@date-io/date-fns"
                                         "@date-io/luxon"
                                         "@date-io/dayjs"
                                         ;; old names
                                         "date-io-moment"
                                         "date-io-date-fns"
                                         "date-io-luxon"
                                         "date-io-dayjs"]
                              :global-exports '{;; new names
                                                "@date-io/moment" DateIOMomentUtils
                                                "@date-io/date-fns" DateIODateFnsUtils
                                                "@date-io/luxon" DateIOLuxonUtils
                                                "@date-io/dayjs" DateIODayJsUtils
                                                ;; old names
                                                "date-io-moment" DateIOMomentUtils
                                                "date-io-date-fns" DateIODateFnsUtils
                                                "date-io-luxon" DateIOLuxonUtils
                                                "date-io-dayjs" DateIODayJsUtils}}]
              :externs [#"date-io.ext.js"])
   (pom)
   (jar)
   (validate-checksums)))
