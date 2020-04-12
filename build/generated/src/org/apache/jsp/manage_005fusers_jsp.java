package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class manage_005fusers_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Manage Users</title>\n");
      out.write("        <script type=\"text/javascript\" src=\"jquery-1.12.2.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write(" \n");
      out.write("        <script>\n");
      out.write("            function readandpreview(fileobj, imageid)\n");
      out.write("            {\n");
      out.write("                var firstfile = fileobj.files[0];\n");
      out.write("                var reader = new FileReader();\n");
      out.write("                reader.onload = (function (f)\n");
      out.write("                {\n");
      out.write("                    return function read12(e)\n");
      out.write("                    {\n");
      out.write("                        document.getElementById(imageid).src = e.target.result;\n");
      out.write("                    };\n");
      out.write("                })(firstfile);\n");
      out.write("                reader.readAsDataURL(firstfile);\n");
      out.write("            }\n");
      out.write("            function fetchUsers()\n");
      out.write("            {\n");
      out.write("                var xhr = new XMLHttpRequest;\n");
      out.write("                xhr.onreadystatechange = function ()\n");
      out.write("                {\n");
      out.write("                    if (xhr.readyState === 4 && xhr.status === 200)\n");
      out.write("                    {\n");
      out.write("                        var s = xhr.responseText.trim();\n");
      out.write("                        var mainjson = JSON.parse(s);\n");
      out.write("                        var ar = mainjson[\"ans\"];\n");
      out.write("                        console.log(ar);\n");
      out.write("\n");
      out.write("                        var tb = \"<table class=\\\"table table-hover\\\">\";\n");
      out.write("                        tb += \"<tr><th>UserName</th><th>Email Id</th><th>Profile Photo</th><th></th><th></th></tr>\";\n");
      out.write("                        for (var i = 0; i < ar.length; i++)\n");
      out.write("                        {\n");
      out.write("                            var obj = ar[i];\n");
      out.write("                            tb += \"<tr>\";\n");
      out.write("                            tb += \"<td>\" + obj[\"name\"] + \"</td>\";\n");
      out.write("                            tb += \"<td>\" + obj[\"email\"] + \"</td>\";\n");
      out.write("                            tb += \"<td><img src='\" + obj[\"photo\"] + \"' class='img-responsive img-circle' style='width:100px; height:100px;' /></td>\";\n");
      out.write("                            tb += \"<td><input class='btn btn-success' type='button' value='Approve' /></td>\";\n");
      out.write("                            tb += \"<td><input class='btn btn-danger' type='button' value='Reject' /></td>\";\n");
      out.write("                            tb += \"</tr>\";\n");
      out.write("                        }\n");
      out.write("                        tb += \"</table>\";\n");
      out.write("                        document.getElementById(\"d1\").innerHTML = tb;\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                xhr.open(\"POST\", \"./ManageUsers\", true);\n");
      out.write("                xhr.send();\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body onload=\"fetchUsers()\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-sm-1\"></div>\n");
      out.write("                <div class=\"col-sm-10\" id=\"d1\"></div>\n");
      out.write("                <div class=\"col-sm-1\"></div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
