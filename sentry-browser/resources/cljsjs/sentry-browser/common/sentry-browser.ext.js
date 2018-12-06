var Sentry = {
  "API_VERSION": {},
  "SDK_NAME": {},
  "SDK_VERSION": {},
  "Integrations": {},
  "defaultIntegrations": {},

  "isError": function () {},
  "isErrorEvent": function () {},
  "isDOMError": function () {},
  "isDOMException": function () {},
  "isUndefined": function () {},
  "isFunction": function () {},
  "isString": function () {},
  "isArray": function () {},
  "isPlainObject": function () {},
  "isRegExp": function () {},
  "isNaN": function () {},
  "dynamicRequire": function () {},
  "isNodeEnv": function () {},
  "getGlobalObject": function () {},
  "uuid4": function () {},
  "htmlTreeAsString": function () {},
  "htmlElementAsString": function () {},
  "parseUrl": function () {},
  "getEventDescription": function () {},
  "consoleSandbox": function () {},
  "serialize": function () {},
  "deserialize": function () {},
  "clone": function () {},
  "fill": function () {},
  "urlEncode": function () {},
  "serializeObject": function () {},
  "limitObjectDepthToSize": function () {},
  "serializeKeysToEventMessage": function () {},
  "assign": function () {},
  "addGlobalEventProcessor": function () {},
  "getMainCarrier": function () {},
  "makeMain": function () {},
  "getCurrentHub": function () {},
  "hasHubOnCarrier": function () {},
  "getHubFromCarrier": function () {},
  "setHubOnCarrier": function () {},
  "captureException": function () {},
  "captureMessage": function () {},
  "captureEvent": function () {},
  "addBreadcrumb": function () {},
  "configureScope": function () {},
  "withScope": function () {},
  "_callOnClient": function () {},
  "forget": function () {},
  "filterAsync": function () {},
  "snipLine": function () {},
  "safeJoin": function () {},
  "includes": function () {},
  "installedIntegrations": {},
  "getIntegrationsToSetup": function () {},
  "setupIntegration": function () {},
  "setupIntegrations": function () {},
  "initAndBind": function () {},
  "FunctionToString": function () {},
  "resolve": function () {},
  "relative": function () {},
  "normalize": function () {},
  "isAbsolute": function () {},
  "join": function () {},
  "dirname": function () {},
  "basename": function () {},
  "supportsErrorEvent": function () {},
  "supportsDOMError": function () {},
  "supportsDOMException": function () {},
  "supportsFetch": function () {},
  "supportsNativeFetch": function () {},
  "supportsBeacon": function () {},
  "supportsReportingObserver": function () {},
  "supportsReferrerPolicy": function () {},
  "supportsHistory": function () {},
  "forceLoad": function () {},
  "init": function () {},
  "lastEventId": function () {},
  "onLoad": function () {},
  "showReportDialog": function () {},
  
  "Scope": function () {},
  "Logger": function () {},
  "Hub": function () {},
  "SentryError": function () {},
  "Dsn": function () {},
  "API": function () {},
  "BaseClient": function () {},
  "RequestBuffer": function () {},
  "BaseBackend": function () {},
  "Dedupe": function () {},
  "SDKInformation": function () {},
  "InboundFilters": function () {},
  "Debug": function () {},
  "RewriteFrames": function () {},
  "BaseTransport": function () {},
  "FetchTransport": function () {},
  "XHRTransport": function () {},
  "BeaconTransport": function () {},
  "BrowserBackend": function () {},
  "BrowserClient": function () {},
  "GlobalHandlers": function () {},
  "TryCatch": function () {},
  "Breadcrumbs": function () {},
  "LinkedErrors": function () {},
  "UserAgent": function () {},
  "Ember": function () {},
  "Vue": function () {},
  "ReportingObserver": function () {},
  "Severity": function () {},
  "Status": function () {},
  "Transports": function () {}
};

Sentry.Scope.prototype = {
  "addScopeListener": function () {},
  "addEventProcessor": function () {},
  "notifyScopeListeners": function () {},
  "notifyEventProcessors": function () {},
  "setUser": function () {},
  "setTag": function () {},
  "setExtra": function () {},
  "setFingerprint": function () {},
  "setLevel": function () {},
  "clone": function () {},
  "clear": function () {},
  "addBreadcrumb": function () {},
  "applyToEvent": function () {}
};

Sentry.Logger.prototype = {
  "disable": function () {},
  "enable": function () {},
  "log": function () {},
  "warn": function () {},
  "error": function () {}
};

Sentry.Hub.prototype = {
  "invokeClient": function () {},
  "invokeClientAsync": function () {},
  "isOlderThan": function () {},
  "bindClient": function () {},
  "pushScope": function () {},
  "popScope": function () {},
  "withScope": function () {},
  "getClient": function () {},
  "getScope": function () {},
  "getStack": function () {},
  "getStackTop": function () {},
  "captureException": function () {},
  "captureMessage": function () {},
  "captureEvent": function () {},
  "lastEventId": function () {},
  "addBreadcrumb": function () {},
  "configureScope": function () {},
  "run": function () {},
  "getIntegration": function () {}
};

Sentry.SentryError.prototype = {
};

Sentry.Dsn.prototype = {
  "toString": function () {},
  "fromString": function () {},
  "fromComponents": function () {},
  "validate": function () {}
};

Sentry.API.prototype = {
  "getDsn": function () {},
  "getStoreEndpoint": function () {},
  "getStoreEndpointWithUrlEncodedAuth": function () {},
  "getBaseUrl": function () {},
  "getStoreEndpointPath": function () {},
  "getRequestHeaders": function () {},
  "getReportDialogEndpoint": function () {},
  "truncate": function () {}
};

Sentry.BaseClient.prototype = {
  "install": function () {},
  "buffer": function () {},
  "captureException": function () {},
  "captureMessage": function () {},
  "captureEvent": function () {},
  "addBreadcrumb": function () {},
  "getDsn": function () {},
  "getOptions": function () {},
  "getBackend": function () {},
  "isEnabled": function () {},
  "prepareEvent": function () {},
  "processEvent": function () {},
  "close": function () {},
  "getIntegration": function () {}
};

Sentry.RequestBuffer.prototype = {
  "add": function () {},
  "remove": function () {},
  "length": function () {},
  "drain": function () {}
};

Sentry.BaseBackend.prototype = {
  "eventFromException": function () {},
  "eventFromMessage": function () {},
  "sendEvent": function () {},
  "storeBreadcrumb": function () {},
  "storeScope": function () {},
  "getBuffer": function () {}
};

Sentry.Dedupe.prototype = {
  "setupOnce": function () {},
  "shouldDropEvent": function () {},
  "isSameMessageEvent": function () {},
  "getFramesFromEvent": function () {},
  "isSameStacktrace": function () {},
  "getExceptionFromEvent": function () {},
  "isSameExceptionEvent": function () {},
  "isSameFingerprint": function () {}
};

Sentry.SDKInformation.prototype = {
  "setupOnce": function () {}
};

Sentry.InboundFilters.prototype = {
  "setupOnce": function () {},
  "shouldDropEvent": function () {},
  "isIgnoredError": function () {},
  "isBlacklistedUrl": function () {},
  "isWhitelistedUrl": function () {},
  "mergeOptions": function () {},
  "isMatchingPattern": function () {},
  "getPossibleEventMessages": function () {},
  "getEventFilterUrl": function () {}
};

Sentry.Debug.prototype = {
  "setupOnce": function () {}
};

Sentry.RewriteFrames.prototype = {
  "setupOnce": function () {},
  "process": function () {},
  "getFramesFromEvent": function () {}
};

Sentry.BaseTransport.prototype = {
  "captureEvent": function () {}
};

Sentry.FetchTransport.prototype = {
  "captureEvent": function () {}
};

Sentry.XHRTransport.prototype = {
  "captureEvent": function () {}
};

Sentry.BeaconTransport.prototype = {
  "captureEvent": function () {}
};

Sentry.BrowserBackend.prototype = {
  "install": function () {},
  "eventFromException": function () {},
  "eventFromMessage": function () {},
  "sendEvent": function () {}
};

Sentry.BrowserClient.prototype = {
  "prepareEvent": function () {},
  "showReportDialog": function () {}
};

Sentry.GlobalHandlers.prototype = {
  "setupOnce": function () {},
  "eventFromGlobalHandler": function () {}
};

Sentry.TryCatch.prototype = {
  "wrapTimeFunction": function () {},
  "wrapRAF": function () {},
  "wrapEventTarget": function () {},
  "setupOnce": function () {}
};

Sentry.Breadcrumbs.prototype = {
  "instrumentBeacon": function () {},
  "instrumentConsole": function () {},
  "instrumentDOM": function () {},
  "instrumentFetch": function () {},
  "instrumentHistory": function () {},
  "instrumentXHR": function () {},
  "addBreadcrumb": function () {},
  "setupOnce": function () {}
};

Sentry.LinkedErrors.prototype = {
  "setupOnce": function () {},
  "handler": function () {},
  "walkErrorTree": function () {}
};

Sentry.UserAgent.prototype = {
  "setupOnce": function () {}
};

Sentry.Ember.prototype = {
  "setupOnce": function () {},
  "addIntegrationToSdkInfo": function () {}
};

Sentry.Vue.prototype = {
  "formatComponentName": function () {},
  "setupOnce": function () {}
};

Sentry.ReportingObserver.prototype = {
  "setupOnce": function () {},
  "handler": function () {}
};

Sentry.Severity.prototype = {
  "Fatal": {},
  "Error": {},
  "Warning": {},
  "Log": {},
  "Info": {},
  "Debug": {},
  "Critical": {},
  "fromString": function () {}
};

Sentry.Status.prototype = {
  "Unknown": {},
  "Skipped": {},
  "Success": {},
  "RateLimit": {},
  "Invalid": {},
  "Failed": {},
  "fromHttpCode": function () {}
};

Sentry.Transports.prototype = {
  "BaseTransport": {},
  "FetchTransport": {},
  "XHRTransport": {},
  "BeaconTransport": {}
};

