const path = require('path');

module.exports = function(env, argv) {
  const isDevel = argv.mode === 'development';

  return {
    entry: {
      'material-ui-currency-textfield': './main.js'
    },
    devtool: 'none',
    output: {
      filename: isDevel ? '[name].inc.js' : '[name].min.inc.js',
      path: path.resolve(__dirname, 'cljsjs/material-ui-currency-textfield', argv.mode),
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
        'prop-types': 'PropTypes',
        'react': 'React',
        'react-dom': 'ReactDOM',
        '@material-ui/core': 'MaterialUI',
        '@material-ui/styles': 'MaterialUIStyles'
      }
    ]
  };
}
