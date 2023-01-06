package classes;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Candidates {

    String name = "Tsogtbayar";
    int[] level = {0, 0, 0};
    int id = 000013;
    int point = 0;

    public Candidates(int id) {
        this.id = id;
        this.checkmate();
    }

    public void checkmate() {
        Date date = new Date();
        String rDate = (date.getYear() + 1900) + "-" + (date.getMonth() + 1)
                + "-" + date.getDate();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/online_aptitude_test", "root", "");
            PreparedStatement stm = con.prepareCall("Select * from general_result"
                    + " WHERE C_id = " + id);
            ResultSet rs = stm.executeQuery();
            PreparedStatement stm2 = con.prepareCall("Select * from math_result"
                    + " WHERE C_id = " + id);
            ResultSet rs2 = stm2.executeQuery();
            PreparedStatement stm3 = con.prepareCall("Select * from it_result"
                    + " WHERE C_id = " + id);
            ResultSet rs3 = stm3.executeQuery();
            while (rs.next() && rs2.next() && rs3.next()) {
                if (id == Integer.valueOf(rs.getString("C_Id"))) {

                    if (rs.getString("T_year").equals(rDate)) {
                        if (rs.getString("C_general") != null) {
                            level[0] = 2;
                        } else {
                            level[0] = 1;
                        }
                    } else {
                        level[0] = 0;
                    }
                    if (rs2.getString("T_year").equals(rDate)) {
                        if (rs2.getString("C_Math") != null) {
                            level[1] = 2;
                        } else {
                            if (level[0] != 1) {
                                level[1] = 1;
                            } else {
                                level[1] = 0;
                            }
                        }
                    } else {
                        if (level[0] == 1) {
                            level[1] = 0;
                        }
                    }
                    if (rs3.getString("T_year").equals(rDate)) {
                        if (rs3.getString("C_It") != null) {
                            level[2] = 2;
                        } else {
                            if (level[1] != 1) {
                                level[2] = 1;
                            } else {
                                level[2] = 0;
                            }
                        }
                    } else {
                        level[2] = 0;
                    }
                    setLevel(level);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Candidates.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setPoint(int point) {
        try {
            int no = checkLevel();
            switch (no) {
                case 1:
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/online_aptitude_test", "root", "");
                    Statement stm = con.createStatement();
                    stm.executeUpdate("UPDATE `general_result` SET `C_general`='" + point + "' WHERE C_id =" + id);
                    break;
                case 2:
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost/online_aptitude_test", "root", "");
                    Statement stm2 = con2.createStatement();
                    stm2.executeUpdate("UPDATE `math_result` SET `C_math`='" + point + "' WHERE C_id =" + id);
                    break;
                case 3:
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con3 = DriverManager.getConnection("jdbc:mysql://localhost/online_aptitude_test", "root", "");
                    Statement stm3 = con3.createStatement();
                    stm3.executeUpdate("UPDATE `it_result` SET `C_it`='" + point + "' WHERE C_id =" + id);
                    break;
            }
            this.point += point;
        } catch (Exception ex) {
            Logger.getLogger(Candidates.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int checkLevel() {
        int no = 0;
        for (int i = 0; i < 3; i++) {
            if (level[i] == 1) {
                level[i] = 2;
                no = i + 1;
                if (i < 2) {
                    level[i + 1] = 1;
                }
                break;
            }
        }
        return no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getLevel() {
        return level;
    }

    public void setLevel(int[] level) {
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPoint() {
        return point;
    }
}