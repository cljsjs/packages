/**
 * @fileoverview Closure Compiler externs for Eclipse Paho 1.0.1
 * @see https://www.eclipse.org/paho/clients/js/
 * @externs
 */

var Paho = { "Paho":
             {"MQTT":
             { "Client":
               { "connect":  function( connectionOptions ) {},
                 "disconnect": function() {},
                 "getTraceLog": function() {},
                 "send": function( message ) {},
                 "startTrace": function() {},
                 "stopTrace": function() {},
                 "subscribe": function( filter, subscribeOptions )  {},
                 "unsubscribe": function( filter, unsubscribeOptions ) {},
                 "onConnectionLost": function( reasonCode, reasonMessage ) {},
                 "onMessageArrived": function( message ) {},
                 "onMessageDelivered": function( message ) {},
                 "clientId": {},
                 "host": {} },

               "Message":
                 {"onSuccess": function() {},
                  "onFailure": function() {} }}}};

var destinationName = String;
var duplicate =  Boolean;
var qos = Number;
var retained  =  Boolean;

var clientId = String;
var host = String;
var payloadBytes = Array;
var payloadString = String;
var payload = {};

var messageIdentifier = {};
var payloadMessage   = {};
var connectStrings = {};
var topics = {};
var requestQoS = {};

var cleanSession = {};
var willMessage = {};
var isRetained = {};
var userName = {};
var password  = {};
var keepAliveInterval = {};
