# cljsjs/jsbn

[](dependency)
```clojure
[cljsjs/jsbn "0.1.1-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.jsbn))
```

Documentation for the jsbn lib can be found [here](http://www-cs-students.stanford.edu/~tjw/jsbn/)

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
