# cljsjs/highlight

[](dependency)
```clojure
[cljsjs/highlight "8.4.0-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like:

```clojure
(ns application.core
  (:require [cljsjs.highlight]))
```

This package highlights the following languages:
- CSS
- HTTP
- JavaScript
- Ruby
- Bash
- Makefile
- SQL
- Diff
- JSON
- Markdown
- HTML, XML
- Java
- Python
- Clojure
- Clojure REPL
- Haml
- Haskell
- SCSS

[flibs]: https://github.com/clojure/clojurescript/wiki/Foreign-Dependencies
