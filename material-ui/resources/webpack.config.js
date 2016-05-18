var webpack = require("webpack");
var path = require('path');
var svgIcons = process.argv.indexOf('--svg-icons') !== -1;
var isProduction = process.argv.indexOf('--production') !== -1;
var entryPath = "./main.js";
var entryName = "material-ui";
var output = {
    filename: '[name].inc.js'
};
var nodeModulesPath = path.resolve(__dirname, 'node_modules');


if (svgIcons) {
    output['libraryTarget'] = 'var';
    output['library'] = 'MaterialUISvgIcons';
    entryPath =  "./src/svg-icons/index.js";
    entryName = "material-ui-svg-icons";
}

var entry = {};
if (isProduction) {
    entryName = entryName + ".min";
}
entry[entryName] = entryPath;

module.exports = {
    entry : entry,
    output: output,
    module: {
        loaders: [
            {
                test: /\.js$/,
                loaders: ['babel-loader'],
                exclude: [nodeModulesPath]
            },
        ],
    },

    plugins: [
        new webpack.DefinePlugin({
            'process.env': {
                'NODE_ENV': isProduction ? '"production"' : '"development"'
            }
        }),
        new webpack.optimize.UglifyJsPlugin({
            include: /\.min\.inc\.js$/,
            minimize: true
        })
    ]
};
