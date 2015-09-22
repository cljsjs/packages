# cljsjs/plottable
## *Flexible, interactive charts for the web.*

## Description
This is a CLJSJS package for using [Plottable](http://plottablejs.org/) within your ClojureScript projects.


## Usage

### Step One
`D3.js` is a pre-requisite for using Plottable, so [ensure you include the CLJSJS D3 package in your project](https://github.com/cljsjs/packages/tree/master/d3#cljsjsd3).

### Step Two
Add the dependency to your `build.boot` or `project.clj` file:

[](dependency)
```clojure
[cljsjs/plottable "1.12.0-0"] ;; latest release
```
[](/dependency)

### Step Three
This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.plottable))
```
### Step Three
This package contains a CSS file, `/cljsjs/plottable/common/plottable.css`, which you must also load in order to use Plottable:

#### Boot Users
Refer to [the wiki to learn how to include this file in your project](https://github.com/cljsjs/packages/wiki/Non-JS-Assets).

#### Leinigen Users
Unfortunately I haven't found a decent way to incorporate non-JS assets from CLJSJS packages in Leinigen projects. As such, I recommend manually copying the `plottable.css` file and referencing it in your html.

## Credit

**Plottable Authours:** Plottable is designed by [Palantir Technologies](https://github.com/palantir).

**CLJSJS Package Maintainers:**

- [Dhruv Bhatia](https://github.com/dhruvbhatia).