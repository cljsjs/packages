Quill = function(elem) {};
Quill = function(elem, configs) {};

Quill.prototype.getText = function() {};
Quill.prototype.getText = function(start) {};
Quill.prototype.getText = function(start, end) {};

Quill.prototype.getLength = function() {};

Quill.prototype.getContents = function() {};
Quill.prototype.getContents = function(start) {};
Quill.prototype.getContents = function(start, end) {};

Quill.prototype.getHTML = function() {};

Quill.prototype.insertText = function(index, text) {};
Quill.prototype.insertText = function(index, text, name, value) {};
Quill.prototype.insertText = function(index, text, source) {};
Quill.prototype.insertText = function(index, text, name, value, source) {};
Quill.prototype.insertText = function(index, text, formats, source) {};

Quill.prototype.deleteText = function(start, end) {};
Quill.prototype.deleteText = function(start, end, source) {};

Quill.prototype.formatText = function(start, end) {};
Quill.prototype.formatText = function(start, end, name, value) {};
Quill.prototype.formatText = function(start, end, formats) {};

Quill.prototype.insertEmbed = function(index, type, url) {};
Quill.prototype.insertEmbed = function(index, type, url, source) {};

Quill.prototype.updateContents = function(delta) {};

Quill.prototype.setContents = function(delta) {};

Quill.prototype.setHTML = function(html) {};

Quill.prototype.setText = function(text) {};

Quill.prototype.getSelection = function() {};

Quill.prototype.setSelection = function(start, end) {};
Quill.prototype.setSelection = function(start, end, source) {};
Quill.prototype.setSelection = function(range) {};

Quill.prototype.prepareFormat = function(format, value) {};

Quill.prototype.focus = function() {};

Quill.registerModule = function(name, fn) {};

Quill.prototype.addModule = function(name, options) {};

Quill.prototype.getModule = function(name) {};

Quill.prototype.onModuleLoad = function(name, callback) {};

Quill.prototype.addFormat = function(name, config) {};

Quill.prototype.addContainer = function(cssClass, before) {};

Quill.prototype.on = function(event, fn) {};