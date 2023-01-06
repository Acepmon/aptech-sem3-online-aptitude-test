package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Managers {

    private static String tempUser = "";
    private static String tempPass = "";

    private static String username;
    private static String password;
    
    public Managers() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/onlineaptitudetest", "root", "");
            PreparedStatement stm = con.prepareCall("select username, password from Manager");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                tempUser = rs.getString("username");
                tempPass = rs.getString("password");
            }
            username = tempUser;
            password = tempPass;
        } catch (SQLException ex) {
            Logger.getLogger(Managers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Managers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
