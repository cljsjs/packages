# Contributing to CLJSJS

## Creating Packages

See [the wiki](https://github.com/cljsjs/packages/wiki/Creating-Packages).

## Reviewing Pull Requests

Pull requests need to be reviewed and eventually published to Clojars.
If you would like to help with this process go to the
[list of open pull requests][prs] and pick an open PR.

Check the PR for the following things and help contributors understand
where and how their contribution could be improved:

1. The directory structure in the `target/` after running `boot
   package` looks like the following
    target/
    ├── cljsjs
    │   └── <library-name>
    │       ├── common
    │       │   └── <library-name>.ext.js
    │       ├── development
    │       │   └── <library-name>.inc.js
    │       └── production
    │            └── <library-name>.min.inc.js
    └── deps.cljs
2. The externs are reasonably complete. Externs are an inexact science
   and it can't easily be verified if externs are complete but PRs
   should generally aim to provide externs as complete as possible.
3. The version number in the README matches the version number declared
   in the packages `build.boot` file.
4. The version number ends with `-X` where `X` is a CLJSJS internal
   version of the packages original version. This allows improving
   packages while clearly indicating that the original source version
   is unchanged.

After you've reviewed a pull request or two we will happily add you to
the cljsjs group on Clojars allowing you to deploy updates on your
own. :-)

Parts of this process could also be automated more, contributions in
that direction are welcome in the [boot-cljsjs](https://github.com/cljsjs/boot-cljsjs)
project.

[prs]: https://github.com/cljsjs/packages/pulls
