var AutoLayout;

AutoLayout.View = {
    "width": {},
    "height": {},
    "fittingWidth": {},
    "fittingHeight": {},
    "subViews": {}
};
AutoLayout.View.prototype = {
    "setSize": function(){},
    "setSpacing": function(){},
    "addConstraint": function(){},
    "addConstraints": function(){}
};

AutoLayout.Attribute = {
    "CONST": {},
    "NOTANATTRIBUTE": {},
    "VARIABLE": {},
    "LEFT": {},
    "RIGHT": {},
    "TOP": {},
    "BOTTOM": {},
    "WIDTH": {},
    "HEIGHT": {},
    "CENTERX": {},
    "CENTERY": {},
    "ZINDEX": {}
};

AutoLayout.Relation = {
    "LEQ": {},
    "EQU": {},
    "GEQ": {}
};

AutoLayout.Priority = {
    "REQUIRED": {},
    "DEFAULTHIGH": {},
    "DEFAULTLOW": {}
};

AutoLayout.SubView = {
    "name": {},
    "left": {},
    "right": {},
    "width": {},
    "height": {},
    "intrinsicWidth": {},
    "intrinsicHeight": {},
    "top": {},
    "bottom": {},
    "centerX": {},
    "centerY": {},
    "zIndex": {},
    "type": {}
};

AutoLayout.SubView.prototype = {
    "getValue": function(){}
};

AutoLayout.VisualFormat = {
    "parseLine": function(){},
    "parse": function(){},
    "parseMetaInfo": function(){}
};