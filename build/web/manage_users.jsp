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
        <title>Manage Users</title>
        <script type="text/javascript" src="jquery-1.12.2.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
 
        <script>
            function readandpreview(fileobj, imageid)
            {
                var firstfile = fileobj.files[0];
                var reader = new FileReader();
                reader.onload = (function (f)
                {
                    return function read12(e)
                    {
                        document.getElementById(imageid).src = e.target.result;
                    };
                })(firstfile);
                reader.readAsDataURL(firstfile);
            }
            function fetchUsers()
            {
                var xhr = new XMLHttpRequest;
                xhr.onreadystatechange = function ()
                {
                    if (xhr.readyState === 4 && xhr.status === 200)
                    {
                        var s = xhr.responseText.trim();
                        var mainjson = JSON.parse(s);
                        var ar = mainjson["ans"];
                        console.log(ar);

                        var tb = "<table class=\"table table-hover\">";
                        tb += "<tr><th>UserName</th><th>Email Id</th><th>Profile Photo</th><th></th><th></th></tr>";
                        for (var i = 0; i < ar.length; i++)
                        {
                            var obj = ar[i];
                            tb += "<tr>";
                            tb += "<td>" + obj["name"] + "</td>";
                            tb += "<td>" + obj["email"] + "</td>";
                            tb += "<td><img src='" + obj["photo"] + "' class='img-responsive img-circle' style='width:100px; height:100px;' /></td>";
                            tb += "<td><input class='btn btn-success' type='button' value='Approve' /></td>";
                            tb += "<td><input class='btn btn-danger' type='button' value='Reject' /></td>";
                            tb += "</tr>";
                        }
                        tb += "</table>";
                        document.getElementById("d1").innerHTML = tb;
                    }
                };
                xhr.open("POST", "./ManageUsers", true);
                xhr.send();
            }
        </script>
    </head>
    <body onload="fetchUsers()">
        <div class="container">
            <div class="row">
                <div class="col-sm-1"></div>
                <div class="col-sm-10" id="d1"></div>
                <div class="col-sm-1"></div>
            </div>
        </div>
    </body>
</html>
