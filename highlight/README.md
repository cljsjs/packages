# cljsjs/highlight

[](dependency)
```clojure
[cljsjs/highlight "8.4-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.highlight))
```

And also include the languages you wish to highlight:

```
cljsjs.highlight.langs.1c
cljsjs.highlight.langs.actionscript
cljsjs.highlight.langs.apache
cljsjs.highlight.langs.applescript
cljsjs.highlight.langs.asciidoc
cljsjs.highlight.langs.aspectj
cljsjs.highlight.langs.autohotkey
cljsjs.highlight.langs.avrasm
cljsjs.highlight.langs.axapta
cljsjs.highlight.langs.bash
cljsjs.highlight.langs.brainfuck
cljsjs.highlight.langs.capnproto
cljsjs.highlight.langs.clojure-repl
cljsjs.highlight.langs.clojure
cljsjs.highlight.langs.cmake
cljsjs.highlight.langs.coffeescript
cljsjs.highlight.langs.cpp
cljsjs.highlight.langs.cs
cljsjs.highlight.langs.css
cljsjs.highlight.langs.d
cljsjs.highlight.langs.dart
cljsjs.highlight.langs.delphi
cljsjs.highlight.langs.diff
cljsjs.highlight.langs.django
cljsjs.highlight.langs.dockerfile
cljsjs.highlight.langs.dos
cljsjs.highlight.langs.dust
cljsjs.highlight.langs.elixir
cljsjs.highlight.langs.erb
cljsjs.highlight.langs.erlang-repl
cljsjs.highlight.langs.erlang
cljsjs.highlight.langs.fix
cljsjs.highlight.langs.fortran
cljsjs.highlight.langs.fsharp
cljsjs.highlight.langs.gcode
cljsjs.highlight.langs.gherkin
cljsjs.highlight.langs.glsl
cljsjs.highlight.langs.go
cljsjs.highlight.langs.gradle
cljsjs.highlight.langs.groovy
cljsjs.highlight.langs.haml
cljsjs.highlight.langs.handlebars
cljsjs.highlight.langs.haskell
cljsjs.highlight.langs.haxe
cljsjs.highlight.langs.http
cljsjs.highlight.langs.ini
cljsjs.highlight.langs.java
cljsjs.highlight.langs.javascript
cljsjs.highlight.langs.json
cljsjs.highlight.langs.julia
cljsjs.highlight.langs.lasso
cljsjs.highlight.langs.less
cljsjs.highlight.langs.lisp
cljsjs.highlight.langs.livecodeserver
cljsjs.highlight.langs.livescript
cljsjs.highlight.langs.lua
cljsjs.highlight.langs.makefile
cljsjs.highlight.langs.markdown
cljsjs.highlight.langs.mathematica
cljsjs.highlight.langs.matlab
cljsjs.highlight.langs.mel
cljsjs.highlight.langs.mercury
cljsjs.highlight.langs.mizar
cljsjs.highlight.langs.monkey
cljsjs.highlight.langs.nginx
cljsjs.highlight.langs.nimrod
cljsjs.highlight.langs.nix
cljsjs.highlight.langs.nsis
cljsjs.highlight.langs.objectivec
cljsjs.highlight.langs.ocaml
cljsjs.highlight.langs.oxygene
cljsjs.highlight.langs.parser3
cljsjs.highlight.langs.perl
cljsjs.highlight.langs.pf
cljsjs.highlight.langs.php
cljsjs.highlight.langs.powershell
cljsjs.highlight.langs.processing
cljsjs.highlight.langs.profile
cljsjs.highlight.langs.protobuf
cljsjs.highlight.langs.puppet
cljsjs.highlight.langs.python
cljsjs.highlight.langs.q
cljsjs.highlight.langs.r
cljsjs.highlight.langs.rib
cljsjs.highlight.langs.roboconf
cljsjs.highlight.langs.rsl
cljsjs.highlight.langs.ruby
cljsjs.highlight.langs.ruleslanguage
cljsjs.highlight.langs.rust
cljsjs.highlight.langs.scala
cljsjs.highlight.langs.scheme
cljsjs.highlight.langs.scilab
cljsjs.highlight.langs.scss
cljsjs.highlight.langs.smali
cljsjs.highlight.langs.smalltalk
cljsjs.highlight.langs.sml
cljsjs.highlight.langs.sql
cljsjs.highlight.langs.stata
cljsjs.highlight.langs.step21
cljsjs.highlight.langs.stylus
cljsjs.highlight.langs.swift
cljsjs.highlight.langs.tcl
cljsjs.highlight.langs.tex
cljsjs.highlight.langs.thrift
cljsjs.highlight.langs.twig
cljsjs.highlight.langs.typescript
cljsjs.highlight.langs.vala
cljsjs.highlight.langs.vbnet
cljsjs.highlight.langs.vbscript-html
cljsjs.highlight.langs.vbscript
cljsjs.highlight.langs.verilog
cljsjs.highlight.langs.vhdl
cljsjs.highlight.langs.vim
cljsjs.highlight.langs.x86asm
cljsjs.highlight.langs.xl
cljsjs.highlight.langs.xml
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
