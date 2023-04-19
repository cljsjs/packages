
var skygear = {
  /**
   * @constructor
   */
  ACL: {
    fromJSON: function() {},
    prototype: {
      public: {},
      roles: {},
      users: {},
      hasPublicReadAccess: function() {},
      hasPublicWriteAccess: function() {},
      hasReadAccess: function() {},
      hasReadAccessForRole: function() {},
      hasReadAccessForUser: function() {},
      hasWriteAccess: function() {},
      hasWriteAccessForRole: function() {},
      hasWriteAccessForUser: function() {},
      setNoAccessForRole: function() {},
      setNoAccessForUser: function() {},
      setPublicNoAccess: function() {},
      setPublicReadOnly: function() {},
      setPublicReadWriteAccess: function() {},
      setReadOnlyForRole: function() {},
      setReadOnlyForUser: function() {},
      setReadWriteAccessForRole: function() {},
      setReadWriteAccessForUser: function() {},
      toJSON: function() {},
    },
  },
  /**
   * @constructor
   */
  Asset: {
    fromJSON: function() {},
    prototype: {
      contentType: {},
      file: {},
      name: {},
      url: {},
      toJSON: function() {},
    },
  },
  /**
   * @constructor
   */
  Database: {
    prototype: {
      cacheResponse: {},
      cacheStore: {},
      container: {},
      dbID: {},
      del: function() {},
      delete: function() {},
      getRecordByID: function() {},
      query: function() {},
      save: function() {},
    },
  },
  /**
   * @constructor
   */
  Geolocation: {
    fromJSON: function() {},
    prototype: {
      latitude: {},
      longitude: {},
      toJSON: function() {},
    },
  },
  /**
   * @constructor
   */
  Query: {
    clone: function() {},
    fromJSON: function() {},
    not: function() {},
    or: function() {},
    prototype: {
      hash: {},
      limit: {},
      offset: {},
      overallCount: {},
      page: {},
      predicate: {},
      recordCls: {},
      recordType: {},
      addAscending: function() {},
      addAscendingByDistance: function() {},
      addDescending: function() {},
      addDescendingByDistance: function() {},
      caseInsensitiveLike: function() {},
      caseInsensitiveNotLike: function() {},
      contains: function() {},
      containsValue: function() {},
      distanceGreaterThan: function() {},
      distanceLessThan: function() {},
      equalTo: function() {},
      greaterThan: function() {},
      greaterThanOrEqualTo: function() {},
      havingEmails: function() {},
      havingRelation: function() {},
      havingUsernames: function() {},
      lessThan: function() {},
      lessThanOrEqualTo: function() {},
      like: function() {},
      notContains: function() {},
      notContainsValue: function() {},
      notEqualTo: function() {},
      notHavingRelation: function() {},
      notLike: function() {},
      toJSON: function() {},
      transientInclude: function() {},
      transientIncludeDistance: function() {},
    },
  },
  /**
   * @constructor
   */
  Record: {
    defaultACL: {},
    extend: function() {},
    parseID: function() {},
    validType: function() {},
    prototype: {
      $transient: {},
      access: {},
      attributeKeys: {},
      id: {},
      recordType: {},
      hasPublicReadAccess: function() {},
      hasPublicWriteAccess: function() {},
      hasReadAccess: function() {},
      hasReadAccessForRole: function() {},
      hasReadAccessForUser: function() {},
      hasWriteAccess: function() {},
      hasWriteAccessForRole: function() {},
      hasWriteAccessForUser: function() {},
      setAccess: function() {},
      setNoAccessForRole: function() {},
      setNoAccessForUser: function() {},
      setPublicNoAccess: function() {},
      setPublicReadOnly: function() {},
      setPublicReadWriteAccess: function() {},
      setReadOnlyForRole: function() {},
      setReadOnlyForUser: function() {},
      setReadWriteAccessForRole: function() {},
      setReadWriteAccessForUser: function() {},
      toJSON: function() {},
      update: function() {},
      updateTransient: function() {},
    },
  },
  /**
   * @constructor
   */
  Reference: {
    prototype: {
      id: {},
      toJSON: function() {},
    },
  },
  /**
   * @constructor
   */
  Role: {
    contain: function() {},
    define: function() {},
    isValidName: function() {},
    subtract: function() {},
    union: function() {},
    prototype: {
      name: {},
    },
  },
  /**
   * @constructor
   */
  Sequence: {
    prototype: {
      toJSON: function() {},
    },
  },
  /**
   * @constructor
   */
  User: {
    fromJSON: function() {},
    prototype: {
      email: {},
      id: {},
      lastLoginAt: {},
      lastSeenAt: {},
      roles: {},
      username: {},
      addRole: function() {},
      hasRole: function() {},
      removeRole: function() {},
      toJSON: function() {},
    },
  },
  /**
   * @constructor
   * @extends skygear.Record
   */
  UserRecord: function() {},
  // ------------------------------
  accessToken: {},
  apiKey: {},
  autoPubsub: {},
  cacheResponse: {},
  currentUser: {},
  defaultACL: {},
  deviceID: {},
  ee: {},
  endPoint: {},
  privateDB: {},
  publicDB: {},
  pubsub: {},
  relation: {},
  request: {},
  timeoutOptions: {},
  token: {},
  url: {},
  changePassword: function() {},
  clearCache: function() {},
  config: function() {},
  configApiKey: function() {},
  discoverUserByEmails: function() {},
  discoverUserByUsernames: function() {},
  getUsersByEmail: function() {},
  getUsersByUsername: function() {},
  lambda: function() {},
  loginWithEmail: function() {},
  loginWithProvider: function() {},
  loginWithUsername: function() {},
  logout: function() {},
  makeRequest: function() {},
  makeUploadAssetRequest: function() {},
  off: function() {},
  on: function() {},
  onUserChanged: function() {},
  reconfigurePubsubIfNeeded: function() {},
  registerDevice: function() {},
  saveUser: function() {},
  sendRequestObject: function() {},
  setAdminRole: function() {},
  setDefaultACL: function() {},
  setDefaultRole: function() {},
  setRecordCreateAccess: function() {},
  signupAnonymously: function() {},
  signupWithEmail: function() {},
  signupWithUsername: function() {},
  unregisterDevice: function() {},
  whoami: function() {},
};
