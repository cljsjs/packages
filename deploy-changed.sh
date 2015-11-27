#!/bin/bash

IFS=$OFS

for x in *; do
    if [[ -d $x ]]; then
        if [[ $x = "jquery" ]]; then
            echo "WARNING: jquery not supported"
            continue
        fi

        if [[ ! -f $x/build.boot ]]; then
            echo "WARNING: $x skipped"
            continue
        fi

        id=$(grep :project $x/build.boot | grep -o "'.*" | head -n1 | cut -c 2-)

        version=$(grep "def +lib-version+" $x/build.boot | grep -o "\".*\"" | head -n1 | cut -d \" -f 2)
        version=$version$(grep "def +version+" $x/build.boot | grep -o "\".*\"" | head -n1 | cut -d \" -f 2)

        y=$(curl -s -o /dev/null --write-out %{http_code} https://clojars.org/repo/cljsjs/$x/$version/$x-$version.pom)

        if [[ $y != "200" ]]; then
            echo "$x version $version is not deployed"

            (
            cd $x
            BOOT_VERSION=2.5.0-SNAPSHOT boot package -- build-jar -- push --gpg-sign --repo clojars --repo-map "{:username :gpg :password :gpg}"
            )
        fi
    fi
done
