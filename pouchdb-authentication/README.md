# cljsjs/pouchdb-authentication

[](dependency)
```clojure
[cljsjs/pouchdb-authentication "0.5.5-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.pouchdb-authentication))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies

## Usage

Activate the plugin with:

```clojure
(.plugin js/PuchDB PouchAuthentication)
```

## Generating Externs

Externs for this package were generated with [`javascript-externs-generator`](https://github.com/jmmk/javascript-externs-generator):
```shell
generate-extern -f pouchdb-authenticaion-0.5.5.js -n PouchAuthentication -o resources/cljsjs/pouchdb-authentication/common/pouchdb-authentication.ext.js
```
