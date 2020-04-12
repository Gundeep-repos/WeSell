<%-- 
    Document   : managecategory
    Created on : 10 Apr, 2018, 3:10:03 PM
    Author     : GUNDEEP
--%>

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
        <script src="js/jquery-1.12.2.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>

        <script>




            function fetchcategory()
            {
                var ans;
                var mainobj;
                var singleobj;
                var obj;
                var xhr = new XMLHttpRequest();

                xhr.open("POST", "./FetchCategory", true);
                xhr.onreadystatechange = function () {


                    if (xhr.status === 200 && xhr.readyState === 4)
                    {



                        ans = xhr.responseText.trim();
//                        console.log(ans);

                        mainobj = JSON.parse(ans);
//                        console.log(mainobj);

                        singleobj = mainobj["ans"];

                        var tb = "<table class=\"table table-hover\"><tr><th>Name</th><th>Description</th><th>Photo</th>\n\
            <th></th><th></th></tr>";
                        for (var i = 0; i < singleobj.length; i++)
                        {
                            obj = singleobj[i];

                            tb += "<tr><td>" + obj.cname + "</td><td>" + obj.cdesc + "</td><td><img src=\"" + obj.cphoto + "\" style=\"width:100px; height:100px\"/></td>";
                            tb += "<td><input type=\"button\" class=\"btn btn-info\" \n\
            value=\"Edit\" onclick=\"editcategory('" + obj.cname + "','" + obj.cdesc + "','" + obj.cphoto + "')\"></td>";
                            tb += "<td><input type=\"button\" class=\"btn btn-info\" value=\"Delete\" \n\
            onclick=\"deletecategory('" + obj.cname + "')\"></td></tr>";

                        }

                        tb += "</table>";
                        document.getElementById("d1").innerHTML = tb;
                    }
                };

                xhr.send();

            }

            function editcategory(cname, cdesc, cphoto)
            {

                document.getElementById("cname").value = cname;
                document.getElementById("cdesc").value = cdesc;
                document.getElementById("im1").src = cphoto;
                document.getElementById("f1").value = null;
                $('#myModal').modal('show');
            }

            function deletecategory(cname)
            {
                alert(cname);
                var res = confirm("Are you sure you want to delete the category?");

                if (res === true)
                {
                    var xhr = new XMLHttpRequest();
                    xhr.open("GET", "./DeleteCategory?cname=" + cname, true);

                    xhr.onreadystatechange = function () {


                        if (xhr.status === 200 && xhr.readyState === 4)
                        {
                            fetchcategory();

                        }
                    };
                    xhr.send();



                } else
                {
                    fetchcategory();
                }
            }

            function updateCategory()
            {

                var ans = "";
                //NEW CODE
                var formdata = new FormData();

                var controls = document.getElementById("form1").elements;
                //var controls = document.forms['form1'].elements;
//                console.log(controls);

//                alert("found " + controls.length + " controls in form");

                var flag = 0;
                for (var i = 0; i < controls.length; i++)
                {
                    if (controls[i].name === "" || controls[i].name === null)
                    {
                        flag = 1;
                    }

                    if (controls[i].type === "file")
                    {
                        if (controls[i].files.length > 0)
                        {
                            ans = ans + controls[i].name + ": " + controls[i].files[0].name + "\n";
                            formdata.append(controls[i].name, controls[i].files[0]);
                        } else
                        {
                            flag = 2;
                        }
                    } else    // for other input types  text,password,select
                    {
                        ans = ans + controls[i].name + ": " + controls[i].value + "\n";
                        //formdata.append("rn",document.getElementById("rn").value);
                        //formdata.append(firstfile.name,firstfile);

                        formdata.append(controls[i].name, controls[i].value);
                    }
//                    alert(ans);
//                    alert(flag);
                }

                if (flag === 1)
                {
                    alert("CHECK: --> Give name attribute to all controls in form");
                } else if (flag == 2)
                {
                    alert("CHECK: --> Select Files for file controls");
                } else
                {
//                    alert(ans);
//                    alert(formdata);

                    var xhr = new XMLHttpRequest;


                    // CORS Policy, should allow OPTIONS 
                    // AJAX uses OPTIONS instead of GET, POST which are enabled by default

                    xhr.open("POST", "./UpdateCategory", true);

                    // xhr.setRequestHeader('Access-Control-Allow-Origin','*');
                    // xhr.setRequestHeader('Access-Control-Allow-Methods', 'OPTIONS');
                    // xhr.setRequestHeader('Access-Control-Allow-Credentials', 'true');

                    //for response receiving
                    xhr.onreadystatechange = function ()
                    {
                        if (xhr.readyState === 4 && xhr.status === 200)
                        {
                            var res = xhr.responseText.trim();
                            console.log(res + "*****************");
                            if (res === "success")
                            {
                                alert("category updated");
                                $('#myModal').modal('hide');
                                fetchcategory();
                            }
                        }
                    };




                    xhr.send(formdata);
                }




            }


            function readandpreview(fileobj, imageid)
            {
                var firstfile = fileobj.files[0];

                var reader = new FileReader();

                //alert("File name: " + firstfile.name);
                //alert("File size: " + firstfile.size);

                reader.onload = (function (f)
                {
                    return function read12(e)
                    {
                        if (firstfile.type.indexOf("image") !== -1)
                        {
                            document.getElementById(imageid).src = e.target.result;
                        } else if (firstfile.type.indexOf("audio") !== -1)
                        {
                            document.getElementById(imageid).src = "audio.jpg";
                        } else if (firstfile.type.indexOf("video") !== -1)
                        {
                            document.getElementById(imageid).src = "video.jpg";
                        } else
                        {
                            document.getElementById(imageid).src = "other.png";
                        }
                    };
                })(firstfile);


                reader.readAsDataURL(firstfile);
            }


        </script>


    </head>
    <body onload="fetchcategory()">
        <div class="container">
            <div class="row" id="d1"></div>

            <div class="modal" id="myModal" >
                <div class="modal-dialog">

                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Modal Header</h4>
                        </div>
                        <div class="modal-body">
                            <form action="#" method="POST" enctype="multipart/form-data" id="form1">
                                <h1>Add Category</h1>

                                <div class="form-group">
                                    <label>Enter Category:</label>&nbsp;
                                    <input type="text" readonly="" placeholder="Enter Category" id="cname" name="cname">
                                </div>
                                <br>
                                <div class="form-group">
                                    <label>Add Description</label>&nbsp;
                                    <textarea placeholder="Category Description" id="cdesc" name="cdesc"></textarea>
                                </div>
                                <br>
                                <div class="form-group">
                                    <label>Add Picture</label>&nbsp;
                                    <input type="file" name="cphoto" id="f1" onchange="readandpreview(this, 'im1')"/>
                                    <img src="" id="im1" style="width: 100px;height: 100px;">
                                    <br>
                                    <br>
                                    <input type="button" class="btn-lg btn-info" name="data"  value="Update" onclick="updateCategory()">

                                </div>

                                <br>
                                <br>


                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>

                </div>
            </div>


        </div>   
    </body>
</html>
