# cljsjs/humane

[](dependency)
```clojure
[cljsjs/humane "3.2.2-1"] ;; latest release
```
[](/dependency)

ClojureScript package for the [humane.js](humane.js) utility for creating unobtrusive
monolog messages.

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.humane))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
[humane.js]: http://wavded.github.io/humane-js/
