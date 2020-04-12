package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addcategory_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    String email = (String) session.getAttribute("email");
    if (email == null) {
        response.sendRedirect("admin_login.jsp?msg=Please Login First.");
        return;
    }

      out.write("\n");
      out.write("<html>\n");
      out.write("    \n");
      out.write("    <head>\n");
      out.write("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"jquery-1.12.2.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"js/bootstrap.js\" type=\"text/javascript\"></script>\n");
      out.write("\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            function readandpreview(fileobj, imageid)\n");
      out.write("            {\n");
      out.write("                var firstfile = fileobj.files[0];\n");
      out.write("\n");
      out.write("                var reader = new FileReader();\n");
      out.write("\n");
      out.write("                //alert(\"File name: \" + firstfile.name);\n");
      out.write("                //alert(\"File size: \" + firstfile.size);\n");
      out.write("\n");
      out.write("                reader.onload = (function (f)\n");
      out.write("                {\n");
      out.write("                    return function read12(e)\n");
      out.write("                    {\n");
      out.write("                        if (firstfile.type.indexOf(\"image\") !== -1)\n");
      out.write("                        {\n");
      out.write("                            document.getElementById(imageid).src = e.target.result;\n");
      out.write("                        } else if (firstfile.type.indexOf(\"audio\") !== -1)\n");
      out.write("                        {\n");
      out.write("                            document.getElementById(imageid).src = \"audio.jpg\";\n");
      out.write("                        } else if (firstfile.type.indexOf(\"video\") !== -1)\n");
      out.write("                        {\n");
      out.write("                            document.getElementById(imageid).src = \"video.jpg\";\n");
      out.write("                        } else\n");
      out.write("                        {\n");
      out.write("                            document.getElementById(imageid).src = \"other.png\";\n");
      out.write("                        }\n");
      out.write("                    };\n");
      out.write("                })(firstfile);\n");
      out.write("\n");
      out.write("\n");
      out.write("                reader.readAsDataURL(firstfile);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            function addcategory()\n");
      out.write("            {\n");
      out.write("                var ans = \"\";\n");
      out.write("                //NEW CODE\n");
      out.write("                var formdata = new FormData();\n");
      out.write("\n");
      out.write("                var controls = document.getElementById(\"form1\").elements;\n");
      out.write("                //var controls = document.forms['form1'].elements;\n");
      out.write("                console.log(controls);\n");
      out.write("\n");
      out.write("                alert(\"found \" + controls.length + \" controls in form\");\n");
      out.write("\n");
      out.write("                 var flag = 0;\n");
      out.write("                for (var i = 0; i < controls.length; i++)\n");
      out.write("                {\n");
      out.write("                    if (controls[i].name === \"\" || controls[i].name === null)\n");
      out.write("                    {\n");
      out.write("                        flag = 1;\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                    if (controls[i].type == \"file\")\n");
      out.write("                    {\n");
      out.write("                        if (controls[i].files.length > 0)\n");
      out.write("                        {\n");
      out.write("                            ans = ans + controls[i].name + \": \" + controls[i].files[0].name + \"\\n\";\n");
      out.write("                            formdata.append(controls[i].name, controls[i].files[0]);\n");
      out.write("                        } else\n");
      out.write("                        {\n");
      out.write("                            flag = 2;\n");
      out.write("                        }\n");
      out.write("                    } else    // for other input types  text,password,select\n");
      out.write("                    {\n");
      out.write("                        ans = ans + controls[i].name + \": \" + controls[i].value + \"\\n\";\n");
      out.write("                        //formdata.append(\"rn\",document.getElementById(\"rn\").value);\n");
      out.write("                        //formdata.append(firstfile.name,firstfile);\n");
      out.write("\n");
      out.write("                        formdata.append(controls[i].name, controls[i].value);\n");
      out.write("                    }\n");
      out.write("//                    alert(ans);\n");
      out.write("//                    alert(flag);\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                if (flag == 1)\n");
      out.write("                {\n");
      out.write("                    alert(\"CHECK: --> Give name attribute to all controls in form\");\n");
      out.write("                } else if (flag == 2)\n");
      out.write("                {\n");
      out.write("                    alert(\"CHECK: --> Select Files for file controls\");\n");
      out.write("                }\n");
      out.write("                else\n");
      out.write("                {\n");
      out.write("                    //alert(ans);\n");
      out.write("                    //alert(formdata);\n");
      out.write("\n");
      out.write("                    var xhr = new XMLHttpRequest;\n");
      out.write("                     \n");
      out.write("\n");
      out.write("                    // CORS Policy, should allow OPTIONS \n");
      out.write("                    // AJAX uses OPTIONS instead of GET, POST which are enabled by default\n");
      out.write("                                        \n");
      out.write("                    xhr.open(\"POST\", \"./AddCategory\", true);\n");
      out.write("\n");
      out.write("                    // xhr.setRequestHeader('Access-Control-Allow-Origin','*');\n");
      out.write("                    // xhr.setRequestHeader('Access-Control-Allow-Methods', 'OPTIONS');\n");
      out.write("                    // xhr.setRequestHeader('Access-Control-Allow-Credentials', 'true');\n");
      out.write("\n");
      out.write("                    //for response receiving\n");
      out.write("                    xhr.onreadystatechange = function ()\n");
      out.write("                    {\n");
      out.write("                        if (xhr.readyState === 4 && xhr.status == 200)\n");
      out.write("                        {\n");
      out.write("                           var res=xhr.responseText.trim();\n");
      out.write("                           if(res==\"success\")\n");
      out.write("                           {\n");
      out.write("                               document.getElementById(\"lb1\").innerHTML=\"Category Successfuly Added\";\n");
      out.write("                               document.getElementById(\"lb1\").style.color=\"green\";\n");
      out.write("                           }\n");
      out.write("                           else\n");
      out.write("                           {\n");
      out.write("                               document.getElementById(\"lb1\").innerHTML=\"Unsuccessful\"\n");
      out.write("                               document.getElementById(\"lb1\").style.color=\"red\";\n");
      out.write("                               \n");
      out.write("                           }\n");
      out.write("                                                    }\n");
      out.write("                    };\n");
      out.write("\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("\n");
      out.write("                    xhr.send(formdata);\n");
      out.write("                }\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            \n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("        <form action=\"#\" method=\"POST\" enctype=\"multipart/form-data\" id=\"form1\">\n");
      out.write("        <h1>Add Category</h1>\n");
      out.write("        \n");
      out.write("        <div class=\"form-group\">\n");
      out.write("        <label>Enter Category:</label>&nbsp;\n");
      out.write("        <input type=\"text\" placeholder=\"Enter Category\" id=\"cname\" name=\"cname\">\n");
      out.write("        </div>\n");
      out.write("        <br>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("        <label>Add Description</label>&nbsp;\n");
      out.write("        <textarea placeholder=\"Category Description\" id=\"cdesc\" name=\"cdesc\"></textarea>\n");
      out.write("        </div>\n");
      out.write("        <br>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("        <label>Add Picture</label>&nbsp;\n");
      out.write("        <input type=\"file\" name=\"cphoto\" id=\"f1\" onchange=\"readandpreview(this,'im1')\"/>\n");
      out.write("        <img src=\"\" id=\"im1\" style=\"width: 100px;height: 100px;\">\n");
      out.write("        \n");
      out.write("        </div>\n");
      out.write("                \n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("                \n");
      out.write("        \n");
      out.write("        </form>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <input type=\"button\" value=\"Submit\" onclick=\"addcategory()\"><br><br> \n");
      out.write("        <label id=\"lb1\" ></label>\n");
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
