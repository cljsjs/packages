# cljsjs/gl-matrix

## Version Fork Note

The original gl-matrix library is somewhat neglected and has not seen
a proper release in some time, despite multiple crucial bug fixes in
master. This version of cljsjs/gl-matrix is pegged to a fork that is up
to date as of 2015-04-09.

* Original library: https://github.com/toji/gl-matrix
* Fork, purely to release latest version: https://github.com/jenanwise/gl-matrix
* Issue requesting fresh release: https://github.com/toji/gl-matrix/issues/156

## Installation

[](dependency)
```clojure
[cljsjs/gl-matrix "2.3.0-jenanwise-0"] ;; latest release
```
[](/dependency)


## Usage

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
to can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.gl-matrix))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
