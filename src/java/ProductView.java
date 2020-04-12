
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductView extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            PrintWriter out = response.getWriter();
            String pid=request.getParameter("pid");
            String q="select * from product_ads inner join userprofiles on product_ads.email=userprofiles.email inner join productphotos on product_ads.pid=productphotos.pid and product_ads.pid='"+pid+"'";
            String ans=new vmm.RDBMS_TO_JSON().generateJSON(q);
            out.println(ans);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
