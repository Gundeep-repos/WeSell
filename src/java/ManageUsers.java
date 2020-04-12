import java.io.*;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vmm.*;
public class ManageUsers extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String ans = new RDBMS_TO_JSON().generateJSON("select * from userprofiles");
            out.println(ans);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}