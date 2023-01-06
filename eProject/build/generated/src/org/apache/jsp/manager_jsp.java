package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Connection;
import classes.Managers;

public final class manager_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"shortcut icon\" href=\"resource/icon.png\">\n");
      out.write("        <title>Webster Organization</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"CSS/global_adminstrator.css\" type=\"text/css\"/>\n");
      out.write("        <link rel='stylesheet' type='text/css' href='CSS/control_navigation.css' />\n");
      out.write("        <script type='text/javascript' src='JS/jquery.min.js'></script>\n");
      out.write("        <script type='text/javascript' src='JS/menu_jquery.js'></script>\n");
      out.write("        <script>\n");
      out.write("            function editF(){\n");
      out.write("                document.getElementById('sample_totalCandidate').style.display = 'none';\n");
      out.write("                document.getElementById('sample_totalCandidateEdit').style.display = 'block';\n");
      out.write("            }\n");
      out.write("            function deleteF(){\n");
      out.write("                document.getElementById('sample_totalCandidate').style.display = 'none';\n");
      out.write("                document.getElementById('sample_totalCandidateDelete').style.display = 'block';\n");
      out.write("            }\n");
      out.write("            function resetF(){\n");
      out.write("                alert(\"reset button\");\n");
      out.write("            }\n");
      out.write("            function cancelF(){\n");
      out.write("                document.getElementById('sample_totalCandidate').style.display = 'block';\n");
      out.write("                document.getElementById('sample_totalCandidateEdit').style.display = 'none';\n");
      out.write("                document.getElementById('sample_totalCandidateDelete').style.display = 'none';\n");
      out.write("            }\n");
      out.write("            function inboxMailView(id) {\n");
      out.write("                var haha = \"viewServlet?id=\"+id;\n");
      out.write("                window.location.href = haha;\n");
      out.write("            }\n");
      out.write("            function inboxMailDelete(idI) {\n");
      out.write("                var linkD = \"deleteInboxServlet?id=\"+idI;\n");
      out.write("                window.location.href = linkD;\n");
      out.write("            }\n");
      out.write("            function inboxMailViewTest() {\n");
      out.write("                document.getElementById('table_inbox_mail').style.display = 'none';\n");
      out.write("                document.getElementById('mail_view').style.display = 'block';\n");
      out.write("            }\n");
      out.write("            function defaultSend(idD){\n");
      out.write("                var link = \"defaultSendServelt?id=\"+idD;\n");
      out.write("                window.location.href = link;\n");
      out.write("            }\n");
      out.write("            function backF(){\n");
      out.write("                document.getElementById('mail_view').style.display = 'none';\n");
      out.write("                document.getElementById('table_inbox_mail').style.display = 'block';\n");
      out.write("            }\n");
      out.write("            function candidateEditBackF(){\n");
      out.write("                document.getElementById('table_candidate_edit').style.display = 'none';\n");
      out.write("                document.getElementById('sample_totalCandidate').style.display = 'block';\n");
      out.write("            }\n");
      out.write("            function candidateEditF(id) {\n");
      out.write("                document.getElementById('table_candidate_edit').style.display = 'none';\n");
      out.write("                document.getElementById('sample_totalCandidate').style.display = 'block';\n");
      out.write("            }\n");
      out.write("            function candidateEditValuesF(id) {\n");
      out.write("                document.getElementById('sample_totalCandidate').style.display = 'none';\n");
      out.write("                document.getElementById('sample_totalCandidateEdit').style.display = 'none';\n");
      out.write("                document.getElementById('table_candidate_edit').style.display = 'block';\n");
      out.write("            }\n");
      out.write("            function testMenu_editWindow() {\n");
      out.write("                document.getElementById('table_testMenu').style.display = 'none';\n");
      out.write("                var a = document.getElementsByClassName('testMenuAddButton');\n");
      out.write("                var b = a.length;\n");
      out.write("                while (b--) {\n");
      out.write("                    a[b].style.display = 'none';\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function testMenu_editButton(test, id) {\n");
      out.write("                var id = id;\n");
      out.write("                var test = test;\n");
      out.write("                var ts;\n");
      out.write("                if (test === 1) {\n");
      out.write("                    ts = \"gk\";\n");
      out.write("                } else if (test === 2) {\n");
      out.write("                    ts = \"math\";\n");
      out.write("                } else if (test === 3) {\n");
      out.write("                    ts = \"ct\";\n");
      out.write("                }\n");
      out.write("                var url = \"EditQuestionValues?testMenu=\"+ts+\"&id=\"+id;\n");
      out.write("                window.location.href = url;\n");
      out.write("            }\n");
      out.write("            function testMenu_calcelButton() {\n");
      out.write("                var id = id;\n");
      out.write("                var test = test;\n");
      out.write("                var ts;\n");
      out.write("                if (test === 1) {\n");
      out.write("                    ts = \"gk\";\n");
      out.write("                } else if (test === 2) {\n");
      out.write("                    ts = \"math\";\n");
      out.write("                } else if (test === 3) {\n");
      out.write("                    ts = \"ct\";\n");
      out.write("                }\n");
      out.write("                var url = \"EditQuestionValues?testMenu=\"+ts+\"&editQuestion=false&id=\"+id;\n");
      out.write("                window.location.href = url;\n");
      out.write("            }\n");
      out.write("            function testMenu_delete(id) {\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("            function testMenu_addWindow() {\n");
      out.write("                document.getElementById('table_testMenu').style.display = 'none';\n");
      out.write("                var a = document.getElementsByClassName('testMenuAddButton');\n");
      out.write("                var b = a.length;\n");
      out.write("                while (b--) {\n");
      out.write("                    a[b].style.display = 'none';\n");
      out.write("                }\n");
      out.write("                document.getElementById('testMenu_addNew').style.display = 'block';\n");
      out.write("            }\n");
      out.write("            function testMenu_cancel() {\n");
      out.write("                document.getElementById('table_testMenu').style.display = 'block';\n");
      out.write("                var a = document.getElementsByClassName('testMenuAddButton');\n");
      out.write("                var b = a.length;\n");
      out.write("                while (b--) {\n");
      out.write("                    a[b].style.display = 'block';\n");
      out.write("                }\n");
      out.write("                document.getElementById('testMenu_addNew').style.display = 'none';\n");
      out.write("            }\n");
      out.write("            function today(){\n");
      out.write("                var today = \"TodayServlet\";\n");
      out.write("                window.location.href = today;\n");
      out.write("            }\n");
      out.write("            function addQuestion(){\n");
      out.write("                document.getElementById('testMenu_addNew').style.display = 'none';\n");
      out.write("                var a = document.getElementsByClassName('testMenuAddButton');\n");
      out.write("                var b = a.length;\n");
      out.write("                while (b--) {\n");
      out.write("                    a[b].style.display = 'block';\n");
      out.write("                }\n");
      out.write("                document.getElementById('table_testMenu').style.display = 'block';\n");
      out.write("            }\n");
      out.write("            function questionDelete(test, id){\n");
      out.write("                var id = id;\n");
      out.write("                var test = test;\n");
      out.write("                var ts;\n");
      out.write("                if (test === 1) {\n");
      out.write("                    ts = \"General Knowledge\";\n");
      out.write("                } else if (test === 2) {\n");
      out.write("                    ts = \"Mathematics\";\n");
      out.write("                } else if (test === 3) {\n");
      out.write("                    ts = \"Computer Technology\";\n");
      out.write("                }\n");
      out.write("                var url = \"DeleteQuestionServlet?questionType=\"+ts+\"&questionId=\"+id;\n");
      out.write("                window.location.href = url;\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"background-color: #ffffff\">\n");
      out.write("        <!--Div to hold all content-->\n");
      out.write("        <div class=\"content_wrapper\">\n");
      out.write("            <!--Header Div-->\n");
      out.write("            <div style=\"width:100%\">\n");
      out.write("                <div class=\"headerDiv\">\n");
      out.write("                    <div class=\"logo\">\n");
      out.write("                        <a href=\"index.jsp\" title=\"webster\" class=\"logo\"><img src=\"resource/logo.png\" alt=\"Webster\"/></a>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"search\">\n");
      out.write("                        <form action=\"\">\n");
      out.write("                            <input type=\"text\" name=\"searchInput\" placeholder=\"Search...\"/>\n");
      out.write("                            <input type=\"image\" name=\"searchIcon\" src=\"resource/search_icon.png\" class=\"searchIcon\"/>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"menu\">\n");
      out.write("                        <ul>\n");
      out.write("                            <a href=\"manager.jsp?menuRequest=total_candidate\"><li><img src=\"resource/appbar.user.svg\"/><span>Total Candidate</span>\n");
      out.write("                                    <span class=\"total_num\">");

                                        Class.forName("com.mysql.jdbc.Driver");
                                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/online_aptitude_test", "root", "");
                                        PreparedStatement stm = con.prepareCall("Select * from candidate");
                                        ResultSet rs = stm.executeQuery();
                                        int totalC = 0;
                                        while (rs.next()) {
                                            totalC++;
                                        }
                                        
      out.print(totalC);
      out.write("</span></li></a>\n");
      out.write("                            <a href=\"manager.jsp?menuRequest=total_news\"><li><img src=\"resource/appbar.book.png\"/><span>Total News</span>\n");
      out.write("                                    <span class=\"total_num\">");

                                        PreparedStatement stm1 = con.prepareCall("Select * from news");
                                        ResultSet rs1 = stm1.executeQuery();
                                        int totalN = 0;
                                        while (rs1.next()) {
                                            totalN++;
                                        }
                                        
      out.print(totalN);
      out.write("</span></li></a>\n");
      out.write("                            <a href=\"manager.jsp?menuRequest=test_result\"><li><img src=\"resource/appbar.page.edit.png\"/><span>Test Result</span></li></a>\n");
      out.write("                            <a href=\"manager.jsp?menuRequest=inbox\"><li style=\"border-right: 1px lightgray solid;\"><img src=\"resource/appbar.email.png\"/><span>Inbox</span>\n");
      out.write("                                    <span class=\"total_num\">");

                                        PreparedStatement stm2 = con.prepareCall("Select * from inbox");
                                        ResultSet rs2 = stm2.executeQuery();
                                        int totalI = 0;
                                        while (rs2.next()) {
                                            totalI++;
                                        }
                                        
      out.print(totalI);
      out.write("</span><span class=\"total_num_label\">unread emails</span></li></a>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"profile\">\n");
      out.write("                        <img src=\"resource/appbar.user.tie.svg\"/>\n");
      out.write("                        <span class=\"profile_name\">");

                            String name = "";
                            PreparedStatement stm3 = con.prepareCall("Select * from manager");
                            ResultSet rs3 = stm3.executeQuery();
                            while (rs3.next()) {
                                name = rs3.getString("Username");
                            }
      out.print(name);
      out.write("</span><br/>\n");
      out.write("                        <span class=\"profile_role\">Admin</span>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!--Control Div-->\n");
      out.write("            <div class=\"control_holder\">\n");
      out.write("                <div id='ctrl_nav'>\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=''><span>Control Section</span></a></li>\n");
      out.write("                        <li class='has-sub'><a href=''><span>Tests</span></a>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href='manager.jsp?testMenu=gk'><span>General Knowledge</span></a></li>\n");
      out.write("                                <li><a href='manager.jsp?testMenu=math'><span>Mathematics</span></a></li>\n");
      out.write("                                <li class='last'><a href='manager.jsp?testMenu=ct'><span>Computer Technology</span></a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                        <li class='last'><a href=''><span>Managers</span></a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"first_time_manager\">\n");
      out.write("                    <img src=\"resource/appbar.cup.png\"/>\n");
      out.write("                    <h1>Welcome</h1>\n");
      out.write("                    <span>If its your first time grab and read our manual on how to manage your site.<br/>Click the download link</span>\n");
      out.write("                    <br/>\n");
      out.write("                    <a href=\"resource/Management_Manual.docx\">Download</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!--Content Div-->\n");
      out.write("            <div class=\"body_wrapper\">\n");
      out.write("                <div class=\"sample_window\">\n");
      out.write("                    ");

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
                        if (request.getParameter("testMenu") != null) {
                            if (request.getParameter("testMenu").equals("gk")) {
                                menuRequest = "<a href='manager.jsp?testMenu=gk' class='sample_window_title_link'>General Knowledge</a>";
                            } else if (request.getParameter("testMenu").equals("math")) {
                                menuRequest = "<a href='manager.jsp?testMenu=math' class='sample_window_title_link'>Mathematics</a>";
                            } else if (request.getParameter("testMenu").equals("ct")) {
                                menuRequest = "<a href='manager.jsp?testMenu=ct' class='sample_window_title_link'>Computer Technology</a>";
                            }
                        }
                    
      out.write("\n");
      out.write("                    <div class=\"sample_window_title\">\n");
      out.write("                        ");

                            if (menuRequest != null) {
                                out.println(menuRequest);
                            } else if (request.getParameter("searchInput") != null) {
                                out.println("Search Results");
                            } else {
                                out.println("Example Window");
                            }
                        
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"sample_window_content\">\n");
      out.write("                        ");
if (request.getParameter("searchInput") != null) {
                                String input = request.getParameter("searchInput").toLowerCase();
                                PreparedStatement searchPs = con.prepareCall("Select * from candidate_personal");
                                ResultSet searchRs = searchPs.executeQuery();
                                out.println("<div id='table_candidate_edit'>");
                                out.println("<div class='column_infor' style='margin: 5px 0px 0px 10px;'>");
                                out.println("<table cellspacing='0' cellpadding='5' border='0' >");
                                out.println("<tr><th>Id</th><th>First Name</th><th>Last Name</th>"
                                        + "<th>Birthdate</th><th>Age</th><th>Gender</th>"
                                        + "<th>Status</th><th>Address</th>"
                                        + "<th>Phone</th><th>Email</th></tr>");
                                while (searchRs.next()) {
                                    String searchingIt = searchRs.getString("F_name").toLowerCase();
                                    if (searchingIt.equals(input) || searchingIt.contains(input)) {
                                        out.println("<tr><td>" + searchRs.getString("C_id") + "</td>"
                                                + "<td>" + searchRs.getString("F_name") + "</td>"
                                                + "<td>" + searchRs.getString("L_name") + "</td>"
                                                + "<td>" + searchRs.getString("Birthdate") + "</td>"
                                                + "<td>" + searchRs.getString("Age") + "</td>"
                                                + "<td>" + searchRs.getString("Gender") + "</td>"
                                                + "<td>" + searchRs.getString("Status") + "</td>"
                                                + "<td>" + searchRs.getString("Address") + "</td>"
                                                + "<td>" + searchRs.getString("Phone") + "</td>"
                                                + "<td>" + searchRs.getString("Email") + "</td>"
                                                + "</tr>");
                                    }
                                }
                                out.println("</table>");
                                out.println("</div></div>");
                            } else {
                                if (request.getParameter("testMenu") != null) {
                                    out.println("<div id='testMenu_addNew'>");
                                    out.println("<table border='0' cellpadding='5' cellspacing='0'>");
                                    out.println("<form action='AddQuestionServlet'>");
                                    out.println("<tr><td><span>Category: </span></td><td><select name='type'><option>General Knowledge</option><option>Mathematics</option><option>Computer Technology</option></select></td></tr>");
                                    out.println("<tr><td><span>Question: </span></td><td><input name='question' type='text' placeholder='Enter Question'/></td></tr>");
                                    out.println("<tr><td><span>Answer 1: </span></td><td><input name='answer1' type='text' placeholder='Enter Answer 1'/></td></tr>");
                                    out.println("<tr><td><span>Answer 2: </span></td><td><input name='answer2' type='text' placeholder='Enter Answer 2'/></td></tr>");
                                    out.println("<tr><td><span>Answer 3: </span></td><td><input name='answer3' type='text' placeholder='Enter Answer 3'/></td></tr>");
                                    out.println("<tr><td><span>Answer 4: </span></td><td><input name='answer4' type='text' placeholder='Enter Answer 4'/></td></tr>");
                                    out.println("<tr><td><span>Correct Answer: </span></td><td><select  name='cAnswer'><option>Answer 1</option><option>Answer 2</option><option>Answer 3</option><option>Answer 4</option></select></td></tr>");
                                    out.println("<tr><td><button type='button' id='FingButton' onclick='testMenu_cancel()'>Cancel</button></td>"
                                            + "<td><button type='submit' onclick='addQuestion()' style='float: left; margin-left: 10px;' id='FingButton'>Add Question</button></td></tr>");
                                    out.println("</form>");
                                    out.println("</table>");
                                    out.println("</div>");

                                    out.println("<div id='testMenu'>");
                                    out.println("<button type='button' class='testMenuAddButton' id='FingButton' onclick='testMenu_addWindow()'>Add New Question</button>");
                                    out.println("<table id='table_testMenu'><tr><td>");
                                    out.println("<div class='table_testMenu_title' style='width: 20px;'>ID</div>");
                                    out.println("<div class='table_testMenu_title'>Question</div>");
                                    out.println("<div class='table_testMenu_title' style='width: 85px'>Correct Answer</div>");
                                    out.println("<div class='table_testMenu_title' style='width: 85px'>Answer 1</div>");
                                    out.println("<div class='table_testMenu_title' style='width: 85px'>Answer 2</div>");
                                    out.println("<div class='table_testMenu_title' style='width: 85px'>Answer 3</div>");
                                    out.println("<div class='table_testMenu_title' style='width: 85px'>Answer 4</div>");
                                    out.println("<div class='table_testMenu_title' style='width: 100px'>Actions</div>");
                                    out.println("</td></tr><tr><td>");
                                    PreparedStatement stmTest_gk = con.prepareStatement("Select * from general_test");
                                    ResultSet rsTest_gk = stmTest_gk.executeQuery();
                                    if (request.getParameter("testMenu").equals("gk")) {
                                        while (rsTest_gk.next()) {
                                            String id = rsTest_gk.getString("Question_id");
                                            out.println("<div class='table_testMenu_tr'>");
                                            out.println("<div class='table_testMenu_cell' style='width: 20px;'>" + id + "</div>");
                                            out.println("<div class='table_testMenu_cell'>" + rsTest_gk.getString("Question") + "</div>");
                                            out.println("<div class='table_testMenu_cell' style='width: 85px'>" + rsTest_gk.getString("CorrectA") + "</div>");
                                            out.println("<div class='table_testMenu_cell' style='width: 85px'>" + rsTest_gk.getString("Answer_1") + "</div>");
                                            out.println("<div class='table_testMenu_cell' style='width: 85px'>" + rsTest_gk.getString("Answer_2") + "</div>");
                                            out.println("<div class='table_testMenu_cell' style='width: 85px'>" + rsTest_gk.getString("Answer_3") + "</div>");
                                            out.println("<div class='table_testMenu_cell' style='width: 85px'>" + rsTest_gk.getString("Answer_4") + "</div>");
                                            out.println("<div class='table_testMenu_cell' style='width: 100px'>"
                                                    + "<button type='button' onclick='questionDelete(1, " + id + ")'>Delete</button>&nbsp;&nbsp;&nbsp;&nbsp;"
                                                    + "<button type='button' onclick='testMenu_editButton(1, " + id + ")'>Edit</button></div>");
                                            out.println("</div>");
                                        }
                                    }
                                    PreparedStatement stmTest_math = con.prepareStatement("Select * from math_test");
                                    ResultSet rsTest_math = stmTest_math.executeQuery();
                                    if (request.getParameter("testMenu").equals("math")) {
                                        while (rsTest_math.next()) {
                                            String id = rsTest_math.getString("Question_id");
                                            String url = "manager.jsp?testMenu=ct&editQuestion=true&questionId=" + id;
                                            out.println("<div class='table_testMenu_tr'>");
                                            out.println("<div class='table_testMenu_cell' style='width: 20px;'>" + id + "</div>");
                                            out.println("<div class='table_testMenu_cell'>" + rsTest_math.getString("Question") + "</div>");
                                            out.println("<div class='table_testMenu_cell' style='width: 85px'>" + rsTest_math.getString("CorrectA") + "</div>");
                                            out.println("<div class='table_testMenu_cell' style='width: 85px'>" + rsTest_math.getString("Answer_1") + "</div>");
                                            out.println("<div class='table_testMenu_cell' style='width: 85px'>" + rsTest_math.getString("Answer_2") + "</div>");
                                            out.println("<div class='table_testMenu_cell' style='width: 85px'>" + rsTest_math.getString("Answer_3") + "</div>");
                                            out.println("<div class='table_testMenu_cell' style='width: 85px'>" + rsTest_math.getString("Answer_4") + "</div>");
                                            out.println("<div class='table_testMenu_cell' style='width: 100px'>"
                                                    + "<button type='button' onclick='questionDelete(2, " + id + ")'>Delete</button>&nbsp;&nbsp;&nbsp;&nbsp;"
                                                    + "<button type='button' onclick='testMenu_editButton(2, " + id + ")'>Edit</button></div>");
                                            out.println("</div>");
                                        }
                                    }
                                    PreparedStatement stmTest_ct = con.prepareStatement("Select * from it_test");
                                    ResultSet rsTest_ct = stmTest_ct.executeQuery();
                                    if (request.getParameter("testMenu").equals("ct")) {
                                        while (rsTest_ct.next()) {
                                            String id = rsTest_ct.getString("Question_id");
                                            String url = "manager.jsp?testMenu=ct&editQuestion=true&questionId=" + id;
                                            out.println("<div class='table_testMenu_tr'>");
                                            out.println("<div class='table_testMenu_cell' style='width: 20px;'>" + id + "</div>");
                                            out.println("<div class='table_testMenu_cell'>" + rsTest_ct.getString("Question") + "</div>");
                                            out.println("<div class='table_testMenu_cell' style='width: 85px'>" + rsTest_ct.getString("CorrectA") + "</div>");
                                            out.println("<div class='table_testMenu_cell' style='width: 85px'>" + rsTest_ct.getString("Answer_1") + "</div>");
                                            out.println("<div class='table_testMenu_cell' style='width: 85px'>" + rsTest_ct.getString("Answer_2") + "</div>");
                                            out.println("<div class='table_testMenu_cell' style='width: 85px'>" + rsTest_ct.getString("Answer_3") + "</div>");
                                            out.println("<div class='table_testMenu_cell' style='width: 85px'>" + rsTest_ct.getString("Answer_4") + "</div>");
                                            out.println("<div class='table_testMenu_cell' style='width: 100px'>"
                                                    + "<button type='button' onclick='questionDelete(3, " + id + ")'>Delete</button>&nbsp;&nbsp;&nbsp;&nbsp;"
                                                    + "<button type='submit' onclick='testMenu_editButton(3, " + id + ")'>Edit</button></div>");
                                            out.println("</div>");
                                        }
                                    }
                                    out.println("</td></tr></table>");
                                    out.println("</div>");
                                    if (request.getParameter("testMenu") != null && request.getParameter("id") != null) {
                                        if (request.getParameter("editQuestion").equals("true")) {
                                            out.println("<div id='testMenu_editWindow'>");
                                            out.println("<table border='0' cellpadding='5' cellspacing='0'>");
                                            out.println("<form action='EditQuestion?type='" + request.getParameter("testMenu") + ">");
                                            out.println("<tr><td><span>Id: </span></td><td><input name='questionId' disabled='true' type='text' value=\"" + request.getParameter("id") + "\"/></td></tr>");
                                            out.println("<tr><td><span>Question: </span></td><td><input name='question' type='text' value=\"" + request.getParameter("question") + "\"/></td></tr>");
                                            out.println("<tr><td><span>Answer 1: </span></td><td><input name='answer1' type='text' value=\"" + request.getParameter("answer1") + "\"/></td></tr>");
                                            out.println("<tr><td><span>Answer 2: </span></td><td><input name='answer2' type='text' value=\"" + request.getParameter("answer2") + "\"/></td></tr>");
                                            out.println("<tr><td><span>Answer 3: </span></td><td><input name='answer3' type='text' value=\"" + request.getParameter("answer3") + "\"/></td></tr>");
                                            out.println("<tr><td><span>Answer 4: </span></td><td><input name='answer4' type='text' value=\"" + request.getParameter("answer4") + "\"/></td></tr>");
                                            out.println("<tr><td><span>Correct Answer: </span></td><td><select name='correctA'><option>Answer 1</option><option>Answer 2</option><option>Answer 3</option><option>Answer 4</option></select></td></tr>");
                                            out.println("<tr><td></td><td><button type='button' id='FingButton' onclick='testMenu_calcelButton()'>Cancel</button></td><td><button type='submit' style='float: left; margin-left: 10px;' id='FingButton'>Save</button></td></tr>");
                                            out.println("</form>");
                                            out.println("</table>");
                                            out.println("</div>");
                                            out.println("<script>testMenu_editWindow()</script>");
                                        }
                                    }
                                }
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
                                        out.println("<tr><th>Id</th><td><input disabled='true' type='text' name='id' value='" + request.getParameter("id") + "'/></td></tr>");
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
                                        out.println("<input type='button' value='Edit' id='FingButton' onclick='editF()'/>");
                                        out.println("<input type='button' value='Delete' id='FingButton' onclick='deleteF()'/>");
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
                                        out.println("<input type='submit' id='FingButton' value='Edit'/>");
                                        out.println("<input type='button' value='Cancel' id='FingButton' onclick='cancelF()'/>");
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
                                        out.println("<input type='submit' value='Delete' id='FingButton'/>");
                                        out.println("<input type='button' value='Cancel' id='FingButton' onclick='cancelF()'/>");
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
                            }
                        
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!--Footer Div-->\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
