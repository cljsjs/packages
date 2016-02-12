// d3geo_externs.js --- 
// 
// Filename: d3geo_externs.js
// Description: Using D3geo  in ClojureScript under Google Closure's advanced optimization
// Author: Zach Charlop-Powers
// Maintainer: Zach Charlop-Powers
// Created: Mon Dec 28 15:28:15 2013 (+0100)
// 
//
// The MIT License (MIT)
//
// Copyright (c) 2015 Zachary Charlop-Powers
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in all
// copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
// SOFTWARE.
//
// 
// Code:

var projection = {};
var projectionMutator = {};
var d3_geo_projectLine = {};
var d3_geo_projectLines = {};
var d3_geo_projectFeature = {};
var d3_geo_projectGeometry = {};
var d3_geo_projectGeometryType = {};
var d3_geo_projectObjectType = {};
var d3_geo_projectPoint = {};
var d3_geo_projectPoints = {};
var d3_geo_projectPolygon = {};
var d3_geo_projectNoop = {};
var d3_geo_projectClockwise = {};
var sphere = {};
var resample = {};
var pointEqual = {};


projection.prototype = function () {};
projectionMutator.prototype = function () {};

d3_geo_projectFeature = function () {};
d3_geo_projectGeometry = function () {};
d3_geo_projectObjectType.prototype = function () {};
d3_geo_projectObjectType.prototype = {
  "Feature":  function () {},
  "FeatureCollection":  function () {}
};


d3_geo_projectPoint.prototype = function () {};
d3_geo_projectPoint.prototype = {
  "point": function() {},
  "result": function() {}
};

d3_geo_projectLine.prototype = function () {};
d3_geo_projectLine.prototype = {
  "lineStart" :  function () {},
  "point" : function () {},
  "lineEnd": function () {},
  "result":  function () {}
};

d3_geo_projectPolygon.prototype = function() {};
d3_geo_projectPolygon.prototype = {
  "polygonStart": function () {},
  "lineStart": function () {},
  "point": function () {},
  "lineEnd": function () {},
  "polygonEnd": function () {},
  "result": function() {}
};

d3_geo_projectGeometryType.prototype = function () {};
d3_geo_projectGeometryType.prototype = {
  "Point": function () {},
  "MultiPoint": function () {},
  "LineString": function () {},
  "MultiLineString": function () {},
  "Polygon": function () {},
  "MultiPolygon": function () {},
  "Sphere": function () {}
};

d3_geo_projectNoop.prototype = function () {};
d3_geo_projectClockwise.prototype = function () {};

d3.geo.interrupt.prototype = function () {};
d3.geo.interrupt.prototype = {
  "forward": function () {},
  "reset": function () {}  
};

sphere.prototype = function () {};
resample.prototype = function () {};
pointEqual.protoype = function () {};

airy.prototype = function () {};
airy.prototype = {
  "forward": function () {},
  "forward.invert": function () {} 
};

airyProjection.prototype = function () {};
aitoff.prototype = function () {};
aitoff.invert.prototype = function () {};
armadillo.prototype = function () {};


d3.geo.airy.prototype = function () {};
d3.geo.airy.raw.prototype = function () {};
d3.geo.aitoff.prototype = function () {};
d3.geo.aitoff.raw.prototype = function () {};
d3.geo.armadillo.prototype = function () {};
d3.geo.armadillo.raw.prototype = function () {};
d3.geo.august.prototype = function () {};
d3.geo.august.raw.prototype = function () {};
d3.geo.baker.prototype = function () {};
d3.geo.baker.raw.prototype = function () {};
d3.geo.berghaus.prototype = function () {};
d3.geo.berghaus.raw.prototype = function () {};
d3.geo.mollweide.prototype = function () {};
d3.geo.mollweide.raw.prototype = function () {};
d3.geo.boggs.prototype = function () {};
d3.geo.boggs.raw.prototype = function () {};
d3.geo.sinusoidal.prototype = function () {};
d3.geo.sinusoidal.raw.prototype = function () {};
d3.geo.bonne.prototype = function () {};
d3.geo.bonne.raw.prototype = function () {};
d3.geo.bromley.prototype = function () {};
d3.geo.bromley.raw.prototype = function () {};
d3.geo.chamberlin.prototype = function () {};
d3.geo.chamberlin.raw.prototype = function () {};
d3.geo.collignon.prototype = function () {};
d3.geo.collignon.raw.prototype = function () {};
d3.geo.craig.prototype = function () {};
d3.geo.craig.raw.prototype = function () {};
d3.geo.craster.prototype = function () {};
d3.geo.craster.raw.prototype = function () {};
d3.geo.cylindricalEqualArea.prototype = function () {};
d3.geo.cylindricalEqualArea.raw.prototype = function () {};
d3.geo.chamberlin.prototype = function () {};
d3.geo.chamberlin.raw.prototype = function () {};
d3.geo.collignon.prototype = function () {};
d3.geo.collignon.raw.prototype = function () {};
d3.geo.craig.prototype = function () {};
d3.geo.craig.raw.prototype = function () {};
d3.geo.craster.prototype = function () {};
d3.geo.craster.raw.prototype = function () {};
d3.geo.cylindricalEqualArea.prototype = function () {};
d3.geo.cylindricalEqualArea.raw.prototype = function () {};
d3.geo.cylindricalStereographic.prototype = function () {};
d3.geo.cylindricalStereographic.raw.prototype = function () {};
d3.geo.eckert1.prototype = function () {};
d3.geo.eckert1.raw.prototype = function () {};
d3.geo.eckert2.prototype = function () {};
d3.geo.eckert2.raw.prototype = function () {};
d3.geo.eckert3.prototype = function () {};
d3.geo.eckert3.raw.prototype = function () {};
d3.geo.eckert4.prototype = function () {};
d3.geo.eckert4.raw.prototype = function () {};
d3.geo.eckert5.prototype = function () {};
d3.geo.eckert5.raw.prototype = function () {};
d3.geo.eckert6.prototype = function () {};
d3.geo.eckert6.raw.prototype = function () {};
d3.geo.eisenlohr.prototype = function () {};
d3.geo.eisenlohr.raw.prototype = function () {};
d3.geo.fahey.prototype = function () {};
d3.geo.fahey.raw.prototype = function () {};
d3.geo.foucaut.prototype = function () {};
d3.geo.foucaut.raw.prototype = function () {};
d3.geo.gilbert.prototype = function () {};
d3.geo.gilbert.raw.prototype = function () {};
d3.geo.gingery.prototype = function () {};
d3.geo.gingery.raw.prototype = function () {};
d3.geo.ginzburg4.prototype = function () {};
d3.geo.ginzburg4.raw.prototype = function () {};
d3.geo.ginzburg5.prototype = function () {};
d3.geo.ginzburg5.raw.prototype = function () {};
d3.geo.ginzburg6.prototype = function () {};
d3.geo.ginzburg6.raw.prototype = function () {};
d3.geo.ginzburg8.prototype = function () {};
d3.geo.ginzburg8.raw.prototype = function () {};
d3.geo.ginzburg9.prototype = function () {};
d3.geo.ginzburg9.raw.prototype = function () {};
d3.geo.gringorten.prototype = function () {};
d3.geo.gringorten.raw.prototype = function () {};
d3.geo.guyou.prototype = function () {};
d3.geo.guyou.raw.prototype = function () {};
d3.geo.hammerRetroazimuthal.prototype = function () {};
d3.geo.hammerRetroazimuthal.raw.prototype = function () {};
d3.geo.hammer.prototype = function () {};
d3.geo.hammer.raw.prototype = function () {};
d3.geo.hatano.prototype = function () {};
d3.geo.hatano.raw.prototype = function () {};
d3.geo.healpix.prototype = function () {};
d3.geo.healpix.raw.prototype = function () {};
d3.geo.hill.prototype = function () {};
d3.geo.hill.raw.prototype = function () {};
d3.geo.sinuMollweide.prototype = function () {};
d3.geo.sinuMollweide.raw.prototype = function () {};
d3.geo.homolosine.prototype = function () {};
d3.geo.homolosine.raw.prototype = function () {};
d3.geo.kavrayskiy7.prototype = function () {};
d3.geo.kavrayskiy7.raw.prototype = function () {};
d3.geo.lagrange.prototype = function () {};
d3.geo.lagrange.raw.prototype = function () {};
d3.geo.larrivee.prototype = function () {};
d3.geo.larrivee.raw.prototype = function () {};
d3.geo.laskowski.prototype = function () {};
d3.geo.laskowski.raw.prototype = function () {};
d3.geo.littrow.prototype = function () {};
d3.geo.littrow.raw.prototype = function () {};
d3.geo.loximuthal.prototype = function () {};
d3.geo.loximuthal.raw.prototype = function () {};
d3.geo.miller.prototype = function () {};
d3.geo.miller.raw.prototype = function () {};
d3.geo.modifiedStereographic.prototype = function () {};
d3.geo.modifiedStereographic.raw.prototype = function () {};
d3.geo.mtFlatPolarParabolic.prototype = function () {};
d3.geo.mtFlatPolarParabolic.raw.prototype = function () {};
d3.geo.mtFlatPolarQuartic.prototype = function () {};
d3.geo.mtFlatPolarQuartic.raw.prototype = function () {};
d3.geo.mtFlatPolarSinusoidal.prototype = function () {};
d3.geo.mtFlatPolarSinusoidal.raw.prototype = function () {};
d3.geo.naturalEarth.prototype = function () {};
d3.geo.naturalEarth.raw.prototype = function () {};
d3.geo.nellHammer.prototype = function () {};
d3.geo.nellHammer.raw.prototype = function () {};
d3.geo.patterson.prototype = function () {};
d3.geo.patterson.raw.prototype = function () {};
d3.geo.peirceQuincuncial.prototype = function () {};
d3.geo.peirceQuincuncial.raw.prototype = function () {};
d3.geo.polyconic.prototype = function () {};
d3.geo.polyconic.raw.prototype = function () {};
d3.geo.rectangularPolyconic.prototype = function () {};
d3.geo.rectangularPolyconic.raw.prototype = function () {};
d3.geo.robinson.prototype = function () {};
d3.geo.robinson.raw.prototype = function () {};
d3.geo.satellite.prototype = function () {};
d3.geo.satellite.raw.prototype = function () {};
d3.geo.times.prototype = function () {};
d3.geo.times.raw.prototype = function () {};
d3.geo.twoPointEquidistant.prototype = function () {};
d3.geo.twoPointEquidistant.raw.prototype = function () {};
d3.geo.twoPointAzimuthal.prototype = function () {};
d3.geo.twoPointAzimuthal.raw.prototype = function () {};
d3.geo.vanDerGrinten.prototype = function () {};
d3.geo.vanDerGrinten.raw.prototype = function () {};
d3.geo.vanDerGrinten2.prototype = function () {};
d3.geo.vanDerGrinten2.raw.prototype = function () {};
d3.geo.vanDerGrinten3.prototype = function () {};
d3.geo.vanDerGrinten3.raw.prototype = function () {};
d3.geo.vanDerGrinten4.prototype = function () {};
d3.geo.vanDerGrinten4.raw.prototype = function () {};
d3.geo.wagner4.prototype = function () {};
d3.geo.wagner4.raw.prototype = function () {};
d3.geo.wagner6.prototype = function () {};
d3.geo.wagner6.raw.prototype = function () {};
d3.geo.wagner7.prototype = function () {};
d3.geo.wagner7.raw.prototype = function () {};
d3.geo.wiechel.prototype = function () {};
d3.geo.wiechel.raw.prototype = function () {};
d3.geo.winkel3.prototype = function () {};
d3.geo.winkel3.raw.prototype = function () {};
