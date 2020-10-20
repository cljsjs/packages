# cljsjs/highlight

[](dependency)
```clojure
[cljsjs/highlight "10.3.1-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler.

After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require
    [cljsjs.highlight]
    [cljsjs.highlight.langs.clojure]))
```

The `cljsjs.highlight.langs.clojure` is optional, you can include any of the
language packages listed below to enable higlight support for them.

Now you can reference the highlight global object:

```clojure
(.highlightBlock js/hljs (-> js/document (.querySelector "code")))
```

Refer to [this](https://github.com/cljsjs/packages/wiki/Non-JS-Assets) wiki page
for instructions on how to add CSS theme files to your project.

TLDR - You'll have to include the highlight CSS theme code on your page in
whatever way you prefer. The easiest is to just include the theme CSS in your
HTML file:

```html
<link href="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/10.3.1/styles/zenburn.min.css" rel="stylesheet" type="text/css">
```

List of highlight language packages:

```
cljsjs.highlight.langs.1c
cljsjs.highlight.langs.abnf
cljsjs.highlight.langs.accesslog
cljsjs.highlight.langs.actionscript
cljsjs.highlight.langs.ada
cljsjs.highlight.langs.apache
cljsjs.highlight.langs.applescript
cljsjs.highlight.langs.arduino
cljsjs.highlight.langs.armasm
cljsjs.highlight.langs.asciidoc
cljsjs.highlight.langs.aspectj
cljsjs.highlight.langs.autohotkey
cljsjs.highlight.langs.autoit
cljsjs.highlight.langs.avrasm
cljsjs.highlight.langs.awk
cljsjs.highlight.langs.axapta
cljsjs.highlight.langs.bash
cljsjs.highlight.langs.basic
cljsjs.highlight.langs.bnf
cljsjs.highlight.langs.brainfuck
cljsjs.highlight.langs.cal
cljsjs.highlight.langs.capnproto
cljsjs.highlight.langs.ceylon
cljsjs.highlight.langs.clean
cljsjs.highlight.langs.clojure
cljsjs.highlight.langs.clojure-repl
cljsjs.highlight.langs.cmake
cljsjs.highlight.langs.coffeescript
cljsjs.highlight.langs.coq
cljsjs.highlight.langs.cos
cljsjs.highlight.langs.cpp
cljsjs.highlight.langs.crmsh
cljsjs.highlight.langs.crystal
cljsjs.highlight.langs.cs
cljsjs.highlight.langs.csp
cljsjs.highlight.langs.css
cljsjs.highlight.langs.d
cljsjs.highlight.langs.dart
cljsjs.highlight.langs.delphi
cljsjs.highlight.langs.diff
cljsjs.highlight.langs.django
cljsjs.highlight.langs.dns
cljsjs.highlight.langs.dockerfile
cljsjs.highlight.langs.dos
cljsjs.highlight.langs.dsconfig
cljsjs.highlight.langs.dts
cljsjs.highlight.langs.dust
cljsjs.highlight.langs.ebnf
cljsjs.highlight.langs.elixir
cljsjs.highlight.langs.elm
cljsjs.highlight.langs.erb
cljsjs.highlight.langs.erlang
cljsjs.highlight.langs.erlang-repl
cljsjs.highlight.langs.excel
cljsjs.highlight.langs.fix
cljsjs.highlight.langs.flix
cljsjs.highlight.langs.fortran
cljsjs.highlight.langs.fsharp
cljsjs.highlight.langs.gams
cljsjs.highlight.langs.gauss
cljsjs.highlight.langs.gcode
cljsjs.highlight.langs.gherkin
cljsjs.highlight.langs.glsl
cljsjs.highlight.langs.go
cljsjs.highlight.langs.golo
cljsjs.highlight.langs.gradle
cljsjs.highlight.langs.groovy
cljsjs.highlight.langs.haml
cljsjs.highlight.langs.handlebars
cljsjs.highlight.langs.haskell
cljsjs.highlight.langs.haxe
cljsjs.highlight.langs.hsp
cljsjs.highlight.langs.htmlbars
cljsjs.highlight.langs.http
cljsjs.highlight.langs.hy
cljsjs.highlight.langs.inform7
cljsjs.highlight.langs.ini
cljsjs.highlight.langs.irpf90
cljsjs.highlight.langs.java
cljsjs.highlight.langs.javascript
cljsjs.highlight.langs.jboss-cli
cljsjs.highlight.langs.json
cljsjs.highlight.langs.julia
cljsjs.highlight.langs.julia-repl
cljsjs.highlight.langs.kotlin
cljsjs.highlight.langs.lasso
cljsjs.highlight.langs.ldif
cljsjs.highlight.langs.leaf
cljsjs.highlight.langs.less
cljsjs.highlight.langs.lisp
cljsjs.highlight.langs.livecodeserver
cljsjs.highlight.langs.livescript
cljsjs.highlight.langs.llvm
cljsjs.highlight.langs.lsl
cljsjs.highlight.langs.lua
cljsjs.highlight.langs.makefile
cljsjs.highlight.langs.markdown
cljsjs.highlight.langs.mathematica
cljsjs.highlight.langs.matlab
cljsjs.highlight.langs.maxima
cljsjs.highlight.langs.mel
cljsjs.highlight.langs.mercury
cljsjs.highlight.langs.mipsasm
cljsjs.highlight.langs.mizar
cljsjs.highlight.langs.mojolicious
cljsjs.highlight.langs.monkey
cljsjs.highlight.langs.moonscript
cljsjs.highlight.langs.n1ql
cljsjs.highlight.langs.nginx
cljsjs.highlight.langs.nimrod
cljsjs.highlight.langs.nix
cljsjs.highlight.langs.nsis
cljsjs.highlight.langs.objectivec
cljsjs.highlight.langs.ocaml
cljsjs.highlight.langs.openscad
cljsjs.highlight.langs.oxygene
cljsjs.highlight.langs.parser3
cljsjs.highlight.langs.perl
cljsjs.highlight.langs.pf
cljsjs.highlight.langs.php
cljsjs.highlight.langs.pony
cljsjs.highlight.langs.powershell
cljsjs.highlight.langs.processing
cljsjs.highlight.langs.profile
cljsjs.highlight.langs.prolog
cljsjs.highlight.langs.protobuf
cljsjs.highlight.langs.puppet
cljsjs.highlight.langs.purebasic
cljsjs.highlight.langs.python
cljsjs.highlight.langs.q
cljsjs.highlight.langs.qml
cljsjs.highlight.langs.r
cljsjs.highlight.langs.rib
cljsjs.highlight.langs.roboconf
cljsjs.highlight.langs.routeros
cljsjs.highlight.langs.rsl
cljsjs.highlight.langs.ruby
cljsjs.highlight.langs.ruleslanguage
cljsjs.highlight.langs.rust
cljsjs.highlight.langs.scala
cljsjs.highlight.langs.scheme
cljsjs.highlight.langs.scilab
cljsjs.highlight.langs.scss
cljsjs.highlight.langs.shell
cljsjs.highlight.langs.smali
cljsjs.highlight.langs.smalltalk
cljsjs.highlight.langs.sml
cljsjs.highlight.langs.sqf
cljsjs.highlight.langs.sql
cljsjs.highlight.langs.stan
cljsjs.highlight.langs.stata
cljsjs.highlight.langs.step21
cljsjs.highlight.langs.stylus
cljsjs.highlight.langs.subunit
cljsjs.highlight.langs.swift
cljsjs.highlight.langs.taggerscript
cljsjs.highlight.langs.tap
cljsjs.highlight.langs.tcl
cljsjs.highlight.langs.tex
cljsjs.highlight.langs.thrift
cljsjs.highlight.langs.tp
cljsjs.highlight.langs.twig
cljsjs.highlight.langs.typescript
cljsjs.highlight.langs.vala
cljsjs.highlight.langs.vbnet
cljsjs.highlight.langs.vbscript
cljsjs.highlight.langs.vbscript-html
cljsjs.highlight.langs.verilog
cljsjs.highlight.langs.vhdl
cljsjs.highlight.langs.vim
cljsjs.highlight.langs.x86asm
cljsjs.highlight.langs.xl
cljsjs.highlight.langs.xml
cljsjs.highlight.langs.xquery
cljsjs.highlight.langs.yaml
cljsjs.highlight.langs.zephir
```


## Npm style names

Also provides names `highlight.js` and `highlight.js/lib/languages/<name>`.

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
