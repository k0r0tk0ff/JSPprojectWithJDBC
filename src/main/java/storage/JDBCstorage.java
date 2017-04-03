package storage;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Import local packages.
 */
import models.User;
import service.Settings;

/**
 * Storage, where data is saved in DB
 */

public class JDBCstorage implements Storage {
        
    private Connection connection = null;
    private PreparedStatement preparedStatement;
    private Settings settings;
    final List <User> users = new ArrayList<>();

    public JDBCstorage() throws SQLException {
        final Settings settings = Settings.getInstance();

        try {
            this.connection = DriverManager.getConnection(
                    settings.getValue("jdbc.url"),
                    settings.getValue("jdbc.username"),
                    settings.getValue("jdbc.password"));
        } catch (SQLException sqlError) {
            throw new IllegalStateException(sqlError);
        }
        //final Statement statement = connection.createStatement();
        preparedStatement = null;
        this.settings = null;

    }

    @Override
    public void add(User user) {

    }

    @Override
    public void delUserById(int id) {

    }

    @Override
    public User getUserById(String id) {
        return null;
    }

    @Override
    public User getUserByLogin(String loginForFind) {
        return null;
    }

    @Override
    public List<User> getAll() throws SQLException {


        final String prepareSqlQuery = "SELECT * FROM clients";

        try {
            preparedStatement = connection.prepareStatement(prepareSqlQuery);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                users.add(new User
                    (   resultSet.getInt("id"),
                          resultSet.getString("name")
                    )
                );
            }

        } catch (SQLException sqlError) {
            sqlError.printStackTrace();
        }
        // connection.close();
        return users;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public Optional<User> findByCredentionals(String username, String password) {

        Optional<User> userForReturn = Optional.empty();

        for (User findUser: this.users) {
            if(findUser.getLogin().equals(username)) {
                if (findUser.getPassword().equals(password)) userForReturn = Optional.of(findUser);
            }
        }
        return userForReturn;
    }

}
