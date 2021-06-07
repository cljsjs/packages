#!/bin/bash

for x in *; do
    if [[ -d $x ]]; then
        if [[ ! -f $x/build.boot ]]; then
            continue
        fi
        if [[ -f $x/disabled ]]; then
            continue
        fi

        # jquery_1, jquery_2, react and react_15 are different versions of the same package
        artifact=${x//_[0-9]*/}
        group=cljsjs
        if grep -q "io.github.cljsjs/$artifact" "$x/build.boot"; then
            group=io/github/cljsjs
        fi
        version=$(grep "def +lib-version+" "$x/build.boot" | grep -o "\".*\"" | head -n1 | cut -d \" -f 2)
        version=$version$(grep "def +version+" "$x/build.boot" | grep -o "\".*\"" | head -n1 | cut -d \" -f 2)

        # run in parallel
        (
        y=$(curl -s -o /dev/null --write-out %{http_code} "https://repo.clojars.org/$group/$artifact/$version/$artifact-$version.pom")

        if [[ $y != "200" ]]; then
            echo $x$'\t'$version
        fi
        ) &
    fi
done

wait
