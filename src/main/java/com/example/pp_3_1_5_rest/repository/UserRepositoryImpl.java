package com.example.pp_3_1_5_rest.repository;

import com.example.pp_3_1_5_rest.models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(Long id) {
        try {
            User user = entityManager.find(User.class, id);
            if (user != null) {
                entityManager.remove(user);
            }
        } catch (NullPointerException e) {
            System.out.println("User с указанным вами id не существует!");
        }
    }

    @Override
    public void editUser(Long id, User user) {
        entityManager.merge(user);
    }


    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class)
                .getResultList();
    }

    @Override
    public User getUserByUsername(String username) {
        return entityManager.createQuery("SELECT u FROM User u JOIN FETCH u.roles WHERE u.username = :username", User.class)
                .setParameter("username", username)
                .getSingleResult();
    }
}