var Relay = {
  "Mutation": {
    "getFragment": function() {}
  },
  "PropTypes": {
    "Container": function() {},
    "Context": function() {},
    "QueryConfig": {
      "isRequired": function() {}
    }
  },
  "QL": {
    "__frag": function() {},
    "__var": function() {},
    "__id": function() {}
  },
  "RootContainer": {
    "propTypes": {
      "Component": function() {},
      "forceFetch": {
        "isRequired": function() {}
      },
      "onReadyStateChange": {
        "isRequired": function() {}
      },
      "renderFailure": {
        "isRequired": function() {}
      },
      "renderFetched": {
        "isRequired": function() {}
      },
      "renderLoading": {
        "isRequired": function() {}
      },
      "route": function() {}
    },
    "childContextTypes": {
      "route": function() {}
    }
  },
  "Route": {
    "injectURICreator": function() {}
  },
  "Store": {},
  "createContainer": function() {},
  "createQuery": function() {},
  "getQueries": {
    "attachHandler": function() {},
    "detachHandler": function() {},
    "displayName": {}
  },
  "injectNetworkLayer": function() {},
  "injectTaskScheduler": function() {},
  "isContainer": function() {},
  "DefaultNetworkLayer": function() {}
};
Relay.Mutation.prototype = {
  "getMutation": function() {},
  "getFatQuery": function() {},
  "getConfigs": function() {},
  "getVariables": function() {},
  "getFiles": function() {},
  "getOptimisticResponse": function() {},
  "getOptimisticConfigs": function() {},
  "getCollisionKey": function() {},
  "_resolveProps": function() {}
};
Relay.Route.prototype = {
  "prepareVariables": function() {}
};
Relay.DefaultNetworkLayer.prototype = {
  "sendMutation": function() {},
  "sendQueries": function() {},
  "supports": function() {},
  "_sendMutation": function() {},
  "_sendQuery": function() {}
};
