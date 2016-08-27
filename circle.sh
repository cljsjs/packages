#!/bin/bash

# Node 1 runs the build or deploy
# Node 2 runs extern tests

if [[ $CIRCLE_NODE_TOTAL < 2 ]] || [[ $CIRCLE_NODE_INDEX == 1 ]]; then
    curl -L https://github.com/boot-clj/boot-bin/releases/download/latest/boot.sh -o ~/bin/boot
    chmod +x ~/bin/boot
    mkdir -p ~/.boot
    cp profile.boot ~/.boot/profile.boot

    if [[ $CIRCLE_BRANCH == "master" ]]; then
        echo -e "use-agent\ndefault-key cljsjs.robot@gmail.com\npassphrase $GPG_PASSPHRASE" >> ~/.gnupg/gpg.conf
        # CircleCI doesn't support newlines in vars so newlines are coded as "|"
        echo -e $GPG_KEY | tr "|" "\n" > gpg.key
        gpg --allow-secret-key-import --import gpg.key
        rm gpg.key
        ./deploy-changed.sh
    else
        ./test-changed.sh
    fi
fi

if [[ $CIRCLE_NODE_TOTAL < 2 ]] || [[ $CIRCLE_NODE_INDEX == 2 ]]; then
    npm install
    ./test-extern-files.sh
fi
