# cljsjs/react-onclickoutside

[](dependency)
```clojure
[cljsjs/react-onclickoutside "4.9.0-2"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.react-onclickoutside))
```

Then you can add this as a mixin to your react components, or use as a Higher
Order Component, see the [repo][repo] for details.

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
[repo]: https://github.com/Pomax/react-onclickoutside
