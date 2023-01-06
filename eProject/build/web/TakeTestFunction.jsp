<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            int questionCount = 10;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/online_aptitude_test", "root", "");
            PreparedStatement stm = con.prepareCall("Select * from general_test");
            ResultSet rs = stm.executeQuery();

            String[] questions = new String[26];
            String[] correctAnswers = new String[26];
            String[][] answers = new String[26][4];
            int i2 = 0;
            while (rs.next()) {
                questions[i2] = rs.getString("question");
                correctAnswers[i2] = rs.getString("correctA");
                for (int j = 0; j < 4; j++) {
                    answers[i2][j] = rs.getString("answer" + (j + 1));
                }
                i2++;
            }
        %>
        <%
            if (request.getParameter("first") == null) {
                boolean containsNull = false;
                for (int i = 1; i <= questionCount; i++) {
                    if (request.getParameter("" + i) == null) {
                        containsNull = true;
                    }
                }
                if (containsNull) {
                    out.println("<script>alert('Null input');</script>");
                } else {
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
                            + "window.location.href = 'index.jsp';</script>");
                }
            }
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Taking Test Example Functional</title>
        <script>
            min = 40, sec = 10;
            function timer() {
                if (!(min === 0 && sec === 0)) {
                    if (sec === 0) {
                        sec = 60;
                        min--;
                    }
                    sec--;

                    if (min > 4) {
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

                    var size = 10;
                    var values = new Array(10);
                    for (var j = 0; j < size; j++) {
                        var radios = document.getElementsByName(j);
                        for (var i = 0, length = radios.length; i < length; i++) {
                            if (radios[i].checked) {
                                values[j] = radios[i].value;
                                break;
                            }
                        }
                    }

                    var href2 = 'index.jsp?';
                    for (i = 1; i < size; i++) {
                        href2 += (i + '=' + values[i] + '&');
                    }
                    href2 += (size + '=' + values[size]);
                    window.location.href = href2;
                }

                setTimeout(timer, 1000);
            }
        </script>
    </head>
    <body onload="timer()">
        <div class="Timer">
            <span id="timer"></span>
            <span id="timered" style="color: red;"></span>
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
                    out.println(i + ". " + questions[random] + "<br/>");
                    out.println("<input type='radio' name='" + i + "'"
                            + " value='" + answers[random][0] + "'/>"
                            + answers[random][0] + "<br/>");
                    out.println("<input type='radio' name='" + i + "'"
                            + " value='" + answers[random][1] + "'/>"
                            + answers[random][1] + "<br/>");
                    out.println("<input type='radio' name='" + i + "'"
                            + " value='" + answers[random][2] + "'/>"
                            + answers[random][2] + "<br/>");
                    out.println("<input type='radio' name='" + i + "'"
                            + " value='" + answers[random][3] + "'/>"
                            + answers[random][3] + "<br/>");
                    bools[random] = true;
                }
            %>
            <input type="submit" value="I finished my test"/>
        </form>
    </body>
</html>
