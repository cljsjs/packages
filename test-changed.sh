#!/bin/bash

if [[ $CIRCLE_BRANCH == "master" ]]; then
    exit 0
fi

EXIT=0

for x in $(./changed-packages.sh); do
    if [[ $x = "jquery" ]]; then
        echo "WARNING: jquery not supported"
        continue
    fi

    if [[ ! -f $x/build.boot ]]; then
        echo "WARNING: $x skipped"
        continue
    fi

    version=$(grep "def +lib-version+" $x/build.boot | grep -o "\".*\"" | head -n1 | cut -d \" -f 2)
    version=$version$(grep "def +version+" $x/build.boot | grep -o "\".*\"" | head -n1 | cut -d \" -f 2)

    echo "$x version $version is not deployed"

    (
    cd $x
    boot package -- pom -- jar
    )
    [[ $? != "0" ]] && EXIT=1
done

exit $EXIT
