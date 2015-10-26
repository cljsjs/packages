var vis = {
  "util": {
    "isNumber": function () {},
    "recursiveDOMDelete": function () {},
    "giveRange": function () {},
    "isString": function () {},
    "isDate": function () {},
    "randomUUID": function () {},
    "assignAllKeys": function () {},
    "fillIfDefined": function () {},
    "protoExtend": function () {},
    "extend": function () {},
    "selectiveExtend": function () {},
    "selectiveDeepExtend": function () {},
    "selectiveNotDeepExtend": function () {},
    "deepExtend": function () {},
    "equalArray": function () {},
    "convert": function () {},
    "getType": function () {},
    "copyAndExtendArray": function () {},
    "copyArray": function () {},
    "getAbsoluteLeft": function () {},
    "getAbsoluteTop": function () {},
    "addClassName": function () {},
    "removeClassName": function () {},
    "forEach": function () {},
    "toArray": function () {},
    "updateProperty": function () {},
    "throttle": function () {},
    "addEventListener": function () {},
    "removeEventListener": function () {},
    "preventDefault": function () {},
    "getTarget": function () {},
    "hasParent": function () {},
    "option": {
      "asBoolean": function () {},
      "asNumber": function () {},
      "asString": function () {},
      "asSize": function () {},
      "asElement": function () {}
    },
    "hexToRGB": function () {},
    "overrideOpacity": function () {},
    "RGBToHex": function () {},
    "parseColor": function () {},
    "RGBToHSV": function () {},
    "addCssText": function () {},
    "removeCssText": function () {},
    "HSVToRGB": function () {},
    "HSVToHex": function () {},
    "hexToHSV": function () {},
    "isValidHex": function () {},
    "isValidRGB": function () {},
    "isValidRGBA": function () {},
    "selectiveBridgeObject": function () {},
    "bridgeObject": function () {},
    "mergeOptions": function () {},
    "binarySearchCustom": function () {},
    "binarySearchValue": function () {},
    "easingFunctions": {
      "linear": function () {},
      "easeInQuad": function () {},
      "easeOutQuad": function () {},
      "easeInOutQuad": function () {},
      "easeInCubic": function () {},
      "easeOutCubic": function () {},
      "easeInOutCubic": function () {},
      "easeInQuart": function () {},
      "easeOutQuart": function () {},
      "easeInOutQuart": function () {},
      "easeInQuint": function () {},
      "easeOutQuint": function () {},
      "easeInOutQuint": function () {}
    }
  },
  "DOMutil": {
    "prepareElements": function () {},
    "cleanupElements": function () {},
    "getSVGElement": function () {},
    "getDOMElement": function () {},
    "drawPoint": function () {},
    "drawBar": function () {}
  },
  "DataSet": function () {},
  "DataView": function () {},
  "Queue": function () {},
  "Graph3d": function () {},
  "graph3d": {
    "Camera": function () {},
    "Filter": function () {},
    "Point2d": function () {},
    "Point3d": function () {},
    "Slider": function () {},
    "StepNumber": function () {}
  },
  "Timeline": function () {},
  "Graph2d": function () {},
  "timeline": {
    "DateUtil": {
      "convertHiddenOptions": function () {},
      "updateHiddenDates": function () {},
      "removeDuplicates": function () {},
      "printDates": function () {},
      "stepOverHiddenDates": function () {},
      "toScreen": function () {},
      "toTime": function () {},
      "getHiddenDurationBetween": function () {},
      "correctTimeForHidden": function () {},
      "getHiddenDurationBefore": function () {},
      "getAccumulatedHiddenDuration": function () {},
      "snapAwayFromHidden": function () {},
      "isHidden": function () {}
    },
    "DataStep": function () {},
    "Range": function () {},
    "stack": {
      "orderByStart": function () {},
      "orderByEnd": function () {},
      "stack": function () {},
      "nostack": function () {},
      "collision": function () {}
    },
    "TimeStep": function () {},
    "components": {
      "items": {
        "Item": function () {},
        "BackgroundItem": function () {},
        "BoxItem": function () {},
        "PointItem": function () {},
        "RangeItem": function () {}
      },
      "Component": function () {},
      "CurrentTime": function () {},
      "CustomTime": function () {},
      "DataAxis": function () {},
      "GraphGroup": function () {},
      "Group": function () {},
      "BackgroundGroup": function () {},
      "ItemSet": function () {},
      "Legend": function () {},
      "LineGraph": function () {},
      "TimeAxis": function () {}
    }
  },
  "Network": function () {},
  "network": {
    "Images": function () {},
    "dotparser": {
      "parseDOT": function () {},
      "DOTToGraph": function () {}
    },
    "gephiParser": {
      "parseGephi": function () {}
    },
    "allOptions": {
      "allOptions": {
        "configure": {
          "enabled": {
            "boolean": {}
          },
          "filter": {
            "boolean": {},
            "string": {},
            "array": {},
            "function": {}
          },
          "container": {
            "dom": {}
          },
          "showButton": {
            "boolean": {}
          },
          "__type__": {
            "object": {},
            "boolean": {},
            "string": {},
            "array": {},
            "function": {}
          }
        },
        "edges": {
          "arrows": {
            "to": {
              "enabled": {
                "boolean": {}
              },
              "scaleFactor": {
                "number": {}
              },
              "__type__": {
                "object": {},
                "boolean": {}
              }
            },
            "middle": {
              "enabled": {
                "boolean": {}
              },
              "scaleFactor": {
                "number": {}
              },
              "__type__": {
                "object": {},
                "boolean": {}
              }
            },
            "from": {
              "enabled": {
                "boolean": {}
              },
              "scaleFactor": {
                "number": {}
              },
              "__type__": {
                "object": {},
                "boolean": {}
              }
            },
            "__type__": {
              "string": {
                "0": {},
                "1": {},
                "2": {}
              },
              "object": {}
            }
          },
          "color": {
            "color": {
              "string": {}
            },
            "highlight": {
              "string": {}
            },
            "hover": {
              "string": {}
            },
            "inherit": {
              "string": {
                "0": {},
                "1": {},
                "2": {}
              },
              "boolean": {}
            },
            "opacity": {
              "number": {}
            },
            "__type__": {
              "object": {},
              "string": {}
            }
          },
          "dashes": {
            "boolean": {},
            "array": {}
          },
          "font": {
            "color": {
              "string": {}
            },
            "size": {
              "number": {}
            },
            "face": {
              "string": {}
            },
            "background": {
              "string": {}
            },
            "strokeWidth": {
              "number": {}
            },
            "strokeColor": {
              "string": {}
            },
            "align": {
              "string": {
                "0": {},
                "1": {},
                "2": {},
                "3": {}
              }
            },
            "__type__": {
              "object": {},
              "string": {}
            }
          },
          "hidden": {
            "boolean": {}
          },
          "hoverWidth": {
            "function": {},
            "number": {}
          },
          "label": {
            "string": {},
            "undefined": {}
          },
          "labelHighlightBold": {
            "boolean": {}
          },
          "length": {
            "number": {},
            "undefined": {}
          },
          "physics": {
            "boolean": {}
          },
          "scaling": {
            "min": {
              "number": {}
            },
            "max": {
              "number": {}
            },
            "label": {
              "enabled": {
                "boolean": {}
              },
              "min": {
                "number": {}
              },
              "max": {
                "number": {}
              },
              "maxVisible": {
                "number": {}
              },
              "drawThreshold": {
                "number": {}
              },
              "__type__": {
                "object": {},
                "boolean": {}
              }
            },
            "customScalingFunction": {
              "function": {}
            },
            "__type__": {
              "object": {}
            }
          },
          "selectionWidth": {
            "function": {},
            "number": {}
          },
          "selfReferenceSize": {
            "number": {}
          },
          "shadow": {
            "enabled": {
              "boolean": {}
            },
            "size": {
              "number": {}
            },
            "x": {
              "number": {}
            },
            "y": {
              "number": {}
            },
            "__type__": {
              "object": {},
              "boolean": {}
            }
          },
          "smooth": {
            "enabled": {
              "boolean": {}
            },
            "type": {
              "string": {
                "0": {},
                "1": {},
                "2": {},
                "3": {},
                "4": {},
                "5": {},
                "6": {},
                "7": {},
                "8": {},
                "9": {}
              }
            },
            "roundness": {
              "number": {}
            },
            "forceDirection": {
              "string": {
                "0": {},
                "1": {},
                "2": {}
              },
              "boolean": {}
            },
            "__type__": {
              "object": {},
              "boolean": {}
            }
          },
          "title": {
            "string": {},
            "undefined": {}
          },
          "width": {
            "number": {}
          },
          "value": {
            "number": {},
            "undefined": {}
          },
          "__type__": {
            "object": {}
          }
        },
        "groups": {
          "useDefaultGroups": {
            "boolean": {}
          },
          "__any__": {
            "borderWidth": {
              "number": {}
            },
            "borderWidthSelected": {
              "number": {},
              "undefined": {}
            },
            "brokenImage": {
              "string": {},
              "undefined": {}
            },
            "color": {
              "border": {
                "string": {}
              },
              "background": {
                "string": {}
              },
              "highlight": {
                "border": {
                  "string": {}
                },
                "background": {
                  "string": {}
                },
                "__type__": {
                  "object": {},
                  "string": {}
                }
              },
              "hover": {
                "border": {
                  "string": {}
                },
                "background": {
                  "string": {}
                },
                "__type__": {
                  "object": {},
                  "string": {}
                }
              },
              "__type__": {
                "object": {},
                "string": {}
              }
            },
            "fixed": {
              "x": {
                "boolean": {}
              },
              "y": {
                "boolean": {}
              },
              "__type__": {
                "object": {},
                "boolean": {}
              }
            },
            "font": {
              "color": {
                "string": {}
              },
              "size": {
                "number": {}
              },
              "face": {
                "string": {}
              },
              "background": {
                "string": {}
              },
              "strokeWidth": {
                "number": {}
              },
              "strokeColor": {
                "string": {}
              },
              "__type__": {
                "object": {},
                "string": {}
              }
            },
            "group": {
              "string": {},
              "number": {},
              "undefined": {}
            },
            "hidden": {
              "boolean": {}
            },
            "icon": {
              "face": {
                "string": {}
              },
              "code": {
                "string": {}
              },
              "size": {
                "number": {}
              },
              "color": {
                "string": {}
              },
              "__type__": {
                "object": {}
              }
            },
            "id": {
              "string": {},
              "number": {}
            },
            "image": {
              "string": {},
              "undefined": {}
            },
            "label": {
              "string": {},
              "undefined": {}
            },
            "labelHighlightBold": {
              "boolean": {}
            },
            "level": {
              "number": {},
              "undefined": {}
            },
            "mass": {
              "number": {}
            },
            "physics": {
              "boolean": {}
            },
            "scaling": {
              "min": {
                "number": {}
              },
              "max": {
                "number": {}
              },
              "label": {
                "enabled": {
                  "boolean": {}
                },
                "min": {
                  "number": {}
                },
                "max": {
                  "number": {}
                },
                "maxVisible": {
                  "number": {}
                },
                "drawThreshold": {
                  "number": {}
                },
                "__type__": {
                  "object": {},
                  "boolean": {}
                }
              },
              "customScalingFunction": {
                "function": {}
              },
              "__type__": {
                "object": {}
              }
            },
            "shadow": {
              "enabled": {
                "boolean": {}
              },
              "size": {
                "number": {}
              },
              "x": {
                "number": {}
              },
              "y": {
                "number": {}
              },
              "__type__": {
                "object": {},
                "boolean": {}
              }
            },
            "shape": {
              "string": {
                "0": {},
                "1": {},
                "2": {},
                "3": {},
                "4": {},
                "5": {},
                "6": {},
                "7": {},
                "8": {},
                "9": {},
                "10": {},
                "11": {},
                "12": {},
                "13": {}
              }
            },
            "shapeProperties": {
              "borderDashes": {
                "boolean": {},
                "array": {}
              },
              "borderRadius": {
                "number": {}
              },
              "useImageSize": {
                "boolean": {}
              },
              "useBorderWithImage": {
                "boolean": {}
              },
              "__type__": {
                "object": {}
              }
            },
            "size": {
              "number": {}
            },
            "title": {
              "string": {},
              "undefined": {}
            },
            "value": {
              "number": {},
              "undefined": {}
            },
            "x": {
              "number": {}
            },
            "y": {
              "number": {}
            },
            "__type__": {
              "object": {}
            }
          },
          "__type__": {
            "object": {}
          }
        },
        "interaction": {
          "dragNodes": {
            "boolean": {}
          },
          "dragView": {
            "boolean": {}
          },
          "hideEdgesOnDrag": {
            "boolean": {}
          },
          "hideNodesOnDrag": {
            "boolean": {}
          },
          "hover": {
            "boolean": {}
          },
          "keyboard": {
            "enabled": {
              "boolean": {}
            },
            "speed": {
              "x": {
                "number": {}
              },
              "y": {
                "number": {}
              },
              "zoom": {
                "number": {}
              },
              "__type__": {
                "object": {}
              }
            },
            "bindToWindow": {
              "boolean": {}
            },
            "__type__": {
              "object": {},
              "boolean": {}
            }
          },
          "multiselect": {
            "boolean": {}
          },
          "navigationButtons": {
            "boolean": {}
          },
          "selectable": {
            "boolean": {}
          },
          "selectConnectedEdges": {
            "boolean": {}
          },
          "hoverConnectedEdges": {
            "boolean": {}
          },
          "tooltipDelay": {
            "number": {}
          },
          "zoomView": {
            "boolean": {}
          },
          "__type__": {
            "object": {}
          }
        },
        "layout": {
          "randomSeed": {
            "undefined": {},
            "number": {}
          },
          "improvedLayout": {
            "boolean": {}
          },
          "hierarchical": {
            "enabled": {
              "boolean": {}
            },
            "levelSeparation": {
              "number": {}
            },
            "direction": {
              "string": {
                "0": {},
                "1": {},
                "2": {},
                "3": {}
              }
            },
            "sortMethod": {
              "string": {
                "0": {},
                "1": {}
              }
            },
            "__type__": {
              "object": {},
              "boolean": {}
            }
          },
          "__type__": {
            "object": {}
          }
        },
        "manipulation": {
          "enabled": {
            "boolean": {}
          },
          "initiallyActive": {
            "boolean": {}
          },
          "addNode": {
            "boolean": {},
            "function": {}
          },
          "addEdge": {
            "boolean": {},
            "function": {}
          },
          "editNode": {
            "function": {}
          },
          "editEdge": {
            "boolean": {},
            "function": {}
          },
          "deleteNode": {
            "boolean": {},
            "function": {}
          },
          "deleteEdge": {
            "boolean": {},
            "function": {}
          },
          "controlNodeStyle": {
            "borderWidth": {
              "number": {}
            },
            "borderWidthSelected": {
              "number": {},
              "undefined": {}
            },
            "brokenImage": {
              "string": {},
              "undefined": {}
            },
            "color": {
              "border": {
                "string": {}
              },
              "background": {
                "string": {}
              },
              "highlight": {
                "border": {
                  "string": {}
                },
                "background": {
                  "string": {}
                },
                "__type__": {
                  "object": {},
                  "string": {}
                }
              },
              "hover": {
                "border": {
                  "string": {}
                },
                "background": {
                  "string": {}
                },
                "__type__": {
                  "object": {},
                  "string": {}
                }
              },
              "__type__": {
                "object": {},
                "string": {}
              }
            },
            "fixed": {
              "x": {
                "boolean": {}
              },
              "y": {
                "boolean": {}
              },
              "__type__": {
                "object": {},
                "boolean": {}
              }
            },
            "font": {
              "color": {
                "string": {}
              },
              "size": {
                "number": {}
              },
              "face": {
                "string": {}
              },
              "background": {
                "string": {}
              },
              "strokeWidth": {
                "number": {}
              },
              "strokeColor": {
                "string": {}
              },
              "__type__": {
                "object": {},
                "string": {}
              }
            },
            "group": {
              "string": {},
              "number": {},
              "undefined": {}
            },
            "hidden": {
              "boolean": {}
            },
            "icon": {
              "face": {
                "string": {}
              },
              "code": {
                "string": {}
              },
              "size": {
                "number": {}
              },
              "color": {
                "string": {}
              },
              "__type__": {
                "object": {}
              }
            },
            "id": {
              "string": {},
              "number": {}
            },
            "image": {
              "string": {},
              "undefined": {}
            },
            "label": {
              "string": {},
              "undefined": {}
            },
            "labelHighlightBold": {
              "boolean": {}
            },
            "level": {
              "number": {},
              "undefined": {}
            },
            "mass": {
              "number": {}
            },
            "physics": {
              "boolean": {}
            },
            "scaling": {
              "min": {
                "number": {}
              },
              "max": {
                "number": {}
              },
              "label": {
                "enabled": {
                  "boolean": {}
                },
                "min": {
                  "number": {}
                },
                "max": {
                  "number": {}
                },
                "maxVisible": {
                  "number": {}
                },
                "drawThreshold": {
                  "number": {}
                },
                "__type__": {
                  "object": {},
                  "boolean": {}
                }
              },
              "customScalingFunction": {
                "function": {}
              },
              "__type__": {
                "object": {}
              }
            },
            "shadow": {
              "enabled": {
                "boolean": {}
              },
              "size": {
                "number": {}
              },
              "x": {
                "number": {}
              },
              "y": {
                "number": {}
              },
              "__type__": {
                "object": {},
                "boolean": {}
              }
            },
            "shape": {
              "string": {
                "0": {},
                "1": {},
                "2": {},
                "3": {},
                "4": {},
                "5": {},
                "6": {},
                "7": {},
                "8": {},
                "9": {},
                "10": {},
                "11": {},
                "12": {},
                "13": {}
              }
            },
            "shapeProperties": {
              "borderDashes": {
                "boolean": {},
                "array": {}
              },
              "borderRadius": {
                "number": {}
              },
              "useImageSize": {
                "boolean": {}
              },
              "useBorderWithImage": {
                "boolean": {}
              },
              "__type__": {
                "object": {}
              }
            },
            "size": {
              "number": {}
            },
            "title": {
              "string": {},
              "undefined": {}
            },
            "value": {
              "number": {},
              "undefined": {}
            },
            "x": {
              "number": {}
            },
            "y": {
              "number": {}
            },
            "__type__": {
              "object": {}
            }
          },
          "__type__": {
            "object": {},
            "boolean": {}
          }
        },
        "nodes": {
          "borderWidth": {
            "number": {}
          },
          "borderWidthSelected": {
            "number": {},
            "undefined": {}
          },
          "brokenImage": {
            "string": {},
            "undefined": {}
          },
          "color": {
            "border": {
              "string": {}
            },
            "background": {
              "string": {}
            },
            "highlight": {
              "border": {
                "string": {}
              },
              "background": {
                "string": {}
              },
              "__type__": {
                "object": {},
                "string": {}
              }
            },
            "hover": {
              "border": {
                "string": {}
              },
              "background": {
                "string": {}
              },
              "__type__": {
                "object": {},
                "string": {}
              }
            },
            "__type__": {
              "object": {},
              "string": {}
            }
          },
          "fixed": {
            "x": {
              "boolean": {}
            },
            "y": {
              "boolean": {}
            },
            "__type__": {
              "object": {},
              "boolean": {}
            }
          },
          "font": {
            "color": {
              "string": {}
            },
            "size": {
              "number": {}
            },
            "face": {
              "string": {}
            },
            "background": {
              "string": {}
            },
            "strokeWidth": {
              "number": {}
            },
            "strokeColor": {
              "string": {}
            },
            "__type__": {
              "object": {},
              "string": {}
            }
          },
          "group": {
            "string": {},
            "number": {},
            "undefined": {}
          },
          "hidden": {
            "boolean": {}
          },
          "icon": {
            "face": {
              "string": {}
            },
            "code": {
              "string": {}
            },
            "size": {
              "number": {}
            },
            "color": {
              "string": {}
            },
            "__type__": {
              "object": {}
            }
          },
          "id": {
            "string": {},
            "number": {}
          },
          "image": {
            "string": {},
            "undefined": {}
          },
          "label": {
            "string": {},
            "undefined": {}
          },
          "labelHighlightBold": {
            "boolean": {}
          },
          "level": {
            "number": {},
            "undefined": {}
          },
          "mass": {
            "number": {}
          },
          "physics": {
            "boolean": {}
          },
          "scaling": {
            "min": {
              "number": {}
            },
            "max": {
              "number": {}
            },
            "label": {
              "enabled": {
                "boolean": {}
              },
              "min": {
                "number": {}
              },
              "max": {
                "number": {}
              },
              "maxVisible": {
                "number": {}
              },
              "drawThreshold": {
                "number": {}
              },
              "__type__": {
                "object": {},
                "boolean": {}
              }
            },
            "customScalingFunction": {
              "function": {}
            },
            "__type__": {
              "object": {}
            }
          },
          "shadow": {
            "enabled": {
              "boolean": {}
            },
            "size": {
              "number": {}
            },
            "x": {
              "number": {}
            },
            "y": {
              "number": {}
            },
            "__type__": {
              "object": {},
              "boolean": {}
            }
          },
          "shape": {
            "string": {
              "0": {},
              "1": {},
              "2": {},
              "3": {},
              "4": {},
              "5": {},
              "6": {},
              "7": {},
              "8": {},
              "9": {},
              "10": {},
              "11": {},
              "12": {},
              "13": {}
            }
          },
          "shapeProperties": {
            "borderDashes": {
              "boolean": {},
              "array": {}
            },
            "borderRadius": {
              "number": {}
            },
            "useImageSize": {
              "boolean": {}
            },
            "useBorderWithImage": {
              "boolean": {}
            },
            "__type__": {
              "object": {}
            }
          },
          "size": {
            "number": {}
          },
          "title": {
            "string": {},
            "undefined": {}
          },
          "value": {
            "number": {},
            "undefined": {}
          },
          "x": {
            "number": {}
          },
          "y": {
            "number": {}
          },
          "__type__": {
            "object": {}
          }
        },
        "physics": {
          "enabled": {
            "boolean": {}
          },
          "barnesHut": {
            "gravitationalConstant": {
              "number": {}
            },
            "centralGravity": {
              "number": {}
            },
            "springLength": {
              "number": {}
            },
            "springConstant": {
              "number": {}
            },
            "damping": {
              "number": {}
            },
            "avoidOverlap": {
              "number": {}
            },
            "__type__": {
              "object": {}
            }
          },
          "forceAtlas2Based": {
            "gravitationalConstant": {
              "number": {}
            },
            "centralGravity": {
              "number": {}
            },
            "springLength": {
              "number": {}
            },
            "springConstant": {
              "number": {}
            },
            "damping": {
              "number": {}
            },
            "avoidOverlap": {
              "number": {}
            },
            "__type__": {
              "object": {}
            }
          },
          "repulsion": {
            "centralGravity": {
              "number": {}
            },
            "springLength": {
              "number": {}
            },
            "springConstant": {
              "number": {}
            },
            "nodeDistance": {
              "number": {}
            },
            "damping": {
              "number": {}
            },
            "__type__": {
              "object": {}
            }
          },
          "hierarchicalRepulsion": {
            "centralGravity": {
              "number": {}
            },
            "springLength": {
              "number": {}
            },
            "springConstant": {
              "number": {}
            },
            "nodeDistance": {
              "number": {}
            },
            "damping": {
              "number": {}
            },
            "__type__": {
              "object": {}
            }
          },
          "maxVelocity": {
            "number": {}
          },
          "minVelocity": {
            "number": {}
          },
          "solver": {
            "string": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            }
          },
          "stabilization": {
            "enabled": {
              "boolean": {}
            },
            "iterations": {
              "number": {}
            },
            "updateInterval": {
              "number": {}
            },
            "onlyDynamicEdges": {
              "boolean": {}
            },
            "fit": {
              "boolean": {}
            },
            "__type__": {
              "object": {},
              "boolean": {}
            }
          },
          "timestep": {
            "number": {}
          },
          "adaptiveTimestep": {
            "boolean": {}
          },
          "__type__": {
            "object": {},
            "boolean": {}
          }
        },
        "autoResize": {
          "boolean": {}
        },
        "clickToUse": {
          "boolean": {}
        },
        "locale": {
          "string": {}
        },
        "locales": {
          "__any__": {
            "any": {}
          },
          "__type__": {
            "object": {}
          }
        },
        "height": {
          "string": {}
        },
        "width": {
          "string": {}
        },
        "__type__": {
          "object": {}
        }
      },
      "configureOptions": {
        "nodes": {
          "borderWidth": {
            "0": {},
            "1": {},
            "2": {},
            "3": {}
          },
          "borderWidthSelected": {
            "0": {},
            "1": {},
            "2": {},
            "3": {}
          },
          "color": {
            "border": {
              "0": {},
              "1": {}
            },
            "background": {
              "0": {},
              "1": {}
            },
            "highlight": {
              "border": {
                "0": {},
                "1": {}
              },
              "background": {
                "0": {},
                "1": {}
              }
            },
            "hover": {
              "border": {
                "0": {},
                "1": {}
              },
              "background": {
                "0": {},
                "1": {}
              }
            }
          },
          "fixed": {
            "x": {},
            "y": {}
          },
          "font": {
            "color": {
              "0": {},
              "1": {}
            },
            "size": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            },
            "face": {
              "0": {},
              "1": {},
              "2": {}
            },
            "background": {
              "0": {},
              "1": {}
            },
            "strokeWidth": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            },
            "strokeColor": {
              "0": {},
              "1": {}
            }
          },
          "hidden": {},
          "labelHighlightBold": {},
          "physics": {},
          "scaling": {
            "min": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            },
            "max": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            },
            "label": {
              "enabled": {},
              "min": {
                "0": {},
                "1": {},
                "2": {},
                "3": {}
              },
              "max": {
                "0": {},
                "1": {},
                "2": {},
                "3": {}
              },
              "maxVisible": {
                "0": {},
                "1": {},
                "2": {},
                "3": {}
              },
              "drawThreshold": {
                "0": {},
                "1": {},
                "2": {},
                "3": {}
              }
            }
          },
          "shadow": {
            "enabled": {},
            "size": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            },
            "x": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            },
            "y": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            }
          },
          "shape": {
            "0": {},
            "1": {},
            "2": {},
            "3": {},
            "4": {},
            "5": {},
            "6": {},
            "7": {},
            "8": {},
            "9": {},
            "10": {}
          },
          "shapeProperties": {
            "borderDashes": {},
            "borderRadius": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            },
            "useImageSize": {}
          },
          "size": {
            "0": {},
            "1": {},
            "2": {},
            "3": {}
          }
        },
        "edges": {
          "arrows": {
            "to": {
              "enabled": {},
              "scaleFactor": {
                "0": {},
                "1": {},
                "2": {},
                "3": {}
              }
            },
            "middle": {
              "enabled": {},
              "scaleFactor": {
                "0": {},
                "1": {},
                "2": {},
                "3": {}
              }
            },
            "from": {
              "enabled": {},
              "scaleFactor": {
                "0": {},
                "1": {},
                "2": {},
                "3": {}
              }
            }
          },
          "color": {
            "color": {
              "0": {},
              "1": {}
            },
            "highlight": {
              "0": {},
              "1": {}
            },
            "hover": {
              "0": {},
              "1": {}
            },
            "inherit": {
              "0": {},
              "1": {},
              "2": {},
              "3": {},
              "4": {}
            },
            "opacity": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            }
          },
          "dashes": {},
          "font": {
            "color": {
              "0": {},
              "1": {}
            },
            "size": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            },
            "face": {
              "0": {},
              "1": {},
              "2": {}
            },
            "background": {
              "0": {},
              "1": {}
            },
            "strokeWidth": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            },
            "strokeColor": {
              "0": {},
              "1": {}
            },
            "align": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            }
          },
          "hidden": {},
          "hoverWidth": {
            "0": {},
            "1": {},
            "2": {},
            "3": {}
          },
          "labelHighlightBold": {},
          "physics": {},
          "scaling": {
            "min": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            },
            "max": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            },
            "label": {
              "enabled": {},
              "min": {
                "0": {},
                "1": {},
                "2": {},
                "3": {}
              },
              "max": {
                "0": {},
                "1": {},
                "2": {},
                "3": {}
              },
              "maxVisible": {
                "0": {},
                "1": {},
                "2": {},
                "3": {}
              },
              "drawThreshold": {
                "0": {},
                "1": {},
                "2": {},
                "3": {}
              }
            }
          },
          "selectionWidth": {
            "0": {},
            "1": {},
            "2": {},
            "3": {}
          },
          "selfReferenceSize": {
            "0": {},
            "1": {},
            "2": {},
            "3": {}
          },
          "shadow": {
            "enabled": {},
            "size": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            },
            "x": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            },
            "y": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            }
          },
          "smooth": {
            "enabled": {},
            "type": {
              "0": {},
              "1": {},
              "2": {},
              "3": {},
              "4": {},
              "5": {},
              "6": {},
              "7": {},
              "8": {},
              "9": {}
            },
            "forceDirection": {
              "0": {},
              "1": {},
              "2": {}
            },
            "roundness": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            }
          },
          "width": {
            "0": {},
            "1": {},
            "2": {},
            "3": {}
          }
        },
        "layout": {
          "hierarchical": {
            "enabled": {},
            "levelSeparation": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            },
            "direction": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            },
            "sortMethod": {
              "0": {},
              "1": {}
            }
          }
        },
        "interaction": {
          "dragNodes": {},
          "dragView": {},
          "hideEdgesOnDrag": {},
          "hideNodesOnDrag": {},
          "hover": {},
          "keyboard": {
            "enabled": {},
            "speed": {
              "x": {
                "0": {},
                "1": {},
                "2": {},
                "3": {}
              },
              "y": {
                "0": {},
                "1": {},
                "2": {},
                "3": {}
              },
              "zoom": {
                "0": {},
                "1": {},
                "2": {},
                "3": {}
              }
            },
            "bindToWindow": {}
          },
          "multiselect": {},
          "navigationButtons": {},
          "selectable": {},
          "selectConnectedEdges": {},
          "hoverConnectedEdges": {},
          "tooltipDelay": {
            "0": {},
            "1": {},
            "2": {},
            "3": {}
          },
          "zoomView": {}
        },
        "manipulation": {
          "enabled": {},
          "initiallyActive": {}
        },
        "physics": {
          "enabled": {},
          "barnesHut": {
            "gravitationalConstant": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            },
            "centralGravity": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            },
            "springLength": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            },
            "springConstant": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            },
            "damping": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            },
            "avoidOverlap": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            }
          },
          "forceAtlas2Based": {
            "gravitationalConstant": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            },
            "centralGravity": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            },
            "springLength": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            },
            "springConstant": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            },
            "damping": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            },
            "avoidOverlap": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            }
          },
          "repulsion": {
            "centralGravity": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            },
            "springLength": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            },
            "springConstant": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            },
            "nodeDistance": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            },
            "damping": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            }
          },
          "hierarchicalRepulsion": {
            "centralGravity": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            },
            "springLength": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            },
            "springConstant": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            },
            "nodeDistance": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            },
            "damping": {
              "0": {},
              "1": {},
              "2": {},
              "3": {}
            }
          },
          "maxVelocity": {
            "0": {},
            "1": {},
            "2": {},
            "3": {}
          },
          "minVelocity": {
            "0": {},
            "1": {},
            "2": {},
            "3": {}
          },
          "solver": {
            "0": {},
            "1": {},
            "2": {},
            "3": {}
          },
          "timestep": {
            "0": {},
            "1": {},
            "2": {},
            "3": {}
          }
        },
        "global": {
          "locale": {
            "0": {},
            "1": {}
          }
        }
      }
    },
    "convertDot": function () {},
    "convertGephi": function () {}
  },
  "moment": function () {},
  "Hammer": function () {},
  "keycharm": function () {}
}