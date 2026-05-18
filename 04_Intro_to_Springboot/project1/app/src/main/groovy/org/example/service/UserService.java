package org.example.service;

import org.example.bean.UserConfig;

public class UserService {
//    We will use th UserConfig bean in this Service.

//    We are doing this without using springboot annotation to acutally know how this actually works in backend.

    UserConfig userConfig;

    public UserService(UserConfig userConfig){this.userConfig = userConfig;
    }
}
