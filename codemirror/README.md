# cljsjs/codemirror

[](dependency)
```clojure
[cljsjs/codemirror "5.11.0-1"] ;; latest release
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

You can now use ```js/CodeMirror```. See [this project](https://github.com/Jonovono/CodeMirror-cljs/blob/master/src/cljs/codemirror_cljs/core.cljs)
for examples of wrapping the ```js/CodeMirror``` javascript object with ClojureScript functions.

Require any of the additional features you wish to include:

- [Addons](#addons)
- [Modes](#modes)
- [KeyMaps](#keymaps)

### Addons

```
cljsjs.codemirror.addon.comment.comment
cljsjs.codemirror.addon.comment.continuecomment
cljsjs.codemirror.addon.dialog.dialog
cljsjs.codemirror.addon.display.autorefresh
cljsjs.codemirror.addon.display.fullscreen
cljsjs.codemirror.addon.display.panel
cljsjs.codemirror.addon.display.placeholder
cljsjs.codemirror.addon.display.rulers
cljsjs.codemirror.addon.edit.closebrackets
cljsjs.codemirror.addon.edit.closetag
cljsjs.codemirror.addon.edit.continuelist
cljsjs.codemirror.addon.edit.matchbrackets
cljsjs.codemirror.addon.edit.matchtags
cljsjs.codemirror.addon.edit.trailingspace
cljsjs.codemirror.addon.fold.brace-fold
cljsjs.codemirror.addon.fold.comment-fold
cljsjs.codemirror.addon.fold.foldcode
cljsjs.codemirror.addon.fold.foldgutter
cljsjs.codemirror.addon.fold.indent-fold
cljsjs.codemirror.addon.fold.markdown-fold
cljsjs.codemirror.addon.fold.xml-fold
cljsjs.codemirror.addon.hint.anyword-hint
cljsjs.codemirror.addon.hint.css-hint
cljsjs.codemirror.addon.hint.html-hint
cljsjs.codemirror.addon.hint.javascript-hint
cljsjs.codemirror.addon.hint.show-hint
cljsjs.codemirror.addon.hint.sql-hint
cljsjs.codemirror.addon.hint.xml-hint
cljsjs.codemirror.addon.lint.coffeescript-lint
cljsjs.codemirror.addon.lint.css-lint
cljsjs.codemirror.addon.lint.html-lint
cljsjs.codemirror.addon.lint.javascript-lint
cljsjs.codemirror.addon.lint.json-lint
cljsjs.codemirror.addon.lint.lint
cljsjs.codemirror.addon.lint.yaml-lint
cljsjs.codemirror.addon.merge.merge
cljsjs.codemirror.addon.mode.loadmode
cljsjs.codemirror.addon.mode.multiplex
cljsjs.codemirror.addon.mode.overlay
cljsjs.codemirror.addon.mode.simple
cljsjs.codemirror.addon.runmode.colorize
cljsjs.codemirror.addon.runmode.runmode-standalone
cljsjs.codemirror.addon.runmode.runmode
cljsjs.codemirror.addon.runmode.runmode.node
cljsjs.codemirror.addon.scroll.annotatescrollbar
cljsjs.codemirror.addon.scroll.scrollpastend
cljsjs.codemirror.addon.scroll.simplescrollbars
cljsjs.codemirror.addon.search.match-highlighter
cljsjs.codemirror.addon.search.matchesonscrollbar
cljsjs.codemirror.addon.search.search
cljsjs.codemirror.addon.search.searchcursor
cljsjs.codemirror.addon.selection.active-line
cljsjs.codemirror.addon.selection.mark-selection
cljsjs.codemirror.addon.selection.selection-pointer
cljsjs.codemirror.addon.tern.tern
cljsjs.codemirror.addon.tern.worker
cljsjs.codemirror.addon.wrap.hardwrap
```

### Modes

```
cljsjs.codemirror.mode.apl
cljsjs.codemirror.mode.asciiarmor
cljsjs.codemirror.mode.asn.1
cljsjs.codemirror.mode.asterisk
cljsjs.codemirror.mode.brainfuck
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
cljsjs.codemirror.mode.elm
cljsjs.codemirror.mode.erlang
cljsjs.codemirror.mode.factor
cljsjs.codemirror.mode.forth
cljsjs.codemirror.mode.fortran
cljsjs.codemirror.mode.gas
cljsjs.codemirror.mode.gfm
cljsjs.codemirror.mode.gherkin
cljsjs.codemirror.mode.go
cljsjs.codemirror.mode.groovy
cljsjs.codemirror.mode.haml
cljsjs.codemirror.mode.handlebars
cljsjs.codemirror.mode.haskell
cljsjs.codemirror.mode.haxe
cljsjs.codemirror.mode.htmlembedded
cljsjs.codemirror.mode.htmlmixed
cljsjs.codemirror.mode.http
cljsjs.codemirror.mode.idl
cljsjs.codemirror.mode.jade
cljsjs.codemirror.mode.javascript
cljsjs.codemirror.mode.jinja2
cljsjs.codemirror.mode.julia
cljsjs.codemirror.mode.kotlin
cljsjs.codemirror.mode.livescript
cljsjs.codemirror.mode.lua
cljsjs.codemirror.mode.markdown
cljsjs.codemirror.mode.mathematica
cljsjs.codemirror.mode.mirc
cljsjs.codemirror.mode.mllike
cljsjs.codemirror.mode.modelica
cljsjs.codemirror.mode.mscgen
cljsjs.codemirror.mode.mumps
cljsjs.codemirror.mode.nginx
cljsjs.codemirror.mode.ntriples
cljsjs.codemirror.mode.octave
cljsjs.codemirror.mode.oz
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
cljsjs.codemirror.mode.swift
cljsjs.codemirror.mode.tcl
cljsjs.codemirror.mode.textile
cljsjs.codemirror.mode.tiddlywiki
cljsjs.codemirror.mode.tiki
cljsjs.codemirror.mode.toml
cljsjs.codemirror.mode.tornado
cljsjs.codemirror.mode.troff
cljsjs.codemirror.mode.ttcn-cfg
cljsjs.codemirror.mode.ttcn
cljsjs.codemirror.mode.turtle
cljsjs.codemirror.mode.twig
cljsjs.codemirror.mode.vb
cljsjs.codemirror.mode.vbscript
cljsjs.codemirror.mode.velocity
cljsjs.codemirror.mode.verilog
cljsjs.codemirror.mode.vhdl
cljsjs.codemirror.mode.vue
cljsjs.codemirror.mode.xml
cljsjs.codemirror.mode.xquery
cljsjs.codemirror.mode.yaml
cljsjs.codemirror.mode.z80
```

### KeyMaps

```
cljsjs.codemirror.keymap.emacs
cljsjs.codemirror.keymap.sublime
cljsjs.codemirror.keymap.vim
```


Thanks to @urmuzov for the [extern file](https://raw.githubusercontent.com/urmuzov/closure-externs/master/codemirror.js)
