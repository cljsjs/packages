# cljsjs/js-beautify

[](dependency)
```clojure
[cljsjs/js-beautify "1.6.8-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require and use the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.js-beautify))

(def asset-loader js/js_beautify)
```

```clojure
(ns application.core
  (:require cljsjs.js-beautify.html))

(def asset-loader js/html_beautify)
```

```clojure
(ns application.core
  (:require cljsjs.js-beautify.css))

(def asset-loader js/css_beautify)
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
