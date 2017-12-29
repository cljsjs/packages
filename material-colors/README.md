# cljsjs/material-colors

[](dependency)
```clojure
[cljsjs/material-colors "1.2.5-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like:

```clojure
(ns application.core
  (:require cljsjs.material-colors))
```

See the Javascript [documentation](http://shuheikagawa.com/material-colors/) for more details.

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps

## Maintenance

Updated the version number in build.boot and README.md.

The build.boot will download the matching source from the github archive then minify the extracted js file.

The material-colors.ext.js file was manually created, but only has one entry.
