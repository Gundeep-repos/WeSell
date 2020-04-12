import vmm.*;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class UserGetPassword extends HttpServlet {

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String email =  request.getParameter("email");
        try
        {
           String ans =  new RDBMS_TO_JSON().generateJSON("select * from userprofiles where email='"+email+"'");
           out.println(ans);
        }
        catch(Exception e)
        {
             e.printStackTrace();
        }
        }
    }