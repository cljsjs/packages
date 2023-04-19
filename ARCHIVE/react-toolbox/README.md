# cljsjs/react-toolbox - Bootstrap your application with beautiful Material Design Components

React Toolbox depends on React with Addons, so, to be able to use it, you not only have to depend in
cljsjs/react-toolbox:

[](dependency)
```clojure
[cljsjs/react-toolbox "2.0.0-beta.7-0"] ;; latest release
```
[](/dependency)

But you also need to skip react and use react-with-addons instead when requesting reagent or any other library that
depends on react directly:

```clojure
[reagent "0.6.0" :exclusions [cljsjs/react]]
[cljsjs/react-with-addons "15.2.1-0"]
[cljsjs/react-toolbox "2.0.0-beta.6-0"]
```

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like:

```clojure
(ns application.core
  (:require [cljsjs.react-toolbox]))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps

If you are using Reagent, a wrapper for this cljsjs library is being developed that will provide ready to use well
documented Reagent components: [Reagent Toolbox](https://github.com/dashmantech/reagent-toolbox).
