<%-- 
    Document   : login
    Created on : Jan 28, 2023, 7:53:51 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Form</title>
        <style>
            *{
                font-family:Times New Roman;
            }
            a{
                color: white;
                text-decoration: none;  
            }

            .header{
                height: 130px;
                background-image: linear-gradient(to top, #1a1a1a, #0d0d0d); 
                display: flex;
                justify-content: space-between;
            }
            .invent{
                display: flex;
            }

            .leftside{
                /*border: 1px solid white;*/
                width: 400px;
            }
            .personal{
                font-weight:600;
                text-align: center;
                color:cornflowerblue;
                padding-top: 20px;
                font-size: 36px;
            }
            .inven{
                margin-top: -11px;
                font-weight:600;
                color: white;
                font-size: 36px;
                padding-left: 70px;
            }
            .system{
                margin-top: -11px;
                font-weight:600;
                color: grey;
                font-size: 36px;
                text-align: center;
            }
            .rightside{
                color:white;
                display: flex;
                /*border: solid;*/
                padding-bottom:30px;
                font-weight: 700;
                justify-content: space-between;
                width: 350px;
                align-items: center;
                font-size: 18px;
            }

            .login{
                padding-right: 40px;
            }
            .tableouter{                
                font-size: 20px;
                border-radius: 15px ;
                margin-top: 80px;
                margin-left: 330px;
                background-color:#00134d;
                width: 660px;
                height: 190px;
                padding-top: 10px;
                border: solid aliceblue;
            }
            .login1{
                font-family:Algerian;
                padding-left: 32px;
                color: aliceblue;
            }
            .table{
                /*border: solid;*/
                border-radius: 15px;
                background-color: #0099ff;
                padding-bottom: 10px;
                padding-top: 30px;
                margin-left: 30px;              
                padding-left: 20px;
                color: white;
                width: 600px;
                height: 130px;
            }
            .button1{
                height: 30px;
            }
            .button2{
                margin-left: 35px;
            }

        </style>
    </head>
    <body style="background-color: #0099ff">

        <div class="header" >
            <div class="leftside">
                <div class="personal">Personal </div>
                <div class="invent">
                    <div class="inven">Inventory</div>
                    <div class="system">System</div>
                </div>
            </div>
            <div class="rightside">
                <div class="home"><a href="Home.html"> Home</a></div>
                <div class="register"><a href="Registration.html"> Register User</a></div>
                <div class="login"> <a href="Login.jsp"> Login</a></div>
            </div>
        </div>

        <form action="Logincontrol.jsp">
            <div class="tableouter">
                <div class="login1">Login</div>
                <table border="0" cellspacing='0' class="table">

                    <tr >
                        <td>UserName : <input type="text" name="Un"></td>

                    </tr>

                    <tr>
                        <td>Password :<input type="password" name="Ps" style="margin-left:14px;"></td>

                    </tr>


                    <tr>
                        <td><input class="button1" type="submit" value="Signin"><input  type="submit" value="Reset" class="button2"></td>
                    </tr>

                </table>
            </div>


        </form>
    </body>
</html>
