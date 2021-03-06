package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class user_005flogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>User login</title>\n");
      out.write("        <script src=\"js/jquery-1.12.2.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"js/bootstrap.js\" type=\"text/javascript\"></script>\n");
      out.write("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        \n");
      out.write("        <script>\n");
      out.write("            var contact;\n");
      out.write("            var email;\n");
      out.write("\n");
      out.write("            function userLoginCheck()\n");
      out.write("            {\n");
      out.write("                email = document.getElementById(\"email\").value;\n");
      out.write("                var password = document.getElementById(\"password\").value;\n");
      out.write("\n");
      out.write("                var xhr = new XMLHttpRequest();\n");
      out.write("                xhr.onreadystatechange = function () {\n");
      out.write("                    if (xhr.status == 200 && xhr.readyState == 4)\n");
      out.write("                    {\n");
      out.write("                        var res = xhr.responseText.trim();\n");
      out.write("                        \n");
      out.write("                        if (res == \"success\")\n");
      out.write("                        {\n");
      out.write("                            alert(\"success\");\n");
      out.write("                            window.location.href=\"user_home.jsp\"\n");
      out.write("                        } else if (res == \"Pending\")\n");
      out.write("                        {\n");
      out.write("                            document.getElementById(\"lb1\").innerHTML = \"Pending\";\n");
      out.write("                            document.getElementById(\"btn\").style.visibility = \"Visible\";\n");
      out.write("                        } else if (res == \"fail\")\n");
      out.write("                        {\n");
      out.write("                            document.getElementById(\"lb1\").innerHTML = \"Invalid email or Password\";\n");
      out.write("                        }\n");
      out.write("\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                xhr.open(\"POST\", \"./UserloginCheck?email=\" + email + \"&password=\" + password, true);\n");
      out.write("                xhr.send();\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function sendOTP()\n");
      out.write("            {\n");
      out.write("                contact = document.getElementById(\"contact\").value;\n");
      out.write("\n");
      out.write("                var xhr = new XMLHttpRequest();\n");
      out.write("                xhr.onreadystatechange = function () {\n");
      out.write("                    if (xhr.status == 200 && xhr.readyState == 4)\n");
      out.write("                    {\n");
      out.write("                        var res = xhr.responseText.trim();\n");
      out.write("                        alert(res);\n");
      out.write("                        if (res == 'success')\n");
      out.write("                        {\n");
      out.write("                            $('#myModal').modal('hide');\n");
      out.write("                            alert(\"OTP has been sent\");\n");
      out.write("                            $('#myModal2').modal('show');\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        } else\n");
      out.write("                        {\n");
      out.write("                            document.getElementById(\"l1\").innerHTML = res;\n");
      out.write("\n");
      out.write("                        }\n");
      out.write("\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                xhr.open(\"POST\", \"./SendOTP?contact=\" + contact + \"&email=\" + email, true);\n");
      out.write("                xhr.send();\n");
      out.write("            }\n");
      out.write("            function verifyOTP()\n");
      out.write("            {\n");
      out.write("                xhr = new XMLHttpRequest;\n");
      out.write("                var otp = document.getElementById(\"otp\").value;\n");
      out.write("                xhr.open(\"GET\", \"./VerifyOTP?otp=\" + otp + \"&email=\" + email, true);\n");
      out.write("                xhr.onreadystatechange = function ()\n");
      out.write("                {\n");
      out.write("                    if (xhr.status === 200 && xhr.readyState === 4)\n");
      out.write("                    {\n");
      out.write("                        alert(xhr.responseText);\n");
      out.write("                        if (xhr.responseText.trim() === \"success\")\n");
      out.write("                        {\n");
      out.write("                            $('#myModal2').modal('hide');\n");
      out.write("                            alert(\"Account has been verified.\");\n");
      out.write("                            window.location.href=\"user_home.jsp\";\n");
      out.write("                        } else if (xhr.responseText.trim() === \"fail\")\n");
      out.write("                        {\n");
      out.write("                            alert(\"Invalid OTP\");\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                };\n");
      out.write("                xhr.send();\n");
      out.write("            }\n");
      out.write("            function userForgotPassword()\n");
      out.write("            {\n");
      out.write("                $('#myModal3').modal('show');\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function getPassword()\n");
      out.write("            {\n");
      out.write("                email = document.getElementById(\"email1\").value;\n");
      out.write("                var xhr = new XMLHttpRequest();\n");
      out.write("                xhr.onreadystatechange = function ()\n");
      out.write("                {\n");
      out.write("                    if (xhr.readyState === 4 && xhr.status === 200)\n");
      out.write("                    {\n");
      out.write("                        var s = xhr.responseText.trim();\n");
      out.write("                        //alert(s);\n");
      out.write("                        var mainjson = JSON.parse(s);\n");
      out.write("                        var ar = mainjson[\"ans\"];\n");
      out.write("\n");
      out.write("                        if (ar.length > 0)\n");
      out.write("                        {\n");
      out.write("                            var detail = ar[0];\n");
      out.write("                            var ques = detail[\"sec_ques\"];\n");
      out.write("                            //alert(ques);\n");
      out.write("                            document.getElementById(\"label2\").innerHTML = ques;\n");
      out.write("                            document.getElementById(\"d2\").style.visibility = \"visible\";\n");
      out.write("                            document.getElementById(\"d3\").style.visibility = \"visible\";\n");
      out.write("                        } else\n");
      out.write("                        {\n");
      out.write("                            document.getElementById(\"label1\").innerHTML = \"Invalid Email Id\";\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                };\n");
      out.write("                xhr.open(\"GET\", \"./UserGetPassword?email=\" + email, true);\n");
      out.write("                xhr.send();\n");
      out.write("            }\n");
      out.write("            function sendPassword()\n");
      out.write("            {\n");
      out.write("                email = document.getElementById(\"email1\").value;\n");
      out.write("                var sec_ans = document.getElementById(\"sec_ans\").value;\n");
      out.write("                var xhr = new XMLHttpRequest();\n");
      out.write("                //alert(email);\n");
      out.write("                //alert(sec_ans);\n");
      out.write("                xhr.onreadystatechange = function ()\n");
      out.write("                {\n");
      out.write("                    if (xhr.readyState === 4 && xhr.status === 200)\n");
      out.write("                    {\n");
      out.write("                        var res = xhr.responseText.trim();\n");
      out.write("                        if (res === \"fail\")\n");
      out.write("                        {\n");
      out.write("                            document.getElementById(\"label3\").innerHTML = \"Incorrect Security Answer\";\n");
      out.write("                        } else if (res === \"success\")\n");
      out.write("                        {\n");
      out.write("                            alert(\"Your Password has been sent to your Email Address\");\n");
      out.write("                            $('#myModal3').modal('hide');\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                xhr.open(\"GET\", \"./UserSendPassword?email=\" + email + \"&sec_ans=\" + sec_ans, true);\n");
      out.write("                xhr.send();\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <center><h1>Login</h1></center>\n");
      out.write("\n");
      out.write("    <div class=\"container\" id=\"d1\">\n");
      out.write("\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-sm-3\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-sm-6\">\n");
      out.write("                <div class=\"form-group\">    \n");
      out.write("                    <label>Email:</label>&nbsp;\n");
      out.write("                    <input type=\"email\" id=\"email\" name=\"email\" placeholder=\"Enter Email\" class=\"form-control\"/>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label>Password:</label>&nbsp;\n");
      out.write("                    <input type=\"password\" id=\"password\" name=\"password\" placeholder=\"Enter Password\" class=\"form-control\"/>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("\n");
      out.write("                    <center><input type=\"button\" class=\"btn-info btn-lg\" value=\"Login\" onclick=\"userLoginCheck()\" class=\"form-control\"></center>\n");
      out.write("                    <a href=\"#myModal3\" style=\"color:red\" onclick=\"userForgotPassword()\">FORGOT PASSWORD</a>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <label id=\"lb1\"></label>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-sm-3\">\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <input id=\"btn\" style=\"visibility: hidden\" type=\"button\" class=\"btn btn-info btn-lg\" data-toggle=\"modal\" data-target=\"#myModal\" value=\"Verify Your Account\"/>\n");
      out.write("\n");
      out.write("        <!-- Modal -->\n");
      out.write("        <div class=\"modal\" id=\"myModal\" >\n");
      out.write("            <div class=\"modal-dialog\">\n");
      out.write("\n");
      out.write("                <!-- Modal content-->\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                        <h4 class=\"modal-title\">Verify Account</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                        <label>Enter Mobile Number:</label>&nbsp;\n");
      out.write("                        <input type=\"text\" placeholder=\"Start with +91\" id=\"contact\" name=\"contact\">\n");
      out.write("                        <input type=\"button\" value=\"Send OTP\" onclick=\"sendOTP()\"/>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"modal fade\" id=\"myModal2\">\n");
      out.write("            <div class=\"modal-dialog\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                        <h4 class=\"modal-title\">Verify Your Account</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                        <form>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label>OTP has been sent to your provided contact number</label>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label>Enter OTP</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"otp\"/>\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                        <input type=\"button\" value=\"Verify Account\" class=\"btn btn-primary\" onclick=\"verifyOTP()\"/>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"modal fade\" id=\"myModal3\" >\n");
      out.write("            <div class=\"modal-dialog\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                        <center><h3 class=\"h3\">Recover Password</h3></center>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                        <form >\n");
      out.write("                            <div class=\"form-group\">                       \n");
      out.write("                                <label>Enter Your Email</label>\n");
      out.write("                                <input type=\"email\" id=\"email1\" name=\"email1\" class=\"form-control\" />                \n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">                    \n");
      out.write("                                <center><input type=\"button\" value=\"SUBMIT\" class=\"btn-primary btn-lg\" onclick=\"getPassword()\" /></center>                               \n");
      out.write("                            </div>\n");
      out.write("                            <center> <label id=\"label1\" class=\"\" ></label> </center>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label id=\"label2\" ></label>\n");
      out.write("                            </div> \n");
      out.write("                            <div class=\"form-group\" style=\"visibility: hidden;\" id=\"d2\">\n");
      out.write("                                <label>Security Answer</label>\n");
      out.write("                                <input type=\"text\" id=\"sec_ans\" name=\"sec_ans\" class=\"form-control\" placeholder=\"Enter security answer\" />                \n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\" style=\"visibility: hidden;\" id=\"d3\">                    \n");
      out.write("                                <center><input type=\"button\" value=\"Get Password\" class=\"btn-primary btn-lg\" onclick=\"sendPassword()\" /></center>                               \n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
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
      out.write("                                <label id=\"label3\" ></label>\n");
      out.write("                            </div> \n");
      out.write("                        </form>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-footer\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
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
