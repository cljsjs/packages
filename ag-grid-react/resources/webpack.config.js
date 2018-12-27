const path = require('path');
process.env.NODE_ENV = "production";

var entryName = "ag-grid-react.inc";

module.exports = {
    entry: path.join(__dirname, "main.js"),

    externals: {
        "react": "React",
        "react-dom": "ReactDOM",
        "ag-grid-community": "agGrid"
    },

    output: {
        filename: entryName + ".js",
        libraryTarget: "var",
        library: "agGridReact"
    },

    resolve: {
        extensions: ['', '.js']
    }
};
