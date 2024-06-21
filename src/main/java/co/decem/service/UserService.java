package co.decem.service;

import java.util.List;

import co.decem.model.User;
import co.decem.model.UserDto;


public interface UserService {


    public List<User> searchUsers(String searchText);

    // Saves a user
    User save(UserDto user);

    // Retrieves all users
    List<User> findAll();

    // Retrieves a user by username
    User findOne(String username);

    User createEmployee(UserDto user);

}