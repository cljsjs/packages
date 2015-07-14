var fabric = {
    version: "",
    isTouchSupported: "",
    isLikelyNode: "",
    SHARED_ATTRIBUTES: {},
    DPI: "",
    reNum: {},
    log: function(){},
    warn: function(){},
    cssRules: {},
    gradientDefs: {},
    parseTransformAttribute: function(){},
    parseSVGDocument: function(){},
    parseFontDeclaration: function(){},
    getGradientDefs: function(){},
    parseAttributes: function(){},
    parseElements: function(){},
    parseStyleAttribute: function(){},
    parsePointsAttribute: function(){},
    getCSSRules: function(){},
    createSVGFontFacesMarkup: function(){},
    createSVGRefElementsMarkup: function(){},
    /**
     * @constructor
     * @extends {fabric.Object}
     */
    ElementsParser: {
        element: {},
        callback: function(){},
        options: {},
        reviver: {},
        svgUid: {}
    },
    /**
     * @constructor
     * @extends {fabric.Object}
     */
    Point: {},
    Intersection: {
        status: {},
        points: {},
        intersectLineLine: function(){},
        intersectLinePolygon: function(){},
        intersectPolygonPolygon: function(){},
        intersectPolygonRectangle: function(){}
    },
    /**
     * @constructor
     * @extends {fabric.Object}
     */
    Color: {
        fromRgb: function(){},
        sourceFromRgb: function(){},
        fromRgba: function(){},
        fromHsl: function(){},
        sourceFromHsl: function(){},
        fromHsla: function(){},
        fromHex: function(){},
        sourceFromHex: function(){},
        fromSource: function(){}
    },
    /**
     * @constructor
     * @extends {fabric.Object}
     */
    Observable: {
        observe: function () {
        },
        stopObserving: function () {
        },
        fire: function () {
        },
        on: function () {
        },
        off: function () {
        },
        trigger: function () {
        }
    },
    /**
     * @constructor
     * @extends {fabric.Object}
     */
    Collection: {
        add: function () {
        },
        insertAt: function () {
        },
        remove: function () {
        },
        forEachObject: function () {
        },
        getObjects: function () {
        },
        item: function () {
        },
        isEmpty: function () {
        },
        size: function () {
        },
        contains: function () {
        },
        complexity: function () {
        }
    },
    util: {
        removeFromArray: function(){},
        getRandomInt: function(){},
        degreesToRadians: function(){},
        radiansToDegrees: function(){},
        rotatePoint: function(){},
        transformPoint: function(){},
        invertTransform: function(){},
        toFixed: function(){},
        parseUnit: function(){},
        falseFunction: function(){},
        getKlass: function(){},
        resolveNamespace: function(){},
        loadImage: function(){},
        enlivenObjects: function(){},
        groupSVGElements: function(){},
        populateWithProperties: function(){},
        drawDashedLine: function(){},
        createCanvasElement: function(){},
        createImage: function(){},
        createAccessors: function(){},
        clipContext: function(){},
        multiplyTransformMatrices: function(){},
        getFunctionBody: function(){},
        isTransparent: function(){},
        drawArc: function(){},
        getBoundsOfArc: function(){},
        getBoundsOfCurve: function(){},
        array: {
            invoke: function(){},
            min: function(){},
            max: function(){}
        },
        string: {
            camelize: function(){},
            capitalize: function(){},
            escapeXml: function(){}
        },
        createClass: function(){},
        addListener: function(){},
        removeListener: function(){},
        getPointer: function(){},
        setStyle: function(){},
        makeElementUnselectable: function(){},
        makeElementSelectable: function(){},
        getScript: function(){},
        getById: function(){},
        toArray: function(){},
        makeElement: function(){},
        addClass: function(){},
        wrapElement: function(){},
        getScrollLeftTop: function(){},
        getElementOffset: function(){},
        getElementStyle: function(){},
        animate: function(){},
        requestAnimFrame: function(){},
        ease: {
            easeInQuad: function(){},
            easeOutQuad: function(){},
            easeInOutQuad: function(){},
            easeInCubic: function(){},
            easeOutCubic: function(){},
            easeInOutCubic: function(){},
            easeInQuart: function(){},
            easeOutQuart: function(){},
            easeInOutQuart: function(){},
            easeInQuint: function(){},
            easeOutQuint: function(){},
            easeInOutQuint: function(){},
            easeInSine: function(){},
            easeOutSine: function(){},
            easeInOutSine: function(){},
            easeInExpo: function(){},
            easeOutExpo: function(){},
            easeInOutExpo: function(){},
            easeInCirc: function(){},
            easeOutCirc: function(){},
            easeInOutCirc: function(){},
            easeInElastic: function(){},
            easeOutElastic: function(){},
            easeInOutElastic: function(){},
            easeInBack: function(){},
            easeOutBack: function(){},
            easeInOutBack: function(){},
            easeInBounce: function(){},
            easeOutBounce: function(){},
            easeInOutBounce: function(){}
        }
    },
    loadSVGFromURL: function(){},
    loadSVGFromString: function(){},
    createCanvasForNode: function(){},
    /**
     * @constructor
     * @extends {fabric.Object}
     */
    Gradient: function(){},
    /**
     * @constructor
     * @extends {fabric.Object}
     */
    Pattern: function(){},
    /**
     * @constructor
     * @extends {fabric.Object}
     */
    Shadow: function(){},
    /**
     * @constructor
     * @extends {fabric.Object}
     */
    BaseBrush: function(){},
    /**
     * @constructor
     * @extends {fabric.Object}
     */
    PencilBrush: function(){},
    /**
     * @constructor
     * @extends {fabric.Object}
     */
    CircleBrush: function(){},
    /**
     * @constructor
     * @extends {fabric.Object}
     */
    SprayBrush: function(){},
    /**
     * @constructor
     * @extends {fabric.Object}
     */
    PatternBrush: function(){},
    /**
     * @constructor
     * @extends {fabric.Object}
     */
    StaticCanvas: function(){},
    /**
     * @constructor
     * @extends {fabric.StaticCanvas}
     */
    Canvas: function(){},
    /**
     * @constructor
     * @extends {fabric.Object}
     */
    Line: function(){},
    /**
     * @constructor
     * @extends {fabric.Object}
     */
    Circle: function(){},
    /**
     * @constructor
     * @extends {fabric.Object}
     */
    Triangle: function(){},
    /**
     * @constructor
     * @extends {fabric.Object}
     */
    Ellipse: function(){},
    /**
     * @constructor
     * @extends {fabric.Object}
     */
    Rect: function(){},
    /**
     * @constructor
     * @extends {fabric.Object}
     */
    Polyline: function(){},
    /**
     * @constructor
     * @extends {fabric.Object}
     */
    Polygon: function(){},
    /**
     * @constructor
     * @extends {fabric.Object}
     */
    Path: function(){},
    /**
     * @constructor
     * @extends {fabric.Object}
     */
    PathGroup: function(){},
    /**
     * @constructor
     * @extends {fabric.Object}
     */
    Group: function(){},
    /**
     * @constructor
     * @extends {fabric.Object}
     */
    Image: {
        fromURL: function(){},
        fromElement: function(){},
        fromObject: function(){},
        filters: {}
    },
    /**
     * @constructor
     * @extends {fabric.Object}
     */
    Text: {},
    /**
     * @constructor
     * @extends {fabric.Object}
     */
    IText: {}
};

fabric.ElementsParser.prototype = {
    parse: function(){},
    createObjects: function(){},
    createObject: function(){},
    createCallback: function(){},
    resolveGradient: function(){}
};

fabric.Point.prototype = {
    constructor: function(){},
    add: function(){},
    addEquals: function(){},
    scalarAdd: function(){},
    scalarAddEquals: function(){},
    subtract: function(){},
    subtractEquals: function(){},
    scalarSubtract: function(){},
    scalarSubtractEquals: function(){},
    multiply: function(){},
    multiplyEquals: function(){},
    divide: function(){},
    divideEquals: function(){},
    eq: function(){},
    lt: function(){},
    lte: function(){},
    gt: function(){},
    gte: function(){},
    lerp: function(){},
    distanceFrom: function(){},
    midPointFrom: function(){},
    min: function(){},
    max: function(){},
    toString: function(){},
    setXY: function(){},
    setFromPoint: function(){},
    swap: function(){}
};


fabric.Intersection.prototype = {
    appendPoint: function(){},
    appendPoints: function(){}
};

fabric.Color.prototype = {
    getSource: function(){},
    setSource: function(){},
    toRgb: function(){},
    toRgba: function(){},
    toHsl: function(){},
    toHsla: function(){},
    toHex: function(){},
    getAlpha: function(){},
    setAlpha: function(){},
    toGrayscale: function(){},
    toBlackWhite: function(){},
    overlayWith: function(){}
};

fabric.Gradient.prototype = {
    addColorStop: function(){},
    toObject: function(){},
    toSVG: function(){},
    toLive: function(){},
    fromElement: function(){},
    forObject: function(){}
};

fabric.Pattern.prototype = {
    toObject: function(){},
    toSVG: function(){},
    toLive: function(){}
};

fabric.Shadow.prototype = {
    toObject: function(){},
    toSVG: function(){},
    toLive: function(){},
    toString: function(){}
};

fabric.BaseBrush.prototype = {
    setShadow: function(){}
};

fabric.PencilBrush.prototype = {
    onMouseDown: function(){},
    onMouseMove: function(){},
    onMouseUp: function(){},
    convertPointsToSVGPath: function(){},
    createPath: function(){}
};

fabric.CircleBrush.prototype = {
    drawDot: function(){},
    onMouseDown: function(){},
    onMouseMove: function(){},
    onMouseUp: function(){},
    addPoint: function(){}
};

fabric.SprayBrush.prototype = {
    onMouseDown: function(){},
    onMouseMove: function(){},
    onMouseUp: function(){},
    render: function(){},
    addSprayChunk: function(){}
};

fabric.PatternBrush.prototype = {
    getPatternSrc: function(){},
    getPattern: function(){},
    createPath: function(){},
    loadFromJSON: function(){},
    clone: function(){},
    cloneWithoutData: function(){}
};

fabric.Line.prototype = {
    calcLinePoints: function(){},
    toSVG: function(){},
    complexity: function(){},
    fromElement: function(){},
    fromObject: function(){}
};

fabric.Circle.prototype = {
    toObject: function(){},
    toSVG: function(){},
    getRadiusX: function(){},
    getRadiusY: function(){},
    setRadius: function(){},
    complexity: function(){}
};

fabric.Triangle.prototype = {
    toSVG: function(){},
    complexity: function(){}
};

fabric.Rect.prototype = {
    toObject: function(){},
    toSVG: function(){},
    complexity: function(){}
};

fabric.Ellipse.prototype = {
    getRx: function(){},
    getRy: function(){},
    toObject: function(){},
    toSVG: function(){},
    complexity: function(){}
};

fabric.Polyline.prototype = {
    toObject: function(){},
    toSVG: function(){},
    complexity: function(){}
};

fabric.Polygon.prototype = {
    toObject: function(){},
    toSVG: function(){},
    complexity: function(){}
};

fabric.Path.prototype = {
    toString: function(){},
    toObject: function(){},
    toDatalessObject: function(){},
    toSVG: function(){},
    complexity: function(){}
};

fabric.PathGroup.prototype = {
    parseDimensionsFromPaths: function(){},
    render: function(){},
    toObject: function(){},
    toDatalessObject: function(){},
    toSVG: function(){},
    toString: function(){},
    isSameColor: function(){},
    complexity: function(){},
    getObjects: function(){}
};

fabric.Group.prototype = {
    toString: function(){},
    addWithUpdate: function(){},
    removeWithUpdate: function(){},
    toObject: function(){},
    render: function(){},
    realizeTransform: function(){},
    destroy: function(){},
    saveCoords: function(){},
    hasMoved: function(){},
    setObjectsCoords: function(){},
    toSVG: function(){},
    get: function(){}
};

fabric.Image.prototype = {
    getElement: function(){},
    setElement: function(){},
    setCrossOrigin: function(){},
    getOriginalSize: function(){},
    toObject: function(){},
    toSVG: function(){},
    getSrc: function(){},
    setSrc: function(){},
    toString: function(){},
    clone: function(){},
    applyFilters: function(){},
    complexity: function(){},
    getSvgSrc: function(){}
};

/**
 * @constructor
 * @extends {fabric.Object}
 */
fabric.Image.filters.BaseFilter = function(){};
fabric.Image.filters.BaseFilter.prototype = {
    setOptions: function(){},
    toObject: function(){},
    toJSON: function(){}
};

/**
 * @constructor
 * @extends {fabric.Object}
 */
fabric.Image.filters.Brightness = function(){};
fabric.Image.filters.Brightness.prototype = {
    applyTo: function(){},
    toObject: function(){},
    toJSON: function(){}
};

/**
 * @constructor
 * @extends {fabric.Object}
 */
fabric.Image.filters.Convolute = {
    fromObject: function(){}
};
fabric.Image.filters.Convolute.prototype = {
    applyTo: function(){},
    toObject: function(){}
};

/**
 * @constructor
 * @extends {fabric.Object}
 */
fabric.Image.filters.GradientTransparency = {
    fromObject: function(){}
};
fabric.Image.filters.GradientTransparency.prototype = {
    applyTo: function(){},
    toObject: function(){}
};

/**
 * @constructor
 * @extends {fabric.Object}
 */
fabric.Image.filters.Grayscale = {
    fromObject: function(){}
};

fabric.Image.filters.Grayscale.prototype = {
    applyTo: function(){}
};


/**
 * @constructor
 * @extends {fabric.Object}
 */
fabric.Image.filters.Invert = {
    fromObject: function(){}
};

fabric.Image.filters.Invert.prototype = {
    applyTo: function(){}
};

/**
 * @constructor
 * @extends {fabric.Object}
 */
fabric.Image.filters.Mask = {
    fromObject: function(){}
};

fabric.Image.filters.Mask.prototype = {
    applyTo: function(){},
    toObject: function(){}
};

/**
 * @constructor
 * @extends {fabric.Object}
 */
fabric.Image.filters.Noise = {
    fromObject: function(){}
};

fabric.Image.filters.Noise.prototype = {
    applyTo: function(){},
    toObject: function(){}
};

/**
 * @constructor
 * @extends {fabric.Object}
 */
fabric.Image.filters.Pixelate = {
    fromObject: function(){}
};

fabric.Image.filters.Pixelate.prototype = {
    applyTo: function(){},
    toObject: function(){}
};

/**
 * @constructor
 * @extends {fabric.Object}
 */
fabric.Image.filters.RemoveWhite = {
    fromObject: function(){}
};

fabric.Image.filters.RemoveWhite.prototype = {
    applyTo: function(){},
    toObject: function(){}
};

/**
 * @constructor
 * @extends {fabric.Object}
 */
fabric.Image.filters.Sepia = {
    fromObject: function(){}
};

fabric.Image.filters.Sepia.prototype = {
    applyTo: function(){},
    toObject: function(){}
};

/**
 * @constructor
 * @extends {fabric.Object}
 */
fabric.Image.filters.Sepia2 = {
    fromObject: function(){}
};

fabric.Image.filters.Sepia2.prototype = {
    applyTo: function(){},
    toObject: function(){}
};

/**
 * @constructor
 * @extends {fabric.Object}
 */
fabric.Image.filters.Tint = {
    fromObject: function(){}
};

fabric.Image.filters.Tint.prototype = {
    applyTo: function(){},
    toObject: function(){}
};

/**
 * @constructor
 * @extends {fabric.Object}
 */
fabric.Image.filters.Multiply = {
    fromObject: function(){}
};

fabric.Image.filters.Multiply.prototype = {
    applyTo: function(){},
    toObject: function(){}
};

/**
 * @constructor
 * @extends {fabric.Object}
 */
fabric.Image.filters.Blend = {
    fromObject: function(){}
};

fabric.Image.filters.Blend.prototype = {
    applyTo: function(){},
    toObject: function(){}
};


/**
 * @constructor
 * @extends {fabric.Object}
 */fabric.Image.filters.Resize = {
    fromObject: function(){}
};

fabric.Image.filters.Resize.prototype = {
    applyTo: function(){},
    toObject: function(){},
    sliceByTwo: function(){},
    lanczosResize: function(){},
    bilinearFiltering: function(){},
    hermiteFastResize: function(){}
};


fabric.Text.prototype = {
    toString: function(){},
    render: function(){},
    toObject: function(){},
    toSVG: function(){}
};

fabric.IText.prototype = {
    isEmptyStyles: function(){},
    setSelectionStart: function(){},
    setSelectionEnd: function(){},
    getSelectionStyles: function(){},
    setSelectionStyles: function(){},
    renderCursorOrSelection: function(){},
    get2DCursorLocation: function(){},
    getCurrentCharStyle: function(){},
    getCurrentCharFontSize: function(){},
    getCurrentCharColor: function(){},
    renderCursor: function(){},
    renderSelection: function(){},
    toObject: function(){},

    initBehavior: function(){},
    initSelectedHandler: function(){},
    initAddedHandler: function(){},
    initRemovedHandler: function(){},
    initDelayedCursor: function(){},
    abortCursorAnimation: function(){},
    selectAll: function(){},
    getSelectedText: function(){},
    findWordBoundaryLeft: function(){},
    findWordBoundaryRight: function(){},
    findLineBoundaryLeft: function(){},
    findLineBoundaryRight: function(){},
    getNumNewLinesInSelectedText: function(){},
    searchWordBoundary: function(){},
    selectWord: function(){},
    selectLine: function(){},
    enterEditing: function(){},
    exitEditingOnOthers: function(){},
    initMouseMoveHandler: function(){},
    exitEditing: function(){},
    insertChars: function(){},
    insertNewlineStyleObject: function(){},
    insertCharStyleObject: function(){},
    insertStyleObjects: function(){},
    shiftLineStyles: function(){},
    removeStyleObject: function(){},
    insertNewline: function(){},

    initDoubleClickSimulation: function(){},
    onMouseDown: function(){},
    isDoubleClick: function(){},
    isTripleClick: function(){},
    initCursorSelectionHandlers: function(){},
    initClicks: function(){},
    initMousedownHandler: function(){},
    initMouseupHandler: function(){},
    setCursorByClick: function(){},
    getSelectionStartFromPointer: function(){},

    initHiddenTextarea: function(){},
    onClick: function(){},
    onKeyDown: function(){},
    forwardDelete: function(){},
    copy: function(){},
    paste: function(){},
    cut: function(){},
    onKeyPress: function(){},
    getDownCursorOffset: function(){},
    moveCursorDown: function(){},
    moveCursorDownWithoutShift: function(){},
    moveCursorDownWithShift: function(){},
    getUpCursorOffset: function(){},
    moveCursorUp: function(){},
    moveCursorUpWithShift: function(){},
    moveCursorUpWithoutShift: function(){},
    moveCursorLeft: function(){},
    moveCursorLeftWithoutShift: function(){},
    moveCursorLeftWithShift: function(){},
    moveCursorRight: function(){},
    moveCursorRightWithShift: function(){},
    moveCursorRightWithoutShift: function(){},
    removeChars: function(){}
};


fabric.Canvas.prototype = {
    toDataURL: function(){},
    toDataURLWithMultiplier: function(){},
    loadFromDatalessJSON: function(){},

    containsPoint: function(){},
    isTargetTransparent: function(){},
    setCursor: function(){},
    findTarget: function(){},
    getPointer: function(){},
    getSelectionContext: function(){},
    getSelectionElement: function(){},
    setActiveObject: function(){},
    getActiveObject: function(){},
    discardActiveObject: function(){},
    setActiveGroup: function(){},
    getActiveGroup: function(){},
    discardActiveGroup: function(){},
    deactivateAll: function(){},
    deactivateAllWithDispatch: function(){},
    drawControls: function(){}
};

//stateProperties:  (
//    'top left width height scaleX scaleY flipX flipY originX originY transformMatrix ' +
//    'stroke strokeWidth strokeDashArray strokeLineCap strokeLineJoin strokeMiterLimit ' +
//    'angle opacity fill fillRule globalCompositeOperation shadow clipTo visible backgroundColor'
//).split(' '),

fabric.StaticCanvas.prototype = {
    calcOffset: function(){},
    setOverlayImage: function(){},
    setBackgroundImage: function(){},
    setOverlayColor: function(){},
    setBackgroundColor: function(){},
    getWidth: function(){},
    getHeight: function(){},
    setWidth: function(){},
    setHeight: function(){},
    setDimensions: function(){},
    getZoom: function(){},
    setViewportTransform: function(){},
    zoomToPoint: function(){},
    setZoom: function(){},
    absolutePan: function(){},
    relativePan: function(){},
    getElement: function(){},
    getActiveObject: function(){},
    getActiveGroup: function(){},
    clearContext: function(){},
    getContext: function(){},
    clear: function(){},
    renderAll: function(){},
    renderTop: function(){},
    getCenter: function(){},
    centerObjectH: function(){},
    centerObjectV: function(){},
    centerObject: function(){},
    toDatalessJSON: function(){},
    toObject: function(){},
    toDatalessObject: function(){},
    toSVG: function(){},
    sendToBack: function(){},
    bringToFront: function(){},
    sendBackwards: function(){},
    bringForward: function(){},
    moveTo: function(){},
    dispose: function(){},
    toString: function(){},

    supports: function(){},


    fxCenterObjectH: function(){},
    fxCenterObjectV: function(){},
    fxRemove: function(){},

    straightenObject: function(){},
    fxStraightenObject: function(){},

    setWidth: function(){},
    setHeight: function(){}
};

fabric.Object.prototype = {
    /** attributes */
    setTop: function(){},
    getTop: function(){},
    setLeft: function(){},
    getLeft: function(){},
    setWidth: function(){},
    getWidth: function(){},
    setHeight: function(){},
    getHeight: function(){},
    setScaleX: function(){},
    getScaleX: function(){},
    setScaleY: function(){},
    getScaleY: function(){},
    setFlipX: function(){},
    getFlipX: function(){},
    setFlipY: function(){},
    getFlipY: function(){},
    setOriginX: function(){},
    getOriginX: function(){},
    setOriginY: function(){},
    getOriginY: function(){},
    setTransformMatrix: function(){},
    getTransformMatrix: function(){},
    setStroke: function(){},
    getStroke: function(){},
    setStrokeWidth: function(){},
    getStrokeWidth: function(){},
    setStrokeDashArray: function(){},
    getStrokeDashArray: function(){},
    setStrokeLineCap: function(){},
    getStrokeLineCap: function(){},
    setStrokeLineJoin: function(){},
    getStrokeLineJoin: function(){},
    setStrokeMiterLimit: function(){},
    getStrokeMiterLimit: function(){},
    setAngle: function(){},
    getAngle: function(){},
    setOpacity: function(){},
    getOpacity: function(){},
    setFill: function(){},
    getFill: function(){},
    setFillRule: function(){},
    getFillRule: function(){},
    setGlobalCompositeOperation: function(){},
    getGlobalCompositeOperation: function(){},
    setShadow: function(){},
    getShadow: function(){},
    setClipTo: function(){},
    getClipTo: function(){},
    setVisible: function(){},
    getVisible: function(){},
    setBackgroundColor: function(){},
    getBackgroundColor: function(){},
    setRx: function(){},
    getRx: function(){},
    setRy: function(){},
    getRy: function(){},
    setX: function(){},
    getX: function(){},
    setY: function(){},
    getY: function(){},
    setFontFamily: function(){},
    getFontFamily: function(){},
    setFontWeight: function(){},
    getFontWeight: function(){},
    setFontSize: function(){},
    getFontSize: function(){},
    setText: function(){},
    getText: function(){},
    setTextDecoration: function(){},
    getTextDecoration: function(){},
    setTextAlign: function(){},
    getTextAlign: function(){},
    setFontStyle: function(){},
    getFontStyle: function(){},
    setLineHeight: function(){},
    getLineHeight: function(){},
    setTextBackgroundColor: function(){},
    getTextBackgroundColor: function(){},
    setX1: function(){},
    getX1: function(){},
    setY1: function(){},
    getY1: function(){},
    setX2: function(){},
    getX2: function(){},
    setY2: function(){},
    getY2: function(){},
    setCx: function(){},
    getCx: function(){},
    setCy: function(){},
    getCy: function(){},
    setR: function(){},
    getR: function(){},
    setPreserveaSpectRatio: function(){},
    getPreserveaSpectRatio: function(){},
    setDx: function(){},
    getDx: function(){},
    setDy: function(){},
    getDy: function(){},
    setTextAnchor: function(){},
    getTextAnchor: function(){},
    /** end of attributes */

    setOptions: function(){},
    transform: function(){},
    toObject: function(){},
    toDatalessObject: function(){},
    toString: function(){},
    get: function(){},
    set: function(){},
    toggle: function(){},
    setSourcePath: function(){},
    getViewportTransform: function(){},
    render: function(){},
    clone: function(){},
    cloneAsImage: function(){},
    toDataURL: function(){},
    isType: function(){},
    complexity: function(){},
    toJSON: function(){},
    setGradient: function(){},
    setPatternFill: function(){},
    setColor: function(){},
    centerH: function(){},
    centerV: function(){},
    center: function(){},
    remove: function(){},
    getLocalPointer: function(){},
    rotate: function(){},

    translateToCenterPoint: function(){},
    translateToOriginPoint: function(){},
    getCenterPoint: function(){},
    getPointByOrigin: function(){},
    toLocalPoint: function(){},
    setPositionByOrigin: function(){},
    adjustPosition: function(){},

    intersectsWithRect: function(){},
    intersectsWithObject: function(){},
    isContainedWithinObject: function(){},
    isContainedWithinRect: function(){},
    containsPoint: function(){},
    getBoundingRectWidth: function(){},
    getBoundingRectHeight: function(){},
    getBoundingRect: function(){},
    getHeight: function(){},
    scale: function(){},
    scaleToWidth: function(){},
    scaleToHeight: function(){},
    setCoords: function(){},

    sendToBack: function(){},
    bringToFront: function(){},
    sendBackwards: function(){},
    bringForward: function(){},
    moveTo: function(){},

    getSvgStyles: function(){},
    getSvgTransform: function(){},
    getSvgTransformMatrix: function(){},

    hasStateChanged: function(){},
    saveState: function(){},
    setupState: function(){},

    drawBorders: function(){},
    drawControls: function(){},
    isControlVisible: function(){},
    setControlVisible: function(){},
    setControlsVisibility: function(){},

    animate: function(){},

    straighten: function(){},
    fxStraighten: function(){}


};


