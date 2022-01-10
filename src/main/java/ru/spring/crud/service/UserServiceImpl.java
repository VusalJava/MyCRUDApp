package ru.spring.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.spring.crud.dao.UserDAO;
import ru.spring.crud.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Override
    public void createUser(User user) {
        userDAO.createUser(user);
    }

    @Override
    public void update(Long id, User user) {
        userDAO.update(id,user);
    }

    @Override
    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    @Override
    public void deleteById(Long id) {
        userDAO.deleteById(id);
    }

    @Override
    public List<User> readAllUsers() {
        return userDAO.readAllUsers();
    }
}
