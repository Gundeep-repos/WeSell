package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class productview_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <script src=\"js/jquery-1.12.2.min.js\" type=\"text/javascript\"></script>\n");
      out.write("\n");
      out.write("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"js/bootstrap.js\" type=\"text/javascript\"></script>\n");
      out.write("\n");
      out.write("        <title>BUY PRODUCT</title>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            function productView(pid)\n");
      out.write("            {\n");
      out.write("                var ans;\n");
      out.write("                var mainobj;\n");
      out.write("                var singleobj;\n");
      out.write("                var obj;\n");
      out.write("                var js;\n");
      out.write("                var xhr = new XMLHttpRequest();\n");
      out.write("                var html2 = \"\";\n");
      out.write("                xhr.open(\"GET\", \"./ProductView?pid=\" + pid, true);\n");
      out.write("                xhr.onreadystatechange = function () {\n");
      out.write("\n");
      out.write("                    if (xhr.status === 200 && xhr.readyState === 4)\n");
      out.write("                    {\n");
      out.write("                        ans = xhr.responseText.trim();\n");
      out.write("                        alert(ans);\n");
      out.write("\n");
      out.write("                        mainobj = JSON.parse(ans);\n");
      out.write("//                        console.log(mainobj);\n");
      out.write("\n");
      out.write("                        singleobj = mainobj[\"ans\"];\n");
      out.write("                        //var html=\"\";\n");
      out.write("                        // console.log(ans);\n");
      out.write("                        var html = \"\";\n");
      out.write("\n");
      out.write("                        obj = singleobj[0];\n");
      out.write("\n");
      out.write("                        html += \"<div class='row'><div class='col-sm-6'>\";\n");
      out.write("                        html += \"<div><img src='\" + obj.photo_wide + \"' class='img img-responsive ' style='width:400px;height:250px; ' /></div >\";\n");
      out.write("                        html += \"<br><div class='row' ><div class='col-sm-3'><img src='\" + obj.photo_square + \"' class='img img-responsive img img-circle' style='width:130px;height:130px; ' /></div>\";\n");
      out.write("                        html += \"<div class='col-sm-6'>\" + obj.pname + \"<br>\";\n");
      out.write("                        html += \"<strike>Original price: \" + obj.original_price + \"</strike><br>\";\n");
      out.write("                        html += \"Offer price: \" + obj.offer_price + \"</div><div class='col-sm-3'></div></div>\";\n");
      out.write("                        // html += \"<div class='col-sm-4'><input type='button' onclick='#' class='btn btn-lg btn-warning' value='BUY'/></div>\"\n");
      out.write("\n");
      out.write("                        html += \"<div><h4>Seller Information:</h4>\"\n");
      out.write("                        html += \"Name: \" + obj.name + \"<br>\";\n");
      out.write("                        html += \"Email: \" + obj.email + \"<br>\";\n");
      out.write("                        html += \"Contact: \" + obj.contact + \"<br>\"\n");
      out.write("                        html += \"</div></div>\"\n");
      out.write("                        html += \"<div class='col-sm-6'>\";\n");
      out.write("                        html += \"<div class='row'  style='border: solid 1px black; margin-top:1px margin-bottom:1px margin-right:1px margin-left:1px'>\"\n");
      out.write("                        html += \"<center><h2>More Photos<h2></center>\";\n");
      out.write("                        for (var i = 0; i < singleobj.length; i++)\n");
      out.write("                        {\n");
      out.write("                            js = singleobj[i];\n");
      out.write("                            html2 += \"<div class='col-sm-4' style=' padding-top:1px padding-bottom:1px padding-left:1px padding-right:1px '>\";\n");
      out.write("                            html2 += \"<img src='\" + js.photo_path + \"' class='img img-responsive' style='width:130px; height:130px;'/>\";\n");
      out.write("                            html2 += \"</div>\";\n");
      out.write("                        }\n");
      out.write("\n");
      out.write("                        html += html2;\n");
      out.write("                        html += \"</div>\";\n");
      out.write("\n");
      out.write("                        html += \"<div><h3>Product Description: </h3><textarea readonly>\" + obj.description + \"</textarea>\";\n");
      out.write("                        html += \"<h3>Brand: </h3>\" + obj.brand + \"</div>\";\n");
      out.write("                        html += \"<br><input type='button' value='BUY NOW' class='btn-lg btn btn-warning' >\";\n");
      out.write("                        html += \"</div></div>\";\n");
      out.write("\n");
      out.write("\n");
      out.write("                        document.getElementById(\"d1\").innerHTML = html;\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                xhr.send();\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            \n");
      out.write("\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    ");
        String pid = request.getParameter("pid");

    
      out.write("\n");
      out.write("    <body onload=\"productView(");
      out.print(pid);
      out.write(")\">\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("\n");
      out.write("\n");
      out.write("            <nav class=\"navbar navbar-inverse\">\n");
      out.write("\n");
      out.write("                <div class=\"container-fluid\" >\n");
      out.write("\n");
      out.write("                    <div class=\"navbar-header\">\n");
      out.write("                        <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#myNavbar\">\n");
      out.write("                            <span class=\"icon-bar\"></span>\n");
      out.write("                            <span class=\"icon-bar\"></span>\n");
      out.write("                            <span class=\"icon-bar\"></span>                        \n");
      out.write("                        </button>\n");
      out.write("                        <a class=\"navbar-brand\" href=\"publicHome.jsp\">WeSell</a>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"collapse navbar-collapse\" id=\"myNavbar\">\n");
      out.write("\n");
      out.write("                        <ul class=\"nav navbar-nav\">\n");
      out.write("                            <li class=\"active\"><a href=\"publicHome.jsp\">Home</a></li>\n");
      out.write("                            <li class=\"active\"><a href=\"#\" onclick=\"openCityModal()\" id=\"selectcity\">Select City</a></li>\n");
      out.write("\n");
      out.write("                        </ul>\n");
      out.write("                        <!--<div class=\"row\"><div id=\"d1\" class=\"col-sm-6\"></div></div>-->\n");
      out.write("\n");
      out.write("                        <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("\n");
      out.write("                            <li><input type=\"text\" placeholder=\"Search Product\" id=\"search\" name=\"search\" style=\"width:380px;height: 40px; margin-top:6px\" onkeyup=\"getProducts()\"/></li>\n");
      out.write("\n");
      out.write("                            <li><br><input type=\"button\" value=\"Search\" class=\"btn-lg btn-info\" \n");
      out.write("                                           onclick=\"window.location.href = 'searchResults.jsp?\\n\\\n");
      out.write("value=' + document.getElementById('search').value + ''\" style=\"margin-top:0px;margin-bottom: 0px\"></li>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <li><a href=\"userSignup.jsp\"><span class=\"glyphicon glyphicon-user\"></span> Sign Up</a></li>\n");
      out.write("                            <li><a href=\"user_login.jsp\"><span class=\"glyphicon glyphicon-log-in\"></span> Login</a></li>\n");
      out.write("                        </ul>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <h1>Product Description</h1>\n");
      out.write("            <div class=\"row\" id=\"d1\">\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
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
