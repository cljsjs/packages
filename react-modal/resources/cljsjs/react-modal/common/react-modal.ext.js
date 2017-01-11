var ReactModal = {
    "Modal": {
	"propTypes": {
	    "isOpen": {
		"isRequired": function () {}
	    },
	    "onAfterOpen": {
		"isRequired": function () {}
	    },
	    "style": {
		"isRequired": function () {}
	    },
	    "onRequestClose": {
		"isRequired": function () {}
	    },
	    "closeTimeoutMS": {
		"isRequired": function () {}
	    },
	    "shouldCloseOnOverlayClick": {
		"isRequired": function () {}
	    },
	    "contentLabel": {
		"isRequired": function () {}
	    },
	},
	"defaultProps": {
	    "isActive": {},
	    "onAfterOpen": function () {},
	    "style": {},
	    "onRequestClose": function () {},
	    "closeTimeoutMS": {},
	    "shouldCloseOnOverlayClick": {},
	    "contentLabel": {}, 
	},
    }
};


ReactModal.Modal.prototype = {
    "isReactComponent": function () {},
    "setState": function () {},
    "forceUpdate": function () {}
};


ReactModal.default.prototype = {
    "isReactComponent": function () {},
    "setState": function () {},
    "forceUpdate": function () {}
};
