/*
 * Copyright 2010 The Closure Compiler Authors.
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
 */

/**
 * @fileoverview Externs for Kakao Javascript SDK
 * @see https://developers.kakao.com/docs/js-reference
 * @externs
 */

/** @const */
var Kakao = {
  
  init: function() { },
  cleanup: function() { },
  VERSION: {},

  Auth: {
    createLoginButton: function() { },
    login: function() { },
    logout: function() { },
    getAccessToken: function() { },
    getRefreshToken: function() { },
    setAccessToken: function() { },
    setRefreshToken: function() { },
    getAppKey: function() { },
    getStatus: function() { },
    cleanup: function() { }
  },

  Link: {
    createDefaultButton: function() { },
    createScrapButton: function() { },
    createCustomButton: function() { },
    sendDefault: function() { },
    sendScrap: function() { },
    sendCustom: function() { },
    uploadImage: function() { },
    deleteImage: function() { },
    scrapImage: function() { },
    cleanup: function() { },
    createTalkLinkButton: function() { },
    sendTalkLink: function() { }
  },

  API: {
    request: function() { },
    cleanup: function() { }
  },

  Navi: {
    start: function() { },
    share: function() { }
  },

  Story: {
    createShareButton: function() { },
    share: function() { },
    open: function() { },
    createFollowButton: function() { },
    cleanup: function() { }
  }
  
};





