<%-- 
    Document   : loginControl
    Created on : Jan 28, 2023, 7:54:28 PM
    Author     : Admin
--%>

<%@page import="com.personaliventorysystem.dao.UsersDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        String Un=request.getParameter("Un");
        String Ps=request.getParameter("Ps");
        UsersDAO ud=new UsersDAO();
        int x=ud.loginCheck(Un, Ps);
        if(x>0){
            response.sendRedirect("Users_View.jsp?userid="+x+"");
            out.println("<h1><font color='green'>Login success</font></h1>");
            session.setAttribute("user", Un);
        }
        else{
         out.println("<h1><font color='red'>Login Fail</font></h1>");   
        RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
        rd.include(request, response);
        }  
        %>
    </body>
</html>
