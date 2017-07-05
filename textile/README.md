# cljsjs/textile

[](dependency)
```clojure
[cljsjs/textile "2.0.3-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.textile))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies

## Upgrading

When upgrading textile, you need to regenerate the externs:
1. Go to https://cdnjs.com/libraries/textile-js/<THE-VERSION> such as https://cdnjs.com/libraries/textile-js/2.0.3
2. Find the URL for textile.js, such as: https://cdnjs.cloudflare.com/ajax/libs/textile-js/2.0.3/textile.js
3. Go to http://jmmk.github.io/javascript-externs-generator
4. Paste the URL for textile.js and click load.
5. Name the JavaScript object textile.
6. Click "Extern!"
6. Copy the JavaScript value to resources/cljsjs/textile/common/textile.ext.js.
