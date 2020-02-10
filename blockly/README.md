# cljsjs/blockly

This provides (https://developers.google.com/blockly/)[Blockly], a library for building Scratch-like visual programming languages. It is used by (https://github.com/ParkerICI/blockoid)[Blockoid] which provides a lightweight Clojurescript API.

[](dependency)
```clojure
[cljsjs/blockly "3.20200123.1-0"] ;; latest release (versions track Blockly release versions)
```
[](/dependency)

# Notes

Blockly provides extensive multi-language support, but this only packages the English strings. Could easily be extended or customized for other languages.

# Ext generation

Install https://github.com/jmmk/javascript-externs-generator and:

    generate-extern -f ...blockly/blockly_compressed.js -n Blockly -o blockly.ext.js
	

