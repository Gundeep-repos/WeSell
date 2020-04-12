
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckAdminLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        PrintWriter out = response.getWriter();
        try {
            ResultSet rs = vmm.DBLoader.executeQuery("select * from admin where email ='" + email + "' "
                    + "and password='" + password + "'");

            if (rs.next()) {

                HttpSession session = request.getSession();
                session.setAttribute("email", email);
                out.println("success");

            } else {
                out.println("Invalid Email or Password :(");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        //##code
    }

}
