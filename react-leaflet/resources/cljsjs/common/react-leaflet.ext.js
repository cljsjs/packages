// Generated for version 0.12.2
//
// Generated via http://jmmk.github.io/javascript-externs-generator/
// Loaded JavaScripts:
// https://fb.me/react-15.0.2.js
// https://fb.me/react-dom-15.0.2.js
// http://cdn.leafletjs.com/leaflet/v0.7.7/leaflet.js
// https://unpkg.com/react-leaflet@0.12.2/dist/react-leaflet.min.js
// End of file contains manual additions

var ReactLeaflet = {
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
    }
  },
  "AttributionControl": {
    "propTypes": {
      "prefix": {
        "isRequired": function () {}
      }
    },
    "contextTypes": {
      "map": {
        "isRequired": function () {}
      }
    }
  },
  "BaseTileLayer": {
    "propTypes": {
      "opacity": {
        "isRequired": function () {}
      },
      "zIndex": {
        "isRequired": function () {}
      }
    },
    "contextTypes": {
      "layerContainer": {
        "isRequired": function () {}
      },
      "map": {
        "isRequired": function () {}
      }
    }
  },
  "CanvasTileLayer": {
    "propTypes": {
      "opacity": {
        "isRequired": function () {}
      },
      "zIndex": {
        "isRequired": function () {}
      }
    },
    "contextTypes": {
      "layerContainer": {
        "isRequired": function () {}
      },
      "map": {
        "isRequired": function () {}
      }
    }
  },
  "Circle": {
    "propTypes": {
      "center": function () {},
      "radius": function () {}
    },
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
      }
    }
  },
  "CircleMarker": {
    "propTypes": {
      "center": function () {},
      "radius": {
        "isRequired": function () {}
      }
    },
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
      }
    }
  },
  "FeatureGroup": {
    "childContextTypes": {
      "layerContainer": {
        "isRequired": function () {}
      },
      "popupContainer": {
        "isRequired": function () {}
      }
    },
    "propTypes": {
      "children": {
        "isRequired": function () {}
      }
    },
    "contextTypes": {
      "layerContainer": {
        "isRequired": function () {}
      },
      "map": {
        "isRequired": function () {}
      }
    }
  },
  "GeoJson": {
    "propTypes": {
      "data": function () {}
    },
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
      }
    }
  },
  "ImageOverlay": {
    "propTypes": {
      "attribution": {
        "isRequired": function () {}
      },
      "bounds": function () {},
      "opacity": {
        "isRequired": function () {}
      },
      "url": function () {}
    },
    "contextTypes": {
      "layerContainer": {
        "isRequired": function () {}
      },
      "map": {
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
    "propTypes": {
      "children": {
        "isRequired": function () {}
      }
    },
    "contextTypes": {
      "layerContainer": {
        "isRequired": function () {}
      },
      "map": {
        "isRequired": function () {}
      }
    }
  },
  "LayersControl": {
    "propTypes": {
      "baseLayers": {
        "isRequired": function () {}
      },
      "children": {
        "isRequired": function () {}
      },
      "overlays": {
        "isRequired": function () {}
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
    "BaseLayer": {
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
        "children": function () {},
        "name": function () {},
        "removeLayer": {
          "isRequired": function () {}
        },
        "removeLayerControl": {
          "isRequired": function () {}
        }
      },
      "contextTypes": {
        "map": {
          "isRequired": function () {}
        }
      },
      "childContextTypes": {
        "layerContainer": {
          "isRequired": function () {}
        }
      }
    },
    "Overlay": {
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
        "children": function () {},
        "name": function () {},
        "removeLayer": {
          "isRequired": function () {}
        },
        "removeLayerControl": {
          "isRequired": function () {}
        }
      },
      "contextTypes": {
        "map": {
          "isRequired": function () {}
        }
      },
      "childContextTypes": {
        "layerContainer": {
          "isRequired": function () {}
        }
      }
    }
  },
  "Map": {
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
      "zoom": {
        "isRequired": function () {}
      }
    },
    "defaultProps": {
      "animate": {}
    },
    "childContextTypes": {
      "map": {
        "isRequired": function () {}
      }
    }
  },
  "MapComponent": function () {},
  "MapControl": {
    "propTypes": {
      "position": {
        "isRequired": function () {}
      }
    },
    "contextTypes": {
      "map": {
        "isRequired": function () {}
      }
    }
  },
  "MapLayer": {
    "propTypes": {
      "children": {
        "isRequired": function () {}
      }
    },
    "contextTypes": {
      "layerContainer": {
        "isRequired": function () {}
      },
      "map": {
        "isRequired": function () {}
      }
    }
  },
  "Marker": {
    "propTypes": {
      "icon": {
        "isRequired": function () {}
      },
      "opacity": {
        "isRequired": function () {}
      },
      "position": function () {},
      "zIndexOffset": {
        "isRequired": function () {}
      }
    },
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
      }
    }
  },
  "MultiPolygon": {
    "propTypes": {
      "polygons": function () {}
    },
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
      }
    }
  },
  "MultiPolyline": {
    "propTypes": {
      "polylines": function () {}
    },
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
      }
    }
  },
  "Path": {
    "childContextTypes": {
      "popupContainer": {
        "isRequired": function () {}
      }
    },
    "propTypes": {
      "children": {
        "isRequired": function () {}
      }
    },
    "contextTypes": {
      "layerContainer": {
        "isRequired": function () {}
      },
      "map": {
        "isRequired": function () {}
      }
    }
  },
  "Polygon": {
    "propTypes": {
      "positions": function () {}
    },
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
      }
    }
  },
  "Polyline": {
    "propTypes": {
      "positions": function () {}
    },
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
      }
    }
  },
  "Popup": {
    "propTypes": {
      "children": {
        "isRequired": function () {}
      },
      "position": {
        "isRequired": function () {}
      }
    },
    "contextTypes": {
      "map": {
        "isRequired": function () {}
      },
      "popupContainer": {
        "isRequired": function () {}
      }
    }
  },
  "Rectangle": {
    "propTypes": {
      "bounds": function () {}
    },
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
      }
    }
  },
  "ScaleControl": {
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
      "updateWhenIdle": {
        "isRequired": function () {}
      }
    },
    "contextTypes": {
      "map": {
        "isRequired": function () {}
      }
    }
  },
  "TileLayer": {
    "propTypes": {
      "url": function () {}
    },
    "contextTypes": {
      "layerContainer": {
        "isRequired": function () {}
      },
      "map": {
        "isRequired": function () {}
      }
    }
  },
  "WMSTileLayer": {
    "propTypes": {
      "url": function () {}
    },
    "contextTypes": {
      "layerContainer": {
        "isRequired": function () {}
      },
      "map": {
        "isRequired": function () {}
      }
    }
  },
  "ZoomControl": {
    "propTypes": {
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
    },
    "contextTypes": {
      "map": {
        "isRequired": function () {}
      }
    }
  },
  "setIconDefaultImagePath": function () {}
};
ReactLeaflet.AttributionControl.prototype = {
  "isReactComponent": function () {},
  "setState": function () {},
  "forceUpdate": function () {}
};
ReactLeaflet.BaseTileLayer.prototype = {
  "isReactComponent": function () {},
  "setState": function () {},
  "forceUpdate": function () {}
};
ReactLeaflet.CanvasTileLayer.prototype = {
  "isReactComponent": function () {},
  "setState": function () {},
  "forceUpdate": function () {}
};
ReactLeaflet.Circle.prototype = {
  "isReactComponent": function () {},
  "setState": function () {},
  "forceUpdate": function () {}
};
ReactLeaflet.CircleMarker.prototype = {
  "isReactComponent": function () {},
  "setState": function () {},
  "forceUpdate": function () {}
};
ReactLeaflet.FeatureGroup.prototype = {
  "isReactComponent": function () {},
  "setState": function () {},
  "forceUpdate": function () {}
};
ReactLeaflet.GeoJson.prototype = {
  "isReactComponent": function () {},
  "setState": function () {},
  "forceUpdate": function () {}
};
ReactLeaflet.ImageOverlay.prototype = {
  "isReactComponent": function () {},
  "setState": function () {},
  "forceUpdate": function () {}
};
ReactLeaflet.LayerGroup.prototype = {
  "isReactComponent": function () {},
  "setState": function () {},
  "forceUpdate": function () {}
};
ReactLeaflet.LayersControl.prototype = {
  "isReactComponent": function () {},
  "setState": function () {},
  "forceUpdate": function () {}
};
ReactLeaflet.LayersControl.BaseLayer.prototype = {
  "isReactComponent": function () {},
  "setState": function () {},
  "forceUpdate": function () {}
};
ReactLeaflet.LayersControl.Overlay.prototype = {
  "isReactComponent": function () {},
  "setState": function () {},
  "forceUpdate": function () {}
};
ReactLeaflet.Map.prototype = {
  "isReactComponent": function () {},
  "setState": function () {},
  "forceUpdate": function () {}
};
ReactLeaflet.MapComponent.prototype = {
  "isReactComponent": function () {},
  "setState": function () {},
  "forceUpdate": function () {}
};
ReactLeaflet.MapControl.prototype = {
  "isReactComponent": function () {},
  "setState": function () {},
  "forceUpdate": function () {}
};
ReactLeaflet.MapLayer.prototype = {
  "isReactComponent": function () {},
  "setState": function () {},
  "forceUpdate": function () {}
};
ReactLeaflet.Marker.prototype = {
  "isReactComponent": function () {},
  "setState": function () {},
  "forceUpdate": function () {}
};
ReactLeaflet.MultiPolygon.prototype = {
  "isReactComponent": function () {},
  "setState": function () {},
  "forceUpdate": function () {}
};
ReactLeaflet.MultiPolyline.prototype = {
  "isReactComponent": function () {},
  "setState": function () {},
  "forceUpdate": function () {}
};
ReactLeaflet.Path.prototype = {
  "isReactComponent": function () {},
  "setState": function () {},
  "forceUpdate": function () {}
};
ReactLeaflet.Polygon.prototype = {
  "isReactComponent": function () {},
  "setState": function () {},
  "forceUpdate": function () {}
};
ReactLeaflet.Polyline.prototype = {
  "isReactComponent": function () {},
  "setState": function () {},
  "forceUpdate": function () {}
};
ReactLeaflet.Popup.prototype = {
  "isReactComponent": function () {},
  "setState": function () {},
  "forceUpdate": function () {}
};
ReactLeaflet.Rectangle.prototype = {
  "isReactComponent": function () {},
  "setState": function () {},
  "forceUpdate": function () {}
};
ReactLeaflet.ScaleControl.prototype = {
  "isReactComponent": function () {},
  "setState": function () {},
  "forceUpdate": function () {}
};
ReactLeaflet.TileLayer.prototype = {
  "isReactComponent": function () {},
  "setState": function () {},
  "forceUpdate": function () {}
};
ReactLeaflet.WMSTileLayer.prototype = {
  "isReactComponent": function () {},
  "setState": function () {},
  "forceUpdate": function () {}
};
ReactLeaflet.ZoomControl.prototype = {
  "isReactComponent": function () {},
  "setState": function () {},
  "forceUpdate": function () {}
};

ReactLeaflet.leafletElement = {};
