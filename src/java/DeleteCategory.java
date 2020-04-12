

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DeleteCategory extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter() ;
        
        String s=request.getParameter("cname");
        try
        {
            
        ResultSet rs = vmm.DBLoader.executeQuery("select * from categories where cname='"+s+"'");
        if(rs.next())
        {
            rs.deleteRow();
            
        }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    

}
