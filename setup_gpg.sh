#!/bin/bash

# Important to not use -x here, or secrets will be exposed...

if [[ $CIRCLE_NODE_TOTAL < 2 ]] || [[ $CIRCLE_NODE_INDEX == 0 ]]; then
    if [[ $CIRCLE_BRANCH == "master" ]]; then
        echo -e "use-agent\ndefault-key cljsjs.robot@gmail.com\npassphrase $GPG_PASSPHRASE" >> ~/.gnupg/gpg.conf
        # CircleCI doesn't support newlines in vars so newlines are coded as "|"
        echo -e $GPG_KEY | tr "|" "\n" > gpg.key
        gpg --allow-secret-key-import --import gpg.key
        rm gpg.key
    fi
fi
