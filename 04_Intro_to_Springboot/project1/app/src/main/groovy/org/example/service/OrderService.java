package org.example.service;

import org.example.bean.UserConfig;
import org.junit.jupiter.api.Order;

public class OrderService {
    /*
    Factory method
    A factory method is simply a method whose job is to create and return objects, instead of you creating objects directly using new.
    */

    public static OrderService createInstance(UserService userService, UserConfig userConfig){
        return null;
    }
}
