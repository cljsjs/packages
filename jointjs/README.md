# cljsjs/jointjs

This is a cljsjs package for [JointJS](https://github.com/clientIO/joint)

[](dependency)
```clojure
[cljsjs/jointjs "2.2.1-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project 
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.jointjs))
```

Don't forget about dependencies:

```html
<script src="https://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.9.1/underscore-min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/backbone.js/1.3.3/backbone-min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/dagre/0.8.2/dagre.min.js"></script>
<script src="https://unpkg.com/graphlib@2.1.5/dist/graphlib.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/lodash.js/4.17.11/lodash.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
