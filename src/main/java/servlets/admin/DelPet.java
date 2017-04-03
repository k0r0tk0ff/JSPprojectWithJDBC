package servlets.admin;

import models.User;
import storage.MemoryStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**.
 * Servlet for del user`s pet
 * @author Petr Arsentev
 * site - http://job4j.ru/
 */

public class DelPet extends HttpServlet {

	private MemoryStorage storage = MemoryStorage.getInstance();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User user = storage.getUserById(request.getParameter("id"));
		int intPetId = Integer.valueOf(request.getParameter("petId"));

		user.delPet(user.getPetById(intPetId));

		/**
		 * Work with http session
		 */

		HttpSession session = request.getSession(true);
		User sessionUser = (User) session.getAttribute("user");

		if (sessionUser.getRole().equals("ROLE_ADMIN")) {
				response.sendRedirect(String.format("%s/users/UsersView.do",
						request.getContextPath()));}
		else {
			//response.sendRedirect(String.format("%s/users/showpets.do?id=%s",
			//		request.getContextPath(), String.valueOf(sessionUser.getId())));

		//	String ownId = String.valueOf(request.getAttribute("ownId"));

			//response.sendRedirect(String.format("%s/users/showpets.do?id=%s", request.getContextPath(),
			//	request.getParameter("ownId")));

			request.getRequestDispatcher(String.format("%s/users/showpets.do?id=%s", request.getContextPath(),
					request.getParameter("id"))).forward(request, response);

			}
		}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User user = storage.getUserById(request.getParameter("id"));
		int intPetId = Integer.valueOf(request.getParameter("petId"));

		user.delPet(user.getPetById(intPetId));

		/**
		 * After binding - forward to jsp page with web-interface for enter
		 * data of pet.
		 */

		request.getRequestDispatcher("/login.do").forward(request, response);
	}
}
