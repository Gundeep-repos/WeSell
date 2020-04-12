package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class admin_005flogin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <script src=\"js/jquery-1.12.2.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"js/bootstrap.js\" type=\"text/javascript\"></script>\n");
      out.write("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            function checkadminlogin()\n");
      out.write("            {\n");
      out.write("                var email = document.getElementById(\"email\").value;\n");
      out.write("                var password = document.getElementById(\"password\").value;\n");
      out.write("\n");
      out.write("                var xhr = new XMLHttpRequest();\n");
      out.write("                xhr.onreadystatechange = function () {\n");
      out.write("                    if (xhr.status == 200 && xhr.readyState == 4)\n");
      out.write("                    {\n");
      out.write("                        var res = xhr.responseText.trim();\n");
      out.write("                        alert(res);\n");
      out.write("                        if (res == 'success')\n");
      out.write("                        {\n");
      out.write("                            window.location.href = \"admin_home.jsp\";\n");
      out.write("\n");
      out.write("                        } else\n");
      out.write("                        {\n");
      out.write("                            document.getElementById(\"l1\").innerHTML = res;\n");
      out.write("\n");
      out.write("                        }\n");
      out.write("\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                xhr.open(\"POST\", \"./CheckAdminLogin?email=\" + email + \"&password=\" + password, true);\n");
      out.write("                xhr.send();\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function getResponse()\n");
      out.write("            {\n");
      out.write("                var ans;\n");
      out.write("                var mainobj;\n");
      out.write("                var singleobj;\n");
      out.write("                var obj;\n");
      out.write("                var eemail = document.getElementById(\"eemail\").value;\n");
      out.write("\n");
      out.write("                var xhr = new XMLHttpRequest();\n");
      out.write("                xhr.onreadystatechange = function () {\n");
      out.write("                    if (xhr.status === 200 && xhr.readyState === 4)\n");
      out.write("                    {\n");
      out.write("\n");
      out.write("                        ans = xhr.responseText.trim();\n");
      out.write("                        console.log(ans);\n");
      out.write("\n");
      out.write("                        mainobj = JSON.parse(ans);\n");
      out.write("//                        console.log(mainobj);\n");
      out.write("\n");
      out.write("                        singleobj = mainobj[\"ans\"];\n");
      out.write("\n");
      out.write("                        if (singleobj.length > 0)\n");
      out.write("                        {\n");
      out.write("\n");
      out.write("                            var details = singleobj[0];\n");
      out.write("                            var tb = details[\"sec_ques\"];\n");
      out.write("                            alert(tb);\n");
      out.write("                            document.getElementById(\"lb3\").innerHTML = tb;\n");
      out.write("                            document.getElementById(\"lb4\").style.visibility = \"visible\";\n");
      out.write("                            document.getElementById(\"t1\").style.visibility = \"visible\";\n");
      out.write("                            document.getElementById(\"b1\").style.visibility = \"visible\";\n");
      out.write("                        } else\n");
      out.write("                        {\n");
      out.write("                            alert('Invalid Email Address');\n");
      out.write("                        }\n");
      out.write("\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                xhr.open(\"POST\", \"./GetResponse?eemail=\" + eemail, true);\n");
      out.write("                xhr.send();\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function getPassword()\n");
      out.write("            {\n");
      out.write("                var sa = document.getElementById(\"t1\").value;\n");
      out.write("                var eeemail = document.getElementById(\"eemail\").value;\n");
      out.write("\n");
      out.write("                var xhr = new XMLHttpRequest();\n");
      out.write("                xhr.onreadystatechange = function () {\n");
      out.write("                    if (xhr.status == 200 && xhr.readyState == 4)\n");
      out.write("                    {\n");
      out.write("                        var res = xhr.responseText.trim();\n");
      out.write("                        alert(res);\n");
      out.write("                        if (res === 'success')\n");
      out.write("                        {\n");
      out.write("                            document.getElementById(\"lb5\").innerHTML = \"Your Password has been sent to your linked Email-Id\";\n");
      out.write("                            document.getElementById(\"lb5\").style.color = \"green\"\n");
      out.write("                            \n");
      out.write("\n");
      out.write("                        } else if(res)\n");
      out.write("                        {\n");
      out.write("                            document.getElementById(\"lb5\").innerHTML = \"incorrect input\";\n");
      out.write("\n");
      out.write("                        }\n");
      out.write("\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                xhr.open(\"POST\", \"./GetPassword?email=\" + eeemail + \"&sa=\" + sa, true);\n");
      out.write("                xhr.send();\n");
      out.write("\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function forgotpassword()\n");
      out.write("            {\n");
      out.write("                document.getElementById(\"form1\").reset();\n");
      out.write("                $('#myModal').modal('show');\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>LOGIN</h1>\n");
      out.write("\n");
      out.write("        <!--modal-->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"modal\" id=\"myModal\" >\n");
      out.write("            <div class=\"modal-dialog\" >\n");
      out.write("\n");
      out.write("                <!-- Modal content-->\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                        <h4 class=\"modal-title\">Recover Password</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                        <form id=\"form1\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label>Enter Email:</label>&nbsp;\n");
      out.write("                                <input type=\"text\" palceholder=\"Enter your Email\" name=\"eemail\" id=\"eemail\"/>\n");
      out.write("                                <input type=\"button\" Value=\"Submit\" onclick=\"getResponse()\"/>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("\n");
      out.write("                                <label id=\"lb3\"></label>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label id=\"lb4\" style=\"visibility: hidden\">Enter Security Answer:</label>&nbsp;\n");
      out.write("                                <input type=\"text\" placeholder=\"Security Answer\" id=\"t1\" style=\"visibility: hidden\"/>\n");
      out.write("                                <input  value=\"Get password\" type=\"button\" style=\"visibility: hidden\" onclick=\"getPassword()\" id=\"b1\"/>\n");
      out.write("                                \n");
      out.write("                                ");

                                        String msg = request.getParameter("msg");
                                        System.out.println(msg);
                                        if (msg != null) {
      out.write("\n");
      out.write("                                        <script>alert('");
      out.print(msg);
      out.write("');</script>\n");
      out.write("                                    ");
}
                                    
      out.write("\n");
      out.write("\n");
      out.write("                                \n");
      out.write("                                <label id=\"lb5\"></label>\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("\n");
      out.write("                        <div class=\"modal-footer\">\n");
      out.write("                            <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!--//-->\n");
      out.write("\n");
      out.write("        <label>Email:</label>&nbsp;\n");
      out.write("        <input type=\"email\" id=\"email\" name=\"email\" />\n");
      out.write("        <label>Password:</label>\n");
      out.write("        <input type=\"password\" id=\"password\" name=\"password\"/>\n");
      out.write("\n");
      out.write("        <input type=\"button\" value=\"LOGIN\" class=\"btn btn-info btn-lg\"  onclick=\"checkadminlogin()\" />\n");
      out.write("        <a href=\"#\" onclick=\"forgotpassword()\">Forgot your Password?</a>\n");
      out.write("\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <label id=\"l1\"> </label>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
