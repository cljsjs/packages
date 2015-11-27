var Dygraph = {
    "NAME": {},
    "VERSION": {},
    "__repr__": function () {},
    "toString": function () {},
    "DEFAULT_ROLL_PERIOD": {},
    "DEFAULT_WIDTH": {},
    "DEFAULT_HEIGHT": {},
    "ANIMATION_STEPS": {},
    "ANIMATION_DURATION": {},
    "KMB_LABELS": {
        "0": {},
        "1": {},
        "2": {},
        "3": {},
        "4": {}
    },
    "KMG2_BIG_LABELS": {
        "0": {},
        "1": {},
        "2": {},
        "3": {},
        "4": {},
        "5": {},
        "6": {},
        "7": {}
    },
    "KMG2_SMALL_LABELS": {
        "0": {},
        "1": {},
        "2": {},
        "3": {},
        "4": {},
        "5": {},
        "6": {},
        "7": {}
    },
    "numberValueFormatter": function () {},
    "numberAxisLabelFormatter": function () {},
    "SHORT_MONTH_NAMES_": {
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
        "11": {}
    },
    "dateAxisLabelFormatter": function () {},
    "dateAxisFormatter": function () {},
    "dateValueFormatter": function () {},
    "Plotters": {
        "linePlotter": function () {},
        "fillPlotter": function () {},
        "errorPlotter": function () {}
    },
    "DEFAULT_ATTRS": {
        "highlightCircleSize": {},
        "highlightSeriesOpts": function () {},
        "highlightSeriesBackgroundAlpha": {},
        "labelsDivWidth": {},
        "labelsDivStyles": function () {},
        "labelsSeparateLines": {},
        "labelsShowZeroValues": {},
        "labelsKMB": {},
        "labelsKMG2": {},
        "showLabelsOnHighlight": {},
        "digitsAfterDecimal": {},
        "maxNumberWidth": {},
        "sigFigs": function () {},
        "strokeWidth": {},
        "strokeBorderWidth": {},
        "strokeBorderColor": {},
        "axisTickSize": {},
        "axisLabelFontSize": {},
        "rightGap": {},
        "showRoller": {},
        "xValueParser": {},
        "delimiter": {},
        "sigma": {},
        "errorBars": {},
        "fractions": {},
        "wilsonInterval": {},
        "customBars": {},
        "fillGraph": {},
        "fillAlpha": {},
        "connectSeparatedPoints": {},
        "stackedGraph": {},
        "stackedGraphNaNFill": {},
        "hideOverlayOnMouseOut": {},
        "legend": {},
        "stepPlot": {},
        "avoidMinZero": {},
        "xRangePad": {},
        "yRangePad": function () {},
        "drawAxesAtZero": {},
        "titleHeight": {},
        "xLabelHeight": {},
        "yLabelWidth": {},
        "drawXAxis": {},
        "drawYAxis": {},
        "axisLineColor": {},
        "axisLineWidth": {},
        "gridLineWidth": {},
        "axisLabelColor": {},
        "axisLabelWidth": {},
        "drawYGrid": {},
        "drawXGrid": {},
        "gridLineColor": {},
        "interactionModel": {
            "mousedown": function () {},
            "willDestroyContextMyself": {},
            "touchstart": function () {},
            "touchmove": function () {},
            "touchend": function () {},
            "dblclick": function () {}
        },
        "animatedZooms": {},
        "showRangeSelector": {},
        "rangeSelectorHeight": {},
        "rangeSelectorPlotStrokeColor": {},
        "rangeSelectorPlotFillColor": {},
        "showInRangeSelector": function () {},
        "plotter": {
            "0": function () {},
            "1": function () {},
            "2": function () {}
        },
        "plugins": function () {},
        "axes": {
            "x": {
                "pixelsPerLabel": {},
                "axisLabelWidth": {},
                "axisLabelFormatter": function () {},
                "valueFormatter": function () {},
                "drawGrid": {},
                "drawAxis": {},
                "independentTicks": {},
                "ticker": function () {}
            },
            "y": {
                "axisLabelWidth": {},
                "pixelsPerLabel": {},
                "valueFormatter": function () {},
                "axisLabelFormatter": function () {},
                "drawGrid": {},
                "drawAxis": {},
                "independentTicks": {},
                "ticker": function () {}
            },
            "y2": {
                "axisLabelWidth": {},
                "pixelsPerLabel": {},
                "valueFormatter": function () {},
                "axisLabelFormatter": function () {},
                "drawAxis": {},
                "drawGrid": {},
                "independentTicks": {},
                "ticker": function () {}
            }
        }
    },
    "HORIZONTAL": {},
    "VERTICAL": {},
    "PLUGINS": {
        "0": function () {},
        "1": function () {},
        "2": function () {},
        "3": function () {},
        "4": function () {},
        "5": function () {}
    },
    "addedAnnotationCSS": {},
    "zoomAnimationFunction": function () {},
    "PointType": {},
    "stackPoints_": function () {},
    "mapLegacyOptions_": function () {},
    "addAnnotationRule": function () {},
    "LOG_SCALE": {},
    "LN_TEN": {},
    "log10": function () {},
    "DOTTED_LINE": {
        "0": {},
        "1": {}
    },
    "DASHED_LINE": {
        "0": {},
        "1": {}
    },
    "DOT_DASH_LINE": {
        "0": {},
        "1": {},
        "2": {},
        "3": {}
    },
    "getContext": function () {},
    "addEvent": function () {},
    "removeEvent": function () {},
    "cancelEvent": function () {},
    "hsvToRGB": function () {},
    "findPos": function () {},
    "pageX": function () {},
    "pageY": function () {},
    "dragGetX_": function () {},
    "dragGetY_": function () {},
    "isOK": function () {},
    "isValidPoint": function () {},
    "floatFormat": function () {},
    "zeropad": function () {},
    "DateAccessorsLocal": {
        "getFullYear": function () {},
        "getMonth": function () {},
        "getDate": function () {},
        "getHours": function () {},
        "getMinutes": function () {},
        "getSeconds": function () {},
        "getMilliseconds": function () {},
        "getDay": function () {},
        "makeDate": function () {}
    },
    "DateAccessorsUTC": {
        "getFullYear": function () {},
        "getMonth": function () {},
        "getDate": function () {},
        "getHours": function () {},
        "getMinutes": function () {},
        "getSeconds": function () {},
        "getMilliseconds": function () {},
        "getDay": function () {},
        "makeDate": function () {}
    },
    "hmsString_": function () {},
    "dateString_": function () {},
    "round_": function () {},
    "binarySearch": function () {},
    "dateParser": function () {},
    "dateStrToMillis": function () {},
    "update": function () {},
    "updateDeep": function () {},
    "isArrayLike": function () {},
    "isDateLike": function () {},
    "clone": function () {},
    "createCanvas": function () {},
    "getContextPixelRatio": function () {},
    "isAndroid": function () {},
    "Iterator": function () {},
    "createIterator": function () {},
    "requestAnimFrame": function () {},
    "repeatAndCleanup": function () {},
    "isPixelChangingOptionList": function () {},
    "Circles": {
        "DEFAULT": function () {}
    },
    "IFrameTarp": function () {},
    "detectLineDelimiter": function () {},
    "isNodeContainedBy": function () {},
    "pow": function () {},
    "toRGB_": function () {},
    "isCanvasSupported": function () {},
    "parseFloat_": function () {},
    "GVizChart": function () {},
    "Interaction": {
        "maybeTreatMouseOpAsClick": function () {},
        "startPan": function () {},
        "movePan": function () {},
        "endPan": function () {},
        "startZoom": function () {},
        "moveZoom": function () {},
        "treatMouseOpAsClick": function () {},
        "endZoom": function () {},
        "startTouch": function () {},
        "moveTouch": function () {},
        "endTouch": function () {},
        "defaultModel": {
            "mousedown": function () {},
            "willDestroyContextMyself": {},
            "touchstart": function () {},
            "touchmove": function () {},
            "touchend": function () {},
            "dblclick": function () {}
        },
        "nonInteractiveModel_": {
            "mousedown": function () {},
            "mouseup": function () {}
        },
        "dragIsPanInteractionModel": {
            "mousedown": function () {},
            "mousemove": function () {},
            "mouseup": function () {}
        }
    },
    "defaultInteractionModel": {
        "mousedown": function () {},
        "willDestroyContextMyself": {},
        "touchstart": function () {},
        "touchmove": function () {},
        "touchend": function () {},
        "dblclick": function () {}
    },
    "endZoom": function () {},
    "moveZoom": function () {},
    "startZoom": function () {},
    "endPan": function () {},
    "movePan": function () {},
    "startPan": function () {},
    "TickList": {},
    "Ticker": {},
    "numericLinearTicks": function () {},
    "numericTicks": function () {},
    "dateTicker": function () {},
    "SECONDLY": {},
    "TWO_SECONDLY": {},
    "FIVE_SECONDLY": {},
    "TEN_SECONDLY": {},
    "THIRTY_SECONDLY": {},
    "MINUTELY": {},
    "TWO_MINUTELY": {},
    "FIVE_MINUTELY": {},
    "TEN_MINUTELY": {},
    "THIRTY_MINUTELY": {},
    "HOURLY": {},
    "TWO_HOURLY": {},
    "SIX_HOURLY": {},
    "DAILY": {},
    "TWO_DAILY": {},
    "WEEKLY": {},
    "MONTHLY": {},
    "QUARTERLY": {},
    "BIANNUAL": {},
    "ANNUAL": {},
    "DECADAL": {},
    "CENTENNIAL": {},
    "NUM_GRANULARITIES": {},
    "DATEFIELD_Y": {},
    "DATEFIELD_M": {},
    "DATEFIELD_D": {},
    "DATEFIELD_HH": {},
    "DATEFIELD_MM": {},
    "DATEFIELD_SS": {},
    "DATEFIELD_MS": {},
    "NUM_DATEFIELDS": {},
    "TICK_PLACEMENT": {
        "0": {
            "datefield": {},
            "step": {},
            "spacing": {}
        },
        "1": {
            "datefield": {},
            "step": {},
            "spacing": {}
        },
        "2": {
            "datefield": {},
            "step": {},
            "spacing": {}
        },
        "3": {
            "datefield": {},
            "step": {},
            "spacing": {}
        },
        "4": {
            "datefield": {},
            "step": {},
            "spacing": {}
        },
        "5": {
            "datefield": {},
            "step": {},
            "spacing": {}
        },
        "6": {
            "datefield": {},
            "step": {},
            "spacing": {}
        },
        "7": {
            "datefield": {},
            "step": {},
            "spacing": {}
        },
        "8": {
            "datefield": {},
            "step": {},
            "spacing": {}
        },
        "9": {
            "datefield": {},
            "step": {},
            "spacing": {}
        },
        "10": {
            "datefield": {},
            "step": {},
            "spacing": {}
        },
        "11": {
            "datefield": {},
            "step": {},
            "spacing": {}
        },
        "12": {
            "datefield": {},
            "step": {},
            "spacing": {}
        },
        "13": {
            "datefield": {},
            "step": {},
            "spacing": {}
        },
        "14": {
            "datefield": {},
            "step": {},
            "spacing": {}
        },
        "15": {
            "datefield": {},
            "step": {},
            "spacing": {}
        },
        "16": {
            "datefield": {},
            "step": {},
            "spacing": {}
        },
        "17": {
            "datefield": {},
            "step": {},
            "spacing": {}
        },
        "18": {
            "datefield": {},
            "step": {},
            "spacing": {}
        },
        "19": {
            "datefield": {},
            "step": {},
            "spacing": {}
        },
        "20": {
            "datefield": {},
            "step": {},
            "spacing": {}
        },
        "21": {
            "datefield": {},
            "step": {},
            "spacing": {}
        }
    },
    "PREFERRED_LOG_TICK_VALUES": {
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
        "19": {},
        "20": {},
        "21": {},
        "22": {},
        "23": {},
        "24": {},
        "25": {},
        "26": {},
        "27": {},
        "28": {},
        "29": {},
        "30": {},
        "31": {},
        "32": {},
        "33": {},
        "34": {},
        "35": {},
        "36": {},
        "37": {},
        "38": {},
        "39": {},
        "40": {},
        "41": {},
        "42": {},
        "43": {},
        "44": {},
        "45": {},
        "46": {},
        "47": {},
        "48": {},
        "49": {},
        "50": {},
        "51": {},
        "52": {},
        "53": {},
        "54": {},
        "55": {},
        "56": {},
        "57": {},
        "58": {},
        "59": {},
        "60": {},
        "61": {},
        "62": {},
        "63": {},
        "64": {},
        "65": {},
        "66": {},
        "67": {},
        "68": {},
        "69": {},
        "70": {},
        "71": {},
        "72": {},
        "73": {},
        "74": {},
        "75": {},
        "76": {},
        "77": {},
        "78": {},
        "79": {},
        "80": {},
        "81": {},
        "82": {},
        "83": {},
        "84": {},
        "85": {},
        "86": {},
        "87": {},
        "88": {},
        "89": {},
        "90": {},
        "91": {},
        "92": {},
        "93": {},
        "94": {},
        "95": {},
        "96": {},
        "97": {},
        "98": {},
        "99": {},
        "100": {},
        "101": {},
        "102": {},
        "103": {},
        "104": {},
        "105": {},
        "106": {},
        "107": {},
        "108": {},
        "109": {},
        "110": {},
        "111": {},
        "112": {},
        "113": {},
        "114": {},
        "115": {},
        "116": {},
        "117": {},
        "118": {},
        "119": {},
        "120": {},
        "121": {},
        "122": {},
        "123": {},
        "124": {},
        "125": {},
        "126": {},
        "127": {},
        "128": {},
        "129": {},
        "130": {},
        "131": {},
        "132": {},
        "133": {},
        "134": {},
        "135": {},
        "136": {},
        "137": {},
        "138": {},
        "139": {},
        "140": {},
        "141": {},
        "142": {},
        "143": {},
        "144": {},
        "145": {},
        "146": {},
        "147": {},
        "148": {},
        "149": {},
        "150": {},
        "151": {},
        "152": {},
        "153": {},
        "154": {},
        "155": {},
        "156": {},
        "157": {},
        "158": {},
        "159": {},
        "160": {},
        "161": {},
        "162": {},
        "163": {},
        "164": {},
        "165": {},
        "166": {},
        "167": {},
        "168": {},
        "169": {},
        "170": {},
        "171": {},
        "172": {},
        "173": {},
        "174": {},
        "175": {},
        "176": {},
        "177": {},
        "178": {},
        "179": {},
        "180": {},
        "181": {},
        "182": {},
        "183": {},
        "184": {},
        "185": {},
        "186": {},
        "187": {},
        "188": {},
        "189": {},
        "190": {},
        "191": {},
        "192": {},
        "193": {},
        "194": {},
        "195": {},
        "196": {},
        "197": {},
        "198": {},
        "199": {},
        "200": {},
        "201": {},
        "202": {},
        "203": {},
        "204": {},
        "205": {},
        "206": {},
        "207": {},
        "208": {},
        "209": {},
        "210": {},
        "211": {},
        "212": {},
        "213": {},
        "214": {},
        "215": {},
        "216": {},
        "217": {},
        "218": {},
        "219": {},
        "220": {},
        "221": {},
        "222": {},
        "223": {},
        "224": {},
        "225": {},
        "226": {},
        "227": {},
        "228": {},
        "229": {},
        "230": {},
        "231": {},
        "232": {},
        "233": {},
        "234": {},
        "235": {},
        "236": {},
        "237": {},
        "238": {},
        "239": {},
        "240": {},
        "241": {},
        "242": {},
        "243": {},
        "244": {},
        "245": {},
        "246": {},
        "247": {},
        "248": {},
        "249": {},
        "250": {},
        "251": {},
        "252": {},
        "253": {},
        "254": {},
        "255": {},
        "256": {},
        "257": {},
        "258": {},
        "259": {},
        "260": {},
        "261": {},
        "262": {},
        "263": {},
        "264": {},
        "265": {},
        "266": {},
        "267": {},
        "268": {},
        "269": {},
        "270": {},
        "271": {},
        "272": {},
        "273": {},
        "274": {},
        "275": {},
        "276": {},
        "277": {},
        "278": {},
        "279": {},
        "280": {},
        "281": {},
        "282": {},
        "283": {},
        "284": {},
        "285": {},
        "286": {},
        "287": {},
        "288": {},
        "289": {},
        "290": {},
        "291": {},
        "292": {},
        "293": {},
        "294": {},
        "295": {},
        "296": {},
        "297": {},
        "298": {},
        "299": {},
        "300": {},
        "301": {},
        "302": {},
        "303": {},
        "304": {},
        "305": {},
        "306": {},
        "307": {},
        "308": {},
        "309": {},
        "310": {},
        "311": {},
        "312": {},
        "313": {},
        "314": {},
        "315": {},
        "316": {},
        "317": {},
        "318": {},
        "319": {},
        "320": {},
        "321": {},
        "322": {},
        "323": {},
        "324": {},
        "325": {},
        "326": {},
        "327": {},
        "328": {},
        "329": {},
        "330": {},
        "331": {},
        "332": {},
        "333": {},
        "334": {},
        "335": {},
        "336": {},
        "337": {},
        "338": {},
        "339": {},
        "340": {},
        "341": {},
        "342": {},
        "343": {},
        "344": {},
        "345": {},
        "346": {},
        "347": {},
        "348": {},
        "349": {},
        "350": {},
        "351": {},
        "352": {},
        "353": {},
        "354": {},
        "355": {},
        "356": {},
        "357": {},
        "358": {},
        "359": {},
        "360": {},
        "361": {},
        "362": {},
        "363": {},
        "364": {},
        "365": {},
        "366": {},
        "367": {},
        "368": {},
        "369": {},
        "370": {},
        "371": {},
        "372": {},
        "373": {},
        "374": {},
        "375": {},
        "376": {},
        "377": {},
        "378": {},
        "379": {},
        "380": {},
        "381": {},
        "382": {},
        "383": {},
        "384": {},
        "385": {},
        "386": {},
        "387": {},
        "388": {},
        "389": {},
        "390": {},
        "391": {},
        "392": {},
        "393": {},
        "394": {},
        "395": {},
        "396": {},
        "397": {},
        "398": {},
        "399": {},
        "400": {},
        "401": {},
        "402": {},
        "403": {},
        "404": {},
        "405": {},
        "406": {},
        "407": {},
        "408": {},
        "409": {},
        "410": {},
        "411": {},
        "412": {},
        "413": {},
        "414": {},
        "415": {},
        "416": {},
        "417": {},
        "418": {},
        "419": {},
        "420": {},
        "421": {},
        "422": {},
        "423": {},
        "424": {},
        "425": {},
        "426": {},
        "427": {},
        "428": {},
        "429": {},
        "430": {},
        "431": {},
        "432": {},
        "433": {},
        "434": {},
        "435": {},
        "436": {},
        "437": {},
        "438": {},
        "439": {},
        "440": {},
        "441": {},
        "442": {},
        "443": {},
        "444": {},
        "445": {},
        "446": {},
        "447": {},
        "448": {},
        "449": {},
        "450": {},
        "451": {},
        "452": {},
        "453": {},
        "454": {},
        "455": {},
        "456": {},
        "457": {},
        "458": {},
        "459": {},
        "460": {},
        "461": {},
        "462": {},
        "463": {},
        "464": {},
        "465": {},
        "466": {},
        "467": {},
        "468": {},
        "469": {},
        "470": {},
        "471": {},
        "472": {},
        "473": {},
        "474": {},
        "475": {},
        "476": {},
        "477": {},
        "478": {},
        "479": {},
        "480": {},
        "481": {},
        "482": {},
        "483": {},
        "484": {},
        "485": {},
        "486": {},
        "487": {},
        "488": {},
        "489": {},
        "490": {},
        "491": {},
        "492": {},
        "493": {},
        "494": {},
        "495": {},
        "496": {},
        "497": {},
        "498": {},
        "499": {},
        "500": {},
        "501": {},
        "502": {},
        "503": {},
        "504": {},
        "505": {},
        "506": {},
        "507": {},
        "508": {},
        "509": {},
        "510": {},
        "511": {},
        "512": {},
        "513": {},
        "514": {},
        "515": {},
        "516": {},
        "517": {},
        "518": {},
        "519": {},
        "520": {},
        "521": {},
        "522": {},
        "523": {},
        "524": {},
        "525": {},
        "526": {},
        "527": {},
        "528": {},
        "529": {},
        "530": {},
        "531": {},
        "532": {},
        "533": {},
        "534": {},
        "535": {},
        "536": {},
        "537": {},
        "538": {},
        "539": {},
        "540": {},
        "541": {},
        "542": {},
        "543": {},
        "544": {},
        "545": {},
        "546": {},
        "547": {},
        "548": {},
        "549": {},
        "550": {},
        "551": {},
        "552": {},
        "553": {},
        "554": {},
        "555": {},
        "556": {},
        "557": {},
        "558": {},
        "559": {},
        "560": {},
        "561": {},
        "562": {},
        "563": {},
        "564": {},
        "565": {},
        "566": {},
        "567": {},
        "568": {},
        "569": {},
        "570": {},
        "571": {},
        "572": {},
        "573": {},
        "574": {},
        "575": {},
        "576": {},
        "577": {},
        "578": {},
        "579": {},
        "580": {},
        "581": {},
        "582": {},
        "583": {},
        "584": {},
        "585": {},
        "586": {},
        "587": {},
        "588": {},
        "589": {},
        "590": {},
        "591": {},
        "592": {},
        "593": {},
        "594": {},
        "595": {},
        "596": {},
        "597": {},
        "598": {},
        "599": {},
        "600": {},
        "601": {},
        "602": {},
        "603": {},
        "604": {},
        "605": {},
        "606": {},
        "607": {},
        "608": {},
        "609": {},
        "610": {},
        "611": {},
        "612": {},
        "613": {},
        "614": {},
        "615": {},
        "616": {},
        "617": {},
        "618": {},
        "619": {},
        "620": {},
        "621": {},
        "622": {},
        "623": {},
        "624": {},
        "625": {},
        "626": {},
        "627": {},
        "628": {},
        "629": {},
        "630": {},
        "631": {},
        "632": {},
        "633": {},
        "634": {},
        "635": {},
        "636": {},
        "637": {},
        "638": {},
        "639": {},
        "640": {},
        "641": {},
        "642": {},
        "643": {},
        "644": {},
        "645": {},
        "646": {},
        "647": {},
        "648": {},
        "649": {},
        "650": {},
        "651": {},
        "652": {},
        "653": {},
        "654": {},
        "655": {},
        "656": {},
        "657": {},
        "658": {},
        "659": {},
        "660": {},
        "661": {},
        "662": {},
        "663": {},
        "664": {},
        "665": {},
        "666": {},
        "667": {},
        "668": {},
        "669": {},
        "670": {},
        "671": {},
        "672": {},
        "673": {},
        "674": {},
        "675": {},
        "676": {},
        "677": {},
        "678": {},
        "679": {},
        "680": {},
        "681": {},
        "682": {},
        "683": {},
        "684": {},
        "685": {},
        "686": {},
        "687": {},
        "688": {},
        "689": {},
        "690": {},
        "691": {},
        "692": {},
        "693": {},
        "694": {},
        "695": {},
        "696": {},
        "697": {},
        "698": {},
        "699": {},
        "700": {},
        "701": {},
        "702": {},
        "703": {},
        "704": {},
        "705": {},
        "706": {},
        "707": {},
        "708": {},
        "709": {},
        "710": {}
    },
    "pickDateTickGranularity": function () {},
    "numDateTicks": function () {},
    "getDateAxis": function () {},
    "Plugins": {
        "Annotations": function () {},
        "Axes": function () {},
        "ChartLabels": function () {},
        "Grid": function () {},
        "Legend": function () {},
        "RangeSelector": function () {}
    },
    "OPTIONS_REFERENCE": {
        "xValueParser": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "stackedGraph": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "stackedGraphNaNFill": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "pointSize": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "labelsDivStyles": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "drawPoints": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "drawGapEdgePoints": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "drawPointCallback": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "parameters": {
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
                },
                "3": {
                    "0": {},
                    "1": {}
                },
                "4": {
                    "0": {},
                    "1": {}
                },
                "5": {
                    "0": {},
                    "1": {}
                },
                "6": {
                    "0": {},
                    "1": {}
                },
                "7": {
                    "0": {},
                    "1": {}
                }
            },
            "description": {}
        },
        "height": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "zoomCallback": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "parameters": {
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
            "description": {}
        },
        "pointClickCallback": {
            "snippet": {},
            "default": {},
            "labels": {
                "0": {},
                "1": {}
            },
            "type": {},
            "parameters": {
                "0": {
                    "0": {},
                    "1": {}
                },
                "1": {
                    "0": {},
                    "1": {}
                }
            },
            "description": {}
        },
        "color": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "example": {},
            "description": {}
        },
        "colors": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "example": {},
            "description": {}
        },
        "connectSeparatedPoints": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "highlightCallback": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {},
            "parameters": {
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
                },
                "3": {
                    "0": {},
                    "1": {}
                },
                "4": {
                    "0": {},
                    "1": {}
                }
            }
        },
        "drawHighlightPointCallback": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "parameters": {
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
                },
                "3": {
                    "0": {},
                    "1": {}
                },
                "4": {
                    "0": {},
                    "1": {}
                },
                "5": {
                    "0": {},
                    "1": {}
                },
                "6": {
                    "0": {},
                    "1": {}
                },
                "7": {
                    "0": {},
                    "1": {}
                }
            },
            "description": {}
        },
        "highlightSeriesOpts": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "highlightSeriesBackgroundAlpha": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "includeZero": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "rollPeriod": {
            "default": {},
            "labels": {
                "0": {},
                "1": {}
            },
            "type": {},
            "description": {}
        },
        "unhighlightCallback": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "parameters": {
                "0": {
                    "0": {},
                    "1": {}
                }
            },
            "description": {}
        },
        "axisTickSize": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "labelsSeparateLines": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "xValueFormatter": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "valueFormatter": {
            "default": {},
            "labels": {
                "0": {},
                "1": {}
            },
            "type": {},
            "description": {},
            "parameters": {
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
                },
                "3": {
                    "0": {},
                    "1": {}
                },
                "4": {
                    "0": {},
                    "1": {}
                },
                "5": {
                    "0": {},
                    "1": {}
                }
            }
        },
        "pixelsPerYLabel": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "annotationMouseOverHandler": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "annotationMouseOutHandler": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "parameters": {
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
                },
                "3": {
                    "0": {},
                    "1": {}
                }
            },
            "description": {}
        },
        "annotationClickHandler": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "parameters": {
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
                },
                "3": {
                    "0": {},
                    "1": {}
                }
            },
            "description": {}
        },
        "annotationDblClickHandler": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "parameters": {
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
                },
                "3": {
                    "0": {},
                    "1": {}
                }
            },
            "description": {}
        },
        "drawCallback": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "parameters": {
                "0": {
                    "0": {},
                    "1": {}
                },
                "1": {
                    "0": {},
                    "1": {}
                }
            },
            "description": {}
        },
        "labelsKMG2": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "delimiter": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "axisLabelFontSize": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "underlayCallback": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "parameters": {
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
            "description": {}
        },
        "width": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "interactionModel": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "ticker": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "parameters": {
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
                },
                "3": {
                    "0": {},
                    "1": {}
                },
                "4": {
                    "0": {},
                    "1": {}
                },
                "5": {
                    "0": {},
                    "1": {}
                }
            },
            "description": {}
        },
        "xAxisLabelWidth": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "xAxisHeight": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "showLabelsOnHighlight": {
            "default": {},
            "labels": {
                "0": {},
                "1": {}
            },
            "type": {},
            "description": {}
        },
        "axis": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "pixelsPerXLabel": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "pixelsPerLabel": {
            "default": {},
            "labels": {
                "0": {},
                "1": {}
            },
            "type": {},
            "description": {}
        },
        "labelsDiv": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "example": {},
            "description": {}
        },
        "fractions": {
            "default": {},
            "labels": {
                "0": {},
                "1": {}
            },
            "type": {},
            "description": {}
        },
        "logscale": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "strokeWidth": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "example": {},
            "description": {}
        },
        "strokePattern": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "example": {},
            "description": {}
        },
        "strokeBorderWidth": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "example": {},
            "description": {}
        },
        "strokeBorderColor": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "example": {},
            "description": {}
        },
        "wilsonInterval": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "fillGraph": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "highlightCircleSize": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "gridLineColor": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "gridLinePattern": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "example": {},
            "description": {}
        },
        "visibility": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "valueRange": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "example": {},
            "description": {}
        },
        "labelsDivWidth": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "colorSaturation": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "yAxisLabelWidth": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "hideOverlayOnMouseOut": {
            "default": {},
            "labels": {
                "0": {},
                "1": {}
            },
            "type": {},
            "description": {}
        },
        "yValueFormatter": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "legend": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "labelsShowZeroValues": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "stepPlot": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "labelsUTC": {
            "default": {},
            "labels": {
                "0": {},
                "1": {}
            },
            "type": {},
            "description": {}
        },
        "labelsKMB": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "rightGap": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "avoidMinZero": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "drawAxesAtZero": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "xRangePad": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "yRangePad": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "xAxisLabelFormatter": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "axisLabelFormatter": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "parameters": {
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
                },
                "3": {
                    "0": {},
                    "1": {}
                }
            },
            "description": {}
        },
        "clickCallback": {
            "snippet": {},
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "parameters": {
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
            "description": {}
        },
        "yAxisLabelFormatter": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "labels": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "dateWindow": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "example": {},
            "description": {}
        },
        "showRoller": {
            "default": {},
            "labels": {
                "0": {},
                "1": {}
            },
            "type": {},
            "description": {}
        },
        "sigma": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "customBars": {
            "default": {},
            "labels": {
                "0": {},
                "1": {}
            },
            "type": {},
            "description": {}
        },
        "colorValue": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "errorBars": {
            "default": {},
            "labels": {
                "0": {},
                "1": {}
            },
            "type": {},
            "description": {}
        },
        "displayAnnotations": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "panEdgeFraction": {
            "default": {},
            "labels": {
                "0": {},
                "1": {}
            },
            "type": {},
            "description": {}
        },
        "title": {
            "labels": {
                "0": {}
            },
            "type": {},
            "default": {},
            "description": {}
        },
        "titleHeight": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "xlabel": {
            "labels": {
                "0": {}
            },
            "type": {},
            "default": {},
            "description": {}
        },
        "xLabelHeight": {
            "labels": {
                "0": {}
            },
            "type": {},
            "default": {},
            "description": {}
        },
        "ylabel": {
            "labels": {
                "0": {}
            },
            "type": {},
            "default": {},
            "description": {}
        },
        "y2label": {
            "labels": {
                "0": {}
            },
            "type": {},
            "default": {},
            "description": {}
        },
        "yLabelWidth": {
            "labels": {
                "0": {}
            },
            "type": {},
            "default": {},
            "description": {}
        },
        "isZoomedIgnoreProgrammaticZoom": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "drawXGrid": {
            "default": {},
            "labels": {
                "0": {},
                "1": {}
            },
            "type": {},
            "description": {}
        },
        "drawYGrid": {
            "default": {},
            "labels": {
                "0": {},
                "1": {}
            },
            "type": {},
            "description": {}
        },
        "drawGrid": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "independentTicks": {
            "default": {},
            "labels": {
                "0": {},
                "1": {}
            },
            "type": {},
            "description": {}
        },
        "drawXAxis": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "drawYAxis": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "drawAxis": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "gridLineWidth": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "axisLineWidth": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "axisLineColor": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "fillAlpha": {
            "default": {},
            "labels": {
                "0": {},
                "1": {}
            },
            "type": {},
            "description": {}
        },
        "axisLabelColor": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "axisLabelWidth": {
            "default": {},
            "labels": {
                "0": {},
                "1": {}
            },
            "type": {},
            "description": {}
        },
        "sigFigs": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "digitsAfterDecimal": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "maxNumberWidth": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "file": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "timingName": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "showRangeSelector": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "rangeSelectorHeight": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "rangeSelectorPlotStrokeColor": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "rangeSelectorPlotFillColor": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "showInRangeSelector": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "animatedZooms": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "plotter": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "axes": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "series": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "plugins": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        },
        "dataHandler": {
            "default": {},
            "labels": {
                "0": {}
            },
            "type": {},
            "description": {}
        }
    },
    "DataHandler": function () {},
    "DataHandlers": {
        "DefaultHandler": function () {},
        "DefaultFractionHandler": function () {},
        "BarsHandler": function () {},
        "CustomBarsHandler": function () {},
        "ErrorBarsHandler": function () {},
        "FractionsBarsHandler": function () {}
    }
}
