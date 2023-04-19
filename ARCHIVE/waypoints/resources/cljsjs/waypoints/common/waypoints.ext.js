var Waypoint = {
  "invokeAll": function () {},
  "refreshAll": function () {},

  "enableAll": function () {},
  "disableAll": function () {},
  "destroyAll": function () {},

  "requestAnimationFrame": function () {},

  "viewportHeight": function () {},
  "viewportWidth": function () {},

  "adapters": {},
  "defaults": {
    "context": {},
    "continuous": {},
    "enabled": {},
    "group": {},
    "horizontal": {},
    "offset": {}
  },
  "offsetAliases": {
    "bottom-in-view": function () {},
    "right-in-view": function () {}
  },
  "Context": {
    "findByElement": function () {},
    "findOrCreateByElement": function () {},
    "refreshAll": function () {}
  },
  "Group": {
    "findOrCreate": function () {}
  },
  "Adapter": {
    "extend": function () {},
    "inArray": function () {},
    "isEmptyObject": function () {}
  }
};

Waypoint.prototype = {
  "enable": function () {},
  "disable": function () {},

  "next": function () {},
  "previous": function () {},

  "destroy": function () {},

  "trigger": function () {},
  "queueTrigger": function () {}
};

Waypoint.Context.prototype = {
  "add": function () {},
  "remove": function () {},
  "destroy": function () {},
  "refresh": function () {},

  "checkEmpty": function () {},

  "innerHeight": function () {},
  "innerWidth": function () {},

  "handleResize": function () {},
  "handleScroll": function () {},

  "createThrottledResizeHandler": function () {},
  "createThrottledScrollHandler": function () {}
};

Waypoint.Group.prototype = {
  "add": function () {},
  "remove": function () {},

  "first": function () {},
  "last": function () {},
  "next": function () {},
  "previous": function () {},

  "queueTrigger": function () {},
  "flushTriggers": function () {},
  "clearTriggerQueues": function () {}
};

Waypoint.Adapter.prototype = {
  "offset": function () {},

  "off": function () {},
  "on": function () {},

  "scrollLeft": function () {},
  "scrollTop": function () {},

  "innerHeight": function () {},
  "innerWidth": function () {},
  "outerHeight": function () {},
  "outerWidth": function () {}
};
