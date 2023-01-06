package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteQuestionServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        if (!request.getParameter("questionType").equals("") && !request.getParameter("questionId").equals("")) {
            try {
                String testType = request.getParameter("questionType");
                String testId = request.getParameter("questionId");

                out.println(testType);
                out.println(testId);
                if (testType.equals("General Knowledge")) {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost/online_aptitude_test", "root", "");
                    Statement stm1 = con1.createStatement();
                    stm1.execute("delete from general_test where Question_id=" + testId);
                    response.sendRedirect("manager.jsp?testMenu=gk");
                } else if (testType.equals("Mathematics")) {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost/online_aptitude_test", "root", "");
                    Statement stm2 = con2.createStatement();
                    stm2.execute("delete from math_test where Question_id=" + testId);
                    response.sendRedirect("manager.jsp?testMenu=math");
                } else {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con3 = DriverManager.getConnection("jdbc:mysql://localhost/online_aptitude_test", "root", "");
                    Statement stm3 = con3.createStatement();
                    stm3.execute("delete from inbox where Question_id=" + testId);
                    response.sendRedirect("manager.jsp?testMenu=ct");
                }
            } catch (SQLException ex) {
                Logger.getLogger(DeleteQuestionServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DeleteQuestionServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            out.println("<script>window.history.back()</script>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
