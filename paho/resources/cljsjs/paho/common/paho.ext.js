/**
 * @fileoverview Closure Compiler externs for Eclipse Paho 1.0.1
 * @see https://www.eclipse.org/paho/clients/js/
 * @externs
 */



var Paho = { "Paho": 
             {"MQTT":
             { "Client":
               { "connect":  function(connectionOptions) {},
                 "disconnect": function() {},
                 "getTraceLog": function() {},
                 "send": function(message) {},
                 "startTrace": function() {},
                 "stopTrace": function() {},
                 "subscribe": function( filter, subscribeOptions )  {},
                 "unsubscribe": function( filter, unsubscribeOptions ) {},                
                 "onConnectionLost": function( reasonCode, reasonMessage ) {},
                 "onMessageArrived": function( message ) {},
                 "onMessageDelivered": function( message ) {} },
               "Message":
                 {"onSuccess": function() {},
                  "onFailure": function() {} }}}};

/*

var Paho = {
    "Paho": {
        "MQTT": {
            "Client": function () {},
            "Message": function () {}
        }
    }
}
*/
