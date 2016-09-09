var path = require('path');
var webpack = require('webpack');

module.exports = [{
  entry: path.join(__dirname, "src", "index.js"),

  externals: {
    "react": "React",
    "react-dom": "ReactDOM",
    "classnames": "classNames"
  },

  output: {
    filename: "rc-slider.js",
    libraryTarget: 'umd',
    library: 'Slider'
  },

  module: {
    loaders: [{
      loader: 'babel',
      exclude: /node_modules/,
      query: {
        presets: ['es2015', 'react', 'stage-0'],
        plugins: ['add-module-exports']
      }
    }]
  },

  resolve: {
    extensions: ['', '.js', '.jsx'],
  }
},{
  entry: path.join(__dirname, "src", "index.js"),

  externals: {
    "react": "React",
    "react-dom": "ReactDOM",
    "classnames": "classNames"
  },

  output: {
    filename: "rc-slider.min.js",
    libraryTarget: 'umd',
    library: 'Slider'
  },

  module: {
    loaders: [{
      loader: 'babel',
      exclude: /node_modules/,
      query: {
        presets: ['es2015', 'react', 'stage-0'],
        plugins: ['add-module-exports']
      }
    }]
  },

  resolve: {
    extensions: ['', '.js', '.jsx'],
  },

  plugins: [
    new webpack.DefinePlugin({
      'process.env': {
        NODE_ENV: JSON.stringify('production')
      }
    }),
    new webpack.optimize.UglifyJsPlugin({
      output: {
        comments: false
      },
      compress: {
        warnings: false
      }
    })
  ]
}]
