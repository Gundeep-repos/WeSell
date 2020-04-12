
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jquery-1.12.2.min.js" type="text/javascript"></script>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <title>Search Results</title>

        <script>

            function fetchSearchedproducts(search)
            {
                var ans;
                var mainobj;
                var singleobj;
                var obj;
                var xhr = new XMLHttpRequest();

                if (search !== "")
                {


                    xhr.open("GET", "./FetchSearchedproducts?search=" + search, true);
                    xhr.onreadystatechange = function () {

                        if (xhr.status === 200 && xhr.readyState === 4)
                        {
                            ans = xhr.responseText.trim();
//                        console.log(ans);

                            mainobj = JSON.parse(ans);
//                        console.log(mainobj);

                            singleobj = mainobj["ans"];
                            var html="";

                            for (var i = 0; i < singleobj.length; i++)
                            {
                                obj = singleobj[i];

                                html +="<div class='row'><div class='col-sm-2'>";
                                html += "<img src='" + obj.photo_square + "' class='img img-responsive img img-circle' style='width:100px;height:100px; ' /></div >"
                                html +=  "<div class='col-sm-2'>"+obj.pname+"</div>" ;
                                html += "<div class='col-sm-2'><h6><strike>Original price: "+ obj.original_price + "</strike></h6></div>";
                                html += "<div class='col-sm-2'><h6>Offer price: " + obj.offer_price + "</h6></div>";
                                html += "<div class='col-sm-4'><input type='button' onclick='#' class='btn btn-lg btn-warning' value='BUY'/></div>"
                                html += "</div>"
                            }

                            document.getElementById("d1").innerHTML = html;
                        }
                    };
                    xhr.send();
                }
            }


        </script>

    </head>
    <%
        String search = request.getParameter("value");

    %>
    <body onload="fetchSearchedproducts('<%=search%>')">
        <h1>Search Results</h1>
        <div class="container">

            <div class="row" id="d1">
                
            

            </div>


        </div>



    </body>
</html>
