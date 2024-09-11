# cljsjs/js-joda

[](dependency)
```clojure
[io.github.cljsjs/js-joda "5.6.3-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require and use the packaged library like so:

```clojure
(ns application.core
  (:require ["@js-joda/core" :as js-joda]))

  (.. js-joda -Year)
```

## Info on how to build

### Externs

built with cli of this [externs generator](https://github.com/jmmk/javascript-externs-generator)

and additionally [this custom generator](https://github.com/henryw374/cljs.java-time/blob/master/dev/externs.clj)

### Replacements

None

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
