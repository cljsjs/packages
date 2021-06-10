var vdomNode = {
  /** @type {Array<vdomNode>} */
  children: [],
  data: {
    attrs: {},
    hook: {
      destroy: function () {},
      update: function () {},
      insert: function () {},
      remove: function () {},
      pre: function () {}
    }
  },
  elm: {},
  key: {},
  listener: function () {},
  sel: "",
  text: ""
};

/**
 * Externs for snabbdom. Previously generated with
 * http://jmmk.github.io/javascript-externs-generator, now compiled by hand.
 */
var snabbdom = {
  array: function () {},
  attachTo: function () {},
  attributesModule: {
    create: function () {},
    update: function () {}
  },
  classModule: {
    create: function () {},
    update: function () {}
  },
  datasetModule: {
    create: function () {},
    update: function () {}
  },
  eventListenersModule: {
    create: function () {},
    update: function () {},
    destroy: function () {}
  },
  /**
   * @return {vdomNode}
   */
  h: function () {},
  htmlDomApi: {
    createElement: function () {},
    createElementNS: function () {},
    createTextNode: function () {},
    createComment: function () {},
    insertBefore: function () {},
    removeChild: function () {},
    appendChild: function () {},
    parentNode: function () {},
    nextSibling: function () {},
    tagName: function () {},
    setTextContent: function () {},
    getTextContent: function () {},
    isElement: function () {},
    isText: function () {},
    isComment: function () {}
  },
  init: function () {},
  jsx: function () {},
  primitive: function () {},
  propsModule: {
    create: function () {},
    update: function () {}
  },
  styleModule: {
    pre: function () {},
    create: function () {},
    update: function () {},
    destroy: function () {},
    remove: function () {}
  },
  thunk: function () {},
  /**
   * @return {vdomNode}
   */
  toVNode: function () {},
  vnode: function () {}
};
