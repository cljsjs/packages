# cljsjs/reactstrap

[](dependency)
```clojure
[cljsjs/react-chartjs-2 "2.0.5-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require [cljsjs.react-chartjs-2]))
```

Documentation for the react-chartjs-2 lib can be found [here](https://github.com/gor181/react-chartjs-2)

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
