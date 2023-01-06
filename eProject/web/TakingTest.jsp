
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
        <link rel="stylesheet" href="CSS/TakingTestStyle.css" type="text/css"/>
        <%
            if (!Boolean.valueOf(String.valueOf(session.getAttribute("login")))) {
                out.println("<script>alert('Hey, you! Do not try this ever again!');window.location.href='index.jsp'</script>");
            }
        %>
        <%
            int questionCount = 5;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/online_aptitude_test", "root", "");
            PreparedStatement stm = con.prepareCall("Select * from general_test");

            //If it is Math test it must be 30.
            //If it is General knowledge test, make it 40.
            int countG = 0, countM = 0, countC = 0;
            PreparedStatement stm1 = con.prepareCall("Select * from general_test");
            ResultSet rs1 = stm1.executeQuery();
            PreparedStatement stm2 = con.prepareCall("Select * from math_test");
            ResultSet rs2 = stm2.executeQuery();
            PreparedStatement stm3 = con.prepareCall("Select * from it_test");
            ResultSet rs3 = stm3.executeQuery();
            while(rs1.next()){
                countG++;
            }
            while(rs2.next()){
                countM++;
            }
            while(rs3.next()){
                countC++;
            }
            String ws = "";
            if (request.getParameter("test") != null) {
                ws = request.getParameter("test");
            } else if (request.getParameter("test2") != null) {
                ws = request.getParameter("test2");
            } else {
                ws = String.valueOf(session.getAttribute("test"));
            }
            session.setAttribute("test", ws);
            int totalQuestionCount = countG;
            if (ws.equals("math") || ws.equals("math2")) {
                stm = con.prepareCall("Select * from math_test");
                totalQuestionCount = countM;
            } else if (ws.equals("ct") || ws.equals("ct2")) {
                stm = con.prepareCall("Select * from it_test");
                totalQuestionCount = countC;
            }

            ResultSet rs = stm.executeQuery();
            String[] questions = new String[totalQuestionCount];
            String[] correctAnswers = new String[totalQuestionCount];
            String[][] answers = new String[totalQuestionCount][4];
            int i2 = 0;
            while (rs.next()) {
                questions[i2] = rs.getString("Question");
                correctAnswers[i2] = rs.getString("CorrectA");
                for (int j = 0; j < 4; j++) {
                    answers[i2][j] = rs.getString("Answer_" + (j + 1));
                }
                i2++;
            }

            boolean containsNull = false;
            for (int i = 1; i <= questionCount; i++) {
                if (request.getParameter("" + i) == null) {
                    containsNull = true;
                }
            }
            if (request.getParameter("first") == null) {
                if (!containsNull) {
                    int score = 0;
                    for (int i = 1; i <= questionCount; i++) {
                        for (int j = 0; j < correctAnswers.length; j++) {
                            if (request.getParameter("" + i).equals(correctAnswers[j])) {
                                score += 100 / questionCount;
                                break;
                            }
                        }
                    }
                    out.println("<script>alert('Your score is " + score + "');"
                            + "window.location.href = 'test.jsp?score=" + score + "';</script>");
                } else {
                    if (ws.equals("gk2") || ws.equals("gk")) {
                        out.println("<script>alert('Null input');"
                                + "window.location.href = 'TakingTest.jsp?test2=gk2&first=2#Taking_it';</script>");
                    }
                    if (ws.equals("math2") || ws.equals("math")) {
                        out.println("<script>alert('Null input');"
                                + "window.location.href = 'TakingTest.jsp?test2=math2&first=2#Taking_it';</script>");
                    }
                    if (ws.equals("ct2") || ws.equals("ct")) {
                        out.println("<script>alert('Null input');"
                                + "window.location.href = 'TakingTest.jsp?test2=ct2&first=2#Taking_it';</script>");
                    }
                }
            } else {
                if (request.getParameter("first").equals("1")) {
                    int score = 0;
                    for (int i = 1; i <= questionCount; i++) {
                        for (int j = 0; j < correctAnswers.length; j++) {
                            if (request.getParameter("" + i) != null) {
                                if (request.getParameter("" + i).equals(correctAnswers[j])) {
                                    score += 100 / questionCount;
                                    break;
                                }
                            }
                        }
                    }
                    out.println("<script>alert('Your score is " + score + "');"
                            + "window.location.href = 'test.jsp?score=" + score + "';</script>");
                }
            }
        %>

        <%
            int testParam = 0;
            if (ws.equals("gk")) {
                testParam = 1;
            } else if (ws.equals("math")) {
                testParam = 2;
            } else if (ws.equals("ct")) {
                testParam = 3;
            } else if (ws.equals("gk2")) {
                testParam = 4;
            } else if (ws.equals("math2")) {
                testParam = 5;
            } else if (ws.equals("ct2")) {
                testParam = 6;
            }
        %>
        <script>
            min = 5, sec = 01;
            function timer() {
                if (!(min === 0 && sec === 0)) {
                    if (sec === 0) {
                        sec = 60;
                        min--;
                    }
                    sec--;
                    if (min > 0) {
                        if (sec > 9) {
                            document.getElementById("timer").innerHTML = min + ":" + sec;
                        } else {
                            document.getElementById("timer").innerHTML = min + ":0" + sec;
                        }
                    } else {
                        document.getElementById("timer").innerHTML = "";
                        if (sec > 9) {
                            document.getElementById("timered").innerHTML = min + ":" + sec;
                        } else {
                            document.getElementById("timered").innerHTML = min + ":0" + sec;
                        }
                    }
                } else {
                    alert('Time up');

                    var size = 5;
                    var values = new Array(size);
                    for (var j = 0; j < size; j++) {
                        var radios = document.getElementsByName(j);
                        for (var i = 0; i < radios.length; i++) {
                            if (radios[i].checked) {
                                values[j] = radios[i].value;
                                break;
                            }
                        }
                    }

                    var href2 = 'TakingTest.jsp?first=1&';
                    for (i = 1; i < size; i++) {
                        href2 += (i + '=' + values[i] + '&');
                    }
                    href2 += (size + '=' + values[size - 1]);
                    window.location.href = href2;
                }

                setTimeout(timer, 1000);
            }
        </script>
    </head>
    <body style="background-color: #40af64" onload="timer()">
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

            <!--Taking Test Section-->
            <div id="Taking_it">
                <div>
                    <div id="Introduction">
                        <%
                            if (testParam == 1) {
                                out.println("<div class='img'>");
                                out.println("<img src='resource/55763-411x425-Generalknowledge.jpg' />");
                                out.println("</div>");
                                out.println("<div class='title'>");
                                out.println("General Knowledge</div>");
                                out.println("<div class='desc'>");
                                out.println("General knowledge will be your first test. You must pass this to get access to other two tests. General knowledge will test your normal standard intelligence.");
                                out.println("</div>");
                            } else if (testParam == 2) {
                                out.println("<div class='img'>");
                                out.println("<img src='resource/math.jpg' />");
                                out.println("</div>");
                                out.println("<div class='title'>");
                                out.println("Mathematics</div>");
                                out.println("<div class='desc'>");
                                out.println("Mathematics is your second test. You must pass this to get access to final test. You mathematical knowledge will be tested here.");
                                out.println("</div>");
                            } else if (testParam == 3) {
                                out.println("<div class='img'>");
                                out.println("<img src='resource/Computer-Technology1.jpg' />");
                                out.println("</div>");
                                out.println("<div class='title'>");
                                out.println("Computer Technology</div>");
                                out.println("<div class='desc'>");
                                out.println("Lets see if you can handle a computer questions.");
                                out.println("</div>");
                            }
                        %>
                        <%
                            if (testParam != 0 && testParam != 1 && testParam != 2 && testParam != 3) {
                        %>
                        <div class="Timer">
                            <span id="timer"></span>
                            <span id="timered" style="color: red;"></span>
                        </div>
                        <div class="IntroHeader">
                            <%
                                if (testParam == 4) {
                                    out.println("General Knowledge Test");
                                }
                                if (testParam == 5) {
                                    out.println("Mathematics Test");
                                }
                                if (testParam == 6) {
                                    out.println("Computer Technology Test");
                                }
                            %>
                            <hr/>
                        </div>
                        <form action="">
                            <%
                                boolean[] bools = new boolean[questions.length];
                                for (int i = 0; i < bools.length; i++) {
                                    bools[i] = false;
                                }
                                int random = (int) (Math.random() * questions.length);
                                for (int i = 1; i <= questionCount; i++) {
                                    while (bools[random]) {
                                        random = (int) (Math.random() * questions.length);
                                    }
                                    out.println("<div class='QuestionClass'>"
                                            + "<div class='QuestionTitle'>");
                                    out.println(i + ". " + questions[random]);
                                    out.println("</div>");
                                    out.println("<div class='Answer'><input type='radio' name='" + i + "'"
                                            + " value='" + answers[random][0] + "'/> "
                                            + answers[random][0] + "</div>");
                                    out.println("<div class='Answer'><input type='radio' name='" + i + "'"
                                            + " value='" + answers[random][1] + "'/> "
                                            + answers[random][1] + "</div>");
                                    out.println("<div class='Answer'><input type='radio' name='" + i + "'"
                                            + " value='" + answers[random][2] + "'/> "
                                            + answers[random][2] + "</div>");
                                    out.println("<div class='Answer'><input type='radio' name='" + i + "'"
                                            + " value='" + answers[random][3] + "'/> "
                                            + answers[random][3] + "</div></div>");
                                    bools[random] = true;
                                }
                            %>
                            <input type="submit" value="I finished my test" class="buutur"/>
                        </form>
                        <%
                        } else {
                        %>
                        <div id="ButtonContainer">
                            <a href="javascript:history.back()" class="backButton"><img src="resource/back.png" class="hoverEffect"/>Back</a>
                            <a href="<%
                                if (testParam == 1) {
                                    out.print("TakingTest.jsp?test2=" + (ws + "2") + "&first=2#Taking_it");
                                } else if (testParam == 2) {
                                    out.print("TakingTest.jsp?test2=" + (ws + "2") + "&first=2#Taking_it");
                                } else if (testParam == 3) {
                                    out.print("TakingTest.jsp?test2=" + (ws + "2") + "&first=2#Taking_it");
                                }%>" class="startButton">Start<img src="resource/next.png" class="hoverEffect"/></a>
                        </div>
                        <%
                            }
                        %>
                    </div>
                </div>
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
