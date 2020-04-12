import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import vmm.RDBMS_TO_JSON;

public class FetchProducts extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session=request.getSession();
            String email=(String)session.getAttribute("useremail");
            
            String ans = new RDBMS_TO_JSON().generateJSON("select * from product_ads where email='"+email+"'");
            out.println(ans);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}