package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDaoHibernateImpl userDaoHybernate = new UserDaoHibernateImpl();

    @Override
    public void createUsersTable() {
        userDaoHybernate.createUsersTable();
    }

    @Override
    public void dropUsersTable() {
        userDaoHybernate.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        userDaoHybernate.saveUser(name, lastName, age);
    }

    @Override
    public void removeUserById(long id) {
        userDaoHybernate.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDaoHybernate.getAllUsers();
    }

    @Override
    public void cleanUsersTable() {
        userDaoHybernate.cleanUsersTable();
    }
}
