<%-- 
    Document   : publicHome
    Created on : 23 Apr, 2018, 11:50:58 AM
    Author     : GUNDEEP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jquery-1.12.2.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>WESELL</title>

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
                        var html = "";
                        for (var i = 0; i < singleobj.length; i++)
                        {
                            obj = singleobj[i];
                            html += "<div class='col-sm-3'>";
                            html += "<a href='crelatedproducts.jsp?cname=" + obj.cname + "' ><img src='" + obj.cphoto + "' class='img-responsive img-rounded' style='width:100px; height:100px;'/></a>";
                            html += "<a href='crelatedproducts.jsp?cname=" + obj.cname + " '><label>" + obj.cname + "</label></a></div>";
                        }


                        document.getElementById("d1").innerHTML = html;
                    }
                };
                xhr.send();
            }

            function openCityModal()
            {
                $('#myModal').modal('show');
            }

            function getProducts()
            {
                var ans;
                var mainobj;
                var singleobj;
                var obj;
                var xhr = new XMLHttpRequest();
                var search = document.getElementById("search").value;
                if (search !== "")
                {


                    xhr.open("POST", "./SendProducts?search=" + search, true);
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
                                html += obj.pname + "<br>";
                            }

                            document.getElementById("dd").innerHTML = html;
                        }
                    };
                    xhr.send();
                } else
                {
                    document.getElementById("dd").innerHTML = "";
                }
            }
            function savecitytocookies()
            {

                var xhr = new XMLHttpRequest();
                var city = document.getElementById("city").value;
                xhr.open("POST", "./SaveCityToCookies?city=" + city, true);
                xhr.onreadystatechange = function () {


                    if (xhr.status === 200 && xhr.readyState === 4)
                    {
                        var html = xhr.responseText.trim();
                        document.getElementById("selectcity").innerHTML = html;
                    }
                };
                xhr.send();
            }

            function cityCheck()
            {
                fetchcategory();

                var xhr = new XMLHttpRequest();
                xhr.open("POST", "./GetCity", true);
                xhr.onreadystatechange = function () {


                    if (xhr.status === 200 && xhr.readyState === 4)
                    {
                        var res = xhr.responseText.trim();
                        if (res === "unset")
                        {
                            $('#myModal').modal('show');
                        } else
                        {
                            document.getElementById("selectcity").innerHTML = res;
                        }
                    }
                };
                xhr.send();
            }

            

        </script>

    </head>
    <body onload="cityCheck()" >



        <nav class="navbar navbar-inverse">

            <div class="container-fluid" >

                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>                        
                    </button>
                    <a class="navbar-brand" href="#">WeSell</a>
                </div>

                <div class="collapse navbar-collapse" id="myNavbar">

                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">Home</a></li>
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

        <div class="row" >
            <div class="col-sm-2"></div>
            <div class="col-sm-8" id="dd"></div>
            <div class="col-sm-2"></div>
        </div>

        <!-- Data Area -->
        <div class="container">
            <h3 class="container-fluid breadcrumb">Categories</h3>

            <!-- Modal -->
            <div class="modal" id="myModal" >
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Select City</h4>
                        </div>
                        <div class="modal-body">
                            <select onchange="savecitytocookies()" id="city" name="city">
                                <option selected disabled>-select city-</option>
                                <option value="amritsar">Amritsar</option>
                                <option value="ludhiana">Ludhiana</option>
                                <option value="bathinda">Bathinda</option>
                                <option value="patiala">Patiala</option>
                                <option value="jalandhar">Jalandhar</option>

                            </select>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row" id="d1">
            </div>

        </div>
    </body>
</html>
