# cljsjs/lamejs

[](dependency)
```clojure
[cljsjs/lamejs "1.1.0-0"] ;; latest release
```
[](/dependency)

This JAR comes with `deps.cljs`, as used by the [Foreign Libs][flibs]
feature of the ClojureScript compiler. After adding the above dependency
to your project, you can require the packaged `lamejs` library as
follows:

```clojure
(ns application.core
  (:require [cljsjs.lamejs]))

;; Somewhere in your code

(let [encoder (js/lamejs.Mp3Encoder. 1 44100 128)
      samples (Int16Array. 44100)]
  (.encodeBuffer encoder samples))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies

