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
                    </ul>
                </div>
            </div>
            <!-------------------->

            <!--Body Div-->
            <div class="BodySection">
                <div class="ImgSection">
                    <div class="Slide">
                        <img src="resource/slide-1.jpg" style="display: block;">
                        <img src="resource/slide-2.jpg" style="display: none;">
                        <img src="resource/slide-3.jpg" style="display: none;">
                        <img src="resource/slide-4.jpg" style="display: none;">
                        <img src="resource/slide-5.jpg" style="display: none;">
                        <img src="resource/slide-6.jpg" style="display: none;">
                    </div>
                    <div class="blank_space_padding">
                    </div>
                    <div class="SlideIt">
                        <div class="ImgLinkSection" style="display: block;">
                            <span class="desc_title" id="Spanners">About Webster</span><br/>
                            <span class="desc" id="Spanners">
                                The Webster organisation is the leading organization in the world of Oil-Gas Company.  
                                We have various branches throughout the world.  
                                It has various bonds with different multi-national company.</span><br/><br/>
                            <span id="Spanners"><a href="aboutus.jsp" class="desc_link">LEARN MORE</a></span>
                        </div>
                    </div>
                    <%/*
                         if (!islogged) {
                         out.print("<div class='LoginSection'>"
                         + "<a href='' class='LoginTitle'>Login</a>"
                         + "<form action='index.jsp' method='post'>"
                         + "<input type='text' placeholder='Username...' class='field' name='username'/>"
                         + "<input type='password' placeholder='Password...' class='field' name='password'/>"
                         + "<input type='button' value='Register' onclick='Location.href='register.jsp'' class='button' style='margin-right: 5px;'/>"
                         + "<input type='submit' value='Login' class='button' style='margin-left: 5px;'/>"
                         + "</form>"
                         + "</div>");
                         }*/
                    %>
                    <iframe src="login.jsp" class="LoginFrame" draggable="true"></iframe>
                </div>
            </div>
            <!------------------->

            <div class="NewsSection">
                <div class="HeadShape"><img src="resource/news_icon.png" alt="News" title="News"/><a>News</a></div>
                <div class="NewsHolder">
                    <%
                        String[][] news = new String[7][3];
                        boolean[] number = new boolean[7];
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/online_aptitude_test", "root", "");
                        PreparedStatement stm = con.prepareCall("SELECT * FROM news");
                        ResultSet rs = stm.executeQuery();
                        int i = 0;
                        while (rs.next()) {
                            news[i][0] = rs.getString("News_Title");
                            news[i][1] = rs.getString("News_Picture");
                            news[i][2] = rs.getString("News_Description");
                            number[i] = false;
                            i++;
                        }
                        for(int j =0; j<6; j++){
                            int random = (int) (Math.random()*6);
                            while(number[random]){
                                random = (int) (Math.random()*6);
                            }
                            String title = news[random][0];
                            String purl = news[random][1];
                            String desc = news[random][2];
                    %>
                    <div class="News">
                        <div class="NewsTitle"><%=title%></div>
                        <div class="NewsImage"><img src="<%=purl%>"/></div>
                        <div class="NewsDesc" style="height: 80px;"><%=desc%></div>
                    </div>
                    <%
                            number[random] = true;
                        }
                    %>
                </div>
            </div><br/>

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
                        Email: webster.company@yahoo.com<br/>
                    </span>
                </div>

                <div class="columnTable">
                    <table cellspacing="5" cellpadding="0">
                        <tr>
                            <td><a href="http:\\www.facebook.com" target="_blank"><div class="facebook_link" id="comm_links">Facebook</div></a></td>
                        </tr>
                        <tr>
                            <td><a href="http:\\www.twitter.com" target="_blank"><div class="twitter_link" id="comm_links">Twitter</div></a></td>
                        </tr>
                        <tr>
                            <td><a href="http:\\www.myspace.com" target="_blank"><div class="myspace_link" id="comm_links">MySpace</div></a></td>
                        </tr>
                        <tr>
                            <td><a href="http:\\www.linkedi.com" target="_blank"><div class="linkedin_link" id="comm_links">Linkedin</div></a></td>
                        </tr>
                    </table>
                </div>
            </div>
            <!------------------------>

        </div>
        <!----------------------->
    </body>
</html>
