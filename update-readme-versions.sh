#!/bin/bash

for x in *; do
    if [[ -d $x ]]; then
        if [[ ! -f $x/build.boot ]] || [[ ! -f $x/README.md ]]; then
            continue
        fi

        artifact=${x//_[0-9]/}
        version=$(grep "def +lib-version+" $x/build.boot | grep -o "\".*\"" | head -n1 | cut -d \" -f 2)
        version=$version$(grep "def +version+" $x/build.boot | grep -o "\".*\"" | head -n1 | cut -d \" -f 2)

        sed -i "/\[\](dependency)/{ N; N; s/.*/[](dependency)\n\`\`\`clojure\n[cljsjs\/$artifact \"$version\"] ;; latest release/ }" $x/README.md
    fi
done
