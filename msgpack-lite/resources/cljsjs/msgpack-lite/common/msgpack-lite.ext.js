// msgpack-lite.ext.js
//
// Externs file for https://github.com/kawanet/msgpack-lite
//
// Generated with https://jmmk.github.io/javascript-externs-generator/

var msgpack = {
	"encode": function () {},
	"decode": function () {},
	"Encoder": function () {},
	"Decoder": function () {},
	"createCodec": function () {},
	"codec": {
		"preset": {
			"addExtPacker": function() {},
			"addExtUnpacker": function() {},
		}
	}
};

msgpack.Encoder.prototype = {
	"options": function () {},
	"codec": function () {},
	"on": function () {},
	"once": function () {},
	"off": function () {},
	"emit": function () {},
	"encode": function () {},
	"end": function () {},
	"push": function () {},
	"read": function () {},
	"flush": function () {},
	"reserve": function () {},
	"alloc": function () {},
	"send": function () {}
};

msgpack.Decoder.prototype = {
	"options": function () {},
	"codec": function () {},
	"on": function () {},
	"once": function () {},
	"off": function () {},
	"emit": function () {},
	"decode": function () {},
	"push": function () {},
	"end": function () {},
	"read": function () {},
	"append": function () {}
};
