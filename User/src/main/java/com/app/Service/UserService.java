package com.app.Service;

import com.app.Entity.User;
import com.app.exception.ResourceNotFound;

import java.util.List;

public interface UserService {
    //Create User
     public User save(User user);

    //Update User
    public User update(User user, String id) throws ResourceNotFound;

    //Delete User
    public User delete(String id) throws ResourceNotFound;

    //Get User Based On Id
    public User get(String id) throws ResourceNotFound;

    //Get All Users
    public List<User> getAllUsers();
}
