# cljsjs/js-beautify

[](dependency)
```clojure
[cljsjs/js-beautify "1.6.2-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require and use the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.js-beautify))

(def asset-loader js/js_beautify)
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Foreign-Dependencies
