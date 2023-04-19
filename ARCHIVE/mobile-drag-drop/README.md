# cljsjs/mobile-drag-drop

[](dependency)
```clojure
[cljsjs/mobile-drag-drop "2.3.0-rc.1-0"] ;; latest release
```

[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler.

After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require
    [cljsjs.mobile-drag-drop]
    ;; Require search-behaviour if needed
    [cljsjs.mobile-drag-drop.search-behaviour]))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
