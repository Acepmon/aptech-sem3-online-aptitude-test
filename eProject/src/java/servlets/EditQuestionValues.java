package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditQuestionValues extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (!request.getParameter("testMenu").equals("") && !request.getParameter("id").equals("")) {
            try {
                String testType = request.getParameter("testMenu");
                String qId = request.getParameter("id");

                if (testType.equals("gk")) {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost/online_aptitude_test", "root", "");
                    PreparedStatement stm1 = con1.prepareCall("Select * from general_test");
                    ResultSet rs1 = stm1.executeQuery();
                    while (rs1.next()) {
                        String questionId = rs1.getString("Question_Id");
                        String question = rs1.getString("Question");
                        String correctA = rs1.getString("CorrectA");
                        String answer1 = rs1.getString("Answer_1");
                        String answer2 = rs1.getString("Answer_2");
                        String answer3 = rs1.getString("Answer_3");
                        String answer4 = rs1.getString("Answer_4");
                        if (qId.equals(questionId)) {
                            response.sendRedirect("manager.jsp?testMenu=gk&editQuestion=true&id=" + questionId + "&question=" + question + "&correctA=" + correctA + "&answer1=" + answer1 + "&answer2=" + answer2 + "&answer3=" + answer3 + "&answer4=" + answer4 + "");
                        }
                    }
                } else if (testType.equals("math")) {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost/online_aptitude_test", "root", "");
                    PreparedStatement stm2 = con2.prepareCall("Select * from math_test");
                    ResultSet rs2 = stm2.executeQuery();
                    while (rs2.next()) {
                        String questionId = rs2.getString("Question_Id");
                        String question = rs2.getString("Question");
                        String correctA = rs2.getString("CorrectA");
                        String answer1 = rs2.getString("Answer_1");
                        String answer2 = rs2.getString("Answer_2");
                        String answer3 = rs2.getString("Answer_3");
                        String answer4 = rs2.getString("Answer_4");
                        if (qId.equals(questionId)) {
                            response.sendRedirect("manager.jsp?testMenu=math&editQuestion=true&id=" + questionId + "&question=" + question + "&correctA=" + correctA + "&answer1=" + answer1 + "&answer2=" + answer2 + "&answer3=" + answer3 + "&answer4=" + answer4 + "");
                        }
                    }
                } else {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con3 = DriverManager.getConnection("jdbc:mysql://localhost/online_aptitude_test", "root", "");
                    PreparedStatement stm3 = con3.prepareCall("Select * from it_test");
                    ResultSet rs3 = stm3.executeQuery();
                    while (rs3.next()) {
                        String questionId = rs3.getString("Question_Id");
                        String question = rs3.getString("Question");
                        String correctA = rs3.getString("CorrectA");
                        String answer1 = rs3.getString("Answer_1");
                        String answer2 = rs3.getString("Answer_2");
                        String answer3 = rs3.getString("Answer_3");
                        String answer4 = rs3.getString("Answer_4");
                        if (qId.equals(questionId)) {
                            response.sendRedirect("manager.jsp?testMenu=ct&editQuestion=true&id=" + questionId + "&question=" + question + "&correctA=" + correctA + "&answer1=" + answer1 + "&answer2=" + answer2 + "&answer3=" + answer3 + "&answer4=" + answer4 + "");
                        }
                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(viewServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(viewServlet.class.getName()).log(Level.SEVERE, null, ex);
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
