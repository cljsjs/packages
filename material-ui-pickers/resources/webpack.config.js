module.exports = {
  entry: {
    'material-ui-pickers': './main.js'
  },
  output: {
    filename: '[name].inc.js'
  },
  externals: [
    function(context, request, callback) {
      const re = /^@material-ui\/core\/(.*)$/;
      if (re.test(request)) {
        const [_, name] = re.exec(request);
        const external = name === 'styles' ? 'MaterialUIStyles' : `MaterialUI.${name}`;
        return callback(null, `root ${external}`);
      }
      callback();
    },
    {
      'react': 'React',
      'react-dom': 'ReactDOM',
      '@material-ui/styles': 'MaterialUIStyles'
    }
  ]
};
