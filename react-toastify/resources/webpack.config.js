module.exports = {
  entry: {
    'react-toastify': './main.js'
  },
  output: {
    filename: '[name].inc.js'
  },
  externals: {
    'react': 'React',
    'react-dom': 'ReactDOM',
  }
};
