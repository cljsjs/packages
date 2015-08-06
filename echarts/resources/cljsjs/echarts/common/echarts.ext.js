var zrender = {
    "version": {},
    "init": function () {},
    "dispose": function () {},
    "getInstance": function () {},
    "delInstance": function () {},
    "tool": {
        "color": {
            "customPalette": function () {},
            "resetPalette": function () {},
            "getColor": function () {},
            "getHighlightColor": function () {},
            "customHighlight": function () {},
            "resetHighlight": function () {},
            "getRadialGradient": function () {},
            "getLinearGradient": function () {},
            "getGradientColors": function () {},
            "getStepColors": function () {},
            "reverse": function () {},
            "mix": function () {},
            "lift": function () {},
            "trim": function () {},
            "random": function () {},
            "toRGB": function () {},
            "toRGBA": function () {},
            "toHex": function () {},
            "toHSL": function () {},
            "toHSLA": function () {},
            "toHSB": function () {},
            "toHSBA": function () {},
            "toHSV": function () {},
            "toHSVA": function () {},
            "toName": function () {},
            "toColor": function () {},
            "toArray": function () {},
            "alpha": function () {},
            "getData": function () {}
        },
        "math": {
            "sin": function () {},
            "cos": function () {},
            "degreeToRadian": function () {},
            "radianToDegree": function () {}
        },
        "util": {
            "inherits": function () {},
            "clone": function () {},
            "merge": function () {},
            "getContext": function () {},
            "indexOf": function () {},
            "each": function () {},
            "map": function () {},
            "filter": function () {},
            "bind": function () {}
        },
        "vector": {
            "create": function () {},
            "copy": function () {},
            "clone": function () {},
            "set": function () {},
            "add": function () {},
            "scaleAndAdd": function () {},
            "sub": function () {},
            "len": function () {},
            "lenSquare": function () {},
            "mul": function () {},
            "div": function () {},
            "dot": function () {},
            "scale": function () {},
            "normalize": function () {},
            "distance": function () {},
            "distanceSquare": function () {},
            "negate": function () {},
            "lerp": function () {},
            "applyTransform": function () {},
            "min": function () {},
            "max": function () {},
            "length": function () {},
            "lengthSquare": function () {},
            "dist": function () {},
            "distSquare": function () {}
        },
        "area": {
            "isInside": function () {},
            "isOutside": function () {},
            "getTextWidth": function () {},
            "getTextHeight": function () {},
            "isInsidePath": function () {},
            "isInsidePolygon": function () {},
            "isInsideSector": function () {},
            "isInsideCircle": function () {},
            "isInsideLine": function () {},
            "isInsideRect": function () {},
            "isInsidePolyline": function () {},
            "isInsideCubicStroke": function () {},
            "isInsideQuadraticStroke": function () {}
        },
        "event": {
            "getX": function () {},
            "getY": function () {},
            "getDelta": function () {},
            "stop": function () {},
            "Dispatcher": function () {}
        }
    },
    "animation": {
        "Animation": function () {},
        "Cip": function () {},
        "easing": {
            "Linear": function () {},
            "QuadraticIn": function () {},
            "QuadraticOut": function () {},
            "QuadraticInOut": function () {},
            "CubicIn": function () {},
            "CubicOut": function () {},
            "CubicInOut": function () {},
            "QuarticIn": function () {},
            "QuarticOut": function () {},
            "QuarticInOut": function () {},
            "QuinticIn": function () {},
            "QuinticOut": function () {},
            "QuinticInOut": function () {},
            "SinusoidalIn": function () {},
            "SinusoidalOut": function () {},
            "SinusoidalInOut": function () {},
            "ExponentialIn": function () {},
            "ExponentialOut": function () {},
            "ExponentialInOut": function () {},
            "CircularIn": function () {},
            "CircularOut": function () {},
            "CircularInOut": function () {},
            "ElasticIn": function () {},
            "ElasticOut": function () {},
            "ElasticInOut": function () {},
            "BackIn": function () {},
            "BackOut": function () {},
            "BackInOut": function () {},
            "BounceIn": function () {},
            "BounceOut": function () {},
            "BounceInOut": function () {}
        }
    }
}

var echarts = {
    "version": {},
    "dependencies": {
        "zrender": {}
    },
    "init": function () {},
    "getInstanceById": function () {},
    "config": {
        "CHART_TYPE_LINE": {},
        "CHART_TYPE_BAR": {},
        "CHART_TYPE_SCATTER": {},
        "CHART_TYPE_PIE": {},
        "CHART_TYPE_RADAR": {},
        "CHART_TYPE_VENN": {},
        "CHART_TYPE_TREEMAP": {},
        "CHART_TYPE_TREE": {},
        "CHART_TYPE_MAP": {},
        "CHART_TYPE_K": {},
        "CHART_TYPE_ISLAND": {},
        "CHART_TYPE_FORCE": {},
        "CHART_TYPE_CHORD": {},
        "CHART_TYPE_GAUGE": {},
        "CHART_TYPE_FUNNEL": {},
        "CHART_TYPE_EVENTRIVER": {},
        "CHART_TYPE_WORDCLOUD": {},
        "CHART_TYPE_HEATMAP": {},
        "COMPONENT_TYPE_TITLE": {},
        "COMPONENT_TYPE_LEGEND": {},
        "COMPONENT_TYPE_DATARANGE": {},
        "COMPONENT_TYPE_DATAVIEW": {},
        "COMPONENT_TYPE_DATAZOOM": {},
        "COMPONENT_TYPE_TOOLBOX": {},
        "COMPONENT_TYPE_TOOLTIP": {},
        "COMPONENT_TYPE_GRID": {},
        "COMPONENT_TYPE_AXIS": {},
        "COMPONENT_TYPE_POLAR": {},
        "COMPONENT_TYPE_X_AXIS": {},
        "COMPONENT_TYPE_Y_AXIS": {},
        "COMPONENT_TYPE_AXIS_CATEGORY": {},
        "COMPONENT_TYPE_AXIS_VALUE": {},
        "COMPONENT_TYPE_TIMELINE": {},
        "COMPONENT_TYPE_ROAMCONTROLLER": {},
        "backgroundColor": {},
        "color": {
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
            "13": {},
            "14": {},
            "15": {},
            "16": {},
            "17": {},
            "18": {},
            "19": {}
        },
        "markPoint": {
            "clickable": {},
            "symbol": {},
            "symbolSize": {},
            "large": {},
            "effect": {
                "show": {},
                "loop": {},
                "period": {},
                "type": {},
                "scaleSize": {},
                "bounceDistance": {}
            },
            "itemStyle": {
                "normal": {
                    "borderWidth": {},
                    "label": {
                        "show": {},
                        "position": {}
                    }
                },
                "emphasis": {
                    "label": {
                        "show": {}
                    }
                }
            }
        },
        "markLine": {
            "clickable": {},
            "symbol": {
                "0": {},
                "1": {}
            },
            "symbolSize": {
                "0": {},
                "1": {}
            },
            "smoothness": {},
            "precision": {},
            "effect": {
                "show": {},
                "loop": {},
                "period": {},
                "scaleSize": {}
            },
            "bundling": {
                "enable": {},
                "maxTurningAngle": {}
            },
            "itemStyle": {
                "normal": {
                    "borderWidth": {},
                    "label": {
                        "show": {},
                        "position": {}
                    },
                    "lineStyle": {
                        "type": {}
                    }
                },
                "emphasis": {
                    "label": {
                        "show": {}
                    },
                    "lineStyle": function () {}
                }
            }
        },
        "textStyle": {
            "decoration": {},
            "fontFamily": {},
            "fontFamily2": {},
            "fontSize": {},
            "fontStyle": {},
            "fontWeight": {}
        },
        "EVENT": {
            "REFRESH": {},
            "RESTORE": {},
            "RESIZE": {},
            "CLICK": {},
            "DBLCLICK": {},
            "HOVER": {},
            "MOUSEOUT": {},
            "DATA_CHANGED": {},
            "DATA_ZOOM": {},
            "DATA_RANGE": {},
            "DATA_RANGE_SELECTED": {},
            "DATA_RANGE_HOVERLINK": {},
            "LEGEND_SELECTED": {},
            "LEGEND_HOVERLINK": {},
            "MAP_SELECTED": {},
            "PIE_SELECTED": {},
            "MAGIC_TYPE_CHANGED": {},
            "DATA_VIEW_CHANGED": {},
            "TIMELINE_CHANGED": {},
            "MAP_ROAM": {},
            "FORCE_LAYOUT_END": {},
            "TOOLTIP_HOVER": {},
            "TOOLTIP_IN_GRID": {},
            "TOOLTIP_OUT_GRID": {},
            "ROAMCONTROLLER": {}
        },
        "DRAG_ENABLE_TIME": {},
        "EFFECT_ZLEVEL": {},
        "effectBlendAlpha": {},
        "symbolList": {
            "0": {},
            "1": {},
            "2": {},
            "3": {},
            "4": {},
            "5": {},
            "6": {},
            "7": {}
        },
        "loadingEffect": {},
        "loadingText": {},
        "noDataEffect": {},
        "noDataText": {},
        "calculable": {},
        "calculableColor": {},
        "calculableHolderColor": {},
        "nameConnector": {},
        "valueConnector": {},
        "animation": {},
        "addDataAnimation": {},
        "animationThreshold": {},
        "animationDuration": {},
        "animationDurationUpdate": {},
        "animationEasing": {},
        "grid": {
            "zlevel": {},
            "z": {},
            "x": {},
            "y": {},
            "x2": {},
            "y2": {},
            "backgroundColor": {},
            "borderWidth": {},
            "borderColor": {}
        },
        "dataZoom": {
            "zlevel": {},
            "z": {},
            "show": {},
            "orient": {},
            "backgroundColor": {},
            "dataBackgroundColor": {},
            "fillerColor": {},
            "handleColor": {},
            "handleSize": {},
            "showDetail": {},
            "realtime": {}
        },
        "line": {
            "zlevel": {},
            "z": {},
            "clickable": {},
            "legendHoverLink": {},
            "xAxisIndex": {},
            "yAxisIndex": {},
            "dataFilter": {},
            "itemStyle": {
                "normal": {
                    "label": {
                        "show": {}
                    },
                    "lineStyle": {
                        "width": {},
                        "type": {},
                        "shadowColor": {},
                        "shadowBlur": {},
                        "shadowOffsetX": {},
                        "shadowOffsetY": {}
                    }
                },
                "emphasis": {
                    "label": {
                        "show": {}
                    }
                }
            },
            "symbolSize": {},
            "showAllSymbol": {}
        },
        "bar": {
            "zlevel": {},
            "z": {},
            "clickable": {},
            "legendHoverLink": {},
            "xAxisIndex": {},
            "yAxisIndex": {},
            "barMinHeight": {},
            "barGap": {},
            "barCategoryGap": {},
            "itemStyle": {
                "normal": {
                    "barBorderColor": {},
                    "barBorderRadius": {},
                    "barBorderWidth": {},
                    "label": {
                        "show": {}
                    }
                },
                "emphasis": {
                    "barBorderColor": {},
                    "barBorderRadius": {},
                    "barBorderWidth": {},
                    "label": {
                        "show": {}
                    }
                }
            }
        },
        "dataRange": {
            "zlevel": {},
            "z": {},
            "show": {},
            "orient": {},
            "x": {},
            "y": {},
            "backgroundColor": {},
            "borderColor": {},
            "borderWidth": {},
            "padding": {},
            "itemGap": {},
            "itemWidth": {},
            "itemHeight": {},
            "precision": {},
            "splitNumber": {},
            "splitList": function () {},
            "calculable": {},
            "selectedMode": {},
            "hoverLink": {},
            "realtime": {},
            "color": {
                "0": {},
                "1": {}
            },
            "textStyle": {
                "color": {}
            }
        },
        "scatter": {
            "zlevel": {},
            "z": {},
            "clickable": {},
            "legendHoverLink": {},
            "xAxisIndex": {},
            "yAxisIndex": {},
            "symbolSize": {},
            "large": {},
            "largeThreshold": {},
            "itemStyle": {
                "normal": {
                    "label": {
                        "show": {}
                    }
                },
                "emphasis": {
                    "label": {
                        "show": {}
                    }
                }
            }
        },
        "k": {
            "zlevel": {},
            "z": {},
            "clickable": {},
            "hoverable": {},
            "legendHoverLink": {},
            "xAxisIndex": {},
            "yAxisIndex": {},
            "itemStyle": {
                "normal": {
                    "color": {},
                    "color0": {},
                    "lineStyle": {
                        "width": {},
                        "color": {},
                        "color0": {}
                    },
                    "label": {
                        "show": {}
                    }
                },
                "emphasis": {
                    "label": {
                        "show": {}
                    }
                }
            }
        },
        "pie": {
            "zlevel": {},
            "z": {},
            "clickable": {},
            "legendHoverLink": {},
            "center": {
                "0": {},
                "1": {}
            },
            "radius": {
                "0": {},
                "1": {}
            },
            "clockWise": {},
            "startAngle": {},
            "minAngle": {},
            "selectedOffset": {},
            "itemStyle": {
                "normal": {
                    "borderColor": {},
                    "borderWidth": {},
                    "label": {
                        "show": {},
                        "position": {}
                    },
                    "labelLine": {
                        "show": {},
                        "length": {},
                        "lineStyle": {
                            "width": {},
                            "type": {}
                        }
                    }
                },
                "emphasis": {
                    "borderColor": {},
                    "borderWidth": {},
                    "label": {
                        "show": {}
                    },
                    "labelLine": {
                        "show": {},
                        "length": {},
                        "lineStyle": {
                            "width": {},
                            "type": {}
                        }
                    }
                }
            }
        },
        "polar": {
            "zlevel": {},
            "z": {},
            "center": {
                "0": {},
                "1": {}
            },
            "radius": {},
            "startAngle": {},
            "boundaryGap": {
                "0": {},
                "1": {}
            },
            "splitNumber": {},
            "name": {
                "show": {},
                "textStyle": {
                    "color": {}
                }
            },
            "axisLine": {
                "show": {},
                "lineStyle": {
                    "color": {},
                    "width": {},
                    "type": {}
                }
            },
            "axisLabel": {
                "show": {},
                "textStyle": {
                    "color": {}
                }
            },
            "splitArea": {
                "show": {},
                "areaStyle": {
                    "color": {
                        "0": {},
                        "1": {}
                    }
                }
            },
            "splitLine": {
                "show": {},
                "lineStyle": {
                    "width": {},
                    "color": {}
                }
            },
            "type": {}
        },
        "radar": {
            "zlevel": {},
            "z": {},
            "clickable": {},
            "legendHoverLink": {},
            "polarIndex": {},
            "itemStyle": {
                "normal": {
                    "label": {
                        "show": {}
                    },
                    "lineStyle": {
                        "width": {},
                        "type": {}
                    }
                },
                "emphasis": {
                    "label": {
                        "show": {}
                    }
                }
            },
            "symbolSize": {}
        },
        "chord": {
            "zlevel": {},
            "z": {},
            "clickable": {},
            "radius": {
                "0": {},
                "1": {}
            },
            "center": {
                "0": {},
                "1": {}
            },
            "padding": {},
            "sort": {},
            "sortSub": {},
            "startAngle": {},
            "clockWise": {},
            "ribbonType": {},
            "minRadius": {},
            "maxRadius": {},
            "symbol": {},
            "showScale": {},
            "showScaleText": {},
            "itemStyle": {
                "normal": {
                    "borderWidth": {},
                    "borderColor": {},
                    "label": {
                        "show": {},
                        "rotate": {},
                        "distance": {}
                    },
                    "chordStyle": {
                        "width": {},
                        "color": {},
                        "borderWidth": {},
                        "borderColor": {},
                        "opacity": {}
                    }
                },
                "emphasis": {
                    "borderWidth": {},
                    "borderColor": {},
                    "chordStyle": {
                        "width": {},
                        "color": {},
                        "borderWidth": {},
                        "borderColor": {}
                    }
                }
            }
        },
        "force": {
            "zlevel": {},
            "z": {},
            "center": {
                "0": {},
                "1": {}
            },
            "size": {},
            "preventOverlap": {},
            "coolDown": {},
            "minRadius": {},
            "maxRadius": {},
            "ratioScaling": {},
            "large": {},
            "useWorker": {},
            "steps": {},
            "scaling": {},
            "gravity": {},
            "symbol": {},
            "symbolSize": {},
            "linkSymbol": function () {},
            "linkSymbolSize": {
                "0": {},
                "1": {}
            },
            "draggable": {},
            "clickable": {},
            "roam": {},
            "itemStyle": {
                "normal": {
                    "label": {
                        "show": {},
                        "position": {}
                    },
                    "nodeStyle": {
                        "brushType": {},
                        "borderColor": {},
                        "borderWidth": {}
                    },
                    "linkStyle": {
                        "color": {},
                        "width": {},
                        "type": {}
                    }
                },
                "emphasis": {
                    "label": {
                        "show": {}
                    },
                    "nodeStyle": function () {},
                    "linkStyle": {
                        "opacity": {}
                    }
                }
            }
        },
        "roamController": {
            "zlevel": {},
            "z": {},
            "show": {},
            "x": {},
            "y": {},
            "width": {},
            "height": {},
            "backgroundColor": {},
            "borderColor": {},
            "borderWidth": {},
            "padding": {},
            "handleColor": {},
            "fillerColor": {},
            "step": {},
            "mapTypeControl": function () {}
        },
        "map": {
            "zlevel": {},
            "z": {},
            "mapType": {},
            "showLegendSymbol": {},
            "dataRangeHoverLink": {},
            "hoverable": {},
            "clickable": {},
            "itemStyle": {
                "normal": {
                    "borderColor": {},
                    "borderWidth": {},
                    "areaStyle": {
                        "color": {}
                    },
                    "label": {
                        "show": {},
                        "textStyle": {
                            "color": {}
                        }
                    }
                },
                "emphasis": {
                    "borderColor": {},
                    "borderWidth": {},
                    "areaStyle": {
                        "color": {}
                    },
                    "label": {
                        "show": {},
                        "textStyle": {
                            "color": {}
                        }
                    }
                }
            }
        },
        "gauge": {
            "zlevel": {},
            "z": {},
            "center": {
                "0": {},
                "1": {}
            },
            "clickable": {},
            "legendHoverLink": {},
            "radius": {},
            "startAngle": {},
            "endAngle": {},
            "min": {},
            "max": {},
            "splitNumber": {},
            "axisLine": {
                "show": {},
                "lineStyle": {
                    "color": {
                        "0": {
                            "0": {},
                            "1": {}
                        },
                        "1": {
                            "0": {},
                            "1": {}
                        },
                        "2": {
                            "0": {},
                            "1": {}
                        }
                    },
                    "width": {}
                }
            },
            "axisTick": {
                "show": {},
                "splitNumber": {},
                "length": {},
                "lineStyle": {
                    "color": {},
                    "width": {},
                    "type": {}
                }
            },
            "axisLabel": {
                "show": {},
                "textStyle": {
                    "color": {}
                }
            },
            "splitLine": {
                "show": {},
                "length": {},
                "lineStyle": {
                    "color": {},
                    "width": {},
                    "type": {}
                }
            },
            "pointer": {
                "show": {},
                "length": {},
                "width": {},
                "color": {}
            },
            "title": {
                "show": {},
                "offsetCenter": {
                    "0": {},
                    "1": {}
                },
                "textStyle": {
                    "color": {},
                    "fontSize": {}
                }
            },
            "detail": {
                "show": {},
                "backgroundColor": {},
                "borderWidth": {},
                "borderColor": {},
                "width": {},
                "height": {},
                "offsetCenter": {
                    "0": {},
                    "1": {}
                },
                "textStyle": {
                    "color": {},
                    "fontSize": {}
                }
            }
        },
        "funnel": {
            "zlevel": {},
            "z": {},
            "clickable": {},
            "legendHoverLink": {},
            "x": {},
            "y": {},
            "x2": {},
            "y2": {},
            "min": {},
            "max": {},
            "minSize": {},
            "maxSize": {},
            "sort": {},
            "gap": {},
            "funnelAlign": {},
            "itemStyle": {
                "normal": {
                    "borderColor": {},
                    "borderWidth": {},
                    "label": {
                        "show": {},
                        "position": {}
                    },
                    "labelLine": {
                        "show": {},
                        "length": {},
                        "lineStyle": {
                            "width": {},
                            "type": {}
                        }
                    }
                },
                "emphasis": {
                    "borderColor": {},
                    "borderWidth": {},
                    "label": {
                        "show": {}
                    },
                    "labelLine": {
                        "show": {}
                    }
                }
            }
        },
        "eventRiver": {
            "zlevel": {},
            "z": {},
            "clickable": {},
            "legendHoverLink": {},
            "itemStyle": {
                "normal": {
                    "borderColor": {},
                    "borderWidth": {},
                    "label": {
                        "show": {},
                        "position": {},
                        "formatter": {}
                    }
                },
                "emphasis": {
                    "borderColor": {},
                    "borderWidth": {},
                    "label": {
                        "show": {}
                    }
                }
            }
        },
        "venn": {
            "zlevel": {},
            "z": {},
            "calculable": {}
        },
        "treemap": {
            "zlevel": {},
            "z": {},
            "calculable": {},
            "clickable": {},
            "center": {
                "0": {},
                "1": {}
            },
            "size": {
                "0": {},
                "1": {}
            },
            "root": {},
            "itemStyle": {
                "normal": {
                    "label": {
                        "show": {},
                        "x": {},
                        "y": {},
                        "textStyle": {
                            "align": {},
                            "color": {},
                            "fontFamily": {},
                            "fontSize": {},
                            "fontStyle": {},
                            "fontWeight": {}
                        }
                    },
                    "breadcrumb": {
                        "show": {},
                        "textStyle": function () {}
                    },
                    "borderWidth": {},
                    "borderColor": {},
                    "childBorderWidth": {},
                    "childBorderColor": {}
                },
                "emphasis": function () {}
            }
        },
        "tree": {
            "zlevel": {},
            "z": {},
            "calculable": {},
            "clickable": {},
            "rootLocation": function () {},
            "orient": {},
            "symbol": {},
            "symbolSize": {},
            "nodePadding": {},
            "layerPadding": {},
            "itemStyle": {
                "normal": {
                    "label": {
                        "show": {}
                    },
                    "lineStyle": {
                        "width": {},
                        "color": {},
                        "type": {}
                    }
                },
                "emphasis": function () {}
            }
        },
        "wordCloud": {
            "zlevel": {},
            "z": {},
            "clickable": {},
            "center": {
                "0": {},
                "1": {}
            },
            "size": {
                "0": {},
                "1": {}
            },
            "textRotation": {
                "0": {},
                "1": {}
            },
            "textPadding": {},
            "autoSize": {
                "enable": {},
                "minSize": {}
            },
            "itemStyle": {
                "normal": {
                    "textStyle": {
                        "fontSize": function () {}
                    }
                }
            }
        },
        "heatmap": {
            "zlevel": {},
            "z": {},
            "clickable": {}
        }
    },
    "util": {
        "mapData": {
            "params": {
                "decode": function () {},
                "params": {
                    "none": {
                        "getGeoJson": function () {}
                    },
                    "world": {
                        "getGeoJson": function () {}
                    },
                    "china": {
                        "getGeoJson": function () {}
                    },
                    "南海诸岛": {
                        "textCoord": {
                            "0": {},
                            "1": {}
                        },
                        "getPath": function () {}
                    },
                    "新疆": {
                        "getGeoJson": function () {}
                    },
                    "西藏": {
                        "getGeoJson": function () {}
                    },
                    "内蒙古": {
                        "getGeoJson": function () {}
                    },
                    "青海": {
                        "getGeoJson": function () {}
                    },
                    "四川": {
                        "getGeoJson": function () {}
                    },
                    "黑龙江": {
                        "getGeoJson": function () {}
                    },
                    "甘肃": {
                        "getGeoJson": function () {}
                    },
                    "云南": {
                        "getGeoJson": function () {}
                    },
                    "广西": {
                        "getGeoJson": function () {}
                    },
                    "湖南": {
                        "getGeoJson": function () {}
                    },
                    "陕西": {
                        "getGeoJson": function () {}
                    },
                    "广东": {
                        "getGeoJson": function () {}
                    },
                    "吉林": {
                        "getGeoJson": function () {}
                    },
                    "河北": {
                        "getGeoJson": function () {}
                    },
                    "湖北": {
                        "getGeoJson": function () {}
                    },
                    "贵州": {
                        "getGeoJson": function () {}
                    },
                    "山东": {
                        "getGeoJson": function () {}
                    },
                    "江西": {
                        "getGeoJson": function () {}
                    },
                    "河南": {
                        "getGeoJson": function () {}
                    },
                    "辽宁": {
                        "getGeoJson": function () {}
                    },
                    "山西": {
                        "getGeoJson": function () {}
                    },
                    "安徽": {
                        "getGeoJson": function () {}
                    },
                    "福建": {
                        "getGeoJson": function () {}
                    },
                    "浙江": {
                        "getGeoJson": function () {}
                    },
                    "江苏": {
                        "getGeoJson": function () {}
                    },
                    "重庆": {
                        "getGeoJson": function () {}
                    },
                    "宁夏": {
                        "getGeoJson": function () {}
                    },
                    "海南": {
                        "getGeoJson": function () {}
                    },
                    "台湾": {
                        "getGeoJson": function () {}
                    },
                    "北京": {
                        "getGeoJson": function () {}
                    },
                    "天津": {
                        "getGeoJson": function () {}
                    },
                    "上海": {
                        "getGeoJson": function () {}
                    },
                    "香港": {
                        "getGeoJson": function () {}
                    },
                    "澳门": {
                        "getGeoJson": function () {}
                    }
                }
            }
        }
    }
}

function MessageCenter() {}
function Echarts(dom) {}

Echarts.prototype.restore = function() {};
Echarts.prototype.refresh = function(param) {};
Echarts.prototype.setOption = function(option, notMerge) {};
Echarts.prototype.getOption = function() {};
Echarts.prototype.setSeries = function(series, notMerge) {};
Echarts.prototype.getSeries = function() {};
Echarts.prototype.addData = function(seriesIdx, data, isHead, dataGrow, additionData) {};
Echarts.prototype.addMarkPoint = function(seriesIdx, markData) {};
Echarts.prototype.addMarkLine = function(seriesIdx, markData) {};
Echarts.prototype.delMarkPoint = function(seriesIdx, markName) {};
Echarts.prototype.delMarkLine = function(seriesIdx, markName) {};
Echarts.prototype.getDom = function() {};
Echarts.prototype.getZrender = function() {};
Echarts.prototype.getDataURL = function(imgType) {};
Echarts.prototype.getImage = function(imgType) {};
Echarts.prototype.getConnectedDataURL = function(imgType) {};
Echarts.prototype.getConnectedImage = function(imgType) {};
Echarts.prototype.on = function(eventName, eventListener) {};
Echarts.prototype.un = function(eventName, eventListener) {};
Echarts.prototype.connect = function(connectTarget) {};
Echarts.prototype.disConnect = function(connectTarget) {};
Echarts.prototype.connectedEventHandler = function(param) {};
Echarts.prototype.isConnected = function() {};
Echarts.prototype.showLoading = function(loadingOption) {};
Echarts.prototype.hideLoading = function() {};
Echarts.prototype.setTheme = function(theme) {};
Echarts.prototype.resize = function() {};
Echarts.prototype.clear = function() {};
Echarts.prototype.dispose = function() {};
