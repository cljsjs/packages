var webpack = require('webpack');

module.exports = {
  entry: './src/index.js',

  module: {
    loaders: [
      {
        test: /\.jsx?$/,
        loader: 'babel-loader',
        exclude: /node_modules/
      },
    ]
  },

  externals: {
    'react': 'React',
    'react-dom': 'ReactDOM',
  },

  output: {
    filename: 'dist/react-autosize-textarea.js',
    libraryTarget: 'umd',
    library: 'TextareaAutosize'
  },

  resolve: {
    extensions: ['.jsx', '.js']
  }
};
