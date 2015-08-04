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
[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies

Media Stream Recorder

https://github.com/streamproc/MediaStreamRecorder lets you record audio and video
from a media stream (webcam) to Blob files in your browser.

Demos:  https://www.webrtc-experiment.com/msr/

Use MediaStreamRecorder for firefox and MultiStreamRecorder for chrome. Constructing
these given a stream `stream is as simple as.

```clojure
(def media-constraints #js {:audio false :video true})
```

```clojure
;; use MediaStreamRecorder to record .webm files on Firefox and Firefox Mobile (best)
(defn record! [stream]
  (let [msr (js/MediaStreamRecorder. stream)]
    (aset msr "mimeType" "video/webm") ;; necessary
    (aset msr "width" 320) ;; necessary
    (aset msr "height" 240) ;; necessary
    (set! (.-ondataavailable msr)  #(js/console.log %))
    (.start msr 0)))

(def media-constraints #js {:audio true :video true})

(js/navigator.getUserMedia media-constraints record! js/console.warn)
```
or
```clojure
;; use MultiStreamRecorder only if you need video + audio on Chrome
(defn record! [stream]
  (let [msr (js/MultiStreamRecorder. stream)]
    (set! (.-ondataavailable msr)  #(js/console.log %))
    (.start msr 0)))

(def media-constraints #js {:audio true :video true})

(js/navigator.webkitGetUserMedia media-constraints record! js/console.warn)
```

available methods for msr are:

```clojure
  (.start msr) ;; starts recording from stream
  (.stop msr) ;; segments and stops recording from stream
```
