package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class searchResults_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <script src=\"js/jquery-1.12.2.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"js/bootstrap.js\" type=\"text/javascript\"></script>\n");
      out.write("        <title>Search Results</title>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("\n");
      out.write("            function fetchSearchedproducts(search)\n");
      out.write("            {\n");
      out.write("                var ans;\n");
      out.write("                var mainobj;\n");
      out.write("                var singleobj;\n");
      out.write("                var obj;\n");
      out.write("                var xhr = new XMLHttpRequest();\n");
      out.write("\n");
      out.write("                if (search !== \"\")\n");
      out.write("                {\n");
      out.write("\n");
      out.write("\n");
      out.write("                    xhr.open(\"GET\", \"./FetchSearchedproducts?search=\" + search, true);\n");
      out.write("                    xhr.onreadystatechange = function () {\n");
      out.write("\n");
      out.write("                        if (xhr.status === 200 && xhr.readyState === 4)\n");
      out.write("                        {\n");
      out.write("                            ans = xhr.responseText.trim();\n");
      out.write("//                        console.log(ans);\n");
      out.write("\n");
      out.write("                            mainobj = JSON.parse(ans);\n");
      out.write("//                        console.log(mainobj);\n");
      out.write("\n");
      out.write("                            singleobj = mainobj[\"ans\"];\n");
      out.write("                            var html = \"<table class='table table-hover'>\";\n");
      out.write("\n");
      out.write("                            for (var i = 0; i < singleobj.length; i++)\n");
      out.write("                            {\n");
      out.write("                                obj = singleobj[i];\n");
      out.write("                                html += \"<tr><td><img src='\" + obj.photo_square + \"' class='img img-responsive img img-circle' style='width:100px;height:100px; ' /></td>\"\n");
      out.write("                                html += \"<td>\" + obj.pname + \"</td>\";\n");
      out.write("                                html += \"<td><h6><strike>Original price: \" + obj.original_price + \"</strike></h6></td>\";\n");
      out.write("                                html += \"<td></h6>Offer price: \" + obj.offer_price + \"</h6></td>\";\n");
      out.write("                                html += \"<td><input type='button' onclick='#' class='btn btn-lg btn-warning' value='BUY'/></td>\"\n");
      out.write("                                html += \"</tr>\";\n");
      out.write("                            }\n");
      out.write("                            html += \"</table>\";\n");
      out.write("                            document.getElementById(\"d1\").innerHTML = html;\n");
      out.write("                        }\n");
      out.write("                    };\n");
      out.write("                    xhr.send();\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    ");

        String search = request.getParameter("value");

    
      out.write("\n");
      out.write("    <body onload=\"fetchSearchedproducts('");
      out.print(search);
      out.write("')\">\n");
      out.write("        <h1>Search Results</h1>\n");
      out.write("        <div class=\"container\">\n");
      out.write("\n");
      out.write("            <div class=\"row\">\n");
      out.write("\n");
      out.write("                <div class=\"col-sm-2\"></div>\n");
      out.write("\n");
      out.write("                <div class=\"col-sm-8\" id=\"d1\"></div>\n");
      out.write("\n");
      out.write("                <div class=\"col-sm-2\"></div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
