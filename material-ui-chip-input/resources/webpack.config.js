var path = require('path');

module.exports = {
  entry: {
    'material-ui-chip-input' :'./main.js'
  },
  output: {
    filename: "[name].inc.js",
  },
  externals: {
    "react": "React",
    "@material-ui/core/Chip": "MaterialUI.Chip",
    "@material-ui/core/Input": "MaterialUI.Input",
    "@material-ui/core/FilledInput/FilledInput": "MaterialUI.FilledInput",
    "@material-ui/core/InputLabel": "MaterialUI.InputLabel",
    "@material-ui/core/FormControl": "MaterialUI.FormControl",
    "@material-ui/core/FormHelperText": "MaterialUI.FormHelperText",
    "@material-ui/core/styles/transitions": "MaterialUIStyles.transitions",
    "@material-ui/core/styles/colors/blue": "MaterialUIStyles.colors.blue"
  }
};
