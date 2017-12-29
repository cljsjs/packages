# cljsjs/parinfer-codemirror

[](dependency)
```clojure
[cljsjs/parinfer-codemirror "1.4.1-2"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

__NOTE__: `cljsjs/parinfer` and `cljsjs/codemirror` are prerequisite dependencies
for usage below.

```clojure
(ns your-ns
  (:require
    [cljsjs.codemirror]
    [cljsjs.parinfer]
    [cljsjs.parinfer-codemirror]))

(let [cm (js/CodeMirror js/document.body)]
  (js/parinferCodeMirror.init cm))
```


[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
