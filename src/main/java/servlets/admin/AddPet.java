package servlets.admin;

import models.Pet;
import models.User;
import storage.MemoryStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**.
 * Servlet for add user`s pet
 * @author Petr Arsentev
 * site - http://job4j.ru/
 */

public class AddPet extends HttpServlet {

	private MemoryStorage storage = MemoryStorage.getInstance();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");

		User user = storage.getUserById(request.getParameter("id"));
		Pet pet = new Pet();
		pet.setNick(request.getParameter("nick"));
		pet.setOwnId(Integer.valueOf(request.getParameter("id")));

		pet.setPetId(user.petId.incrementAndGet());
		pet.setType(request.getParameter("type"));

		user.addPet(pet);

		response.sendRedirect(String.format("%s/users/UsersView.do",
				request.getContextPath()));

		//response.sendRedirect(String.format("%s/",request.getContextPath()));

/*		HttpSession session = request.getSession(true);
		User sessionUser = (User) session.getAttribute("user");

		if (sessionUser.getRole().equals("ROLE_ADMIN")) {
			response.sendRedirect(String.format("%s/users/UsersView.do",
					request.getContextPath()));}
		else {
					request.getRequestDispatcher(String.format("%s/users/showpets.do?id=%s", request.getContextPath(),
					request.getParameter("id"))).forward(request, response);
		}*/

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/**
		 * Bind parameter "ownId" for use in edit user operation.
		 */
		request.setAttribute("ownId", request.getParameter("id"));

		/**
		 * Bind parameter "users" for access to database with users
		 */
		request.setAttribute("users", storage.getAll());

		/**
		 * After binding - forward to jsp page with web-interface for enter
		 * data of pet.
		 */

		request.getRequestDispatcher("/WEB-INF/views/users/addPet.jsp").forward(request, response);
	}
}
