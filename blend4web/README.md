# cljs-blend4web

[](dependency)
```clojure
[cljsjs/blend4web "16.11-1"] ;; latest release
```
[](/dependency)

If you're looking for a place to start, try downloading the [monkey project](https://github.com/mikebelanger/monkey-project)

### ClojureScript -> Blend4Web Web-player functions

[Here's an example of its output](https://mikebelanger.github.io/blend4web_test/target/)

[Here's a workflow video](https://vimeo.com/191821775)

*Note: Probably runs best on Chrome, FF*

### Externs

Download the full blend4web archive (1.4GB).

Modify `script/compile_b4w.py` script so that it doesn't delete `externs_gen_file` (around line 248).

Run the script and copy created extern file from temp folder (`/tmp` or such) to `resources` folder here.
