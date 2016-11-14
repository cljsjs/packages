var path = require('path');

module.exports = {
    entry: [
        path.join(__dirname, 'entry.js')
    ],

    output: {
        libraryTarget: "umd",
        library: "Victory"
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
