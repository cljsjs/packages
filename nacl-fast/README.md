# cljsjs/nacl-fast

[](dependency)
```clojure
[cljsjs/nacl-fast "1.0.0-rc.1-0"] ;; latest release
```
[](/dependency)

CLJSJS wrapper for the optimized implementation of [TweetNaCl.js](https://github.com/dchest/tweetnacl-js), a JavaScript port of [TweetNaCl](https://tweetnacl.cr.yp.to/) by djb featuring curve25519 EC crypto.

After adding the above dependency to your project you can require the packaged
library like so:

```clojure
(ns application.core
  (:require cljsjs.nacl-fast))
```

And access the global `nacl` object.
