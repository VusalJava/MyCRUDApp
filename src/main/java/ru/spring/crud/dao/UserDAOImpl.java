package ru.spring.crud.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.spring.crud.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> readAllUsers() {
        return entityManager.createQuery("from " + User.class.getName()).getResultList();
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public void deleteById(Long id) {
        User userById = getUserById(id);
        if (userById != null) {
            entityManager.remove(userById);
        } else {
            System.out.println("There is no such user");
        }

    }
    @Override
    public void update(Long id, User user) {
        User newUser = getUserById(id);
        newUser.setName(user.getName());
        newUser.setMailAddress(user.getMailAddress());
        entityManager.merge(newUser);
    }


}
