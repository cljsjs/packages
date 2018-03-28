# cljsjs/react-three-renderer

https://toxicfork.github.com/react-three-renderer-example/

[](dependency)
```clojure
[cljsjs/react-three-renderer "3.2.3-0"] ;; latest release
```
[](/dependency)

## Generating Externs

The extern generation depends on:

* react.inc.js
* react-dom.inc.js
* three.inc.js
* react-three-renderer.inc.js

## Usage

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.react-three-renderer))

;; Access react-three-renderer
js/React3
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
