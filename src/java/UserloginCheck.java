
import com.mysql.jdbc.Messages;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserloginCheck extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        


//out.println(email);
        //out.println(password);
        try {

            ResultSet rs = vmm.DBLoader.executeQuery("select * from userprofiles where email=\'" + email + "\' and password = \'" + password + "\'");
            if (rs.next()) {
                String strng = rs.getString("status");
                //out.println(strng);
                if (strng.equals("Pending")) 
                {
                    out.println("Pending");
                }
                else 
                {
                    HttpSession session=request.getSession();
                    session.setAttribute("useremail",email);
                    out.println("success");
                }
            }
            else {
                out.println("fail");
                
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
