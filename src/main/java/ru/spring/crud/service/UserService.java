package ru.spring.crud.service;

import ru.spring.crud.model.User;

import java.util.List;

public interface UserService {

    void createUser(User user);

    void update(Long id,User user);

    User getUserById(Long id);

    List<User> readAllUsers();

    void deleteById(Long id);
}
