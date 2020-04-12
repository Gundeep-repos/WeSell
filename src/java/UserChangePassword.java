
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.*;

public class UserChangePassword extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
 
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
        
            String email = (String) (session.getAttribute("useremail"));
            String old_pass = request.getParameter("old_pass");
            String new_pass = request.getParameter("new_pass");
            ResultSet rs = DBLoader.executeQuery("select * from userprofiles where email=\'" + email + "\'");
            if (rs.next()) {
                if (old_pass.equals(rs.getString("password"))) {
                    rs.updateString("password", new_pass);
                    rs.updateRow();
                    out.println("success");
                } else {
                    out.println("fail");
                }
            } else {
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
