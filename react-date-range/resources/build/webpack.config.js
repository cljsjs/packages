var path = require('path');

module.exports = {
    entry: path.join(__dirname, "dist", "index.js"),

    externals: {
        "moment": "moment",
        "react": "React"
    },

    output: {
        path: path.join(__dirname, "build"),
        publicPath: "/build/",
        filename: "react-date-range.js",
        libraryTarget: "var",
        library: "ReactDateRange"
    },

    node: {
        fs: 'empty'
    }
}
