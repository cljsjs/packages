#!/bin/bash

# Some duplicate externs manually excluded

externs=$(for ext in $(find . \
    -name '*.ext.js' \
    -not -path '*/target/*' \
    -not -wholename './jquery_1/*/jquery.ext.js' \
    -not -wholename './highstock/*/highstock.ext.js' \
    -not -wholename './material-ui/*/react.ext.js' \
    -not -wholename './material-ui/*/react-dom.ext.js'); do
echo -en "--externs $ext "
done)

echo "TESTING:"
echo $externs

    # --warning_level VERBOSE \

java -jar node_modules/google-closure-compiler/compiler.jar --js extern-test.js $externs
