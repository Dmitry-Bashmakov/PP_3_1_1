package com.example.pp_3_1_1.crud.dao;
import com.example.pp_3_1_1.crud.model.User;
import java.util.List;

public interface IUserDao {
    List<User> getAllUsers();

    User getUserById(int id);

    void createUser(User user);

    void update(int id, User user);

    void delete(int id);
}
