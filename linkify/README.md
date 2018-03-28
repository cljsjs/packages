# cljsjs/linkify

[](dependency)
```clojure
[cljsjs/linkify "2.1.4-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.linkify
            cljsjs.linkify-string
            cljsjs.linkify-react
            cljsjs.linkify-polyfill
            cljsjs.linkify-plugin-ticket
            cljsjs.linkify-plugin-mention
            cljsjs.linkify-plugin-hashtag
            cljsjs.linkify-jquery
            cljsjs.linkify-html
            cljsjs.linkify-element))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
