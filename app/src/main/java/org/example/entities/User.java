package org.example.entities;

import java.util.Collections;
import java.util.List;

public class User {

    private String name;
    private String password;
    private String hashPass;
    private List<Ticket> ticketsbooked;
    private String userId;

// constructor
    public User() {
    }

    public User(String username, String password, String hashedPassword, List<Ticket> ticketsBooked, String userId) {
        this.name = name;
        this.userId = userId;
        this.password = password;
        this.hashPass = hashPass;
        this.ticketsbooked = ticketsBooked != null ? ticketsBooked : Collections.emptyList();
    }

    // getter
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getHashpass() {
        return hashPass;
    }

    public List<Ticket> getTicketsBooked() {
        return ticketsbooked;
    }

    public void printTickets(){
        if(ticketsbooked.isEmpty()){
            System.out.println("No tickets booked");
            return;
        }else{
            for(Ticket ticket:ticketsbooked){
                System.out.println(ticket.getTicketInfo());
            }
        }
    }

    public String getUserId() {
        return userId;
    }

    // setter
    public void setName(String name) {
        this.name = name;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setTicketsBooked(List<Ticket> ticketsbooked) {
        this.ticketsbooked = ticketsbooked;
    }

    public void setHashpass(String hashPass) {
        this.hashPass = hashPass;
    }

}
