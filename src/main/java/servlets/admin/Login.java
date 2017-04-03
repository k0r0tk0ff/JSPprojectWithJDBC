package servlets.admin;

import models.User;
import org.slf4j.Logger;
import storage.MemoryStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 11.07.2016
 */
public class Login extends HttpServlet {
    private static final Logger log = getLogger(Login.class);
    private final MemoryStorage memoryStorage = MemoryStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /**.
         * Add binding object "User" for Http session
         *
         */

        req.getRequestDispatcher("login.jsp").forward(req, resp);
/*        User user = memoryStorage.getUserById(req.getParameter("id"));

        HttpSession session = req.getSession();
        session.setAttribute("user", user);

        if (session == null || user == null) {
        req.getRequestDispatcher("login.jsp").forward(req, resp);}
        else {

            User userForIf = (User) session.getAttribute("user");

            if ("ROLE_ADMIN".equals( userForIf.getRole()))  {
            resp.sendRedirect(String.format("%s/users/UsersView.do", req.getContextPath()));
            }
            else {

            User userForIfTwo = (User) session.getAttribute("user");

            resp.sendRedirect(String.format("%s/users/showpets.do?id=%s",
                req.getContextPath(), String.valueOf(userForIfTwo.getId())));
            }
        }*/
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        /**
         * Bind parameter "users" for access to database with users
         */
        req.setAttribute("users", memoryStorage.getAll());

        Optional<User> result = this.memoryStorage.findByCredentionals(req.getParameter("username"),
                req.getParameter("password"));

        if (result.isPresent()) {
            User user = result.get();
            HttpSession session = req.getSession();
            session.setAttribute("user", user);

            if ("ROLE_ADMIN".equals(user.getRole()))  {
                 resp.sendRedirect(String.format("%s/users/UsersView.do", req.getContextPath()));

            } else {
                 req.setAttribute("ownId", String.valueOf(user.getId()));

                 resp.sendRedirect(String.format("%s/client/showpets.do?id=%s",
                     req.getContextPath(), String.valueOf(user.getId())));
            }
        } else {
            this.doGet(req, resp);
        }
    }
}