 /**.
 *
 * Created by mkyong
 *
 * https://www.mkyong.com/jdbc/how-do-connect-to-postgresql-with-jdbc-driver-java/
 */

import service.Settings;

import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

import java.io.File;
import java.io.InputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static service.Settings.getInstance;

public class JDBCconnectorTest {

/*    public static void main(String[] argv) throws Exception {

        *//**.
         *  Check for install JDBC driver
         *//*
        System.out.println("--- PostgreSQL JDBC Connection Testing ----");
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Install PostgreSQL JDBC Driver!");
            e.printStackTrace();
            return;
        }

        System.out.println("PostgreSQL JDBC Driver Registered!");

        *//**.
         *  Test load settings from file
         *  (with public constructor)
         *//*
*//*        Settings settings = new Settings();
        ClassLoader loader = Settings.class.getClassLoader();
        try (InputStream io = loader.getResourceAsStream("dbConnect.properties")) {
            settings.load(io);
        }
        assertThat(settings.getValue("jdbc.username"), is("postgres"));
*//*
        *//**.
         *  Test load settings from file
         *  (with private constructor)
         *//*
        Settings settings = Settings.getInstance();
        assertThat(settings.getValue("jdbc.username"), is("xxx"));

        *//**.
        *  Test connection
        *//*
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(
                    settings.getValue("jdbc.url"),
                    settings.getValue("jdbc.username"),
                    settings.getValue("jdbc.password"));
            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println(" Connect successful !");
        } else {
            System.out.println(" Connection Failed!");
        }
    }*/
}