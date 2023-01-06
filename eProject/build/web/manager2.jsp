<%@page import="classes.TempInfo"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="classes.Managers"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Webster Organization</title>
        <link rel="stylesheet" href="CSS/global_adminstrator.css" type="text/css"/>
        <link rel='stylesheet' type='text/css' href='CSS/control_navigation.css' />
        <script type='text/javascript' src='JS/jquery.min.js'></script>
        <script type='text/javascript' src='JS/menu_jquery.js'></script>
        <script>
            function editF(){
                document.getElementById('sample_totalCandidate').style.display = 'none';
                document.getElementById('sample_totalCandidateEdit').style.display = 'block';
            }
            function deleteF(){
                document.getElementById('sample_totalCandidate').style.display = 'none';
                document.getElementById('sample_totalCandidateDelete').style.display = 'block';
            }
            function resetF(){
                alert("reset button");
            }
            function cancelF(){
                document.getElementById('sample_totalCandidate').style.display = 'block';
                document.getElementById('sample_totalCandidateEdit').style.display = 'none';
                document.getElementById('sample_totalCandidateDelete').style.display = 'none';
            }
            function inboxMailView(id) {
                var haha = "viewServlet?id="+id;
                window.location.href = haha;
            }
            function inboxMailDelete(idI) {
                var linkD = "deleteInboxServlet?id="+idI;
                window.location.href = linkD;
            }
            function inboxMailViewTest() {
                document.getElementById('table_inbox_mail').style.display = 'none';
                document.getElementById('mail_view').style.display = 'block';
            }
            function defaultSend(idD){
                var link = "defaultSendServelt?id="+idD;
                window.location.href = link;
            }
            function backF(){
                document.getElementById('mail_view').style.display = 'none';
                document.getElementById('table_inbox_mail').style.display = 'block';
            }
            function candidateEditBackF(){
                document.getElementById('table_candidate_edit').style.display = 'none';
                document.getElementById('sample_totalCandidate').style.display = 'block';
            }
            function candidateEditF(id) {
                document.getElementById('table_candidate_edit').style.display = 'none';
                document.getElementById('sample_totalCandidate').style.display = 'block';
            }
            function candidateEditValuesF(id) {
                document.getElementById('sample_totalCandidate').style.display = 'none';
                document.getElementById('sample_totalCandidateEdit').style.display = 'none';
                document.getElementById('table_candidate_edit').style.display = 'block';
            }
            function today(){
                var today = "TodayServlet";
                window.location.href = today;
            }
        </script>
    </head>
    <body style="background-color: #ffffff">
        <!--Div to hold all content-->
        <div class="content_wrapper">
            <!--Header Div-->
            <div style="width:100%">
                <div class="headerDiv">
                    <div class="logo">
                        <a href="index.jsp" title="webster" class="logo"><img src="resource/logo.png" alt="Webster"/></a>
                    </div>
                    <div class="search">
                        <form action="index.jsp">
                            <input type="text" name="searchInput" placeholder="Search..."/>
                            <input type="image" name="searchIcon" src="resource/search_icon.png" class="searchIcon"/>
                        </form>
                    </div>
                    <div class="menu">
                        <ul>
                            <a href="manager.jsp?menuRequest=total_candidate"><li><img src="resource/appbar.user.svg"/><span>Total Candidate</span>
                                    <span class="total_num"><%
                                        Class.forName("com.mysql.jdbc.Driver");
                                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/online_aptitude_test", "root", "");
                                        PreparedStatement stm = con.prepareCall("Select * from candidate");
                                        ResultSet rs = stm.executeQuery();
                                        int totalC = 0;
                                        while (rs.next()) {
                                            totalC++;
                                        }
                                        %><%=totalC%></span></li></a>
                            <a href="manager.jsp?menuRequest=total_news"><li><img src="resource/appbar.book.png"/><span>Total News</span>
                                    <span class="total_num"><%
                                        PreparedStatement stm1 = con.prepareCall("Select * from News");
                                        ResultSet rs1 = stm1.executeQuery();
                                        int totalN = 0;
                                        while (rs1.next()) {
                                            totalN++;
                                        }
                                        %><%=totalN%></span></li></a>
                            <a href="manager.jsp?menuRequest=test_result"><li><img src="resource/appbar.page.edit.png"/><span>Test Result</span></li></a>
                            <a href="manager.jsp?menuRequest=inbox"><li style="border-right: 1px lightgray solid;"><img src="resource/appbar.email.png"/><span>Inbox</span>
                                    <span class="total_num"><%
                                        PreparedStatement stm2 = con.prepareCall("Select * from inbox");
                                        ResultSet rs2 = stm2.executeQuery();
                                        int totalI = 0;
                                        while (rs2.next()) {
                                            totalI++;
                                        }
                                        %><%=totalI%></span><span class="total_num_label">unread emails</span></li></a>
                        </ul>
                    </div>
                    <div class="profile">
                        <img src="resource/appbar.user.tie.svg"/>
                        <span class="profile_name"><%
                            String name = "";
                            PreparedStatement stm3 = con.prepareCall("Select * from manager");
                            ResultSet rs3 = stm3.executeQuery();
                            while (rs3.next()) {
                                name = rs3.getString("Username");
                            }%><%=name%></span><br/>
                        <span class="profile_role">Admin</span>
                    </div>
                </div>
            </div>

            <!--Control Div-->
            <div class="control_holder">
                <div id='ctrl_nav'>
                    <ul>
                        <li><a href=''><span>Control Section</span></a></li>
                        <li class='has-sub'><a href=''><span>Tests</span></a>
                            <ul>
                                <li><a href=''><span>General Knowledge</span></a></li>
                                <li><a href=''><span>Mathematics</span></a></li>
                                <li class='last'><a href=''><span>Computer Technology</span></a></li>
                            </ul>
                        </li>
                        <li><a href=''><span>Candidates</span></a></li>
                        <li class='last'><a href=''><span>Managers</span></a></li>
                    </ul>
                </div>
                <div id="first_time_manager">
                    <img src="resource/appbar.cup.png"/>
                    <h1>Welcome</h1>
                    <span>If its your first time grab and read our manual on how to manage your site.<br/>Click the download link</span>
                    <br/>
                    <a href="">Download</a>
                </div>
            </div>

            <!--Content Div-->
            <div class="body_wrapper">
                <div class="sample_window">
                    <%
                        String menuRequest = null;
                        if (request.getParameter("menuRequest") != null) {
                            if (request.getParameter("menuRequest").equals("total_candidate")) {
                                menuRequest = "<a href='manager.jsp?menuRequest=total_candidate' class='sample_window_title_link'>Total Candidate</a>";
                                out.println("<script>document.getElementById('sample_testResult').style.display = 'none';</script>");
                            } else if (request.getParameter("menuRequest").equals("total_news")) {
                                menuRequest = "<a href='manager.jsp?menuRequest=total_news' class='sample_window_title_link'>Total News</a>";
                            } else if (request.getParameter("menuRequest").equals("test_result")) {
                                menuRequest = "<a href='manager.jsp?menuRequest=test_result' class='sample_window_title_link'>Test Result</a>";
                            } else if (request.getParameter("menuRequest").equals("inbox")) {
                                menuRequest = "<a href='manager.jsp?menuRequest=inbox' class='sample_window_title_link'>Inbox</a>";
                            }
                        }
                    %>
                    <div class="sample_window_title">
                        <%
                            if (menuRequest != null) {
                                out.println(menuRequest);
                            } else {
                                out.println("Example Window");
                            }
                        %>
                    </div>
                    <div class="sample_window_content">
                        <%
                            if (request.getParameter("menuRequest") != null) {
                                if (request.getParameter("menuRequest").equals("test_result")) {
                                    //General test result table start
                                    PreparedStatement stm7 = con.prepareCall("Select * from general_result");
                                    ResultSet rs7 = stm7.executeQuery();
                                    PreparedStatement stm10 = con.prepareCall("Select * from candidate");
                                    ResultSet rs10 = stm10.executeQuery();
                                    out.println("<div id='sample_testResult'>");
                                    out.println("<button type='button' onclick='today()'>Today</button>");
                                    out.println("<button type='button' onclick='week'>Week</button>");
                                    out.println("<button type='button' onclick='month'>Month</button>");
                                    if (session.getAttribute("generalTest") == null) {
                                        out.println("<div class='title_table_holder'>");
                                        out.println("<div>General Knowledge Candidates</div>");
                                        out.println("<table cellspacing='7'>");
                                        out.println("<tr><th>Names</th><th>Points</th></tr>");
                                        while (rs7.next()) {
                                            String idG = rs7.getString("C_id");
                                            while (rs10.next()) {
                                                String id = rs10.getString("C_id");
                                                if (idG.equals(id)) {
                                                    String username = rs10.getString("Username");
                                                    String general = rs7.getString("C_general");
                                                    out.println("<tr>");
                                                    out.println("<td>" + username + "</td><td>" + general + "</td>");
                                                    out.println("</tr>");
                                                }
                                            }
                                            rs10.first();
                                        }
                                    } else {
                                        String[][] generalTest = (String[][]) session.getAttribute("generalTest");
                                        int size = 0;
                                        try {
                                            while (generalTest[size][0] != null) {
                                                size++;
                                            }
                                        } catch (ArrayIndexOutOfBoundsException ex) {
                                        }
                                        out.println("<div class='title_table_holder'>");
                                        out.println("<div>General Knowledge Candidates</div>");
                                        out.println("<table cellspacing='7'>");
                                        out.println("<tr><th>Names</th><th>Points</th><th>Date</th></tr>");
                                        for (int i = 0; i < size; i++) {
                                            out.println("<tr>");
                                            out.println("<td>" + generalTest[i][0] + "</td><td>" + generalTest[i][1] + "</td><td>" + generalTest[i][2] + "</td>");
                                            out.println("</tr>");
                                        }
                                        session.setAttribute("generalTest", null);
                                    }
                                    out.println("</table>");
                                    out.println("</div>");
                                    //General test result table end

                                    //Math test result table start
                                    PreparedStatement stm8 = con.prepareCall("Select * from math_result");
                                    ResultSet rs8 = stm8.executeQuery();
                                    stm10 = con.prepareCall("Select * from candidate");
                                    rs10 = stm10.executeQuery();
                                    if (session.getAttribute("mathTest") == null) {
                                        out.println("<div class='title_table_holder'>");
                                        out.println("<div>Mathematics Candidates</div>");
                                        out.println("<table cellspacing='7'>");
                                        out.println("<tr><th>Names</th><th>Points</th></tr>");

                                        while (rs8.next()) {
                                            String idM = rs8.getString("C_id");
                                            String math = rs8.getString("C_math");
                                            while (rs10.next()) {
                                                String id = rs10.getString("C_id");
                                                String username = rs10.getString("Username");
                                                if (idM.equals(id)) {
                                                    out.println("<tr>");
                                                    out.println("<td>" + username + "</td><td>" + math + "</td>");
                                                    out.println("</tr>");
                                                }
                                            }
                                            rs10.first();
                                        }
                                    } else {
                                        String[][] mathTest = (String[][]) session.getAttribute("mathTest");
                                        int size = 0;
                                        try {
                                            while (mathTest[size][0] != null) {
                                                size++;
                                            }
                                        } catch (ArrayIndexOutOfBoundsException ex) {
                                        }
                                        out.println("<div class='title_table_holder'>");
                                        out.println("<div>Mathematics Candidates</div>");
                                        out.println("<table cellspacing='7'>");
                                        out.println("<tr><th>Names</th><th>Points</th><th>Date</th></tr>");
                                        for (int i = 0; i < size; i++) {
                                            out.println("<tr>");
                                            out.println("<td>" + mathTest[i][0] + "</td><td>" + mathTest[i][1] + "</td><td>" + mathTest[i][2] + "</td>");
                                            out.println("</tr>");
                                        }
                                        session.setAttribute("mathTest", null);
                                    }
                                    out.println("</table>");
                                    out.println("</div>");
                                    //Math test result table end

                                    //It test result table start
                                    PreparedStatement stm9 = con.prepareCall("Select * from it_result");
                                    ResultSet rs9 = stm9.executeQuery();
                                    stm10 = con.prepareCall("Select * from candidate");
                                    rs10 = stm10.executeQuery();
                                    if (session.getAttribute("itTest") == null) {
                                        out.println("<div class='title_table_holder'>");
                                        out.println("<div>Computer Technology Candidates</div>");
                                        out.println("<table cellspacing='7'>");
                                        out.println("<tr><th>Names</th><th>Points</th></tr>");
                                        while (rs9.next()) {
                                            String idI = rs9.getString("C_id");
                                            String it = rs9.getString("C_it");
                                            while (rs10.next()) {
                                                String id = rs10.getString("C_id");
                                                String username = rs10.getString("Username");
                                                if (idI.equals(id)) {
                                                    out.println("<tr>");
                                                    out.println("<td>" + username + "</td><td>" + it + "</td>");
                                                    out.println("</tr>");
                                                }
                                            }
                                            rs10.first();
                                        }
                                    } else {
                                        String[][] itTest = (String[][]) session.getAttribute("itTest");
                                        int size = 0;
                                        try {
                                            while (itTest[size][0] != null) {
                                                size++;
                                            }
                                        } catch (ArrayIndexOutOfBoundsException ex) {
                                        }
                                        out.println("<div class='title_table_holder'>");
                                        out.println("<div>Computer Technology Candidates</div>");
                                        out.println("<table cellspacing='7'>");
                                        out.println("<tr><th>Names</th><th>Points</th><th>Date</th></tr>");
                                        for (int i = 0; i < size; i++) {
                                            out.println("<tr>");
                                            out.println("<td>" + itTest[i][0] + "</td><td>" + itTest[i][1] + "</td><td>" + itTest[i][2] + "</td>");
                                            out.println("</tr>");
                                        }
                                        session.setAttribute("itTest", null);
                                    }
                                    out.println("</table>");
                                    out.println("</div>");
                                    //It test result table end
                                    out.println("</div>");
                                } else if (request.getParameter("menuRequest").equals("total_candidate")) {
                                    out.println("<div id='sample_candidate_edit'>");
                                    out.println("<div id='table_candidate_edit' style='display: none;'>");
                                    String idD = request.getParameter("id");
                                    out.println("<form action='EditCandidate'>");
                                    out.println("<div class='column_infor' style='margin: 5px 0px 0px 10px;'>");
                                    out.println("<span class='title'>Personal Information</span><br/>");
                                    out.println("<table cellspacing='0' cellpadding='5' border='0' >");
                                    out.println("<tr><th>Id</th><td><input type='text' name='id' value='" + request.getParameter("id") + "' /></td></tr>");
                                    out.println("<tr><th>First Name</th><td><input type='text' name='fname' value='" + request.getParameter("fname") + "'/></td></tr>");
                                    out.println("<tr><th>Last Name</th><td><input type='text' name='lname' value='" + request.getParameter("lname") + "'/></td></tr>");
                                    out.println("<tr><th>Birthdate</th><td><input type='text' name='birthdate' value='" + request.getParameter("birthdate") + "'/></td></tr>");
                                    out.println("<tr><th>Age</th><td><input type='text' name='age' value='" + request.getParameter("age") + "'/></td></tr>");
                                    out.println("<tr><th>Gender</th><td><input type='text' name='gender' value='" + request.getParameter("gender") + "'/></td></tr>");
                                    out.println("<tr><th>Address</th><td><input type='text' name='address' value='" + request.getParameter("address") + "'/></td></tr>");
                                    out.println("<tr><th>Phone</th><td><input type='text' name='phone' value='" + request.getParameter("phone") + "'/></td></tr>");
                                    out.println("<tr><th>Email</th><td><input type='text' name='email' value='" + request.getParameter("email") + "'/></td></tr>");
                                    out.println("<tr><th>Status</th><td><input type='text' name='status' value='" + request.getParameter("status") + "'/></td></tr>");
                                    out.println("</table>");
                                    out.println("</div>");
                                    out.println("<div class='column_infor' style='margin: 5px 0px 0px 450px;'>");
                                    out.println("<span class='title'>Education</span><br/>");
                                    out.println("<table cellspacing='0' cellpadding='5' border='0'>");
                                    out.println("<tr><th>Degree</th><td><input type='text' name='degree' value='" + request.getParameter("degree") + "'/></td></tr>");
                                    out.println("</table>");
                                    out.println("</div>");
                                    out.println("<div class='column_infor' style='margin: 100px 0px 0px 450px'>");
                                    out.println("<span class='title'>Job Experience</span><br/>");
                                    out.println("<table cellspacing='0' cellpadding='5' border='0'>");
                                    out.println("<tr><th>Major</th><td><input type='text' name='category' value='" + request.getParameter("category") + "'/></td></tr>");
                                    out.println("<tr><th>Experience years</th><td><input type='text' name='years' value='" + request.getParameter("years") + "'/></td></tr>");
                                    out.println("</table>");
                                    out.println("</div>");
                                    out.println("<div class='button_contain' style='margin: 340px 0px 0px 0px;'>");
                                    out.println("<button type='button' onclick='candidateEditBackF()'>Back</button>");
                                    out.println("<button type='submit' onclick='candidateEditF()''>Edit</button>");
                                    out.println("</div>");
                                    out.println("</form>");
                                    out.println("</div>");

                                    out.println("<div id='sample_totalCandidate'>");
                                    out.println("<table cellspacing='5' cellpadding='5'");
                                    out.println("<tr>");
                                    out.println("<th>ID</th><th>First Name</th><th>Last Name</th><th>Birthdate</th><th>Age</th>"
                                            + "<th>Gender</th><th>Status</th><th>Address</th><th>Phone</th><th>Email</th>");
                                    out.println("</tr>");
                                    PreparedStatement stm4 = con.prepareCall("Select * from candidate_personal");
                                    ResultSet rs4 = stm4.executeQuery();
                                    while (rs4.next()) {
                                        String idP = rs4.getString("C_id");
                                        String fname = rs4.getString("F_Name");
                                        String lname = rs4.getString("L_Name");
                                        String birthdate = rs4.getString("Birthdate");
                                        String age = rs4.getString("Age");
                                        String gender = rs4.getString("Gender");
                                        String status = rs4.getString("Status");
                                        String address = rs4.getString("Address");
                                        String phone = rs4.getString("Phone");
                                        String email = rs4.getString("Email");
                                        out.println("<tr>");
                                        out.println("<td>" + idP + "</td><td>" + fname + "</td><td>" + lname + "</td><td>" + birthdate + "</td>"
                                                + "<td>" + age + "</td><td>" + gender + "</td><td>" + status + "</td><td>" + address + "</td>"
                                                + "<td>" + phone + "</td><td>" + email + "</td>");
                                        out.println("</tr>");
                                    }
                                    out.println("</table>");
                                    out.println("<input type='button' value='edit' onclick='editF()'/>");
                                    out.println("<input type='button' value='delete' onclick='deleteF()'/>");
                                    out.println("</div>");
                                    //edit
                                    out.println("<div style='display:none;' id='sample_totalCandidateEdit'>");
                                    out.println("<form action='EditCandidateValues'>");
                                    out.println("Select edit candidate id: ");
                                    out.println("<select name='idE'>");
                                    out.println("<option>none</option>");
                                    PreparedStatement stmEdit = con.prepareCall("Select * from candidate");
                                    ResultSet rsEdit = stmEdit.executeQuery();
                                    while (rsEdit.next()) {
                                        String idE = rsEdit.getString("C_id");
                                        out.println("<option value='" + idE + "'>" + idE + "</option>");
                                    }
                                    out.println("</select><br>");
                                    out.println("<input type='submit' value='edit'/>");
                                    out.println("<input type='button' value='reset' onclick='resetF()'/>");
                                    out.println("<input type='button' value='cancel' onclick='cancelF()'/>");
                                    out.println("</form>");
                                    out.println("</div>");

                                    //delete
                                    out.println("<div style='display:none;' id='sample_totalCandidateDelete'>");
                                    out.println("<form action='deleteCandidateServlet'>");
                                    out.println("Select delete candidate id: ");
                                    out.println("<select name='idD'>");
                                    out.println("<option>none</option>");
                                    PreparedStatement stmDelete = con.prepareCall("Select * from candidate");
                                    ResultSet rsDelete = stmDelete.executeQuery();
                                    while (rsDelete.next()) {
                                        String idDelete = rsDelete.getString("C_id");
                                        out.println("<option value='" + idDelete + "'>" + idDelete + "</option>");
                                    }
                                    out.println("</select><br>");
                                    out.println("<input type='submit' value='delete'/>");
                                    out.println("<input type='button' value='cancel' onclick='cancelF()'/>");
                                    out.println("</form>");
                                    out.println("</div>");

                                    if (request.getParameter("fromCandidate") != null) {
                                        if (request.getParameter("fromCandidate").equals("true")) {
                                            out.print("<script>candidateEditValuesF()</script>");
                                        }
                                    }
                                    out.println("</div>");
                                } else if (request.getParameter("menuRequest").equals("total_news")) {
                                    out.println("<div id='sample_totalNews'>");
                                    out.println("<table>");
                                    PreparedStatement stm5 = con.prepareCall("Select * from news");
                                    ResultSet rs5 = stm5.executeQuery();
                                    for (int a = 0; a < totalN; a++) {
                                        while (rs5.next()) {
                                            String title = rs5.getString("News_Title");
                                            String picture = rs5.getString("News_Picture");
                                            String description = rs5.getString("News_Description");
                                            out.println("<tr>");
                                            out.println("<td>");
                                            out.println("<div id='picture'>");
                                            out.println("<img src='" + picture + "' alt='" + title + "'>");
                                            out.println("</div>");
                                            out.println("<div id='news'>");
                                            out.println("<span>" + description + "</span>");
                                            out.println("</div>");
                                            out.println("</td>");
                                            out.println("</tr>");
                                        }
                                    }
                                    out.println("</table>");
                                    out.println("</div>");
                                } else if (request.getParameter("menuRequest").equals("inbox")) {
                                    out.println("<div id='sample_inbox'>");
                                    PreparedStatement stm6 = con.prepareCall("Select * from inbox");
                                    ResultSet rs6 = stm6.executeQuery();
                                    out.println("<div id='mail_view' style='display: none;'>");
                                    out.println("<div class='column_infor' style='margin: 5px 0px 0px 10px;'>");
                                    out.println("<span class='title'>Personal Information</span><br/>");
                                    out.println("<table cellspacing='0' cellpadding='5' border='0' >");
                                    out.println("<tr><th>First Name</th><td>" + request.getParameter("fname") + "</td></tr>");
                                    out.println("<tr><th>Last Name</th><td>" + request.getParameter("lname") + "</td></tr>");
                                    out.println("<tr><th>Birthdate</th><td>" + request.getParameter("birthdate") + "</td></tr>");
                                    out.println("<tr><th>Age</th><td>" + request.getParameter("age") + "</td></tr>");
                                    out.println("<tr><th>Gender</th><td>" + request.getParameter("gender") + "</td></tr>");
                                    out.println("<tr><th>Address</th><td>" + request.getParameter("address") + "</td></tr>");
                                    out.println("<tr><th>Phone</th><td>" + request.getParameter("phone") + "</td></tr>");
                                    out.println("<tr><th>Email</th><td>" + request.getParameter("email") + "</td></tr>");
                                    out.println("<tr><th>Status</th><td>" + request.getParameter("status") + "</td></tr>");
                                    out.println("</table>");
                                    out.println("</div>");
                                    out.println("<div class='column_infor' style='margin: 5px 0px 0px 450px;'>");
                                    out.println("<span class='title'>Education</span><br/>");
                                    out.println("<table cellspacing='0' cellpadding='5' border='0'>");
                                    out.println("<tr><th>Degree</th><td>" + request.getParameter("degree") + "</td></tr>");
                                    out.println("</table>");
                                    out.println("</div>");
                                    out.println("<div class='column_infor' style='margin: 100px 0px 0px 450px'>");
                                    out.println("<span class='title'>Job Experience</span><br/>");
                                    out.println("<table cellspacing='0' cellpadding='5' border='0'>");
                                    out.println("<tr><th>Major</th><td>" + request.getParameter("category") + "</td></tr>");
                                    out.println("<tr><th>Experience years</th><td>" + request.getParameter("years") + "</td></tr>");
                                    out.println("</table>");
                                    out.println("</div>");
                                    out.println("<div class='set_log' style='margin: 225px 0px 0px 450px;'>");
                                    String idD = request.getParameter("id");
                                    out.println("<form>");
                                    out.println("<input type='text' name='username' placeholder='Set username...'/>");
                                    out.println("<input type='password' name='password' placeholder='Set password...'/>");
                                    out.println("<input type='button' onclick='defaultSend(" + idD + ")' value='Default'/>");
                                    out.println("<input type='submit' name='admin' value='Save and Send'/>");
                                    out.println("</form>");
                                    out.println("</div>");
                                    out.println("<div class='button_contain' style='margin: 340px 0px 0px 0px;'>");
                                    out.println("<button type='button' onclick='back()'>Back</button>");
                                    out.println("<button type='button' onclick='inboxMailDelete(" + idD + ")''>Delete</button>");
                                    out.println("</div>");
                                    out.println("</div>");
                                    out.println("<table id='table_inbox_mail'><tr><td>");
                                    out.println("<div class='inbox_mail_title' style='width: 100px'>ID</div>");
                                    out.println("<div class='inbox_mail_title'>Full Name</div>");
                                    out.println("<div class='inbox_mail_title'>Actions</div>");
                                    out.println("<div class='inbox_mail_title'>Descriptions</div>");
                                    out.println("<div class='inbox_mail_title'>Date</div>");
                                    out.println("</td></tr><tr><td>");
                                    if (request.getParameter("fromView") != null) {
                                        if (request.getParameter("fromView").equals("true")) {
                                            out.print("<script>inboxMailViewTest()</script>");
                                        }
                                    }
                                    while (rs6.next()) {
                                        String id = rs6.getString("in_id");
                                        String fname = rs6.getString("F_Name");
                                        String lname = rs6.getString("L_Name");
                                        String birthdate = rs6.getString("Birthdate");
                                        String age = rs6.getString("Age");
                                        String gender = rs6.getString("Gender");
                                        String phone = rs6.getString("Phone");
                                        String email = rs6.getString("Email");
                                        String address = rs6.getString("Address");
                                        String status = rs6.getString("Status");
                                        String degree = rs6.getString("Degree");
                                        String years = rs6.getString("Years");
                                        String category = rs6.getString("Category");
                                        String description = rs6.getString("Description");
                                        out.println("<div class='inbox_mail'>");
                                        out.println("<div class='inbox_mail_view'>");
                                        out.println("</div>");
                                        out.println("<div class='inbox_mail_cell' style='width: 100px'>" + id + "</div>");
                                        out.println("<div class='inbox_mail_cell'>" + fname + " " + lname + "</div>");
                                        out.println("<div class='inbox_mail_cell'>"
                                                + "<button type='button' onclick='inboxMailDelete(" + id + ")'>Delete</button>&nbsp;&nbsp;&nbsp;&nbsp;"
                                                + "<button type='button' onclick='inboxMailView(" + id + ")'>View</button></form></div>");
                                        out.println("<div class='inbox_mail_cell'>" + description + "</div>");
                                        out.println("<div class='inbox_mail_cell'>12/21/2012</div>");
                                        out.println("</div>");
                                    }
                                    out.println("</td></tr></table>");
                                }
                            }
                        %>
                    </div>
                </div>
            </div>
        </div>
        <!--Footer Div-->
    </div>
</body>
</html>