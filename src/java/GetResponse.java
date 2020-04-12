
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetResponse extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String eemail = request.getParameter("eemail");

        try {

            //ResultSet rs=vmm.DBLoader.executeQuery("select * from admin where email = '"+eemail+"'");
            String ans = new vmm.RDBMS_TO_JSON().generateJSON("select * from admin where email = '" + eemail + "'");
            out.println(ans);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
