package org.example.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class UserService {

    @Getter
    @Setter
    @AllArgsConstructor
    public  class User{
        private String name;
        private int age;
        private String address;
    }

    private User user;

    public UserService(){
        user = new User("Rahul Singh ",20,"Banglore");
    }

    public void logIn(){
        System.out.println("Logging user in");
    }

    public void logout() throws Exception{
        System.out.println("logging user out");
        throw new Exception("unable to logout the user");
    }
}
