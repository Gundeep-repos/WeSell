<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String email = (String) session.getAttribute("email");
    if (email == null) {
        response.sendRedirect("admin_login.jsp?msg=Please Login First.");
        return;
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Admin Home</title>
        <script src="js/jquery-1.12.2.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>

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
                    xhr.open("GET", "./ChangePassword?old_pass=" + old_pass + "&new_pass=" + new_pass, true);
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
                    document.getElementById("span").className = "glyphicon glyphicon-ban-circle";
                    document.getElementById("span").style.color = "red";
                } else
                {
                    if (new_pass === cnew_pass)
                    {
                        flag = 0;
                        document.getElementById("label2").innerHTML = "Passwords match";
                        document.getElementById("label2").className = "text-success";
                        document.getElementById("span").className = "glyphicon glyphicon-ok";
                        document.getElementById("span").style.color = "green";
                    } else
                    {
                        flag = 1;
                        document.getElementById("label2").innerHTML = "Passwords do not match";
                        document.getElementById("label2").className = "text-danger";
                        document.getElementById("span").className = "glyphicon glyphicon-ban-circle";
                        document.getElementById("span").style.color = "red";
                    }
                }
            }
            function emptylabel()
            {
                document.getElementById("label1").innerHTML= "";
                document.getElementById("label2").innerHTML= "";
                document.getElementById("span").className= "";
            }
            function openmodal()
            {
                $('#myModal').modal('show');
            }



        </script>

    </head>
    <body>
        <div class="container">
            <div class="row">   

                <div class="col-sm-3"></div>

                <div class="col-sm-6">
                    <centre><h1>Welcome <%=session.getAttribute("email")%></h1></centre>

                    <a href="addcategory.jsp">Add Category</a>&nbsp;&nbsp;
                    <a href="managecategory.jsp">Manage Category</a>
                </div>    
                <div class="col-sm-3"></div>

            </div>

            <div class="row">
                <a href=# onclick="openmodal()">Change Password</a>
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
                                    <label>OLD PASSWORD:</label>&nbsp;
                                    <input type="password" id="old_pass" name="old_pass" class="form-control" onclick="emptylabel()" />                
                                </div>
                                <div class="form-group">   
                                    <label>NEW PASSWORD:</label>&nbsp;
                                    <input id="new_pass" name="new_pass" type="password" class="form-control" />              
                                </div>
                                <div class="form-group">   
                                    <label>CONFIRM NEW PASSWORD</label>
                                    <input id="cnew_pass" name="cnew_pass" type="password" class="form-control" onkeyup="checkpassword()"/>
                                    <span class="" id="span" style="font-size: 15px"></span>
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
