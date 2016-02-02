#!/bin/bash

for x in *; do
    if [[ -d $x ]]; then
        if [[ ! -f $x/build.boot ]]; then
            continue
        fi

        version=$(grep "def +lib-version+" $x/build.boot | grep -o "\".*\"" | head -n1 | cut -d \" -f 2)
        version=$version$(grep "def +version+" $x/build.boot | grep -o "\".*\"" | head -n1 | cut -d \" -f 2)

        # run in parallel
        (
        y=$(curl -s -o /dev/null --write-out %{http_code} https://clojars.org/repo/cljsjs/$x/$version/$x-$version.pom)

        if [[ $y != "200" ]]; then
            echo $x
        fi
        ) &
    fi
done

wait
