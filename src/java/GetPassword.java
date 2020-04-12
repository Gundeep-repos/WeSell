
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vmm.SimpleMailDemo;

public class GetPassword extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String sa = request.getParameter("sa");
        try {
            String q="select * from admin where email = '" + email + "' and sec_ans = '" + sa + "'";
            ResultSet rs = vmm.DBLoader.executeQuery(q);
            
            
            if(rs.next())
            {
                SimpleMailDemo smd= new SimpleMailDemo(email,"Recovery Password","Your Password is"+rs.getString("password"));
                out.println("success");
            }
            else
            {
                out.println("fail");
            }
            

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

    }

}
