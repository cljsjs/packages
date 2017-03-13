# cljsjs/reactstrap

[](dependency)
```clojure
[cljsjs/reactstrap "4.2.0-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require [cljsjs.reactstrap]))
```

Additionally, this library requires some React Addons. To add React Addons to your project, require 
`cljsjs/react-with-addons`. Also ensure that you have excluded all other versions of React. If you don't
exclude other versions of React then the Addons will not be included in the build and you will get
errors when using Reactstrap.

Documentation for the Reactstrap lib can be found [here](https://reactstrap.github.io/)

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
