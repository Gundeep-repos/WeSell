
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import vmm.DBLoader;
import vmm2.FileUploader;

@MultipartConfig
public class PostAdd extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            String pname = request.getParameter("pname");
            String category = request.getParameter("category");
            String brand = request.getParameter("brand");
            String desc = request.getParameter("desc");
            String city = request.getParameter("city");
            String condition = request.getParameter("condition");
            String original_price = request.getParameter("original_price");
            String offer_price = request.getParameter("offer_price");
            String realPath = getServletContext().getRealPath("/products");
            Part part = request.getPart("photo_square");
            String email = (String) session.getAttribute("useremail");
            String newfilename1 = new Date().getTime() + "square.jpg";
            String newfilename2 = new Date().getTime() + "wide.jpg";
            String filename1 = FileUploader.savefileonserver(part, realPath, newfilename1);
            String filename2 = FileUploader.savefileonserver(part, realPath, newfilename2);
            String path_square = "./products/" + filename1;
            String path_wide = "./products/" + filename2;
            ResultSet rs = DBLoader.executeQuery("select * from product_ads");
            // out.println("etho tk chl pya");

            rs.moveToInsertRow();
            rs.updateString("pname", pname);
            rs.updateString("category", category);
            rs.updateString("brand", brand);
            rs.updateString("description", desc);
            rs.updateString("city", city);
            rs.updateString("product_condition", condition);
            rs.updateString("photo_square", path_square);
            rs.updateString("photo_wide", path_wide);
            rs.updateString("original_price", original_price);
            rs.updateString("offer_price", offer_price);
            rs.updateString("email", email);
            rs.insertRow();

            out.println("success");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
