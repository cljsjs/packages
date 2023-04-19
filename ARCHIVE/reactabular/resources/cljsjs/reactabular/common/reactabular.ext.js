var Reactabular = {
  "Table": {
    "Provider": {
      "propTypes": {
        "columns": function () {},
        "components": {
          "isRequired": function () {}
        },
        "children": {
          "isRequired": function () {}
        }
      },
      "defaultProps": {
        "components": {
          "table": {},
          "header": {
            "wrapper": {},
            "row": {},
            "cell": {}
          },
          "body": {
            "wrapper": {},
            "row": {},
            "cell": {}
          }
        }
      },
      "childContextTypes": {
        "headerColumns": function () {},
        "bodyColumns": function () {},
        "components": {
          "isRequired": function () {}
        }
      }
    },
    "Header": {
      "propTypes": {
        "children": {
          "isRequired": function () {}
        }
      },
      "contextTypes": {
        "headerColumns": function () {},
        "components": {
          "isRequired": function () {}
        }
      }
    },
    "Body": {
      "propTypes": {
        "onRow": {
          "isRequired": function () {}
        },
        "rows": function () {},
        "rowKey": function () {}
      },
      "defaultProps": {
        "onRow": function () {}
      },
      "contextTypes": {
        "bodyColumns": function () {},
        "components": {
          "isRequired": function () {}
        }
      }
    }
  },
  "search": {
    "multipleColumns": function () {},
    "singleColumn": function () {},
    "_columnMatches": function () {},
    "matches": function () {},
    "strategies": {
      "infix": function () {},
      "prefix": function () {}
    }
  },
  "sort": {
    "byColumn": function () {},
    "byColumns": function () {},
    "sorter": function () {},
    "sort": function () {}
  },
  "edit": {
    "boolean": function () {},
    "dropdown": function () {},
    "input": function () {},
    "edit": function () {}
  },
  "highlight": {
    "cell": function () {},
    "value": function () {},
    "highlighter": function () {}
  },
  "resolve": {
    "resolve": function () {},
    "nested": function () {},
    "byFunction": function () {}
  }
};
Reactabular.Table.Provider.prototype = {
  "isReactComponent": function () {},
  "setState": function () {},
  "forceUpdate": function () {}
};
Reactabular.Table.Header.prototype = {
  "isReactComponent": function () {},
  "setState": function () {},
  "forceUpdate": function () {}
};
Reactabular.Table.Body.prototype = {
  "isReactComponent": function () {},
  "setState": function () {},
  "forceUpdate": function () {}
};
