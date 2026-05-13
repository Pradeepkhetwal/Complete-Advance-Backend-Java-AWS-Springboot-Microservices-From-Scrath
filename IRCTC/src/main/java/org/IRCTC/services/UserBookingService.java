package org.IRCTC.services;

import IRCTC.src.main.java.org.IRCTC.entities.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class UserBookingService {

    private User user;

    private List<User> userList;

//    We are using object mapper as we have imported
   private static final ObjectMapper objectMapper = new ObjectMapper();

//    Final rakhne ka motive ye hai ki path koi change na kar paye, and static is optional bcoz we want the path to
//    be in memory to fetch users easily.

    private static final String USERS_PATH="../localDB/users.json";


//    Whoever or whenever will create object or call this contructor he/she must have to handle this IOException
//    (this is why we have written throws IOException.
    public UserBookingService(User user1) throws IOException {
        this.user = user1;
        File users = new File(USERS_PATH);


//        Serialization means conversion of java objects to json. Deserilization is ulta of it.
//        Using File class we are accessing the file that is there in the specified path because jakson needs to read
//        to file like json to convert it into a java object.

//        Using readValue it takes 2 params one is the file and other is the classType(in which java object the file
//        is neeeded to be convert we need to pass it's class).

//        Now we use TypeReference when we are dealing with generic types like list (List of which type as list can
//        of any data type ). so during runitme the typereference is required.
        List<User> userList = objectMapper.readValue(
                users,
                new TypeReference<List<User>>() {}
        );
    }
}
