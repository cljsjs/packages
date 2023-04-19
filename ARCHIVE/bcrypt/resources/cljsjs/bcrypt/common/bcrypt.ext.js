//
// Provided by library https://raw.githubusercontent.com/dcodeIO/bcrypt.js/2.3.0/externs/bcrypt.js
// Adjusted since it did not include the `dcodeIO` object reference

var dcodeIO = {
  "bcrypt": {}
};

dcodeIO.bcrypt.setRandomFallback = function(random) {};

dcodeIO.bcrypt.genSaltSync = function(rounds, seed_length) {};

dcodeIO.bcrypt.genSalt = function(rounds, seed_length, callback) {};

dcodeIO.bcrypt.hashSync = function(s, salt) {};

dcodeIO.bcrypt.hash = function(s, salt, callback) {};

dcodeIO.bcrypt.compareSync = function(s, hash) {};

dcodeIO.bcrypt.compare = function(s, hash, callback) {};

dcodeIO.bcrypt.getRounds = function(hash) {};

dcodeIO.bcrypt.getSalt = function(hash) {};
