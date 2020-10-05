# cljsjs/quaternion

[](dependency)
```clojure
[cljsjs/quaternion "1.1.0-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature of
the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.quaternion))
```

This package also supports `:global-exports`:

```clojure
(ns application.core
  (:require [quaternion :as Quaternion]))
```

This works too:

```clojure
(ns application.core
  (:require [cljsjs.quaternion :as Quaternion]))
```

[Quaternion.js][quaternionjs] is a well tested JavaScript library for 3D
rotations. Quaternions can be used everywhere, from the rotation calculation of
your mobile phone over computer games to the rotation of satellites and all by
avoiding the [Gimbal lock][gimballock]. The library comes with examples to make
you get started much quicker without worrying about the math behind.

Example usage from Clojurescript:

```clojure
(ns example.core
  (:require [quaternion :as Quaternion]))

(extend-type Quaternion
  IEquiv
  (-equiv [this other]
    (.equals this other)))

(defn quaternion
  [w x y z]
  (Quaternion. w x y z))

(= (quaternion 2 4 6 8)
   (.add (quaternion 1 2 3 4)
         (quaternion 1 2 3 4)))
;; => true
```

[quaternionjs]: https://github.com/infusion/Quaternion.js
[gimballock]: https://en.wikipedia.org/wiki/Gimbal_lock
