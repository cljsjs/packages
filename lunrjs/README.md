# cljsjs/lunrjs

This is a cljsjs package for https://github.com/olivernn/lunr.js

[](dependency)
```clojure
[cljsjs/lunrjs "2.1.5-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.lunrjs))

;; call lunr rather than lunrjs
(js/lunr (fn [] ...))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
