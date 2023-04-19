# cljsjs/reactcss

[](dependency)
```clojure
[cljsjs/reactcss "1.2.0-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.reactcss))
```

See the Javascript [documentation](http://reactcss.com) for more details.

## Maintenance

Update the version number in build.boot and README.md.

The build.boot will download the matching source from the github archive, bundle using webpack then minify the bundled js file.

The reactcss.ext.js file was manually created.


[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
