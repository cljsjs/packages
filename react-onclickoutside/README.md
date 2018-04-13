# cljsjs/react-onclickoutside

[](dependency)
```clojure
[cljsjs/react-onclickoutside "6.7.1-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.react-onclickoutside))
```

Then you can add this as a mixin to your react components, or use as a Higher
Order Component, see the [repo][repo] for details.

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
[repo]: https://github.com/Pomax/react-onclickoutside
