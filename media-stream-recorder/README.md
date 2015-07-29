# cljsjs/media-stream-recorder

[](dependency)
```clojure
[cljsjs/media-stream-recorder "1.2.6-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.media-stream-recorder))
```

From there
[flibs]: https://github.com/clojure/clojurescript/wiki/Foreign-Dependencies

Media Stream Recorder

https://github.com/streamproc/MediaStreamRecorder lets you record audio and video
from a media stream (webcam) to Blob files in your browser.

Demos:  https://www.webrtc-experiment.com/msr/

Use MediaStreamRecorder for firefox and MultiStreamRecorder for chrome. Constructing
these given a stream `stream is as simple as.

```clojure
(let [msr (js/MediaStreamRecorder stream)]
  ...)
```
or
```clojure
(let [msr (js/MultiStreamRecorder stream)]
  ...)
```

available methods for msr are:

```clojure
  (.start msr) ;; starts recording from stream
  (.stop msr) ;; segments and stops recording from stream
```

Finally, you will probably want to do something with that segment, use
ondataavailable to get the value of the generated blob

```clojure
  (set!
     (.-ondataavailable msr)
     #(put! c {:action :new-stream-segment :data %}))
```
