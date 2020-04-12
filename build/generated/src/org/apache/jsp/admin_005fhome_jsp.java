package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class admin_005fhome_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("        <title>Admin Home</title>\n");
      out.write("        <script src=\"js/jquery-1.12.2.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"js/bootstrap.js\" type=\"text/javascript\"></script>\n");
      out.write("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("\n");
      out.write("            function changepassword()\n");
      out.write("            {\n");
      out.write("                emptylabel();\n");
      out.write("                \n");
      out.write("                var flag = 0;\n");
      out.write("                var xhr = new XMLHttpRequest;\n");
      out.write("                var old_pass = document.getElementById(\"old_pass\").value;\n");
      out.write("                var new_pass = document.getElementById(\"new_pass\").value;\n");
      out.write("                var cnew_pass = document.getElementById(\"cnew_pass\").value;\n");
      out.write("                if (new_pass === cnew_pass && flag === 0)\n");
      out.write("                {\n");
      out.write("                    xhr.open(\"GET\", \"./ChangePassword?old_pass=\" + old_pass + \"&new_pass=\" + new_pass, true);\n");
      out.write("                    xhr.onreadystatechange = function ()\n");
      out.write("                    {\n");
      out.write("                        if (xhr.status === 200 && xhr.readyState === 4)\n");
      out.write("                        {\n");
      out.write("                            alert(xhr.responseText);\n");
      out.write("                            if (xhr.responseText.trim() === \"fail\")\n");
      out.write("                            {\n");
      out.write("                                document.getElementById(\"label1\").innerHTML = \"Old Password is Incorrect\";\n");
      out.write("                                document.getElementById(\"label1\").className = \"text-danger\";\n");
      out.write("                                document.getElementById(\"form1\").reset();\n");
      out.write("                            } else if (xhr.responseText.trim() === \"success\")\n");
      out.write("                            {\n");
      out.write("                                alert(\"Password changed Successfully\");\n");
      out.write("                                document.getElementById(\"label1\").className = \"text-success\";\n");
      out.write("                                $(\"#myModal\").modal('hide');\n");
      out.write("                                document.getElementById(\"form1\").reset();\n");
      out.write("\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("                    };\n");
      out.write("                    xhr.send();\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function checkpassword()\n");
      out.write("            {\n");
      out.write("                var new_pass = document.getElementById(\"new_pass\").value;\n");
      out.write("                var cnew_pass = document.getElementById(\"cnew_pass\").value;\n");
      out.write("                if (new_pass === \"\")\n");
      out.write("                {\n");
      out.write("                    flag = 1;\n");
      out.write("                    document.getElementById(\"label2\").innerHTML = \"Password field cannot be blank\";\n");
      out.write("                    document.getElementById(\"label2\").className = \"text-danger\";\n");
      out.write("                    document.getElementById(\"span\").className = \"glyphicon glyphicon-ban-circle\";\n");
      out.write("                    document.getElementById(\"span\").style.color = \"red\";\n");
      out.write("                } else\n");
      out.write("                {\n");
      out.write("                    if (new_pass === cnew_pass)\n");
      out.write("                    {\n");
      out.write("                        flag = 0;\n");
      out.write("                        document.getElementById(\"label2\").innerHTML = \"Passwords match\";\n");
      out.write("                        document.getElementById(\"label2\").className = \"text-success\";\n");
      out.write("                        document.getElementById(\"span\").className = \"glyphicon glyphicon-ok\";\n");
      out.write("                        document.getElementById(\"span\").style.color = \"green\";\n");
      out.write("                    } else\n");
      out.write("                    {\n");
      out.write("                        flag = 1;\n");
      out.write("                        document.getElementById(\"label2\").innerHTML = \"Passwords do not match\";\n");
      out.write("                        document.getElementById(\"label2\").className = \"text-danger\";\n");
      out.write("                        document.getElementById(\"span\").className = \"glyphicon glyphicon-ban-circle\";\n");
      out.write("                        document.getElementById(\"span\").style.color = \"red\";\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function emptylabel()\n");
      out.write("            {\n");
      out.write("                document.getElementById(\"label1\").innerHTML= \"\";\n");
      out.write("                document.getElementById(\"label2\").innerHTML= \"\";\n");
      out.write("                document.getElementById(\"span\").className= \"\";\n");
      out.write("            }\n");
      out.write("            function openmodal()\n");
      out.write("            {\n");
      out.write("                $('#myModal').modal('show');\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">   \n");
      out.write("\n");
      out.write("                <div class=\"col-sm-3\"></div>\n");
      out.write("\n");
      out.write("                <div class=\"col-sm-6\">\n");
      out.write("                    <centre><h1>Welcome ");
      out.print(session.getAttribute("email"));
      out.write("</h1></centre>\n");
      out.write("\n");
      out.write("                    <a href=\"addcategory.jsp\">Add Category</a>&nbsp;&nbsp;\n");
      out.write("                    <a href=\"managecategory.jsp\">Manage Category</a>\n");
      out.write("                </div>    \n");
      out.write("                <div class=\"col-sm-3\"></div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <a href=# onclick=\"openmodal()\">Change Password</a>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal fade\" id=\"myModal\" >\n");
      out.write("                <div class=\"modal-dialog\">\n");
      out.write("                    <div class=\"modal-content\">\n");
      out.write("                        <div class=\"modal-header\">\n");
      out.write("                            <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                            <center><h3 class=\"h3\">Change Password</h3></center>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"modal-body\">\n");
      out.write("                            <form id=\"form1\">\n");
      out.write("                                <div class=\"form-group\">                       \n");
      out.write("                                    <label>OLD PASSWORD:</label>&nbsp;\n");
      out.write("                                    <input type=\"password\" id=\"old_pass\" name=\"old_pass\" class=\"form-control\" onclick=\"emptylabel()\" />                \n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">   \n");
      out.write("                                    <label>NEW PASSWORD:</label>&nbsp;\n");
      out.write("                                    <input id=\"new_pass\" name=\"new_pass\" type=\"password\" class=\"form-control\" />              \n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">   \n");
      out.write("                                    <label>CONFIRM NEW PASSWORD</label>\n");
      out.write("                                    <input id=\"cnew_pass\" name=\"cnew_pass\" type=\"password\" class=\"form-control\" onkeyup=\"checkpassword()\"/>\n");
      out.write("                                    <span class=\"\" id=\"span\" style=\"font-size: 15px\"></span>\n");
      out.write("                                    <label class=\"\" id=\"label2\"></label>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">                    \n");
      out.write("                                    <center><input type=\"button\" value=\"CHANGE PASSWORD\" class=\"btn-primary btn-lg\" onclick=\"changepassword()\" /></center>                               \n");
      out.write("                                </div>\n");
      out.write("                            </form>\n");
      out.write("                            <center> <label id=\"label1\" class=\"\" ></label> </center>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"modal-footer\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
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
