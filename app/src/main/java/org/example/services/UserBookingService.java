package org.example.services;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.example.entities.User;
import org.example.utils.UserServiceutil;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserBookingService {

    private User user;
    private ObjectMapper objectMapper = new ObjectMapper();
    private List<User> userList;
    private static final String USERS_PATH = "app/src/main/java/org/example/localDb/users.json";

    public UserBookingService(User user) throws IOException {
        this.user = user;
        File users = new File(USERS_PATH);
        userList = objectMapper.readValue(users, new TypeReference<List<User>>() {
        });
    }

    public Boolean loginUser() {
        Optional<User> founduser = userList.stream().filter(user -> {
            return user.getName().equals(user.getName()) && UserServiceutil.checkPassword(user.getPassword(), user.getHashpass());
        }).findFirst();
        return founduser.isPresent();
    }

    public Boolean signUp(User user1) {
        try {
            userList.add(user1);
            saveUserListToFile();
            return Boolean.TRUE;
        } catch (IOException ex) {
            return Boolean.FALSE;
        }
    }

    private void saveUserListToFile() throws IOException {
        File files = new File(USERS_PATH);
        objectMapper.writeValue(files, userList);
    }

    public void fetchBookings() {
        System.out.println("Fetching booking...");
        user.printTickets();
    }

    public Optional<User> getUserbyName(String name) {
        return userList.stream().filter(user -> user.getName().equals(name)).findFirst();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean cancelBooking(String ticketId) throws IOException {
        if (ticketId == null || ticketId.isEmpty()) {
            System.out.println("Ticket not booked");
            return Boolean.FALSE;
        }
        boolean isremoved = user.getTicketsBooked().removeIf(ticket -> ticket.getTicketId().equals(ticketId));
        if (isremoved) {
            saveUserListToFile();
            System.out.println("Ticket Id " + ticketId + " canceled");
            return true;
        } else {
            System.out.println("No ticket found with ID " + ticketId);
            return false;
        }
    }
}
