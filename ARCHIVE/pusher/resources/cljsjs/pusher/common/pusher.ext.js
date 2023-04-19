var Pusher = {
  "instances": {},
  "isReady": {},
  "debug": function () {},
  "warn": function () {},
  "ready": function () {},
  "HTTP": {},
  "Timer": function () {},
  "PeriodicTimer": function () {},
  "Util": {
    "now": function () {},
    "defer": function () {},
    "extend": function () {},
    "stringify": function () {},
    "arrayIndexOf": function () {},
    "objectApply": function () {},
    "keys": function () {},
    "values": function () {},
    "apply": function () {},
    "map": function () {},
    "mapObject": function () {},
    "filter": function () {},
    "filterObject": function () {},
    "flatten": function () {},
    "any": function () {},
    "all": function () {},
    "method": function () {},
    "getWindow": function () {},
    "getDocument": function () {},
    "getLocalStorage": function () {},
    "getClientFeatures": function () {},
    "addWindowListener": function () {},
    "removeWindowListener": function () {},
    "isXHRSupported": function () {},
    "isXDRSupported": function () {}
  },
  "VERSION": {},
  "PROTOCOL": {},
  "host": {},
  "ws_port": {},
  "wss_port": {},
  "sockjs_host": {},
  "sockjs_http_port": {},
  "sockjs_https_port": {},
  "sockjs_path": {},
  "stats_host": {},
  "channel_auth_endpoint": {},
  "channel_auth_transport": {},
  "activity_timeout": {},
  "pong_timeout": {},
  "unavailable_timeout": {},
  "cdn_http": {},
  "cdn_https": {},
  "dependency_suffix": {},
  "getDefaultStrategy": function () {},
  "getGlobalConfig": function () {},
  "getClusterConfig": function () {},
  "Errors": {
    "BadEventName": function () {},
    "RequestTimedOut": function () {},
    "TransportPriorityTooLow": function () {},
    "TransportClosed": function () {},
    "UnsupportedTransport": function () {},
    "UnsupportedStrategy": function () {}
  },
  "EventsDispatcher": function () {},
  "ScriptReceiverFactory": function () {},
  "ScriptReceivers": {},
  "ScriptRequest": function () {},
  "DependencyLoader": function () {},
  "DependenciesReceivers": {},
  "Dependencies": {},
  "Base64": {
    "encode": function () {}
  },
  "JSONPRequest": function () {},
  "Timeline": {
    "ERROR": {},
    "INFO": {},
    "DEBUG": {}
  },
  "TimelineSender": function () {},
  "BestConnectedEverStrategy": function () {},
  "CachedStrategy": function () {},
  "DelayedStrategy": function () {},
  "FirstConnectedStrategy": function () {},
  "IfStrategy": function () {},
  "SequentialStrategy": function () {},
  "TransportStrategy": function () {},
  "URLSchemes": {
    "ws": {
      "getInitial": function () {}
    },
    "sockjs": {
      "getInitial": function () {},
      "getPath": function () {}
    },
    "http": {
      "getInitial": function () {}
    }
  },
  "TransportConnection": function () {},
  "Transport": function () {},
  "WSTransport": {},
  "SockJSTransport": {},
  "XHRStreamingTransport": {},
  "XDRStreamingTransport": {},
  "XHRPollingTransport": {},
  "XDRPollingTransport": {},
  "AssistantToTheTransportManager": function () {},
  "TransportManager": function () {},
  "StrategyBuilder": {
    "build": function () {}
  },
  "Protocol": {
    "decodeMessage": function () {},
    "encodeMessage": function () {},
    "processHandshake": function () {},
    "getCloseAction": function () {},
    "getCloseError": function () {}
  },
  "Connection": function () {},
  "Handshake": function () {},
  "ConnectionManager": function () {},
  "NetInfo": function () {},
  "Network": {},
  "Members": function () {},
  "Channel": {
    "Authorizer": function () {}
  },
  "PrivateChannel": function () {},
  "PresenceChannel": function () {},
  "Channels": function () {},
  "auth_callbacks": {},
  "authorizers": {
    "ajax": function () {},
    "jsonp": function () {}
  }
};
Pusher.prototype = {
  "channel": function () {},
  "allChannels": function () {},
  "connect": function () {},
  "disconnect": function () {},
  "bind": function () {},
  "bind_all": function () {},
  "subscribeAll": function () {},
  "subscribe": function () {},
  "unsubscribe": function () {},
  "send_event": function () {},
  "isEncrypted": function () {}
};
Pusher.EventsDispatcher.prototype = {
  "bind": function () {},
  "bind_all": function () {},
  "unbind": function () {},
  "unbind_all": function () {},
  "emit": function () {}
};
Pusher.ScriptReceiverFactory.prototype = {
  "create": function () {},
  "remove": function () {}
};
Pusher.ScriptRequest.prototype = {
  "send": function () {},
  "cleanup": function () {}
};
Pusher.DependencyLoader.prototype = {
  "load": function () {},
  "getRoot": function () {},
  "getPath": function () {}
};
Pusher.JSONPRequest.prototype = {
  "send": function () {},
  "cleanup": function () {}
};
Pusher.Timeline.prototype = {
  "log": function () {},
  "error": function () {},
  "info": function () {},
  "debug": function () {},
  "isEmpty": function () {},
  "send": function () {},
  "generateUniqueID": function () {}
};
Pusher.TimelineSender.prototype = {
  "send": function () {}
};
Pusher.BestConnectedEverStrategy.prototype = {
  "isSupported": function () {},
  "connect": function () {}
};
Pusher.CachedStrategy.prototype = {
  "isSupported": function () {},
  "connect": function () {}
};
Pusher.DelayedStrategy.prototype = {
  "isSupported": function () {},
  "connect": function () {}
};
Pusher.FirstConnectedStrategy.prototype = {
  "isSupported": function () {},
  "connect": function () {}
};
Pusher.IfStrategy.prototype = {
  "isSupported": function () {},
  "connect": function () {}
};
Pusher.SequentialStrategy.prototype = {
  "isSupported": function () {},
  "connect": function () {},
  "tryStrategy": function () {}
};
Pusher.TransportStrategy.prototype = {
  "isSupported": function () {},
  "connect": function () {}
};
Pusher.TransportConnection.prototype = {
  "bind": function () {},
  "bind_all": function () {},
  "unbind": function () {},
  "unbind_all": function () {},
  "emit": function () {},
  "handlesActivityChecks": function () {},
  "supportsPing": function () {},
  "initialize": function () {},
  "connect": function () {},
  "close": function () {},
  "send": function () {},
  "ping": function () {},
  "onOpen": function () {},
  "onError": function () {},
  "onClose": function () {},
  "onMessage": function () {},
  "onActivity": function () {},
  "bindListeners": function () {},
  "unbindListeners": function () {},
  "changeState": function () {},
  "buildTimelineMessage": function () {}
};
Pusher.Transport.prototype = {
  "isSupported": function () {},
  "createConnection": function () {}
};
Pusher.AssistantToTheTransportManager.prototype = {
  "createConnection": function () {},
  "isSupported": function () {}
};
Pusher.TransportManager.prototype = {
  "getAssistant": function () {},
  "isAlive": function () {},
  "reportDeath": function () {}
};
Pusher.Connection.prototype = {
  "bind": function () {},
  "bind_all": function () {},
  "unbind": function () {},
  "unbind_all": function () {},
  "emit": function () {},
  "handlesActivityChecks": function () {},
  "send": function () {},
  "send_event": function () {},
  "ping": function () {},
  "close": function () {},
  "bindListeners": function () {},
  "handleCloseEvent": function () {}
};
Pusher.Handshake.prototype = {
  "close": function () {},
  "bindListeners": function () {},
  "unbindListeners": function () {},
  "finish": function () {}
};
Pusher.ConnectionManager.prototype = {
  "bind": function () {},
  "bind_all": function () {},
  "unbind": function () {},
  "unbind_all": function () {},
  "emit": function () {},
  "connect": function () {},
  "send": function () {},
  "send_event": function () {},
  "disconnect": function () {},
  "isEncrypted": function () {},
  "startConnecting": function () {},
  "abortConnecting": function () {},
  "disconnectInternally": function () {},
  "updateStrategy": function () {},
  "retryIn": function () {},
  "clearRetryTimer": function () {},
  "setUnavailableTimer": function () {},
  "clearUnavailableTimer": function () {},
  "sendActivityCheck": function () {},
  "resetActivityCheck": function () {},
  "stopActivityCheck": function () {},
  "buildConnectionCallbacks": function () {},
  "buildHandshakeCallbacks": function () {},
  "buildErrorCallbacks": function () {},
  "setConnection": function () {},
  "abandonConnection": function () {},
  "updateState": function () {},
  "shouldRetry": function () {}
};
Pusher.NetInfo.prototype = {
  "bind": function () {},
  "bind_all": function () {},
  "unbind": function () {},
  "unbind_all": function () {},
  "emit": function () {},
  "isOnline": function () {}
};
Pusher.Members.prototype = {
  "get": function () {},
  "each": function () {},
  "setMyID": function () {},
  "onSubscription": function () {},
  "addMember": function () {},
  "removeMember": function () {},
  "reset": function () {}
};
Pusher.Channel.prototype = {
  "bind": function () {},
  "bind_all": function () {},
  "unbind": function () {},
  "unbind_all": function () {},
  "emit": function () {},
  "authorize": function () {},
  "trigger": function () {},
  "disconnect": function () {},
  "handleEvent": function () {},
  "subscribe": function () {},
  "unsubscribe": function () {}
};
Pusher.Channel.Authorizer.prototype = {
  "composeQuery": function () {},
  "authorize": function () {}
};
Pusher.PrivateChannel.prototype = {
  "bind": function () {},
  "bind_all": function () {},
  "unbind": function () {},
  "unbind_all": function () {},
  "emit": function () {},
  "authorize": function () {},
  "trigger": function () {},
  "disconnect": function () {},
  "handleEvent": function () {},
  "subscribe": function () {},
  "unsubscribe": function () {}
};
Pusher.PresenceChannel.prototype = {
  "bind": function () {},
  "bind_all": function () {},
  "unbind": function () {},
  "unbind_all": function () {},
  "emit": function () {},
  "authorize": function () {},
  "trigger": function () {},
  "disconnect": function () {},
  "handleEvent": function () {},
  "subscribe": function () {},
  "unsubscribe": function () {}
};
Pusher.Channels.prototype = {
  "add": function () {},
  "all": function () {},
  "find": function () {},
  "remove": function () {},
  "disconnect": function () {}
};
