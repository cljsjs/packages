# cljsjs/exif

[](dependency)
```clojure
[cljsjs/exif "2.1.1-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs]
feature of the Clojurescript compiler. After adding the above
dependency to your project you can require the packaged library like
so:

```clojure
(ns application.core
  (:require cljsjs.exif))
```

Here's an example of how to use the exif library to parse metadata
from a javascript File object (the `img` variable in the example below):

```
  (js/EXIF.getData img
   (fn [] (this-as this 
    (let [exifdata (js->clj (.-exifdata this))]
      ;; exifdata will be a clojure map of exif metadata
      ;; that can be used however you need
    ))))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
