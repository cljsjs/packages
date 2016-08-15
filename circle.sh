#!/bin/bash

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
