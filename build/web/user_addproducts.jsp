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
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>

        <title>Add Product</title>
        <script>
            function postAd()
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
                            alert(xhr.responseText.trim());
                            if (xhr.responseText.trim() === "success")
                            {
                                document.getElementById("label").innerHTML = "<h2>Ad Posted Successfully</h2>";
                                document.getElementById("label").className = "text-success";
                                document.getElementById("myform").reset();
                                document.getElementById("image_square").src = "";
                                document.getElementById("image_square").src = "";

                            }
                        }
                    };
                    xhr.open("POST", "./PostAdd", true);
                    xhr.send(formdata);
                }
            }
            function readandpreview(fileobj, imageid)
            {
                var firstfile = fileobj.files[0];
                var reader = new FileReader();
                reader.onload = (function (f)
                {
                    return function read12(e)
                    {
                        document.getElementById(imageid).src = e.target.result;
                        document.getElementById("image_wide").src = e.target.result;
                    };
                })(firstfile);
                reader.readAsDataURL(firstfile);
            }
            function fetchCategory()
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
                        var options = "<option value=''>Select Category</option>";
                        for (var i = 0; i < ar.length; i++)
                        {
                            var obj = ar[i];
                            options += "<option value='" + obj["cname"] + "'>" + obj["cname"] + "</option>";
                        }
                        document.getElementById("category").innerHTML = options;
                    }
                };
                xhr.open("POST", "./FetchCategory", true);
                xhr.send();
            }
        </script>
    </head>
    <body onload="fetchCategory()">
        <div class="container" style=" margin-top:10px ;margin-bottom: 10px; border: solid 2px black; border-radius: 5px; padding: 10px;">
            <div class="row">
                <div class="col-sm-4"></div>
                <div class="jumbotron col-sm-4" style="margin-top: 20px;"> 
                    <center><h4 class="h4">ADD PRODUCT</h4></center>
                </div>
                <div class="col-sm-4"></div>
            </div>
            <div class="row">
                <div class="col-sm-1"></div>
                <div class="col-sm-10">
                    <form  method="POST"  enctype="multipart/form-data" id="myform">
                        <div class="form-group">
                            <label>PRODUCT NAME</label>
                            <input type="text" class="form-control" name="pname" id="pname" placeholder="Enter product name" />
                        </div>
                        <div class="form-group">
                            <label>CATEGORY</label>
                            <select class="form-control" id="category" name="category">
                                <option value="" disabled  selected>Select Category</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>BRAND</label>
                            <input type="text" class="form-control" id="brand" name="brand" placeholder="Enter brand name"/>
                        </div>
                        <div class="form-group">
                            <label>DESCRIPTION</label>
                            <textarea class="form-control" name="desc" id="desc" placeholder="Enter description"></textarea>
                        </div>
                        <div class="form-group">
                            <label>CITY</label>
                            <select class="form-control" id="city" name="city">
                                <option value="" selected disabled>Select City</option>
                                <option value="Amritsar">AMRITSAR</option>
                                <option value="Jalandhar">JALANDHAR</option>
                                <option value="Ludhiana">LUDHIANA</option>
                                <option value="Bathinda">BATHINDA</option>
                                <option value="Patiala">PATIALA</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>PRODUCT CONDITION</label>
                            <select class="form-control" id="condition" name="condition">
                                <option value="" selected disabled>Select Product Condition</option>
                                <option value="good">GOOD</option>
                                <option value="fair">FAIR</option>
                                <option value="excellent">EXCELLENT</option>
                            </select>
                        </div>
                        <br><br><br>
                        <div class="form-group">
                            <label>PHOTO SQUARE</label>
                            <img class="img-rounded" src="" id="image_square" name="image_square" style="width:150px; height:150px"/>
                        </div>
                        <br><br><br><br>
                        <div class="form-group">
                            <input class="btn" type="file" name="photo_square" id="photo_square" onchange="readandpreview(this, 'image_square')"/>
                        </div>
                        <br><br>
                        <div class="form-group">
                            <label>PHOTO WIDE</label>
                            <img class="img-rounded" src="" id="image_wide" name="image_wide" style="width:500px; height:150px"/>
                        </div>
                        <br><br><br><br>
                        <div class="form-group">
                            <label>ORIGINAL PRICE</label>
                            <input type="text" class="form-control" id="original_price" name="original_price" placeholder="Enter original price"/>
                        </div>
                        <div class="form-group">
                            <label>OFFER PRICE</label>
                            <input type="text" class="form-control" id="offer_price" name="offer_price" placeholder="Enter original price"/>
                        </div>

                    </form>
                </div>
                <div class="col-sm-1"></div>
            </div>
            <div class="row">           
                <center>
                    <input type="button" value="POST AD" name="btn" class="btn-primary btn-lg" onclick="postAd()" />
                </center>
            </div>
            <div class="row">
                <center>  <label id ="label" ></label>  </center>
            </div>

        </div>
    </body>
</html>