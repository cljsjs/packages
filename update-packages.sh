#!/bin/bash

for x in *; do
    if [[ -d $x ]]; then
        if [[ ! -f $x/build.boot ]]; then
            continue
        fi
        if [[ -f $x/disabled ]]; then
            continue
        fi

        # Skip packages not using unpkg
        if ! grep -q "unpkg.com" "$x/build.boot"; then
            continue
        fi

        artifact=${x//_[0-9]*/}
        # Skip old versions of packages, like jquery_1 or react_15
        if [[ "$x" != "$artifact" ]]; then
            continue
        fi

        lib_version=$(grep "def +lib-version+" "$x/build.boot" | grep -o "\".*\"" | head -n1 | cut -d \" -f 2)

        location=$(curl -s --head "https://unpkg.com/$artifact/" | grep location:)
        latest_version=$(echo "$location" | grep -o "@[0-9.]*" | cut -c2-)

        if [[ $latest_version = "" ]]; then
            # if no response, e.g. folder name doesn't match unpkg, skip for now
            continue
        fi

        if [[ "$lib_version" != "$latest_version" ]]; then
            echo "$x, packaged lib version $lib_version, latest is $latest_version"
            ./update-package.sh "$x" "$lib_version" "$latest_version"
        fi
    fi
done
