
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CRelatedProducts extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String cname=request.getParameter("cname");
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            String ans=new vmm.RDBMS_TO_JSON().generateJSON("select * from product_ads where category ='"+cname+"'");
            out.println(ans);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
