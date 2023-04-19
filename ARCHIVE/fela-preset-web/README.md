# cljsjs/fela-preset-web

[](dependency)
```clojure
[cljsjs/fela-preset-web "4.3.5-0"] ;; latest release
```
[](/dependency)

After adding the above dependency to your project you can require the packaged library like so:

```clojure
(ns application.core
  (:require
    cljsjs.fela
    cljsjs.fela-preset-web))
```

# Example

```clojure
(.createRenderer js/Fela #js {:plugins js/FelaPresetWeb})
```
