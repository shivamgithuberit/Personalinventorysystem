/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.personaliventorysystem.bean.IncomeCategoryBean;
import com.personaliventorysystem.dao.IncomeCategoryDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
public class Update_Income_Category extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
             int inc_catid = Integer.parseInt(request.getParameter("catid"));
            String inc_catname = request.getParameter("catname");
            String inc_catdetails = request.getParameter("catdetails");
            int userid=Integer.parseInt(request.getParameter("userid"));
            IncomeCategoryDAO id = new IncomeCategoryDAO();
            IncomeCategoryBean ib = new IncomeCategoryBean();

            ib.setInc_catid(inc_catid);
            ib.setInc_catname(inc_catname);
            ib.setInc_catdetails(inc_catdetails);
             ib.setUserid(userid);
            int x = id.UpdateIncomeCategory(ib);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Update_Income_Category</title>");            
            out.println("</head>");
            out.println("<body>");
             if(x>0){
                response.sendRedirect("Income_Category_view1.jsp?userid="+ userid+"");
            }
            else{
              out.println("<h1><font color='red'>Not Updated Successfully</font></h1>");   
            }
            out.println("<h1>Servlet Update_Income_Category at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
