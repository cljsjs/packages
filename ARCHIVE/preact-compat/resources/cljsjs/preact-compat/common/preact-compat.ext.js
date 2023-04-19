/**
 * @type {!Object}
 * @const
 */
var PreactCompat = {};

// Preact-compat publishes the same vars under window as React & ReactDOM.
// Defined here under PreactCompat object to prevent name clashes in externs.
PreactCompat.React = {};
PreactCompat.ReactDOM = {};

/**
 * @type {string}
 * @const
 */
PreactCompat.version;

/**
 * @type {Object}
 * @const
 */
PreactCompat.DOM = {};

/**
 * @typedef {
 *   boolean|number|string|PreactCompat.Component|
 *   Array.<boolean>|Array.<number>|Array.<string>|Array.<PreactCompat.Component>
 * }
 */
PreactCompat.ChildrenArgument;

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.a = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.abbr = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.address = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.area = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.article = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.aside = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.audio = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.b = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.base = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.bdi = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.bdo = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.big = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.blockquote = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.body = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.br = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.button = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.canvas = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.caption = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.circle = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.cite = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.clipPath = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.code = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.col = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.colgroup = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.data = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.datalist = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.dd = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.defs = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.del = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.details = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.dfn = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.dialog = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.div = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.dl = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.dt = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.ellipse = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.em = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.embed = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.fieldset = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.figcaption = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.figure = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.footer = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.form = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.g = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.h1 = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.h2 = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.h3 = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.h4 = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.h5 = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.h6 = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.head = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.header = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.hr = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.html = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.i = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.iframe = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.image = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.img = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.input = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.ins = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.kbd = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.keygen = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.label = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.legend = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.li = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.line = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.linearGradient = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.link = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.main = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.map = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.mark = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.mask = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.menu = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.menuitem = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.meta = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.meter = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.nav = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.noscript = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.object = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.ol = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.optgroup = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.option = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.output = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.p = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.param = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.path = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.pattern = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.picture = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.polygon = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.polyline = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.pre = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.progress = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.q = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.radialGradient = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.rect = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.rp = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.rt = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.ruby = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.s = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.samp = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.script = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.section = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.select = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.small = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.source = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.span = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.stop = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.strong = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.style = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.sub = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.summary = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.sup = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.svg = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.table = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.tbody = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.td = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.text = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.textarea = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.tfoot = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.th = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.thead = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.time = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.title = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.tr = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.track = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.tspan = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.u = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.ul = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.var = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.video = function(props, children) {};

/**
 * @param {Object=} props
 * @param {...PreactCompat.ChildrenArgument} children
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.DOM.wbr = function(props, children) {};

/**
 * @type {Object}
 */
PreactCompat.Children;

/**
 * @param {Object} children Children tree container.
 * @param {function(*, number)} mapFunction
 * @param {*=} mapContext Context for mapFunction.
 * @return {Object|undefined} Object containing the ordered map of results.
 */
PreactCompat.Children.map;

/**
 * @param {Object} children Children tree container.
 * @param {function(*, number)} mapFunction
 * @param {*=} mapContext Context for mapFunction.
 */
PreactCompat.Children.forEach;

/**
 * @param {Object} children Children tree container.
 * @return {Object|undefined}
 */
PreactCompat.Children.only;

/**
 * @param {PreactCompat.ReactComponent} container
 * @param {Element} mountPoint
 * @param {Function=} opt_callback
 * @return {PreactCompat.ReactComponent}
 */
PreactCompat.render = function(container, mountPoint, opt_callback) {};

PreactCompat.createElement = function(type, props) {};
PreactCompat.createClass = function(specification) {};
PreactCompat.createFactory = function(reactClass) {};

PreactCompat.cloneElement = function(element, props) {};

/**
 * @param {?Object} object
 * @return {boolean} True if `object` is a valid component.
 */
PreactCompat.isValidElement = function(object) {};

/**
 * @param {PreactCompat.ReactComponent} component
 * @return {Element}
 */
PreactCompat.findDOMNode = function(component) {};

/**
 * @param {Element} container
 * @return {boolean}
 */
PreactCompat.unmountComponentAtNode = function(container) {};

/**
 * Renders a React component into the DOM in the supplied `container`.
 *
 * If the React component was previously rendered into `container`, this will
 * perform an update on it and only mutate the DOM as necessary to reflect the
 * latest React component.
 *
 * @param {PreactCompat.ReactComponent} parentComponent The conceptual parent of this render tree.
 * @param {PreactCompat.ReactElement} nextElement Component element to render.
 * @param {Element} container DOM element to render into.
 * @param {Function=} opt_callback function triggered on completion
 * @return {PreactCompat.ReactComponent} Component instance rendered in `container`.
 */
PreactCompat.unstable_renderSubtreeIntoContainer = function(parentComponent, nextElement, container, opt_callback) {};

/**
 * @interface
 */
PreactCompat.Component = function() {};

/**
 * @type {Object}
 */
PreactCompat.Component.prototype.props;

/**
 * @type {Object}
 */
PreactCompat.Component.prototype.state;

/**
 * @type {Object}
 */
PreactCompat.Component.prototype.refs;

/**
 * @type {Object}
 */
PreactCompat.Component.prototype.context;

/**
 * @type {Object}
 * @protected
 */
PreactCompat.Component.prototype.propTypes;

/**
 * @type {Object}
 * @protected
 */
PreactCompat.Component.prototype.contextTypes;

/**
 * @type {Object}
 */
PreactCompat.Component.prototype.mixins;

/**
 * @return {Object}
 */
PreactCompat.Component.prototype.getInitialState = function() {};

/**
 * @return {Object}
 */
PreactCompat.Component.prototype.getDefaultProps = function() {};

/**
 * @return {Object}
 */
PreactCompat.Component.prototype.getChildContext = function() {};

/**
 * @param {PreactCompat.Component} targetComponent
 * @return {PreactCompat.Component}
 */
PreactCompat.Component.prototype.transferPropsTo = function(targetComponent) {};

/**
 * @param {Function=} callback
 */
PreactCompat.Component.prototype.forceUpdate = function(callback) {};

/**
 * @return {boolean}
 */
PreactCompat.Component.prototype.isMounted = function() {};

/**
 * @param {Object} nextState
 * @param {Function=} callback
 */
PreactCompat.Component.prototype.setState = function(nextState, callback) {};

/**
 * @param {Object} nextState
 * @param {Function=} callback
 */
PreactCompat.Component.prototype.replaceState = function(nextState, callback) {};

/**
 * @protected
 */
PreactCompat.Component.prototype.componentWillMount = function() {};

/**
 * @param {Element} element
 * @protected
 */
PreactCompat.Component.prototype.componentDidMount = function(element) {};

/**
 * @param {Object} nextProps
 * @protected
 */
PreactCompat.Component.prototype.componentWillReceiveProps = function(
  nextProps) {};

/**
 * @param {Object} nextProps
 * @param {Object} nextState
 * @return {boolean}
 * @protected
 */
PreactCompat.Component.prototype.shouldComponentUpdate = function(
  nextProps, nextState) {};

/**
 * @param {Object} nextProps
 * @param {Object} nextState
 * @protected
 */
PreactCompat.Component.prototype.componentWillUpdate = function(
  nextProps, nextState) {};

/**
 * @param {Object} prevProps
 * @param {Object} prevState
 * @param {Element} rootNode
 * @protected
 */
PreactCompat.Component.prototype.componentDidUpdate = function(
  prevProps, prevState, rootNode) {};

/**
 * @protected
 */
PreactCompat.Component.prototype.componentWillUnmount = function() {};

/**
 * @return {PreactCompat.Component}
 * @protected
 */
PreactCompat.Component.prototype.render = function() {};

/**
 * @extends {PreactCompat.Component}
 */
PreactCompat.PureComponent = function() {};

/**
 * @type {boolean}
 */
PreactCompat.PureComponent.prototype.isPureReactComponent;
