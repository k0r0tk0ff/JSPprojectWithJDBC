package storage;

import models.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Selector of storage -
 * data save in memory or in DB
 */
public class WorkStorage implements Storage {

    /**.
     * Use singleton for storage
/*     */
    private static Storage INSTANCE = null;

    static {
        try {
            INSTANCE = new JDBCstorage();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Chose work storage
     */
    private Storage storage = null;

    public WorkStorage() {
        try {
            storage = new JDBCstorage();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Storage getInstance() {return INSTANCE;}

    @Override
    public void add(User user) { storage.add(user);
    }

    @Override
    public void delUserById(int id) { storage.delUserById(id);
    }

    @Override
    public User getUserById(String id) {
        return storage.getUserById(id);
    }

    @Override
    public User getUserByLogin(String loginForFind) {
        return storage.getUserByLogin(loginForFind);
    }

    @Override
    public List<User> getAll() throws SQLException {
        return INSTANCE.getAll();
    }

    @Override
    public void update(User user) { storage.update(user);
    }

    @Override
    public void deleteUser(User user) { storage.deleteUser(user);
    }

    @Override
    public Optional<User> findByCredentionals(String username, String password) {
         return null;
    }
}
