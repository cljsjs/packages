var libtess = {};

/** @constructor */
libtess.GluTesselator = function(){};

libtess.GluTesselator.prototype.gluDeleteTess = function(){};
libtess.GluTesselator.prototype.gluTessProperty = function(){};
libtess.GluTesselator.prototype.gluGetTessProperty = function(){};
libtess.GluTesselator.prototype.gluTessNormal = function(){};
libtess.GluTesselator.prototype.gluTessCallback = function(){};
libtess.GluTesselator.prototype.gluTessVertex = function(){};
libtess.GluTesselator.prototype.gluTessBeginPolygon = function(){};
libtess.GluTesselator.prototype.gluTessBeginContour = function(){};
libtess.GluTesselator.prototype.gluTessEndContour = function(){};
libtess.GluTesselator.prototype.gluTessEndPolygon = function(){};

/** @enum {number} */
libtess.windingRule = {
    GLU_TESS_WINDING_ODD: 100130,
    GLU_TESS_WINDING_NONZERO: 100131,
    GLU_TESS_WINDING_POSITIVE: 100132,
    GLU_TESS_WINDING_NEGATIVE: 100133,
    GLU_TESS_WINDING_ABS_GEQ_TWO: 100134
};

/** @enum {number} */
libtess.primitiveType = {
    GL_LINE_LOOP: 2,
    GL_TRIANGLES: 4,
    GL_TRIANGLE_STRIP: 5,
    GL_TRIANGLE_FAN: 6
};

/**
 * The types of errors provided in the error callback.
 * @enum {number}
 */
libtess.errorType = {
    GLU_TESS_MISSING_BEGIN_POLYGON: 100151,
    GLU_TESS_MISSING_END_POLYGON: 100153,
    GLU_TESS_MISSING_BEGIN_CONTOUR: 100152,
    GLU_TESS_MISSING_END_CONTOUR: 100154,
    GLU_TESS_COORD_TOO_LARGE: 100155,
    GLU_TESS_NEED_COMBINE_CALLBACK: 100156
};

/**
 * Enum values necessary for providing settings and callbacks. See the readme
 * for details.
 * @enum {number}
 */
libtess.gluEnum = {
    GLU_TESS_BEGIN: 100100,
    GLU_TESS_VERTEX: 100101,
    GLU_TESS_END: 100102,
    GLU_TESS_ERROR: 100103,
    GLU_TESS_EDGE_FLAG: 100104,
    GLU_TESS_COMBINE: 100105,
    GLU_TESS_BEGIN_DATA: 100106,
    GLU_TESS_VERTEX_DATA: 100107,
    GLU_TESS_END_DATA: 100108,
    GLU_TESS_ERROR_DATA: 100109,
    GLU_TESS_EDGE_FLAG_DATA: 100110,
    GLU_TESS_COMBINE_DATA: 100111,

    GLU_TESS_MESH: 100112,
    GLU_TESS_TOLERANCE: 100142,
    GLU_TESS_WINDING_RULE: 100140,
    GLU_TESS_BOUNDARY_ONLY: 100141,

    GLU_INVALID_ENUM: 100900,
    GLU_INVALID_VALUE: 100901
};
