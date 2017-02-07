# cljsjs/antd

[](dependency)
```clojure
[cljsjs/antd "2.6.0-0"] ;; latest release
```
[](/dependency)


This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. after adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require [cljsjs.antd]))
```

This package **does not include antd's CSS!** You can find instructions for
including css [here](https://ant.design/docs/react/install).

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
