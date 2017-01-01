#!/bin/bash

EXIT=0

IFS=$'\n'
for x in $(./changed-packages.sh); do
    IFS=$'\t'
    x=($x)

    echo "${x[0]} version ${x[1]} is not deployed"

    (
    cd ${x[0]}
    boot package -- push --ensure-release --gpg-sign --repo clojars
    )
    [[ $? != "0" ]] && EXIT=1
done

exit $EXIT
