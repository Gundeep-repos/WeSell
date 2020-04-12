import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import vmm.DBLoader;
import vmm2.FileUploader;

@MultipartConfig
public class AddPhoto extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int pid = Integer.parseInt(request.getParameter("pid"));
            String caption = request.getParameter("title");
            String desc = request.getParameter("desc");
            Part part = request.getPart("photo");
            String realPath = getServletContext().getRealPath("/products");
            String newfilename = new Date().getTime() + ".jpg";
            String filename = FileUploader.savefileonserver(part, realPath, newfilename);
            String path = "./products/" + filename;
           
            ResultSet rs = DBLoader.executeQuery("select * from productphotos");
           
            rs.moveToInsertRow();
            rs.updateInt("pid", pid);
            rs.updateString("caption", caption);
            rs.updateString("description", desc);
            rs.updateString("photo_path", path);
            
            rs.insertRow();
            out.println("success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}