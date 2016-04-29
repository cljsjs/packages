// Please use https://github.com/jmmk/javascript-externs-generator
// to generate the externs


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
    "getAbsoluteRight": function () {},
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
    "insertSort": function () {},
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
    "resetElements": function () {},
    "getSVGElement": function () {},
    "getDOMElement": function () {},
    "drawPoint": function () {},
    "drawBar": function () {}
  },
  "DataSet": function () {},
  "DataView": function () {},
  "Queue": {
    "extend": function () {}
  },
  "Graph3d": {
    "STYLE": {
      "BAR": {},
      "BARCOLOR": {},
      "BARSIZE": {},
      "DOT": {},
      "DOTLINE": {},
      "DOTCOLOR": {},
      "DOTSIZE": {},
      "GRID": {},
      "LINE": {},
      "SURFACE": {}
    }
  },
  "graph3d": {
    "Camera": function () {},
    "Filter": function () {},
    "Point2d": function () {},
    "Point3d": {
      "subtract": function () {},
      "add": function () {},
      "avg": function () {},
      "crossProduct": function () {}
    },
    "Slider": function () {},
    "StepNumber": {
      "calculatePrettyStep": function () {}
    }
  },
  "moment": {
    "momentProperties": {},
    "suppressDeprecationWarnings": {},
    "deprecationHandler": {},
    "createFromInputFallback": function () {},
    "parseTwoDigitYear": function () {},
    "ISO_8601": function () {},
    "updateOffset": function () {},
    "defaultFormat": {},
    "defaultFormatUtc": {},
    "lang": function () {},
    "langData": function () {},
    "version": {},
    "fn": {},
    "min": function () {},
    "max": function () {},
    "now": function () {},
    "utc": function () {},
    "unix": function () {},
    "months": function () {},
    "isDate": function () {},
    "locale": function () {},
    "invalid": function () {},
    "duration": {
      "fn": {}
    },
    "isMoment": function () {},
    "weekdays": function () {},
    "parseZone": function () {},
    "localeData": function () {},
    "isDuration": function () {},
    "monthsShort": function () {},
    "weekdaysMin": function () {},
    "defineLocale": function () {},
    "updateLocale": function () {},
    "locales": function () {},
    "weekdaysShort": function () {},
    "normalizeUnits": function () {},
    "relativeTimeThreshold": function () {}
  },
  "Hammer": {
    "VERSION": {},
    "defaults": {
      "domEvents": {},
      "touchAction": {},
      "enable": {},
      "inputTarget": {},
      "inputClass": {},
      "preset": {},
      "cssProps": {
        "userSelect": {},
        "touchSelect": {},
        "touchCallout": {},
        "contentZooming": {},
        "userDrag": {},
        "tapHighlightColor": {}
      }
    },
    "INPUT_START": {},
    "INPUT_MOVE": {},
    "INPUT_END": {},
    "INPUT_CANCEL": {},
    "STATE_POSSIBLE": {},
    "STATE_BEGAN": {},
    "STATE_CHANGED": {},
    "STATE_ENDED": {},
    "STATE_RECOGNIZED": {},
    "STATE_CANCELLED": {},
    "STATE_FAILED": {},
    "DIRECTION_NONE": {},
    "DIRECTION_LEFT": {},
    "DIRECTION_RIGHT": {},
    "DIRECTION_UP": {},
    "DIRECTION_DOWN": {},
    "DIRECTION_HORIZONTAL": {},
    "DIRECTION_VERTICAL": {},
    "DIRECTION_ALL": {},
    "Manager": function () {},
    "Input": function () {},
    "TouchAction": function () {},
    "TouchInput": function () {},
    "MouseInput": function () {},
    "PointerEventInput": function () {},
    "TouchMouseInput": function () {},
    "SingleTouchInput": function () {},
    "Recognizer": function () {},
    "AttrRecognizer": function () {},
    "Tap": function () {},
    "Pan": function () {},
    "Swipe": function () {},
    "Pinch": function () {},
    "Rotate": function () {},
    "Press": function () {},
    "on": function () {},
    "off": function () {},
    "each": function () {},
    "merge": function () {},
    "extend": function () {},
    "assign": function () {},
    "inherit": function () {},
    "bindFn": function () {},
    "prefixed": function () {}
  },
  "keycharm": function () {},
  "Timeline": function () {},
  "Graph2d": function () {},
  "timeline": {
    "Core": function () {},
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
    "Range": {
      "conversion": function () {}
    },
    "stack": {
      "orderByStart": function () {},
      "orderByEnd": function () {},
      "stack": function () {},
      "nostack": function () {},
      "collision": function () {}
    },
    "TimeStep": {
      "FORMAT": {
        "minorLabels": {
          "millisecond": {},
          "second": {},
          "minute": {},
          "hour": {},
          "weekday": {},
          "day": {},
          "month": {},
          "year": {}
        },
        "majorLabels": {
          "millisecond": {},
          "second": {},
          "minute": {},
          "hour": {},
          "weekday": {},
          "day": {},
          "month": {},
          "year": {}
        }
      },
      "snap": function () {}
    },
    "components": {
      "items": {
        "Item": function () {},
        "BackgroundItem": function () {},
        "BoxItem": function () {},
        "PointItem": function () {},
        "RangeItem": function () {}
      },
      "BackgroundGroup": function () {},
      "Component": function () {},
      "CurrentTime": function () {},
      "CustomTime": {
        "customTimeFromTarget": function () {}
      },
      "DataAxis": function () {},
      "DataScale": function () {},
      "GraphGroup": function () {},
      "Group": function () {},
      "ItemSet": {
        "types": {
          "background": function () {},
          "box": function () {},
          "range": function () {},
          "point": function () {}
        },
        "_getItemRange": function () {},
        "itemSetFromTarget": function () {}
      },
      "Legend": function () {},
      "LineGraph": function () {},
      "TimeAxis": function () {}
    }
  },
  "Network": function () {},
  "network": {
    "Images": {
      "default": function () {}
    },
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
              "string": {},
              "object": {}
            }
          },
          "arrowStrikethrough": {
            "boolean": {}
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
              "string": {},
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
              "string": {}
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
            "color": {
              "string": {}
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
              "string": {}
            },
            "roundness": {
              "number": {}
            },
            "forceDirection": {
              "string": {},
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
              "align": {
                "string": {}
              },
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
              "color": {
                "string": {}
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
              "string": {}
            },
            "shapeProperties": {
              "borderDashes": {
                "boolean": {},
                "array": {}
              },
              "borderRadius": {
                "number": {}
              },
              "interpolation": {
                "boolean": {}
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
            "nodeSpacing": {
              "number": {}
            },
            "treeSpacing": {
              "number": {}
            },
            "blockShifting": {
              "boolean": {}
            },
            "edgeMinimization": {
              "boolean": {}
            },
            "parentCentralization": {
              "boolean": {}
            },
            "direction": {
              "string": {}
            },
            "sortMethod": {
              "string": {}
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
              "align": {
                "string": {}
              },
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
              "color": {
                "string": {}
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
              "string": {}
            },
            "shapeProperties": {
              "borderDashes": {
                "boolean": {},
                "array": {}
              },
              "borderRadius": {
                "number": {}
              },
              "interpolation": {
                "boolean": {}
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
            "align": {
              "string": {}
            },
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
            "color": {
              "string": {}
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
            "string": {}
          },
          "shapeProperties": {
            "borderDashes": {
              "boolean": {},
              "array": {}
            },
            "borderRadius": {
              "number": {}
            },
            "interpolation": {
              "boolean": {}
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
            "string": {}
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
          "borderWidth": {},
          "borderWidthSelected": {},
          "color": {
            "border": {},
            "background": {},
            "highlight": {
              "border": {},
              "background": {}
            },
            "hover": {
              "border": {},
              "background": {}
            }
          },
          "fixed": {
            "x": {},
            "y": {}
          },
          "font": {
            "color": {},
            "size": {},
            "face": {},
            "background": {},
            "strokeWidth": {},
            "strokeColor": {}
          },
          "hidden": {},
          "labelHighlightBold": {},
          "physics": {},
          "scaling": {
            "min": {},
            "max": {},
            "label": {
              "enabled": {},
              "min": {},
              "max": {},
              "maxVisible": {},
              "drawThreshold": {}
            }
          },
          "shadow": {
            "enabled": {},
            "color": {},
            "size": {},
            "x": {},
            "y": {}
          },
          "shape": {},
          "shapeProperties": {
            "borderDashes": {},
            "borderRadius": {},
            "interpolation": {},
            "useImageSize": {}
          },
          "size": {}
        },
        "edges": {
          "arrows": {
            "to": {
              "enabled": {},
              "scaleFactor": {}
            },
            "middle": {
              "enabled": {},
              "scaleFactor": {}
            },
            "from": {
              "enabled": {},
              "scaleFactor": {}
            }
          },
          "arrowStrikethrough": {},
          "color": {
            "color": {},
            "highlight": {},
            "hover": {},
            "inherit": {},
            "opacity": {}
          },
          "dashes": {},
          "font": {
            "color": {},
            "size": {},
            "face": {},
            "background": {},
            "strokeWidth": {},
            "strokeColor": {},
            "align": {}
          },
          "hidden": {},
          "hoverWidth": {},
          "labelHighlightBold": {},
          "physics": {},
          "scaling": {
            "min": {},
            "max": {},
            "label": {
              "enabled": {},
              "min": {},
              "max": {},
              "maxVisible": {},
              "drawThreshold": {}
            }
          },
          "selectionWidth": {},
          "selfReferenceSize": {},
          "shadow": {
            "enabled": {},
            "color": {},
            "size": {},
            "x": {},
            "y": {}
          },
          "smooth": {
            "enabled": {},
            "type": {},
            "forceDirection": {},
            "roundness": {}
          },
          "width": {}
        },
        "layout": {
          "hierarchical": {
            "enabled": {},
            "levelSeparation": {},
            "nodeSpacing": {},
            "treeSpacing": {},
            "blockShifting": {},
            "edgeMinimization": {},
            "parentCentralization": {},
            "direction": {},
            "sortMethod": {}
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
              "x": {},
              "y": {},
              "zoom": {}
            },
            "bindToWindow": {}
          },
          "multiselect": {},
          "navigationButtons": {},
          "selectable": {},
          "selectConnectedEdges": {},
          "hoverConnectedEdges": {},
          "tooltipDelay": {},
          "zoomView": {}
        },
        "manipulation": {
          "enabled": {},
          "initiallyActive": {}
        },
        "physics": {
          "enabled": {},
          "barnesHut": {
            "gravitationalConstant": {},
            "centralGravity": {},
            "springLength": {},
            "springConstant": {},
            "damping": {},
            "avoidOverlap": {}
          },
          "forceAtlas2Based": {
            "gravitationalConstant": {},
            "centralGravity": {},
            "springLength": {},
            "springConstant": {},
            "damping": {},
            "avoidOverlap": {}
          },
          "repulsion": {
            "centralGravity": {},
            "springLength": {},
            "springConstant": {},
            "nodeDistance": {},
            "damping": {}
          },
          "hierarchicalRepulsion": {
            "centralGravity": {},
            "springLength": {},
            "springConstant": {},
            "nodeDistance": {},
            "damping": {}
          },
          "maxVelocity": {},
          "minVelocity": {},
          "solver": {},
          "timestep": {}
        },
        "global": {
          "locale": {}
        }
      }
    },
    "convertDot": function () {},
    "convertGephi": function () {}
  }
};
vis.DataSet.prototype = {
  "setOptions": function () {},
  "on": function () {},
  "subscribe": function () {},
  "off": function () {},
  "unsubscribe": function () {},
  "_trigger": function () {},
  "add": function () {},
  "update": function () {},
  "get": function () {},
  "getIds": function () {},
  "getDataSet": function () {},
  "forEach": function () {},
  "map": function () {},
  "_filterFields": function () {},
  "_sort": function () {},
  "remove": function () {},
  "_remove": function () {},
  "clear": function () {},
  "max": function () {},
  "min": function () {},
  "distinct": function () {},
  "_addItem": function () {},
  "_getItem": function () {},
  "_updateItem": function () {}
};
vis.DataView.prototype = {
  "setData": function () {},
  "refresh": function () {},
  "get": function () {},
  "getIds": function () {},
  "map": function () {},
  "getDataSet": function () {},
  "_onEvent": function () {},
  "on": function () {},
  "off": function () {},
  "_trigger": function () {},
  "subscribe": function () {},
  "unsubscribe": function () {}
};
vis.Queue.prototype = {
  "setOptions": function () {},
  "destroy": function () {},
  "replace": function () {},
  "queue": function () {},
  "_flushIfNeeded": function () {},
  "flush": function () {}
};
vis.Graph3d.prototype = {
  "addEventListener": function () {},
  "on": function () {},
  "once": function () {},
  "removeEventListener": function () {},
  "removeAllListeners": function () {},
  "removeListener": function () {},
  "off": function () {},
  "emit": function () {},
  "listeners": function () {},
  "hasListeners": function () {},
  "_setScale": function () {},
  "_convert3Dto2D": function () {},
  "_convertPointToTranslation": function () {},
  "_convertTranslationToScreen": function () {},
  "_setBackgroundColor": function () {},
  "_getStyleNumber": function () {},
  "_determineColumnIndexes": function () {},
  "getNumberOfRows": function () {},
  "getNumberOfColumns": function () {},
  "getDistinctValues": function () {},
  "getColumnRange": function () {},
  "_dataInitialize": function () {},
  "_getDataPoints": function () {},
  "create": function () {},
  "setSize": function () {},
  "_resizeCanvas": function () {},
  "animationStart": function () {},
  "animationStop": function () {},
  "_resizeCenter": function () {},
  "setCameraPosition": function () {},
  "getCameraPosition": function () {},
  "_readData": function () {},
  "setData": function () {},
  "setOptions": function () {},
  "redraw": function () {},
  "_redrawClear": function () {},
  "_redrawLegend": function () {},
  "_redrawFilter": function () {},
  "_redrawSlider": function () {},
  "_redrawInfo": function () {},
  "_redrawAxis": function () {},
  "_hsv2rgb": function () {},
  "_redrawDataGrid": function () {},
  "_getStrokeWidth": function () {},
  "_redrawDataDot": function () {},
  "_redrawDataBar": function () {},
  "_redrawDataLine": function () {},
  "_onMouseDown": function () {},
  "_onMouseMove": function () {},
  "_onMouseUp": function () {},
  "_onTooltip": function () {},
  "_onTouchStart": function () {},
  "_onTouchMove": function () {},
  "_onTouchEnd": function () {},
  "_onWheel": function () {},
  "_insideTriangle": function () {},
  "_dataPointFromXY": function () {},
  "_showTooltip": function () {},
  "_hideTooltip": function () {}
};
vis.graph3d.Camera.prototype = {
  "setArmLocation": function () {},
  "setArmRotation": function () {},
  "getArmRotation": function () {},
  "setArmLength": function () {},
  "getArmLength": function () {},
  "getCameraLocation": function () {},
  "getCameraRotation": function () {},
  "calculateCameraOrientation": function () {}
};
vis.graph3d.Filter.prototype = {
  "isLoaded": function () {},
  "getLoadedProgress": function () {},
  "getLabel": function () {},
  "getColumn": function () {},
  "getSelectedValue": function () {},
  "getValues": function () {},
  "getValue": function () {},
  "_getDataPoints": function () {},
  "setOnLoadCallback": function () {},
  "selectValue": function () {},
  "loadInBackground": function () {}
};
vis.graph3d.Point3d.prototype = {
  "length": function () {}
};
vis.graph3d.Slider.prototype = {
  "prev": function () {},
  "next": function () {},
  "playNext": function () {},
  "togglePlay": function () {},
  "play": function () {},
  "stop": function () {},
  "setOnChangeCallback": function () {},
  "setPlayInterval": function () {},
  "getPlayInterval": function () {},
  "setPlayLoop": function () {},
  "onChange": function () {},
  "redraw": function () {},
  "setValues": function () {},
  "setIndex": function () {},
  "getIndex": function () {},
  "get": function () {},
  "_onMouseDown": function () {},
  "leftToIndex": function () {},
  "indexToLeft": function () {},
  "_onMouseMove": function () {},
  "_onMouseUp": function () {}
};
vis.graph3d.StepNumber.prototype = {
  "setRange": function () {},
  "setStep": function () {},
  "getCurrent": function () {},
  "getStep": function () {},
  "start": function () {},
  "next": function () {},
  "end": function () {}
};
vis.moment.prototype = {
  "add": function () {},
  "calendar": function () {},
  "clone": function () {},
  "diff": function () {},
  "endOf": function () {},
  "format": function () {},
  "from": function () {},
  "fromNow": function () {},
  "to": function () {},
  "toNow": function () {},
  "get": function () {},
  "invalidAt": function () {},
  "isAfter": function () {},
  "isBefore": function () {},
  "isBetween": function () {},
  "isSame": function () {},
  "isSameOrAfter": function () {},
  "isSameOrBefore": function () {},
  "isValid": function () {},
  "lang": function () {},
  "locale": function () {},
  "localeData": function () {},
  "max": function () {},
  "min": function () {},
  "parsingFlags": function () {},
  "set": function () {},
  "startOf": function () {},
  "subtract": function () {},
  "toArray": function () {},
  "toObject": function () {},
  "toDate": function () {},
  "toISOString": function () {},
  "toJSON": function () {},
  "toString": function () {},
  "unix": function () {},
  "valueOf": function () {},
  "creationData": function () {},
  "year": function () {},
  "isLeapYear": function () {},
  "weekYear": function () {},
  "isoWeekYear": function () {},
  "quarters": function () {},
  "quarter": function () {},
  "month": function () {},
  "daysInMonth": function () {},
  "weeks": function () {},
  "week": function () {},
  "isoWeeks": function () {},
  "isoWeek": function () {},
  "weeksInYear": function () {},
  "isoWeeksInYear": function () {},
  "date": function () {},
  "days": function () {},
  "day": function () {},
  "weekday": function () {},
  "isoWeekday": function () {},
  "dayOfYear": function () {},
  "hours": function () {},
  "hour": function () {},
  "minutes": function () {},
  "minute": function () {},
  "seconds": function () {},
  "second": function () {},
  "milliseconds": function () {},
  "millisecond": function () {},
  "utcOffset": function () {},
  "utc": function () {},
  "local": function () {},
  "parseZone": function () {},
  "hasAlignedHourOffset": function () {},
  "isDST": function () {},
  "isDSTShifted": function () {},
  "isLocal": function () {},
  "isUtcOffset": function () {},
  "isUtc": function () {},
  "isUTC": function () {},
  "zoneAbbr": function () {},
  "zoneName": function () {},
  "dates": function () {},
  "months": function () {},
  "years": function () {},
  "zone": function () {}
};
vis.Hammer.Input.prototype = {
  "handler": function () {},
  "init": function () {},
  "destroy": function () {}
};
vis.Hammer.TouchAction.prototype = {
  "set": function () {},
  "update": function () {},
  "compute": function () {},
  "preventDefaults": function () {},
  "preventSrc": function () {}
};
vis.Hammer.TouchInput.prototype = {
  "constructor": function () {},
  "_super": function () {},
  "handler": function () {}
};
vis.Hammer.MouseInput.prototype = {
  "constructor": function () {},
  "_super": function () {},
  "handler": function () {}
};
vis.Hammer.PointerEventInput.prototype = {
  "constructor": function () {},
  "_super": function () {},
  "handler": function () {}
};
vis.Hammer.TouchMouseInput.prototype = {
  "constructor": function () {},
  "_super": function () {},
  "handler": function () {},
  "destroy": function () {}
};
vis.Hammer.SingleTouchInput.prototype = {
  "constructor": function () {},
  "_super": function () {},
  "handler": function () {}
};
vis.Hammer.Recognizer.prototype = {
  "defaults": function () {},
  "set": function () {},
  "recognizeWith": function () {},
  "dropRecognizeWith": function () {},
  "requireFailure": function () {},
  "dropRequireFailure": function () {},
  "hasRequireFailures": function () {},
  "canRecognizeWith": function () {},
  "emit": function () {},
  "tryEmit": function () {},
  "canEmit": function () {},
  "recognize": function () {},
  "process": function () {},
  "getTouchAction": function () {},
  "reset": function () {}
};
vis.Hammer.AttrRecognizer.prototype = {
  "constructor": function () {},
  "_super": function () {},
  "defaults": function () {},
  "attrTest": function () {},
  "process": function () {}
};
vis.Hammer.Tap.prototype = {
  "constructor": function () {},
  "_super": function () {},
  "defaults": function () {},
  "getTouchAction": function () {},
  "process": function () {},
  "failTimeout": function () {},
  "reset": function () {},
  "emit": function () {}
};
vis.Hammer.Pan.prototype = {
  "constructor": function () {},
  "_super": function () {},
  "defaults": function () {},
  "getTouchAction": function () {},
  "directionTest": function () {},
  "attrTest": function () {},
  "emit": function () {}
};
vis.Hammer.Swipe.prototype = {
  "constructor": function () {},
  "_super": function () {},
  "defaults": function () {},
  "getTouchAction": function () {},
  "attrTest": function () {},
  "emit": function () {}
};
vis.Hammer.Pinch.prototype = {
  "constructor": function () {},
  "_super": function () {},
  "defaults": function () {},
  "getTouchAction": function () {},
  "attrTest": function () {},
  "emit": function () {}
};
vis.Hammer.Rotate.prototype = {
  "constructor": function () {},
  "_super": function () {},
  "defaults": function () {},
  "getTouchAction": function () {},
  "attrTest": function () {}
};
vis.Hammer.Press.prototype = {
  "constructor": function () {},
  "_super": function () {},
  "defaults": function () {},
  "getTouchAction": function () {},
  "process": function () {},
  "reset": function () {},
  "emit": function () {}
};
vis.Timeline.prototype = {
  "_createConfigurator": function () {},
  "redraw": function () {},
  "setOptions": function () {},
  "setItems": function () {},
  "setGroups": function () {},
  "setData": function () {},
  "setSelection": function () {},
  "getSelection": function () {},
  "focus": function () {},
  "fit": function () {},
  "getItemRange": function () {},
  "getDataRange": function () {},
  "getEventProperties": function () {}
};
vis.Graph2d.prototype = {
  "setOptions": function () {},
  "setItems": function () {},
  "setGroups": function () {},
  "getLegend": function () {},
  "isGroupVisible": function () {},
  "getDataRange": function () {},
  "getEventProperties": function () {},
  "_createConfigurator": function () {}
};
vis.timeline.Core.prototype = {
  "addEventListener": function () {},
  "on": function () {},
  "once": function () {},
  "removeEventListener": function () {},
  "removeAllListeners": function () {},
  "removeListener": function () {},
  "off": function () {},
  "emit": function () {},
  "listeners": function () {},
  "hasListeners": function () {},
  "_create": function () {},
  "setOptions": function () {},
  "isActive": function () {},
  "destroy": function () {},
  "setCustomTime": function () {},
  "getCustomTime": function () {},
  "setCustomTimeTitle": function () {},
  "getEventProperties": function () {},
  "addCustomTime": function () {},
  "removeCustomTime": function () {},
  "getVisibleItems": function () {},
  "fit": function () {},
  "getDataRange": function () {},
  "setWindow": function () {},
  "moveTo": function () {},
  "getWindow": function () {},
  "redraw": function () {},
  "_redraw": function () {},
  "repaint": function () {},
  "setCurrentTime": function () {},
  "getCurrentTime": function () {},
  "_toTime": function () {},
  "_toGlobalTime": function () {},
  "_toScreen": function () {},
  "_toGlobalScreen": function () {},
  "_initAutoResize": function () {},
  "_startAutoResize": function () {},
  "_stopAutoResize": function () {},
  "_onTouch": function () {},
  "_onPinch": function () {},
  "_onDrag": function () {},
  "_setScrollTop": function () {},
  "_updateScrollTop": function () {},
  "_getScrollTop": function () {},
  "_createConfigurator": function () {}
};
vis.timeline.Range.prototype = {
  "options": function () {},
  "props": function () {},
  "setOptions": function () {},
  "setRange": function () {},
  "_cancelAnimation": function () {},
  "_applyRange": function () {},
  "getRange": function () {},
  "conversion": function () {},
  "_onDragStart": function () {},
  "_onDrag": function () {},
  "_onDragEnd": function () {},
  "_onMouseWheel": function () {},
  "_onTouch": function () {},
  "_onPinch": function () {},
  "_isInsideRange": function () {},
  "_pointerToDate": function () {},
  "getPointer": function () {},
  "zoom": function () {},
  "move": function () {},
  "moveTo": function () {}
};
vis.timeline.TimeStep.prototype = {
  "setMoment": function () {},
  "setFormat": function () {},
  "setRange": function () {},
  "start": function () {},
  "roundToMinor": function () {},
  "hasNext": function () {},
  "next": function () {},
  "getCurrent": function () {},
  "setScale": function () {},
  "setAutoScale": function () {},
  "setMinimumStep": function () {},
  "isMajor": function () {},
  "getLabelMinor": function () {},
  "getLabelMajor": function () {},
  "getClassName": function () {}
};
vis.timeline.components.items.Item.prototype = {
  "stack": function () {},
  "select": function () {},
  "unselect": function () {},
  "setData": function () {},
  "setParent": function () {},
  "isVisible": function () {},
  "show": function () {},
  "hide": function () {},
  "redraw": function () {},
  "repositionX": function () {},
  "repositionY": function () {},
  "_repaintDeleteButton": function () {},
  "_updateContents": function () {},
  "_updateTitle": function () {},
  "_updateDataAttributes": function () {},
  "_updateStyle": function () {},
  "_contentToString": function () {},
  "getWidthLeft": function () {},
  "getWidthRight": function () {}
};
vis.timeline.components.items.BackgroundItem.prototype = {
  "id": function () {},
  "parent": function () {},
  "data": function () {},
  "dom": function () {},
  "conversion": function () {},
  "options": function () {},
  "selected": function () {},
  "displayed": function () {},
  "dirty": function () {},
  "top": function () {},
  "right": function () {},
  "left": function () {},
  "width": function () {},
  "height": function () {},
  "editable": function () {},
  "baseClassName": function () {},
  "stack": function () {},
  "isVisible": function () {},
  "redraw": function () {},
  "show": function () {},
  "hide": function () {},
  "repositionX": function () {},
  "repositionY": function () {}
};
vis.timeline.components.items.BoxItem.prototype = {
  "id": function () {},
  "parent": function () {},
  "data": function () {},
  "dom": function () {},
  "conversion": function () {},
  "options": function () {},
  "selected": function () {},
  "displayed": function () {},
  "dirty": function () {},
  "top": function () {},
  "right": function () {},
  "left": function () {},
  "width": function () {},
  "height": function () {},
  "editable": function () {},
  "isVisible": function () {},
  "redraw": function () {},
  "show": function () {},
  "hide": function () {},
  "repositionX": function () {},
  "repositionY": function () {},
  "getWidthLeft": function () {},
  "getWidthRight": function () {}
};
vis.timeline.components.items.PointItem.prototype = {
  "id": function () {},
  "parent": function () {},
  "data": function () {},
  "dom": function () {},
  "conversion": function () {},
  "options": function () {},
  "selected": function () {},
  "displayed": function () {},
  "dirty": function () {},
  "top": function () {},
  "right": function () {},
  "left": function () {},
  "width": function () {},
  "height": function () {},
  "editable": function () {},
  "isVisible": function () {},
  "redraw": function () {},
  "show": function () {},
  "hide": function () {},
  "repositionX": function () {},
  "repositionY": function () {},
  "getWidthLeft": function () {},
  "getWidthRight": function () {}
};
vis.timeline.components.items.RangeItem.prototype = {
  "id": function () {},
  "parent": function () {},
  "data": function () {},
  "dom": function () {},
  "conversion": function () {},
  "options": function () {},
  "selected": function () {},
  "displayed": function () {},
  "dirty": function () {},
  "top": function () {},
  "right": function () {},
  "left": function () {},
  "width": function () {},
  "height": function () {},
  "editable": function () {},
  "baseClassName": function () {},
  "isVisible": function () {},
  "redraw": function () {},
  "show": function () {},
  "hide": function () {},
  "repositionX": function () {},
  "repositionY": function () {},
  "_repaintDragLeft": function () {},
  "_repaintDragRight": function () {}
};
vis.timeline.components.BackgroundGroup.prototype = {
  "redraw": function () {},
  "show": function () {}
};
vis.timeline.components.Component.prototype = {
  "setOptions": function () {},
  "redraw": function () {},
  "destroy": function () {},
  "_isResized": function () {}
};
vis.timeline.components.CurrentTime.prototype = {
  "options": function () {},
  "props": function () {},
  "_create": function () {},
  "destroy": function () {},
  "setOptions": function () {},
  "redraw": function () {},
  "start": function () {},
  "stop": function () {},
  "setCurrentTime": function () {},
  "getCurrentTime": function () {}
};
vis.timeline.components.CustomTime.prototype = {
  "options": function () {},
  "props": function () {},
  "setOptions": function () {},
  "_create": function () {},
  "destroy": function () {},
  "redraw": function () {},
  "hide": function () {},
  "setCustomTime": function () {},
  "getCustomTime": function () {},
  "setCustomTitle": function () {},
  "_onDragStart": function () {},
  "_onDrag": function () {},
  "_onDragEnd": function () {}
};
vis.timeline.components.DataAxis.prototype = {
  "options": function () {},
  "props": function () {},
  "addGroup": function () {},
  "updateGroup": function () {},
  "removeGroup": function () {},
  "setOptions": function () {},
  "_create": function () {},
  "_redrawGroupIcons": function () {},
  "_cleanupIcons": function () {},
  "show": function () {},
  "hide": function () {},
  "setRange": function () {},
  "redraw": function () {},
  "_redrawLabels": function () {},
  "convertValue": function () {},
  "screenToValue": function () {},
  "_redrawLabel": function () {},
  "_redrawLine": function () {},
  "_redrawTitle": function () {},
  "_calculateCharSize": function () {}
};
vis.timeline.components.DataScale.prototype = {
  "setCharHeight": function () {},
  "setHeight": function () {},
  "determineScale": function () {},
  "is_major": function () {},
  "getStep": function () {},
  "getFirstMajor": function () {},
  "formatValue": function () {},
  "getLines": function () {},
  "followScale": function () {},
  "convertValue": function () {},
  "screenToValue": function () {}
};
vis.timeline.components.GraphGroup.prototype = {
  "setItems": function () {},
  "getItems": function () {},
  "setZeroPosition": function () {},
  "setOptions": function () {},
  "update": function () {},
  "getLegend": function () {},
  "getYRange": function () {}
};
vis.timeline.components.Group.prototype = {
  "_create": function () {},
  "setData": function () {},
  "getLabelWidth": function () {},
  "redraw": function () {},
  "_calculateSubGroupHeights": function () {},
  "_calculateHeight": function () {},
  "show": function () {},
  "hide": function () {},
  "add": function () {},
  "orderSubgroups": function () {},
  "resetSubgroups": function () {},
  "remove": function () {},
  "removeFromDataSet": function () {},
  "order": function () {},
  "_updateVisibleItems": function () {},
  "_traceVisible": function () {},
  "_checkIfVisible": function () {},
  "_checkIfVisibleWithReference": function () {}
};
vis.timeline.components.ItemSet.prototype = {
  "options": function () {},
  "props": function () {},
  "_create": function () {},
  "setOptions": function () {},
  "markDirty": function () {},
  "destroy": function () {},
  "hide": function () {},
  "show": function () {},
  "setSelection": function () {},
  "getSelection": function () {},
  "getVisibleItems": function () {},
  "_deselect": function () {},
  "redraw": function () {},
  "_firstGroup": function () {},
  "_updateUngrouped": function () {},
  "getLabelSet": function () {},
  "setItems": function () {},
  "getItems": function () {},
  "setGroups": function () {},
  "getGroups": function () {},
  "removeItem": function () {},
  "_getType": function () {},
  "_getGroupId": function () {},
  "_onUpdate": function () {},
  "_onAdd": function () {},
  "_onRemove": function () {},
  "_order": function () {},
  "_onUpdateGroups": function () {},
  "_onAddGroups": function () {},
  "_onRemoveGroups": function () {},
  "_orderGroups": function () {},
  "_addItem": function () {},
  "_updateItem": function () {},
  "_removeItem": function () {},
  "_constructByEndArray": function () {},
  "_onTouch": function () {},
  "_getGroupIndex": function () {},
  "_onDragStart": function () {},
  "_onDragStartAddItem": function () {},
  "_onDrag": function () {},
  "_moveToGroup": function () {},
  "_onDragEnd": function () {},
  "_onGroupDragStart": function () {},
  "_onGroupDrag": function () {},
  "_onGroupDragEnd": function () {},
  "_onSelectItem": function () {},
  "_onAddItem": function () {},
  "_onMultiSelectItem": function () {},
  "itemFromTarget": function () {},
  "groupFromTarget": function () {},
  "_cloneItemData": function () {}
};
vis.timeline.components.ItemSet.types.background.prototype = {
  "id": function () {},
  "parent": function () {},
  "data": function () {},
  "dom": function () {},
  "conversion": function () {},
  "options": function () {},
  "selected": function () {},
  "displayed": function () {},
  "dirty": function () {},
  "top": function () {},
  "right": function () {},
  "left": function () {},
  "width": function () {},
  "height": function () {},
  "editable": function () {},
  "baseClassName": function () {},
  "stack": function () {},
  "isVisible": function () {},
  "redraw": function () {},
  "show": function () {},
  "hide": function () {},
  "repositionX": function () {},
  "repositionY": function () {}
};
vis.timeline.components.ItemSet.types.box.prototype = {
  "id": function () {},
  "parent": function () {},
  "data": function () {},
  "dom": function () {},
  "conversion": function () {},
  "options": function () {},
  "selected": function () {},
  "displayed": function () {},
  "dirty": function () {},
  "top": function () {},
  "right": function () {},
  "left": function () {},
  "width": function () {},
  "height": function () {},
  "editable": function () {},
  "isVisible": function () {},
  "redraw": function () {},
  "show": function () {},
  "hide": function () {},
  "repositionX": function () {},
  "repositionY": function () {},
  "getWidthLeft": function () {},
  "getWidthRight": function () {}
};
vis.timeline.components.ItemSet.types.range.prototype = {
  "id": function () {},
  "parent": function () {},
  "data": function () {},
  "dom": function () {},
  "conversion": function () {},
  "options": function () {},
  "selected": function () {},
  "displayed": function () {},
  "dirty": function () {},
  "top": function () {},
  "right": function () {},
  "left": function () {},
  "width": function () {},
  "height": function () {},
  "editable": function () {},
  "baseClassName": function () {},
  "isVisible": function () {},
  "redraw": function () {},
  "show": function () {},
  "hide": function () {},
  "repositionX": function () {},
  "repositionY": function () {},
  "_repaintDragLeft": function () {},
  "_repaintDragRight": function () {}
};
vis.timeline.components.ItemSet.types.point.prototype = {
  "id": function () {},
  "parent": function () {},
  "data": function () {},
  "dom": function () {},
  "conversion": function () {},
  "options": function () {},
  "selected": function () {},
  "displayed": function () {},
  "dirty": function () {},
  "top": function () {},
  "right": function () {},
  "left": function () {},
  "width": function () {},
  "height": function () {},
  "editable": function () {},
  "isVisible": function () {},
  "redraw": function () {},
  "show": function () {},
  "hide": function () {},
  "repositionX": function () {},
  "repositionY": function () {},
  "getWidthLeft": function () {},
  "getWidthRight": function () {}
};
vis.timeline.components.Legend.prototype = {
  "options": function () {},
  "props": function () {},
  "clear": function () {},
  "addGroup": function () {},
  "updateGroup": function () {},
  "removeGroup": function () {},
  "_create": function () {},
  "hide": function () {},
  "show": function () {},
  "setOptions": function () {},
  "redraw": function () {},
  "drawLegendIcons": function () {}
};
vis.timeline.components.LineGraph.prototype = {
  "options": function () {},
  "props": function () {},
  "_create": function () {},
  "setOptions": function () {},
  "hide": function () {},
  "show": function () {},
  "setItems": function () {},
  "setGroups": function () {},
  "_onUpdate": function () {},
  "_onAdd": function () {},
  "_onRemove": function () {},
  "_onUpdateGroups": function () {},
  "_onAddGroups": function () {},
  "_onRemoveGroups": function () {},
  "_removeGroup": function () {},
  "_updateGroup": function () {},
  "_updateAllGroupData": function () {},
  "redraw": function () {},
  "_getSortedGroupIds": function () {},
  "_updateGraph": function () {},
  "_stack": function () {},
  "_getRelevantData": function () {},
  "_applySampling": function () {},
  "_getYRanges": function () {},
  "_updateYAxis": function () {},
  "_toggleAxisVisiblity": function () {},
  "_convertXcoordinates": function () {},
  "_convertYcoordinates": function () {}
};
vis.timeline.components.TimeAxis.prototype = {
  "options": function () {},
  "props": function () {},
  "setOptions": function () {},
  "_create": function () {},
  "destroy": function () {},
  "redraw": function () {},
  "_repaintLabels": function () {},
  "_repaintMinorText": function () {},
  "_repaintMajorText": function () {},
  "_repaintMinorLine": function () {},
  "_repaintMajorLine": function () {},
  "_calculateCharSize": function () {}
};
vis.Network.prototype = {
  "addEventListener": function () {},
  "on": function () {},
  "once": function () {},
  "removeEventListener": function () {},
  "removeAllListeners": function () {},
  "removeListener": function () {},
  "off": function () {},
  "emit": function () {},
  "listeners": function () {},
  "hasListeners": function () {},
  "setOptions": function () {},
  "_updateVisibleIndices": function () {},
  "bindEventListeners": function () {},
  "setData": function () {},
  "destroy": function () {},
  "_updateValueRange": function () {},
  "isActive": function () {},
  "setSize": function () {},
  "canvasToDOM": function () {},
  "DOMtoCanvas": function () {},
  "findNode": function () {},
  "isCluster": function () {},
  "openCluster": function () {},
  "cluster": function () {},
  "getNodesInCluster": function () {},
  "clusterByConnection": function () {},
  "clusterByHubsize": function () {},
  "clusterOutliers": function () {},
  "getSeed": function () {},
  "enableEditMode": function () {},
  "disableEditMode": function () {},
  "addNodeMode": function () {},
  "editNode": function () {},
  "editNodeMode": function () {},
  "addEdgeMode": function () {},
  "editEdgeMode": function () {},
  "deleteSelected": function () {},
  "getPositions": function () {},
  "storePositions": function () {},
  "moveNode": function () {},
  "getBoundingBox": function () {},
  "getConnectedNodes": function () {},
  "getConnectedEdges": function () {},
  "startSimulation": function () {},
  "stopSimulation": function () {},
  "stabilize": function () {},
  "getSelection": function () {},
  "setSelection": function () {},
  "getSelectedNodes": function () {},
  "getSelectedEdges": function () {},
  "getNodeAt": function () {},
  "getEdgeAt": function () {},
  "selectNodes": function () {},
  "selectEdges": function () {},
  "unselectAll": function () {},
  "redraw": function () {},
  "getScale": function () {},
  "getViewPosition": function () {},
  "fit": function () {},
  "moveTo": function () {},
  "focus": function () {},
  "releaseNode": function () {},
  "getOptionsFromConfigurator": function () {}
};