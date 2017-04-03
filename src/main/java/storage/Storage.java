package storage;

import models.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**.
 * Interface for save users.
 * @author Petr Arsentev
 * site - http://job4j.ru/
 */
public interface Storage {

    /**
    * Describe how to add a user to database.
    */
    void add(User user);

    /**
     * Describe how to del a user to database.
     */
    void delUserById(int id);

    /**
     * Describe how to get a user from database.
     */
    User getUserById(String id);

    /**
     * Describe how to get a user from database by login.
     */
    User getUserByLogin(String loginForFind);

    /**
     * Describe how to get all users from database.
     */
    List<User> getAll() throws SQLException;

    /**
     * Describe how to update a user from database.
     */
    void update(User user);

    /**
     * Describe how to delete a user from database.
     */
    void deleteUser(User user);

    /**.
     * User findByCridentional(String username, String password) use in login page
     *
     * @param username - entered username
     * @param password - entered password
     *
     *  Get a user from database by username and password
     */
    Optional<User> findByCredentionals(String username, String password);

}
