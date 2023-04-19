const path = require('path');
const webpack = require('webpack');
const autoprefixer = require('autoprefixer');
const ExtractTextPlugin = require('extract-text-webpack-plugin');

var entryName = "react-dates.inc";

module.exports = {
  entry: path.join(__dirname, "index.js"),

  externals: {
    "moment": "moment",
    "react": "React",
    "react-dom": "ReactDOM",
  },

  output: {
    path: path.join(__dirname, "build"),
    publicPath: "/build/",
    filename: entryName + ".js",
    libraryTarget: "var",
    library: "ReactDates"
  },

  resolve: {
    extensions: ['.js', '.scss', '.json']
  },

  module: {
    loaders: [
      {
        test: /\.js$/,
        exclude: /(node_modules)/,
        loader: 'babel-loader'
      },
      {
        test: /(\.scss|\.css)$/,
        loader: ExtractTextPlugin.extract({ fallback: 'style-loader', use: 'css?sourceMap&modules&importLoaders=1&localIdentName=[name]__[local]___[hash:base64:5]!postcss!sass?sourceMap' })
      }
    ]
  },

  node: {
    fs: 'empty'
  },

  plugins: [
    new ExtractTextPlugin({allChunks: true, filename: entryName + '.css'}),
    new webpack.LoaderOptionsPlugin({
      options: {
        postcss: [autoprefixer]
      }
    })
  ]
}

