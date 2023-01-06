<%@page import="classes.Candidates"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="resource/icon.png">
        <title>Webster Organization</title>
        <link rel="stylesheet" href="CSS/global_test.css" type="text/css"/>
        <link rel="stylesheet" href="CSS/footer.css" type="text/css"/>
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
        <script>
            jQuery(document).ready(function($) {
                $(window).scroll(function() {
                    if ($(this).scrollTop() > 50) {
                        $('#backToTop').fadeIn('slow');
                    } else {
                        $('#backToTop').fadeOut('slow');
                    }
                });
                $('#backToTop').click(function() {
                    $("html, body").animate({scrollTop: 0}, 500);
                    return false;
                });
            });</script>
            <%
                Candidates can = (Candidates) session.getAttribute("Candidate");
                if (request.getParameter("score") != null) {
                    can.setPoint(Integer.valueOf(request.getParameter("score")));
                }
                can.checkmate();
            %>
        <script>
            function notAllowed() {
                alert("You are not allowed to take that test");
            }
            function Allowed() {
                alert("You had already taken that test");
            }
        </script>
        <%
            if (request.getParameter("isTest") != null) {
                if (request.getParameter("isTest").equals("allow")) {
                    out.println("<script>Allowed();</script>");
                } else if (request.getParameter("isTest").equals("notAllow")) {
                    out.println("<script>notAllowed();</script>");
                }
            }
        %>
        <style>
            iframe, object, embed {
                max-width: 100%;
                overflow: no-display;
                position: relative;
                width: 100%;
                height: 100%;
                border: 0px;
            }
        </style>
    </head>
    <body style="background-color: #40af64">
        <!--Div to hold all content-->
        <div class="content_wrapper">

            <!--Header Div-->
            <div class="headerDiv">
                <div class="logo-container">
                    <a href="index.jsp" title="Online Aptitude Test" class="logo"><img src="resource/logo.png"/></a>
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
            <!-------------------------------->

            <!--Test section--->
            <div class="TestSection">
                <div class="candidate_test_links">
                    <%
                        if (!Boolean.valueOf(String.valueOf(session.getAttribute("login")))) {
                    %>
                    <iframe src="registerFrame.jsp" scrolling="auto"></iframe>

                    <%
                    } else {
                    %>
                    <div class="gk_link">
                        <a <%
                            if (can.getLevel()[0] == 2) {
                                out.print("href='test.jsp?isTest=allow&first=2'");
                            } else if (can.getLevel()[0] == 0) {
                                out.print("href='test.jsp?isTest=notAllow&first=2'");
                            } else if (can.getLevel()[0] == 1) {
                                out.print("href='TakingTest.jsp?test=gk&first=2'");
                            }
                            %> class="link_img"><img src="resource/55763-411x425-Generalknowledge.jpg"/></a>
                        <a <%
                            if (can.getLevel()[0] == 2) {
                                out.print("href='test.jsp?isTest=allow&first=2'");
                            } else if (can.getLevel()[0] == 0) {
                                out.print("href='test.jsp?isTest=notAllow&first=2'");
                            } else if (can.getLevel()[0] == 1) {
                                out.print("href='TakingTest.jsp?test=gk&first=2'");
                            }
                            %> class="link_title" <%
                                if (can.getLevel()[0] == 2) {
                                    out.print("style='color: #22b122'");
                                } else if (can.getLevel()[0] == 1) {
                                    out.print("style='color: #eed522'");
                                }
                            %>>General Knowledge</a><br/>
                        <span class="link_description">General knowledge will be your first test. You must pass this to get access to other two tests. General knowledge will test your normal standard intelligence.</span>
                    </div>
                    <div class="math_link">
                        <a <%
                            if (can.getLevel()[1] == 2) {
                                out.print("href='test.jsp?isTest=allow&first=2'");
                            } else if (can.getLevel()[1] == 0) {
                                out.print("href='test.jsp?isTest=notAllow&first=2'");
                            } else if (can.getLevel()[1] == 1) {
                                out.print("href='TakingTest.jsp?test=math&first=2'");
                            }
                            %> class="link_img"><img src="resource/math.jpg"/></a>
                        <a <%
                            if (can.getLevel()[1] == 2) {
                                out.print("href='test.jsp?isTest=allow&first=2'");
                            } else if (can.getLevel()[1] == 0) {
                                out.print("href='test.jsp?isTest=notAllow&first=2'");
                            } else if (can.getLevel()[1] == 1) {
                                out.print("href='TakingTest.jsp?test=math&first=2'");
                            }
                            %> class="link_title" <%
                                if (can.getLevel()[1] == 2) {
                                    out.print("style='color: #22b122'");
                                } else if (can.getLevel()[1] == 1) {
                                    out.print("style='color: #eed522'");
                                }
                            %>>Mathematics</a><br/>
                        <span class="link_description">In this test you will solve mathematical problems under given time. You are free to solve problems on your notebook or paper but be warned you must not waste time.</span>
                    </div>
                    <div class="tech_link">
                        <a <%
                            if (can.getLevel()[2] == 2) {
                                out.print("href='test.jsp?isTest=allow&first=2'");
                            } else if (can.getLevel()[2] == 0) {
                                out.print("href='test.jsp?isTest=notAllow&first=2'");
                            } else if (can.getLevel()[2] == 1) {
                                out.print("href='TakingTest.jsp?test=ct&first=2'");
                            }
                            %> class="link_img"><img src="resource/Computer-Technology1.jpg"/></a>
                        <a <%
                            if (can.getLevel()[2] == 2) {
                                out.print("href='test.jsp?isTest=allow&first=2'");
                            } else if (can.getLevel()[2] == 0) {
                                out.print("href='test.jsp?isTest=notAllow&first=2'");
                            } else if (can.getLevel()[2] == 1) {
                                out.print("href='TakingTest.jsp?test=ct&first=2'");
                            }
                            %> class="link_title" <%
                                if (can.getLevel()[2] == 2) {
                                    out.print("style='color: #22b122'");
                                } else if (can.getLevel()[2] == 1) {
                                    out.print("style='color: #eed522'");
                                }
                            %>>Computer technology</a><br/>
                        <span class="link_description">Computer is everyones everyday need. If you really do have a place in IT community pass this test. It will test your programming skill and logical problems. </span>
                    </div>
                    <%}%>
                </div>
                <div class="test_introduction">
                    <div class="test_introduction_title">
                        Online Aptitude Test for job applicants
                    </div>
                    <div class="test_introduction_desc">
                        General knowledge, mathematics and computer technology are now essential to modern workforce. 
                        That is why we designed this test solely for job applicants to test their limits so we can discuss such a candidate.
                    </div>
                </div>
                <div class="test_profile">
                    <%
                        if (!Boolean.valueOf(String.valueOf(session.getAttribute("login")))) {
                    %>
                    <div class="LoginError">
                        <h1>You are not logged in!</h1><br/>
                        <h5>Already registered? please use the following link... <a href="index.jsp">Click Here!</a></h5><br/>
                        <h5>If you don't have a account, fill form next to this window</h5> 
                    </div>
                    <%                    } else {
                    %>
                    <div class="test_profile_name">
                        <span><% out.println(can.getName());%>. ID: <% out.println(can.getId());%></span>
                    </div>
                    <div class="test_profile_score">
                        <span><% out.println(can.getName());%> scored <% out.println(can.getPoint());%> points so far</span>
                    </div>
                    <div class="test_profile_accessable">
                        <ul>
                            <li <%
                                if (can.getLevel()[0] == 2) {
                                    out.print("style='list-style-image: url(resource/appbar.checkmark.png)'");
                                }
                                %>><span <%
                                    if (can.getLevel()[0] == 2) {
                                        out.print("style='color: #22b122'");
                                    } else if (can.getLevel()[0] == 1) {
                                        out.print("style='color: #eed522'");
                                    }
                                    %>>General Knowledge</span></li>
                            <li <%
                                if (can.getLevel()[1] == 2) {
                                    out.print("style='list-style-image: url(resource/appbar.checkmark.png)'");
                                }
                                %>><span <%
                                    if (can.getLevel()[1] == 2) {
                                        out.print("style='color: #22b122'");
                                    } else if (can.getLevel()[1] == 1) {
                                        out.print("style='color: #eed522'");
                                    }
                                    %>>Mathematics</span></li>
                            <li <%
                                if (can.getLevel()[2] == 2) {
                                    out.print("style='list-style-image: url(resource/appbar.checkmark.png)'");
                                }
                                %>><span <%
                                    if (can.getLevel()[2] == 2) {
                                        out.print("style='color: #22b122'");
                                    } else if (can.getLevel()[2] == 1) {
                                        out.print("style='color: #eed522'");
                                    }
                                    %>>Computer Technology</span></li>
                        </ul>
                    </div>
                    <%}%>
                </div>
            </div>
            <!---------------------------->
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
