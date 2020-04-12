
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteProduct extends HttpServlet {

    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
try
{
        PrintWriter out = response.getWriter();
        
        int pid=Integer.parseInt(request.getParameter("pid"));
        ResultSet rs=vmm.DBLoader.executeQuery("select * from product_ads where pid="+pid);
        if(rs.next())
        {   
            rs.deleteRow();
            out.println("success");
        }
        
} 
catch(Exception ex)
{
    ex. printStackTrace();
}
}

}
