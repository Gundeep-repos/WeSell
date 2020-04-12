
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
import vmm2.FileUploader;

@MultipartConfig
public class UserSignup extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String contact = request.getParameter("contact");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String secq = request.getParameter("secq");
        String seca = request.getParameter("seca");
        String gender = request.getParameter("gender");
        String password = request.getParameter("password");

        Part part = request.getPart("photo");

        try {
            String q = "select * from userprofiles where "
                    + "email='" + email + "'";
            System.out.println(q);
            ResultSet rs = vmm.DBLoader.executeQuery(q);
            if (rs.next()) {
                out.println("emailae");
            } else {

                String absolutepath = request.getServletContext().getRealPath("/user-prof-pic");
                System.out.println(absolutepath);

                String newfilename = new Date().getTime() + ".jpg";

                String filename = FileUploader.savefileonserver(part, absolutepath, newfilename);

                rs.moveToInsertRow();
                rs.updateString("photo", "user_prof_pic/" + filename);

                rs.updateString("email", email);
                rs.updateString("name", name);
                rs.updateString("password", password);
                rs.updateString("contact", contact);
                rs.updateString("address", address);
                rs.updateString("city", city);
                rs.updateString("sec_ques", secq);
                rs.updateString("sec_ans", seca);
                rs.updateString("gender", gender);
                rs.insertRow();

                out.println("success");

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
