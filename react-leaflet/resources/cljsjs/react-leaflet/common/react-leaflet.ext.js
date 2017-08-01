// Generated for version 1.4.1
//
// Generated via http://jmmk.github.io/javascript-externs-generator/
// Loaded JavaScripts:
// https://unpkg.com/react@15/dist/react.min.js
// https://unpkg.com/react-dom@15/dist/react-dom.min.js
// http://cdn.leafletjs.com/leaflet/v1.1.0/leaflet.js
// https://unpkg.com/react-leaflet@1.4.1/dist/react-leaflet.min.js
// End of file contains manual additions
var ReactLeaflet = {
  "AttributionControl": {
    "contextTypes": {
      "map": {
        "isRequired": function () {}
      }
    },
    "propTypes": {
      "position": {
        "isRequired": function () {}
      },
      "prefix": {
        "isRequired": function () {}
      }
    }
  },
  "Circle": {
    "childContextTypes": {
      "children": {
        "isRequired": function () {}
      },
      "popupContainer": {
        "isRequired": function () {}
      }
    },
    "contextTypes": {
      "layerContainer": {
        "isRequired": function () {}
      },
      "map": {
        "isRequired": function () {}
      },
      "pane": {
        "isRequired": function () {}
      }
    },
    "propTypes": {
      "center": {
        "isRequired": function () {}
      },
      "children": {
        "isRequired": function () {}
      },
      "radius": {
        "isRequired": function () {}
      }
    }
  },
  "CircleMarker": {
    "childContextTypes": {
      "children": {
        "isRequired": function () {}
      },
      "popupContainer": {
        "isRequired": function () {}
      }
    },
    "contextTypes": {
      "layerContainer": {
        "isRequired": function () {}
      },
      "map": {
        "isRequired": function () {}
      },
      "pane": {
        "isRequired": function () {}
      }
    },
    "propTypes": {
      "center": {
        "isRequired": function () {}
      },
      "children": {
        "isRequired": function () {}
      },
      "radius": {
        "isRequired": function () {}
      }
    }
  },
  "FeatureGroup": {
    "childContextTypes": {
      "children": {
        "isRequired": function () {}
      },
      "layerContainer": {
        "isRequired": function () {}
      },
      "popupContainer": {
        "isRequired": function () {}
      }
    },
    "contextTypes": {
      "layerContainer": {
        "isRequired": function () {}
      },
      "map": {
        "isRequired": function () {}
      },
      "pane": {
        "isRequired": function () {}
      }
    },
    "propTypes": {
      "children": {
        "isRequired": function () {}
      }
    }
  },
  "GeoJSON": {
    "childContextTypes": {
      "children": {
        "isRequired": function () {}
      },
      "popupContainer": {
        "isRequired": function () {}
      }
    },
    "contextTypes": {
      "layerContainer": {
        "isRequired": function () {}
      },
      "map": {
        "isRequired": function () {}
      },
      "pane": {
        "isRequired": function () {}
      }
    },
    "propTypes": {
      "children": {
        "isRequired": function () {}
      },
      "data": {
        "isRequired": function () {}
      }
    }
  },
  "GridLayer": {
    "contextTypes": {
      "layerContainer": {
        "isRequired": function () {}
      },
      "map": {
        "isRequired": function () {}
      },
      "pane": {
        "isRequired": function () {}
      }
    },
    "propTypes": {
      "children": {
        "isRequired": function () {}
      },
      "opacity": {
        "isRequired": function () {}
      },
      "zIndex": {
        "isRequired": function () {}
      }
    }
  },
  "ImageOverlay": {
    "childContextTypes": {
      "popupContainer": {
        "isRequired": function () {}
      }
    },
    "contextTypes": {
      "layerContainer": {
        "isRequired": function () {}
      },
      "map": {
        "isRequired": function () {}
      },
      "pane": {
        "isRequired": function () {}
      }
    },
    "propTypes": {
      "attribution": {
        "isRequired": function () {}
      },
      "bounds": {
        "isRequired": function () {}
      },
      "children": {
        "isRequired": function () {}
      },
      "opacity": {
        "isRequired": function () {}
      },
      "url": {
        "isRequired": function () {}
      },
      "zIndex": {
        "isRequired": function () {}
      }
    }
  },
  "LayerGroup": {
    "childContextTypes": {
      "layerContainer": {
        "isRequired": function () {}
      }
    },
    "contextTypes": {
      "layerContainer": {
        "isRequired": function () {}
      },
      "map": {
        "isRequired": function () {}
      },
      "pane": {
        "isRequired": function () {}
      }
    },
    "propTypes": {
      "children": {
        "isRequired": function () {}
      }
    }
  },
  "LayersControl": {
    "BaseLayer": {
      "childContextTypes": {
        "layerContainer": {
          "isRequired": function () {}
        }
      },
      "contextTypes": {
        "map": {
          "isRequired": function () {}
        }
      },
      "propTypes": {
        "addBaseLayer": {
          "isRequired": function () {}
        },
        "addOverlay": {
          "isRequired": function () {}
        },
        "checked": {
          "isRequired": function () {}
        },
        "children": {
          "isRequired": function () {}
        },
        "name": {
          "isRequired": function () {}
        },
        "removeLayer": {
          "isRequired": function () {}
        },
        "removeLayerControl": {
          "isRequired": function () {}
        }
      }
    },
    "Overlay": {
      "childContextTypes": {
        "layerContainer": {
          "isRequired": function () {}
        }
      },
      "contextTypes": {
        "map": {
          "isRequired": function () {}
        }
      },
      "propTypes": {
        "addBaseLayer": {
          "isRequired": function () {}
        },
        "addOverlay": {
          "isRequired": function () {}
        },
        "checked": {
          "isRequired": function () {}
        },
        "children": {
          "isRequired": function () {}
        },
        "name": {
          "isRequired": function () {}
        },
        "removeLayer": {
          "isRequired": function () {}
        },
        "removeLayerControl": {
          "isRequired": function () {}
        }
      }
    },
    "contextTypes": {
      "layerContainer": {
        "isRequired": function () {}
      },
      "map": {
        "isRequired": function () {}
      }
    },
    "propTypes": {
      "baseLayers": {
        "isRequired": function () {}
      },
      "children": {
        "isRequired": function () {}
      },
      "overlays": {
        "isRequired": function () {}
      },
      "position": {
        "isRequired": function () {}
      }
    }
  },
  "Map": {
    "childContextTypes": {
      "layerContainer": {
        "isRequired": function () {}
      },
      "map": {
        "isRequired": function () {}
      }
    },
    "defaultProps": {
      "animate": {},
      "useFlyTo": {}
    },
    "propTypes": {
      "animate": {
        "isRequired": function () {}
      },
      "bounds": {
        "isRequired": function () {}
      },
      "boundsOptions": {
        "isRequired": function () {}
      },
      "center": {
        "isRequired": function () {}
      },
      "children": {
        "isRequired": function () {}
      },
      "className": {
        "isRequired": function () {}
      },
      "id": {
        "isRequired": function () {}
      },
      "maxBounds": {
        "isRequired": function () {}
      },
      "maxZoom": {
        "isRequired": function () {}
      },
      "minZoom": {
        "isRequired": function () {}
      },
      "style": {
        "isRequired": function () {}
      },
      "useFlyTo": {
        "isRequired": function () {}
      },
      "viewport": {
        "isRequired": function () {}
      },
      "whenReady": {
        "isRequired": function () {}
      },
      "zoom": {
        "isRequired": function () {}
      }
    }
  },
  "MapComponent": function () {},
  "MapControl": {
    "contextTypes": {
      "map": {
        "isRequired": function () {}
      }
    },
    "propTypes": {
      "position": {
        "isRequired": function () {}
      }
    }
  },
  "MapLayer": {
    "contextTypes": {
      "layerContainer": {
        "isRequired": function () {}
      },
      "map": {
        "isRequired": function () {}
      },
      "pane": {
        "isRequired": function () {}
      }
    },
    "propTypes": {
      "children": {
        "isRequired": function () {}
      }
    }
  },
  "Marker": {
    "childContextTypes": {
      "popupContainer": {
        "isRequired": function () {}
      }
    },
    "contextTypes": {
      "layerContainer": {
        "isRequired": function () {}
      },
      "map": {
        "isRequired": function () {}
      },
      "pane": {
        "isRequired": function () {}
      }
    },
    "propTypes": {
      "children": {
        "isRequired": function () {}
      },
      "icon": {
        "isRequired": function () {}
      },
      "opacity": {
        "isRequired": function () {}
      },
      "position": {
        "isRequired": function () {}
      },
      "zIndexOffset": {
        "isRequired": function () {}
      }
    }
  },
  "Pane": {
    "childContextTypes": {
      "pane": {
        "isRequired": function () {}
      }
    },
    "contextTypes": {
      "map": {
        "isRequired": function () {}
      },
      "pane": {
        "isRequired": function () {}
      }
    },
    "propTypes": {
      "children": {
        "isRequired": function () {}
      },
      "className": {
        "isRequired": function () {}
      },
      "map": {
        "isRequired": function () {}
      },
      "name": {
        "isRequired": function () {}
      },
      "pane": {
        "isRequired": function () {}
      },
      "style": {
        "isRequired": function () {}
      }
    }
  },
  "Path": {
    "childContextTypes": {
      "children": {
        "isRequired": function () {}
      },
      "popupContainer": {
        "isRequired": function () {}
      }
    },
    "contextTypes": {
      "layerContainer": {
        "isRequired": function () {}
      },
      "map": {
        "isRequired": function () {}
      },
      "pane": {
        "isRequired": function () {}
      }
    },
    "propTypes": {
      "children": {
        "isRequired": function () {}
      }
    }
  },
  "Polygon": {
    "childContextTypes": {
      "children": {
        "isRequired": function () {}
      },
      "popupContainer": {
        "isRequired": function () {}
      }
    },
    "contextTypes": {
      "layerContainer": {
        "isRequired": function () {}
      },
      "map": {
        "isRequired": function () {}
      },
      "pane": {
        "isRequired": function () {}
      }
    },
    "propTypes": {
      "children": {
        "isRequired": function () {}
      },
      "popupContainer": {
        "isRequired": function () {}
      },
      "positions": {
        "isRequired": function () {}
      }
    }
  },
  "Polyline": {
    "childContextTypes": {
      "children": {
        "isRequired": function () {}
      },
      "popupContainer": {
        "isRequired": function () {}
      }
    },
    "contextTypes": {
      "layerContainer": {
        "isRequired": function () {}
      },
      "map": {
        "isRequired": function () {}
      },
      "pane": {
        "isRequired": function () {}
      }
    },
    "propTypes": {
      "children": {
        "isRequired": function () {}
      },
      "positions": {
        "isRequired": function () {}
      }
    }
  },
  "Popup": {
    "contextTypes": {
      "map": {
        "isRequired": function () {}
      },
      "pane": {
        "isRequired": function () {}
      },
      "popupContainer": {
        "isRequired": function () {}
      }
    },
    "propTypes": {
      "children": {
        "isRequired": function () {}
      },
      "onClose": {
        "isRequired": function () {}
      },
      "onOpen": {
        "isRequired": function () {}
      },
      "position": {
        "isRequired": function () {}
      }
    }
  },
  "PropTypes": {
    "bounds": {
      "isRequired": function () {}
    },
    "children": {
      "isRequired": function () {}
    },
    "controlPosition": {
      "isRequired": function () {}
    },
    "latlng": {
      "isRequired": function () {}
    },
    "latlngList": {
      "isRequired": function () {}
    },
    "layerContainer": {
      "isRequired": function () {}
    },
    "map": {
      "isRequired": function () {}
    },
    "viewport": {
      "isRequired": function () {}
    }
  },
  "Rectangle": {
    "childContextTypes": {
      "children": {
        "isRequired": function () {}
      },
      "popupContainer": {
        "isRequired": function () {}
      }
    },
    "contextTypes": {
      "layerContainer": {
        "isRequired": function () {}
      },
      "map": {
        "isRequired": function () {}
      },
      "pane": {
        "isRequired": function () {}
      }
    },
    "propTypes": {
      "bounds": {
        "isRequired": function () {}
      },
      "children": {
        "isRequired": function () {}
      },
      "popupContainer": {
        "isRequired": function () {}
      }
    }
  },
  "ScaleControl": {
    "contextTypes": {
      "map": {
        "isRequired": function () {}
      }
    },
    "propTypes": {
      "imperial": {
        "isRequired": function () {}
      },
      "maxWidth": {
        "isRequired": function () {}
      },
      "metric": {
        "isRequired": function () {}
      },
      "position": {
        "isRequired": function () {}
      },
      "updateWhenIdle": {
        "isRequired": function () {}
      }
    }
  },
  "TileLayer": {
    "contextTypes": {
      "layerContainer": {
        "isRequired": function () {}
      },
      "map": {
        "isRequired": function () {}
      },
      "pane": {
        "isRequired": function () {}
      }
    },
    "propTypes": {
      "children": {
        "isRequired": function () {}
      },
      "opacity": {
        "isRequired": function () {}
      },
      "url": {
        "isRequired": function () {}
      },
      "zIndex": {
        "isRequired": function () {}
      }
    }
  },
  "Tooltip": {
    "contextTypes": {
      "map": {
        "isRequired": function () {}
      },
      "pane": {
        "isRequired": function () {}
      },
      "popupContainer": {
        "isRequired": function () {}
      }
    },
    "propTypes": {
      "children": {
        "isRequired": function () {}
      },
      "onClose": {
        "isRequired": function () {}
      },
      "onOpen": {
        "isRequired": function () {}
      }
    }
  },
  "VideoOverlay": {
    "contextTypes": {
      "layerContainer": {
        "isRequired": function () {}
      },
      "map": {
        "isRequired": function () {}
      },
      "pane": {
        "isRequired": function () {}
      }
    },
    "propTypes": {
      "attribution": {
        "isRequired": function () {}
      },
      "bounds": {
        "isRequired": function () {}
      },
      "opacity": {
        "isRequired": function () {}
      },
      "play": {
        "isRequired": function () {}
      },
      "url": {
        "isRequired": function () {}
      },
      "zIndex": {
        "isRequired": function () {}
      }
    }
  },
  "WMSTileLayer": {
    "contextTypes": {
      "layerContainer": {
        "isRequired": function () {}
      },
      "map": {
        "isRequired": function () {}
      },
      "pane": {
        "isRequired": function () {}
      }
    },
    "propTypes": {
      "children": {
        "isRequired": function () {}
      },
      "opacity": {
        "isRequired": function () {}
      },
      "url": {
        "isRequired": function () {}
      },
      "zIndex": {
        "isRequired": function () {}
      }
    }
  },
  "ZoomControl": {
    "contextTypes": {
      "map": {
        "isRequired": function () {}
      }
    },
    "propTypes": {
      "position": {
        "isRequired": function () {}
      },
      "zoomInText": {
        "isRequired": function () {}
      },
      "zoomInTitle": {
        "isRequired": function () {}
      },
      "zoomOutText": {
        "isRequired": function () {}
      },
      "zoomOutTitle": {
        "isRequired": function () {}
      }
    }
  }
};
ReactLeaflet.AttributionControl.prototype = {
  "componentDidMount": function () {},
  "componentDidUpdate": function () {},
  "componentWillMount": function () {},
  "componentWillUnmount": function () {},
  "createLeafletElement": function () {},
  "forceUpdate": function () {},
  "isReactComponent": function () {},
  "render": function () {},
  "setState": function () {},
  "updateLeafletElement": function () {}
};
ReactLeaflet.Circle.prototype = {
  "bindLeafletEvents": function () {},
  "componentDidMount": function () {},
  "componentDidUpdate": function () {},
  "componentWillMount": function () {},
  "componentWillReceiveProps": function () {},
  "componentWillUnmount": function () {},
  "createLeafletElement": function () {},
  "extractLeafletEvents": function () {},
  "fireLeafletEvent": function () {},
  "forceUpdate": function () {},
  "getChildContext": function () {},
  "getOptions": function () {},
  "getPathOptions": function () {},
  "isReactComponent": function () {},
  "render": function () {},
  "setState": function () {},
  "setStyle": function () {},
  "setStyleIfChanged": function () {},
  "updateLeafletElement": function () {}
};
ReactLeaflet.CircleMarker.prototype = {
  "bindLeafletEvents": function () {},
  "componentDidMount": function () {},
  "componentDidUpdate": function () {},
  "componentWillMount": function () {},
  "componentWillReceiveProps": function () {},
  "componentWillUnmount": function () {},
  "createLeafletElement": function () {},
  "extractLeafletEvents": function () {},
  "fireLeafletEvent": function () {},
  "forceUpdate": function () {},
  "getChildContext": function () {},
  "getOptions": function () {},
  "getPathOptions": function () {},
  "isReactComponent": function () {},
  "render": function () {},
  "setState": function () {},
  "setStyle": function () {},
  "setStyleIfChanged": function () {},
  "updateLeafletElement": function () {}
};
ReactLeaflet.FeatureGroup.prototype = {
  "bindLeafletEvents": function () {},
  "componentDidMount": function () {},
  "componentDidUpdate": function () {},
  "componentWillMount": function () {},
  "componentWillReceiveProps": function () {},
  "componentWillUnmount": function () {},
  "createLeafletElement": function () {},
  "extractLeafletEvents": function () {},
  "fireLeafletEvent": function () {},
  "forceUpdate": function () {},
  "getChildContext": function () {},
  "getOptions": function () {},
  "getPathOptions": function () {},
  "isReactComponent": function () {},
  "render": function () {},
  "setState": function () {},
  "setStyle": function () {},
  "setStyleIfChanged": function () {},
  "updateLeafletElement": function () {}
};
ReactLeaflet.GeoJSON.prototype = {
  "bindLeafletEvents": function () {},
  "componentDidMount": function () {},
  "componentDidUpdate": function () {},
  "componentWillMount": function () {},
  "componentWillReceiveProps": function () {},
  "componentWillUnmount": function () {},
  "createLeafletElement": function () {},
  "extractLeafletEvents": function () {},
  "fireLeafletEvent": function () {},
  "forceUpdate": function () {},
  "getChildContext": function () {},
  "getOptions": function () {},
  "getPathOptions": function () {},
  "isReactComponent": function () {},
  "render": function () {},
  "setState": function () {},
  "setStyle": function () {},
  "setStyleIfChanged": function () {},
  "updateLeafletElement": function () {}
};
ReactLeaflet.GridLayer.prototype = {
  "bindLeafletEvents": function () {},
  "componentDidMount": function () {},
  "componentDidUpdate": function () {},
  "componentWillMount": function () {},
  "componentWillReceiveProps": function () {},
  "componentWillUnmount": function () {},
  "createLeafletElement": function () {},
  "extractLeafletEvents": function () {},
  "fireLeafletEvent": function () {},
  "forceUpdate": function () {},
  "getOptions": function () {},
  "isReactComponent": function () {},
  "render": function () {},
  "setState": function () {},
  "updateLeafletElement": function () {}
};
ReactLeaflet.ImageOverlay.prototype = {
  "bindLeafletEvents": function () {},
  "componentDidMount": function () {},
  "componentDidUpdate": function () {},
  "componentWillMount": function () {},
  "componentWillReceiveProps": function () {},
  "componentWillUnmount": function () {},
  "createLeafletElement": function () {},
  "extractLeafletEvents": function () {},
  "fireLeafletEvent": function () {},
  "forceUpdate": function () {},
  "getChildContext": function () {},
  "getOptions": function () {},
  "isReactComponent": function () {},
  "render": function () {},
  "setState": function () {},
  "updateLeafletElement": function () {}
};
ReactLeaflet.LayerGroup.prototype = {
  "bindLeafletEvents": function () {},
  "componentDidMount": function () {},
  "componentDidUpdate": function () {},
  "componentWillMount": function () {},
  "componentWillReceiveProps": function () {},
  "componentWillUnmount": function () {},
  "createLeafletElement": function () {},
  "extractLeafletEvents": function () {},
  "fireLeafletEvent": function () {},
  "forceUpdate": function () {},
  "getChildContext": function () {},
  "getOptions": function () {},
  "isReactComponent": function () {},
  "render": function () {},
  "setState": function () {},
  "updateLeafletElement": function () {}
};
ReactLeaflet.LayersControl.prototype = {
  "addBaseLayer": function () {},
  "addOverlay": function () {},
  "componentDidMount": function () {},
  "componentDidUpdate": function () {},
  "componentWillMount": function () {},
  "componentWillUnmount": function () {},
  "createLeafletElement": function () {},
  "forceUpdate": function () {},
  "isReactComponent": function () {},
  "removeLayer": function () {},
  "removeLayerControl": function () {},
  "render": function () {},
  "setState": function () {},
  "updateLeafletElement": function () {}
};
ReactLeaflet.LayersControl.BaseLayer.prototype = {
  "addLayer": function () {},
  "componentWillReceiveProps": function () {},
  "componentWillUnmount": function () {},
  "forceUpdate": function () {},
  "getChildContext": function () {},
  "isReactComponent": function () {},
  "removeLayer": function () {},
  "render": function () {},
  "setState": function () {}
};
ReactLeaflet.LayersControl.Overlay.prototype = {
  "addLayer": function () {},
  "componentWillReceiveProps": function () {},
  "componentWillUnmount": function () {},
  "forceUpdate": function () {},
  "getChildContext": function () {},
  "isReactComponent": function () {},
  "removeLayer": function () {},
  "render": function () {},
  "setState": function () {}
};
ReactLeaflet.Map.prototype = {
  "bindLeafletEvents": function () {},
  "componentDidMount": function () {},
  "componentDidUpdate": function () {},
  "componentWillMount": function () {},
  "componentWillReceiveProps": function () {},
  "componentWillUnmount": function () {},
  "createLeafletElement": function () {},
  "extractLeafletEvents": function () {},
  "fireLeafletEvent": function () {},
  "forceUpdate": function () {},
  "getChildContext": function () {},
  "getOptions": function () {},
  "isReactComponent": function () {},
  "render": function () {},
  "setState": function () {},
  "shouldUpdateBounds": function () {},
  "shouldUpdateCenter": function () {},
  "updateLeafletElement": function () {}
};
ReactLeaflet.MapComponent.prototype = {
  "bindLeafletEvents": function () {},
  "componentDidMount": function () {},
  "componentWillMount": function () {},
  "componentWillReceiveProps": function () {},
  "componentWillUnmount": function () {},
  "extractLeafletEvents": function () {},
  "fireLeafletEvent": function () {},
  "forceUpdate": function () {},
  "getOptions": function () {},
  "isReactComponent": function () {},
  "setState": function () {}
};
ReactLeaflet.MapControl.prototype = {
  "componentDidMount": function () {},
  "componentDidUpdate": function () {},
  "componentWillMount": function () {},
  "componentWillUnmount": function () {},
  "createLeafletElement": function () {},
  "forceUpdate": function () {},
  "isReactComponent": function () {},
  "render": function () {},
  "setState": function () {},
  "updateLeafletElement": function () {}
};
ReactLeaflet.MapLayer.prototype = {
  "bindLeafletEvents": function () {},
  "componentDidMount": function () {},
  "componentDidUpdate": function () {},
  "componentWillMount": function () {},
  "componentWillReceiveProps": function () {},
  "componentWillUnmount": function () {},
  "createLeafletElement": function () {},
  "extractLeafletEvents": function () {},
  "fireLeafletEvent": function () {},
  "forceUpdate": function () {},
  "getOptions": function () {},
  "isReactComponent": function () {},
  "render": function () {},
  "setState": function () {},
  "updateLeafletElement": function () {}
};
ReactLeaflet.Marker.prototype = {
  "bindLeafletEvents": function () {},
  "componentDidMount": function () {},
  "componentDidUpdate": function () {},
  "componentWillMount": function () {},
  "componentWillReceiveProps": function () {},
  "componentWillUnmount": function () {},
  "createLeafletElement": function () {},
  "extractLeafletEvents": function () {},
  "fireLeafletEvent": function () {},
  "forceUpdate": function () {},
  "getChildContext": function () {},
  "getOptions": function () {},
  "isReactComponent": function () {},
  "render": function () {},
  "setState": function () {},
  "updateLeafletElement": function () {}
};
ReactLeaflet.Pane.prototype = {
  "componentDidMount": function () {},
  "componentWillReceiveProps": function () {},
  "componentWillUnmount": function () {},
  "createPane": function () {},
  "forceUpdate": function () {},
  "getChildContext": function () {},
  "getPane": function () {},
  "getParentPane": function () {},
  "isReactComponent": function () {},
  "removePane": function () {},
  "render": function () {},
  "setState": function () {}
};
ReactLeaflet.Path.prototype = {
  "bindLeafletEvents": function () {},
  "componentDidMount": function () {},
  "componentDidUpdate": function () {},
  "componentWillMount": function () {},
  "componentWillReceiveProps": function () {},
  "componentWillUnmount": function () {},
  "createLeafletElement": function () {},
  "extractLeafletEvents": function () {},
  "fireLeafletEvent": function () {},
  "forceUpdate": function () {},
  "getChildContext": function () {},
  "getOptions": function () {},
  "getPathOptions": function () {},
  "isReactComponent": function () {},
  "render": function () {},
  "setState": function () {},
  "setStyle": function () {},
  "setStyleIfChanged": function () {},
  "updateLeafletElement": function () {}
};
ReactLeaflet.Polygon.prototype = {
  "bindLeafletEvents": function () {},
  "componentDidMount": function () {},
  "componentDidUpdate": function () {},
  "componentWillMount": function () {},
  "componentWillReceiveProps": function () {},
  "componentWillUnmount": function () {},
  "createLeafletElement": function () {},
  "extractLeafletEvents": function () {},
  "fireLeafletEvent": function () {},
  "forceUpdate": function () {},
  "getChildContext": function () {},
  "getOptions": function () {},
  "getPathOptions": function () {},
  "isReactComponent": function () {},
  "render": function () {},
  "setState": function () {},
  "setStyle": function () {},
  "setStyleIfChanged": function () {},
  "updateLeafletElement": function () {}
};
ReactLeaflet.Polyline.prototype = {
  "bindLeafletEvents": function () {},
  "componentDidMount": function () {},
  "componentDidUpdate": function () {},
  "componentWillMount": function () {},
  "componentWillReceiveProps": function () {},
  "componentWillUnmount": function () {},
  "createLeafletElement": function () {},
  "extractLeafletEvents": function () {},
  "fireLeafletEvent": function () {},
  "forceUpdate": function () {},
  "getChildContext": function () {},
  "getOptions": function () {},
  "getPathOptions": function () {},
  "isReactComponent": function () {},
  "render": function () {},
  "setState": function () {},
  "setStyle": function () {},
  "setStyleIfChanged": function () {},
  "updateLeafletElement": function () {}
};
ReactLeaflet.Popup.prototype = {
  "bindLeafletEvents": function () {},
  "componentDidMount": function () {},
  "componentDidUpdate": function () {},
  "componentWillMount": function () {},
  "componentWillReceiveProps": function () {},
  "componentWillUnmount": function () {},
  "createLeafletElement": function () {},
  "extractLeafletEvents": function () {},
  "fireLeafletEvent": function () {},
  "forceUpdate": function () {},
  "getOptions": function () {},
  "isReactComponent": function () {},
  "render": function () {},
  "setState": function () {},
  "updateLeafletElement": function () {}
};
ReactLeaflet.Rectangle.prototype = {
  "bindLeafletEvents": function () {},
  "componentDidMount": function () {},
  "componentDidUpdate": function () {},
  "componentWillMount": function () {},
  "componentWillReceiveProps": function () {},
  "componentWillUnmount": function () {},
  "createLeafletElement": function () {},
  "extractLeafletEvents": function () {},
  "fireLeafletEvent": function () {},
  "forceUpdate": function () {},
  "getChildContext": function () {},
  "getOptions": function () {},
  "getPathOptions": function () {},
  "isReactComponent": function () {},
  "render": function () {},
  "setState": function () {},
  "setStyle": function () {},
  "setStyleIfChanged": function () {},
  "updateLeafletElement": function () {}
};
ReactLeaflet.ScaleControl.prototype = {
  "componentDidMount": function () {},
  "componentDidUpdate": function () {},
  "componentWillMount": function () {},
  "componentWillUnmount": function () {},
  "createLeafletElement": function () {},
  "forceUpdate": function () {},
  "isReactComponent": function () {},
  "render": function () {},
  "setState": function () {},
  "updateLeafletElement": function () {}
};
ReactLeaflet.TileLayer.prototype = {
  "bindLeafletEvents": function () {},
  "componentDidMount": function () {},
  "componentDidUpdate": function () {},
  "componentWillMount": function () {},
  "componentWillReceiveProps": function () {},
  "componentWillUnmount": function () {},
  "createLeafletElement": function () {},
  "extractLeafletEvents": function () {},
  "fireLeafletEvent": function () {},
  "forceUpdate": function () {},
  "getOptions": function () {},
  "isReactComponent": function () {},
  "render": function () {},
  "setState": function () {},
  "updateLeafletElement": function () {}
};
ReactLeaflet.Tooltip.prototype = {
  "bindLeafletEvents": function () {},
  "componentDidMount": function () {},
  "componentDidUpdate": function () {},
  "componentWillMount": function () {},
  "componentWillReceiveProps": function () {},
  "componentWillUnmount": function () {},
  "createLeafletElement": function () {},
  "extractLeafletEvents": function () {},
  "fireLeafletEvent": function () {},
  "forceUpdate": function () {},
  "getOptions": function () {},
  "isReactComponent": function () {},
  "render": function () {},
  "setState": function () {}
};
ReactLeaflet.VideoOverlay.prototype = {
  "bindLeafletEvents": function () {},
  "componentDidMount": function () {},
  "componentDidUpdate": function () {},
  "componentWillMount": function () {},
  "componentWillReceiveProps": function () {},
  "componentWillUnmount": function () {},
  "createLeafletElement": function () {},
  "extractLeafletEvents": function () {},
  "fireLeafletEvent": function () {},
  "forceUpdate": function () {},
  "getOptions": function () {},
  "isReactComponent": function () {},
  "render": function () {},
  "setState": function () {},
  "updateLeafletElement": function () {}
};
ReactLeaflet.WMSTileLayer.prototype = {
  "bindLeafletEvents": function () {},
  "componentDidMount": function () {},
  "componentDidUpdate": function () {},
  "componentWillMount": function () {},
  "componentWillReceiveProps": function () {},
  "componentWillUnmount": function () {},
  "createLeafletElement": function () {},
  "extractLeafletEvents": function () {},
  "fireLeafletEvent": function () {},
  "forceUpdate": function () {},
  "getOptions": function () {},
  "isReactComponent": function () {},
  "render": function () {},
  "setState": function () {},
  "updateLeafletElement": function () {}
};
ReactLeaflet.ZoomControl.prototype = {
  "componentDidMount": function () {},
  "componentDidUpdate": function () {},
  "componentWillMount": function () {},
  "componentWillUnmount": function () {},
  "createLeafletElement": function () {},
  "forceUpdate": function () {},
  "isReactComponent": function () {},
  "render": function () {},
  "setState": function () {},
  "updateLeafletElement": function () {}
};

// Manual additions
ReactLeaflet.leafletElement = {};
