var Phoenix = {
  "Channel": function () {},
  "Socket": function () {},
  "LongPoll": function () {},
  "Ajax": function () {}
};

Phoenix.Channel.prototype = function () {};
Phoenix.Channel.prototype = {
  bindings: {},
  canPush: function () {},
  join: function () {},
  joinPush: {
    receive: function () {},
    resend: function () {},
    send: function () {}
  },
  joinedOnce: {},
  leave: function () {},
  off: function () {},
  on: function () {},
  onClose: function () {},
  onError: function () {},
  onMessage: function () {},
  params: {},
  push: function () {},
  pushBuffer: {},
  rejoin: function () {},
  rejoinTimer: {},
  rejoinUntilConnected: function () {},
  replyEventName: function () {},
  socket: {},
  state: {},
  timeout: {},
  topic: {},
  trigger: function () {}
};

Phoenix.Socket.prototype = function () {};
Phoenix.Socket.prototype = {
  stateChangeCallbacks: {
    open: {},
    close: {},
    error: {},
    message: {}
  },
  channels: {},
  sendBuffer: {},
  ref: {},
  timeout: {},
  transport: {},
  heartbeatIntervalMs: {},
  reconnectAfterMs: {},
  logger: {},
  longpollerTimeout: {},
  params: {},
  endPoint: {},
  reconnectTimer: {},
  protocol: function () {},
  endPointURL: function () {},
  disconnect: function () {},
  connect: function () {},
  log: function () {},
  onOpen: function () {},
  onClose: function () {},
  onError: function () {},
  onMessage: function () {},
  onConnOpen: function () {},
  onConnClose: function () {},
  onConnError: function () {},
  triggerChanError: function () {},
  connectionState: function () {},
  isConnected: function () {},
  remove: function () {},
  channel: function () {},
  push: function () {},
  makeRef: function () {},
  sendHeartbeat: function () {},
  flushSendBuffer: function () {},
  onConnMessage: function () {}
};

Phoenix.LongPoll.prototype = function () {};
Phoenix.LongPoll.prototype = {
  endPoint: {},
  token: {},
  skipHeartbeat: {},
  onopen: {},
  onerror: {},
  onmessage: {},
  onclose: {},
  pollEndpoint: {},
  readyState: {},
  normalizeEndpoint: function () {},
  endpointURL: function () {},
  closeAndRetry: function () {},
  ontimeout: function () {},
  poll: function () {},
  send: function () {},
  close: function () {}
};

Phoenix.Ajax.prototype = function () {};
Phoenix.Ajax.prototype = {
  request: function () {},
  xdomainRequest: function () {},
  xhrRequest: function () {},
  parseJSON: function () {},
  serialize: function () {},
  appendParams: function () {},
  states: {}
};

Phoenix.Presence.prototype = function () {};
Phoenix.Presence.prototype = {
  syncState: function () {},
  syncDiff: function () {},
  list: function () {}
};

