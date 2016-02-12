# cljsjs/responsive-nav
## *Responsive navigation plugin without library dependencies and with fast touch screen support.*

## Description
This is a CLJSJS package for using [Responsive Nav](http://responsive-nav.com) within your ClojureScript projects.


## Usage

### Step One
Add the dependency to your `build.boot` or `project.clj` file:

[](dependency)
```clojure
[cljsjs/responsive-nav "1.0.39-0"] ;; latest release
```
[](/dependency)

### Step Two
This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.responsive-nav))
```
### Step Three
This package contains a CSS file, `/cljsjs/nprogress/common/responsive-nav.css`, which you must also load in order to use Responsive Nav:

#### Boot Users
Refer to [the wiki to learn how to include this file in your project](https://github.com/cljsjs/packages/wiki/Non-JS-Assets).

#### Leinigen Users
Unfortunately I haven't found a decent way to incorporate non-JS assets from CLJSJS packages in Leinigen projects. As such, I recommend manually copying the `responsive-nav.css` file and referencing it in your html.

## Credit

**Responsive Nav Authour:** Responsive Nav is designed by [Viljami Salminen](https://github.com/viljamis).

**CLJSJS Package Maintainers:**

- [Dhruv Bhatia](https://github.com/dhruvbhatia).