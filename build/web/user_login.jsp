

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User login</title>
        <script src="js/jquery-1.12.2.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        
        <script>
            var contact;
            var email;

            function userLoginCheck()
            {
                email = document.getElementById("email").value;
                var password = document.getElementById("password").value;

                var xhr = new XMLHttpRequest();
                xhr.onreadystatechange = function () {
                    if (xhr.status == 200 && xhr.readyState == 4)
                    {
                        var res = xhr.responseText.trim();
                        
                        if (res == "success")
                        {
                            alert("success");
                            window.location.href="user_home.jsp"
                        } else if (res == "Pending")
                        {
                            document.getElementById("lb1").innerHTML = "Pending";
                            document.getElementById("btn").style.visibility = "Visible";
                        } else if (res == "fail")
                        {
                            document.getElementById("lb1").innerHTML = "Invalid email or Password";
                        }

                    }
                };
                xhr.open("POST", "./UserloginCheck?email=" + email + "&password=" + password, true);
                xhr.send();
            }

            function sendOTP()
            {
                contact = document.getElementById("contact").value;

                var xhr = new XMLHttpRequest();
                xhr.onreadystatechange = function () {
                    if (xhr.status == 200 && xhr.readyState == 4)
                    {
                        var res = xhr.responseText.trim();
                        alert(res);
                        if (res == 'success')
                        {
                            $('#myModal').modal('hide');
                            alert("OTP has been sent");
                            $('#myModal2').modal('show');



                        } else
                        {
                            document.getElementById("l1").innerHTML = res;

                        }

                    }
                };
                xhr.open("POST", "./SendOTP?contact=" + contact + "&email=" + email, true);
                xhr.send();
            }
            function verifyOTP()
            {
                xhr = new XMLHttpRequest;
                var otp = document.getElementById("otp").value;
                xhr.open("GET", "./VerifyOTP?otp=" + otp + "&email=" + email, true);
                xhr.onreadystatechange = function ()
                {
                    if (xhr.status === 200 && xhr.readyState === 4)
                    {
                        alert(xhr.responseText);
                        if (xhr.responseText.trim() === "success")
                        {
                            $('#myModal2').modal('hide');
                            alert("Account has been verified.");
                            window.location.href="user_home.jsp";
                        } else if (xhr.responseText.trim() === "fail")
                        {
                            alert("Invalid OTP");
                        }
                    }

                };
                xhr.send();
            }
            function userForgotPassword()
            {
                $('#myModal3').modal('show');

            }

            function getPassword()
            {
                email = document.getElementById("email1").value;
                var xhr = new XMLHttpRequest();
                xhr.onreadystatechange = function ()
                {
                    if (xhr.readyState === 4 && xhr.status === 200)
                    {
                        var s = xhr.responseText.trim();
                        //alert(s);
                        var mainjson = JSON.parse(s);
                        var ar = mainjson["ans"];

                        if (ar.length > 0)
                        {
                            var detail = ar[0];
                            var ques = detail["sec_ques"];
                            //alert(ques);
                            document.getElementById("label2").innerHTML = ques;
                            document.getElementById("d2").style.visibility = "visible";
                            document.getElementById("d3").style.visibility = "visible";
                        } else
                        {
                            document.getElementById("label1").innerHTML = "Invalid Email Id";
                        }
                    }

                };
                xhr.open("GET", "./UserGetPassword?email=" + email, true);
                xhr.send();
            }
            function sendPassword()
            {
                email = document.getElementById("email1").value;
                var sec_ans = document.getElementById("sec_ans").value;
                var xhr = new XMLHttpRequest();
                //alert(email);
                //alert(sec_ans);
                xhr.onreadystatechange = function ()
                {
                    if (xhr.readyState === 4 && xhr.status === 200)
                    {
                        var res = xhr.responseText.trim();
                        if (res === "fail")
                        {
                            document.getElementById("label3").innerHTML = "Incorrect Security Answer";
                        } else if (res === "success")
                        {
                            alert("Your Password has been sent to your Email Address");
                            $('#myModal3').modal('hide');
                        }
                    }
                };
                xhr.open("GET", "./UserSendPassword?email=" + email + "&sec_ans=" + sec_ans, true);
                xhr.send();
            }

        </script>

    </head>
    <body>
    <center><h1>Login</h1></center>

    <div class="container" id="d1">

        <div class="row">
            <div class="col-sm-3">
            </div>
            <div class="col-sm-6">
                <div class="form-group">    
                    <label>Email:</label>&nbsp;
                    <input type="email" id="email" name="email" placeholder="Enter Email" class="form-control"/>

                </div>
                <div class="form-group">
                    <label>Password:</label>&nbsp;
                    <input type="password" id="password" name="password" placeholder="Enter Password" class="form-control"/>
                </div>
                <div class="form-group">

                    <center><input type="button" class="btn-info btn-lg" value="Login" onclick="userLoginCheck()" class="form-control"></center>
                    <a href="#myModal3" style="color:red" onclick="userForgotPassword()">FORGOT PASSWORD</a>



                </div>
                <label id="lb1"></label>
            </div>
            <div class="col-sm-3">
            </div>
        </div>

        <input id="btn" style="visibility: hidden" type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" value="Verify Your Account"/>

        <!-- Modal -->
        <div class="modal" id="myModal" >
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Verify Account</h4>
                    </div>
                    <div class="modal-body">
                        <label>Enter Mobile Number:</label>&nbsp;
                        <input type="text" placeholder="Start with +91" id="contact" name="contact">
                        <input type="button" value="Send OTP" onclick="sendOTP()"/>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>

            </div>
        </div>

        <div class="modal fade" id="myModal2">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Verify Your Account</h4>
                    </div>
                    <div class="modal-body">
                        <form>
                            <div class="form-group">
                                <label>OTP has been sent to your provided contact number</label>
                            </div>
                            <div class="form-group">
                                <label>Enter OTP</label>
                                <input type="text" class="form-control" id="otp"/>
                            </div>
                        </form>
                        <input type="button" value="Verify Account" class="btn btn-primary" onclick="verifyOTP()"/>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>


        <div class="modal fade" id="myModal3" >
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <center><h3 class="h3">Recover Password</h3></center>
                    </div>
                    <div class="modal-body">
                        <form >
                            <div class="form-group">                       
                                <label>Enter Your Email</label>
                                <input type="email" id="email1" name="email1" class="form-control" />                
                            </div>
                            <div class="form-group">                    
                                <center><input type="button" value="SUBMIT" class="btn-primary btn-lg" onclick="getPassword()" /></center>                               
                            </div>
                            <center> <label id="label1" class="" ></label> </center>
                            <div class="form-group">
                                <label id="label2" ></label>
                            </div> 
                            <div class="form-group" style="visibility: hidden;" id="d2">
                                <label>Security Answer</label>
                                <input type="text" id="sec_ans" name="sec_ans" class="form-control" placeholder="Enter security answer" />                
                            </div>
                            <div class="form-group" style="visibility: hidden;" id="d3">                    
                                <center><input type="button" value="Get Password" class="btn-primary btn-lg" onclick="sendPassword()" /></center>                               
                            </div>
                            <div class="form-group">
                                <%
                                        String msg = request.getParameter("msg");
                                        System.out.println(msg);
                                        if (msg != null) {%>
                                        <script>alert('<%=msg%>');</script>
                                    <%}
                                    %>

                                <label id="label3" ></label>
                            </div> 
                        </form>

                    </div>
                    <div class="modal-footer">
                    </div>
                </div>
            </div>
        </div>

    </div>







</body>
</html>
