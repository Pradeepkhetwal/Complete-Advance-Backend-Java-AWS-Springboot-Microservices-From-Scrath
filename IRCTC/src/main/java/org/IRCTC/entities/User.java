package org.IRCTC.entities;

import java.util.List;

public class User {

    private String name;

    private String password;

    private String hashedPassword;

    private List<org.IRCTC.entities.Ticket> ticketBooked;

    private String userId;

    public User(String name, String password, String hashedPassword,
                List<org.IRCTC.entities.Ticket> ticketBooked,String userId){
        this.name = name;
        this.password = password;
        this.hashedPassword = hashedPassword;
        this.ticketBooked = ticketBooked;
        this.userId = userId;

    }

//    Default constructor.
    public User(){}

//    getter
    public String getName(){
        return this.name;
//        or we can also write return name both are same.
    }

    public String getPassword(){
        return password;
    }

    public String getHashedPassword(){
        return hashedPassword;
    }

  public List<org.IRCTC.entities.Ticket> getTicketBooked(){
        return ticketBooked;
  }

  public void printTickets(){
        for(int i = 0; i<ticketBooked.size();i++){
            System.out.println(ticketBooked.get(i).getTicketInfo());
        }
  }

  public String getUserId(){
        return userId;
  }

//  Setters

    public void setName(String name){
        this.name= name;
    }

    public void setHashedPassword(String hashedPassword){
        this.hashedPassword = hashedPassword;
    }



}
