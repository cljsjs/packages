# cljsjs/jqgrid
[](dependency)
```clojure
[cljsjs/jqgrid "5.0.1-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.jqgrid
            cljsjs.jqgrid.langs.grid.locale-en))
```

Also includes the locale settings for different languages in the following namespaces:

```
cljsjs.jqgrid.langs.grid.locale-ar
cljsjs.jqgrid.langs.grid.locale-bg
cljsjs.jqgrid.langs.grid.locale-ca
cljsjs.jqgrid.langs.grid.locale-cn
cljsjs.jqgrid.langs.grid.locale-cs
cljsjs.jqgrid.langs.grid.locale-de
cljsjs.jqgrid.langs.grid.locale-dk
cljsjs.jqgrid.langs.grid.locale-el
cljsjs.jqgrid.langs.grid.locale-en
cljsjs.jqgrid.langs.grid.locale-es
cljsjs.jqgrid.langs.grid.locale-fa
cljsjs.jqgrid.langs.grid.locale-fi
cljsjs.jqgrid.langs.grid.locale-fr
cljsjs.jqgrid.langs.grid.locale-gl
cljsjs.jqgrid.langs.grid.locale-he
cljsjs.jqgrid.langs.grid.locale-hr
cljsjs.jqgrid.langs.grid.locale-hu
cljsjs.jqgrid.langs.grid.locale-id
cljsjs.jqgrid.langs.grid.locale-is
cljsjs.jqgrid.langs.grid.locale-it
cljsjs.jqgrid.langs.grid.locale-ja
cljsjs.jqgrid.langs.grid.locale-kr
cljsjs.jqgrid.langs.grid.locale-lt
cljsjs.jqgrid.langs.grid.locale-me
cljsjs.jqgrid.langs.grid.locale-nl
cljsjs.jqgrid.langs.grid.locale-no
cljsjs.jqgrid.langs.grid.locale-pl
cljsjs.jqgrid.langs.grid.locale-pt-br
cljsjs.jqgrid.langs.grid.locale-pt
cljsjs.jqgrid.langs.grid.locale-ro
cljsjs.jqgrid.langs.grid.locale-ru
cljsjs.jqgrid.langs.grid.locale-sk
cljsjs.jqgrid.langs.grid.locale-sr
cljsjs.jqgrid.langs.grid.locale-sr-latin
cljsjs.jqgrid.langs.grid.locale-sv
cljsjs.jqgrid.langs.grid.locale-th
cljsjs.jqgrid.langs.grid.locale-tr
cljsjs.jqgrid.langs.grid.locale-tw
cljsjs.jqgrid.langs.grid.locale-uk
cljsjs.jqgrid.langs.grid.locale-vi
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
