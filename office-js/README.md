# cljsjs/office-js

Wraps https://www.npmjs.com/package/@microsoft/office-js which serves the foundation for Office APIs in JavaScript.

[](dependency)
```clojure
[cljsjs/office-js "1.1.8-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.office-js))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps

## Further Links

Source code can be inspected here
https://unpkg.com/@microsoft/office-js/
