package servlets.admin;

import storage.MemoryStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by user on 2/1/2017.
 */

public class UserDel extends HttpServlet {

    private final MemoryStorage storage = MemoryStorage.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        storage.deleteUser(storage.getUserById(request.getParameter("id")));
        //request.getRequestDispatcher("/WEB-INF/views/UsersView.jsp").forward(request, response);
        request.getRequestDispatcher("/").forward(request, response);
    }
}
