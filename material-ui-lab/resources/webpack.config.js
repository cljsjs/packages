module.exports = {
  entry: {
    'material-ui-lab': './main.js'
  },
  output: {
    filename: '[name].inc.js'
  },
  externals: [
    {
      'react': 'React',
      'react-dom': 'ReactDOM',
      '@material-ui/core': 'MaterialUI',
      '@material-ui/core/utils': 'MaterialUI',
      '@material-ui/colors': 'MaterialUIColors',
      '@material-ui/styles': 'MaterialUIStyles'
    },
    function(context, request, callback) {
      const re = /^@material-ui\/core\/(.*)$/;
      if (re.test(request)) {
        const [_, name] = re.exec(request);
        const external =
          (name === 'styles')
          ? 'MaterialUIStyles'
          : `MaterialUI.${name}`;
        return callback(null, `root ${external}`);
      }
      callback();
    }
  ]
};
