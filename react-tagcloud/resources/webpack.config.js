module.exports = {
  entry: {
    'react-tagcloud': './main.js'
  },
  output: {
    filename: '[name].inc.js'
  },
  externals: {
    'react': 'React',
    'react-dom': 'ReactDOM'
  }
};
