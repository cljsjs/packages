var Sentry = {
    "Severity": {
        "Fatal": {},
        "Error": {},
        "Warning": {},
        "Log": {},
        "Info": {},
        "Debug": {},
        "Critical": {},
        "fromString": function () {}
    },
    "Status": {
        "Unknown": {},
        "Skipped": {},
        "Success": {},
        "RateLimit": {},
        "Invalid": {},
        "Failed": {},
        "fromHttpCode": function () {}
    },
    "BrowserClient": function () {},
    "Hub": function () {},
    "Integrations": {
        "FunctionToString": function () {},
        "InboundFilters": function () {},
        "GlobalHandlers": function () {},
        "TryCatch": function () {},
        "Breadcrumbs": function () {},
        "LinkedErrors": function () {},
        "UserAgent": function () {}
    },
    "SDK_NAME": {},
    "SDK_VERSION": {},
    "Scope": function () {},
    "Span": function () {},
    "Transports": {
        "BaseTransport": function () {},
        "FetchTransport": function () {},
        "XHRTransport": function () {}
    },
    "addBreadcrumb": function () {},
    "addGlobalEventProcessor": function () {},
    "captureEvent": function () {},
    "captureException": function () {},
    "captureMessage": function () {},
    "close": function () {},
    "configureScope": function () {},
    "defaultIntegrations": {
        "0": {
            "_options": function () {},
            "name": {},
            "setupOnce": function () {},
            "_shouldDropEvent": function () {},
            "_isSentryError": function () {},
            "_isIgnoredError": function () {},
            "_isBlacklistedUrl": function () {},
            "_isWhitelistedUrl": function () {},
            "_mergeOptions": function () {},
            "_getPossibleEventMessages": function () {},
            "_getEventFilterUrl": function () {}
        },
        "1": {
            "name": {},
            "setupOnce": function () {}
        },
        "2": {
            "_ignoreOnError": {},
            "name": {},
            "_wrapTimeFunction": function () {},
            "_wrapRAF": function () {},
            "_wrapEventTarget": function () {},
            "setupOnce": function () {}
        },
        "3": {
            "name": {},
            "_options": {
                "console": {},
                "dom": {},
                "fetch": {},
                "history": {},
                "sentry": {},
                "xhr": {}
            },
            "_instrumentConsole": function () {},
            "_instrumentDOM": function () {},
            "_instrumentFetch": function () {},
            "_instrumentHistory": function () {},
            "_instrumentXHR": function () {},
            "setupOnce": function () {}
        },
        "4": {
            "name": {},
            "_options": {
                "onerror": {},
                "onunhandledrejection": {}
            },
            "setupOnce": function () {},
            "_eventFromGlobalHandler": function () {}
        },
        "5": {
            "name": {},
            "_key": {},
            "_limit": {},
            "setupOnce": function () {},
            "_handler": function () {},
            "_walkErrorTree": function () {}
        },
        "6": {
            "name": {},
            "setupOnce": function () {}
        }
    },
    "flush": function () {},
    "forceLoad": function () {},
    "getCurrentHub": function () {},
    "getHubFromCarrier": function () {},
    "init": function () {},
    "lastEventId": function () {},
    "onLoad": function () {},
    "setContext": function () {},
    "setExtra": function () {},
    "setExtras": function () {},
    "setTag": function () {},
    "setTags": function () {},
    "setUser": function () {},
    "showReportDialog": function () {},
    "withScope": function () {},
    "wrap": function () {}
}