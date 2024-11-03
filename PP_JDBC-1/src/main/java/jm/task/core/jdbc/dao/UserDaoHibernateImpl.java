package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {

        Transaction transaction = null;

        try (Session session = Util.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            String sql = "CREATE TABLE IF NOT EXISTS Users " +
                    "(Id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    "Name VARCHAR(50) NOT NULL, LastName VARCHAR(50) NOT NULL, " +
                    "Age TINYINT NOT NULL)";

            Query query = session.createSQLQuery(sql).addEntity(User.class);

            query.executeUpdate();
            transaction.commit();
            System.out.println("Created users table");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public void dropUsersTable() {

        Transaction transaction = null;

        try (Session session = Util.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            String sql = "DROP TABLE IF EXISTS Users";

            Query query = session.createSQLQuery(sql).addEntity(User.class);

            query.executeUpdate();
            transaction.commit();
            System.out.println("Dropped users table");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

        }

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

        Transaction transaction = null;

        try (Session session = Util.getSessionFactory().openSession()) {

            User user = new User(name, lastName, age);
            transaction = session.beginTransaction();

            session.save(user);

            transaction.commit();
            System.out.println("Saved user");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public void removeUserById(long id) {

        Transaction transaction = null;

        try (Session session = Util.getSessionFactory().openSession()) {

            User user = session.get(User.class, id);
            transaction = session.beginTransaction();

            session.remove(user);

            transaction.commit();
            System.out.println("Removed user");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public void cleanUsersTable() {
        Transaction transaction = null;

        try (Session session = Util.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            String sql = "TRUNCATE TABLE Users";

            Query query = session.createSQLQuery(sql).addEntity(User.class);

            query.executeUpdate();
            transaction.commit();
            System.out.println("Cleaned users table");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

        }
    }

    @Override
    public List<User> getAllUsers() {
        try (Session session = Util.getSessionFactory().openSession()) {
            return session.createQuery("from Users", User.class).list();
        }
    }
}