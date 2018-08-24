package com.example.springboot.dao;

import com.example.springboot.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserHibernateEntityManagerDAO implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void addNewUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUserUserById(long id) {
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.id = ?1");
        query.setParameter(1, id);
        User user = (User)query.getSingleResult();
        return user;
    }

    @Override
    public User getUserByName(String name) {
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.name = ?1");
        query.setParameter(1, name);
        return (User) query.getSingleResult();
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> list = entityManager.createQuery("SELECT u FROM User u").getResultList();
        return list;
    }

    @Override
    public void deleteUserById(long id) {
        entityManager.remove(getUserUserById(id));
    }
}
