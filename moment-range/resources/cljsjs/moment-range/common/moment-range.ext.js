
//-----------------------------------------------------------------------------
// Contstants
//-----------------------------------------------------------------------------



var INTERVALS = {};


//-----------------------------------------------------------------------------
// Date Ranges
//-----------------------------------------------------------------------------

/**
 * DateRange class to store ranges and query dates.
 *
 * @constructor
 * @param {(Moment|Date)} start Start of interval
 * @param {(Moment|Date)} end End of interval
 *//**
 * DateRange class to store ranges and query dates.
 *
 * @constructor
 * @param {!Array} range Array containing start and end dates.
 *//**
 * DateRange class to store ranges and query dates.
 *
 * @constructor
 * @param {!String} range String formatted as an IS0 8601 time interval
 */
function DateRange() {}

/**
 * Constructor for prototype.
 *
 * @type {DateRange}
 */
DateRange.prototype.constructor = DateRange;

/**
 * Deep clone range.
 *
 * @return {!DateRange}
 */
DateRange.prototype.clone = function() {};

/**
 * Determine if the current interval contains a given moment/date/range.
 *
 * @param {(Moment|Date|DateRange)} other Date to check
 * @param {!boolean} exclusive True if the to value is exclusive
 *
 * @return {!boolean}
 */
DateRange.prototype.contains = function() {};

/**
 * Determine if the current date range overlaps a given date range.
 *
 * @param {!DateRange} range Date range to check
 *
 * @return {!boolean}
 */
DateRange.prototype.overlaps = function() {};

/**
 * Determine the intersecting periods from one or more date ranges.
 *
 * @param {!DateRange} other A date range to intersect with this one
 *
 * @return {DateRange} Returns the intersecting date or `null` if the ranges do
 *                     not intersect
 */
DateRange.prototype.intersect = function() {};

/**
 * Merge date ranges if they intersect.
 *
 * @param {!DateRange} other A date range to add to this one
 *
 * @return {DateRange} Returns the new `DateRange` or `null` if they do not
 *                     overlap
 */
DateRange.prototype.add = function() {};

/**
 * Subtract one range from another.
 *
 * @param {!DateRange} other A date range to substract from this one
 *
 * @return {!Array<DateRange>}
 */
DateRange.prototype.subtract = function() {};

/**
 * Iterate over the date range by a given date range, executing a function
 * for each sub-range.
 *
 * @param {(!DateRange|String)} range Date range to be used for iteration or
 *                                    shorthand string (shorthands:
 *                                    http://momentjs.com/docs/#/manipulating/add/)
 * @param {!DateRange~by} hollaback Callback
 * @param {!boolean} exclusive Indicate that the end of the range should not
 *                             be included in the iter.
 *
 * @return {DateRange} `this`
 */
DateRange.prototype.by = function() {};


/**
 * Callback executed for each sub-range.
 *
 * @callback DateRange~by
 *
 * @param {!Moment} current Current moment object for iteration
 */

/**
 * @private
 */
function _byString() {}

/**
 * @private
 */
function _byRange() {}

/**
 * Date range formatted as an [ISO8601 Time
 * Interval](http://en.wikipedia.org/wiki/ISO_8601#Time_intervals).
 *
 * @return {!String}
 */
DateRange.prototype.toString = function() {};

/**
 * Date range in milliseconds. Allows basic coercion math of date ranges.
 *
 * @return {!number}
 */
DateRange.prototype.valueOf = function() {};

/**
 * Center date of the range.
 *
 * @return {!Moment}
 */
DateRange.prototype.center = function() {};

/**
 * Date range toDate
 *
 * @return {!Array<Date>}
 */
DateRange.prototype.toDate = function() {};

/**
 * Determine if this date range is the same as another.
 *
 * @param {!DateRange} other Another date range to compare to
 *
 * @return {!boolean}
 */
DateRange.prototype.isSame = function() {};

/**
 * The difference of the end vs start.
 *
 * @param {number} unit Unit of difference, if no unit is passed in
 *                      milliseconds are returned. E.g.: `"days"`, `"months"`,
 *                      etc...
 *
 * @return {!number}
 */
DateRange.prototype.diff = function() {};


//-----------------------------------------------------------------------------
// Moment Extensions
//-----------------------------------------------------------------------------

/**
 * Build a date range.
 *
 * @param {(Moment|Date)} start Start of range
 * @param {(Moment|Date)} end End of range
 *
 * @this {Moment}
 *
 * @return {!DateRange}
 */
moment.range = function() {};

/**
 * Expose constructor
 *
 * @const
 */
moment.range.constructor = DateRange;

/**
 * @deprecated
 */
moment.fn.range = moment.range;

/**
 * Check if the current moment is within a given date range.
 *
 * @param {!DateRange} range Date range to check
 *
 * @this {Moment}
 *
 * @return {!boolean}
 */
moment.fn.within = function() {};


//-----------------------------------------------------------------------------
// Export
//-----------------------------------------------------------------------------
