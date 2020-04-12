<%-- 
    Document   : crelatedproducts
    Created on : 24 Apr, 2018, 4:54:30 PM
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
        <title>Products</title>
        <script>

            function cRelatedProducts(cname)
            {
                var ans;
                var mainobj;
                var singleobj;
                var obj;
                var xhr = new XMLHttpRequest();

                xhr.open("POST", "./CRelatedProducts?cname=" + cname, true);
                xhr.onreadystatechange = function () {
                    if (xhr.status === 200 && xhr.readyState === 4)
                    {
                        ans = xhr.responseText.trim();
//                        console.log(ans);

                        mainobj = JSON.parse(ans);
//                        console.log(mainobj);

                        singleobj = mainobj["ans"];
                        var html = "";
                        for (var i = 0; i < singleobj.length; i++)
                        {
                            obj = singleobj[i];
                            var pv = "\"productview.jsp?pid=" + obj.pid + "\" ";
                            console.log(pv);
                            html += "<br><div class='row'><div class='col-sm-1'></div>";
                            html += "<div class='col-sm-2'><img src='" + obj.photo_square + "' class='img img-responsive img img-circle' style='width:100px;height:100px; ' /></div >"
                            html += "<div class='col-sm-2'>" + obj.pname + "</div>";
                            html += "<div class='col-sm-2'><h6><strike>Original price: " + obj.original_price + "</strike></h6></div>";
                            html += "<div class='col-sm-2'><h6>Offer price: " + obj.offer_price + "</h6></div>";
                            html += "<div class='col-sm-2'>\n\
            <input type='button' onclick='window.location.href=" + pv + " '  class='btn btn-lg btn-warning' value='BUY'/></div>";
                            html += "<div class='col-sm-1'></div></div><br>";


                        }



                        document.getElementById("d1").innerHTML = html;
                    }
                };
                xhr.send();
            }
            
            
            
        </script>


    </head>
    <body onload="cRelatedProducts('<%=request.getParameter("cname")%>')">
        <div class="comntainer">
            
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

            
            
            
            
            <div id="d1"></div>

        </div>
    </body>
</html>
