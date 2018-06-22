# cljsjs/js-joda-locale_en-us

prebuilt en-US locale addon for js-joda

[](dependency)
```clojure
[cljsjs/js-joda-locale_en-us "1.0.0"] ;; from sha 8e384141cb191c8cbf35b2844cab15ace035f806
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require and use the packaged library like so:

```clojure
(ns application.core
  (:require [cljsjs.js-joda]
            [cljsjs.js-joda-timezone]
            [cljsjs.js-joda-locale_en-us]))
  
  (set! js/JSJoda (.use js/JSJoda js/JSJodaLocale))
  
  (.. js/JSJoda -Locale getAvailableLocales)
  (.. js/JSJoda -Locale -US)
  
   (.. js/JSJoda -DateTimeFormatter
     (ofPattern "dd MMM HH:mm")
     (withLocale (.. js/JSJoda -Locale -US))
     (format (.. js/JSJoda -ZonedDateTime now)))
  

```

## Info on how to build

### Externs

None

### Replacements

None

[flibs]: https://github.com/clojure/clojurescript/wiki/Foreign-Dependencies

