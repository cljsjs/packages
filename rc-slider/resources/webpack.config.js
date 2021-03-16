module.exports = {
  entry: {
    'rc-slider': './main.js'
  },
  output: {
    filename: '[name].inc.js'
  },
  externals: {
    'react': 'React',
    'react-dom': 'ReactDOM',
  }
};
