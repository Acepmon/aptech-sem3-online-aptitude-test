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

public class EditQuestion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (request.getParameter("type") != null && request.getParameter("questionId") != null && request.getParameter("question") != null && request.getParameter("answer1") != null
                && request.getParameter("answer2") != null && request.getParameter("answer3") != null && request.getParameter("answer4") != null
                && request.getParameter("correctA") != null) {
            if (!request.getParameter("type").equals("") && !request.getParameter("questionId").equals("") && !request.getParameter("question").equals("")
                    && !request.getParameter("answer1").equals("") && !request.getParameter("answer2").equals("")
                    && !request.getParameter("answer3").equals("") && !request.getParameter("answer4").equals("")
                    && !request.getParameter("correctA").equals("")) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/online_aptitude_test", "root", "");
                    Statement stm = con.createStatement();
                    
                    String type= request.getParameter("type");
                    String idR = request.getParameter("questionId");
                    int id = Integer.valueOf(idR);
                    String question = request.getParameter("question");
                    String correctA = request.getParameter("correctA");
                    String answer1 = request.getParameter("answer1");
                    String answer2 = request.getParameter("answer2");
                    String answer3 = request.getParameter("answer3");
                    String answer4 = request.getParameter("answer4");

                    stm.executeUpdate("UPDATE `general_test` SET `Question` = '" + question + "',"
                            + " `CorrectA` = '" + correctA + "', `Answer1`='" + answer1 + "', `Answer2`='" + answer2 + "', `Answer3`='" + answer3 + "',"
                            + " `Answer4`='" + answer4 + "' where Question_id =" + id);

                    out.print("<script>window.history.back()</script>");
                } catch (SQLException ex) {
                    Logger.getLogger(EditQuestion.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(EditQuestion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
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
