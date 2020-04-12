
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vmm.*;


public class FetchPhotos extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                try{
                    int pid=Integer.parseInt(request.getParameter("pid"));
                    String ans = new RDBMS_TO_JSON().generateJSON("select * from productphotos where pid="+pid);
                    out.println(ans);
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
    }


}
