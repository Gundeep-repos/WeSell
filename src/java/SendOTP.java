
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import vmm.*;

public class SendOTP extends HttpServlet {


    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try
        {
            
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String OTP= (long)(Math.random()*1000000)+"";
        String contact = request.getParameter("contact");
        HttpSession session=request.getSession();
        session.setAttribute("OTP", OTP);
        session.setAttribute("contact", contact); 
        
        SmsSender.sendMessage("Your OTP for Wesell is: "+OTP,contact);
        
        out.println("success");
            System.out.println(OTP);
        } catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
    }

}
