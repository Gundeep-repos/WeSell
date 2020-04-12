
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCity extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            Cookie ans[] = request.getCookies();
            String msg="unset";
            for (int i = 0; i < ans.length; i++) {
                Cookie sc = ans[i];
                String nameofcookie = sc.getName();
                if(nameofcookie.equalsIgnoreCase("city"))
                {
                    
                    msg=sc.getValue();
                    break;
                }
            }
            out.println(msg);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
