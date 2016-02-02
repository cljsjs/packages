// blockapps_externs.js ---
//
// Filename: blockapps_externs.js
// Description: Interface to the Ethereum blockchain providing contract creation and transactions, state inspection, and dApp registration and management
// Author: Ryan Reich
//
// The MIT License (MIT)
//
// Copyright (c) 2015 Ryan Reich
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in all
// copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
// SOFTWARE.
//
//
// Code:

var BlockApps = {
    "ethbase": {
      "Account": function (address) {},
      "Address": function (x) {},
      "Int": function (x) {},
      "Storage": function (storageQueryObj) {},
      "Transaction": function (argObj) {},
      "Units": {
        "stringToEthUnit": function(s){},
        "convertEth": function(n,d){},
        "ethValue": function(x){},
        "schemes": {"ethereum": {
          "wei":{},
          "kwei":{},
          "mwei":{},
          "gwei":{},
          "szabo":{},
          "finney":{},
          "ether":{}
        }}
      }},
    routes: {
      solc: function (code) {},
      extabi: function (code) {},
      faucet: function (address) {},
      login: function (loginObj, address) {},
      wallet: function(loginObj, enckey) {},
      developer: function(loginObj) {},
      register: function(loginObj, appObj) {},
      block: function(blockQueryObj) {},
      blockLast: function(n) {},
      account: function(accountQueryObj) {},
      accountAddress: function(address) {},
      submitTransaction: function(txObj) {},
      transaction: function(transactionQueryObj) {},
      transactionLast: function(n) {},
      transactionResult: function(txHash) {},
      storage: function(storageQueryObj) {},
      storageAddress: function(address) {}
    },
    query: {},
    polling: {},
    setProfile: function(profName, version){},
    Solidity: function(code) {},
    MultiTX: function(txArray) {}:
  }

BlockApps.ethbase.Transaction.send = function(privKeyFrom, addressTo) {};

BlockApps.ethbase.Transaction.defaults = {
    "value": 0
};

BlockApps.ethbase.Storage.prototype = {
    "address" : "",
    "getSubKey" : function(key, start, size) {},
    "getKeyRange" : function(start, itemsNum) {},
    "constructor" : function(storageQueryObj) {}
};
BlockApps.ethbase.Storage.Word = function(x){};

BlockApps.setProfile.profiles = {};

BlockApps.Solidity.prototype = {
    "code" : "",
    "name" : "",
    "vmCode" : null,
    "symTab" : null,
    "constructor" : function(code) {},
    "newContract" : function(privkey, txParams) {}
};
BlockApps.Solidity.attach = function(metadata) {};

BlockApps.MultiTX.defaults = {};
