#!/bin/bash

# Some duplicate externs manually excluded

CLOSURE_COMPILER_VERSION=20180204
LEVEL=DEFAULT
# LEVEL=VERBOSE

if [[ ! -f closure-compiler.jar ]]; then
  curl -SLO "http://dl.google.com/closure-compiler/compiler-$CLOSURE_COMPILER_VERSION.tar.gz"
  tar -xf "compiler-$CLOSURE_COMPILER_VERSION.tar.gz" closure-compiler-v$CLOSURE_COMPILER_VERSION.jar
  mv closure-compiler-v$CLOSURE_COMPILER_VERSION.jar closure-compiler.jar
  rm "compiler-$CLOSURE_COMPILER_VERSION.tar.gz"
fi

externs=$(find . -name '*.ext.js' -not -path '*/target/*' -exec echo -en ' --externs {}' \;)

java -jar closure-compiler.jar \
  --js extern-test.js \
  --warning_level $LEVEL \
  $externs
