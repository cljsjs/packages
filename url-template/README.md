# cljsjs/url-template

[](dependency)
```clojure
[cljsjs/url-template "2.0.8-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can use the packaged library like this:

```clojure
(ns application.core
  (:require cljsjs.url-template))

(let [email-url (js/urltemplate.parse "/{email}/{folder}/{id}")]
  (.expand email-url {"email"  "user@domain"
                      "folder" "test"
                      "id"     42"}))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
