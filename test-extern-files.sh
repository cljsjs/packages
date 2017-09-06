#!/bin/bash

# Some duplicate externs manually excluded

externs=$(find . -name '*.ext.js' -not -path '*/target/*' -exec echo -en ' --externs {}' \;)

# --warning_level VERBOSE \

java -jar /usr/local/bin/closure-compiler.jar --js extern-test.js $externs
