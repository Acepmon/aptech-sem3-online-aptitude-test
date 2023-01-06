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

public class AddQuestionServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        if (!request.getParameter("question").equals("") && !"".equals(request.getParameter("answer1")) && !"".equals(request.getParameter("answer2")) && !"".equals(request.getParameter("answer3")) && !"".equals(request.getParameter("answer4"))) {
            try {
                String type = request.getParameter("type");
                String question = request.getParameter("question");
                String answer1 = request.getParameter("answer1");
                String answer2 = request.getParameter("answer2");
                String answer3 = request.getParameter("answer3");
                String answer4 = request.getParameter("answer4");
                String cAnswerR = request.getParameter("cAnswer");

                int id = 0;
                String cAnswer = "";

                if (cAnswerR.equals("Answer 1")) {
                    cAnswer = answer1;
                } else if (cAnswerR.equals("Answer 2")) {
                    cAnswer = answer2;
                } else if (cAnswerR.equals("Answer 3")) {
                    cAnswer = answer3;
                } else {
                    cAnswer = answer4;
                }

                if (type.equals("General Knowledge")) {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/online_aptitude_test", "root", "");
                    Statement stm = con.createStatement();

                    out.println(cAnswer);
                    stm.executeUpdate("INSERT INTO `general_test` (`Question_id`, `Question`, `CorrectA`,`Answer_1`, `Answer_2`, `Answer_3`, `Answer_4`) VALUES ('" + id + "','"
                            + question + "', '" + cAnswer + "', '" + answer1 + "', '" + answer2 + "', '" + answer3 + "', '" + answer4 + "')");
                    response.sendRedirect("manager.jsp?testMenu=gk");
                } else if (type.equals("Mathematics")) {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/online_aptitude_test", "root", "");
                    Statement stm2 = con.createStatement();
                    stm2.executeUpdate("INSERT INTO `math_test` (`Question_id`, `Question`, `CorrectA`,`Answer_1`, `Answer_2`, `Answer_3`, `Answer_4`) VALUES ('" + id + "','"
                            + question + "', '" + cAnswer + "', '" + answer1 + "', '" + answer2 + "', '" + answer3 + "', '" + answer4 + "')");
                    response.sendRedirect("manager.jsp?testMenu=math");
                } else {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/online_aptitude_test", "root", "");
                    Statement stm3 = con.createStatement();
                    stm3.executeUpdate("INSERT INTO `it_test` (`Question_id`, `Question`, `CorrectA`, `Answer_1`, `Answer_2`, `Answer_3`, `Answer_4`) VALUES ('" + id + "','"
                            + question + "', '" + cAnswer + "', '" + answer1 + "', '" + answer2 + "', '" + answer3 + "', '" + answer4 + "')");
                    response.sendRedirect("manager.jsp?testMenu=ct");
                }
            } catch (SQLException ex) {
                Logger.getLogger(AddQuestionServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AddQuestionServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
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
