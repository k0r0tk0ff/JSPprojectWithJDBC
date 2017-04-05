package servlets.admin;

import models.User;
import storage.WorkStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by root on 2/6/17.
 */


public class ShowUserPets extends HttpServlet {

	private WorkStorage storage = (WorkStorage) WorkStorage.getInstance();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/**
		 * Bind parameter "ownId" for use in edit user operation.
		 */
		request.setAttribute("ownId", request.getParameter("id"));

		/**
		 * Bind parameter "users" for access to database with users
		 */
		try {
			request.setAttribute("users", storage.getAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		/**
		 * After binding - forward to jsp page with web-interface for enter
		 * data of pet.
		 */

		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("user");

		request.getRequestDispatcher("/WEB-INF/views/users/showUserPets.jsp").forward(request, response);
	}
}
