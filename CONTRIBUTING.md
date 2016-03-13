# Contributing to CLJSJS

## Creating Packages

See [the wiki](https://github.com/cljsjs/packages/wiki/Creating-Packages).

## For information and help

[Clojurians slack](https://clojurians.slack.com/) ([join](http://clojurians.net/))
has a channel [#cljsjs](https://clojurians.slack.com/messages/cljsjs/) for talk about Cljsjs.

## Commit messages

1. Start commit message with `[<library-name>]`
1. Separate subject from body with a blank line
2. Limit the subject line to 50 characters
3. Capitalize the subject line
4. Do not end the subject line with a period
5. Use the imperative mood in the subject line
    - "Add x", "Fix y", "Support z", "Remove x"
6. Wrap the body at 72 characters
7. Use the body to explain what and why vs. how

**Example of good commit message**: `[pikaday] Add minified version of js and css`

## Creating Pull Requests

- Base your changes on the latest master commit. This will ensure that the build scripts are up-to-date.
- Please increment the build number (version part after the dash). This way maintainers only need to merge the PR and don't need to make any changes themselves.
- If you are asked to implement changes, please comment on PR after implementing the changes. This way maintainers will more easily notice your updates.

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
        │           └── <library-name>.min.inc.js
        └── deps.cljs

2. The externs are reasonably complete. Externs are an inexact science
   and it can't easily be verified if externs are complete but PRs
   should generally aim to provide externs as complete as possible.
3. The version number in the README matches the version number declared
   in the packages `build.boot` file.
4. The version number ends with `-X` where `X` is a CLJSJS build number
   of the packages original version. This allows improving
   packages while clearly indicating that the original source version
   is unchanged.
5. The PR's commits start with `[<library-name>]` followed by a description
   of the change. Commits are squashed where appropriate.

After you've reviewed a pull request or two we will happily add you to
the cljsjs group on Clojars allowing you to deploy updates on your
own. :-)

## Releases

### Building locally

To test that your additions or changes to a library were successful,
run following command **from within the
library-specific directory**:

```
$ boot package install target
```

This will run your package instructions and create a jar for the given
library in your local maven repository. From there, it can be included
in projects and tested locally.

### Deploying to Clojars

Deployment to Clojars is automated using [a bash script](./deploy-changed.sh) and [CircleCI](https://circleci.com/gh/cljsjs/packages).

[prs]: https://github.com/cljsjs/packages/pulls
