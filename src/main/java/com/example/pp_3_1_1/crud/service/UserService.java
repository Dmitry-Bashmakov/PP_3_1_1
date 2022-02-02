package com.example.pp_3_1_1.crud.service;

import com.example.pp_3_1_1.crud.dao.IUserDao;
import com.example.pp_3_1_1.crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements IUserService{

    IUserDao dao;

    @Autowired
    public UserService(IUserDao dao) {
        this.dao = dao;
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    @Transactional
    @Override
    public User getUserById(int id) {
        return dao.getUserById(id);
    }

    @Transactional
    @Override
    public void createUser(User user) {
        dao.createUser(user);
    }

    @Transactional
    @Override
    public void update(int id, User user) {
        dao.update(id, user);
    }

    @Transactional
    @Override
    public void delete(int id) {
        dao.delete(id);
    }
}
