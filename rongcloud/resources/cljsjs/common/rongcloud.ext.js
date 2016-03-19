/**
 *
 * @constructor
 */
var RongIMClient = {
    version: "",
    getInstance:function(){},

    /**
     * @constructor
     */
    RongIMMessage: {

    },

    /**
     * @constructor
     * @extends {RongIMClient.RongIMMessage}
     */
    NotificationMessage: {

    },

    /**
     * @constructor
     * @extends {RongIMClient.RongIMMessage}
     */
    StatusMessage: {

    },

    /**
     * @constructor
     * @extends {RongIMClient.RongIMMessage}
     */
    TextMessage: {
        obtain: function(){}
    },

    /**
     * @constructor
     * @extends {RongIMClient.RongIMMessage}
     */
    ImageMessage: {
        obtain: function(){}
    },

    /**
     * @constructor
     * @extends {RongIMClient.RongIMMessage}
     */
    RichContentMessage: {
        obtain: function(){}
    },

    /**
     * @constructor
     * @extends {RongIMClient.RongIMMessage}
     */
    VoiceMessage: {
        obtain: function(){}
    },

    /**
     * @constructor
     * @extends {RongIMClient.RongIMMessage}
     */
    HandshakeMessage: {
        obtain: function(){}
    },

    /**
     * @constructor
     * @extends {RongIMClient.RongIMMessage}
     */
    SuspendMessage: {
        obtain: function(){}
    },

    /**
     * @constructor
     * @extends {RongIMClient.RongIMMessage}
     */
    UnknownMessage  : {
        obtain: function(){}
    },


    /**
     * @constructor
     * @extends {RongIMClient.RongIMMessage}
     */
    LocationMessage  : {
        obtain: function(){}
    },


    /**
     * @constructor
     * @extends {RongIMClient.NotificationMessage}
     */
    DiscussionNotificationMessage  : {
        obtain: function(){}
    },

    /**
     * @constructor
     * @extends {RongIMClient.NotificationMessage}
     */
    InformationNotificationMessage  : {
        obtain: function(){}
    },


    /**
     * @constructor
     * @extends {RongIMClient.NotificationMessage}
     */
    ContactNotificationMessage  : {
        obtain: function(){},
        CONTACT_OPERATION_ACCEPT_RESPONSE: "",
        CONTACT_OPERATION_REJECT_RESPONSE: "",
        CONTACT_OPERATION_REQUEST: ""

    },

   /**
     * @constructor
     * @extends {RongIMClient.NotificationMessage}
     */
   ProfileNotificationMessage  : {
        obtain: function(){}
    },

   /**
     * @constructor
     * @extends {RongIMClient.NotificationMessage}
     */
   CommandNotificationMessage  : {
        obtain: function(){}
    },

    /**
     * @constructor
     */
    MessageContent  : {

    },

    /**
     * @constructor
     */
    MessageHandler  : {
    },

    connect: function(){},
    hasUnreadMessages: function(){},
    init: function(){},
    registerMessageType: function(){},
    setConnectionStatusListener: function(){},
    /**
     *
     * @constructor
     */
    ReceivedStatus: function(){},
    /**
     *
     * @constructor
     */
    UserInfo: function(){},


    /**
     *
     * @constructor
     */
    Conversation: function(){},

    /**
     *
     * @constructor
     */
    Discussion: function(){},

    /**
         *
         * @constructor
         */
    Group: function(){},


    /* enums */
    MessageTag: {
        ISPERSISTED: "ISPERSISTED",
        ISCOUNTED: "ISCOUNTED",
        NONE: "NONE",
        ISDISPLAYED: "ISDISPLAYED"
    },
    ConversationNotificationStatus: {
        DO_NOT_DISTURB: 0,
        NOTIFY: 1
    },
    ConversationType: {
        CHATROOM: 0, CUSTOMER_SERVICE: 1, DISCUSSION: 2,GROUP: 3,PRIVATE:4,SYSTEM:5
    },
    SentStatus: {
        DESTROYED: 0,FAILED:1,READ:2,RECEIVED:3,SENDING:4,SENT:5
    },
    DiscussionInviteStatus: {
        CLOSED:0,OPENED:1
    },
    MediaType: {
        AUDIO:0,FILE:1,IMAGE:2,VIDEO:3
    },
    MessageDirection: {
        RECEIVE:0,SEND:1
    },
    MessageType: {
        DiscussionNotificationMessage:0,TextMessage:1,ImageMessage:2,VoiceMessage:3,RichContentMessage:4,HandshakeMessage:5,UnknownMessage:6,SuspendMessage:7,LocationMessage:8,InformationNotificationMessage:9,ContactNotificationMessage:10,ProfileNotificationMessage:11,CommandNotificationMessage:12
    },
    SendErrorStatus: {
        REJECTED_BY_BLACKLIST: 405,
        NOT_IN_DISCUSSION: 21406,
        NOT_IN_GROUP: 22406,
        NOT_IN_CHATROOM: 23406
    },
    BlacklistStatus: {
        EXIT_BLACK_LIST: 0,
        NOT_EXIT_BLACK_LIST: 1
    },
    ConnectionStatus: {
        CONNECTED:0,CONNECTING:1,RECONNECT:2,OTHER_DEVICE_LOGIN:3,CLOSURE:4,UNKNOWN_ERROR:5,LOGOUT:6,BLOCK:7
    }
};

RongIMClient.prototype = {
    get: function(){},
    clearTextMessageDraft: function(){},
    getTextMessageDraft: function(){},
    saveTextMessageDraft: function(){},
    getIO: function(){},
    connect: function(){},
    disconnect: function(){},
    reconnect: function(){},
    syncConversationList: function(){},
    getConversation: function(){},
    getConversationList: function(){},
    getConversationNotificationStatus: function(){},
    clearConversations: function(){},
    getGroupConversationList: function(){},
    removeConversation: function(){},
    setConversationNotificationStatus: function(){},
    setConversationToTop: function(){},
    setConversationName: function(){},
    createConversation: function(){},
    getCurrentUserInfo: function(){},
    getUserInfo: function(){},
    sendMessage: function(){},
    uploadMedia: function(){},
    getUploadToken: function(){},
    getDownloadUrl: function(){},
    setConnectionStatusListener: function(){},
    setOnReceiveMessageListener: function(){},
    getTotalUnreadCount: function(){},
    getUnreadCount: function(){},
    clearMessagesUnreadStatus: function(){},
    initChatRoom: function(){},
    joinChatRoom: function(){},
    quitChatRoom: function(){},
    sendNotification: function(){},
    sendStatus: function(){},
    setDiscussionInviteStatus: function(){},
    setDiscussionName: function(){},
    removeMemberFromDiscussion: function(){},
    createDiscussion: function(){},
    addMemberToDiscussion: function(){},
    getDiscussion: function(){},
    quitDiscussion: function(){},
    quitGroup: function(){},
    joinGroup: function(){},
    syncGroup: function(){},
    addToBlacklist: function(){},
    getBlacklist: function(){},
    getBlacklistStatus: function(){},
    removeFromBlacklist: function(){},
    getHistoryMessages: function(){}
};

RongIMClient.RongIMMessage = {
    getDetail: function(){},
    getMessageTag: function(){},
    getContent: function(){},
    getConversationType: function(){},
    getExtra: function(){},
    getMessageDirection: function(){},
    getMessageId: function(){},
    getObjectName: function(){},
    getReceivedStatus: function(){},
    getReceivedTime: function(){},
    getSenderUserId: function(){},
    getSentStatus: function(){},
    getTargetId: function(){},
    setContent: function(){},
    setConversationType: function(){},
    setExtra: function(){},
    setMessageDirection: function(){},
    setMessageId: function(){},
    setObjectName: function(){},
    setReceivedStatus: function(){},
    setSenderUserId: function(){},
    setSentStatus: function(){},
    setSentTime: function(){},
    getSentTime: function(){},
    setTargetId: function(){},
    setReceivedTime: function(){},
    toJSONString: function(){},
    getMessageType: function(){},
    setMessageType: function(){}
};

RongIMClient.ImageMessage.prototype = {
    setImageUri: function(){},
    getImageUri: function(){}
};

RongIMClient.RichContentMessage.prototype = {
    setTitle: function(){},
    getTitle: function(){},
    setImageUri: function(){},
    getImageUri: function(){}
};

RongIMClient.VoiceMessage.prototype = {
    setDuration: function(){},
    getDuration: function(){}
};

RongIMClient.LocationMessage.prototype = {
    setLatitude: function(){},
    getLatitude: function(){},
    setLongitude: function(){},
    getLongitude: function(){},
    setPoi: function(){},
    getPoi: function(){}
};

RongIMClient.DiscussionNotificationMessage.prototype = {
    getExtension: function(){},
    getOperator: function(){},
    getType: function(){},
    isHasReceived: function(){},
    setExtension: function(){},
    setHasReceived: function(){},
    setOperator: function(){},
    setType: function(){}
};


RongIMClient.ContactNotificationMessage.prototype = {
    getOperation: function(){},
    setOperation: function(){},
    setMessage: function(){},
    getMessage: function(){},
    getSourceUserId: function(){},
    setSourceUserId: function(){},
    getTargetUserId: function(){},
    setTargetUserId: function(){}
};


RongIMClient.ProfileNotificationMessage.prototype = {
    getOperation: function(){},
    setOperation: function(){},
    getData: function(){},
    setData: function(){}
};



RongIMClient.MessageContent.prototype = {
    getMessage: function(){},
    encode: function(){}
};

RongIMClient.MessageHandler.prototype = {
    process: function(){}
};


RongIMClient.ReceivedStatus.prototype = {
    getFlag: function(){},
    isDownload: function(){},
    isListened: function(){},
    isRead: function(){},
    setDownload: function(){},
    setListened: function(){},
    setRead: function(){}
};

RongIMClient.UserInfo.prototype = {
    getUserName: function(){},
    getPortraitUri: function(){},
    getUserId: function(){},
    setUserName: function(){},
    setPortraitUri: function(){},
    setUserId: function(){}
};


RongIMClient.Conversation.prototype = {
    getConversationTitle: function(){},
    toJSONString: function(){},
    setReceivedStatus: function(){},
    getReceivedStatus: function(){},
    getConversationType: function(){},
    getDraft: function(){},
    getLatestMessage: function(){},
    getLatestMessageId: function(){},
    getNotificationStatus: function(){},
    getObjectName: function(){},
    getReceivedTime: function(){},
    getSenderUserId: function(){},
    getSentStatus: function(){},
    getSentTime: function(){},
    getTargetId: function(){},
    getUnreadMessageCount: function(){},
    isTop: function(){},
    setConversationTitle: function(){},
    getConversationPortrait: function(){},
    setConversationPortrait: function(){},
    setConversationType: function(){},
    setDraft: function(){},
    setSenderUserName: function(){},
    setLatestMessage: function(){},
    setLatestMessageId: function(){},
    setNotificationStatus: function(){},
    setObjectName: function(){},
    setReceivedTime: function(){},
    setSenderUserId: function(){},
    getLatestTime: function(){},
    setSentStatus: function(){},
    setSentTime: function(){},
    setTargetId: function(){},
    setTop: function(){},
    setUnreadMessageCount: function(){}
};

RongIMClient.Discussion.prototype = {
    getCreatorId: function(){},
    getId: function(){},
    getMemberIdList: function(){},
    getName: function(){},
    isOpen: function(){},
    setCreatorId: function(){},
    setId: function(){},
    setMemberIdList: function(){},
    setName: function(){},
    setOpen: function(){}
};


RongIMClient.Group.prototype = {
    getId: function(){},
    getName: function(){},
    getPortraitUri: function(){},
    setId: function(){},
    setName: function(){},
    setPortraitUri: function(){}
};
