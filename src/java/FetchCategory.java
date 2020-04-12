
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.console;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FetchCategory extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
        {
          //ResultSet rs = vmm.DBLoader.executeQuery("select * from categories");
          
          String ans= new vmm.RDBMS_TO_JSON().generateJSON("select * from categories");
          out.println(ans);
         
            
        }
        catch(Exception ex)
                {
                    ex.printStackTrace();                  
                }
        
    }

    

}
