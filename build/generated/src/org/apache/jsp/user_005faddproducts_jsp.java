package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class user_005faddproducts_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        \n");
      out.write("        <title>Add Product</title>\n");
      out.write("        <script>\n");
      out.write("            function postAd()\n");
      out.write("            {\n");
      out.write("                var formdata = new FormData();\n");
      out.write("                var controls = document.getElementById(\"myform\").elements;\n");
      out.write("                var flag = 0;\n");
      out.write("                for (var i = 0; i < controls.length; i++)\n");
      out.write("                {\n");
      out.write("                    if (controls[i].name === \"\" || controls[i].name === null)\n");
      out.write("                    {\n");
      out.write("                        flag = 1;\n");
      out.write("                        break;\n");
      out.write("                    }\n");
      out.write("                    if (controls[i].value.trim() === \"\")\n");
      out.write("                    {\n");
      out.write("                        flag = 3;\n");
      out.write("                        break;\n");
      out.write("                    }\n");
      out.write("                    if (controls[i].type === \"file\")\n");
      out.write("                    {\n");
      out.write("                        if (controls[i].files.length > 0)\n");
      out.write("                        {\n");
      out.write("                            formdata.append(controls[i].name, controls[i].files[0]);\n");
      out.write("                        } else\n");
      out.write("                        {\n");
      out.write("                            flag = 2;\n");
      out.write("                            break;\n");
      out.write("                        }\n");
      out.write("                    } else\n");
      out.write("                    {\n");
      out.write("                        formdata.append(controls[i].name, controls[i].value);\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                if (flag === 1)\n");
      out.write("                {\n");
      out.write("                    alert(\"CHECK: --> Give name attribute to all controls in form\");\n");
      out.write("                } else if (flag === 2)\n");
      out.write("                {\n");
      out.write("                    alert(\"CHECK: --> Select Files for file controls\");\n");
      out.write("                } else if (flag === 3)\n");
      out.write("                {\n");
      out.write("                    alert(\"CHECK: --> Give Value to all fields in form \");\n");
      out.write("                } else\n");
      out.write("                {\n");
      out.write("                    var xhr = new XMLHttpRequest;\n");
      out.write("                    xhr.onreadystatechange = function ()\n");
      out.write("                    {\n");
      out.write("                        if (xhr.readyState === 4 && xhr.status === 200)\n");
      out.write("                        {\n");
      out.write("                            alert(xhr.responseText.trim());\n");
      out.write("                            if (xhr.responseText.trim() === \"success\")\n");
      out.write("                            {\n");
      out.write("                                document.getElementById(\"label\").innerHTML = \"<h2>Ad Posted Successfully</h2>\";\n");
      out.write("                                document.getElementById(\"label\").className = \"text-success\";\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("                    };\n");
      out.write("                    xhr.open(\"POST\", \"./PostAdd\", true);\n");
      out.write("                    xhr.send(formdata);\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function readandpreview(fileobj, imageid)\n");
      out.write("            {\n");
      out.write("                var firstfile = fileobj.files[0];\n");
      out.write("                var reader = new FileReader();\n");
      out.write("                reader.onload = (function (f)\n");
      out.write("                {\n");
      out.write("                    return function read12(e)\n");
      out.write("                    {\n");
      out.write("                        document.getElementById(imageid).src = e.target.result;\n");
      out.write("                        document.getElementById(\"image_wide\").src = e.target.result;\n");
      out.write("                    };\n");
      out.write("                })(firstfile);\n");
      out.write("                reader.readAsDataURL(firstfile);\n");
      out.write("            }\n");
      out.write("            function fetchCategory()\n");
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
      out.write("                        var options = \"<option value=''>Select Category</option>\";\n");
      out.write("                        for (var i = 0; i < ar.length; i++)\n");
      out.write("                        {\n");
      out.write("                            var obj = ar[i];\n");
      out.write("                            options += \"<option value='\" + obj[\"cname\"] + \"'>\" + obj[\"cname\"] + \"</option>\";\n");
      out.write("                        }\n");
      out.write("                        document.getElementById(\"category\").innerHTML = options;\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                xhr.open(\"POST\", \"./FetchCategory\", true);\n");
      out.write("                xhr.send();\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body onload=\"fetchCategory()\">\n");
      out.write("        <div class=\"container\" style=\" margin-top:10px ;margin-bottom: 10px; border: solid 2px black; border-radius: 5px; padding: 10px;\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("            <div class=\"col-sm-4\"></div>\n");
      out.write("            <div class=\"jumbotron col-sm-4\" style=\"margin-top: 20px;\"> \n");
      out.write("                <center><h4 class=\"h4\">ADD PRODUCT</h4></center>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-sm-4\"></div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-sm-1\"></div>\n");
      out.write("                <div class=\"col-sm-10\">\n");
      out.write("                <form  method=\"POST\"  enctype=\"multipart/form-data\" id=\"myform\">\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label>PRODUCT NAME</label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"pname\" id=\"pname\" placeholder=\"Enter product name\" />\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label>CATEGORY</label>\n");
      out.write("                        <select class=\"form-control\" id=\"category\" name=\"category\">\n");
      out.write("                            <option value=\"\" disabled  selected>Select Category</option>\n");
      out.write("                        </select>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label>BRAND</label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"brand\" name=\"brand\" placeholder=\"Enter brand name\"/>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label>DESCRIPTION</label>\n");
      out.write("                        <textarea class=\"form-control\" name=\"desc\" id=\"desc\" placeholder=\"Enter description\"></textarea>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label>CITY</label>\n");
      out.write("                        <select class=\"form-control\" id=\"city\" name=\"city\">\n");
      out.write("                            <option value=\"\" selected disabled>Select City</option>\n");
      out.write("                            <option value=\"Amritsar\">AMRITSAR</option>\n");
      out.write("                            <option value=\"Jalandhar\">JALANDHAR</option>\n");
      out.write("                            <option value=\"Ludhiana\">LUDHIANA</option>\n");
      out.write("                            <option value=\"Bathinda\">BATHINDA</option>\n");
      out.write("                            <option value=\"Patiala\">PATIALA</option>\n");
      out.write("                        </select>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label>PRODUCT CONDITION</label>\n");
      out.write("                        <select class=\"form-control\" id=\"condition\" name=\"condition\">\n");
      out.write("                            <option value=\"\" selected disabled>Select Product Condition</option>\n");
      out.write("                            <option value=\"good\">GOOD</option>\n");
      out.write("                            <option value=\"fair\">FAIR</option>\n");
      out.write("                            <option value=\"excellent\">EXCELLENT</option>\n");
      out.write("                        </select>\n");
      out.write("                    </div>\n");
      out.write("                    <br><br><br>\n");
      out.write("               <div class=\"form-group\">\n");
      out.write("                        <label>PHOTO SQUARE</label>\n");
      out.write("                        <img class=\"img-rounded\" src=\"\" id=\"image_square\" name=\"image_square\" style=\"width:150px; height:150px\"/>\n");
      out.write("                    </div>\n");
      out.write("                    <br><br><br><br>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <input class=\"btn\" type=\"file\" name=\"photo_square\" id=\"photo_square\" onchange=\"readandpreview(this, 'image_square')\"/>\n");
      out.write("                    </div>\n");
      out.write("                    <br><br>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label>PHOTO WIDE</label>\n");
      out.write("                        <img class=\"img-rounded\" src=\"\" id=\"image_wide\" name=\"image_wide\" style=\"width:500px; height:150px\"/>\n");
      out.write("                    </div>\n");
      out.write("                    <br><br><br><br>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label>ORIGINAL PRICE</label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"original_price\" name=\"original_price\" placeholder=\"Enter original price\"/>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label>OFFER PRICE</label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"offer_price\" name=\"offer_price\" placeholder=\"Enter original price\"/>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("                <div class=\"col-sm-1\"></div>\n");
      out.write("                </div>\n");
      out.write("            <div class=\"row\">           \n");
      out.write("                <center>\n");
      out.write("                    <input type=\"button\" value=\"POST AD\" name=\"btn\" class=\"btn-primary btn-lg\" onclick=\"postAd()\" />\n");
      out.write("                </center>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <center>  <label id =\"label\" ></label>  </center>\n");
      out.write("            </div>\n");
      out.write("               \n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
