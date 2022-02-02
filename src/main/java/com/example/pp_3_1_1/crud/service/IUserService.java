package com.example.pp_3_1_1.crud.service;

import com.example.pp_3_1_1.crud.model.User;
import java.util.List;

public interface IUserService {

    List<User> getAllUsers();

    User getUserById(int id);

    void createUser(User user);

    void update(int id, User user);

    void delete(int id);
}
