module.exports = {
  entry: {
    'material-table': './main.js'
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
      const reStyles = /^@material-ui\/core\/styles\/(.*)$/;
      if (reStyles.test(request)) {
        const [_, name] = reStyles.exec(request);
        const external =
          (name === 'colorManipulator')
          ? "MaterialUIStyles"
          : `MaterialUIStyles.${name}`;
        return callback(null, `root ${external}`);
      }
      const reCore = /^@material-ui\/core\/(.*)$/;
      if (reCore.test(request)) {
        const [_, name] = reCore.exec(request);
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
