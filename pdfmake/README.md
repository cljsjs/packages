# cljsjs/pdfmake

[](dependency)
```clojure
[cljsjs/pdfmake "0.1.24-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.pdfmake
            cljsjs.pdfmakefonts ;; default fonts
            ))
```
Documentation for the pdfmake lib can be found [here](http://pdfmake.org)

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies

