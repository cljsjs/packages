# cljsjs/tonejs

[](dependency)
```clojure
[cljsjs/tonejs "13.4.9-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns tonejs-test.core
  (:require [tonejs]))
```

Here's an example of basic usage

```clojure
(ns tonejs-test.core
  (:require [tonejs]))

(def synth-settings (clj->js {:oscillator {:type "pwm"
                                           :modulationFrequency 0.05}
                              :envelope {:attack 2.0
                                         :decay 0.025
                                         :sustain 0.25
                                         :release 0.9}}))

(def obj-synth (-> (new js/Tone.Synth synth-settings)
                   (.toMaster)))

(.log js/console synth-settings)
(.log js/console (.-modulationFrequency (.-oscillator synth-settings)))
(.triggerAttackRelease obj-synth "C4" "8n")

```

To learn more about tonejs, check out tonejs'  [API](https://tonejs.github.io/docs/) and [examples](https://tonejs.github.io/docs/).

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
