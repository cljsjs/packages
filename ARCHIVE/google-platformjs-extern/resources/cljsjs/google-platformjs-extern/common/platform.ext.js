var gapi = {
    "auth2": {
        "GoogleUser": {"isSignedIn": function(){},
                       "getBasicProfile": function(){return {"getId": function(){},
                                                             "getName": function(){},
                                                             "getImageUrl": function(){},
                                                             "getEmail": function(){}
                                                            }}},
        "init": function(){
            return {"currentUser": {"listen": function(){},
                                    "get": function(){
                                        return {"getAuthResponse": function(){
                                            return {"id_token": ""}}}}}}},
        "getAuthInstance": function(){
            return {"signOut": function(){},
                    "signIn": function(){}}
        },
    },
    "load": function () {}
}
