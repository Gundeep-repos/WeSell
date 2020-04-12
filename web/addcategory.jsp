
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
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="jquery-1.12.2.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <script>


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



            function addcategory()
            {
                var ans = "";
                //NEW CODE
                var formdata = new FormData();

                var controls = document.getElementById("form1").elements;
                //var controls = document.forms['form1'].elements;
                console.log(controls);

                // alert("found " + controls.length + " controls in form");

                var flag = 0;
                for (var i = 0; i < controls.length; i++)
                {
                    if (controls[i].name === "" || controls[i].name === null)
                    {
                        flag = 1;
                    }

                    if (controls[i].type == "file")
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

                if (flag == 1)
                {
                    alert("CHECK: --> Give name attribute to all controls in form");
                } else if (flag == 2)
                {
                    alert("CHECK: --> Select Files for file controls");
                } else
                {
                    //alert(ans);
                    //alert(formdata);

                    var xhr = new XMLHttpRequest;


                    // CORS Policy, should allow OPTIONS 
                    // AJAX uses OPTIONS instead of GET, POST which are enabled by default

                    xhr.open("POST", "./AddCategory", true);

                    // xhr.setRequestHeader('Access-Control-Allow-Origin','*');
                    // xhr.setRequestHeader('Access-Control-Allow-Methods', 'OPTIONS');
                    // xhr.setRequestHeader('Access-Control-Allow-Credentials', 'true');

                    //for response receiving
                    xhr.onreadystatechange = function ()
                    {
                        if (xhr.readyState === 4 && xhr.status == 200)
                        {
                            var res = xhr.responseText.trim();
                            if (res == "success")
                            {
                                alert("category added successfuly.");
                                document.getElementById("lb1").innerHTML = "Category Successfuly Added";
                                document.getElementById("lb1").style.color = "green";
                                document.getElementById("form1").reset();
                                document.getElementById("im1").src = "";
                            } else
                            {
                                document.getElementById("lb1").innerHTML = "Unsuccessful"
                                document.getElementById("lb1").style.color = "red";

                            }
                        }
                    };




                    xhr.send(formdata);
                }

            }



        </script>
    </head>
    <body>
        <div class="container">
            <form action="#" method="POST" enctype="multipart/form-data" id="form1">
                <h1>Add Category</h1>

                <div class="form-group">
                    <label>Enter Category:</label>&nbsp;
                    <input type="text" placeholder="Enter Category" id="cname" name="cname">
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

                </div>

                <br>
                <br>


            </form>
        </div>


        <input type="button" value="Submit" onclick="addcategory()"><br><br> 
        <label id="lb1" ></label>
    </body>
</html>
