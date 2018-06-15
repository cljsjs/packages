# cljsjs/mixpanel

[](dependency)
```clojure
[cljsjs/mixpanel "2.22.4-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.mixpanel))
```

Documentation for the mixpanel lib can be found [on its GitHub page](https://github.com/mixpanel/mixpanel-js)

## EXTERN NOTE

The javascript-externs-generator does _not_ pick up the "people" property,
it is added to the extern file manually in order to preserve the names of
its properties.

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
