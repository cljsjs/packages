#!/bin/bash

if [[ $CIRCLE_BRANCH == "master" ]]; then
    exit 0
fi

EXIT=0

for x in $(./changed-packages.sh); do
    version=$(grep "def +lib-version+" $x/build.boot | grep -o "\".*\"" | head -n1 | cut -d \" -f 2)
    version=$version$(grep "def +version+" $x/build.boot | grep -o "\".*\"" | head -n1 | cut -d \" -f 2)

    echo "$x version $version is not deployed"

    (
    cd $x
    boot package
    )
    [[ $? != "0" ]] && EXIT=1
done

exit $EXIT
