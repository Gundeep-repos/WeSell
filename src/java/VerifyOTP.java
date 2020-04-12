import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.*;


public class VerifyOTP extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            String otp1 = request.getParameter("otp");
            
            String otp = (String) session.getAttribute("OTP");
            
            String email = request.getParameter("email");

            if (otp1.equals(otp)) {
                //out.println(otp+" "+otp1+email);
                ResultSet rs = DBLoader.executeQuery("select * from userprofiles where email=\'" + email + "\'");
                if (rs.next()) {
                    rs.updateString("status", "Verified");
                    session.setAttribute("useremail", email);
                    rs.updateRow();
                    out.println("success");
                }

            } else {
                out.println("fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
