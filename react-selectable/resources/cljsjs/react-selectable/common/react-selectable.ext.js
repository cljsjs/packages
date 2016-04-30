var Selectable = {
  "SelectableGroup": {
      "propTypes": {
          "onSelection": function () {},
          "component": {},
          "tolerance": {},
          "fixedPosition": {}
      },
      "defaultProps": {
          "onSelection": function() {},
        	"component": {},
        	"tolerance": {},
        	"fixedPosition": {}
      },
      "childContextTypes": {
        selectable: {}
      }
  },
  "createSelectable": function() {},
  "SelectableItem": {
      "contextTypes": {
  		    "selectable": {}
  	  },
      "propTypes": {
  		    "selectableKey": {}
  	  }
   }
}
