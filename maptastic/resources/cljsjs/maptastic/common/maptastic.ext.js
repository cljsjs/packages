var Maptastic = function() {

  var getProp = function() {}

  var showLayerNames       = getProp(config, 'labels', true);
  var showCrosshairs       = getProp(config, 'crosshairs', false);
  var showScreenBounds     = getProp(config, 'screenbounds', false);
  var autoSave             = getProp(config, 'autoSave', true);
  var autoLoad             = getProp(config, 'autoLoad', true);
  var layerList            = getProp(config, 'layers', []);
  var layoutChangeListener = getProp(config, 'onchange', function(){} );
  var localStorageKey      = 'maptastic.layers';

  var canvas;
  var context;

  var layers;

  var configActive;

  var dragging;
  var dragOffset;

  var selectedLayer;
  var selectedPoint;
  var selectionRadius;
  var hoveringPoint;
  var hoveringLayer;
  var dragOperation;
  var isLayerSoloed;

  var mousePosition;
  var mouseDelta;
  var mouseDownPoint;

	var distanceTo = function(x1, y1, x2, y2) {}
  var pointInTriangle = function(point, a, b, c) {}
	var pointInLayer = function(point, layer) {};

  var notifyChangeListener = function() {};
	var draw = function() {}

	var swapLayerPoints = function(){}

	var init = function(){};

	var rotateLayer = function() {}

	var mouseMove = function() {};

	var mouseUp = function() {};

	var mouseDown = function() {};

	var addLayer = function() {};

  var saveSettings = function() {};

  var loadSettings = function() {}

	var updateTransform = function() {}

	var setConfigEnabled = function(){};

	var clonePoints = function(){};

	var resize = function() {};

  var getLayout = function() {}

  var setLayout = function(){}
}
