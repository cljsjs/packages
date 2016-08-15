#!/bin/bash

if [[ $CIRCLE_BRANCH != "master" ]]; then
    ./test-changed.sh
fi
