# cljsjs/react-timer-mixin

[react-timer-mixin](https://github.com/reactjs/react-timer-mixin) provides timer functions for executing code in the future that are safely cleaned up when the component unmounts.

[](dependency)
```clojure
[cljsjs/react-timer-mixin "0.13.2-0"] ;; latest release
```
[](/dependency)
This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.react-timer-mixin))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
