package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class registerFrame_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <script>\n");
      out.write("            function JumpToIndex() {\n");
      out.write("                parent.location.href = 'RegisterServlet';\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        <style>\n");
      out.write("            * {\n");
      out.write("                margin: 0px;\n");
      out.write("                padding: 0px;\n");
      out.write("            }\n");
      out.write("            body, html {\n");
      out.write("                width: 100%;\n");
      out.write("                height: 100%;\n");
      out.write("            }\n");
      out.write("            .RegisterSection {\n");
      out.write("                position: relative;\n");
      out.write("                width: 100%;\n");
      out.write("                height: 100%;\n");
      out.write("                background: white;\n");
      out.write("            }\n");
      out.write("            .RegisterSection div {\n");
      out.write("                position: relative;\n");
      out.write("                margin: 5px;\n");
      out.write("                padding: 10px;\n");
      out.write("                border: 1px lightgray solid;\n");
      out.write("                border-radius: 2px;\n");
      out.write("            }\n");
      out.write("            .RegisterSection table {\n");
      out.write("                width: auto;\n");
      out.write("                height: auto;\n");
      out.write("                margin: 0 auto;\n");
      out.write("            }\n");
      out.write("            .RegisterSection table td {\n");
      out.write("                text-align: right;\n");
      out.write("                width: 150px;\n");
      out.write("                padding: 5px;\n");
      out.write("                margin-top: 10px;\n");
      out.write("                margin-bottom: 10px;\n");
      out.write("            }\n");
      out.write("            .RegisterSection table .Right {\n");
      out.write("                text-align: left;\n");
      out.write("                width: 65%;\n");
      out.write("            }\n");
      out.write("            .RegisterSection div p {\n");
      out.write("                font-family: Verdana;\n");
      out.write("                font-size: 18px;\n");
      out.write("                font-weight: bold;\n");
      out.write("                color: #545aff;\n");
      out.write("            }\n");
      out.write("            .RegisterSection div span {\n");
      out.write("                font-family: Times New Roman;\n");
      out.write("                font-size: 16px;\n");
      out.write("                font-weight: normal;\n");
      out.write("                color: #000000;\n");
      out.write("            }\n");
      out.write("            .RegisterSection div input[type=text] {\n");
      out.write("                width: 100%;\n");
      out.write("                height: 21px;\n");
      out.write("                padding-left: 5px;\n");
      out.write("                font-family: Times New Roman;\n");
      out.write("                font-size: 14px;\n");
      out.write("                font-weight: bold;\n");
      out.write("            }\n");
      out.write("            .RegisterSection div textarea {\n");
      out.write("                width: 100%;\n");
      out.write("                height: 50px;\n");
      out.write("                padding-left: 5px;\n");
      out.write("                font-family: Times New Roman;\n");
      out.write("                font-size: 14px;\n");
      out.write("                font-weight: bold;\n");
      out.write("            }\n");
      out.write("            .RegisterSection div select {\n");
      out.write("                height: 25px;\n");
      out.write("                font-family: Times New Roman;\n");
      out.write("                font-size: 16px;\n");
      out.write("                font-weight: normal;\n");
      out.write("            }\n");
      out.write("            .RegisterSection input[type=submit] {\n");
      out.write("                margin: 5px 0px 0px 10px;\n");
      out.write("                padding: 5px 10px 5px 10px;\n");
      out.write("                width: 120px;\n");
      out.write("                height: 30px;\n");
      out.write("                float: left;\n");
      out.write("                background: #3aa3b6;\n");
      out.write("                border: 1px #3aa3b6 solid;\n");
      out.write("                font-size: 16px;\n");
      out.write("                font-weight: bold;\n");
      out.write("                font-family: Times New Roman, sans-serif;\n");
      out.write("                color: white;\n");
      out.write("            }\n");
      out.write("            .RegisterSection input[type=submit]:hover {\n");
      out.write("                color: #2f545b;\n");
      out.write("                background-color: #cde6ea;\n");
      out.write("                cursor: pointer;\n");
      out.write("                border: 1px #c9c3c3 solid;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!--Body Div-->\n");
      out.write("        <div class=\"RegisterSection\">\n");
      out.write("            <form action=\"RegisterServlet\">\n");
      out.write("                <div class=\"Personal_info\">\n");
      out.write("                    <table border=\"0\" cellpadding=\"5\" cellspacing=\"0\">\n");
      out.write("                        <tr><td><p>Personal Info</p></td><td></td></tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><span>First Name: </span></td>\n");
      out.write("                            <td class=\"Right\"><input type=\"text\" name=\"firstname\" class=\"input\"/></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><span>Last Name: </span></td>\n");
      out.write("                            <td class=\"Right\"><input type=\"text\" name=\"lastname\" class=\"input\"/></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><span>Birth Date: </span></td>\n");
      out.write("                            <td class=\"Right\"><select name=\"year\" class=\"select\">\n");
      out.write("                                    ");
 for (int i = 1950; i <= 2014; i++) {
                                            out.println("<option value='" + i + "'>" + i + "</option>");
                                        }
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                                <select name=\"month\" class=\"select\">\n");
      out.write("                                    <option value=\"01\">1</option>\n");
      out.write("                                    <option value=\"02\">2</option>\n");
      out.write("                                    <option value=\"03\">3</option>\n");
      out.write("                                    <option value=\"04\">4</option>\n");
      out.write("                                    <option value=\"05\">5</option>\n");
      out.write("                                    <option value=\"06\">6</option>\n");
      out.write("                                    <option value=\"07\">7</option>\n");
      out.write("                                    <option value=\"08\">8</option>\n");
      out.write("                                    <option value=\"09\">9</option>\n");
      out.write("                                    <option value=\"10\">10</option>\n");
      out.write("                                    <option value=\"11\">11</option>\n");
      out.write("                                    <option value=\"12\">12</option>\n");
      out.write("                                </select>\n");
      out.write("                                <select name='day' class=\"select\">\n");
      out.write("                                    ");
 for (int i = 1; i <= 31; i++) {
                                            out.println("<option value='" + i + "'>" + i + "</option>");
                                        }
      out.write("\n");
      out.write("                                </select></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><span>Age: </span></td>\n");
      out.write("                            <td class=\"Right\"><input type=\"text\" name=\"age\" class=\"input\"/></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><span>Gender: </span></td>\n");
      out.write("                            <td class=\"Right\"><input type=\"radio\" name=\"gender\" value=\"male\" class=\"radio\">&nbsp;Male&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("                                <input type=\"radio\" name=\"gender\" value=\"female\" class=\"radio\">&nbsp;Female</td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"contact_info\">\n");
      out.write("                    <table border=\"0\" cellpadding=\"5\" cellspacing=\"0\">\n");
      out.write("                        <tr>\n");
      out.write("                            <td><p>Contact Info</p></td><td></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><span>Phone number: </span></td>\n");
      out.write("                            <td class=\"Right\"><input type=\"text\" name=\"phone\" class=\"input\"/></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><span>Email: </span></td>\n");
      out.write("                            <td class=\"Right\"><input type=\"text\" name=\"email\" class=\"input\"/></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><span>Address: </span></td>\n");
      out.write("                            <td class=\"Right\"><input type=\"text\" name=\"address\" class=\"input\"/></td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"other_info\">\n");
      out.write("                    <table border=\"0\" cellpadding=\"5\" cellspacing=\"0\">\n");
      out.write("                        <tr>\n");
      out.write("                            <td><p>Other Info</p></td>\n");
      out.write("                            <td></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><span>Status: </span></td>\n");
      out.write("                            <td class=\"Right\"><select name=\"status\"><option>Unemployed</option><option>Student</option><option>Part time job</option></select></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><span>Academic Degree: </span></td>\n");
      out.write("                            <td class=\"Right\"><select name=\"degree\"><option>none</option><option>Bachelor</option><option>Masters</option><option>Doctoral</option></select></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><span>Major: </span></td>\n");
      out.write("                            <td class=\"Right\"><select name=\"category\"><option>none</option><option>Engineering</option><option>Computer Technology</option><option>Mathematics</option><option>Physics</option></select></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><span>Years of experience: </span></td>\n");
      out.write("                            <td class=\"Right\"><input type=\"text\" name=\"yearW\" class=\"input\"/></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><span>Description: </span></td>\n");
      out.write("                            <td class=\"Right\"><textarea name=\"description\" class=\"input\"></textarea></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><input type=\"checkbox\" name=\"terms\" class=\"radio\"/>I agree</td>\n");
      out.write("                            <td class=\"Right\"><a href=\"#\" target=\"_blank\">Terms and Privacy Policy</a></td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("                <input type=\"submit\" value=\"Register\" onclick='JumpToIndex()' class=\"button\"/>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
