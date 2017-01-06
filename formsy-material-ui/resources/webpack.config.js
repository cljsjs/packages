var path = require('path');

module.exports = {
    entry: path.join(__dirname, "lib", "index.js"),

    externals: {
        "react": "React",
        "react-dom": "ReactDOM",
        "material-ui/AutoComplete": "MaterialUI.AutoComplete",
        "material-ui/Checkbox": "MaterialUI.Checkbox",
        "material-ui/DatePicker": "MaterialUI.DatePicker",
        "material-ui/RadioButton": "MaterialUI.RadioButton",
        "material-ui/RadioButtonGroup": "MaterialUI.RadioButtonGroup",
        "material-ui/SelectField": "MaterialUI.SelectField",
        "material-ui/TextField": "MaterialUI.TextField",
        "material-ui/TimePicker": "MaterialUI.TimePicker",
        "material-ui/Toggle": "MaterialUI.Toggle",
        "formsy-react": "Formsy"
    },

    output: {
        path: path.join(__dirname, "build"),
        publicPath: "/build/",
        filename: "formsy-material-ui.js",
        libraryTarget: "var",
        library: "FormsyMaterialUI"
    },

    node: {
        fs: 'empty'
    }
}
