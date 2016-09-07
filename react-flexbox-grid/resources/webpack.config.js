var path = require('path');
const pkg = require('./package');
const webpack = require('webpack');
const autoprefixer = require('autoprefixer');
const ExtractTextPlugin = require('extract-text-webpack-plugin');

var entryName = "react-flexbox-grid.inc";

module.exports = {
    entry: path.join(__dirname, "lib", "index.js"),

    externals: {
        "react": "React"
    },

    output: {
        path: path.join(__dirname, "build"),
        publicPath: "/build/",
        filename: entryName + ".js",
        libraryTarget: "var",
        library: "ReactFlexboxGrid"
    },

    resolve: {
        extensions: ['', '.js', '.scss', '.json']
    },

    module: {
        loaders: [
          {
            test: /\.js$/,
            exclude: /(node_modules)/,
            loader: 'babel'
          },
          {
            test: /(\.scss|\.css)$/,
            loader: ExtractTextPlugin.extract('style-loader', 'css?sourceMap&modules&importLoaders=1&localIdentName=[name]__[local]___[hash:base64:5]!postcss!sass?sourceMap')
          }
        ]
    },

    postcss: [autoprefixer],

    node: {
        fs: 'empty'
    },

    plugins: [
        new ExtractTextPlugin( entryName + '.css', {allChunks: true})
    ]
}
