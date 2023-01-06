package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TodayServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            Date date = new Date();
            int year = date.getYear() + 1900,
                    month = date.getMonth() + 1,
                    day = date.getDate();
            String realDate = year + "-" + month + "-" + day;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/online_aptitude_test", "root", "");
            
            //general test result view process start
            PreparedStatement stm1 = con.prepareCall("Select * from general_result");
            PreparedStatement stm2 = con.prepareCall("Select * from general_result");
            PreparedStatement stm3 = con.prepareCall("Select * from candidate");
            ResultSet rs1 = stm1.executeQuery();
            ResultSet rs2 = stm2.executeQuery();
            ResultSet rs3 = stm3.executeQuery();
            int i = 0;
            while (rs2.next()) {
                i++;
            }
            String[][] generalTestResult = new String[i][3];
            i = 0;

            while (rs1.next()) {
                String c_id = rs1.getString("C_id");
                String c_name = "It is Me";
                String c_general = rs1.getString("C_general");
                String t_year = rs1.getString("T_year");
                while (rs3.next()) {
                    if (c_id.equals(rs3.getString("C_id"))) {
                        c_name = rs3.getString("Username");
                        break;
                    }
                }


                if (t_year.equals(realDate)) {
                    generalTestResult[i][0] = c_name;
                    generalTestResult[i][1] = c_general;
                    generalTestResult[i][2] = t_year;
                    i++;
                }
            }
            //general test view process end  
            
            //math test view process start
            PreparedStatement stm4 = con.prepareCall("Select * from math_result");
            PreparedStatement stm5 = con.prepareCall("Select * from math_result");
            PreparedStatement stm6 = con.prepareCall("Select * from candidate");
            ResultSet rs4 = stm4.executeQuery();
            ResultSet rs5 = stm5.executeQuery();
            ResultSet rs6 = stm6.executeQuery();
            int j = 0;
            while (rs4.next()) {
                j++;
            }
            String[][] mathTestResult = new String[j][3];
            j = 0;

            while (rs5.next()) {
                String c_id = rs5.getString("C_id");
                String c_name = "It is Me";
                String c_math = rs5.getString("C_math");
                String t_year = rs5.getString("T_year");
                while (rs6.next()) {
                    if (c_id.equals(rs6.getString("C_id"))) {
                        c_name = rs6.getString("Username");
                        break;
                    }
                }


                if (t_year.equals(realDate)) {
                    mathTestResult[j][0] = c_name;
                    mathTestResult[j][1] = c_math;
                    mathTestResult[j][2] = t_year;
                    j++;
                }
            }
            //math test view process end
            
            //it test view process start
            PreparedStatement stm7 = con.prepareCall("Select * from it_result");
            PreparedStatement stm8 = con.prepareCall("Select * from it_result");
            PreparedStatement stm9 = con.prepareCall("Select * from candidate");
            ResultSet rs7 = stm7.executeQuery();
            ResultSet rs8 = stm8.executeQuery();
            ResultSet rs9 = stm9.executeQuery();
            int m = 0;
            while (rs7.next()) {
                m++;
            }
            String[][] itTestResult = new String[m][3];
            m = 0;

            while (rs8.next()) {
                String c_id = rs8.getString("C_id");
                String c_name = "It is Me";
                String c_it = rs8.getString("C_it");
                String t_year = rs8.getString("T_year");
                while (rs9.next()) {
                    if (c_id.equals(rs9.getString("C_id"))) {
                        c_name = rs9.getString("Username");
                        break;
                    }
                }


                if (t_year.equals(realDate)) {
                    itTestResult[m][0] = c_name;
                    itTestResult[m][1] = c_it;
                    itTestResult[m][2] = t_year;
                    m++;
                }
            }
            //it test view process end
            HttpSession session1 = request.getSession();
            session1.setAttribute("generalTest", generalTestResult);
            HttpSession session2 = request.getSession();
            session2.setAttribute("mathTest", mathTestResult);
            HttpSession session3 = request.getSession();
            session3.setAttribute("itTest", itTestResult);
            response.sendRedirect("manager.jsp?menuRequest=test_result");
        } catch (SQLException ex) {
            Logger.getLogger(TodayServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TodayServlet.class.getName()).log(Level.SEVERE, null, ex);
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
