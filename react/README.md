# cljsjs/react

```clojure
[cljsjs/react "15.4.2-2"] ;; latest release
```

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.react))
```

# cljsjs/react-with-addons

```clojure
[cljsjs/react-with-addons "15.4.2-2"] ;; latest release
```

**Note that this JAR provides the same `cljsjs/react` module as
cljsjs/react.** This decision has been made to allow swapping regular
React in transitive dependencies with React with addons. If you do have transitive
dependencies on cljsjs/react, such as with om/reagent/etc, you will need to
declare an exclusion for cljsjs/react. An example for leiningen can be found
[here][lein-excl].

## TestUtils

The externs file includes definitions for TestUtils but to use those with `:advanced`
optimizations you'll need to override `:file-min` to use non-minified version. In your
ClojureScript compiler options, add:

```clj
:foreign-libs [{:provides ["cljsjs.react"]
               :file "cljsjs/development/react-with-addons.inc.js"
               :file-min "cljsjs/development/react-with-addons.inc.js"}]
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
[lein-excl]: https://github.com/technomancy/leiningen/blob/2fb603b2bfc44255faf721995be1dc70d6ce388d/sample.project.clj#L81
