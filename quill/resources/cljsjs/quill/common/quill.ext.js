var Quill = {
    "DEFAULTS": {
        "bounds": function () {},
        "formats": function () {},
        "modules": function () {},
        "placeholder": {},
        "readOnly": {},
        "theme": {}
    },
    "events": {
        "EDITOR_CHANGE": {},
        "SCROLL_BEFORE_UPDATE": {},
        "SCROLL_OPTIMIZE": {},
        "SCROLL_UPDATE": {},
        "SELECTION_CHANGE": {},
        "TEXT_CHANGE": {}
    },
    "sources": {
        "API": {},
        "SILENT": {},
        "USER": {}
    },
    "version": {},
    "imports": {
        "delta": function () {},
        "parchment": {
            "Scope": {
                "3": {},
                "5": {},
                "6": {},
                "7": {},
                "9": {},
                "10": {},
                "11": {},
                "12": {},
                "13": {},
                "14": {},
                "15": {},
                "TYPE": {},
                "LEVEL": {},
                "ATTRIBUTE": {},
                "BLOT": {},
                "INLINE": {},
                "BLOCK": {},
                "BLOCK_BLOT": {},
                "INLINE_BLOT": {},
                "BLOCK_ATTRIBUTE": {},
                "INLINE_ATTRIBUTE": {},
                "ANY": {}
            },
            "create": function () {},
            "find": function () {},
            "query": function () {},
            "register": function () {},
            "Container": function () {},
            "Format": function () {},
            "Leaf": function () {},
            "Embed": function () {},
            "Scroll": function () {},
            "Block": function () {},
            "Inline": function () {},
            "Text": function () {},
            "Attributor": {
                "Attribute": function () {},
                "Class": function () {},
                "Style": function () {},
                "Store": function () {}
            }
        },
        "core/module": function () {},
        "core/theme": function () {},
        "blots/block": function () {},
        "blots/block/embed": function () {},
        "blots/break": function () {},
        "blots/container": function () {},
        "blots/cursor": function () {},
        "blots/embed": function () {},
        "blots/inline": function () {},
        "blots/scroll": function () {},
        "blots/text": function () {},
        "modules/clipboard": function () {},
        "modules/history": function () {},
        "modules/keyboard": function () {},
        "attributors/attribute/direction": {
            "attrName": {},
            "keyName": {},
            "scope": {},
            "whitelist": {
                "0": {}
            },
            "add": function () {},
            "canAdd": function () {},
            "remove": function () {},
            "value": function () {}
        },
        "attributors/class/align": {
            "attrName": {},
            "keyName": {},
            "scope": {},
            "whitelist": {
                "0": {},
                "1": {},
                "2": {}
            },
            "constructor": function () {},
            "add": function () {},
            "remove": function () {},
            "value": function () {},
            "canAdd": function () {}
        },
        "attributors/class/background": {
            "attrName": {},
            "keyName": {},
            "scope": {},
            "constructor": function () {},
            "add": function () {},
            "remove": function () {},
            "value": function () {},
            "canAdd": function () {}
        },
        "attributors/class/color": {
            "attrName": {},
            "keyName": {},
            "scope": {},
            "constructor": function () {},
            "add": function () {},
            "remove": function () {},
            "value": function () {},
            "canAdd": function () {}
        },
        "attributors/class/direction": {
            "attrName": {},
            "keyName": {},
            "scope": {},
            "whitelist": {
                "0": {}
            },
            "constructor": function () {},
            "add": function () {},
            "remove": function () {},
            "value": function () {},
            "canAdd": function () {}
        },
        "attributors/class/font": {
            "attrName": {},
            "keyName": {},
            "scope": {},
            "whitelist": {
                "0": {},
                "1": {}
            },
            "constructor": function () {},
            "add": function () {},
            "remove": function () {},
            "value": function () {},
            "canAdd": function () {}
        },
        "attributors/class/size": {
            "attrName": {},
            "keyName": {},
            "scope": {},
            "whitelist": {
                "0": {},
                "1": {},
                "2": {}
            },
            "constructor": function () {},
            "add": function () {},
            "remove": function () {},
            "value": function () {},
            "canAdd": function () {}
        },
        "attributors/style/align": {
            "attrName": {},
            "keyName": {},
            "scope": {},
            "whitelist": {
                "0": {},
                "1": {},
                "2": {}
            },
            "constructor": function () {},
            "add": function () {},
            "remove": function () {},
            "value": function () {},
            "canAdd": function () {}
        },
        "attributors/style/background": {
            "attrName": {},
            "keyName": {},
            "scope": {},
            "constructor": function () {},
            "add": function () {},
            "remove": function () {},
            "value": function () {},
            "canAdd": function () {}
        },
        "attributors/style/color": {
            "attrName": {},
            "keyName": {},
            "scope": {},
            "constructor": function () {},
            "add": function () {},
            "remove": function () {},
            "value": function () {},
            "canAdd": function () {}
        },
        "attributors/style/direction": {
            "attrName": {},
            "keyName": {},
            "scope": {},
            "whitelist": {
                "0": {}
            },
            "constructor": function () {},
            "add": function () {},
            "remove": function () {},
            "value": function () {},
            "canAdd": function () {}
        },
        "attributors/style/font": {
            "attrName": {},
            "keyName": {},
            "scope": {},
            "whitelist": {
                "0": {},
                "1": {}
            },
            "constructor": function () {},
            "add": function () {},
            "remove": function () {},
            "value": function () {},
            "canAdd": function () {}
        },
        "attributors/style/size": {
            "attrName": {},
            "keyName": {},
            "scope": {},
            "whitelist": {
                "0": {},
                "1": {},
                "2": {}
            },
            "constructor": function () {},
            "add": function () {},
            "remove": function () {},
            "value": function () {},
            "canAdd": function () {}
        },
        "formats/align": {
            "attrName": {},
            "keyName": {},
            "scope": {},
            "whitelist": {
                "0": {},
                "1": {},
                "2": {}
            },
            "constructor": function () {},
            "add": function () {},
            "remove": function () {},
            "value": function () {},
            "canAdd": function () {}
        },
        "formats/direction": {
            "attrName": {},
            "keyName": {},
            "scope": {},
            "whitelist": {
                "0": {}
            },
            "constructor": function () {},
            "add": function () {},
            "remove": function () {},
            "value": function () {},
            "canAdd": function () {}
        },
        "formats/indent": {
            "attrName": {},
            "keyName": {},
            "scope": {},
            "whitelist": {
                "0": {},
                "1": {},
                "2": {},
                "3": {},
                "4": {},
                "5": {},
                "6": {},
                "7": {}
            },
            "constructor": function () {},
            "add": function () {},
            "remove": function () {},
            "value": function () {},
            "canAdd": function () {}
        },
        "formats/background": {
            "attrName": {},
            "keyName": {},
            "scope": {},
            "constructor": function () {},
            "add": function () {},
            "remove": function () {},
            "value": function () {},
            "canAdd": function () {}
        },
        "formats/color": {
            "attrName": {},
            "keyName": {},
            "scope": {},
            "constructor": function () {},
            "add": function () {},
            "remove": function () {},
            "value": function () {},
            "canAdd": function () {}
        },
        "formats/font": {
            "attrName": {},
            "keyName": {},
            "scope": {},
            "whitelist": {
                "0": {},
                "1": {}
            },
            "constructor": function () {},
            "add": function () {},
            "remove": function () {},
            "value": function () {},
            "canAdd": function () {}
        },
        "formats/size": {
            "attrName": {},
            "keyName": {},
            "scope": {},
            "whitelist": {
                "0": {},
                "1": {},
                "2": {}
            },
            "constructor": function () {},
            "add": function () {},
            "remove": function () {},
            "value": function () {},
            "canAdd": function () {}
        },
        "formats/blockquote": function () {},
        "formats/code-block": function () {},
        "formats/header": function () {},
        "formats/list": function () {},
        "formats/bold": function () {},
        "formats/code": function () {},
        "formats/italic": function () {},
        "formats/link": function () {},
        "formats/script": function () {},
        "formats/strike": function () {},
        "formats/underline": function () {},
        "formats/image": function () {},
        "formats/video": function () {},
        "formats/list/item": function () {},
        "modules/formula": function () {},
        "modules/syntax": function () {},
        "modules/toolbar": function () {},
        "themes/bubble": function () {},
        "themes/snow": function () {},
        "ui/icons": {
            "align": {
                "": {},
                "center": {},
                "right": {},
                "justify": {}
            },
            "background": {},
            "blockquote": {},
            "bold": {},
            "clean": {},
            "code": {},
            "code-block": {},
            "color": {},
            "direction": {
                "": {},
                "rtl": {}
            },
            "float": {
                "center": {},
                "full": {},
                "left": {},
                "right": {}
            },
            "formula": {},
            "header": {
                "1": {},
                "2": {}
            },
            "italic": {},
            "image": {},
            "indent": {
                "+1": {},
                "-1": {}
            },
            "link": {},
            "list": {
                "ordered": {},
                "bullet": {}
            },
            "script": {
                "sub": {},
                "super": {}
            },
            "strike": {},
            "underline": {},
            "video": {}
        },
        "ui/picker": function () {},
        "ui/icon-picker": function () {},
        "ui/color-picker": function () {},
        "ui/tooltip": function () {}
    }
}
