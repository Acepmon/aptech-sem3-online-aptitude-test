<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="classes.Candidates"%>
<%
    boolean loggedIn = false;
    boolean managerLogin = false;
    loggedIn = Boolean.valueOf(String.valueOf(session.getAttribute("login")));
    managerLogin = Boolean.valueOf(String.valueOf(session.getAttribute("mlogin")));
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        if (request.getParameter("username") != null
                && request.getParameter("password") != null) {
            String user = "";
            String user2 = "";
            String pass = "";
            String pass2 = "";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/online_aptitude_test", "root", "");
            PreparedStatement stm = con.prepareCall("select * from Manager");
            PreparedStatement stm2 = con.prepareCall("select * from Candidate");
            ResultSet rs = stm.executeQuery();
            ResultSet rs2 = stm2.executeQuery();
            while (rs.next()) {
                user = rs.getString("username");
                pass = rs.getString("password");
                if (user.equals(request.getParameter("username")) && pass.equals(request.getParameter("password"))) {
                    loggedIn = true;
                    managerLogin = true;
                    out.println("<script>parent.location.href='manager.jsp';</script>");
                    break;
                }
            }
            while (rs2.next()) {
                int id = Integer.valueOf(rs2.getString("c_id"));
                user2 = rs2.getString("username");
                pass2 = rs2.getString("password");
                if (user2.equals(request.getParameter("username")) && pass2.equals(request.getParameter("password"))) {
                    loggedIn = true;
                    out.println("<script>parent.location.href='index.jsp';</script>");
                    Candidates can = new Candidates(id);
                    can.setName(user2);
                    can.setId(id);
                    session.setAttribute("Candidate", can);
                    managerLogin = false;
                    break;
                }
            }
        }
        if (request.getParameter("logout") != null) {
            loggedIn = false;
            managerLogin = false;
            out.println("<script>parent.location.href='index.jsp'</script>");
        }
        session.setAttribute("login", loggedIn);
        session.setAttribute("mlogin", managerLogin);
        session.setAttribute("loggeduser", request.getParameter("username"));
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Tester</title>
        <script>
            function goToRegister(){
                parent.location.href = 'register.jsp';
            }
        </script>
        <style>
            h3 {
                margin-bottom: 35px;
                color: green;
            }
            input[type=text], input[type=password] {
                margin-top: 10px;
                padding-left: 5px;
                width: 240px;
                height: 20px;
                float: left;
                font-family: Times New Roman;
                font-size: 14px;
            }
            span {
                font-size: 16px;
                font-weight: bold;
                font-family: Ubuntu, sans-serif;
                color: #656f71;
            }
            .but {
                position: relative;
                margin: 15px 5px 0px 5px;
                width: 110px;
                text-decoration: none;
                font-size: 18px;
                font-weight: bold;
                font-family: Times New Roman, sans-serif;
                color: white;
                border: none;
                background-color: #3aa3b6;
                border: 1px #3aa3b6 solid;
                padding: 5px 10px 5px 10px;
                cursor: pointer;
            }
            .but:hover {
                border: 1px #b8b8cf solid;
                color: #2f545b;
                background-color: #cde6ea;
            }
        </style>
    </head>
    <body>
        <%
            if (loggedIn) {
                out.println("<h3>You have successfully logged in</h3>");
                out.println("<form action=''>"
                        + "<input type='hidden' name='logout' value='logout'/>"
                        + "<input type='submit' class='but' value='Log out'/>"
                        + "</form>");
            } else {
                out.println("<form action=''>"
                        + "<span>Login authenication</span><br/>"
                        + "<input type='text' name='username' placeholder='Enter username...' />"
                        + "<input type='password' name='password' placeholder='Enter password...'/>"
                        + "<input type='button' value='REGISTER' class='but'"
                        + " onclick='goToRegister()' />"
                        + "<input type='submit' value='LOGIN' class='but'/>"
                        + "</form>");
            }
        %>
    </body>
</html>