// D3 Extern generated using: https://github.com/jmmk/javascript-externs-generator
// With some externs added by hand: Every d3-force objects and the d3.zoom

var d3 = {
  "format": function () {},
  "formatPrefix": function () {},
  "timeFormat": function () {},
  "timeParse": function () {},
  "utcFormat": function () {},
  "utcParse": function () {},
  "event": {},
  "version": {},
  "bisect": function () {},
  "bisectRight": function () {},
  "bisectLeft": function () {},
  "ascending": function () {},
  "bisector": function () {},
  "descending": function () {},
  "deviation": function () {},
  "extent": function () {},
  "histogram": function () {},
  "thresholdFreedmanDiaconis": function () {},
  "thresholdScott": function () {},
  "thresholdSturges": function () {},
  "max": function () {},
  "mean": function () {},
  "median": function () {},
  "merge": function () {},
  "min": function () {},
  "pairs": function () {},
  "permute": function () {},
  "quantile": function () {},
  "range": function () {},
  "scan": function () {},
  "shuffle": function () {},
  "sum": function () {},
  "ticks": function () {},
  "tickStep": function () {},
  "transpose": function () {},
  "variance": function () {},
  "zip": function () {},
  "entries": function () {},
  "keys": function () {},
  "values": function () {},
  "map": function () {},
  "set": function () {},
  "nest": function () {},
  "randomUniform": function () {},
  "randomNormal": function () {},
  "randomLogNormal": function () {},
  "randomBates": function () {},
  "randomIrwinHall": function () {},
  "randomExponential": function () {},
  "easeLinear": function () {},
  "easeQuad": function () {},
  "easeQuadIn": function () {},
  "easeQuadOut": function () {},
  "easeQuadInOut": function () {},
  "easeCubic": function () {},
  "easeCubicIn": function () {},
  "easeCubicOut": function () {},
  "easeCubicInOut": function () {},
  "easePoly": {
    "exponent": function () {}
  },
  "easePolyIn": {
    "exponent": function () {}
  },
  "easePolyOut": {
    "exponent": function () {}
  },
  "easePolyInOut": {
    "exponent": function () {}
  },
  "easeSin": function () {},
  "easeSinIn": function () {},
  "easeSinOut": function () {},
  "easeSinInOut": function () {},
  "easeExp": function () {},
  "easeExpIn": function () {},
  "easeExpOut": function () {},
  "easeExpInOut": function () {},
  "easeCircle": function () {},
  "easeCircleIn": function () {},
  "easeCircleOut": function () {},
  "easeCircleInOut": function () {},
  "easeBounce": function () {},
  "easeBounceIn": function () {},
  "easeBounceOut": function () {},
  "easeBounceInOut": function () {},
  "easeBack": {
    "overshoot": function () {}
  },
  "easeBackIn": {
    "overshoot": function () {}
  },
  "easeBackOut": {
    "overshoot": function () {}
  },
  "easeBackInOut": {
    "overshoot": function () {}
  },
  "easeElastic": {
    "amplitude": function () {},
    "period": function () {}
  },
  "easeElasticIn": {
    "amplitude": function () {},
    "period": function () {}
  },
  "easeElasticOut": {
    "amplitude": function () {},
    "period": function () {}
  },
  "easeElasticInOut": {
    "amplitude": function () {},
    "period": function () {}
  },
  "polygonArea": function () {},
  "polygonCentroid": function () {},
  "polygonHull": function () {},
  "polygonContains": function () {},
  "polygonLength": function () {},
  "path": function () {},
  "quadtree": function () {},
  "queue": function () {},
  "arc": {
    "innerRadius": function () {},
    "outerRadius": function () {},
    "startAngle": function () {},
    "endAngle": function () {},
  },
  "area": {
    "y0": function(){},
    "y1": function(){},
    "x0": function(){},
    "x1": function(){}
  },
  "line": function () {},
  "pie": {
    "value": function () {},
    "sortValues": function () {},
    "sort": function () {},
    "startAngle": function () {},
    "endAngle": function () {},
    "padAngle": function () {}
  },
  "radialArea": function () {},
  "radialLine": {
    "curve": function () {},
    "angle": function () {},
    "radius": function () {}
  },
  "symbol": function () {},
  "symbols": {},
  "symbolCircle": {
    "draw": function () {}
  },
  "symbolCross": {
    "draw": function () {}
  },
  "symbolDiamond": {
    "draw": function () {}
  },
  "symbolSquare": {
    "draw": function () {}
  },
  "symbolStar": {
    "draw": function () {}
  },
  "symbolTriangle": {
    "draw": function () {}
  },
  "symbolWye": {
    "draw": function () {}
  },
  "curveBasisClosed": function () {},
  "curveBasisOpen": function () {},
  "curveBasis": function () {},
  "curveBundle": {
    "beta": function () {}
  },
  "curveCardinalClosed": {
    "tension": function () {}
  },
  "curveCardinalOpen": {
    "tension": function () {}
  },
  "curveCardinal": {
    "tension": function () {}
  },
  "curveCatmullRomClosed": {
    "alpha": function () {}
  },
  "curveCatmullRomOpen": {
    "alpha": function () {}
  },
  "curveCatmullRom": {
    "alpha": function () {}
  },
  "curveLinearClosed": function () {},
  "curveLinear": function () {},
  "curveMonotoneX": function () {},
  "curveMonotoneY": function () {},
  "curveNatural": function () {},
  "curveStep": function () {},
  "curveStepAfter": function () {},
  "curveStepBefore": function () {},
  "stack": function () {},
  "stackOffsetExpand": function () {},
  "stackOffsetNone": function () {},
  "stackOffsetSilhouette": function () {},
  "stackOffsetWiggle": function () {},
  "stackOrderAscending": function () {},
  "stackOrderDescending": function () {},
  "stackOrderInsideOut": function () {},
  "stackOrderNone": function () {},
  "stackOrderReverse": function () {},
  "color": function () {},
  "rgb": function () {},
  "hsl": function () {},
  "lab": function () {},
  "hcl": function () {},
  "cubehelix": function () {},
  "interpolate": function () {},
  "interpolateArray": function () {},
  "interpolateDate": function () {},
  "interpolateNumber": function () {},
  "interpolateObject": function () {},
  "interpolateRound": function () {},
  "interpolateString": function () {},
  "interpolateTransformCss": function () {},
  "interpolateTransformSvg": function () {},
  "interpolateZoom": function () {},
  "interpolateRgb": {
    "gamma": function () {}
  },
  "interpolateRgbBasis": function () {},
  "interpolateRgbBasisClosed": function () {},
  "interpolateHsl": function () {},
  "interpolateHslLong": function () {},
  "interpolateLab": function () {},
  "interpolateHcl": function () {},
  "interpolateHclLong": function () {},
  "interpolateCubehelix": {
    "gamma": function () {}
  },
  "interpolateCubehelixLong": {
    "gamma": function () {}
  },
  "interpolateBasis": function () {},
  "interpolateBasisClosed": function () {},
  "quantize": function () {},
  "dispatch": function () {},
  "dsvFormat": function () {},
  "csvParse": function () {},
  "csvParseRows": function () {},
  "csvFormat": function () {},
  "csvFormatRows": function () {},
  "tsvParse": function () {},
  "tsvParseRows": function () {},
  "tsvFormat": function () {},
  "tsvFormatRows": function () {},
  "request": function () {},
  "html": function () {},
  "json": function () {},
  "text": function () {},
  "xml": function () {},
  "csv": function () {},
  "tsv": function () {},
  "now": function () {},
  "timer": function () {},
  "timerFlush": function () {},
  "timeout": function () {},
  "interval": function () {},
  "timeInterval": function () {},
  "timeMillisecond": {
    "floor": function () {},
    "ceil": function () {},
    "round": function () {},
    "offset": function () {},
    "range": function () {},
    "filter": function () {},
    "count": function () {},
    "every": function () {}
  },
  "timeMilliseconds": function () {},
  "timeSecond": {
    "floor": function () {},
    "ceil": function () {},
    "round": function () {},
    "offset": function () {},
    "range": function () {},
    "filter": function () {},
    "count": function () {},
    "every": function () {}
  },
  "timeSeconds": function () {},
  "timeMinute": {
    "floor": function () {},
    "ceil": function () {},
    "round": function () {},
    "offset": function () {},
    "range": function () {},
    "filter": function () {},
    "count": function () {},
    "every": function () {}
  },
  "timeMinutes": function () {},
  "timeHour": {
    "floor": function () {},
    "ceil": function () {},
    "round": function () {},
    "offset": function () {},
    "range": function () {},
    "filter": function () {},
    "count": function () {},
    "every": function () {}
  },
  "timeHours": function () {},
  "timeDay": {
    "floor": function () {},
    "ceil": function () {},
    "round": function () {},
    "offset": function () {},
    "range": function () {},
    "filter": function () {},
    "count": function () {},
    "every": function () {}
  },
  "timeDays": function () {},
  "timeWeek": {
    "floor": function () {},
    "ceil": function () {},
    "round": function () {},
    "offset": function () {},
    "range": function () {},
    "filter": function () {},
    "count": function () {},
    "every": function () {}
  },
  "timeWeeks": function () {},
  "timeSunday": {
    "floor": function () {},
    "ceil": function () {},
    "round": function () {},
    "offset": function () {},
    "range": function () {},
    "filter": function () {},
    "count": function () {},
    "every": function () {}
  },
  "timeSundays": function () {},
  "timeMonday": {
    "floor": function () {},
    "ceil": function () {},
    "round": function () {},
    "offset": function () {},
    "range": function () {},
    "filter": function () {},
    "count": function () {},
    "every": function () {}
  },
  "timeMondays": function () {},
  "timeTuesday": {
    "floor": function () {},
    "ceil": function () {},
    "round": function () {},
    "offset": function () {},
    "range": function () {},
    "filter": function () {},
    "count": function () {},
    "every": function () {}
  },
  "timeTuesdays": function () {},
  "timeWednesday": {
    "floor": function () {},
    "ceil": function () {},
    "round": function () {},
    "offset": function () {},
    "range": function () {},
    "filter": function () {},
    "count": function () {},
    "every": function () {}
  },
  "timeWednesdays": function () {},
  "timeThursday": {
    "floor": function () {},
    "ceil": function () {},
    "round": function () {},
    "offset": function () {},
    "range": function () {},
    "filter": function () {},
    "count": function () {},
    "every": function () {}
  },
  "timeThursdays": function () {},
  "timeFriday": {
    "floor": function () {},
    "ceil": function () {},
    "round": function () {},
    "offset": function () {},
    "range": function () {},
    "filter": function () {},
    "count": function () {},
    "every": function () {}
  },
  "timeFridays": function () {},
  "timeSaturday": {
    "floor": function () {},
    "ceil": function () {},
    "round": function () {},
    "offset": function () {},
    "range": function () {},
    "filter": function () {},
    "count": function () {},
    "every": function () {}
  },
  "timeSaturdays": function () {},
  "timeMonth": {
    "floor": function () {},
    "ceil": function () {},
    "round": function () {},
    "offset": function () {},
    "range": function () {},
    "filter": function () {},
    "count": function () {},
    "every": function () {}
  },
  "timeMonths": function () {},
  "timeYear": {
    "floor": function () {},
    "ceil": function () {},
    "round": function () {},
    "offset": function () {},
    "range": function () {},
    "filter": function () {},
    "count": function () {},
    "every": function () {}
  },
  "timeYears": function () {},
  "utcMillisecond": {
    "floor": function () {},
    "ceil": function () {},
    "round": function () {},
    "offset": function () {},
    "range": function () {},
    "filter": function () {},
    "count": function () {},
    "every": function () {}
  },
  "utcMilliseconds": function () {},
  "utcSecond": {
    "floor": function () {},
    "ceil": function () {},
    "round": function () {},
    "offset": function () {},
    "range": function () {},
    "filter": function () {},
    "count": function () {},
    "every": function () {}
  },
  "utcSeconds": function () {},
  "utcMinute": {
    "floor": function () {},
    "ceil": function () {},
    "round": function () {},
    "offset": function () {},
    "range": function () {},
    "filter": function () {},
    "count": function () {},
    "every": function () {}
  },
  "utcMinutes": function () {},
  "utcHour": {
    "floor": function () {},
    "ceil": function () {},
    "round": function () {},
    "offset": function () {},
    "range": function () {},
    "filter": function () {},
    "count": function () {},
    "every": function () {}
  },
  "utcHours": function () {},
  "utcDay": {
    "floor": function () {},
    "ceil": function () {},
    "round": function () {},
    "offset": function () {},
    "range": function () {},
    "filter": function () {},
    "count": function () {},
    "every": function () {}
  },
  "utcDays": function () {},
  "utcWeek": {
    "floor": function () {},
    "ceil": function () {},
    "round": function () {},
    "offset": function () {},
    "range": function () {},
    "filter": function () {},
    "count": function () {},
    "every": function () {}
  },
  "utcWeeks": function () {},
  "utcSunday": {
    "floor": function () {},
    "ceil": function () {},
    "round": function () {},
    "offset": function () {},
    "range": function () {},
    "filter": function () {},
    "count": function () {},
    "every": function () {}
  },
  "utcSundays": function () {},
  "utcMonday": {
    "floor": function () {},
    "ceil": function () {},
    "round": function () {},
    "offset": function () {},
    "range": function () {},
    "filter": function () {},
    "count": function () {},
    "every": function () {}
  },
  "utcMondays": function () {},
  "utcTuesday": {
    "floor": function () {},
    "ceil": function () {},
    "round": function () {},
    "offset": function () {},
    "range": function () {},
    "filter": function () {},
    "count": function () {},
    "every": function () {}
  },
  "utcTuesdays": function () {},
  "utcWednesday": {
    "floor": function () {},
    "ceil": function () {},
    "round": function () {},
    "offset": function () {},
    "range": function () {},
    "filter": function () {},
    "count": function () {},
    "every": function () {}
  },
  "utcWednesdays": function () {},
  "utcThursday": {
    "floor": function () {},
    "ceil": function () {},
    "round": function () {},
    "offset": function () {},
    "range": function () {},
    "filter": function () {},
    "count": function () {},
    "every": function () {}
  },
  "utcThursdays": function () {},
  "utcFriday": {
    "floor": function () {},
    "ceil": function () {},
    "round": function () {},
    "offset": function () {},
    "range": function () {},
    "filter": function () {},
    "count": function () {},
    "every": function () {}
  },
  "utcFridays": function () {},
  "utcSaturday": {
    "floor": function () {},
    "ceil": function () {},
    "round": function () {},
    "offset": function () {},
    "range": function () {},
    "filter": function () {},
    "count": function () {},
    "every": function () {}
  },
  "utcSaturdays": function () {},
  "utcMonth": {
    "floor": function () {},
    "ceil": function () {},
    "round": function () {},
    "offset": function () {},
    "range": function () {},
    "filter": function () {},
    "count": function () {},
    "every": function () {}
  },
  "utcMonths": function () {},
  "utcYear": {
    "floor": function () {},
    "ceil": function () {},
    "round": function () {},
    "offset": function () {},
    "range": function () {},
    "filter": function () {},
    "count": function () {},
    "every": function () {}
  },
  "utcYears": function () {},
  "formatLocale": function () {},
  "formatDefaultLocale": function () {},
  "formatSpecifier": function () {},
  "precisionFixed": function () {},
  "precisionPrefix": function () {},
  "precisionRound": function () {},
  "isoFormat": function () {},
  "isoParse": function () {},
  "timeFormatLocale": function () {},
  "timeFormatDefaultLocale": function () {},
  "scaleBand": {
      "domain": function () {},
      "range": function () {},
      "rangeRound": function () {},
      "bandwidth": function () {},
      "step": function () {},
      "round": function () {},
      "padding": function () {},
      "paddingInner": function () {},
      "paddingOuter": function () {},
      "align": function () {},
      "copy": function () {}
  },
  "scalePoint": function () {},
  "scaleIdentity": {
      "invert": function () {},
      "domain": function () {},
      "copy": function () {},
      "ticks": function () {},
      "tickFormat": function () {},
      "nice": function () {}
  },
  "scaleLinear": {
      "ticks": function () {},
      "tickFormat": function () {},
      "nice": function () {}
  },
  "scaleLog": {
      "base": function () {},
      "domain": function () {},
      "ticks": function () {},
      "tickFormat": function () {},
      "nice": function () {},
      "copy": function () {}
  },
  "scaleOrdinal": {
      "domain": function () {},
      "range": function () {},
      "unknown": function () {},
      "copy": function () {},
  },
  "scaleImplicit": {
    "name": {}
  },
  "scalePow": function () {},
  "scaleSequential": {
      "domain": function () {},
      "clamp": function () {},
      "interpolator": function () {},
      "copy": function () {},
      "ticks": function () {},
      "tickFormat": function () {},
      "nice": function () {}
  },
  "scaleSqrt": function () {},
  "scaleQuantile": function () {},
  "scaleQuantize": function () {},
  "scaleThreshold": function () {},
  "scaleTime": function () {},
  "scaleUtc": function () {},
  "schemeCategory10": {},
  "schemeCategory20b": {},
  "schemeCategory20c": {},
  "schemeCategory20": {},
  "interpolateCubehelixDefault": function () {},
  "interpolateRainbow": function () {},
  "interpolateWarm": function () {},
  "interpolateCool": function () {},
  "interpolateViridis": function () {},
  "interpolateMagma": function () {},
  "interpolateInferno": function () {},
  "interpolatePlasma": function () {},
  "creator": function () {},
  "customEvent": function () {},
  "local": function () {},
  "matcher": function () {},
  "mouse": function () {},
  "namespace": function () {},
  "namespaces": {
    "svg": {},
    "xhtml": {},
    "xlink": {},
    "xml": {},
    "xmlns": {}
  },
  "select": function () {},
  "selectAll": function () {},
  "selection": function () {},
  "selector": function () {},
  "selectorAll": function () {},
  "touch": function () {},
  "touches": function () {},
  "window": function () {},
  "active": function () {},
  "interrupt": function () {},
  "transition": function () {},
  "axisTop": {
    "scale": function () {},
    "ticks": function () {},
    "tickArguments": function () {},
    "tickValues": function () {},
    "tickFormat": function () {},
    "tickSize": function () {},
    "tickSizeInner": function () {},
    "tickSizeOuter": function () {},
    "tickPadding": function () {}
  },
  "axisRight": {
    "scale": function () {},
    "ticks": function () {},
    "tickArguments": function () {},
    "tickValues": function () {},
    "tickFormat": function () {},
    "tickSize": function () {},
    "tickSizeInner": function () {},
    "tickSizeOuter": function () {},
    "tickPadding": function () {}
  },
  "axisBottom": {
    "scale": function () {},
    "ticks": function () {},
    "tickArguments": function () {},
    "tickValues": function () {},
    "tickFormat": function () {},
    "tickSize": function () {},
    "tickSizeInner": function () {},
    "tickSizeOuter": function () {},
    "tickPadding": function () {}
  },
  "axisLeft": {
    "scale": function () {},
    "ticks": function () {},
    "tickArguments": function () {},
    "tickValues": function () {},
    "tickFormat": function () {},
    "tickSize": function () {},
    "tickSizeInner": function () {},
    "tickSizeOuter": function () {},
    "tickPadding": function () {}
  },
  "cluster": function () {},
  "hierarchy": function () {},
  "pack": function () {},
  "packSiblings": function () {},
  "packEnclose": function () {},
  "partition": function () {},
  "stratify": function () {},
  "tree": function () {},
  "treemap": function () {},
  "treemapBinary": function () {},
  "treemapDice": function () {},
  "treemapSlice": function () {},
  "treemapSliceDice": function () {},
  "treemapSquarify": {
    "ratio": function () {}
  },
  "treemapResquarify": {
    "ratio": function () {}
  },
  "forceCenter": {
    "initialize": function () {},
    "x": function () {},
    "y": function () {}
  },
  "forceCollide": {
    "initialize": function () {},
    "radius": function () {},
    "strength": function () {},
    "iterations": function () {}
  },
  "forceLink": {
    "initialize": function () {},
    "links": function () {},
    "id": function () {},
    "distance": function () {},
    "strength": function () {},
    "iteractions": function () {}
  },
  "forceManyBody": {
    "initialize": function () {},
    "strength": function () {},
    "theta": function () {},
    "distanceMin": function () {},
    "distanceMax": function () {}
  },
  "ForceNode": {
    "index": {},
    "x": {},
    "y": {},
    "vx": {},
    "vy": {},
    "fx": {},
    "fy": {}
  },
  "forceSimulation": {
    "restart": function () {},
    "stop": function () {},
    "tick": function () {},
    "nodes": function () {},
    "alpha": function () {},
    "alphaMin": function () {},
    "alphaDecay": function () {},
    "alphaTarget": function () {},
    "velocityDecay": function () {},
    "velocityAlpha": function () {},
    "force": function () {},
    "find": function () {},
    "on": function () {}
  },
  "forceX": {
    "initialize": function () {},
    "strength": function () {},
    "x": function () {}
  },
  "forceY": {
    "initialize": function () {},
    "strength": function () {},
    "y": function () {}
  },
  "drag": function () {},
  "dragDisable": function () {},
  "dragEnable": function () {},
  "voronoi": function () {},
  "zoom": {
    "transform": function () {},
    "translateBy": function () {},
    "scaleBy": function () {},
    "scaleTo": function () {},
    "filter": function () {},
    "extent": function () {},
    "scaleExtent": function () {},
    "translateExtent": function () {},
    "duration": function () {},
    "on": function () {},
  },
  "zoomIdentity": {
    "k": {},
    "x": {},
    "y": {},
    "constructor": function () {},
    "scale": function () {},
    "translate": function () {},
    "apply": function () {},
    "applyX": function () {},
    "applyY": function () {},
    "invert": function () {},
    "invertX": function () {},
    "invertY": function () {},
    "rescaleX": function () {},
    "rescaleY": function () {},
    "toString": function () {}
  },
  "zoomTransform": function () {},
  "brush": function () {},
  "brushX": function () {},
  "brushY": function () {},
  "brushSelection": function () {},
  "chord": function () {},
  "ribbon": function () {},
  "geoAlbers": function () {},
  "geoAlbersUsa": function () {},
  "geoArea": function () {},
  "geoAzimuthalEqualArea": function () {},
  "geoAzimuthalEqualAreaRaw": {
    "invert": function () {}
  },
  "geoAzimuthalEquidistant": function () {},
  "geoAzimuthalEquidistantRaw": {
    "invert": function () {}
  },
  "geoBounds": function () {},
  "geoCentroid": function () {},
  "geoCircle": function () {},
  "geoClipExtent": function () {},
  "geoConicConformal": function () {},
  "geoConicConformalRaw": function () {},
  "geoConicEqualArea": function () {},
  "geoConicEqualAreaRaw": function () {},
  "geoConicEquidistant": function () {},
  "geoConicEquidistantRaw": function () {},
  "geoDistance": function () {},
  "geoEquirectangular": function () {},
  "geoEquirectangularRaw": {
    "invert": function () {}
  },
  "geoGnomonic": function () {},
  "geoGnomonicRaw": {
    "invert": function () {}
  },
  "geoGraticule": function () {},
  "geoInterpolate": function () {},
  "geoLength": function () {},
  "geoMercator": function () {},
  "geoMercatorRaw": {
    "invert": function () {}
  },
  "geoOrthographic": function () {},
  "geoOrthographicRaw": {
    "invert": function () {}
  },
  "geoPath": function () {},
  "geoProjection": function () {},
  "geoProjectionMutator": function () {},
  "geoRotation": function () {},
  "geoStereographic": function () {},
  "geoStereographicRaw": {
    "invert": function () {}
  },
  "geoStream": function () {},
  "geoTransform": function () {},
  "geoTransverseMercator": function () {},
  "geoTransverseMercatorRaw": {
    "invert": function () {}
  }
};
d3.map.prototype = {
  "constructor": function () {},
  "has": function () {},
  "get": function () {},
  "set": function () {},
  "remove": function () {},
  "clear": function () {},
  "keys": function () {},
  "values": function () {},
  "entries": function () {},
  "size": function () {},
  "empty": function () {},
  "each": function () {}
};
d3.set.prototype = {
  "constructor": function () {},
  "has": function () {},
  "add": function () {},
  "remove": function () {},
  "clear": function () {},
  "values": function () {},
  "size": function () {},
  "empty": function () {},
  "each": function () {}
};
d3.path.prototype = {
  "constructor": function () {},
  "moveTo": function () {},
  "closePath": function () {},
  "lineTo": function () {},
  "quadraticCurveTo": function () {},
  "bezierCurveTo": function () {},
  "arcTo": function () {},
  "arc": function () {},
  "rect": function () {},
  "toString": function () {}
};
d3.quadtree.prototype = {
  "copy": function () {},
  "add": function () {},
  "addAll": function () {},
  "cover": function () {},
  "data": function () {},
  "extent": function () {},
  "find": function () {},
  "remove": function () {},
  "removeAll": function () {},
  "root": function () {},
  "size": function () {},
  "visit": function () {},
  "visitAfter": function () {},
  "x": function () {},
  "y": function () {}
};
d3.queue.prototype = {
  "constructor": function () {},
  "defer": function () {},
  "abort": function () {},
  "await": function () {},
  "awaitAll": function () {}
};
d3.color.prototype = {
  "displayable": function () {},
  "toString": function () {},
  "constructor": function () {}
};
d3.rgb.prototype = {
  "brighter": function () {},
  "darker": function () {},
  "rgb": function () {},
  "displayable": function () {},
  "toString": function () {},
  "constructor": function () {}
};
d3.hsl.prototype = {
  "brighter": function () {},
  "darker": function () {},
  "rgb": function () {},
  "displayable": function () {},
  "constructor": function () {},
  "toString": function () {}
};
d3.lab.prototype = {
  "brighter": function () {},
  "darker": function () {},
  "rgb": function () {},
  "constructor": function () {},
  "displayable": function () {},
  "toString": function () {}
};
d3.hcl.prototype = {
  "brighter": function () {},
  "darker": function () {},
  "rgb": function () {},
  "constructor": function () {},
  "displayable": function () {},
  "toString": function () {}
};
d3.cubehelix.prototype = {
  "brighter": function () {},
  "darker": function () {},
  "rgb": function () {},
  "constructor": function () {},
  "displayable": function () {},
  "toString": function () {}
};
d3.dispatch.prototype = {
  "constructor": function () {},
  "on": function () {},
  "copy": function () {},
  "call": function () {},
  "apply": function () {}
};
d3.timer.prototype = {
  "constructor": function () {},
  "restart": function () {},
  "stop": function () {}
};
d3.local.prototype = {
  "constructor": function () {},
  "get": function () {},
  "set": function () {},
  "remove": function () {},
  "toString": function () {}
};
d3.selection.prototype = {
  "constructor": function () {},
  "select": function () {},
  "selectAll": function () {},
  "filter": function () {},
  "data": function () {},
  "enter": function () {},
  "exit": function () {},
  "merge": function () {},
  "order": function () {},
  "sort": function () {},
  "call": function () {},
  "nodes": function () {},
  "node": {
    "getComputedTextLength": function () {}
  },
  "size": function () {},
  "empty": function () {},
  "each": function () {},
  "attr": function () {},
  "style": function () {},
  "property": function () {},
  "classed": function () {},
  "text": function () {},
  "html": function () {},
  "raise": function () {},
  "lower": function () {},
  "append": function () {},
  "insert": function () {},
  "remove": function () {},
  "datum": function () {},
  "on": function () {},
  "dispatch": function () {},
  "interrupt": function () {},
  "transition": function () {}
};
d3.transition.prototype = {
  "constructor": function () {},
  "select": function () {},
  "selectAll": function () {},
  "filter": function () {},
  "merge": function () {},
  "selection": function () {},
  "transition": function () {},
  "call": function () {},
  "nodes": function () {},
  "node": function () {},
  "size": function () {},
  "empty": function () {},
  "each": function () {},
  "on": function () {},
  "attr": function () {},
  "attrTween": function () {},
  "style": function () {},
  "styleTween": function () {},
  "text": function () {},
  "remove": function () {},
  "tween": function () {},
  "delay": function () {},
  "duration": function () {},
  "ease": function () {}
};
d3.hierarchy.prototype = {
  "constructor": function () {},
  "each": function () {},
  "eachAfter": function () {},
  "eachBefore": function () {},
  "sum": function () {},
  "sort": function () {},
  "path": function () {},
  "ancestors": function () {},
  "descendants": function () {},
  "leaves": function () {},
  "links": function () {},
  "copy": function () {}
};
d3.zoomIdentity.constructor.prototype = {
  "constructor": function () {},
  "scale": function () {},
  "translate": function () {},
  "apply": function () {},
  "applyX": function () {},
  "applyY": function () {},
  "invert": function () {},
  "invertX": function () {},
  "invertY": function () {},
  "rescaleX": function () {},
  "rescaleY": function () {},
  "toString": function () {}
};
d3.zoomTransform.prototype = {
  "constructor": function () {},
  "scale": function () {},
  "translate": function () {},
  "apply": function () {},
  "applyX": function () {},
  "applyY": function () {},
  "invert": function () {},
  "invertX": function () {},
  "invertY": function () {},
  "rescaleX": function () {},
  "rescaleY": function () {},
  "toString": function () {}
};
