# cljsjs/aws-sdk-js

[](dependency)
```clojure
[cljsjs/aws-sdk-js "2.2.41-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.aws-sdk-js))
```

Documentation for the aws-sdk-js lib can be found [on its github page](https://github.com/aws/aws-sdk-js)

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
