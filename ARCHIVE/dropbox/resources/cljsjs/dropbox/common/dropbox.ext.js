var Dropbox = {};

Dropbox.Client = function () {};

Dropbox.Client.prototype.authDriver = function () {};
Dropbox.Client.prototype.dropboxUid = function () {};
Dropbox.Client.prototype.credentials = function () {};
Dropbox.Client.prototype.authenticate = function () {};
Dropbox.Client.prototype.isAuthenticated = function () {};
Dropbox.Client.prototype.signOut = function () {};
Dropbox.Client.prototype.signOff = function () {};
Dropbox.Client.prototype.getAccountInfo = function () {};
Dropbox.Client.prototype.getUserInfo = function () {};
Dropbox.Client.prototype.readFile = function () {};
Dropbox.Client.prototype.writeFile = function () {};
Dropbox.Client.prototype.resumableUploadStep = function () {};
Dropbox.Client.prototype.resumableUploadFinish = function () {};
Dropbox.Client.prototype.stat = function () {};
Dropbox.Client.prototype.readdir = function () {};
Dropbox.Client.prototype.metadata = function () {};
Dropbox.Client.prototype.makeUrl = function () {};
Dropbox.Client.prototype.history = function () {};
Dropbox.Client.prototype.revisions = function () {};
Dropbox.Client.prototype.thumbnailUrl = function () {};
Dropbox.Client.prototype.readThumbnail = function () {};
Dropbox.Client.prototype.revertFile = function () {};
Dropbox.Client.prototype.restore = function () {};
Dropbox.Client.prototype.findByName = function () {};
Dropbox.Client.prototype.search = function () {};
Dropbox.Client.prototype.makeCopyReference = function () {};
Dropbox.Client.prototype.copyRef = function () {};
Dropbox.Client.prototype.pullChanges = function () {};
Dropbox.Client.prototype.delta = function () {};
Dropbox.Client.prototype.pollForChanges = function () {};
Dropbox.Client.prototype.mkdir = function () {};
Dropbox.Client.prototype.remove = function () {};
Dropbox.Client.prototype.unlink = function () {};
Dropbox.Client.prototype.delete = function () {};
Dropbox.Client.prototype.copy = function () {};
Dropbox.Client.prototype.move = function () {};
Dropbox.Client.prototype.appInfo = function () {};
Dropbox.Client.prototype.isAppDeveloper = function () {};
Dropbox.Client.prototype.hasOauthRedirectUri = function () {};
Dropbox.Client.prototype.reset = function () {};
Dropbox.Client.prototype.setCredentials = function () {};
Dropbox.Client.prototype.appHash = function () {};
Dropbox.Client.prototype.onXhr = {};
Dropbox.Client.prototype.onError = {};
Dropbox.Client.prototype.onAuthStepChange = {};
Dropbox.Client.prototype.authStep = {};
Dropbox.Client.prototype.ERROR;
Dropbox.Client.prototype.RESET;
Dropbox.Client.prototype.PARAM_SET;
Dropbox.Client.prototype.PARAM_LOADED;
Dropbox.Client.prototype.AUTHORIZED;
Dropbox.Client.prototype.DONE;
Dropbox.Client.prototype.SIGNED_OUT;

Dropbox.AuthDriver = function () {};

Dropbox.AuthDriver.prototype.authType = function () {};
Dropbox.AuthDriver.prototype.url = function () {};
Dropbox.AuthDriver.prototype.doAuthorize = function () {};
Dropbox.AuthDriver.prototype.getStateParam = function () {};
Dropbox.AuthDriver.prototype.resumeAuthorize = function () {};
Dropbox.AuthDriver.prototype.onAuthStepChange = function () {};

Dropbox.AccountInfo = function () {};

Dropbox.AccountInfo.parse = function () {};
Dropbox.AccountInfo.prototype.json = function () {};
Dropbox.AccountInfo.prototype.name = {};
Dropbox.AccountInfo.prototype.email = {};
Dropbox.AccountInfo.prototype.countryCode = {};
Dropbox.AccountInfo.prototype.uid = {};
Dropbox.AccountInfo.prototype.referralUrl = {};
Dropbox.AccountInfo.prototype.publicAppUrl = {};
Dropbox.AccountInfo.prototype.quota = {};
Dropbox.AccountInfo.prototype.usedQuota = {};
Dropbox.AccountInfo.prototype.privateBytes = {};
Dropbox.AccountInfo.prototype.sharedBytes = {};

Dropbox.ApiError = function () {};

Dropbox.ApiError.prototype.status;
Dropbox.ApiError.prototype.method;
Dropbox.ApiError.prototype.url;
Dropbox.ApiError.prototype.responseText;
Dropbox.ApiError.prototype.response;
Dropbox.ApiError.prototype.NETWORK_ERROR;
Dropbox.ApiError.prototype.NO_CONTENT;
Dropbox.ApiError.prototype.INVALID_PARAM;
Dropbox.ApiError.prototype.INVALID_TOKEN;
Dropbox.ApiError.prototype.OAUTH_ERROR;
Dropbox.ApiError.prototype.NOT_FOUND;
Dropbox.ApiError.prototype.INVALID_METHOD;
Dropbox.ApiError.prototype.NOT_ACCEPTABLE;
Dropbox.ApiError.prototype.CONFLICT;
Dropbox.ApiError.prototype.RATE_LIMITED;
Dropbox.ApiError.prototype.SERVER_ERROR;
Dropbox.ApiError.prototype.OVER_QUOTA;

Dropbox.AuthError = function () {};

Dropbox.AuthError.prototype.code;
Dropbox.AuthError.prototype.description;
Dropbox.AuthError.prototype.uri;
Dropbox.AuthError.prototype.ACCESS_DENIED;
Dropbox.AuthError.prototype.INVALID_REQUEST;
Dropbox.AuthError.prototype.UNAUTHORIZED_CLIENT;
Dropbox.AuthError.prototype.INVALID_GRANT;
Dropbox.AuthError.prototype.INVALID_SCOPE;
Dropbox.AuthError.prototype.UNSUPPORTED_GRANT_TYPE;
Dropbox.AuthError.prototype.UNSUPPORTED_RESPONSE_TYPE;
Dropbox.AuthError.prototype.SERVER_ERROR;
Dropbox.AuthError.prototype.TEMPORARILY_UNAVAILABLE;

Dropbox.File = {};

Dropbox.File.Stat = function () {};

Dropbox.File.Stat.parse = function () {};
Dropbox.File.Stat.prototype.toJSON = function () {};
Dropbox.File.Stat.prototype.json = function () {};
Dropbox.File.Stat.prototype.path;
Dropbox.File.Stat.prototype.name;
Dropbox.File.Stat.prototype.inAppFolder;
Dropbox.File.Stat.prototype.isFolder;
Dropbox.File.Stat.prototype.isFile;
Dropbox.File.Stat.prototype.isRemoved;
Dropbox.File.Stat.prototype.typeIcon;
Dropbox.File.Stat.prototype.versionTag;
Dropbox.File.Stat.prototype.contentHash;
Dropbox.File.Stat.prototype.mimeType;
Dropbox.File.Stat.prototype.size;
Dropbox.File.Stat.prototype.humanSize;
Dropbox.File.Stat.prototype.hasThumbnail;
Dropbox.File.Stat.prototype.modifiedAt;
Dropbox.File.Stat.prototype.clientModifiedAt;

Dropbox.File.CopyReference = function () {};

Dropbox.File.CopyReference.parse = function () {};
Dropbox.File.CopyReference.prototype.toJSON = function () {};
Dropbox.File.CopyReference.prototype.json = function () {};
Dropbox.File.CopyReference.prototype.tag;
Dropbox.File.CopyReference.prototype.expiresAt;

Dropbox.File.ShareUrl = function () {};

Dropbox.File.ShareUrl.parse = function () {};
Dropbox.File.ShareUrl.prototype.toJSON = function () {};
Dropbox.File.ShareUrl.prototype.json = function () {};
Dropbox.File.ShareUrl.prototype.url;
Dropbox.File.ShareUrl.prototype.expiresAt;
Dropbox.File.ShareUrl.prototype.isDirect;
Dropbox.File.ShareUrl.prototype.isPreview;

Dropbox.AuthDriver.BrowserBase = function () {};

Dropbox.AuthDriver.BrowserBase.prototype.localStorage = function () {};
Dropbox.AuthDriver.BrowserBase.prototype.currentLocation = function () {};
Dropbox.AuthDriver.BrowserBase.prototype.cleanupLocation = function () {};
Dropbox.AuthDriver.BrowserBase.prototype.constructor = function () {};
Dropbox.AuthDriver.BrowserBase.prototype.authType = function () {};
Dropbox.AuthDriver.BrowserBase.prototype.onAuthStepChange = function () {};

Dropbox.AuthDriver.ChromeApp = function () {};

Dropbox.AuthDriver.ChromeApp.prototype.doAuthorize = function () {};

Dropbox.AuthDriver.ChromeExtension = function () {};

Dropbox.AuthDriver.ChromeExtension.oauthReceiver = function () {};
Dropbox.AuthDriver.ChromeExtension.prototype.doAuthorize = function () {};

Dropbox.AuthDriver.Cordova = function () {};

Dropbox.AuthDriver.Cordova.prototype.url = function () {};
Dropbox.AuthDriver.Cordova.prototype.doAuthorize = function () {};

Dropbox.AuthDriver.NodeServer = function () {};

Dropbox.AuthDriver.NodeServer.prototype.authType = function () {};
Dropbox.AuthDriver.NodeServer.prototype.url = function () {};
Dropbox.AuthDriver.NodeServer.prototype.doAuthorize = function () {};
Dropbox.AuthDriver.NodeServer.prototype.openBrowser = function () {};
Dropbox.AuthDriver.NodeServer.prototype.createApp = function () {};
Dropbox.AuthDriver.NodeServer.prototype.closeServer = function () {};
Dropbox.AuthDriver.NodeServer.prototype.doRequest = function () {};
Dropbox.AuthDriver.NodeServer.prototype.closeBrowser = function () {};

Dropbox.AuthDriver.Popup = function () {};

Dropbox.AuthDriver.Popup.locationOrigin = function () {};
Dropbox.AuthDriver.Popup.prototype.oauthReceiver = function () {};
Dropbox.AuthDriver.Popup.prototype.url = function () {};
Dropbox.AuthDriver.Popup.prototype.doAuthorize = function () {};

Dropbox.AuthDriver.Redirect = function () {};

Dropbox.AuthDriver.Redirect.prototype.url = function () {};
Dropbox.AuthDriver.Redirect.prototype.doAuthorize = function () {};
Dropbox.AuthDriver.Redirect.prototype.resumeAuthorize = function () {};

Dropbox.Http = {};

Dropbox.Http.AppInfo = function () {};

Dropbox.Http.AppInfo.parse = function () {};
Dropbox.Http.AppInfo.prototype.icon = function () {};
Dropbox.Http.AppInfo.prototype.name;
Dropbox.Http.AppInfo.prototype.key;
Dropbox.Http.AppInfo.prototype.canUseDatastores;
Dropbox.Http.AppInfo.prototype.canUseFiles;
Dropbox.Http.AppInfo.prototype.hasAppFolder;
Dropbox.Http.AppInfo.prototype.canUseFullDropbox;
Dropbox.Http.AppInfo.prototype.ICON_SMALL;
Dropbox.Http.AppInfo.prototype.ICON_LARGE;

Dropbox.Http.PollResult = function () {};

Dropbox.Http.PollResult.parse = function () {};
Dropbox.Http.PollResult.prototype.hasChanges;
Dropbox.Http.PollResult.prototype.retryAfter;

Dropbox.Http.PulledChange = function () {};

Dropbox.Http.PulledChange.parse = function () {};
Dropbox.Http.PulledChange.prototype.path;
Dropbox.Http.PulledChange.prototype.wasRemoved;
Dropbox.Http.PulledChange.prototype.stat;

Dropbox.Http.PulledChanges = function () {};

Dropbox.Http.PulledChanges.parse = function () {};
Dropbox.Http.PulledChanges.prototype.cursor = function () {};
Dropbox.Http.PulledChanges.prototype.changes;
Dropbox.Http.PulledChanges.prototype.blankSlate;
Dropbox.Http.PulledChanges.prototype.cursorTag;
Dropbox.Http.PulledChanges.prototype.shouldPullAgain;
Dropbox.Http.PulledChanges.prototype.shouldBackOff;

Dropbox.Http.RangeInfo = function () {};

Dropbox.Http.RangeInfo.parse = function () {};
Dropbox.Http.RangeInfo.prototype.start;
Dropbox.Http.RangeInfo.prototype.size;
Dropbox.Http.RangeInfo.prototype.end;

Dropbox.Http.UploadCursor = function () {};

Dropbox.Http.UploadCursor.parse = function () {};
Dropbox.Http.UploadCursor.prototype.toJSON = function () {};
Dropbox.Http.UploadCursor.prototype.json = function () {};
Dropbox.Http.UploadCursor.prototype.tag;
Dropbox.Http.UploadCursor.prototype.offset;
Dropbox.Http.UploadCursor.prototype.expiresAt;

Dropbox.Util = {};

Dropbox.Util.EventSource = function () {};

Dropbox.Util.EventSource.prototype.addListener = function () {};
Dropbox.Util.EventSource.prototype.removeListener = function () {};
Dropbox.Util.EventSource.prototype.dispatch = function () {};

Dropbox.Util.Oauth = function () {};

Dropbox.Util.Oauth.prototype.queryParamsFromUrl = function () {};
Dropbox.Util.Oauth.prototype.randomAuthStateParam = function () {};
Dropbox.Util.Oauth.prototype.checkAuthStateParam = function () {};

Dropbox.Util.Xhr = function () {};

Dropbox.Util.Xhr.prototype.urlEncode = function () {};
Dropbox.Util.Xhr.prototype.urlEncodeValue = function () {};
Dropbox.Util.Xhr.prototype.urlDecode = function () {};
Dropbox.Util.Xhr.prototype.setParams = function () {};
Dropbox.Util.Xhr.prototype.setCallback = function () {};
Dropbox.Util.Xhr.prototype.signWithOauth = function () {};
Dropbox.Util.Xhr.prototype.addOauthParams = function () {};
Dropbox.Util.Xhr.prototype.addOauthHeader = function () {};
Dropbox.Util.Xhr.prototype.setBody = function () {};
Dropbox.Util.Xhr.prototype.setResponseType = function () {};
Dropbox.Util.Xhr.prototype.setHeader = function () {};
Dropbox.Util.Xhr.prototype.reportResponseHeaders = function () {};
Dropbox.Util.Xhr.prototype.setFileField = function () {};
Dropbox.Util.Xhr.prototype.prepare = function () {};
Dropbox.Util.Xhr.prototype.send = function () {};
Dropbox.Util.Xhr.prototype.onReadyStateChange = function () {};
Dropbox.Util.Xhr.prototype.onXdrLoad = function () {};
Dropbox.Util.Xhr.prototype.onXdrError = function () {};
Dropbox.Util.Xhr.prototype.xhr = {};
Dropbox.Util.Xhr.prototype.onError = function () {};
