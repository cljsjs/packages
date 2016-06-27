'use strict';

const path = require('path')
const webpack = require('webpack')
const autoprefixer = require('autoprefixer')

const isProduction = process.argv.indexOf('--production') !== -1

let entryPath = './lib/index.js'
let entryName = 'index'
let entry = {}
if (isProduction) {
    entryName = entryName + '.min'
}
entry[entryName] = entryPath

let output = {
    filename: '[name].inc.js'
    , library: 'ReactToolbox'
    , libraryTarget: 'umd'
}

module.exports = {
        entry: entry
        , output: output
        , devtool: 'source-map'
        , resolve: {
            extensions: ['', '.scss', '.css', '.js', '.json']
            , modulesDirectories: [
                path.resolve(__dirname, './node_modules')
            ]
        }
        , module: {
            loaders: [
                {
                    test: /(\.js|\.jsx)$/
                    , exclude: /(node_modules)/
                    , loader: 'babel'
                    , query: { presets: ['es2015', 'stage-0', 'react'] }
                }, {
                    test: /(\.scss|\.css)$/
                    , loader: 'style?insertAt=top!css?sourceMap&modules&importLoaders=1&localIdentName=[name]__[local]___[hash:base64:5]!postcss!sass'
                }
            ]
        }
        , externals: {
            react: {
                root: 'React'
                , commonjs: 'react'
                , commonjs2: 'react'
            }
            , 'react-dom': {
                root:  'ReactDOM'
                , commonjs: 'react-dom'
                , commonjs2: 'react-dom'
            }
            // https://webpack.github.io/docs/configuration.html#externals
            , 'react-addons-css-transition-group': 'var React.addons.CSSTransitionGroup'
        }
        , postcss: [autoprefixer]
        , plugins: [
            new webpack.NoErrorsPlugin()
            , new webpack.DefinePlugin({
                'process.env.NODE_ENV': isProduction ? '"production"' : '"development"'
            })
            , new webpack.optimize.UglifyJsPlugin({
                minimize: true
                    , include: /\.min\.inc\.js$/
            })
        ]
}
