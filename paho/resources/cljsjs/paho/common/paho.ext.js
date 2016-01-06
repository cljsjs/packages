/**
 * @fileoverview Closure Compiler externs for Eclipse Paho 1.0.1
 * @see https://www.eclipse.org/paho/clients/js/
 * @externs
 */

/**
 * @type {!Object}
 * @const
 */
var Paho = {};

/**
 * @param {Object}
 */
Paho.MQTT.Client.prototype.connect = function(connectionOptions) {};

Paho.MQTT.Client.prototype.disconnect = function() {};
Paho.MQTT.Client.prototype.getTraceLog = function() {};

/**
 * @param {Object}
 */
Paho.MQTT.Client.prototype.send = function(message) {};

Paho.MQTT.Client.prototype.startTrace = function() {};
Paho.MQTT.Client.prototype.stopTrace = function() {};

/**
 * @param {string}
 * @param {Object}
 */
Paho.MQTT.Client.prototype.subscribe = function(filter, subscribeOptions) {};

/**
 * @param {string}
 * @param {Object}
 */
Paho.MQTT.Client.prototype.unsubscribe = function(filter, unsubscribeOptions) {};

/**
 * @type {string}
 */
Paho.MQTT.Client.prototype.clientId;

/**
 * @type {string}
 */
Paho.MQTT.Client.prototype.host;

/**
 * @param {string} 
 * @param {string} 
 */
Paho.MQTT.Client.prototype.onConnectionLost = function(reasonCode, reasonMessage) {};

/**
 * @param {Object}
 */
Paho.MQTT.Client.prototype.onMessageArrived = function(message) {};

/**
 * @param {Object}
 */
Paho.MQTT.Client.prototype.onMessageDelivered = function(message) {};

/**
 * @type {string}
 */
Paho.MQTT.Client.prototype.path;

/**
 * @type {integer}
 */
Paho.MQTT.Client.prototype.port;
//Paho.MQTT.Client.prototype.onSuccess;
//Paho.MQTT.Client.prototype.onFailure;

/**
 * @type {string}
 */
Paho.MQTT.Message.prototype.destinationName;

/**
 * @type {number}
 */
Paho.MQTT.Message.prototype.qos;

/**
 * @type {Object}
 */
Paho.MQTT.Message.prototype.invocationContext;
Paho.MQTT.Message.prototype.onSuccess = function() {};
Paho.MQTT.Message.prototype.onFailure = function() {};

/**
 * @type {number}
 */
Paho.MQTT.Message.prototype.timeout;

/*
 * @param {String} the server's DNS hostname or dotted decimal IP address.
 * @param {Number} the server's port.
 * @param {String} the server's path.
 * @param {String} used when connecting to the server
 */ 
Paho.MQTT.Client(host, port, path, clientId);

/**
 * @param {Object}
 */
Paho.MQTT.Message(msg);


