(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]
                  ])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.7.5")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/mathjax
       :version     +version+
       :description "Open source JS display engine for LaTeX, MathML, and AsciiMath notation."
       :url         "https://www.mathjax.org"
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (task-options! push {:ensure-branch nil})
  (comp
    (download
      :url (format "https://unpkg.com/mathjax@%s/MathJax.js" +lib-version+)
      :checksum "C32A502B8B4A6BD6BAD8DDB1B59E9E72"
      :target "cljsjs/production/mathjax.min.inc.js")
    
    (download
      :url (format "https://unpkg.com/mathjax@%s/unpacked/MathJax.js" +lib-version+)
      :checksum "2DFBA9D521236EB1FE3BBEE611B0FC2C"
      :target "cljsjs/development/mathjax.inc.js")
    
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.mathjax")
    (pom)
    (jar)))
