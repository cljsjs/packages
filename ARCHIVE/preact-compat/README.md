# cljsjs/preact

[](dependency)
```clojure
[cljsjs/preact-compat "3.17.0-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns your-ns
  (:require [cljsjs.preact-compat]))

```

This package also provides namespaces `cljsjs.react` and `cljsjs.react.dom`, which
means that this should provide drop-in replacement for React for use with Reagent
and other React wrappers.

To replace React with Preact, you should add global exclusion to `cljsjs/react`,
`cljsjs/react-dom` and `cljsjs/react-dom-server` packages, and add dependency to this
package.

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
