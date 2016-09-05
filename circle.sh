#!/bin/bash

set -e

# Node 0 runs the build or deploy
# Node 1 runs extern tests

if [[ $CIRCLE_NODE_TOTAL < 2 ]] || [[ $CIRCLE_NODE_INDEX == 0 ]]; then
    curl -L https://github.com/boot-clj/boot-bin/releases/download/latest/boot.sh -o ~/bin/boot
    chmod +x ~/bin/boot
    mkdir -p ~/.boot
    cp profile.boot ~/.boot/profile.boot

    if [[ $CIRCLE_BRANCH == "master" ]]; then
        echo "Deploy changed packages"
        ./deploy-changed.sh
    else
        echo "Test changed packages"
        ./test-changed.sh
    fi
fi

if [[ $CIRCLE_NODE_TOTAL < 2 ]] || [[ $CIRCLE_NODE_INDEX == 1 ]]; then
    echo "Validate extern files"
    npm install
    ./test-extern-files.sh
fi
