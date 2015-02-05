//  Chance.js 0.7.3
//  http://chancejs.com
//  (c) 2013 Victor Quinn
//  Chance may be freely distributed or modified under the MIT license.

/** @interface */
function Chance(seed) {}

/** @type {!Chance} */
var chance;

Chance.prototype.VERSION = {};
Chance.prototype.bool = function (options) {}
Chance.prototype.character = function (options) {}
Chance.prototype.floating = function (options) {}
Chance.prototype.integer = function (options) {}
Chance.prototype.natural = function (options) {}
Chance.prototype.string = function (options) {}
Chance.prototype.capitalize = function (word) {}
Chance.prototype.mixin = function (obj) {}
Chance.prototype.unique = function(fn, num, options) {}
Chance.prototype.n = function(fn, n) {}
Chance.prototype.pad = function (number, width, pad) {}
Chance.prototype.pick = function (arr, count) {}
Chance.prototype.shuffle = function (arr) {}
Chance.prototype.weighted = function(arr, weights) {}
Chance.prototype.paragraph = function (options) {}
Chance.prototype.sentence = function (options) {}
Chance.prototype.syllable = function (options) {}
Chance.prototype.word = function (options) {}
Chance.prototype.age = function (options) {}
Chance.prototype.birthday = function (options) {}
Chance.prototype.cpf = function () {}
Chance.prototype.first = function (options) {}
Chance.prototype.gender = function () {}
Chance.prototype.last = function () {}
Chance.prototype.name = function (options) {}
Chance.prototype.name_prefixes = function (gender) {}
Chance.prototype.prefix = function (options) {}
Chance.prototype.name_prefix = function (options) {}
Chance.prototype.ssn = function (options) {}
Chance.prototype.name_suffixes = function () {}
Chance.prototype.suffix = function (options) {}
Chance.prototype.name_suffix = function (options) {}
Chance.prototype.android_id = function () {}
Chance.prototype.apple_token = function () {}
Chance.prototype.wp8_anid2 = function () {}
Chance.prototype.wp7_anid = function () {}
Chance.prototype.bb_pin = function () {}
Chance.prototype.color = function (options) {}
Chance.prototype.domain = function (options) {}
Chance.prototype.email = function (options) {}
Chance.prototype.fbid = function () {}
Chance.prototype.google_analytics = function () {}
Chance.prototype.hashtag = function () {}
Chance.prototype.ip = function () {}
Chance.prototype.ipv6 = function () {}
Chance.prototype.klout = function () {}
Chance.prototype.tlds = function () {}
Chance.prototype.tld = function () {}
Chance.prototype.twitter = function () {}
Chance.prototype.url = function (options) {}
Chance.prototype.address = function (options) {}
Chance.prototype.altitude = function (options) {}
Chance.prototype.areacode = function (options) {}
Chance.prototype.city = function () {}
Chance.prototype.coordinates = function (options) {}
Chance.prototype.countries = function () {}
Chance.prototype.country = function (options) {}
Chance.prototype.depth = function (options) {}
Chance.prototype.geohash = function (options) {}
Chance.prototype.geojson = function (options) {}
Chance.prototype.latitude = function (options) {}
Chance.prototype.longitude = function (options) {}
Chance.prototype.phone = function (options) {}
Chance.prototype.postal = function () {}
Chance.prototype.provinces = function () {}
Chance.prototype.province = function (options) {}
Chance.prototype.state = function (options) {}
Chance.prototype.states = function (options) {}
Chance.prototype.street = function (options) {}
Chance.prototype.street_suffix = function () {}
Chance.prototype.street_suffixes = function () {}
Chance.prototype.zip = function (options) {}
Chance.prototype.ampm = function () {}
Chance.prototype.date = function (options) {}
Chance.prototype.hammertime = function (options) {}
Chance.prototype.hour = function (options) {}
Chance.prototype.millisecond = function () {}
Chance.prototype.minute = Chance.prototype.second = function (options) {}
Chance.prototype.month = function (options) {}
Chance.prototype.months = function () {}
Chance.prototype.second = function () {}
Chance.prototype.timestamp = function () {}
Chance.prototype.year = function (options) {}
Chance.prototype.cc = function (options) {}
Chance.prototype.cc_types = function () {}
Chance.prototype.cc_type = function (options) {}
Chance.prototype.currency_types = function () {}
Chance.prototype.currency = function () {}
Chance.prototype.currency_pair = function (returnAsString) {}
Chance.prototype.dollar = function (options) {}
Chance.prototype.exp = function (options) {}
Chance.prototype.exp_month = function (options) {}
Chance.prototype.exp_year = function () {}
Chance.prototype.d4 = function (options) {}
Chance.prototype.d6 = function (options) {}
Chance.prototype.d8 = function (options) {}
Chance.prototype.d10 = function (options) {}
Chance.prototype.d12 = function (options) {}
Chance.prototype.d20 = function (options) {}
Chance.prototype.d30 = function (options) {}
Chance.prototype.d100 = function (options) {}
Chance.prototype.rpg = function (thrown, options) {}
Chance.prototype.guid = function (options) {}
Chance.prototype.hash = function (options) {}
Chance.prototype.luhn_check = function (num) {}
Chance.prototype.luhn_calculate = function (num) {}
Chance.prototype.get = function (name) {}
Chance.prototype.mac_address = function(options){}
Chance.prototype.normal = function (options) {}
Chance.prototype.radio = function (options) {}
Chance.prototype.set = function (name, values) {}
Chance.prototype.tv = function (options) {}
Chance.prototype.cnpj = function () {}
Chance.prototype.mersenne_twister = function (seed) {}
