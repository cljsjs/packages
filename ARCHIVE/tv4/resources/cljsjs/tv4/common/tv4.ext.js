var tv4 = {};

tv4.setErrorReporter = function() {};
tv4.addFormat = function() {};
tv4.language = function() {};
tv4.addLanguage = function() {};
tv4.freshApi = function() {};
tv4.validate = function() {};
tv4.validateResult = function() {};
tv4.validateMultiple = function() {};
tv4.addSchema = function() {};
tv4.getSchema = function() {};
tv4.getSchemaMap = function() {};
tv4.getSchemaUris = function() {};
tv4.getMissingUris = function() {};
tv4.dropSchemas = function() {};
tv4.defineKeyword = function() {};
tv4.defineError = function() {};
tv4.reset = function() {};
tv4.missing = [];

/**
 * @type {?Object}
 */
tv4.error = null;

/**
 * @type {?boolean}
 */
tv4.valid = true;

tv4.normSchema = function() {};
tv4.resolveUrl = function() {};
tv4.getDocumentUri = function() {};

/**
 * @enum {number}
 */
tv4.errorCodes = {
    INVALID_TYPE: 0,
    ENUM_MISMATCH: 1,
    ANY_OF_MISSING: 10,
    ONE_OF_MISSING: 11,
    ONE_OF_MULTIPLE: 12,
    NOT_PASSED: 13,
    NUMBER_MULTIPLE_OF: 100,
    NUMBER_MINIMUM: 101,
    NUMBER_MINIMUM_EXCLUSIVE: 102,
    NUMBER_MAXIMUM: 103,
    NUMBER_MAXIMUM_EXCLUSIVE: 104,
    NUMBER_NOT_A_NUMBER: 105,
    STRING_LENGTH_SHORT: 200,
    STRING_LENGTH_LONG: 201,
    STRING_PATTERN: 202,
    OBJECT_PROPERTIES_MINIMUM: 300,
    OBJECT_PROPERTIES_MAXIMUM: 301,
    OBJECT_REQUIRED: 302,
    OBJECT_ADDITIONAL_PROPERTIES: 303,
    OBJECT_DEPENDENCY_KEY: 304,
    ARRAY_LENGTH_SHORT: 400,
    ARRAY_LENGTH_LONG: 401,
    ARRAY_UNIQUE: 402,
    ARRAY_ADDITIONAL_ITEMS: 403,
    FORMAT_CUSTOM: 500,
    KEYWORD_CUSTOM: 501,
    CIRCULAR_REFERENCE: 600,
    UNKNOWN_PROPERTY: 1000 };

tv4.tv4 = { };
