# cljsjs/dom4

[](dependency)
```clojure
[cljsjs/dom4 "1.5.2-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.dom4))
```

`dom4` polyfills DOM4 parentNodes/childNodes entries.

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
