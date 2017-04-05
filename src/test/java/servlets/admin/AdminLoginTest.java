package servlets.admin;

import models.User;
import org.junit.Test;
import service.Settings;
import storage.JDBCstorage;
import storage.WorkStorage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexandr Korotkov (https://github.com/k0r0tk0ff)
 */
public class AdminLoginTest {


    @Test
	public void GetAllUsersFromDB () throws SQLException {

		JDBCstorage storage = JDBCstorage.getInstance();

		List<User> users = new ArrayList<>();

		users = storage.getAll();
	}

	@Test
	public void ConnectToDbUsePreparedStatement () throws SQLException {

		// Use https://habrahabr.ru/sandbox/41444/

		Settings settings = Settings.getInstance();

		final Connection testConnectionOne = DriverManager.getConnection(
				settings.getValue("jdbc.url"),
				settings.getValue("jdbc.username"),
				settings.getValue("jdbc.password"));

		final Statement statement = testConnectionOne.createStatement();

		PreparedStatement preparedStatement = null;

		String prepareSqlQuery = "SELECT * FROM clients";

		//preparedStatement = testConnectionOne.prepareStatement("SELECT * FROM clients");
		preparedStatement = testConnectionOne.prepareStatement(prepareSqlQuery);

		ResultSet resultSet = preparedStatement.executeQuery();

		System.out.print("id           name");


/**.
		 * For correct queries need check type of requested variables -
		 * id need type int, name need type String.
		 * See SQL code, where table "clients" was created.
		 */

		while (resultSet.next()) {
			System.out.print("\n" + resultSet.getInt("id"));
			System.out.print("            " + resultSet.getString("name"));

		}
		testConnectionOne.close();
	}


}
