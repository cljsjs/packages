// ResizeObserver polyfill.
// As per the spec.
// https://wicg.github.io/ResizeObserver/#resize-observer-entry-interface
var ResizeObserver = function() {};
ResizeObserver.prototype = {
  "observe": function () {},
  "unobserve": function () {},
  "disconnect": function () {}
};
var ResizeObserverEntry = function () {};
ResizeObserverEntry.Element = {};
ResizeObserverEntry.contentRect = {};
