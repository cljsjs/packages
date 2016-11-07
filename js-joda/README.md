# cljsjs/js-joda

[](dependency)
```clojure
[cljsjs/js-joda "1.1.12"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require and use the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.js-joda))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Foreign-Dependencies
