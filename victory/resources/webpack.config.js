var path = require('path');

var isProduction = process.argv.indexOf('--production') !== -1;

var entryPath = "./entry.js";
var entryName = "victory";

var entry = {};
if (isProduction) {
  entryName = entryName + ".min";
}

entry[entryName] = entryPath;

module.exports = {
    entry: entry,

    output: {
        libraryTarget: "umd",
        library: "Victory",
        filename: '[name].inc.js'
    },

    externals: {
        "react": "React"
    },

    module: {
        loaders: [
            {
                test: /\.js$/,
                loaders: [
                    "babel"
                ]
            },
        ]
    }
}
