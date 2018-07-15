# cljsjs/meta-mascara
An Ethereum keychain manager for Ethereum DAPPs.

[Metamask](https://metamask.io/) is a browser extension that manages Ethereum keychains.

[Mascara](https://github.com/MetaMask/mascara) is the library designed to:

> Add MetaMask to your dapp even if the user doesn't have the extension installed


[](dependency)
```clojure
[cljsjs/meta-mascara "2.2.1-0"]
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.meta-mascara))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
