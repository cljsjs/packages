# cljsjs/fela-plugin-prefixer

[](dependency)
```clojure
[cljsjs/fela-plugin-prefixer "4.3.2-0"] ;; latest release
```
[](/dependency)

After adding the above dependency to your project you can require the packaged library like so:

```clojure
(ns application.core
  (:require
    cljsjs.fela 
    cljsjs.fela-plugin-prefixer))
```

# Example

```clojure
(.createRenderer js/Fela #js{:plugins (apply array [(js/FelaPluginPrefixer)])})
```
