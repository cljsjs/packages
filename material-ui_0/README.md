# cljsjs/material-ui

http://www.material-ui.com/#/

[](dependency)
```clojure
[cljsjs/material-ui "0.20.1-0"] ;; latest release
```
[](/dependency)

#### Important note
`cljsjs/material-ui` comes with its own `cljsjs/react` and `cljsjs/react-dom`. This is because it currently has to
 be built with . Read more [here](http://www.material-ui.com/#/get-started/installation). This won't be needed in a future.
 Important is to put `react` and `react-dom` into `exclusions` in `project.clj` for libraries, which include it.
 For example:

 ```
    [org.omcljs/om "1.0.0-alpha34" :exclusions [cljsjs/react cljsjs/react-dom]]
 ```
 I suggest using


This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.material-ui
                  cljsjs.material-ui-svg-icons))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
