package org.IRCTC.services;

import org.IRCTC.services.TrainService;
import org.IRCTC.entities.Train;
import org.IRCTC.entities.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.IRCTC.services.TrainService;
import org.IRCTC.util.userServiceUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



public class UserBookingService {

    private User user;

    private List<User> userList;

//    We are using object mapper as we have imported jackson.
   private static final ObjectMapper objectMapper = new ObjectMapper();

//    Final rakhne ka motive ye hai ki path koi change na kar paye, and static is optional bcoz we want the path to
//    be in memory to fetch users easily.

    private static final String USERS_PATH =
            "src/main/java/org/IRCTC/localDB/users.json";


//    Whoever or whenever will create object or call this contructor he/she must have to handle this IOException
//    (this is why we have written throws IOException.

//    This constructor is setting the user with current logged in user and fetching all users from json to list.
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
         this.userList = objectMapper.readValue(
                users,
                new TypeReference<List<User>>() {}
        );
    }

//    Let's now create methods.

    public Boolean loginUser(){

//        Let's dicuss what is stream() filter maps.

//        So in java whenever we create any list.
/*
Let's say we create a list of integers and we want only even integers from that list so in java what we do is we pass
 all those list elements into a stream using .stream() and then we apply filter() to filter whatever elements we
 want, inside this filter we pass the lambda expression onto which filter logic will work.
 */

//   Note -: In java functions are called as 1st class citizens bcoz they can be passed as parameters as well or
//   agruments.
        Optional<User> foundUser = userList.stream().filter(user1->{
            return user1.getName().equals(user.getName()) && userServiceUtil.checkPassword(user.getPassword(),
                    user.getHashedPassword());
        }).findFirst();
        return foundUser.isPresent();
    }

//When user signs up add it to userslist and updates json with new user.
    public Boolean signUp(User user1){
        try{
            userList.add(user1);
            saveuserListToFile();
            return Boolean.TRUE;

        }catch(IOException ex){
            return Boolean.FALSE;
        }
    }


    private void saveuserListToFile() throws IOException{
        File usersFile = new File(USERS_PATH);
        /*
        writeValue() is a Jackson method that converts Java objects into JSON and writes them somewhere (file, string, stream, etc.).It OVERWRITES (replaces) the file content completely.
         */
        objectMapper.writeValue(usersFile,userList);
    }

    public void fetchBooking(){
        user.printTickets();
    }


    public List<User> loadUsers() throws IOException{
        File users = new File(USERS_PATH);

        userList = objectMapper.readValue(users, new TypeReference<List<User>>() {
        });
        return userList;
    }
    public UserBookingService() throws IOException{
        loadUsers();
    }

 public List<Train> getTrains(String source, String destination){
        try{
            org.IRCTC.services.TrainService trainService = new org.IRCTC.services.TrainService();
            return trainService.searchTrains(source,destination);
        }
        catch(Exception e){
            return new ArrayList<>();
        }
 }


}
