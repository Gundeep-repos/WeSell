
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String email = (String) session.getAttribute("useremail");
    if (email == null) {
        response.sendRedirect("user_login.jsp?msg=Please Login First.");
        return;
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <script src="js/jquery-1.12.2.min.js" type="text/javascript"></script>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <title>User Home</title>
        <script>
            function changepassword()
            {
                emptylabel();
                var flag = 0;
                var xhr = new XMLHttpRequest;
                var old_pass = document.getElementById("old_pass").value;
                var new_pass = document.getElementById("new_pass").value;
                var cnew_pass = document.getElementById("cnew_pass").value;
                if (new_pass === cnew_pass && flag === 0)
                {
                    xhr.open("GET", "./UserChangePassword?old_pass=" + old_pass + "&new_pass=" + new_pass, true);
                    xhr.onreadystatechange = function ()
                    {
                        if (xhr.status === 200 && xhr.readyState === 4)
                        {
                            alert(xhr.responseText);
                            if (xhr.responseText.trim() === "fail")
                            {
                                document.getElementById("label1").innerHTML = "Old Password is Incorrect";
                                document.getElementById("label1").className = "text-danger";
                                document.getElementById("form1").reset();

                            } else if (xhr.responseText.trim() === "success")
                            {
                                alert("Password changed Successfully");
                                document.getElementById("label1").className = "text-success";
                                $("#myModal").modal('hide');
                                document.getElementById("form1").reset();
                            }
                        }
                    };
                    xhr.send();
                }
            }
            function checkpassword()
            {
                var new_pass = document.getElementById("new_pass").value;
                var cnew_pass = document.getElementById("cnew_pass").value;
                if (new_pass === "")
                {
                    flag = 1;
                    document.getElementById("label2").innerHTML = "Password field cannot be blank";
                    document.getElementById("label2").className = "text-danger";
                    document.getElementById("label3").className = "glyphicon glyphicon-ban-circle";
                    document.getElementById("label3").style.color = "red";
                } else
                {
                    if (new_pass === cnew_pass)
                    {
                        flag = 0;
                        document.getElementById("label2").innerHTML = "Passwords match";
                        document.getElementById("label2").className = "text-success";
                        document.getElementById("label3").className = "glyphicon glyphicon-ok";
                        document.getElementById("label3").style.color = "green";
                    } else
                    {
                        flag = 1;
                        document.getElementById("label2").innerHTML = "Passwords do not match";
                        document.getElementById("label2").className = "text-danger";
                        document.getElementById("label3").className = "glyphicon glyphicon-ban-circle";
                        document.getElementById("label3").style.color = "red";
                    }
                }
            }
            function emptylabel()
            {
                document.getElementById("label1").innerHTML = "";
                document.getElementById("label2").innerHTML = "";
                document.getElementById("label3").className = "";
            }
            function openmodal()
            {
                $('#myModal').modal('show');
            }
            function userlogout()
            {

                var xhr = new XMLHttpRequest;
                xhr.open("GET", "./UserLogout", true);
                xhr.onreadystatechange = function ()
                {

                    if (xhr.status === 200 && xhr.readyState === 4)
                    {
                        if (xhr.responseText.trim() === "success")
                        {
                            alert("Logout Successful");
                            window.location.href = "user_login.jsp";
                        }
                    }
                };
                xhr.send();
            }
        </script>
    </head>
    <body>
        <%
            String useremail = (String) (session.getAttribute("useremail"));
        %>
        <div class="container">
            <h2>Welcome <%=  useremail%></h2>
            <div class="row">
                <a href=# onclick="openmodal()">Change Password</a>
            </div>
            <div class="row">
                <a href="user_addproducts.jsp">Sell Products</a>
            </div>
            <div class="row">
                <a href="user_manageproducts.jsp">Manage Products</a>
            </div>




            <div class="row">
                <a href=# onclick="userlogout()">Logout</a>
            </div>
            <div class="modal fade" id="myModal" >
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <center><h3 class="h3">Change Password</h3></center>
                        </div>
                        <div class="modal-body">
                            <form id="form1">
                                <div class="form-group">                       
                                    <label>OLD PASSWORD</label>
                                    <input type="password" id="old_pass" name="old_pass" class="form-control" onclick="emptylabel()" />                
                                </div>
                                <div class="form-group">   
                                    <label>NEW PASSWORD</label>
                                    <input id="new_pass" name="new_pass" type="password" class="form-control" />              
                                </div>
                                <div class="form-group">   
                                    <label>CONFIRM NEW PASSWORD</label>
                                    <input id="cnew_pass" name="cnew_pass" type="password" class="form-control" onkeyup="checkpassword()"/>
                                    <label class="" id="label3" style="font-size: 15px"></label>
                                    <label class="" id="label2"></label>
                                </div>
                                <div class="form-group">                    
                                    <center><input type="button" value="CHANGE PASSWORD" class="btn-primary btn-lg" onclick="changepassword()" /></center>                               
                                </div>
                            </form>
                            <center> <label id="label1" class="" ></label> </center>
                        </div>
                        <div class="modal-footer">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

