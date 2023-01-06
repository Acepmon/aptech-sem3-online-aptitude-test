<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="resource/icon.png">
        <title>Webster Organization</title>
        <link rel="stylesheet" href="CSS/global_style.css" type="text/css"/>
        <link rel="stylesheet" href="CSS/footer.css" type="text/css"/>
        <script type="text/javascript" src="JS/jquery-1.9.1.js"></script>
        <script type="text/javascript">
            $(function() {
                $('.Slide img:gt(0)').hide();

                setInterval(function() {
                    $('.Slide :first-child').fadeOut()
                            .next('img')
                            .fadeIn()
                            .end()
                            .appendTo('.Slide');
                }, 8000);
            });//]]>
            $(function() {
                $('.SlideIt div:gt(0)').hide();

                setInterval(function() {
                    $('.SlideIt :').fadeOut()
                            .next('div')
                            .fadeIn()
                            .end()
                            .appendTo('.SlideIt');
                }, 4000);
            });//]]>
        </script>
        <style>
            iframe, object, embed {
                max-width: 100%;
                overflow: no-display;
                position: absolute;
                width: 100%;
                height: 760px;
                border: 0px;
            }
        </style>
    </head>
    <body style="background-color: #18DADA">
        <!--Div to hold all content-->
        <div class="content_wrapper">

            <!--Header Div-->
            <div class="headerDiv">
                <div class="logo-container">
                    <a href="index.jsp" title="Amusement Park" class="logo"><img src="resource/logo.png" alt="Amusement Park"/></a>
                </div>
                <div class="top_menu">
                    <ul>
                        <a href="index.jsp"><li style="background-color: #18DADA"><img src="resource/home_icon2.png" width="50" height="50"/><p>Home</p></li></a>
                                <%
                                    if (Boolean.valueOf(String.valueOf(session.getAttribute("mlogin")))) {
                                %><a href='manager.jsp'><li style='background-color: #c05252'><img src='resource/clipboard-8-512.png' width='50' height='50'/><p>Management</p></li></a>
                                <%} else {%>
                        <a href="test.jsp"><li style="background-color: #40af64"><img src="resource/test_icon.png" width="50" height="50"/><p>Test</p></li></a>
                                <%}%>
                        <a href="aboutus.jsp"><li style="background-color: #ff9a1d"><img src="resource/aboutus_icon.png" width="50" height="50"/><p>About us</p></li></a>
                                <%
                                    Boolean islogged = false;
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
                                        user = rs.getString("Username");
                                        pass = rs.getString("Password");
                                    }
                                    while (rs2.next()) {
                                        user2 = rs2.getString("Username");
                                        pass2 = rs2.getString("Password");
                                    }
                                    if (user.equals(request.getParameter("username")) && pass.equals(request.getParameter("password"))) {
                                        out.print("<a href='manager.jsp'><li style='background-color: #c05252'><img src='resource/clipboard-8-512.png' width='50' height='50'/><p>Management</p></li></a>");
                                        islogged = true;
                                    } else if (user2.equals(request.getParameter("username")) && pass2.equals(request.getParameter("password"))) {
                                        out.print("<a href='manager.jsp'><li style='background-color: #c05252'><img src='resource/icon-employeebadge-white-large.png' width='50' height='50'/><p>" + user2 + "</p></li></a>");
                                        islogged = true;
                                    }
                                %>
                    </ul>
                </div>
            </div>
            <!-------------------->

            <!--Body Div-->
            <div style="width: 100%; height: 750px; float: left; background: white; padding: 0px;">
                <iframe src="registerFrame.jsp" scrolling="no"/>
            </div>
            <!--Footer Div-->
            <div class="bigFooter">
                <div class="column">
                    <span class="contentTitle">Locations<br/><br/></span>
                    <span class="contentData">
                        8901 Marmora Road<br/>
                        Glasgow, DO4 89GR.<Br/>
                    </span>
                </div>

                <div class="column">
                    <span class="contentTitle">Contact Us<br/><br/></span>
                    <span class="contentData">
                        Freephone: +1 800 559 6580<Br/>
                        Telephone: +1 959 603 6035<br/>
                        FAX: +1 504 889 9898<br/><Br/>
                        Email: mail@demolink.com<br/>
                    </span>
                </div>

                <div class="columnTable">
                    <table cellspacing="5" cellpadding="0">
                        <tr>
                            <td><a href=""><div class="facebook_link" id="comm_links">Facebook</div></a></td>
                        </tr>
                        <tr>
                            <td><a href=""><div class="twitter_link" id="comm_links">Twitter</div></a></td>
                        </tr>
                        <tr>
                            <td><a href=""><div class="myspace_link" id="comm_links">MySpace</div></a></td>
                        </tr>
                        <tr>
                            <td><a href=""><div class="linkedin_link" id="comm_links">Linkedin</div></a></td>
                        </tr>
                    </table>
                </div>
            </div>
            <!------------------------>

        </div>
        <!----------------------->
    </body>
</html>
