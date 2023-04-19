
/** @interface */
function Plot() {};

Plot.prototype.setData = function (d) {};
Plot.prototype.setupGrid = function() {};
Plot.prototype.draw = function() {};
Plot.prototype.getPlaceholder = function() {};
Plot.prototype.getCanvas = function() {};
Plot.prototype.getPlotOffset = function() {};
Plot.prototype.width = function () {};
Plot.prototype.height = function () {};
Plot.prototype.offset = function () {};
Plot.prototype.getData = function () {};
Plot.prototype.getAxes = function () {};
Plot.prototype.getXAxes = function () {};
Plot.prototype.getYAxes = function () {};
Plot.prototype.c2p = function(pos) {};
Plot.prototype.p2c = function(pos) {};
Plot.prototype.getOptions = function () {};
Plot.prototype.highlight = function (s, point, auto) {};
Plot.prototype.unhighlight = function (s, point) {};
Plot.prototype.triggerRedrawOverlay = function() {};
Plot.prototype.pointOffset = function(point) {};
Plot.prototype.shutdown = function() {};
Plot.prototype.destroy = function () {};
Plot.prototype.resize = function () {};
Plot.prototype.hooks = {
    processOptions: [],
    processRawData: [],
    processDatapoints: [],
    processOffset: [],
    drawBackground: [],
    drawSeries: [],
    draw: [],
    bindEvents: [],
    drawOverlay: [],
    shutdown: []
};

/** @return {!Plot} */
jQuery.prototype.plot = function(placeholder, data, options) {};
jQuery.prototype.plot.version;
jQuery.prototype.plot.plugins;

jQuery.prototype.color = {};
jQuery.prototype.color.make = function (r, g, b, a) {};
jQuery.prototype.color.extract = function (elem, css) {};
jQuery.prototype.color.parse = function (str) {};

