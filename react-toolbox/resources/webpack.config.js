const path = require('path');
const webpack = require('webpack');
const autoprefixer = require('autoprefixer');
const ExtractTextPlugin = require('extract-text-webpack-plugin');
process.env.NODE_ENV = "production";

var entryName = "react-toolbox.inc";

module.exports = {
    entry: path.join(__dirname, "components", "index.js"),

    externals: {
        "react": "React",
        "react-dom": "ReactDOM"
    },

    output: {
        filename: entryName + ".js",
        libraryTarget: "var",
        library: "ReactToolbox"
    },

    resolve: {
        extensions: ['', '.js', '.jsx', '.scss', ".css"]
    },

    module: {
        loaders: [
            {
                test: /(\.js|\.jsx)$/,
                exclude: /(node_modules)/,
                loader: "babel",
                query: {
                    presets: ['es2015', 'react', 'stage-0'],
                    plugins: ['add-module-exports']
                }
            }, {
                test: /\.css$/,
                include: /node_modules/,
                loader: ExtractTextPlugin.extract('style', 'css')
            }, {
                test: /\.css$/,
                include: [path.join(__dirname, './components'), path.join(__dirname, './spec')],
                loader: ExtractTextPlugin.extract('style', 'css?sourceMap&modules&importLoaders=1&localIdentName=[name]__[local]___[hash:base64:5]!postcss')
            }
        ]
    },

    postcss () {
        return [
            require('postcss-import')({
                root: __dirname,
                path: [path.join(__dirname, './components')]
            }),
            require('postcss-mixins')(),
            require('postcss-each')(),
            require('postcss-cssnext')(),
            require('postcss-reporter')({ clearMessages: true })
        ];
    },
    plugins: [
        new ExtractTextPlugin(entryName + '.css', {allChunks: true})
    ]
};
