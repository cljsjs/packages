# cljsjs/raven

[](dependency)
```clojure
[cljsjs/raven "2.1.0-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.raven))
```

Documentation for the raven-js lib can be found [on its github page](https://github.com/getsentry/raven-js)

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
