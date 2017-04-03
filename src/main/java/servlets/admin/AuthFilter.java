package servlets.admin;

import models.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author parsentev
 * @since 11.07.2016
 */

public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        /**.
         * Use HttpServlet "shell"
         */
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        /**.
         * Initialize session attributes
         */
        HttpSession session = req.getSession(true);

        /**.
         * Use User`s object "shell"
         */
        User user = (User) session.getAttribute("user");

        if (req.getRequestURI().contains("/login.do")) {
            chain.doFilter(request, response);
        } else if (session == null || user == null) {
            resp.sendRedirect(String.format("%s/login.do", req.getContextPath()));
        }

        /**.
         * Use construction ((User) user) for define class User for field user
         */
        else if ("ROLE_USER".equals(user.getRole())) {
            chain.doFilter(request, response);

	        //if (req.getRequestURI().contains("/client")) {
		    //    chain.doFilter(request, response);
	        //} else {
		    //    ((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN);
	        //}

            //if (req.getRequestURI().contains("/users/showpets.do")) {
            //    chain.doFilter(request, response);
            //} else {
            //    ((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN);
            //}
        } else {
            if ("ROLE_ADMIN".equals(user.getRole())) {
                chain.doFilter(request, response);
            } else {
                ((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }
}
