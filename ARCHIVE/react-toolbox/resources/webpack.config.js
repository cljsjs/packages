const pkg = require('./package');
const path = require('path');
const webpack = require('webpack');
const ExtractTextPlugin = require('extract-text-webpack-plugin');

const entryName = "react-toolbox.inc";

const extractCss = new ExtractTextPlugin({ filename: entryName + '.css', allChunks: true });

module.exports = {
    target: 'web',
    context: __dirname,
    entry: path.join(__dirname, "components", "index.js"),
    externals: {
        "react": "React",
        "react-dom": "ReactDOM",
        "react-addons-css-transition-group": "React.addons.CSSTransitionGroup"
    },
    output: {
        path: __dirname,
        filename: entryName + '.js',
        libraryTarget: 'var',
        library: 'ReactToolbox'
    },
    resolve: {
        extensions: ['.js', '.css', '.json'],
        modules: ['node_modules']
    },
    module: {
        rules: [
            {
                test: /\.js$/,
                use: 'babel-loader',
                include: [
                    path.join(__dirname, './components'),
                    path.join(__dirname, './spec')
                ]
            }, {
                test: /\.css$/,
                include: [
                    path.join(__dirname, './components'),
                    path.join(__dirname, './spec'),
                        /node_modules/
                ],
                use: extractCss.extract({
                    fallback: 'style-loader',
                    use: [
                        {
                            loader: 'css-loader',
                            query: {
                                modules: true,
                                localIdentName: '[name]__[local]___[hash:base64:5]',
                                sourceMap: true
                            },
                        },
                        'postcss-loader'
                    ]})
            }
        ]
    },
    plugins: [
        new webpack.LoaderOptionsPlugin({
            options: {
                context: __dirname,
                postcss: function () {
                    return [
                        require('postcss-import')({
                            root: __dirname,
                            path: [path.join(__dirname, './components')]
                        }),
                        require('postcss-mixins')(),
                        require('postcss-each')(),
                        require('postcss-cssnext')(),
                        require('postcss-reporter')({
                            clearMessages: true
                        })
                    ];
                }
            }
        }),
        extractCss,
        new webpack.HotModuleReplacementPlugin(),
        new webpack.DefinePlugin({
            'process.env.NODE_ENV': JSON.stringify('production'),
            VERSION: JSON.stringify(pkg.version)
        })
    ]
};
