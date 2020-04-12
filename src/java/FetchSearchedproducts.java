
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FetchSearchedproducts extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();

            String search = request.getParameter("search");
            Cookie[] city = request.getCookies();
            String cityincookie = "";
            for (int i = 0; i < city.length; i++) {
                Cookie sc = city[i];
                if (sc.getName().equalsIgnoreCase("city")) {
                    cityincookie = sc.getValue();
                    break;
                }

            }

            String q="select * from product_ads where "
                    + "city='" + cityincookie + "' and pname like '%" + search + "%'";
            System.out.println(q);
            String ans = new vmm.RDBMS_TO_JSON().generateJSON(q);
            out.println(ans);
        } catch (Exception ex) {
            ex.printStackTrace();

        }

    }

}
