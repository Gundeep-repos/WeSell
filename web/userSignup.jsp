

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="jquery-1.12.2.min.js" type="text/javascript"></script>

        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="js/bootstrap.js" type="text/javascript"></script>


        <script>
            function userSignup()
            {
                var password = document.getElementById("password").value;
                var cpassword = document.getElementById("cpassword").value;
                if (password === cpassword)
                {


                    var ans = "";
                    //NEW CODE
                    var formdata = new FormData();

                    var controls = document.getElementById("form2").elements;
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
//                    alert(ans);
//                    alert(formdata);

                        var xhr = new XMLHttpRequest;
                        xhr.open("POST", "./UserSignup", true);

                        xhr.onreadystatechange = function ()
                        {
                            if (xhr.readyState === 4 && xhr.status === 200)
                            {
                                var res = xhr.responseText.trim();

                                if (res === "success")
                                {
                                    alert("Signup Successful");
                                    document.getElementById("form2").reset();
                                    document.getElementById("im2").src="";

                                } else
                                {
                                    alert("Email Already Exist");
                                }
                            }
                        };

                        xhr.send(formdata);
                    }
                } else
                {
                    document.getElementById("lb1").innerHTML = "Password do not match!";
                    document.getElementById("lb1").style.color = "red"

                }

            }

            function readandpreview(fileobj, imageid)
            {
                var firstfile = fileobj.files[0];

                var reader = new FileReader();

                alert("File name: " + firstfile.name);
                alert("File size: " + firstfile.size);

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




            function passwordcheck()
            {
                var x = 0;
                var password = document.getElementById("password").value;
                var cpassword = document.getElementById("cpassword").value;
                if (document.getElementById("password").value === "")
                {
                    document.getElementById("lb1").innerHTML = "You can't leave Password Field Empty.";
                    document.getElementById("lb1").style.color = "red";
                    document.getElementById("span").className = "glyphicon glyphicon-ban-circle";
                } else
                {


                    if (password === cpassword)
                    {
                        x = 1;
                    }
                    if (x === 0)
                    {
                        document.getElementById("lb1").innerHTML = "Password do not match!";
                        document.getElementById("lb1").style.color = "red"
                    } else
                    {
                        document.getElementById("lb1").innerHTML = "Password Matched";
                        document.getElementById("lb1").style.color = "green";

                    }
                }
            }



        </script>

    </head>
    <body>
        <h1>Sign-Up</h1>
        <div class="container">
            <div class="row">
                <form method="POST" enctype="multipart/form_data" id="form2">
                    <div class="col-sm-6">

                        <div class="form-group">
                            <label>Email:</label>&nbsp;
                            <input type="email" class="form-control" 
                                   placeholder="Enter Email" id="email" name="email">
                        </div>
                        <br>
                        <div class="form-group">
                            <label>Name:</label>&nbsp;
                            <input type="text" class="form-control" placeholder="Enter Name" id="name" name="name">
                        </div>
                        <br>
                        <div class="form-group">
                            <label>Contact:</label>&nbsp;
                            <input type="text" class="form-control" placeholder="Start with +91" id="contact" name="contact">
                        </div>
                        <br>
                        <div class="form-group">
                            <label>Address:</label>&nbsp;
                            <textarea class="form-control" placeholder="Enter Address" id="address" name="address"></textarea>
                        </div>

                        <br>
                        <div class="form-group">
                            <label>State:</label>&nbsp;
                            <input type="text" readonly="" value="Punjab" class="form-control" name="state" >
                        </div>
                        <br>
                        <div class="form-group">
                            <label>Select city:</label>&nbsp;
                            <select class="form-control" id="city" name="city">
                                <option value=""><-select-></option>
                                <option value="amritsar">Amritsar</option>
                                <option value="jalandhar">Jalandhar</option>
                                <option value="ludhiana">Ludhiana</option>
                                <option value="patiala">Patiala</option>
                                <option value="bathinda">Bathinda</option>                   

                            </select><br><br>
                        </div>

                    </div>

                    <div class="col-sm-6">

                        <div class="form-group">
                            <label>Select Security Question:</label>&nbsp;
                            <select class="form-control" id="secq" name="secq">
                                <option value=""><-select-></option>
                                <option value="book">Which is your favorite book?</option>
                                <option value="city">Which is your favorite City?</option>
                                <option value="pet">what is the name of your pet?</option>
                                <option value="movie">Which is your favorite movie?</option>
                                <option value="birthplace">In which city/state you were born?</option>                   

                            </select>
                        </div>
                        <br>
                        <div class="form-group">
                            <label>Security Answer:</label>&nbsp;
                            <input type="text" id="seca" name="seca" class="form-control" placeholder="Enter Answer">
                        </div>
                        <br>
                        <div class="form-group">
                            <label>Gender:</label>&nbsp;
                            <div class="form-control"> 
                                <input type="radio" id="genderm" name="gender" value="Female">Male
                                <input type="radio" id="genderf" name="gender" value="Male">Female
                                <input type="radio" id="gendero" name="gender" value="Others">Others
                            </div>
                        </div>

                        <br>
                        <div class="form-group">
                            <label>Password:</label>&nbsp;
                            <input type="password" class="form-control" placeholder="Enter Password" id="password" name="password">
                        </div>
                        <br>
                        <div class="form-group">
                            <label>Confirm Password:</label>&nbsp;
                            <input type="password" class="form-control" placeholder="Confirm Password" id="cpassword" name="cpassword" onkeyup="passwordcheck()" onblur="passwordcheck()">
                        </div>
                        <span id="span" class="" style="font-size: 17px"></span>
                        <label id="lb1"></label>
                        <br>
                        <div class="form-group">
                            <select class="form-control" id="usertype" name="usertype">
                                <option><-select-></option>
                                <option value="type1">TYPE-1</option>
                                <option value="type2">TYPE-2</option>
                            </select>
                        </div>

                        <br>
                        <div class="form-group">
                            <input class="btn btn-info" type="file" id="photo" name="photo" onchange="readandpreview(this, 'im2')"/>
                            <br>
                            <img class="img-responsive" src="" id="im2" name="im2" style="width: 150px; height: 200px;" />
                            <br><br><br><br><br><br><br>

                        </div>
                    </div>



                </form>
            </div>

            <div class="row">


                <center>
                    <input type="button" value="Sign-Up" class="btn-info btn-lg" onclick="userSignup()">
                </center>
            </div>


        </div>

    </body>
</html>
