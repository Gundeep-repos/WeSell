

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

 
@MultipartConfig
public class AddCategory extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
        String cname = request.getParameter("cname");

        try {
            ResultSet rs = vmm.DBLoader.executeQuery("select * from categories where cname='" +cname +"'");
            if (rs.next()) {
                out.println("already exists");
            } else {
                Collection<Part> parts = request.getParts();
                String ans = "";

                String absolutepath = request.getServletContext().getRealPath("/categories");
                System.out.println(absolutepath);

                String newfilename = new Date().getTime() + ".jpg";
                for (Part part : parts) {
                  String filename = vmm2.FileUploader.savefileonserver(part, absolutepath, newfilename);
                    if (filename.equals("not-a-file")) {
                        ans += "<br>" + "This is not file....This is some text data";
                    } else {
                        ans += "<br>" + filename;
                    }
                }
                System.out.println(ans);
                
                String cdesc= request.getParameter("cdesc");
                
                rs.moveToInsertRow();
                rs.updateString("cname", cname);
                rs.updateString("cdesc", cdesc);
               rs.updateString("cphoto","./categories/"+newfilename);
                rs.insertRow();
                
                out.println("success");
                

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }    
}