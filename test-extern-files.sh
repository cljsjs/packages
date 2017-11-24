#!/bin/bash

# Some duplicate externs manually excluded

externs=$(find . -name '*.ext.js' -not -path '*/target/*' -exec echo -en ' --externs {}' \;)

LEVEL=DEFAULT
# LEVEL=VERBOSE

java -jar /usr/local/bin/closure-compiler.jar \
  --js extern-test.js \
  --warning_level $LEVEL \
  $externs
