# cljsjs/pixi

    [cljsjs/pixi "3.0.7-0"] ;; latest release

This jar comes with deps.cljs as used by the Foreign Libs feature of the
Clojurescript compiler. After adding the above dependency to your project you
can require the packaged library like so:

    (ns application.core
      (:require cljsjs.pixi))

Externs thanks to [this][generator] tool from [DotNetWise][dotnetwise].

[generator]: http://www.dotnetwise.com/Code/Externs/
[dotnetwise]: http://blog.dotnetwise.com/2009/11/closure-compiler-externs-extractor.html
