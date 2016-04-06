#!/bin/bash

for x in *; do
    if [[ -d $x ]]; then
        if [[ ! -f $x/build.boot ]]; then
            continue
        fi

        artifact=${x//_[0-9]/}
        version=$(grep "def +lib-version+" $x/build.boot | grep -o "\".*\"" | head -n1 | cut -d \" -f 2)
        version=$version$(grep "def +version+" $x/build.boot | grep -o "\".*\"" | head -n1 | cut -d \" -f 2)

        # run in parallel
        (
        y=$(curl -s -o /dev/null --write-out %{http_code} https://clojars.org/repo/cljsjs/$artifact/$version/$artifact-$version.pom)

        if [[ $y != "200" ]]; then
            echo $x
        fi
        ) &
    fi
done

wait
