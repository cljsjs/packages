# cljsjs/document-register-element

[](dependency)
```clojure
[cljsjs/document-register-element "0.2.1-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

`document-register-element` polyfills the Custom Elements specification. Related methods are already defined in externs packaged by the closure compiler thus this module is extern free.

```clojure
(ns application.core
  (:require cljsjs.document-register-element))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Foreign-Dependencies
