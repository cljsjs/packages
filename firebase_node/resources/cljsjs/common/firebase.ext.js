/**
   Initial version by @steida:
   https://gist.github.com/steida/375fb2cafc060fba12b7
   Updated with new functions from v2.1.2
*/

/**
   @param {string} firebaseURL
   @constructor
*/
var Firebase = function(firebaseURL) {};

Firebase.ServerValue = {
  TIMESTAMP: null
};


/**
   @param {string} authToken
   @param {Function=} onComplete
   @param {Function=} onCancel
*/

Firebase.prototype.auth = function(authToken, onComplete, onCancel) {};

/**
   @param {string} authToken
   @param {Function} onComplete
   @param {Object=} options
*/
Firebase.prototype.authWithCustomToken = function(authToken, onComplete, options) {};

/**
   @param {Function} onComplete
   @param {Object=} options
*/
Firebase.prototype.authAnonymously = function(onComplete, options) {};

/**
   @param {Object} credentials
   @param {Function} onComplete
   @param {Object=} options
*/
Firebase.prototype.authWithPassword = function(credentials, onComplete, options) {};

/**
   @param {String} provider
   @param {Function} onComplete
   @param {Object=} options
*/
Firebase.prototype.authWithOAuthPopup = function(provider, onComplete, options) {};

/**
   @param {String} provider
   @param {Function} onComplete
   @param {Object=} options
*/
Firebase.prototype.authWithOAuthRedirect = function(provider, onComplete, options) {};

/**
   @param {String} provider
   @param {String|Object} credentials
   @param {Function} onComplete
   @param {Object=} options
*/
Firebase.prototype.authWithOAuthToken = function(provider, credentials, onComplete, options) {};

/**
   @return {Object|null}
*/
Firebase.prototype.getAuth = function() {};

/**
   @param {Function} onComplete
   @param {Object=} context
*/
Firebase.prototype.onAuth = function(onComplete, context) {};

/**
   @param {Function} onComplete
   @param {Object=} context
*/
Firebase.prototype.offAuth = function(onComplete, context) {};

Firebase.prototype.unauth = function() {};

/**
   @param {string} childPath
   @return {Firebase}
*/
Firebase.prototype.child = function(childPath) {};

/**
   @return {Firebase}
*/
Firebase.prototype.parent = function() {};

/**
   @return {Firebase}
*/
Firebase.prototype.root = function() {};

/**
   @return {String}
*/
Firebase.prototype.key = function() {};

/**
   @return {string}
*/
Firebase.prototype.name = function() {};

/**
   @return {string}
*/
Firebase.prototype.toString = function() {};

/**
   @param {(Object|string|number|boolean)} value
   @param {Function=} onComplete
*/
Firebase.prototype.set = function(value, onComplete) {};

/**
   @param {Object} value
   @param {Function=} onComplete
*/
Firebase.prototype.update = function(value, onComplete) {};

/**
   @param {Function=} onComplete
*/
Firebase.prototype.remove = function(onComplete) {};

/**
   @param {(Object|string|number|boolean)=} value
   @param {Function=} onComplete
   @return {Firebase}
*/
Firebase.prototype.push = function(value, onComplete) {};

/**
   @param {(Object|string|number|boolean)} value
   @param {(string|number|Object)} priority
   @param {Function=} onComplete
*/
Firebase.prototype.setWithPriority = function(value, priority, onComplete) {};

/**
   @param {(string|number|Object)} priority
   @param {Function=} onComplete
*/
Firebase.prototype.setPriority = function(priority, onComplete) {};

/**
   @param {Function} updateFunction
   @param {Function=} onComplete
   @param {Function=} applyLocally
*/
Firebase.prototype.transaction = function(updateFunction, onComplete, applyLocally) {};

/**
   @param {Object} credentials
   @param {Function} onComplete
*/
Firebase.prototype.createUser = function(credentials, onComplete) {};

/**
   @param {Object} credentials
   @param {Function} onComplete
*/
Firebase.prototype.changeEmail = function(credentials, onComplete) {};

/**
   @param {Object} credentials
   @param {Function} onComplete
*/
Firebase.prototype.changePassword = function(credentials, onComplete) {};

/**
   @param {Object} credentials
   @param {Function} onComplete
*/
Firebase.prototype.removeUser = function(credentials, onComplete) {};

/**
   @param {Object} credentials
   @param {Function} onComplete
*/
Firebase.prototype.resetPassword = function(credentials, onComplete) {};

Firebase.prototype.goOffline = function() {};

Firebase.prototype.goOnline = function() {};


/**
   @param {string} eventType
   @param {function(FirebaseDataSnapshot)} callback
   @param {Function=} cancelCallback
   @param {Object=} context
   @return {Function}
*/
Firebase.prototype.on = function(eventType, callback, cancelCallback, context) {};

/**
   @param {string=} eventType
   @param {Function=} callback
   @param {Object=} context
   @return {Function}
*/
Firebase.prototype.off = function(eventType, callback, context) {};

/**
   @param {string} eventType
   @param {function(FirebaseDataSnapshot)} successCallback
   @param {Function=} failureCallback
   @param {Object=} context
   @return {Function}
*/
Firebase.prototype.once = function(eventType, successCallback, failureCallback, context) {};

/**
   @param {string} key
   @return {Firebase} Actually it returns Query
*/
Firebase.prototype.orderByChild = function(key) {};

/**
   @return {Firebase} Actually it returns Query
*/
Firebase.prototype.orderByKey = function() {};

/**
   @return {Firebase} Actually it returns Query
*/
Firebase.prototype.orderByPriority = function() {};

/**
   @return {Firebase} Actually it returns Query
*/
Firebase.prototype.orderByValue = function() {};

/**
   @param {string|number|null} value
   @param {string=} key
   @return {Firebase} Actually it returns Query
*/
Firebase.prototype.startAt = function(value, key) {};

/**
   @param {string|number|null} value
   @param {string=} key
   @return {Firebase} Actually it returns Query
*/
Firebase.prototype.endAt = function(value, key) {};

/**
   @param {string|number|null} value
   @param {string=} key
   @return {Firebase} Actually it returns Query
*/
Firebase.prototype.equalTo = function(value, key) {};

/**
   @param {number} limit
   @return {Firebase} Actually it returns Query
*/
Firebase.prototype.limitToFirst = function(limit) {};

/**
   @param {number} limit
   @return {Firebase} Actually it returns Query
*/
Firebase.prototype.limitToLast = function(limit) {};

/**
   @param {number} limit
   @return {Firebase} Actually it returns Query
*/
Firebase.prototype.limit = function(limit) {};

/**
   Get a Firebase reference to the Query's location.
   @return {Firebase}
*/
Firebase.prototype.ref = function() {};


/**
   Get a Firebase reference to the Query's location.
   @return {Firebase}
*/
Firebase.prototype.onDisconnect = function() {};


/**
   @param {Firebase} ref
   @param {Function} callback
   @param {Object=} context
   @constructor
*/
var FirebaseSimpleLogin = function(ref, callback, context) {};

/**
   @param {string} provider
   @param {Object=} options
*/

FirebaseSimpleLogin.prototype.login = function(provider, options) {};

FirebaseSimpleLogin.prototype.logout = function() {};

/**
   @param {string} email
   @param {string} password
   @param {Function=} callback
*/

FirebaseSimpleLogin.prototype.createUser = function(email, password, callback) {};

/**
   @param {string} email
   @param {string} oldPassword
   @param {string} newPassword
   @param {Function} callback
*/

FirebaseSimpleLogin.prototype.changePassword = function(email, oldPassword, newPassword, callback) {};

/**
   @param {string} email
   @param {Function} callback
*/

FirebaseSimpleLogin.prototype.sendPasswordResetEmail = function(email, callback) {};

/**
   @param {string} email
   @param {string} password
   @param {Function} callback
*/

FirebaseSimpleLogin.prototype.removeUser = function(email, password, callback) {};

/**
   @constructor
*/
var FirebaseDataSnapshot = function() {};

/**
   @return {Boolean}
*/
FirebaseDataSnapshot.prototype.exists = function() {};

/**
   @return {(Object|String|Number|Boolean|Null)}
*/
FirebaseDataSnapshot.prototype.val = function() {};

/**
   @param {string} childPath
   @return {FirebaseDataSnapshot}
*/
FirebaseDataSnapshot.prototype.child = function(childPath) {};

/**
   @param {function(FirebaseDataSnapshot): boolean} childAction
   @return {boolean}
*/
FirebaseDataSnapshot.prototype.forEach = function(childAction) {};

/**
   @param {string} childPath
   @return {boolean}
*/
FirebaseDataSnapshot.prototype.hasChild = function(childPath) {};

/**
   @return {boolean}
*/
FirebaseDataSnapshot.prototype.hasChildren = function() {};

/**
   @return {string}
*/
FirebaseDataSnapshot.prototype.key = function() {};

/**
   @return {string}
*/
FirebaseDataSnapshot.prototype.name = function() {};

/**
   @return {number}
*/
FirebaseDataSnapshot.prototype.numChildren = function() {};

/**
   @return {Firebase}
*/
FirebaseDataSnapshot.prototype.ref = function() {};

/**
   @return {(string|number|null)}
*/
FirebaseDataSnapshot.prototype.getPriority = function() {};

/**
   @return {Object}
*/
FirebaseDataSnapshot.prototype.exportVal = function() {};
