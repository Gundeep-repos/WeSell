<%-- 
    Document   : productview
    Created on : 26 Apr, 2018, 11:52:41 AM
    Author     : GUNDEEP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jquery-1.12.2.min.js" type="text/javascript"></script>

        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="js/bootstrap.js" type="text/javascript"></script>

        <title>BUY PRODUCT</title>

        <script>
            function productView(pid)
            {
                var ans;
                var mainobj;
                var singleobj;
                var obj;
                var js;
                var xhr = new XMLHttpRequest();
                var html2 = "";
                xhr.open("GET", "./ProductView?pid=" + pid, true);
                xhr.onreadystatechange = function () {

                    if (xhr.status === 200 && xhr.readyState === 4)
                    {
                        ans = xhr.responseText.trim();
                        alert(ans);

                        mainobj = JSON.parse(ans);
//                        console.log(mainobj);

                        singleobj = mainobj["ans"];
                        //var html="";
                        // console.log(ans);
                        var html = "";

                        obj = singleobj[0];

                        html += "<div class='row'><div class='col-sm-6'>";
                        html += "<div><img src='" + obj.photo_wide + "' class='img img-responsive ' style='width:400px;height:250px; ' /></div >";
                        html += "<br><div class='row' ><div class='col-sm-3'><img src='" + obj.photo_square + "' class='img img-responsive img img-circle' style='width:130px;height:130px; ' /></div>";
                        html += "<div class='col-sm-6'>" + obj.pname + "<br>";
                        html += "<strike>Original price: " + obj.original_price + "</strike><br>";
                        html += "Offer price: " + obj.offer_price + "</div><div class='col-sm-3'></div></div>";
                        // html += "<div class='col-sm-4'><input type='button' onclick='#' class='btn btn-lg btn-warning' value='BUY'/></div>"

                        html += "<div><h4>Seller Information:</h4>"
                        html += "Name: " + obj.name + "<br>";
                        html += "Email: " + obj.email + "<br>";
                        html += "Contact: " + obj.contact + "<br>"
                        html += "</div></div>"
                        html += "<div class='col-sm-6'>";
                        html += "<div class='row'  style='border: solid 1px black; margin-top:1px margin-bottom:1px margin-right:1px margin-left:1px'>"
                        html += "<center><h2>More Photos<h2></center>";
                        for (var i = 0; i < singleobj.length; i++)
                        {
                            js = singleobj[i];
                            html2 += "<div class='col-sm-4' style=' padding-top:1px padding-bottom:1px padding-left:1px padding-right:1px '>";
                            html2 += "<img src='" + js.photo_path + "' class='img img-responsive' style='width:130px; height:130px;'/>";
                            html2 += "</div>";
                        }

                        html += html2;
                        html += "</div>";

                        html += "<div><h3>Product Description: </h3><textarea readonly>" + obj.description + "</textarea>";
                        html += "<h3>Brand: </h3>" + obj.brand + "</div>";
                        html += "<br><input type='button' value='BUY NOW' class='btn-lg btn btn-warning' >";
                        html += "</div></div>";


                        document.getElementById("d1").innerHTML = html;
                    }
                };
                xhr.send();

            }

            


        </script>

    </head>

    



    <%        String pid = request.getParameter("pid");

    %>
    <body onload="productView(<%=pid%>)">


        <div class="container">


            <nav class="navbar navbar-inverse">

                <div class="container-fluid" >

                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>                        
                        </button>
                        <a class="navbar-brand" href="publicHome.jsp">WeSell</a>
                    </div>

                    <div class="collapse navbar-collapse" id="myNavbar">

                        <ul class="nav navbar-nav">
                            <li class="active"><a href="publicHome.jsp">Home</a></li>
                            <li class="active"><a href="#" onclick="openCityModal()" id="selectcity">Select City</a></li>

                        </ul>
                        <!--<div class="row"><div id="d1" class="col-sm-6"></div></div>-->

                        <ul class="nav navbar-nav navbar-right">

                            <li><input type="text" placeholder="Search Product" id="search" name="search" style="width:380px;height: 40px; margin-top:6px" onkeyup="getProducts()"/></li>

                            <li><br><input type="button" value="Search" class="btn-lg btn-info" 
                                           onclick="window.location.href = 'searchResults.jsp?\n\
value=' + document.getElementById('search').value + ''" style="margin-top:0px;margin-bottom: 0px"></li>


                            <li><a href="userSignup.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                            <li><a href="user_login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                        </ul>

                    </div>
                </div>
            </nav>




            <h1>Product Description</h1>
            <div class="row" id="d1">


            </div>

        </div>

    </body>
</html>
