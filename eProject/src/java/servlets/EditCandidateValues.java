package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditCandidateValues extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (request.getParameter("idE") != null) {
            try {
                String idR = request.getParameter("idE");
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/online_aptitude_test", "root", "");
                PreparedStatement stm1 = con.prepareCall("Select * from candidate_personal");
                ResultSet rs1 = stm1.executeQuery();
                PreparedStatement stm2 = con.prepareCall("Select * from candidate_education");
                ResultSet rs2 = stm2.executeQuery();
                PreparedStatement stm3 = con.prepareCall("Select * from candidate_exp");
                ResultSet rs3 = stm3.executeQuery();
                while (rs1.next()) {
                    String idP = rs1.getString("C_id");
                    out.println("1:" + idP);
                    if (idR.equals(idP)) {
                        String fname = rs1.getString("F_Name");
                        String lname = rs1.getString("L_Name");
                        String birthdate = rs1.getString("Birthdate");
                        String age = rs1.getString("Age");
                        String gender = rs1.getString("Gender");
                        String address = rs1.getString("Address");
                        String status = rs1.getString("Status");
                        String phone = rs1.getString("Phone");
                        String email = rs1.getString("Email");

                        while (rs2.next()) {
                            String idE = rs2.getString("C_id");
                            if (idE.equals(idP)) {
                                String degree = rs2.getString("Degree");
                                while (rs3.next()) {
                                    String idEx = rs3.getString("C_id");
                                    String category = rs3.getString("Category");
                                    String years = rs3.getString("Years");
                                    if (idR != null && idP != null && idE != null && idEx != null) {
                                        if (idR.equals(idEx)) {
                                            out.println("<script>window.location.href='manager.jsp?menuRequest=total_candidate&fromCandidate=true&id=" + idR
                                                    + "&fname=" + fname + "&lname=" + lname + "&birthdate=" + birthdate + "&age=" + age + "&gender=" + gender + "&phone=" + phone + "&"
                                                    + "email=" + email + "&address=" + address + "&status=" + status + "&degree=" + degree + "&years=" + years + "&category=" + category + "';</script>");
                                            break;
                                        }
                                    }
                                }
                            }
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
