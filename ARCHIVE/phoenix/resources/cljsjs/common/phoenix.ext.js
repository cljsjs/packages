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
  joinedOnce: {},
  joinPush: {
    channel: {},
    event: {},
    payload: {},
    receive: function () {},
    receivedResp: {},
    recHooks: {},
    resend: function () {},
    sent: {},
    send: function () {},
    timeout: {},
    timeoutTimer: {}
  },
  leave: function () {},
  off: function () {},
  on: function () {},
  onClose: function () {},
  onError: function () {},
  onMessage: function () {},
  params: {},
  push: function () {},
  pushBuffer: {},
  rejoinTimer: {
    callback: function () {},
    reset: function () {},
    scheduleTimeout: function () {},
    timerCalc: function() {},
    timer: {},
    tries: {}
  },
  socket: {},
  state: {},
  timeout: {},
  topic: {}
};

Phoenix.Socket.prototype = function () {};
Phoenix.Socket.prototype = {
  channel: function () {},
  channels: {},
  connect: function () {},
  connectionState: function () {},
  decode: function () {},
  defaultDecoder: function () {},
  defaultEncoder: function () {},
  disconnect: function () {},
  encode: function () {},
  endPoint: {},
  endPointURL: function () {},
  flushSendBuffer: function () {},
  heartbeatIntervalMs: {},
  heartbeatTimer: {},
  isConnected: function () {},
  log: function () {},
  logger: function () {},
  longpollerTimeout: {},
  makeRef: function () {},
  onClose: function () {},
  onConnClose: function () {},
  onConnError: function () {},
  onConnMessage: function () {},
  onConnOpen: function () {},
  onError: function () {},
  onMessage: function () {},
  onOpen: function () {},
  params: {},
  pendingHeartbeatRef: {},
  protocol: function () {},
  push: function () {},
  reconnectAfterMs: function () {},
  reconnectTimer: {
    callback: function () {},
    reset: function () {},
    scheduleTimeout: function () {},
    timerCalc: function() {},
    timer: {},
    tries: {}
  }, 
  ref: {},
  remove: function () {},
  sendBuffer: {},
  sendHeartbeat: function () {},
  stateChangeCallbacks: {
    close: {},
    error: {},
    message: {},
    open: {}
  },
  timeout: {},
  transport: {},
  triggerChanError: function () {}
};

Phoenix.LongPoll.prototype = function () {};
Phoenix.LongPoll.prototype = {
  close: function () {},
  closeAndRetry: function () {},
  endPoint: {},
  endpointURL: function () {},
  normalizeEndpoint: function () {},
  onclose: function () {},
  onerror: function () {},
  onmessage: function () {},
  onopen: function () {},
  ontimeout: function () {},
  poll: function () {},
  pollEndpoint: {},
  readyState: {},
  send: function () {},
  skipHeartbeat: {},
  token: {}
};

Phoenix.Ajax = {
  states: {
    complete: {}
  }
};

Phoenix.Ajax.prototype = function () {};
Phoenix.Ajax.prototype = {
  appendParams: function () {},
  parseJSON: function () {},
  request: function () {},
  serialize: function () {},
  xdomainRequest: function () {},
  xhrRequest: function () {}
};

Phoenix.Presence = {
  clone: function () {},
  list: function () {},
  map: function () {},
  syncDiff: function () {},
  syncState: function () {}
};
