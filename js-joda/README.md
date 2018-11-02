# cljsjs/js-joda

[](dependency)
```clojure
[cljsjs/js-joda "1.9.2-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require and use the packaged library like so:

```clojure
(ns application.core
  (:require [cljsjs.js-joda]))

  (.. js/JSJoda -Year)
```

## Info on how to build

### Externs

built with cli of this [externs generator](https://github.com/jmmk/javascript-externs-generator)

### Replacements

see build.boot for a variable that needs to be renamed in the DecimalStyle.convertToDigit fn. This can be tested
like so

```
(-> (.. js/JSJoda -DateTimeFormatter)
    (.ofPattern "yyyy-MM-dd")
    (.decimalStyle)
    (.convertToDigit "1"))
```


[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
