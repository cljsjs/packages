# cljsjs/react-with-addons

[](dependency)
```clojure
[cljsjs/react-with-addons "0.12.2-5"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
to can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.react))
```

**Note that this JAR provides the same `cljsjs/react` module as
cljsjs/react.** This decision has been made to allow swapping regular
React in transitive dependencies with React with addons.

[flibs]: https://github.com/clojure/clojurescript/wiki/Foreign-Dependencies

