
Messaging.Client( host , port, path , clientId ) {}

Paho.MQTT.Client(host, port, path, clientId) {}
Paho.MQTT.Message( msg ) {}

connect(connectOptions) {}
disconnect() {}
getTraceLog() {}
send(message) {}
startTrace() {}
stopTrace() {}
subscribe(filter, subscribeOptions) {}
unsubscribe(filter, unsubscribeOptions) {}

var clientId;
var host;
var onConnectionLost;
var onMessageArrived;
var onMessageDelivered;
var path;
var port;
var onSuccess;
var onFailure;
