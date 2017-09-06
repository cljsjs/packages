/**
 * @fileoverview Externs for the Google Content Experiments API (cxApi.js).
 *
 * The Content Experiments JavaScript API can be used to:
 * 
 * Choose a variation for a user — For client-side implementations, this API provides an easy way to select an experiment variation for a new user or get the variation for which the user has already been exposed.
 * Set the chosen variation for a user — This is useful when handling experiment choices server-side and you want to report the chosen variation to Google Analytics from the client.
 * Get the chosen variation for a user — Retrieve a previously stored chosen variation for a user.
 * Loading the API Client
 * 
 * To load the Content Experiments JavaScript API client on an experiment page, you add a snippet of JavaScript to the page:
 * 
 * <script src="//www.google-analytics.com/cx/api.js"></script>
 * or you can use an experiment query parameter to specify an experiment ID and load information for that experiment.
 * 
 * <script src="//www.google-analytics.com/cx/api.js?experiment=YByMKfprRCStcMvK8zh1yw"></script>
 * You should specify the experiment id when loading the client if you plan to use the chooseVariation method. If you choose variations server-side and do not plan to use the chooseVariation method, then you should load the client without specifying an experiment ID to take advantage of the performance gain due to browser caching of the script.
 * The client loads synchronously and creates a global object named cxApi. Developers use the cxApi object to choose variations, and set and get experiment values.
 *
 * @see https://developers.google.com/analytics/devguides/collection/analyticsjs/experiments#cxjs
 * @externs
 */
 
function cxApi() {}

cxApi.ORIGINAL_VARIATION;
cxApi.NO_CHOSEN_VARIATION;
cxApi.NOT_PARTICIPATING;

/** @return {number} */
cxApi.chooseVariation = function () {};

/**
* @param {number} chosenVariation (The index of the variation shown to the user, or cxApi.NOT_PARTICIPATING.)
* @param {string} opt_experimentId (The experiment id for which to set the chosen variation. If not provided, uses the first experiment specified when loading the client.)
*/
cxApi.setChosenVariation = function (chosenVariation, opt_experimentId) {};

/**
* @param {string} opt_experimentId (The experiment id for which to get the chosen variation. If not provided, uses the first experiment specified when loading the client.)
* @return {number}
*/
cxApi.getChosenVariation = function (opt_experimentId) {};

/**
* @param {string} domainName (The domain name to use.)
*/
cxApi.setDomainName = function (domainName) {};

/**
* @param {string} cookiePath (The cookie path to use.)
*/
cxApi.setCookiePath = function (cookiePath) {};

/**
* @param {boolean} allowHash (Whether to allow domain hashing.)
*/
cxApi.setAllowHash = function (allowHash) {};
