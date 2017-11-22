// D3 Extern generated using: https://github.com/jmmk/javascript-externs-generator
// With some externs added by hand: Every d3-force objects, d3.zoom and d3.line

var d3 = {
  "ForceNode": {
    "fx": {},
    "fy": {},
    "index": {},
    "vx": {},
    "vy": {},
    "x": {},
    "y": {}
  },
  "active": function () {},
  "arc": {
    "context": function () {},
    "cornerRadius": function () {},
    "centroid": function () {},
    "endAngle": function () {},
    "innerRadius": function () {},
    "outerRadius": function () {},
    "padAngle": function () {},
    "padRadius": function () {},
    "startAngle": function () {}
  },
  "area": {
    "context": function () {},
    "curve": function () {},
    "defined": function () {},
    "lineX0": function () {},
    "lineX1": function () {},
    "lineY0": function () {},
    "lineY1": function () {},
    "x": function () {},
    "y": function () {},
    "x0": function () {},
    "x1": function () {},
    "y0": function () {},
    "y1": function () {}
  },
  "areaRadial": function () {},
  "ascending": function () {},
  "axisBottom": {
    "scale": function () {},
    "tickArguments": function () {},
    "tickFormat": function () {},
    "tickPadding": function () {},
    "ticks": function () {},
    "tickSize": function () {},
    "tickSizeInner": function () {},
    "tickSizeOuter": function () {},
    "tickValues": function () {}
  },
  "axisLeft": {
    "scale": function () {},
    "tickArguments": function () {},
    "tickFormat": function () {},
    "tickPadding": function () {},
    "ticks": function () {},
    "tickSize": function () {},
    "tickSizeInner": function () {},
    "tickSizeOuter": function () {},
    "tickValues": function () {}
  },
  "axisRight": {
    "scale": function () {},
    "tickArguments": function () {},
    "tickFormat": function () {},
    "tickPadding": function () {},
    "ticks": function () {},
    "tickSize": function () {},
    "tickSizeInner": function () {},
    "tickSizeOuter": function () {},
    "tickValues": function () {}
  },
  "axisTop": {
    "scale": function () {},
    "tickArguments": function () {},
    "tickFormat": function () {},
    "tickPadding": function () {},
    "ticks": function () {},
    "tickSize": function () {},
    "tickSizeInner": function () {},
    "tickSizeOuter": function () {},
    "tickValues": function () {}
  },
  "bisect": function () {},
  "bisectLeft": function () {},
  "bisectRight": function () {},
  "bisector": function () {},
  "brush": function () {},
  "brushSelection": function () {},
  "brushX": function () {},
  "brushY": function () {},
  "chord": function () {},
  "clientPoint": function () {},
  "cluster": function () {},
  "color": function () {},
  "creator": function () {},
  "cross": function () {},
  "csv": function () {},
  "csvFormat": function () {},
  "csvFormatRows": function () {},
  "csvParse": function () {},
  "csvParseRows": function () {},
  "cubehelix": function () {},
  "curveBasis": function () {},
  "curveBasisClosed": function () {},
  "curveBasisOpen": function () {},
  "curveBundle": {
    "beta": function () {}
  },
  "curveCardinal": {
    "tension": function () {}
  },
  "curveCardinalClosed": {
    "tension": function () {}
  },
  "curveCardinalOpen": {
    "tension": function () {}
  },
  "curveCatmullRom": {
    "alpha": function () {}
  },
  "curveCatmullRomClosed": {
    "alpha": function () {}
  },
  "curveCatmullRomOpen": {
    "alpha": function () {}
  },
  "curveLinear": function () {},
  "curveLinearClosed": function () {},
  "curveMonotoneX": function () {},
  "curveMonotoneY": function () {},
  "curveNatural": function () {},
  "curveStep": function () {},
  "curveStepAfter": function () {},
  "curveStepBefore": function () {},
  "customEvent": function () {},
  "descending": function () {},
  "deviation": function () {},
  "dispatch": function () {},
  "drag": function () {},
  "dragDisable": function () {},
  "dragEnable": function () {},
  "dsvFormat": function () {},
  "easeBack": {
    "overshoot": function () {}
  },
  "easeBackIn": {
    "overshoot": function () {}
  },
  "easeBackInOut": {
    "overshoot": function () {}
  },
  "easeBackOut": {
    "overshoot": function () {}
  },
  "easeBounce": function () {},
  "easeBounceIn": function () {},
  "easeBounceInOut": function () {},
  "easeBounceOut": function () {},
  "easeCircle": function () {},
  "easeCircleIn": function () {},
  "easeCircleInOut": function () {},
  "easeCircleOut": function () {},
  "easeCubic": function () {},
  "easeCubicIn": function () {},
  "easeCubicInOut": function () {},
  "easeCubicOut": function () {},
  "easeElastic": {
    "amplitude": function () {},
    "period": function () {}
  },
  "easeElasticIn": {
    "amplitude": function () {},
    "period": function () {}
  },
  "easeElasticInOut": {
    "amplitude": function () {},
    "period": function () {}
  },
  "easeElasticOut": {
    "amplitude": function () {},
    "period": function () {}
  },
  "easeExp": function () {},
  "easeExpIn": function () {},
  "easeExpInOut": function () {},
  "easeExpOut": function () {},
  "easeLinear": function () {},
  "easePoly": {
    "exponent": function () {}
  },
  "easePolyIn": {
    "exponent": function () {}
  },
  "easePolyInOut": {
    "exponent": function () {}
  },
  "easePolyOut": {
    "exponent": function () {}
  },
  "easeQuad": function () {},
  "easeQuadIn": function () {},
  "easeQuadInOut": function () {},
  "easeQuadOut": function () {},
  "easeSin": function () {},
  "easeSinIn": function () {},
  "easeSinInOut": function () {},
  "easeSinOut": function () {},
  "entries": function () {},
  "event": {},
  "extent": function () {},
  "forceCenter": {
    "initialize": function () {},
    "x": function () {},
    "y": function () {}
  },
  "forceCollide": {
    "initialize": function () {},
    "iterations": function () {},
    "radius": function () {},
    "strength": function () {}
  },
  "forceLink": {
    "distance": function () {},
    "id": function () {},
    "initialize": function () {},
    "iteractions": function () {},
    "links": function () {},
    "strength": function () {}
  },
  "forceManyBody": {
    "distanceMax": function () {},
    "distanceMin": function () {},
    "initialize": function () {},
    "strength": function () {},
    "theta": function () {}
  },
  "forceRadial": {
    "initialize": function () {},
    "radius": function () {},
    "strength": function () {},
    "x": function () {},
    "y": function () {}
  },
  "forceSimulation": {
    "alpha": function () {},
    "alphaDecay": function () {},
    "alphaMin": function () {},
    "alphaTarget": function () {},
    "find": function () {},
    "force": function () {},
    "nodes": function () {},
    "on": function () {},
    "restart": function () {},
    "stop": function () {},
    "tick": function () {},
    "velocityAlpha": function () {},
    "velocityDecay": function () {}
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
  "format": function () {},
  "formatDefaultLocale": function () {},
  "formatLocale": function () {},
  "formatPrefix": function () {},
  "formatSpecifier": function () {},
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
  "geoClipAntimeridian": function () {},
  "geoClipCircle": function () {},
  "geoClipExtent": function () {},
  "geoClipRectangle": function () {},
  "geoConicConformal": function () {},
  "geoConicConformalRaw": function () {},
  "geoConicEqualArea": function () {},
  "geoConicEqualAreaRaw": function () {},
  "geoConicEquidistant": function () {},
  "geoConicEquidistantRaw": function () {},
  "geoContains": function () {},
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
  "geoGraticule10": function () {},
  "geoIdentity": function () {},
  "geoInterpolate": function () {},
  "geoLength": function () {},
  "geoMercator": function () {},
  "geoMercatorRaw": {
    "invert": function () {}
  },
  "geoNaturalEarth1": function () {},
  "geoNaturalEarth1Raw": {
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
  },
  "hcl": function () {},
  "hierarchy": function () {},
  "histogram": function () {},
  "hsl": function () {},
  "html": function () {},
  "interpolate": function () {},
  "interpolateArray": function () {},
  "interpolateBasis": function () {},
  "interpolateBasisClosed": function () {},
  "interpolateCool": function () {},
  "interpolateCubehelix": {
    "gamma": function () {}
  },
  "interpolateCubehelixDefault": function () {},
  "interpolateCubehelixLong": {
    "gamma": function () {}
  },
  "interpolateDate": function () {},
  "interpolateHcl": function () {},
  "interpolateHclLong": function () {},
  "interpolateHsl": function () {},
  "interpolateHslLong": function () {},
  "interpolateInferno": function () {},
  "interpolateLab": function () {},
  "interpolateMagma": function () {},
  "interpolateNumber": function () {},
  "interpolateObject": function () {},
  "interpolatePlasma": function () {},
  "interpolateRainbow": function () {},
  "interpolateRgb": {
    "gamma": function () {}
  },
  "interpolateRgbBasis": function () {},
  "interpolateRgbBasisClosed": function () {},
  "interpolateRound": function () {},
  "interpolateString": function () {},
  "interpolateTransformCss": function () {},
  "interpolateTransformSvg": function () {},
  "interpolateViridis": function () {},
  "interpolateWarm": function () {},
  "interpolateZoom": function () {},
  "interrupt": function () {},
  "interval": function () {},
  "isoFormat": function () {},
  "isoParse": function () {},
  "json": function () {},
  "keys": function () {},
  "lab": function () {},
  "line": {
    "context": function () {},
    "curve": function () {},
    "defined": function () {},
    "x": function () {},
    "y": function () {}
  },
  "lineRadial": {
    "angle": function () {},
    "context": function () {},
    "curve": function () {},
    "defined": function () {},
    "radius": function () {}
  },
  "linkHorizontal": function () {},
  "linkRadial": function () {},
  "linkVertical": function () {},
  "local": function () {},
  "map": function () {},
  "matcher": function () {},
  "max": function () {},
  "mean": function () {},
  "median": function () {},
  "merge": function () {},
  "min": function () {},
  "mouse": function () {},
  "namespace": function () {},
  "namespaces": {
    "svg": {},
    "xhtml": {},
    "xlink": {},
    "xml": {},
    "xmlns": {}
  },
  "nest": function () {},
  "now": function () {},
  "pack": function () {},
  "packEnclose": function () {},
  "packSiblings": function () {},
  "pairs": function () {},
  "partition": function () {},
  "path": function () {},
  "permute": function () {},
  "pie": {
    "endAngle": function () {},
    "padAngle": function () {},
    "sort": function () {},
    "sortValues": function () {},
    "startAngle": function () {},
    "value": function () {}
  },
  "pointRadial": function () {},
  "polygonArea": function () {},
  "polygonCentroid": function () {},
  "polygonContains": function () {},
  "polygonHull": function () {},
  "polygonLength": function () {},
  "precisionFixed": function () {},
  "precisionPrefix": function () {},
  "precisionRound": function () {},
  "quadtree": function () {},
  "quantile": function () {},
  "quantize": function () {},
  "queue": function () {},
  "radialArea": function () {},
  "radialLine": {
    "angle": function () {},
    "curve": function () {},
    "radius": function () {}
  },
  "randomBates": {
    "source": function () {}
  },
  "randomExponential": {
    "source": function () {}
  },
  "randomIrwinHall": {
    "source": function () {}
  },
  "randomLogNormal": {
    "source": function () {}
  },
  "randomNormal": {
    "source": function () {}
  },
  "randomUniform": {
    "source": function () {}
  },
  "range": function () {},
  "request": function () {},
  "rgb": function () {},
  "ribbon": function () {},
  "scaleBand": {
    "align": function () {},
    "bandwidth": function () {},
    "copy": function () {},
    "domain": function () {},
    "padding": function () {},
    "paddingInner": function () {},
    "paddingOuter": function () {},
    "range": function () {},
    "rangeRound": function () {},
    "round": function () {},
    "step": function () {}
  },
  "scaleIdentity": {
    "copy": function () {},
    "domain": function () {},
    "invert": function () {},
    "nice": function () {},
    "tickFormat": function () {},
    "ticks": function () {}
  },
  "scaleImplicit": {
    "name": {}
  },
  "scaleLinear": {
    "nice": function () {},
    "tickFormat": function () {},
    "ticks": function () {}
  },
  "scaleLog": {
    "base": function () {},
    "clamp": function () {},
    "copy": function () {},
    "domain": function () {},
    "interpolate": function () {},
    "invert": function () {},
    "nice": function () {},
    "range": function () {},
    "rangeRound": function () {},
    "tickFormat": function () {},
    "ticks": function () {}
  },
  "scaleOrdinal": {
    "copy": function () {},
    "domain": function () {},
    "range": function () {},
    "unknown": function () {}
  },
  "scalePoint": function () {},
  "scalePow": function () {},
  "scaleQuantile": function () {},
  "scaleQuantize": function () {},
  "scaleSequential": {
    "clamp": function () {},
    "copy": function () {},
    "domain": function () {},
    "interpolator": function () {},
    "nice": function () {},
    "tickFormat": function () {},
    "ticks": function () {}
  },
  "scaleSqrt": function () {},
  "scaleThreshold": function () {},
  "scaleTime": function () {},
  "scaleUtc": function () {},
  "scan": function () {},
  "schemeCategory10": {},
  "schemeCategory20": {},
  "schemeCategory20b": {},
  "schemeCategory20c": {},
  "select": function () {},
  "selectAll": function () {},
  "selection": function () {},
  "selector": function () {},
  "selectorAll": function () {},
  "set": function () {},
  "shuffle": function () {},
  "stack": function () {},
  "stackOffsetDiverging": function () {},
  "stackOffsetExpand": function () {},
  "stackOffsetNone": function () {},
  "stackOffsetSilhouette": function () {},
  "stackOffsetWiggle": function () {},
  "stackOrderAscending": function () {},
  "stackOrderDescending": function () {},
  "stackOrderInsideOut": function () {},
  "stackOrderNone": function () {},
  "stackOrderReverse": function () {},
  "stratify": function () {},
  "style": function () {},
  "sum": function () {},
  "symbol": function () {},
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
  "symbols": {},
  "text": function () {},
  "thresholdFreedmanDiaconis": function () {},
  "thresholdScott": function () {},
  "thresholdSturges": function () {},
  "tickIncrement": function () {},
  "tickStep": function () {},
  "ticks": function () {},
  "timeDay": {
    "ceil": function () {},
    "count": function () {},
    "every": function () {},
    "filter": function () {},
    "floor": function () {},
    "offset": function () {},
    "range": function () {},
    "round": function () {}
  },
  "timeDays": function () {},
  "timeFormat": function () {},
  "timeFormatDefaultLocale": function () {},
  "timeFormatLocale": function () {},
  "timeFriday": {
    "ceil": function () {},
    "count": function () {},
    "every": function () {},
    "filter": function () {},
    "floor": function () {},
    "offset": function () {},
    "range": function () {},
    "round": function () {}
  },
  "timeFridays": function () {},
  "timeHour": {
    "ceil": function () {},
    "count": function () {},
    "every": function () {},
    "filter": function () {},
    "floor": function () {},
    "offset": function () {},
    "range": function () {},
    "round": function () {}
  },
  "timeHours": function () {},
  "timeInterval": function () {},
  "timeMillisecond": {
    "ceil": function () {},
    "count": function () {},
    "every": function () {},
    "filter": function () {},
    "floor": function () {},
    "offset": function () {},
    "range": function () {},
    "round": function () {}
  },
  "timeMilliseconds": function () {},
  "timeMinute": {
    "ceil": function () {},
    "count": function () {},
    "every": function () {},
    "filter": function () {},
    "floor": function () {},
    "offset": function () {},
    "range": function () {},
    "round": function () {}
  },
  "timeMinutes": function () {},
  "timeMonday": {
    "ceil": function () {},
    "count": function () {},
    "every": function () {},
    "filter": function () {},
    "floor": function () {},
    "offset": function () {},
    "range": function () {},
    "round": function () {}
  },
  "timeMondays": function () {},
  "timeMonth": {
    "ceil": function () {},
    "count": function () {},
    "every": function () {},
    "filter": function () {},
    "floor": function () {},
    "offset": function () {},
    "range": function () {},
    "round": function () {}
  },
  "timeMonths": function () {},
  "timeParse": function () {},
  "timeSaturday": {
    "ceil": function () {},
    "count": function () {},
    "every": function () {},
    "filter": function () {},
    "floor": function () {},
    "offset": function () {},
    "range": function () {},
    "round": function () {}
  },
  "timeSaturdays": function () {},
  "timeSecond": {
    "ceil": function () {},
    "count": function () {},
    "every": function () {},
    "filter": function () {},
    "floor": function () {},
    "offset": function () {},
    "range": function () {},
    "round": function () {}
  },
  "timeSeconds": function () {},
  "timeSunday": {
    "ceil": function () {},
    "count": function () {},
    "every": function () {},
    "filter": function () {},
    "floor": function () {},
    "offset": function () {},
    "range": function () {},
    "round": function () {}
  },
  "timeSundays": function () {},
  "timeThursday": {
    "ceil": function () {},
    "count": function () {},
    "every": function () {},
    "filter": function () {},
    "floor": function () {},
    "offset": function () {},
    "range": function () {},
    "round": function () {}
  },
  "timeThursdays": function () {},
  "timeTuesday": {
    "ceil": function () {},
    "count": function () {},
    "every": function () {},
    "filter": function () {},
    "floor": function () {},
    "offset": function () {},
    "range": function () {},
    "round": function () {}
  },
  "timeTuesdays": function () {},
  "timeWednesday": {
    "ceil": function () {},
    "count": function () {},
    "every": function () {},
    "filter": function () {},
    "floor": function () {},
    "offset": function () {},
    "range": function () {},
    "round": function () {}
  },
  "timeWednesdays": function () {},
  "timeWeek": {
    "ceil": function () {},
    "count": function () {},
    "every": function () {},
    "filter": function () {},
    "floor": function () {},
    "offset": function () {},
    "range": function () {},
    "round": function () {}
  },
  "timeWeeks": function () {},
  "timeYear": {
    "ceil": function () {},
    "count": function () {},
    "every": function () {},
    "filter": function () {},
    "floor": function () {},
    "offset": function () {},
    "range": function () {},
    "round": function () {}
  },
  "timeYears": function () {},
  "timeout": function () {},
  "timer": function () {},
  "timerFlush": function () {},
  "touch": function () {},
  "touches": function () {},
  "transition": function () {},
  "transpose": function () {},
  "tree": function () {},
  "treemap": function () {},
  "treemapBinary": function () {},
  "treemapDice": function () {},
  "treemapResquarify": {
    "ratio": function () {}
  },
  "treemapSlice": function () {},
  "treemapSliceDice": function () {},
  "treemapSquarify": {
    "ratio": function () {}
  },
  "tsv": function () {},
  "tsvFormat": function () {},
  "tsvFormatRows": function () {},
  "tsvParse": function () {},
  "tsvParseRows": function () {},
  "utcDay": {
    "ceil": function () {},
    "count": function () {},
    "every": function () {},
    "filter": function () {},
    "floor": function () {},
    "offset": function () {},
    "range": function () {},
    "round": function () {}
  },
  "utcDays": function () {},
  "utcFormat": function () {},
  "utcFriday": {
    "ceil": function () {},
    "count": function () {},
    "every": function () {},
    "filter": function () {},
    "floor": function () {},
    "offset": function () {},
    "range": function () {},
    "round": function () {}
  },
  "utcFridays": function () {},
  "utcHour": {
    "ceil": function () {},
    "count": function () {},
    "every": function () {},
    "filter": function () {},
    "floor": function () {},
    "offset": function () {},
    "range": function () {},
    "round": function () {}
  },
  "utcHours": function () {},
  "utcMillisecond": {
    "ceil": function () {},
    "count": function () {},
    "every": function () {},
    "filter": function () {},
    "floor": function () {},
    "offset": function () {},
    "range": function () {},
    "round": function () {}
  },
  "utcMilliseconds": function () {},
  "utcMinute": {
    "ceil": function () {},
    "count": function () {},
    "every": function () {},
    "filter": function () {},
    "floor": function () {},
    "offset": function () {},
    "range": function () {},
    "round": function () {}
  },
  "utcMinutes": function () {},
  "utcMonday": {
    "ceil": function () {},
    "count": function () {},
    "every": function () {},
    "filter": function () {},
    "floor": function () {},
    "offset": function () {},
    "range": function () {},
    "round": function () {}
  },
  "utcMondays": function () {},
  "utcMonth": {
    "ceil": function () {},
    "count": function () {},
    "every": function () {},
    "filter": function () {},
    "floor": function () {},
    "offset": function () {},
    "range": function () {},
    "round": function () {}
  },
  "utcMonths": function () {},
  "utcParse": function () {},
  "utcSaturday": {
    "ceil": function () {},
    "count": function () {},
    "every": function () {},
    "filter": function () {},
    "floor": function () {},
    "offset": function () {},
    "range": function () {},
    "round": function () {}
  },
  "utcSaturdays": function () {},
  "utcSecond": {
    "ceil": function () {},
    "count": function () {},
    "every": function () {},
    "filter": function () {},
    "floor": function () {},
    "offset": function () {},
    "range": function () {},
    "round": function () {}
  },
  "utcSeconds": function () {},
  "utcSunday": {
    "ceil": function () {},
    "count": function () {},
    "every": function () {},
    "filter": function () {},
    "floor": function () {},
    "offset": function () {},
    "range": function () {},
    "round": function () {}
  },
  "utcSundays": function () {},
  "utcThursday": {
    "ceil": function () {},
    "count": function () {},
    "every": function () {},
    "filter": function () {},
    "floor": function () {},
    "offset": function () {},
    "range": function () {},
    "round": function () {}
  },
  "utcThursdays": function () {},
  "utcTuesday": {
    "ceil": function () {},
    "count": function () {},
    "every": function () {},
    "filter": function () {},
    "floor": function () {},
    "offset": function () {},
    "range": function () {},
    "round": function () {}
  },
  "utcTuesdays": function () {},
  "utcWednesday": {
    "ceil": function () {},
    "count": function () {},
    "every": function () {},
    "filter": function () {},
    "floor": function () {},
    "offset": function () {},
    "range": function () {},
    "round": function () {}
  },
  "utcWednesdays": function () {},
  "utcWeek": {
    "ceil": function () {},
    "count": function () {},
    "every": function () {},
    "filter": function () {},
    "floor": function () {},
    "offset": function () {},
    "range": function () {},
    "round": function () {}
  },
  "utcWeeks": function () {},
  "utcYear": {
    "ceil": function () {},
    "count": function () {},
    "every": function () {},
    "filter": function () {},
    "floor": function () {},
    "offset": function () {},
    "range": function () {},
    "round": function () {}
  },
  "utcYears": function () {},
  "values": function () {},
  "variance": function () {},
  "version": {},
  "voronoi": function () {},
  "window": function () {},
  "xml": function () {},
  "zip": function () {},
  "zoom": {
    "clickDistance": function () {},
    "constrain": function () {},
    "duration": function () {},
    "extent": function () {},
    "filter": function () {},
    "interpolate": function () {},
    "on": function () {},
    "scaleBy": function () {},
    "scaleExtent": function () {},
    "scaleTo": function () {},
    "touchable": function () {},
    "transform": function () {},
    "translateBy": function () {},
    "translateExtent": function () {},
    "translateTo": function () {},
    "wheelDelta": function () {}
  },
  "zoomIdentity": {
    "apply": function () {},
    "applyX": function () {},
    "applyY": function () {},
    "constructor": function () {},
    "invert": function () {},
    "invertX": function () {},
    "invertY": function () {},
    "k": {},
    "rescaleX": function () {},
    "rescaleY": function () {},
    "scale": function () {},
    "toString": function () {},
    "translate": function () {},
    "x": {},
    "y": {}
  },
  "zoomTransform": function () {}
};
d3.color.prototype = {
  "constructor": function () {},
  "displayable": function () {},
  "toString": function () {}
};
d3.cubehelix.prototype = {
  "brighter": function () {},
  "constructor": function () {},
  "darker": function () {},
  "displayable": function () {},
  "rgb": function () {},
  "toString": function () {}
};
d3.dispatch.prototype = {
  "apply": function () {},
  "call": function () {},
  "constructor": function () {},
  "copy": function () {},
  "on": function () {}
};
d3.formatSpecifier.prototype = {
  "toString": function () {}
};
d3.hcl.prototype = {
  "brighter": function () {},
  "constructor": function () {},
  "darker": function () {},
  "displayable": function () {},
  "rgb": function () {},
  "toString": function () {}
};
d3.hierarchy.prototype = {
  "ancestors": function () {},
  "constructor": function () {},
  "copy": function () {},
  "count": function () {},
  "descendants": function () {},
  "each": function () {},
  "eachAfter": function () {},
  "eachBefore": function () {},
  "leaves": function () {},
  "links": function () {},
  "path": function () {},
  "sort": function () {},
  "sum": function () {}
};
d3.histogram.prototype = {
  "thresholds": function () {}
};
d3.hsl.prototype = {
  "brighter": function () {},
  "constructor": function () {},
  "darker": function () {},
  "displayable": function () {},
  "rgb": function () {},
  "toString": function () {}
};
d3.lab.prototype = {
  "brighter": function () {},
  "constructor": function () {},
  "darker": function () {},
  "displayable": function () {},
  "rgb": function () {},
  "toString": function () {}
};
d3.local.prototype = {
  "constructor": function () {},
  "get": function () {},
  "remove": function () {},
  "set": function () {},
  "toString": function () {}
};
d3.map.prototype = {
  "clear": function () {},
  "constructor": function () {},
  "each": function () {},
  "empty": function () {},
  "entries": function () {},
  "get": function () {},
  "has": function () {},
  "keys": function () {},
  "remove": function () {},
  "set": function () {},
  "size": function () {},
  "values": function () {}
};
d3.path.prototype = {
  "arc": function () {},
  "arcTo": function () {},
  "bezierCurveTo": function () {},
  "closePath": function () {},
  "constructor": function () {},
  "lineTo": function () {},
  "moveTo": function () {},
  "quadraticCurveTo": function () {},
  "rect": function () {},
  "toString": function () {}
};
d3.quadtree.prototype = {
  "add": function () {},
  "addAll": function () {},
  "copy": function () {},
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
  "abort": function () {},
  "await": function () {},
  "awaitAll": function () {},
  "constructor": function () {},
  "defer": function () {}
};
d3.rgb.prototype = {
  "brighter": function () {},
  "constructor": function () {},
  "darker": function () {},
  "displayable": function () {},
  "rgb": function () {},
  "toString": function () {}
};
d3.selection.prototype = {
  "append": function () {},
  "attr": function () {},
  "call": function () {},
  "classed": function () {},
  "constructor": function () {},
  "data": function () {},
  "datum": function () {},
  "dispatch": function () {},
  "each": function () {},
  "empty": function () {},
  "enter": function () {},
  "exit": function () {},
  "filter": function () {},
  "html": function () {},
  "insert": function () {},
  "interrupt": function () {},
  "lower": function () {},
  "merge": function () {},
  "node": function () {},
  "nodes": function () {},
  "on": function () {},
  "order": function () {},
  "property": function () {},
  "raise": function () {},
  "remove": function () {},
  "select": function () {},
  "selectAll": function () {},
  "size": function () {},
  "sort": function () {},
  "style": function () {},
  "text": function () {},
  "transition": function () {}
};
d3.set.prototype = {
  "add": function () {},
  "clear": function () {},
  "constructor": function () {},
  "each": function () {},
  "empty": function () {},
  "has": function () {},
  "remove": function () {},
  "size": function () {},
  "values": function () {}
};
d3.timer.prototype = {
  "constructor": function () {},
  "restart": function () {},
  "stop": function () {}
};
d3.transition.prototype = {
  "attr": function () {},
  "attrTween": function () {},
  "call": function () {},
  "constructor": function () {},
  "delay": function () {},
  "duration": function () {},
  "each": function () {},
  "ease": function () {},
  "empty": function () {},
  "filter": function () {},
  "merge": function () {},
  "node": function () {},
  "nodes": function () {},
  "on": function () {},
  "remove": function () {},
  "select": function () {},
  "selectAll": function () {},
  "selection": function () {},
  "size": function () {},
  "style": function () {},
  "styleTween": function () {},
  "text": function () {},
  "transition": function () {},
  "tween": function () {}
};
d3.zoomIdentity.constructor.prototype = {
  "apply": function () {},
  "applyX": function () {},
  "applyY": function () {},
  "constructor": function () {},
  "invert": function () {},
  "invertX": function () {},
  "invertY": function () {},
  "rescaleX": function () {},
  "rescaleY": function () {},
  "scale": function () {},
  "toString": function () {},
  "translate": function () {}
};
d3.zoomTransform.prototype = {
  "apply": function () {},
  "applyX": function () {},
  "applyY": function () {},
  "constructor": function () {},
  "invert": function () {},
  "invertX": function () {},
  "invertY": function () {},
  "rescaleX": function () {},
  "rescaleY": function () {},
  "scale": function () {},
  "toString": function () {},
  "translate": function () {}
};
