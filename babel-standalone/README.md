# cljsjs/babel-standalone

[](dependency)
```clojure
[cljsjs/babel-standalone "6.18.1-3"] ;; latest release
```
[](/dependency)

## Use as ClojureScript preprocessor

This package provides [Babel-standalone](https://github.com/babel/babel-standalone) for use with ClojureScript
[foreign library preprocessing](https://clojurescript.org/guides/javascript-modules#babel-transforms).
In addition to the file (`cljsjs/babel-standalone/production/babel.min.js`), the package
provides namespace [`cljsjs.babel-standalone`](./src/cljsjs/babel_standalone.clj)
which provides `cljsjs.closure/js-transforms` implementation `:cljsjs.babel-standalone/babel` which you can
use by requiring the namespace in your `build.clj` or similar.

[Babel options](http://babeljs.io/docs/usage/api/#options) can be provided on the
foreign library map using property `:cljsjs.babel-standalone/babel-opts`:

```clojure
:foreign-libs [{:file "src"
                :module-type :es6
                :preprocess :cljsjs.babel-standalone/babel
                :cljsjs.babel-standalone/babel-opts {:presets ["react" "es2016"]}}]
```

Or in next ClojureScript version:

```clojure
:foreign-libs
  [{:file "src"
    :module-type :es6
    ;; changed
    ;; notice that the symbol should not be quoted in project.clj or .cljs.edn
    :preprocess 'cljsjs.babel-standalone/transform
    :cljsjs.babel-standalone/babel-opts {:presets ["react" "es2016"]}}]
```

## Use in browsers

While Babel-standalone can also be used in browser, this package does not currently
provide `deps.cljs` with foreign-library declaration or extern files.
