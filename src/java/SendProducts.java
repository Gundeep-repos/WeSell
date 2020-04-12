
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendProducts extends HttpServlet {

 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        response.setContentType("text/html;charset=UTF-8");
        try {
            String search=request.getParameter("search");
            PrintWriter out = response.getWriter();
            
            String q="select * from product_ads where pname like '%"+search+"%'";
            String ans=new vmm.RDBMS_TO_JSON().generateJSON(q);
            out.println(ans);
            

        } catch (Exception ex) {
            ex.printStackTrace();

        }

    }

}
