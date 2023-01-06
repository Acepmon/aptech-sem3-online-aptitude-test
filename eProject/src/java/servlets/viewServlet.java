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

public class viewServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (request.getParameter("id") != null) {
            try {
                String idR = request.getParameter("id");
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/online_aptitude_test", "root", "");
                PreparedStatement stm = con.prepareCall("Select * from inbox where In_id = " + idR);
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("in_id");
                    String fname = rs.getString("F_Name");
                    String lname = rs.getString("L_Name");
                    String birthdate = rs.getString("Birthdate");
                    String age = rs.getString("Age");
                    String gender = rs.getString("Gender");
                    String phone = rs.getString("Phone");
                    String email = rs.getString("Email");
                    String address = rs.getString("Address");
                    String status = rs.getString("Status");
                    String degree = rs.getString("Degree");
                    String years = rs.getString("Years");
                    String category = rs.getString("Category");
                    if (idR.equals(id)) {
                        out.print("<script>window.location.href='manager.jsp?menuRequest=inbox&fromView=true&id=" + id + "&"
                                + "fname="+fname+"&lname="+lname+"&birthdate="+birthdate+"&age="+age+"&gender="+gender+"&phone="+phone+"&"
                                + "email="+email+"&address="+address+"&status="+status+"&degree="+degree+"&years="+years+"&category="+category+"';</script>");
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
