# cljsjs/pouchdb-authentication

[](dependency)
```clojure
[cljsjs/pouchdb-authentication "1.1.1-0"] ;; latest release
```
[](/dependency)

Used pouchdb-authentication from https://github.com/pouchdb-community/pouchdb-authentication/releases/tag/v1.1.1

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.pouchdb-authentication))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps


## Usage

Activate the plugin with:

```clojure
(.plugin js/PouchDB js/PouchAuthentication)
```

## Generating Externs

Externs for this package were generated with [`javascript-externs-generator`](https://github.com/jmmk/javascript-externs-generator):
```shell
generate-extern -f pouchdb-authenticaion-1.1.1.js -n PouchAuthentication -o resources/cljsjs/pouchdb-authentication/common/pouchdb-authentication.ext.js
```
