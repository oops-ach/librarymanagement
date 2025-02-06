package controllers;

import repositories.UserRepository;
import models.User;

import java.sql.SQLException;
import java.util.List;

public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void showAllUsers() {
        try {
            List<User> users = userRepository.getAllUsers();
            for (User user : users) {
                System.out.println(user);
            }
        } catch (SQLException e) {
            System.out.println("Error while fetching users: " + e.getMessage());
        }
    }

    public void addUser(String name, String surname, String bookTitle) {
        try {
            userRepository.addUser(name, surname, bookTitle);
            System.out.println("User added successfully!");
        } catch (SQLException e) {
            System.out.println("Error while adding user: " + e.getMessage());
        }
    }

    public void deleteUser(String name, String surname) {
        try {
            userRepository.deleteUser(name, surname);
            System.out.println("User deleted successfully!");
        } catch (SQLException e) {
            System.out.println("Error while deleting user: " + e.getMessage());
        }
    }
}
