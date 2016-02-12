# cljsjs/jqconsole
```clojure
[cljsjs/jqconsole "2.13.2-0"] ;; latest release
```
Packages up [jq-console](https://github.com/replit/jq-console).

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.jqconsole))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies

#jq-console

A jQuery terminal plugin written in CoffeeScript.

This project was spawned because of our need for a simple web terminal plugin
for the <a href="http://repl.it">repl.it</a> project. It tries to simulate a low level terminal by providing (almost)
raw input/output streams as well as input and output states.

Version 2.0 adds baked-in support for rich multi-line prompting and operation
queueing.


##Tested Browsers

The plugin has been tested on the following browsers:

* IE 9+
* Chrome
* Firefox
* Opera
* iOS Safari and Chrome
* Android Chrome
