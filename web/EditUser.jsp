<%-- 
    Document   : UpdateUser
    Created on : 5 Feb, 2023, 5:05:57 PM
    Author     : HP
--%>

<%@page import="com.personaliventorysystem.bean.UsersBean"%>
<%@page import="com.personaliventorysystem.dao.UsersDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            *{
                font-family:Times New Roman;
            }
            a{
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
                width: 450px;
                align-items: center;
                font-size: 18px;
            }
            .rightside a{
                color:white;
            }
            .logout{
                padding-right: 40px;
            }
            .table{
                /*border: solid;*/
                border-radius:   0px 0px 15px 15px;
                background-color: #000d33;
                padding-bottom: 40px;
                padding-top: 40px;
                margin-left: 100px;
                padding-left:340px;
                padding-right:180px;
                color: white;
                width: 800px;
                height: 230px;
            }

            .userprofile{
                border-radius:  15px 15px 0px 0px;
                margin-top: 40px;
                padding-top: 30px;
                padding-left: 30px;
                font-size: 28px;
                font-weight: 700;
                margin-left: 100px;
                /*border: solid;*/
                display: flex;
                width: 770px;
                background-color: #000d33;

            }
            .after_header{
                display: flex;

            }
            .leftbox{
                background-color: #1a1a1a;
                margin-left: -70px;
                border: solid;
                margin-top: 115px;
                width: 280px;
                height: 335px;
            }
            .leftbox a{
                font-size: 20px;
                border: none;
                color: #0047b3;
                padding-left: 20px;
                line-height: 2;
            }

            .master{
                color: white;
                font-weight: 600;
                font-size: 24px;
                margin-left: 30px;
                height: 30px;
                /*border: solid;*/
                margin-top: 80px;

            }
            .exp{
                margin-top: 20px;
            }
            .update,a{
                color: white;
            }

        </style>
    </head>
    <body style="background-color:#0099ff">


        <%
            int Userid = Integer.parseInt(request.getParameter("userid"));
            UsersDAO ud = new UsersDAO();
            UsersBean ub = ud.findByuserid(Userid);
        %>
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
                <div> <a href="Users_View.jsp?userid=<%= ub.getUserid()%>">Profile</a></div>
                <div class="update"> <a href="EditUser.jsp?userid=<%= ub.getUserid()%>">Update Profile</a></div>
                <div class="logout"><a href="Home.html">Logout</a></div>
            </div>
        </div>


        <div class="after_header">
            <div class="master">Master</div>
            <div class="leftbox">
                <div class="exp"><a href="Expenses_Category_view.jsp?userid=<%= ub.getUserid()%>"> Expenses Category </a></div>
                <div><a href="Income_Category_view1.jsp?userid=<%= ub.getUserid()%>"> Income Category </a></div>
                <div><a href="Expenses_View.jsp?userid=<%= ub.getUserid()%>"> Expenses </a></div>
                <div><a href="Income_View.jsp?userid=<%= ub.getUserid()%>"> Income </a></div>
                <div><a href="CashBook_View.jsp?userid=<%= ub.getUserid()%>"> Cash Book  </a></div>
                <div><a href="BankBook_view.jsp?userid=<%= ub.getUserid()%>"> Bank Book </a></div>
                <div><a href="_view.jsp?userid=<%= ub.getUserid()%>"> Day Book </a></div>
                <div><a href="_view.jsp?userid=<%= ub.getUserid()%>"> Balance Sheet </a></div>
            </div>
            <form action="UpdateUser1">
                <div>

                    <table  border="0" cellspacing='0' class="table"  >
                        <div class="userprofile">
                            <div style="font-family:Algerian; color:aliceblue;">
                                Update
                            </div>
                            <div style="margin-left:10px; font-family:Algerian; color:grey;">
                                Profile
                            </div>

                        </div>
                        <tr>

                            <td> <input type="hidden" name="userid" value=<%=ub.getUserid()%>></td>
                        </tr>
                        <tr>
                            <td>Name:</td>
                            <td> <input type="text" name="name" value=<%=ub.getName()%>></td>
                        </tr>

                        <tr>
                            <td>Username:</td>
                            <td> <input type="text" name="username" value=<%=ub.getUsername()%>></td>
                        </tr>

                        <tr>
                            <td>Password:</td>
                            <td> <input type="password" name="password" id="password" value=<%=ub.getPassword()%>></td>
                        </tr>          

                        <tr>
                            <td>Phone No:</td>
                            <td> <input type="text" name="mobile" value=<%=ub.getMobile()%>></td>
                        </tr>

                        <tr>
                            <td>Email Id:</td>
                            <td><input type="email" name="email" value=<%=ub.getEmail()%>></td>
                        </tr>
                        <tr>
                            <td>Address :</td>
                            <td> <input type="text" name="add" value=<%=ub.getAddress()%>></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td ><input type="submit" value="Update">
                        </tr>      

                    </table> 
                </div>
            </form>                  
        </div>
</html>
