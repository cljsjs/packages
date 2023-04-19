# cljsjs/enzyme

https://github.com/airbnb/enzyme

[](dependency)
```clojure
[cljsjs/enzyme "3.8.0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.enzyme))
```

Note that this package is configured with the `enzyme-adapter-react-16` adapter - compatible with react `^16.4.0`.
If other enzyme adapter versions are required, this package may need to be restructured.
