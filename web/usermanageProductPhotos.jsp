<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String email = (String) session.getAttribute("useremail");
    if (email == null) {
        response.sendRedirect("user_login.jsp?msg=Please Login First.");
        return;
    }
%>


<% int pid = Integer.parseInt(request.getParameter("pid"));
%>

<html>
    <head>   
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jquery-1.12.2.min.js" type="text/javascript"></script>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <title>Manage Product Photos </title>
        <script>


            function addphotos(pid)
            {

                var formdata = new FormData();
                var controls = document.getElementById("myform").elements;
                var flag = 0;
                for (var i = 0; i < controls.length; i++)
                {
                    if (controls[i].name === "" || controls[i].name === null)
                    {
                        flag = 1;
                        break;
                    }
                    if (controls[i].value.trim() === "")
                    {
                        flag = 3;
                        break;
                    }
                    if (controls[i].type === "file")
                    {
                        if (controls[i].files.length > 0)
                        {
                            formdata.append(controls[i].name, controls[i].files[0]);
                        } else
                        {
                            flag = 2;
                            break;
                        }
                    } else
                    {
                        formdata.append(controls[i].name, controls[i].value);
                    }
                }
                if (flag === 1)
                {
                    alert("CHECK: --> Give name attribute to all controls in form");
                } else if (flag === 2)
                {
                    alert("CHECK: --> Select Files for file controls");
                } else if (flag === 3)
                {
                    alert("CHECK: --> Give Value to all fields in form ");
                } else
                {
                    var xhr = new XMLHttpRequest;
                    xhr.onreadystatechange = function ()
                    {
                        if (xhr.readyState === 4 && xhr.status === 200)
                        {
//                            alert(xhr.responseText.trim());
                            if (xhr.responseText.trim() === "success")
                            {
                                document.getElementById("label").innerHTML = "<h2>Photo Added Successfully</h2>";
                                document.getElementById("label").className = "text-success";
                                document.getElementById("myform").reset();
                                document.getElementById("image").src = "";
                                
                                fetchPhotos();
                            }
                        }
                    };
                    xhr.open("POST", "./AddPhoto?pid=" + pid, true);
                    xhr.send(formdata);
                }
            }

            function fetchPhotos()
            {
                var xhr = new XMLHttpRequest;
                xhr.onreadystatechange = function ()
                {
                    if (xhr.readyState === 4 && xhr.status === 200)
                    {
                        var res = xhr.responseText.trim();
//                        console.log(res);
//                        if (res === "success")
//                        {
                        var s = xhr.responseText.trim();
                        console.log(s);
                        var mainjson = JSON.parse(s);
                        var ar = mainjson["ans"];
                        console.log(ar);
                        var html = "";
                        for (var i = 0; i < ar.length; i++)
                        {
                            var obj = ar[i];
                            html += "<div class='col-sm-3'>\n\
            <img src=\"" + obj.photo_path + "\" class='img img-rounded' style='width:100px; height:100px;' /><br>";
                            html += "<label style='display:inline;margin:1px'><input style='margin:3px' type='button' id='bt" + i + "' value='Del' class='btn btn-default' onclick='deletePhoto(" + obj.photo_id + ")'> " + obj["caption"] + "</label></div>";
                        }
                        document.getElementById("d1").innerHTML = html;
//                        }
                    }
                };
                xhr.open("POST", "./FetchPhotos?pid=" +<%=pid%>, true);
                xhr.send();
            }

            function deletePhoto(phid)
            {
                var cnfrm = confirm("Are you Sure you wanr to delete this photo?");
                if (cnfrm === true)
                {

                    var xhr = new XMLHttpRequest;
                    xhr.onreadystatechange = function ()
                    {
                        if (xhr.readyState === 4 && xhr.status === 200)
                        {
                            var res = xhr.responseText.trim();
                            alert(res);
                            if (res === "success")
                            {
                                document.getElementById("label").innerHTML = "Photo Deleted Successfully";
                                document.getElementById("label").className = "text-success";

                                fetchPhotos();
                            } else
                            {

                            }

                        }
                    };
                    xhr.open("POST", "./DeletePhoto?phid=" + phid, true);
                    xhr.send();
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
    <body onload="fetchPhotos()">

        <h1 class="h3">Add new Photo</h1>
        <div class="container">


            <div class="row">
                <div class="col-sm-4">          


                    <form method="POST" action="#" enctype="multipath/form-data" id="myform">    
                        <div class="form-group">
                            <label>Photo Title:</label>&nbsp;
                            <input type="text" class='form-control' placeholder="Title" id="title" name="title"/>
                        </div>
                        <div class="form-group">
                            <label>Photo Description:</label>&nbsp;
                            <textarea class="form-control" placeholder="Description" id="description" name="desc"></textarea>
                        </div>
                        <div class="form-group">
                            <label>Photo:</label>&nbsp;
                            &nbsp;<img src="" class=" img-responsive img-rounded" id="image" name="image" style="width: 100px; height: 150px;"/>

                        </div>

                        <div class="form-group">
                            <br><br><br>
                            <input type="file" class="btn" id="photo" name="photo"  onchange='readandpreview(this, "image")'/>
                        </div>

                        <label id="label"></label>



                    </form>
                    <div class='row'>
                        <center>
                            <input type='button' value="ADD PHOTO" class='btn btn-primary' onclick="addphotos(<%=pid%>)"/>
                        </center>
                    </div>


                </div>

                <div class='col-sm-8'>
                    <h2 class="h3">Already Added Photos</h2>
                    <div class="row" id="d1">

                    </div>
                </div>
            </div>
        </div>>

    </body>
</html>
