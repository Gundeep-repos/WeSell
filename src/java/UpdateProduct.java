import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.util.Date;
import vmm.DBLoader;
import vmm2.FileUploader;

@MultipartConfig
public class UpdateProduct extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int pid = Integer.parseInt(request.getParameter("pid"));
            String pname = request.getParameter("pname");
            String category = request.getParameter("category");
            String brand = request.getParameter("brand");
            String description = request.getParameter("desc");
            String city = request.getParameter("city");
            String product_condition = request.getParameter("condition");
            String original_price = request.getParameter("original_price");
            String offer_price = request.getParameter("offer_price");
            String realPath = getServletContext().getRealPath("/products");
            Part part = request.getPart("photo_square");
            ResultSet rs = DBLoader.executeQuery("select * from product_ads where pid=" + pid);
            if (rs.next()) {

                if (part != null) {

                    String newfilename1 = new Date().getTime() + "square.jpg";
                    String newfilename2 = new Date().getTime() + "wide.jpg";
                    String filename1 = FileUploader.savefileonserver(part, realPath, newfilename1);
                    String filename2 = FileUploader.savefileonserver(part, realPath, newfilename2);
                    String path1 = "./products/" + filename1;
                    String path2 = "./products/" + filename2;
                    rs.updateString("photo_square", path1);
                    rs.updateString("photo_wide", path2);

                }
                rs.updateString("pname", pname);
                rs.updateString("category", category);
                rs.updateString("brand", brand);
                rs.updateString("description", description);
                rs.updateString("city", city);
                rs.updateString("product_condition", product_condition);
                rs.updateString("original_price", original_price);
                rs.updateString("offer_price", offer_price);
                rs.updateRow();
                out.println("success");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}