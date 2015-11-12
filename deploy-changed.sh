#!/bin/bash

set -e

# Retrieve current versions from Clojars

declare -A versions

OFS=$IFS
IFS=$'\n'
for e in $(curl -s https://clojars.org/api/groups/cljsjs | jq -c ".[]"); do
    group=$(echo $e | jq -r ".group_name")
    artifact=$(echo $e | jq -r ".jar_name")
    id="$group/$artifact"
    version=$(echo $e | jq -r ".latest_version")

    versions["$id"]=$version
done

IFS=$OFS

for x in *; do
    if [[ -d $x ]]; then
        if [[ $x = "jquery" ]]; then
            echo "WARNING: jquery not supported"
            break;
        fi

        if [[ ! -f $x/build.boot ]]; then
            echo "WARNING: $x skipped"
            break;
        fi

        id=$(grep :project $x/build.boot | grep -o "'.*" | head -n1 | cut -c 2-)

        version=$(grep "def +lib-version+" $x/build.boot | grep -o "\".*\"" | head -n1 | cut -d \" -f 2)
        version=$version$(grep "def +version+" $x/build.boot | grep -o "\".*\"" | head -n1 | cut -d \" -f 2)

        deployed=${versions["$id"]}
        if [[ $version != $deployed ]]; then
            echo "$id deployed version $deployed, current $version"

            (
            cd $x
            echo $GPG_PASSPHRASE | boot package build-jar push-release
            )
        fi
    fi
done
