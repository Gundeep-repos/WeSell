import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vmm.DBLoader;
import vmm.SimpleMailDemo;
public class UserSendPassword extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String email = request.getParameter("email");
            String sec_ans = request.getParameter("sec_ans");
            ResultSet rs = DBLoader.executeQuery("select * from userprofiles where email='" + email + "' and sec_ans='" + sec_ans + "'");
            if (rs.next()) {
                SimpleMailDemo smd = new SimpleMailDemo(email, "Recovery Password", "Your password is " + rs.getString("password"));
                out.println("success");
            } else {
                out.println("fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
