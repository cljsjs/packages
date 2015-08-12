# cljsjs/codemirror

[](dependency)
```clojure
[cljsjs/codemirror "5.1.0-2"] ;; latest release
```
[](/dependency)

After adding the above dependency to your project you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.codemirror))
```

You can add the following boot tasks to add the css to your project.

```
    (sift :add-jar {'cljsjs/codemirror #"cljsjs/codemirror/development/codemirror.css"})
    (sift :move {#"cljsjs/codemirror/development/codemirror.css" "vendor/codemirror/codemirror.css"})))
```

You can know use ```js/CodeMirror```. See [this project](https://github.com/Jonovono/CodeMirror-cljs/blob/master/src/cljs/codemirror_cljs/core.cljs) for examples of wrapping the ```js/CodeMirror``` javascript object with ClojureScript functions.

And also add require the modes you wish to include:

```
cljsjs.codemirror.mode.apl
cljsjs.codemirror.mode.asciiarmor
cljsjs.codemirror.mode.asterisk
cljsjs.codemirror.mode.clike
cljsjs.codemirror.mode.clojure
cljsjs.codemirror.mode.cmake
cljsjs.codemirror.mode.cobol
cljsjs.codemirror.mode.coffeescript
cljsjs.codemirror.mode.commonlisp
cljsjs.codemirror.mode.css
cljsjs.codemirror.mode.cypher
cljsjs.codemirror.mode.d
cljsjs.codemirror.mode.dart
cljsjs.codemirror.mode.diff
cljsjs.codemirror.mode.django
cljsjs.codemirror.mode.dockerfile
cljsjs.codemirror.mode.dtd
cljsjs.codemirror.mode.dylan
cljsjs.codemirror.mode.ebnf
cljsjs.codemirror.mode.ecl
cljsjs.codemirror.mode.eiffel
cljsjs.codemirror.mode.erlang
cljsjs.codemirror.mode.forth
cljsjs.codemirror.mode.fortran
cljsjs.codemirror.mode.gas
cljsjs.codemirror.mode.gfm
cljsjs.codemirror.mode.gherkin
cljsjs.codemirror.mode.go
cljsjs.codemirror.mode.groovy
cljsjs.codemirror.mode.haml
cljsjs.codemirror.mode.haskell
cljsjs.codemirror.mode.haxe
cljsjs.codemirror.mode.htmlembedded
cljsjs.codemirror.mode.htmlmixed
cljsjs.codemirror.mode.http
cljsjs.codemirror.mode.idl
cljsjs.codemirror.mode.index.html
cljsjs.codemirror.mode.jade
cljsjs.codemirror.mode.javascript
cljsjs.codemirror.mode.jinja2
cljsjs.codemirror.mode.julia
cljsjs.codemirror.mode.kotlin
cljsjs.codemirror.mode.livescript
cljsjs.codemirror.mode.lua
cljsjs.codemirror.mode.markdown
cljsjs.codemirror.mode.meta.js
cljsjs.codemirror.mode.mirc
cljsjs.codemirror.mode.mllike
cljsjs.codemirror.mode.modelica
cljsjs.codemirror.mode.nginx
cljsjs.codemirror.mode.ntriples
cljsjs.codemirror.mode.octave
cljsjs.codemirror.mode.pascal
cljsjs.codemirror.mode.pegjs
cljsjs.codemirror.mode.perl
cljsjs.codemirror.mode.php
cljsjs.codemirror.mode.pig
cljsjs.codemirror.mode.properties
cljsjs.codemirror.mode.puppet
cljsjs.codemirror.mode.python
cljsjs.codemirror.mode.q
cljsjs.codemirror.mode.r
cljsjs.codemirror.mode.rpm
cljsjs.codemirror.mode.rst
cljsjs.codemirror.mode.ruby
cljsjs.codemirror.mode.rust
cljsjs.codemirror.mode.sass
cljsjs.codemirror.mode.scheme
cljsjs.codemirror.mode.shell
cljsjs.codemirror.mode.sieve
cljsjs.codemirror.mode.slim
cljsjs.codemirror.mode.smalltalk
cljsjs.codemirror.mode.smarty
cljsjs.codemirror.mode.solr
cljsjs.codemirror.mode.soy
cljsjs.codemirror.mode.sparql
cljsjs.codemirror.mode.spreadsheet
cljsjs.codemirror.mode.sql
cljsjs.codemirror.mode.stex
cljsjs.codemirror.mode.stylus
cljsjs.codemirror.mode.tcl
cljsjs.codemirror.mode.textile
cljsjs.codemirror.mode.tiddlywiki
cljsjs.codemirror.mode.tiki
cljsjs.codemirror.mode.toml
cljsjs.codemirror.mode.tornado
cljsjs.codemirror.mode.troff
cljsjs.codemirror.mode.turtle
cljsjs.codemirror.mode.vb
cljsjs.codemirror.mode.vbscript
cljsjs.codemirror.mode.velocity
cljsjs.codemirror.mode.verilog
cljsjs.codemirror.mode.xml
cljsjs.codemirror.mode.xquery
cljsjs.codemirror.mode.yaml
cljsjs.codemirror.mode.z80
```



Thanks to @urmuzov for the [extern file](https://raw.githubusercontent.com/urmuzov/closure-externs/master/codemirror.js)
