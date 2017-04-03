package servlets.admin;

/**
 * Add servlet`s dependencies to programm`s logic
 */
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by root on 1/10/17.
 */
public class JsonController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{

        response.setContentType("text/json");
        PrintWriter writer = new PrintWriter(response.getOutputStream());
        writer.append("[{\"login\":\"test2\":\"email\":\"email2\"}]");
        writer.flush();

    }

/*    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MemoryStorage.getInstance().add(
                new User(request.getParameter("login"), "",
                        "", "")
        );

    }*/

}
