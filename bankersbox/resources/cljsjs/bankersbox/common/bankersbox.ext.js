var BankersBox = function () {};

BankersBox.prototype.toString = function () {};
BankersBox.prototype.del = function () {};
BankersBox.prototype.exists = function () {};
BankersBox.prototype.type = function () {};
BankersBox.prototype.get = function () {};
BankersBox.prototype.getset = function () {};
BankersBox.prototype.append = function () {};
BankersBox.prototype.decr = function () {};
BankersBox.prototype.decrby = function () {};
BankersBox.prototype.incr = function () {};
BankersBox.prototype.incrby = function () {};
BankersBox.prototype.set = function () {};
BankersBox.prototype.setnx = function () {};
BankersBox.prototype.strlen = function () {};
BankersBox.prototype.llen = function () {};
BankersBox.prototype.lindex = function () {};
BankersBox.prototype.lpop = function () {};
BankersBox.prototype.lpush = function () {};
BankersBox.prototype.lpushx = function () {};
BankersBox.prototype.lrange = function () {};
BankersBox.prototype.lrem = function () {};
BankersBox.prototype.lset = function () {};
BankersBox.prototype.ltrim = function () {};
BankersBox.prototype.rpop = function () {};
BankersBox.prototype.rpush = function () {};
BankersBox.prototype.rpushx = function () {};
BankersBox.prototype.rpoplpush = function () {};
BankersBox.prototype.sadd = function () {};
BankersBox.prototype.scard = function () {};
BankersBox.prototype.sismember = function () {};
BankersBox.prototype.smembers = function () {};
BankersBox.prototype.smove = function () {};
BankersBox.prototype.spop = function () {};
BankersBox.prototype.srandmember = function () {};
BankersBox.prototype.srem = function () {};
BankersBox.prototype.keys = function () {};
BankersBox.prototype.flushdb = function () {};
BankersBox.prototype.select = function () {}


var BankersBoxNullAdapter = function(){};
BankersBoxNullAdapter.prototype.getItem = function(k) {};
BankersBoxNullAdapter.prototype.storeItem = function(k, v) {};
BankersBoxNullAdapter.prototype.removeItem = function(k) {};
BankersBoxNullAdapter.prototype.clear = function() {};

var BankersBoxLocalStorageAdapter = function(){};
BankersBoxLocalStorageAdapter.prototype.getItem = function(k) {};
BankersBoxLocalStorageAdapter.prototype.storeItem = function(k, v) {};
BankersBoxLocalStorageAdapter.prototype.removeItem = function(k) {};
BankersBoxLocalStorageAdapter.prototype.clear = function() {};

var BankersBoxFileSystemAdapter = function(){};
BankersBoxFileSystemAdapter.prototype.getItem = function(k) {};
BankersBoxFileSystemAdapter.prototype.storeItem = function(k, v) {};
BankersBoxFileSystemAdapter.prototype.removeItem = function(k) {};
BankersBoxFileSystemAdapter.prototype.clear = function() {};

var BankersBoxException = function(){};
BankersBoxException.prototype.toString = function() {};

var BankersBoxKeyException = function(){};
BankersBoxKeyException.prototype.toString = function() {};
