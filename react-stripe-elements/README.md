# cljsjs/react-stripe-elements

https://github.com/stripe/react-stripe-elements

[](dependency)
```clojure
[cljsjs/react-stripe-elements "3.0.0-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.react-stripe-elements))
```

The Stripe.js API will still need to be provided via:

<script src="https://js.stripe.com/v3/"></script>

From https://stripe.com/docs/stripe-js/reference

"To best leverage Stripe’s advanced fraud functionality, include this script on every page of your site, not just the checkout page. This allows Stripe to detect anomalous behavior that may be indicative of fraud as customers browse your website."

For an example implementation of react-stripe-elements using Reagent see:

https://github.com/jborden/reagent-stripe-elements-demo
