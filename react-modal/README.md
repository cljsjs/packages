# cljsjs/react-modal

[](dependency)
```clojure
[cljsjs/react-modal "3.4.4-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.react-modal))
```

Calling react modal example
```clojure
(js/React.createElement
    js/ReactModal #js {:contentLabel "myLabel"
                       :isOpen true}
              ...react/react-dom components here...)
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
