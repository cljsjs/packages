# cljsjs/document-register-element

[](dependency)
```clojure
[cljsjs/document-register-element "0.5.3-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.document-register-element))
```

`document-register-element` polyfills the Custom Elements specification. Related methods are already defined in externs packaged by the closure compiler thus this module is extern free.

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
