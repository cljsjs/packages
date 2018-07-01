/**
 * @fileoverview Closure Compiler externs for SheetJS xlsx
 * @see https://sheetjs.com/
 * @externs
 */

/**
 * @type {Object}
 * @const
 */
var XLSX = {};

/**
 * @type {string}
 * @const
 */
XLSX.version;

/**
 * @type {Object}
 * @const
 */
XLSX.stream = {};

/**
 * @param {*} ws
 * @param {?Object} opts
 * @return {*}
 */
XLSX.stream.to_html = function(ws, opts) {};

/**
 * @param {*} sheet
 * @param {?Object} opts
 * @return {*}
 */
XLSX.stream.to_csv = function(sheet, opts) {};

/**
 * @param {*} cfb
 * @param {*} options
 */
XLSX.parse_xlscfb = function(cfb, options) {};

/**
 * @param {*} zip
 * @param {*} opts
 */
XLSX.parse_ods = function(zip, opts) {};

/**
 * @param {*} data
 * @param {*} opts
 */
XLSX.parse_fods = function(data, opts) {};

/**
 * @param {*} wb
 * @param {*} opts
 */
XLSX.write_ods = function(wb, opts) {};

/**
 * @param {*} zip
 * @param {*} opts
 */
XLSX.parse_zip = function(zip, opts) {};

/**
 * @param {*} data
 * @param {*} opts
 */
XLSX.read = function(data, opts) {};

/**
 * Alias for XLSX.readFileSync
 * @param {*} filename
 * @param {*} opts
 */
XLSX.readFile = function(filename, opts) {};

/**
 * @param {*} filename
 * @param {*} opts
 */
XLSX.readFileSync = function(filename, opts) {};

/**
 * @param {*} wb
 * @param {*} opts
 */
XLSX.write = function(wb, opts) {};

/**
 * Alias for XLSX.writeFileSync
 * @param {*} wb
 * @param {*} filename
 * @param {*} opts
 */
XLSX.writeFile = function(wb, filename, opts) {};

/**
 * @param {*} wb
 * @param {*} filename
 * @param {*} opts
 */
XLSX.writeFileSync = function(wb, filename, opts) {};

/**
 * @param {*} wb
 * @param {*} filename
 * @param {*} opts
 * @param {*} cb
 */
XLSX.writeFileAsync = function(wb, filename, opts, cb) {};

/**
 * @type {Object}
 * @const
 */
XLSX.utils = {};

/**
 * @type {Object}
 * @const
 */
XLSX.utils.consts = {
    "SHEET_VISIBLE": 0,
    "SHEET_HIDDEN": 1,
    "SHEET_VERY_HIDDEN": 2
};

/**
 * @param {number} col
 * @return {string}
 */
XLSX.utils.encode_col = function(col) {};

/**
 * @param {number} row
 * @return {string}
 */
XLSX.utils.encode_row = function(row) {};

/**
 * @param {*} cell
 */
XLSX.utils.encode_cell = function(cell) {};

/**
 * @param {*} cs
 * @param {*} ce
 */
XLSX.utils.encode_range = function(cs, ce) {};

/**
 * @param {string} colstr
 * @return {number}
 */
XLSX.utils.decode_col = function(colstr) {};

/**
 * @param {string} rowstr
 * @return {number}
 */
XLSX.utils.decode_row = function(rowstr) {};

/**
 * @param {string} cstr
 * @return {Array<string>}
 */
XLSX.utils.split_cell = function(cstr) {};

/**
 * @param {string} cstr
 * @return {Object}
 */
XLSX.utils.decode_cell = function(cstr) {};

/**
 * @param {string} range
 * @return {Object}
 */
XLSX.utils.decode_range = function(range) {};

/**
 * @param {?Object} cell
 * @param {*} v
 * @param {*} o
 * @return {*}
 */
XLSX.utils.format_cell = function(cell, v, o) {};

/**
 * Alias for XLSX.utils.sheet_to_formulae
 * @param {*} sheet
 * @return {Array<*>}
 */
XLSX.utils.get_formulae = function(sheet) {};

/**
 * Alias for XLSX.utils.sheet_to_csv
 * @param {*} sheet
 * @param {?Object} opts
 * @return {string}
 */
XLSX.utils.make_csv = function(sheet, opts) {};

/**
 * Alias for XLSX.utils.sheet_to_json
 * @param {*} sheet
 * @param {?Object} opts
 * @return {Array<*>}
 */
XLSX.utils.make_json = function(sheet, opts) {};

/**
 * Alias for XLSX.utils.sheet_to_formulae
 * @param {*} sheet
 * @return {Array<*>}
 */
XLSX.utils.make_formulae = function(sheet, opts) {};

/**
 * @param {*} _ws
 * @param {*} data
 * @param {?Object} opts
 * @return {Object|Array<*>}
 */
XLSX.utils.sheet_add_aoa = function(_ws, data, opts) {};

/**
 * @param {*} _ws
 * @param {*} js
 * @param {?Object} opts
 * @return {Object}
 */
XLSX.utils.sheet_add_json = function(_ws, js, opts) {};

/**
 * @param {*} data
 * @param {?Object} opts
 * @return {Object|Array<*>}
 */
XLSX.utils.aoa_to_sheet = function(data, opts) {};

/**
 * @param {*} js
 * @param {?Object} opts
 * @return {Object|Array<*>}
 */
XLSX.utils.json_to_sheet = function(js, opts) {};

/**
 * @param {*} table
 * @param {?Object} _opts
 * @return {Object|Array<*>}
 */
XLSX.utils.table_to_sheet = function(table, _opts) {};

/**
 * @param {*} table
 * @param {?Object} opts
 * @return {*}
 */
XLSX.utils.table_to_book = function(table, opts) {};

/**
 * @param {*} sheet
 * @param {?Object} opts
 * @return {string}
 */
XLSX.utils.sheet_to_csv = function(sheet, opts) {};

/**
 * @param {*} sheet
 * @param {?Object} opts
 * @return {string}
 */
XLSX.utils.sheet_to_txt = function(sheet, opts) {};

/**
 * @param {*} sheet
 * @param {?Object} opts
 * @return {Array<*>}
 */
XLSX.utils.sheet_to_json = function(sheet, opts) {};

/**
 * @param {*} ws
 * @param {?Object} opts
 * @return {string}
 */
XLSX.utils.sheet_to_html = function(ws, opts) {};

/**
 * @param {*} ws
 * @return {*}
 */
XLSX.utils.sheet_to_dif = function(ws) {};

/**
 * @param {*} ws
 * @param {*} opts
 * @return {string}
 */
XLSX.utils.sheet_to_slk = function(ws, opts) {};

/**
 * @param {*} ws
 * @return {string}
 */
XLSX.utils.sheet_to_eth = function(ws) {};

/**
 * @param {*} sheet
 * @return {Array<*>}
 */
XLSX.utils.sheet_to_formulae = function(sheet) {};

/**
 * Alias for XLSX.utils.sheet_to_json
 * @param {*} sheet
 * @param {?Object} opts
 * @return {Array<*>}
 */
XLSX.utils.sheet_to_row_object_array = function(sheet, opts) {};

/**
 * @return {Object}
 */
XLSX.utils.book_new = function() {};

/**
 * @param {*} wb
 * @param {*} ws
 * @param {*} name
 */
XLSX.utils.book_append_sheet = function(wb, ws, name) {};

/**
 * @param {*} wb
 * @param {*} sh
 * @param {*} vis
 */
XLSX.utils.book_set_sheet_visibility = function(wb, sh, vis) {};

/**
 * @param {Object} cell
 * @param {*} fmt
 * @return {Object}
 */
XLSX.utils.cell_set_number_format = function(cell, fmt) {};

/**
 * @param {Object} cell
 * @param {*} target
 * @param {*} tooltip
 * @return {Object}
 */
XLSX.utils.cell_set_hyperlink = function(cell, target, tooltip) {};

/**
 * @param {Object} cell
 * @param {string} range
 * @param {*} tooltip
 * @return {Object}
 */
XLSX.utils.cell_set_internal_link = function(cell, range, tooltip) {};

/**
 * @param {Object} cell
 * @param {string} text
 * @param {string} author
 * @return {Object}
 */
XLSX.utils.cell_add_comment = function(cell, text, author) {};

/**
 * @param {*} ws
 * @param {*} range
 * @param {*} formula
 * @return {*}
 */
XLSX.utils.sheet_set_array_formula = function(ws, range, formula) {};

/**
 * @type {Object}
 * @const
 */
XLSX.SSF = {};

/**
 * @type {string}
 * @const
 */
XLSX.SSF.version;

/**
 * @param {number} v
 * @param {?Object} opts
 * @param {*} b2
 * @return {*}
 */
XLSX.SSF.parse_date_code = function(v, opts, b2) {};

/**
 * @param {string} fmt
 * @return {boolean}
 */
XLSX.SSF.is_date = function(fmt) {};

/**
 * @param {string} fmt
 * @param {*} idx
 * @return {*}
 */
XLSX.SSF.load = function(fmt, idx) {};

/**
 * @return {*}
 */
XLSX.SSF.get_table = function() {};

/**
 * @param {*} tbl
 */
XLSX.SSF.load_table = function(tbl) {};

/**
 * @param {*} t
 */
XLSX.SSF.init_table = function(t) {};

/**
 * @param {*} fmt
 * @param {*} v
 * @param {*} o
 * @return {*}
 */
XLSX.SSF.format = function(fmt, v, o) {};

/**
 * @type {*}
 * @const
 */
XLSX.CFB;
