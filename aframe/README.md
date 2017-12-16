# cljsjs/aframe

[](dependency)
```clojure
[cljsjs/aframe "0.7.0-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

Ran [CDNJS](https://cdnjs.com/libraries/aframe)'s version [A-Frame distribution](https://cdnjs.cloudflare.com/ajax/libs/aframe/0.7.0/aframe-master.js)

Changed 50 instances of ` - ` in the generated externs to `.` using Vim regular expressions

<!-- The generated A-Frame externs includes 50 instances of `<x> - <y>`, changed into `['<x>-<y>']` -->
<!-- with the follow regular expressions in Vim: -->
<!--  -->
<!-- - `%s/\v.(\w+) - (\w+)./['\1-\2'].` -->
<!-- Then followed by this to fix names with two dashes in their name (as in 'oculus-touch-controls') -->
<!-- - `%s/\v\']\.- (\w+)./-\1'].` -->
<!--  -->
<!-- The A-Frame source includes 42 instances of attempting to assing variables with `-`'s in their names. These were changed in Vim using the following regular expression: `%s/\v.(\w+) - (\w+)/['\1-\2']` -->

```clojure
(ns application.core
  (:require cljsjs.aframe))
```

Uses externs generated with by [`jmmk`'s Javascript Externs Generator'](https://github.com/jmmk/javascript-externs-generator).

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
