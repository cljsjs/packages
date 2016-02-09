# cljsjs/react

```clojure
[cljsjs/react "0.14.3-0"] ;; latest release
```

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.react))
```

# cljsjs/react-with-addons

```clojure
[cljsjs/react-with-addons "0.14.3-0"] ;; latest release
```

**Note that this JAR provides the same `cljsjs/react` module as
cljsjs/react.** This decision has been made to allow swapping regular
React in transitive dependencies with React with addons. If you do have transitive
dependencies on cljsjs/react, such as with om/reagent/etc, you will need to
declare an exclusion for cljsjs/react. An example for leiningen can be found
[here][lein-excl].

## TestUtils

The externs file includes definitions for TestUtils but to use those with `:advanced`
optimizations you'll need to override `:file-min` to use non-minified version:

src/cljs/deps.cljs:
```clj
{:foreign-libs [{:provides ["cljs.react"] :file-min "cljsjs/development/react-with-addons.inc.js"}}
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
[lein-excl]: https://github.com/technomancy/leiningen/blob/master/sample.project.clj#L65
