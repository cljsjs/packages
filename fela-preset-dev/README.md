# cljsjs/fela-preset-dev

[](dependency)
```clojure
[cljsjs/fela-preset-dev "4.3.5-0"] ;; latest release
```
[](/dependency)

After adding the above dependency to your project you can require the packaged library like so:

```clojure
(ns application.core
  (:require
    cljsjs.fela
    cljsjs.fela-preset-dev))
```

# Example

```clojure
(.createRenderer js/Fela #js {:plugins js/FelaPresetDev})
```
