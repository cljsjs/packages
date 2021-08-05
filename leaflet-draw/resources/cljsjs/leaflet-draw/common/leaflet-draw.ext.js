L.drawVersion;
L.Draw.Feature = {
    "initialize": function () {},
    "enable": function () {},
    "disable": function () {},
    "addHooks": function () {},
    "removeHooks": function () {},
    "setOptions": function () {}
};
L.Draw.SimpleShape = {
    "initialize": function () {},
    "addHooks": function () {},
    "removeHooks": function () {},
    // Inherited from L.Draw.Feature
    "enable": function () {},
    "disable": function () {},
    "setOptions": function () {},
};
L.Draw.Marker = {
    "initialize": function () {},
    "addHooks": function () {},
    "removeHooks": function () {},
    // Inherited from L.Draw.Feature
    "enable": function () {},
    "disable": function () {},
    "setOptions": function () {}
};
L.Draw.CircleMarker = {
    "initialize": function () {},
    // Inherited from L.Draw.Marker
    "addHooks": function () {},
    "removeHooks": function () {},
    // Inherited from L.Draw.Feature
    "enable": function () {},
    "disable": function () {},
    "setOptions": function () {}
};
L.Draw.Circle = {
    "initialize": function () {},
    // Inherited from L.Draw.Marker
    "addHooks": function () {},
    "removeHooks": function () {},
    // Inherited from L.Draw.Feature
    "enable": function () {},
    "disable": function () {},
    "setOptions": function () {},
};
L.Draw.Polyline = {
    "initialize": function () {},
    "addHooks": function () {},
    "removeHooks": function () {},
    "deleteLastVertex": function () {},
    "addVertex": function() {},
    "completeShape": function () {},
    // Inherited from L.Draw.Feature
    "enable": function () {},
    "disable": function () {},
    "setOptions": function () {}
};
L.Draw.Rectangle = {
    "initialize": function () {},
    "disable": function () {},
    // Inherited from L.Draw.SimpleShape
    "addHooks": function () {},
    "removeHooks": function () {},
    // Inherited from L.Draw.Feature
    "enable": function () {},
    "setOptions": function () {}
};
L.Draw.Polygon = {
    "initialize": function () {},
    // Inherited from L.Draw.Polyline
    "addHooks": function () {},
    "removeHooks": function () {},
    "deleteLastVertex": function () {},
    "addVertex": function () {},
    "completeShape": function () {},
    // Inherited from L.Draw.Feature
    "enable": function () {},
    "disable": function () {},
    "setOptions": function () {}
};
L.Edit.SimpleShape = {
    "initialize": function () {},
    "addHooks": function () {},
    "removeHooks": function () {},
    "updateMarkers": function () {}
};
L.Edit.Marker = {
    "initialize": function () {},
    "addHooks": function () {},
    "removeHooks": function () {},
};
L.Edit.CircleMarker = {
    // Inherited from L.Edit.SimpleShape
    "initialize": function () {},
    "addHooks": function () {},
    "removeHooks": function () {},
    "updateMarkers": function () {}
};
L.Edit.Circle = {
    // Inherited from L.Edit.SimpleShape
    "initialize": function () {},
    "addHooks": function () {},
    "removeHooks": function () {},
    "updateMarkers": function () {}
};
L.Edit.Polyline = {
    "initialize": function () {},
    "addHooks": function () {},
    "removeHooks": function () {},
    "updateMarkers": function () {}
};
L.Edit.Rectangle = {
    // Inherited from L.Edit.SimpleShape
    "initialize": function () {},
    "addHooks": function () {},
    "removeHooks": function () {},
    "updateMarkers": function () {}
};
L.EditToolbar.Edit = {
    "initialize": function () {},
    "enable": function () {},
    "disable": function () {},
    "addHooks": function () {},
    "removeHooks": function () {},
    "revertLayers": function () {},
    "save": function () {}
};
L.EditToolbar.Delete = {
    "initialize": function () {},
    "enable": function () {},
    "disable": function () {},
    "addHooks": function () {},
    "removeHooks": function () {},
    "revertLayers": function () {},
    "save": function () {},
    "removeAllLayers": function () {},
};
L.GeometryUtil = {
    "geodesicArea": function () {},
    "formattedNumber": function () {},
    "readableArea": function () {},
    "readableDistance": function () {},
    "isVersion07x": function () {}
};
L.LatLngUtil = {
    "cloneLatLngs": function () {},
    "cloneLatLng": function () {}
};
L.LineUtil = {
    "segmentsIntersect": function () {},
};
L.Polygon = {
    "intersects": function () {}
};
L.Polyline = {
    "intersects": function () {},
    "newLatLngIntersects": function () {},
    "newPointInteresects": function () {}
};
L.Map.TouchExtend = {
    "initialize": function () {},
    "addHooks": function () {},
    "removeHooks": function () {},
};
L.Control.Draw = {
    "initialize": function () {},
    "onAdd": function () {},
    "onRemove": function () {},
    "setDrawingOptions": function () {}
};
L.Draw.Tooltip = {
    "initialize": function () {},
    "dispose": function () {},
    "updateContent": function () {},
    "updatePosition": function () {},
    "showAsError": function () {},
    "removeError": function () {}
};
L.DrawToolbar = {
    "initialize": function () {},
    "getModeHandlers": function () {},
    "getActions": function () {},
    "setOptions": function () {}
};
L.EditToolbar = {
    "initialize": function () {},
    "getModeHandlers": function () {},
    "getActions": function () {},
    "addToolbar": function () {},
    "removeToolbar": function () {},
    "disable": function () {}
};
L.Edit.PolyVerticesEdit = {
    "initialize": function () {},
    "addHooks": function () {},
    "removeHooks": function () {},
    "updateMarkers": function () {}
};
