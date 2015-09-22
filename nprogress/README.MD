# cljsjs/nprogress
## *Slim progress bars for Ajax'y applications. Inspired by Google, YouTube, and Medium.*

## Description
This is a CLJSJS package for using [NProgress](http://ricostacruz.com/nprogress) within your ClojureScript projects.


## Usage

### Step One
Add the dependency to your `build.boot` or `project.clj` file:

[](dependency)
```clojure
[cljsjs/nprogress "0.2.0-1"] ;; latest release
```
[](/dependency)

### Step Two
This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.nprogress))
```
### Step Three
This package contains a CSS file, `/cljsjs/nprogress/common/nprogress.css`, which you must also load in order to use NProgress:

#### Boot Users
Refer to [the wiki to learn how to include this file in your project](https://github.com/cljsjs/packages/wiki/Non-JS-Assets).

#### Leinigen Users
Unfortunately I haven't found a decent way to incorporate non-JS assets from CLJSJS packages in Leinigen projects. As such, I recommend manually copying the `nprogress.css` file and referencing it in your html.

## Credit

**NProgress Authour:** NProgress is designed by [Rico Sta Cruz](https://github.com/rstacruz).

**CLJSJS Package Maintainers:**

- [Dhruv Bhatia](https://github.com/dhruvbhatia).