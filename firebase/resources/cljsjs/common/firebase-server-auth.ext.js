/**
 * @fileoverview Firebase Server Auth API.
 * Version: 3.0.5
 *
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @externs
 */

/**
 * Gets the Auth object for the default App or a given App.
 *
 * Usage:
 *
 *   firebase.auth()
 *   firebase.auth(app)
 *
 * @namespace
 * @param {!firebase.app.App=} app
 * @return {!firebase.auth.Auth}
 */
firebase.auth = function(app) {};

/**
 * Gets the Firebase Auth Service object for an App.
 *
 * Usage:
 *
 *   app.auth()
 *
 * @return {!firebase.auth.Auth}
 */
firebase.app.App.prototype.auth = function() {};

/**
 * The Firebase Auth service interface.
 *
 * @interface
 */
firebase.auth.Auth = function() {};

/**
 * The App associated with the Auth service instance.
 *
 * @type {!firebase.app.App}
 */
firebase.auth.Auth.prototype.app;

/**
 * Creates a new custom token (JWT) that can be sent back to a client to use
 * with signInWithCustomToken.
 *
 * @param {string} uid The uid to use as the subject
 * @param {Object=} developerClaims Optional additional claims to include
 *     in the payload of the custom token (JWT)
 *
 * @return {string} The custom token (JWT) for the provided payload.
 */
firebase.auth.Auth.prototype.createCustomToken =
    function(uid, developerClaims) {};

/**
 * Verifies a ID token (JWT). Returns a Promise with the tokens claims. Rejects
 * the promise if the token could not be verified.
 *
 * @param {string} idToken The ID token (JWT) to verify
 * @return {!firebase.Promise<Object>} The Promise that will be fulfilled after
 *     a successful verification
 */
firebase.auth.Auth.prototype.verifyIdToken = function(idToken) {};
