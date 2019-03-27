# cljsjs/libphonenumber

[](dependency)
```clojure
[cljsjs/libphonenumber "8.10.8-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` providing
[Google's `libphonenumber`](https://github.com/googlei18n/libphonenumber)
project **as a Closure library**.  This means requiring parts of it is
done in a similar fashion to requiring parts of the Closure library
itself:

```clojure
(ns libphonenumber.example
  (:require [goog.format.EmailAddress :as email] ; closure
            [goog.object :as gobj]
            [goog.dom :as gdom]
            [i18n.phonenumbers.PhoneNumberUtil :as pnu] ; libphonenumber
            [i18n.phonenumbers.PhoneNumberFormat :as pnf]))

;; a small example

(let [pu (pnu/getInstance)
      num "0175 2345 234"
      country "DE"                    ; default country
      parsed (.parse pu num country)] ; alternatively: (.parseAndKeepRawInput pu num country)
  (js/console.log "parsing" parsed)
  (js/console.log "valid?" (.isValidNumber pu parsed))

  (js/console.log "formatting international:" (.format pu parsed pnf/INTERNATIONAL))
  (js/console.log "formatting national:" (.format pu parsed pnf/NATIONAL))
  (js/console.log "formatting E164:" (.format pu parsed pnf/E164))
  (js/console.log "formatting RFC3966:" (.format pu parsed pnf/RFC3966)))
```
