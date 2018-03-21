const webpack = require('webpack');

module.exports = {
  entry: {
    'dist/connect' : [
      './node_modules/@0xproject/connect/lib/src/index.js'
    ],
    'dist/connect.min' : [
      './node_modules/@0xproject/connect/lib/src/index.js'
    ]
  },
  debug: false,
  output: {
    filename: '[name].js',
    libraryTarget : 'var',
    library : 'connect'
  },
  externals: {
    "web3" : "Web3",
    "crypto-js" : "CryptoJS",
    "bignumber" : "BigNumber",
    "iconv-lite" : "iconv-lite"
  },
  resolveLoader: {
    modulesDirectories: ['','node_modules']
  },
  plugins: [
    new webpack.DefinePlugin({
      "process.env": {
        NODE_ENV: JSON.stringify("production")
      }
    }),
    new webpack.optimize.UglifyJsPlugin({
      include: /\.min\.js$/,
      minimize: true
    })
  ],
  resolve: {
    extensions: ['','.js']
  },
  module: {
    loaders: [
      { test: /\.json$/, loader: "json-loader" },
      { test: /\.js$/, loaders:['babel'], exclude: /node_modules/ },
    ]
  }
};
