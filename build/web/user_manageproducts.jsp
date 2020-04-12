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
        <title>Manage Products</title>
        <script src="js/jquery-1.12.2.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script>
            var id, ar;
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
            function fetchProducts()
            {
                var xhr = new XMLHttpRequest;
                xhr.onreadystatechange = function ()
                {
                    if (xhr.readyState === 4 && xhr.status === 200)
                    {
                        var s = xhr.responseText.trim();
                        //alert(s);
                        var mainjson = JSON.parse(s);
                        ar = mainjson["ans"];
                        console.log(ar);

                        var tb = "<table class=\"table table-hover\">";
                        tb += "<tr><th>Photo</th><th>Product Name</th><th></th><th></th></tr>";
                        for (var i = 0; i < ar.length; i++)
                        {

                            var obj = ar[i];
                            //id = obj["pid"];
                            tb += "<tr>";
                            tb += "<td><img src='" + obj["photo_square"] + "' class='img-responsive' style='width:100px; height:100px;' /></td>";
                            tb += "<td>" + obj["pname"] + "</td>";
                            tb += "<td><input class='btn btn-info' type='button' value='Add More Photos' onclick='addmorephoto(" + obj["pid"] + ")' /></td>";
                            tb += "<td><input class='btn btn-danger' type='button' value='Delete' onclick='deleteProduct(" + obj["pid"] + ")' /></td>";
                            tb += "<td><input class='btn btn-primary' type='button' value='Edit' onclick='editProduct(" + i + ")' /></td>";
                            tb += "</tr>";
                        }
                        tb += "</table>";
                        document.getElementById("d1").innerHTML = tb;
                    }
                };
                xhr.open("POST", "./FetchProducts", true);
                xhr.send();
            }

            function addmorephoto(pid)
            {
                id = pid;
                console.log(id);
                window.location.href = "usermanageProductPhotos.jsp?pid=" + id + "";
            }
            function deleteProduct(pid)
            {
                id = pid;
                var a = confirm("Do you want to delete the product?");
                if (a === true)
                {
                    var xhr = new XMLHttpRequest;
                    xhr.onreadystatechange = function ()
                    {

                        if (xhr.readyState === 4 && xhr.status === 200)
                        {
                            var res = xhr.responseText.trim();
                            if (res === "success")
                            {
                                alert("product deleted");
                                fetchProducts();
                            } else
                            {
                                alert("Something went wrong try again!");
                            }

                        }
                    };
                    xhr.open("POST", "./DeleteProduct?pid=" + id, true);
                    xhr.send();
                }
            }
            function editProduct(i)
            {
                var obj = ar[i];
                fetchSelectedCategory(obj.category);
                id = obj.pid;
                document.getElementById("pname").value = obj.pname;
                document.getElementById("brand").value = obj.brand;
                document.getElementById("desc").value = obj.description;
                document.getElementById("image_square").src = obj.photo_square;
                document.getElementById("image_wide").src = obj.photo_wide;
                document.getElementById("original_price").value = obj.original_price;
                document.getElementById("offer_price").value = obj.offer_price;
                document.getElementById("city").value = obj.city;
                document.getElementById("condition").value = obj.product_condition;
                $('#myModal').modal('show');




            }


            function fetchSelectedCategory(category)
            {
                var xhr = new XMLHttpRequest;
                xhr.onreadystatechange = function ()
                {
                    if (xhr.readyState === 4 && xhr.status === 200)
                    {
                        var s = xhr.responseText.trim();
                        //alert(s);
                        var mainjson = JSON.parse(s);
                        var ar = mainjson["ans"];
                        console.log(ar);
                        var html;
                        for (var i = 0; i < ar.length; i++)
                        {

                            var obj = ar[i];
                            if (obj.cname.trim() === category.trim())
                            {
                                html += "<option selected>" + obj.cname + "</option>";

                            } else
                            {
                                html += "<option>" + obj.cname + "</option>";
                            }


                        }

                        document.getElementById("category").innerHTML = html;
                    }
                };
                xhr.open("POST", "./FetchCategory", true);
                xhr.send();
            }
            function allowEditing()
            {
                document.getElementById("pname").readOnly = false;
                document.getElementById("brand").readOnly = false;
                document.getElementById("desc").readOnly = false;
                document.getElementById("photo_square").disabled = false;
                document.getElementById("original_price").readOnly = false;
                document.getElementById("offer_price").readOnly = false;
                document.getElementById("city").disabled = false;
                document.getElementById("category").disabled = false;
                document.getElementById("condition").disabled = false;
            }

            function updateProduct()
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
                    if (controls[i].type === "file")
                    {
                        if (controls[i].files.length > 0)
                        {
                            formdata.append(controls[i].name, controls[i].files[0]);
                        }
//                         else
//                        {
//                            flag = 2;
//                            break;
//                        }
                    } else
                    {
                        if (controls[i].value.trim() === "")
                    {
                        flag = 3;
                        break;
                    }
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
                            if (xhr.responseText.trim() === "success")
                            {
                                alert(xhr.responseText.trim());
                                $('#myModal').modal('hide');
                                fetchProducts();
                            }
                        }
                    };
                    xhr.open("POST", "./UpdateProduct?pid=" + id, true);
                    xhr.send(formdata);
                }
            }



        </script>
    </head>
    <body onload="fetchProducts()" >
        <div class="container">
            <div class="row">
                <div class="col-sm-1"></div>
                <div class="col-sm-10" id="d1"></div>
                <div class="col-sm-1"></div>
            </div>
            <div class="modal fade" id="myModal" >
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <center><h3 class="h3">Edit Category</h3></center>
                        </div>
                        <div class="modal-body" >
                            <form  method="POST"  enctype="multipart/form-data" id="myform">
                                <div class="form-group">
                                    <label>PRODUCT NAME</label>
                                    <input readonly="" type="text" class="form-control" name="pname" id="pname" placeholder="Enter product name" />
                                </div>
                                <div class="form-group">
                                    <label>CATEGORY</label>
                                    <select disabled="" class="form-control" id="category" name="category" >
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>BRAND</label>
                                    <input readonly="" type="text" class="form-control" id="brand" name="brand" placeholder="Enter brand name"/>
                                </div>
                                <div class="form-group">
                                    <label>DESCRIPTION</label>
                                    <textarea readonly="" class="form-control" name="desc" id="desc" placeholder="Enter description"></textarea>
                                </div>
                                <div class="form-group">
                                    <label>CITY</label>
                                    <select disabled="" class="form-control" id="city" name="city">
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
                                    <select disabled="" class="form-control" id="condition" name="condition">
                                        <option value="" selected disabled>Select Product Condition</option>
                                        <option value="good">GOOD</option>
                                        <option value="fair">FAIR</option>
                                        <option value="excellent">EXCELLENT</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>PHOTO SQUARE</label>
                                    <img class="img-rounded" src="" id="image_square" name="image_square" style="width:150px; height:150px"/>
                                </div>
                                <div class="form-group">
                                    <input disabled="" class="btn" type="file" name="photo_square" id="photo_square" onchange="readandpreview(this, 'image_square')"/>
                                </div>
                                <div class="form-group">
                                    <label>PHOTO WIDE</label>
                                    <img readonly="" class="img-rounded" src="" id="image_wide" name="image_wide" style="width:500px; height:150px"/>
                                </div>
                                <div class="form-group">
                                    <label>ORIGINAL PRICE</label>
                                    <input readonly="" type="text" class="form-control" id="original_price" name="original_price" placeholder="Enter original price"/>
                                </div>
                                <div class="form-group">
                                    <label>OFFER PRICE</label>
                                    <input readonly="" type="text" class="form-control" id="offer_price" name="offer_price" placeholder="Enter original price"/>
                                </div>
                            </form>
                            <div class="row">
                                <div class="col-sm-3"></div>
                                <div class="col-sm-3">
                                    <input type="button" class="btn-lg btn-info" value="Edit"  onclick="allowEditing()"/>
                                </div>
                                <div class="col-sm-3">
                                    <input type="button" class="btn-lg btn-success" value="Update" onclick="updateProduct()" />
                                </div>
                                <div class="col-sm-3"></div>
                            </div>
                        </div>
                        <div class="modal-footer">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>