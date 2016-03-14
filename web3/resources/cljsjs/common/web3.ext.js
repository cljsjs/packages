/** @constructor */
function Web3() {};
Web3.prototype.fromAscii = function(str){};
Web3.prototype.toAscii = function(hexStr){};

Web3.providers = {};
/** @constructor */
Web3.providers.HttpProvider = function(rpcUrl){};

/** @constructor */
function Filter(){};
Filter.prototype.stopWatching = function(){};


Web3.shh = {};
Web3.shh.newIdentity = function(callback){};
Web3.shh.post = function(msg, callback){};
/**
 * @return {Filter}
 */
Web3.shh.filter = function(topics, callback){};
