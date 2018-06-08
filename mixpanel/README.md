# cljsjs/mixpanel

[](dependency)
```clojure
[cljsjs/mixpanel "2.22.4-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.mixpanel))
```

Documentation for the slate lib can be found [on its GitHub page](https://github.com/mixpanel/mixpanel-js)

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
