# cljsjs/ical

[](dependency)
```clojure
[cljsjs/ical "1.2.1-2"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs]
feature of the Clojurescript compiler. After adding the above
dependency to your project you can require the packaged library like
so:

```clojure
(ns application.core
  (:require cljsjs.ical))
```

Here's a simple example of how to parse the contents of an `.ics` file:

```clojure
(def ical-data
  (clojure.string/join 
   "\r\n"
   ["BEGIN:VCALENDAR"
    "CALSCALE:GREGORIAN"
    "PRODID:-//Example Inc.//Example Calendar//EN"
    "VERSION:2.0"
    "BEGIN:VEVENT"
    "DTSTAMP:20080205T191224Z"
    "DTSTART:20081006"
    "SUMMARY:Planning meeting"
    "UID:4088E990AD89CB3DBB484909"
    "END:VEVENT"
    "END:VCALENDAR"
    ]))
    
(= "Planning meeting" 
  (-> (js/ICAL.parse ical-data)
      (js/ICAL.Component.) 
      (.getFirstSubcomponent "vevent")
      (.getFirstPropertyValue "summary")))
```

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
