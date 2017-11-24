var mdc = {
  "base": {
    "MDCFoundation": function () {},
    "MDCComponent": function () {}
  },
  "checkbox": {
    "MDCCheckboxFoundation": function () {},
    "MDCCheckbox": function () {}
  },
  "formField": {
      "MDCFormField": function () {},
      "MDCFormFieldFoundation": function () {}
  },
  "gridList": {
    "MDCGridListFoundation": function () {},
    "MDCGridList": function () {}
  },
  "iconToggle": {
    "MDCIconToggleFoundation": function () {},
    "MDCIconToggle": function () {}
  },
  "radio": {
    "MDCRadioFoundation": function () {},
    "MDCRadio": function () {}
  },
  "ripple": {
    "MDCRippleFoundation": function () {},
    "MDCRipple": function () {}
  },
  "snackbar": {
    "MDCSnackbarFoundation": function () {},
    "MDCSnackbar": function () {}
  },
    "dialog": {
        "MDCDialogFoundation": function () {},
        "MDCDialog": function () {},
        "util": function () {}
    },
  "drawer": {
    "MDCTemporaryDrawer": function () {},
    "MDCTemporaryDrawerFoundation": function () {},
    "MDCPersistentDrawer": function () {},
    "MDCPersistentDrawerFoundation": function () {},
    "util": function () {}
  },
  "textField": {
    "MDCTextFieldFoundation": function () {},
    "MDCTextField": function () {}
  },
  "menu": {
    "MDCSimpleMenu": function () {},
    "MDCSimpleMenuFoundation": function () {}
  },
  "select": {
    "MDCSelectFoundation": function () {},
    "MDCSelect": function () {}
  },
    "toolbar": {
        "MDCToolBarFoundation": function () {},
        "MDCToolBar": function () {}
    },
  "autoInit": {
    "register": function () {},
    "deregister": function () {},
    "deregisterAll": function () {}
  }
};

/* Checkbox*/

mdc.checkbox.MDCCheckboxFoundation.cssClasses = {};
mdc.checkbox.MDCCheckboxFoundation.defaultAdapter = {};
mdc.checkbox.MDCCheckboxFoundation.numbers = {};
mdc.checkbox.MDCCheckboxFoundation.strings = {};

mdc.checkbox.MDCCheckboxFoundation.prototype = {
  "destroy": function() {},
  "init": function() {},
  "isChecked": function() {},
  "isDisabled": function() {},
  "isIndeterminate": function() {},
  "setChecked": function() {},
  "setDisabled": function() {},
  "setIndeterminate": function() {}
};

/* Icon Toggle */

mdc.iconToggle.MDCIconToggleFoundation.cssClasses = {};
mdc.iconToggle.MDCIconToggleFoundation.defaultAdapter = {};
mdc.iconToggle.MDCIconToggleFoundation.strings = {};

mdc.iconToggle.MDCIconToggleFoundation.prototype = {
  "destroy": function() {},
  "init": function() {},
  "isOn": function() {},
  "isSpace": function() {},
  "refreshToggleData": function() {},
  "toggle": function() {}
};

/* Radio */

mdc.radio.MDCRadioFoundation.cssClasses = {};
mdc.radio.MDCRadioFoundation.strings = {};
mdc.radio.MDCRadioFoundation.defaultAdapter = {};

mdc.radio.MDCRadioFoundation.prototype = {
  "destroy": function() {},
  "init": function() {},
  "isChecked": function() {},
  "isDisabled": function() {},
  "setChecked": function() {},
  "setDisabled": function() {},
};

/* Ripple */

mdc.ripple.MDCRippleFoundation.cssClasses = {};
mdc.ripple.MDCRippleFoundation.strings = {};
mdc.ripple.MDCRippleFoundation.numbers = {};
mdc.ripple.MDCRippleFoundation.defaultAdapter = {};

mdc.ripple.MDCRippleFoundation.prototype = {
  "destroy": function() {},
  "init": function() {},
  "layout": function() {}
};

/* Snackbar */

mdc.snackbar.MDCSnackbarFoundation.cssClasses = {};
mdc.snackbar.MDCSnackbarFoundation.strings = {};
mdc.snackbar.MDCSnackbarFoundation.defaultAdapter = {};

mdc.snackbar.MDCSnackbarFoundation.prototype = {
  "destroy": function() {},
  "init": function() {},
  "show": function() {}
};

/* Drawer*/

mdc.drawer.MDCTemporaryDrawerFoundation.cssClasses = {};
mdc.drawer.MDCTemporaryDrawerFoundation.defaultAdapter = {};
mdc.drawer.MDCTemporaryDrawerFoundation.numbers = {};
mdc.drawer.MDCTemporaryDrawerFoundation.strings = {};

mdc.drawer.MDCTemporaryDrawerFoundation.prototype = {
  "close": function () {},
  "destroy": function () {},
  "init": function () {},
  "isOpen": function () {},
  "open": function () {}
};

mdc.drawer.MDCPersistentDrawerFoundation.cssClasses = {};
mdc.drawer.MDCPersistentDrawerFoundation.defaultAdapter = {};
mdc.drawer.MDCPersistentDrawerFoundation.numbers = {};
mdc.drawer.MDCPersistentDrawerFoundation.strings = {};

mdc.drawer.MDCPersistentDrawerFoundation.prototype = {
    "close": function () {},
    "destroy": function () {},
    "init": function () {},
    "isOpen": function () {},
    "open": function () {}
};

/* Grid List */

mdc.gridList.MDCGridList.attachTo = function(root) {};

mdc.gridList.MDCGridListFoundation.defaultAdapter = {};
mdc.gridList.MDCGridListFoundation.strings = {};

mdc.gridList.MDCGridListFoundation.prototype = {
  "alignCenter": function() {},
  "destroy": function() {},
  "init": function() {},
};

/* Textfield */

mdc.textField.MDCTextFieldFoundation.cssClasses = {};
mdc.textField.MDCTextFieldFoundation.defaultAdapter = {};
mdc.textField.MDCTextFieldFoundation.strings = {};

mdc.textField.MDCTextFieldFoundation.prototype = {
  "destroy": function() {},
  "init": function() {},
  "isDisabled": function() {},
  "setDisabled": function() {},
};

/* Simple Menu */

mdc.menu.MDCSimpleMenuFoundation.cssClasses = {};
mdc.menu.MDCSimpleMenuFoundation.defaultAdapter = {};
mdc.menu.MDCSimpleMenuFoundation.numbers = {};
mdc.menu.MDCSimpleMenuFoundation.strings = {};

mdc.menu.MDCSimpleMenuFoundation.prototype = {
  "close": function() {},
  "destroy": function() {},
  "init": function() {},
  "isOpen": function() {},
  "open": function() {},
};

/* Select Menu */

mdc.select.MDCSelectFoundation.cssClasses = {};
mdc.select.MDCSelectFoundation.defaultAdapter = {};

mdc.select.MDCSelectFoundation.prototype = {
  "destroy": function() {},
  "getSelectedIndex": function() {},
  "init": function() {},
  "isDisabled": function() {},
  "resize": function() {},
  "setDisabled": function() {},
  "setSelectedIndex": function() {},
};
