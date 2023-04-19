#!/bin/bash

for i in */; do
    if [[ $i == "ARCHIVE/" ]]; then
        continue
    fi

    latest_change=$(git log --format="%as %s" "$i" |
        grep -v "Update boot-cljsjs" |
        grep -v "Use new boot-cljsjs" |
        grep -v "Automatic update" |
        grep -v "Link to the official CLJS page on foreign libs" |
        grep -v "Call validate for all tasks" |
        grep -v "Clojurescript -> ClojureScript in all READMEs." |
        head -n1)

    if [[ $latest_change = 202* ]]; then
        echo "$i $latest_change"
    else
        echo "$i $latest_change -> ARCHIVE"
        git mv "$i" ARCHIVE
    fi
done
