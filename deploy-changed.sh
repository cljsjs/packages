#!/bin/bash

EXIT=0

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
            boot package -- pom -- jar -- push --ensure-release --gpg-sign --repo clojars
            )
            [[ $? != "0" ]] && EXIT=1
        fi
    fi
done

exit $EXIT
