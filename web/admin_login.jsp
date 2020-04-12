

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="js/jquery-1.12.2.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script>



            function checkadminlogin()
            {
                var email = document.getElementById("email").value;
                var password = document.getElementById("password").value;

                var xhr = new XMLHttpRequest();
                xhr.onreadystatechange = function () {
                    if (xhr.status == 200 && xhr.readyState == 4)
                    {
                        var res = xhr.responseText.trim();
                        alert(res);
                        if (res == 'success')
                        {
                            window.location.href = "admin_home.jsp";

                        } else
                        {
                            document.getElementById("l1").innerHTML = res;

                        }

                    }
                };
                xhr.open("POST", "./CheckAdminLogin?email=" + email + "&password=" + password, true);
                xhr.send();

            }

            function getResponse()
            {
                var ans;
                var mainobj;
                var singleobj;
                var obj;
                var eemail = document.getElementById("eemail").value;

                var xhr = new XMLHttpRequest();
                xhr.onreadystatechange = function () {
                    if (xhr.status === 200 && xhr.readyState === 4)
                    {

                        ans = xhr.responseText.trim();
                        console.log(ans);

                        mainobj = JSON.parse(ans);
//                        console.log(mainobj);

                        singleobj = mainobj["ans"];

                        if (singleobj.length > 0)
                        {

                            var details = singleobj[0];
                            var tb = details["sec_ques"];
                            alert(tb);
                            document.getElementById("lb3").innerHTML = tb;
                            document.getElementById("lb4").style.visibility = "visible";
                            document.getElementById("t1").style.visibility = "visible";
                            document.getElementById("b1").style.visibility = "visible";
                        } else
                        {
                            alert('Invalid Email Address');
                        }

                    }
                };
                xhr.open("POST", "./GetResponse?eemail=" + eemail, true);
                xhr.send();

            }

            function getPassword()
            {
                var sa = document.getElementById("t1").value;
                var eeemail = document.getElementById("eemail").value;

                var xhr = new XMLHttpRequest();
                xhr.onreadystatechange = function () {
                    if (xhr.status == 200 && xhr.readyState == 4)
                    {
                        var res = xhr.responseText.trim();
                        alert(res);
                        if (res === 'success')
                        {
                            document.getElementById("lb5").innerHTML = "Your Password has been sent to your linked Email-Id";
                            document.getElementById("lb5").style.color = "green"
                            

                        } else if(res)
                        {
                            document.getElementById("lb5").innerHTML = "incorrect input";

                        }

                    }
                };
                xhr.open("POST", "./GetPassword?email=" + eeemail + "&sa=" + sa, true);
                xhr.send();


            }
            
            function forgotpassword()
            {
                document.getElementById("form1").reset();
                $('#myModal').modal('show');
                
            }



        </script>



    </head>
    <body>
        <h1>LOGIN</h1>

        <!--modal-->



        <div class="modal" id="myModal" >
            <div class="modal-dialog" >

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Recover Password</h4>
                    </div>
                    <div class="modal-body">
                        <form id="form1">
                            <div class="form-group">
                                <label>Enter Email:</label>&nbsp;
                                <input type="text" palceholder="Enter your Email" name="eemail" id="eemail"/>
                                <input type="button" Value="Submit" onclick="getResponse()"/>
                            </div>
                            <div class="form-group">

                                <label id="lb3"></label>
                            </div>
                            <div class="form-group">
                                <label id="lb4" style="visibility: hidden">Enter Security Answer:</label>&nbsp;
                                <input type="text" placeholder="Security Answer" id="t1" style="visibility: hidden"/>
                                <input  value="Get password" type="button" style="visibility: hidden" onclick="getPassword()" id="b1"/>
                                
                                <%
                                        String msg = request.getParameter("msg");
                                        System.out.println(msg);
                                        if (msg != null) {%>
                                        <script>alert('<%=msg%>');</script>
                                    <%}
                                    %>

                                
                                <label id="lb5"></label>
                            </div>
                        </form>

                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <!--//-->

        <label>Email:</label>&nbsp;
        <input type="email" id="email" name="email" />
        <label>Password:</label>
        <input type="password" id="password" name="password"/>

        <input type="button" value="LOGIN" class="btn btn-info btn-lg"  onclick="checkadminlogin()" />
        <a href="#" onclick="forgotpassword()">Forgot your Password?</a>

        <br>
        <br>
        <label id="l1"> </label>
    </body>
</html>
