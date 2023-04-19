/**
 * @fileoverview Externs for MediaStreamRecorder version 1.2.6
 */

/**
 * @constructor
 */
var MultiStreamRecorder = function(stream) {};
MultiStreamRecorder.prototype.start = function(/** number **/ ms) {};
MultiStreamRecorder.prototype.onStartedDrawingNonBlankFrames = function() {};
MultiStreamRecorder.prototype.clearOldRecordedFrames = function() {};
MultiStreamRecorder.prototype.ondataavailable = function(blob) {};
MultiStreamRecorder.prototype.onstop = function(error) {};
MultiStreamRecorder.prototype.stop = function() {};


/**
 * @constructor
 */
var MediaStreamRecorder = function(stream) {};
MediaStreamRecorder.prototype.start = function(/** number **/ ms) {};
MediaStreamRecorder.prototype.onStartedDrawingNonBlankFrames = function() {};
MediaStreamRecorder.prototype.clearOldRecordedFrames = function() {};
MediaStreamRecorder.prototype.ondataavailable = function(blob) {};
MediaStreamRecorder.prototype.onstop = function(error) {};
MediaStreamRecorder.prototype.stop = function() {};

