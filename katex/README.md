# cljsjs/katex

[](dependency)
```clojure
[cljsjs/katex "0.11.1-0"] ;; latest release
```
[](/dependency)

After adding the above dependency to your project you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.katex))
```

Access the fonts and css bundled in the library like this:

```
    (sift :add-jar {'cljsjs/katex #"cljsjs/katex/development/katex.inc.css"})
    (sift :add-jar {'cljsjs/katex #"cljsjs/katex/common/fonts"})
    (sift :move {#"cljsjs/katex/development/katex.inc.css" "css/katex.inc.css"})
                 #"cljsjs/katex/common/fonts/(.*)"         "fonts/$1"}
```


You can now use ```js/katex```.

