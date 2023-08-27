<%-- 
    Document   : Income_View
    Created on : 8 Feb, 2023, 2:22:05 PM
    Author     : HP
--%>

<%@page import="com.personaliventorysystem.bean.IncomeBean"%>
<%@page import="com.personaliventorysystem.dao.IncomeDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    // String user = (String) session.getAttribute("user");
    int userid = Integer.parseInt(request.getParameter("userid"));


%>
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
                background-image: linear-gradient(to top,#1f1f2e, #0d0d0d); 
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
                height: 270px;
                background-color:#000d33;
                padding-top: 30px;
                margin-left: 150px;
                padding-right:190px;
                padding-left:190px;
                width: 718px;
                color: white;
                border-radius:  0px 0px  15px 15px;

            }

            .userprofile{
                margin-top: 30px;
                padding-top: 20px;
                padding-left: 30px;
                font-size: 28px;
                font-weight: 700;
                margin-left: 150px;
                /*border: solid;*/
                display: flex; 
                width: 688px;
                border-radius:  15px 15px 0px 0px;
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
            .button a{
                background-color: white;
                color: black;
            }

        </style>
    </head>
    <body style="background-color: #0099ff">
          <%
            int Userid = Integer.parseInt(request.getParameter("userid"));
            IncomeDAO id = new IncomeDAO();
            IncomeBean ib = id.findByinc_id(Userid);
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
                <div> <a href="Users_View.jsp?userid=<%= userid%>">Profile</a></div>
                <div class="update"> <a href="EditUser.jsp?userid=<%= userid%>">Update Profile</a></div>
                <div class="logout"><a href="Home.html">Logout</a></div>
            </div>
        </div>
        <div class="after_header">
            <div class="master">Master</div>
            <div class="leftbox">
                <div class="exp"><a href="Expenses_Category_view.jsp?userid=<%= userid%>"> Expenses Category </a></div>
                <div><a href="Income_Category_view1.jsp?userid=<%= userid%>"> Income Category </a></div>
                <div><a href="Expenses_View.jsp?userid=<%= userid%>"> Expenses </a></div>
                <div><a href="Incom_View.jsp?userid=<%= userid%>"> Income </a></div>
                <div><a href="CashBook_View.jsp?userid=<%= userid%>"> Cash Book  </a></div>
                <div><a href="BankBook_view.jsp?userid=<%= userid%>"> Bank Book </a></div>
                <div><a href="DayBook_view.jsp?userid=<%= userid%>"> Day Book </a></div>
                <div><a href="BalanceSheet_view.jsp?userid=<%= userid%>"> Balance Sheet </a></div>
            </div>

            <form action="Add_Income">
                <div>

                    <table  border="0" cellspacing='0' class="table"  >
                        <div class="userprofile">
                            <div style="font-family:Algerian; color:aliceblue;">
                              In
                            </div>
                            <div style=" font-family:Algerian; color:grey;">
                                Come
                            </div>

                        </div>
                        <tr>
                            <td > <input  type="hidden" name="userid"  value=<%=ib.getUserid()%> ></td>
                        </tr>
                        <tr>
                            <td>Income:</td>
                            <td> <input type="text" style="width: 200px;" ></td>
                        </tr>

                        <tr>
                            <td>Category:</td>
                            <td> <input type="text" style="width: 200px;" name="category" value=<%=ib.getInc_ac() %>></td>
                        </tr>

                        <tr>
                            <td>Amount:</td>
                            <td> <input type="number" style="width: 200px;" name="amount" id="password" value=<%=ib.getAmount() %>></td>
                        </tr>          

                        <tr>
                            <td>Receive By :</td>
                            <td> <input type="radio"  name="payby" value=<%=ib.getReceivby() %>>Cash <input type="radio" name="payby" value=<%=ib.getReceivby()%>>Online <input type="radio" name="payby" value=<%=ib.getReceivby()%>> Check</td>
                        </tr>
                     
                        <tr>
                            <td>Date :</td>
                            <td> <input type="date"  style="width: 200px;" name="date" value=<%=ib.getTransaction_date() %>></td>
                        </tr>
                         <tr>
                            <td>Remark :</td>
                            <td> <input type="text" style="width: 200px;" name="remark" value=<%=ib.getRemark() %>></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Add Income" style="width: 120px; height: 30px; color: gray;"></td>           
                        </tr>      

                    </table> 
                </div>
            </form>
    </body>
</html>

   
    
   
