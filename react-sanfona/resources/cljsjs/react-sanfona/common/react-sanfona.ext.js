var ReactSanfona = {
    "Accordion": {
        "defaultProps": {
            "activeItems": {},
            "allowMultiple": {},
            "duration": {},
            "easing": {},
            "rooting": {}
        },
        "propTypes": {
            "allowMultiple": {},
            "children": {},
            "className": {},
            "duration": {},
            "easing": {},
            "onChange": function () {},
            "openNextAccordionItem": {},
            "style": {},
            "rootTag": {}
        }
    },
    "AccordionItem": {
        "defaultProps": {
            "rootTag": {},
            "bodyTag": {},
            "titleTag": {}
        },
        "propTypes": {
            "bodyClassName": {},
            "bodyTag": {},
            "children": {},
            "className": {},
            "disabled": {},
            "disabledClassName": {},
            "duration": {},
            "easing": {},
            "expanded": {},
            "expandedClassName": {},
            "index": {},
            "onClick": function () {},
            "onClose": function () {},
            "onExpand": function () {},
            "rootTag": {},
            "slug": {},
            "style": {},
            "title": {},
            "titleClassName": {},
            "titleTag": {},
            "uuid": {}
        }
    },
    "AccordionItemTitle": {
        "defaultProps": {
            "rootTag": {}
        },
        "propTypes": {
            "className": {},
            "onClick": function() {},
            "rootTag": {},
            "title": {},
            "uuid": {}
        }
    },
    "AccordionItemBody": {
        "defaultProps": {
            "rootTag": {}
        },
        "propTypes": {
            "className": {},
            "children": {},
            "duration": {},
            "easing": {},
            "maxHeight": {},
            "overflow": {},
            "rootTag": {},
            "uuid": {}
        }
    }
};

ReactSanfona.Accordion.prototype = {
    "isReactComponent": function () {},
    "setState": function () {},
    "forceUpdate": function () {}
};

ReactSanfona.AccordionItem.prototype = {
    "isReactComponent": function () {},
    "setState": function () {},
    "forceUpdate": function () {}
};
