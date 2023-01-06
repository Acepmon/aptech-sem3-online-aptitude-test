package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class defaultSendServelt extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (request.getParameter("id") != null) {
            try {
                String idR = request.getParameter("id");
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/online_aptitude_test", "root", "");
                PreparedStatement stm = con.prepareCall("Select * from inbox");
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    int i = 0;
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
                    String description = rs.getString("Description");
                    if (idR.equals(id)) {
                        int c_id = 0;
                        Properties props = new Properties();
                        props.put("mail.smtp.auth", "true");
                        props.put("mail.smtp.starttls.enable", "true");
                        props.put("mail.smtp.host", "smtp.mail.yahoo.com");
                        props.put("mail.smtp.port", "587");
                        props.put("mail.smtp.ssl.trust", "smtp.mail.yahoo.com");

                        Session session = Session.getInstance(props, new Authenticator() {
                            @Override
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication("webster.company@yahoo.com", "M0ng0li@");
                            }
                        });
                        MimeMessage message = new MimeMessage(session);
                        message.setFrom(new InternetAddress("webster.company@yahoo.com"));
                        message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
                        message.setSubject("Webster Company accepted your request.");
                        message.setText("Your username is: " + fname + "<br>" + "Your password is:" + phone);
                        Transport.send(message);
                        Statement stm2 = con.createStatement();
                        stm2.executeUpdate("INSERT INTO `candidate` (`C_id`, `Username`, `Password`) VALUES ('" + i + "','" + fname + "', '" + phone + "')");
                        
                        PreparedStatement stm10 = con.prepareCall("Select * from candidate ORDER BY C_id DESC LIMIT 1");
                        ResultSet rs10 = stm10.executeQuery();
                        while (rs10.next()) {
                            c_id = rs10.getInt("C_id");
                        }
                        Statement stm3 = con.createStatement();
                        stm3.executeUpdate("INSERT INTO `candidate_education` (`C_id`, `Degree`) VALUES ('" + c_id + "', '" + degree + "')");
                        Statement stm4 = con.createStatement();
                        stm4.executeUpdate("INSERT INTO `candidate_exp` (`C_id`, `Category`, `Years`) VALUES ('" + c_id  + "', '" + category + "', '" + years + "')");
                        Statement stm5 = con.createStatement();
                        stm5.executeUpdate("INSERT INTO `candidate_personal` (`C_id`, `F_name`, `L_name`, `Birthdate`, `Age`, `Gender`, `Status`, `Address`, `Phone`, `Email`) VALUES ('" + c_id  + "', '" + fname + "', '" + lname + "', '" + birthdate + "', '" + age + "', '" + gender + "', '" + status + "', '" + address + "', '" + phone + "', '" + email + "')");
                        Statement stm6 = con.createStatement();
                        stm6.executeUpdate("INSERT INTO `general_result` (`C_id`) VALUES ('" + c_id  + "')");
                        Statement stm7 = con.createStatement();
                        stm7.executeUpdate("INSERT INTO `math_result` (`C_id`) VALUES ('" + c_id  + "')");
                        Statement stm8 = con.createStatement();
                        stm8.executeUpdate("INSERT INTO `it_result` (`C_id`) VALUES ('" + c_id  + "')");
                        Statement stm9 = con.createStatement();
                        stm9.execute("delete from inbox where In_id=" + id);
                        out.println("<script>window.location.href='manager.jsp?menuRequest=inbox</script>");
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(defaultSendServelt.class.getName()).log(Level.SEVERE, null, ex);
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
