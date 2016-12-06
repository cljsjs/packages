# cljsjs/sdp

[sdp-transform](https://github.com/clux/sdp-transform) is a simple parser and writer for the not-so-simple webrtc Session Description Protocol [boondoggle]("https://en.wikipedia.org/wiki/Boondoggle").

[](dependency)
```clojure
[cljsjs/sdp "1.6.2-0"] ;; latest release
```
[](/dependency)
This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.sdp))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
