package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"shortcut icon\" href=\"resource/icon.png\">\n");
      out.write("        <title>Webster Organization</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"CSS/global_style.css\" type=\"text/css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"CSS/footer.css\" type=\"text/css\"/>\n");
      out.write("        <script type=\"text/javascript\" src=\"JS/jquery-1.9.1.js\"></script>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            $(function() {\n");
      out.write("                $('.Slide img:gt(0)').hide();\n");
      out.write("\n");
      out.write("                setInterval(function() {\n");
      out.write("                    $('.Slide :first-child').fadeOut()\n");
      out.write("                            .next('img')\n");
      out.write("                            .fadeIn()\n");
      out.write("                            .end()\n");
      out.write("                            .appendTo('.Slide');\n");
      out.write("                }, 8000);\n");
      out.write("            });//]]>\n");
      out.write("            $(function() {\n");
      out.write("                $('.SlideIt div:gt(0)').hide();\n");
      out.write("\n");
      out.write("                setInterval(function() {\n");
      out.write("                    $('.SlideIt :').fadeOut()\n");
      out.write("                            .next('div')\n");
      out.write("                            .fadeIn()\n");
      out.write("                            .end()\n");
      out.write("                            .appendTo('.SlideIt');\n");
      out.write("                }, 4000);\n");
      out.write("            });//]]>\n");
      out.write("        </script>\n");
      out.write("        <style>\n");
      out.write("            iframe, object, embed {\n");
      out.write("                max-width: 100%;\n");
      out.write("                overflow: no-display;\n");
      out.write("                position: absolute;\n");
      out.write("                width: 100%;\n");
      out.write("                height: 760px;\n");
      out.write("                border: 0px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"background-color: #18DADA\">\n");
      out.write("        <!--Div to hold all content-->\n");
      out.write("        <div class=\"content_wrapper\">\n");
      out.write("\n");
      out.write("            <!--Header Div-->\n");
      out.write("            <div class=\"headerDiv\">\n");
      out.write("                <div class=\"logo-container\">\n");
      out.write("                    <a href=\"index.jsp\" title=\"Amusement Park\" class=\"logo\"><img src=\"resource/logo.png\" alt=\"Amusement Park\"/></a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"top_menu\">\n");
      out.write("                    <ul>\n");
      out.write("                        <a href=\"index.jsp\"><li style=\"background-color: #18DADA\"><img src=\"resource/home_icon2.png\" width=\"50\" height=\"50\"/><p>Home</p></li></a>\n");
      out.write("                                ");

                                    if (Boolean.valueOf(String.valueOf(session.getAttribute("mlogin")))) {
                                
      out.write("<a href='manager.jsp'><li style='background-color: #c05252'><img src='resource/clipboard-8-512.png' width='50' height='50'/><p>Management</p></li></a>\n");
      out.write("                                ");
} else {
      out.write("\n");
      out.write("                        <a href=\"test.jsp\"><li style=\"background-color: #40af64\"><img src=\"resource/test_icon.png\" width=\"50\" height=\"50\"/><p>Test</p></li></a>\n");
      out.write("                                ");
}
      out.write("\n");
      out.write("                        <a href=\"aboutus.jsp\"><li style=\"background-color: #ff9a1d\"><img src=\"resource/aboutus_icon.png\" width=\"50\" height=\"50\"/><p>About us</p></li></a>\n");
      out.write("                                ");

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
                                
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-------------------->\n");
      out.write("\n");
      out.write("            <!--Body Div-->\n");
      out.write("            <div style=\"width: 100%; height: 750px; float: left; background: white; padding: 0px;\">\n");
      out.write("                <iframe src=\"registerFrame.jsp\" scrolling=\"no\"/>\n");
      out.write("            </div>\n");
      out.write("            <!--Footer Div-->\n");
      out.write("            <div class=\"bigFooter\">\n");
      out.write("                <div class=\"column\">\n");
      out.write("                    <span class=\"contentTitle\">Locations<br/><br/></span>\n");
      out.write("                    <span class=\"contentData\">\n");
      out.write("                        8901 Marmora Road<br/>\n");
      out.write("                        Glasgow, DO4 89GR.<Br/>\n");
      out.write("                    </span>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"column\">\n");
      out.write("                    <span class=\"contentTitle\">Contact Us<br/><br/></span>\n");
      out.write("                    <span class=\"contentData\">\n");
      out.write("                        Freephone: +1 800 559 6580<Br/>\n");
      out.write("                        Telephone: +1 959 603 6035<br/>\n");
      out.write("                        FAX: +1 504 889 9898<br/><Br/>\n");
      out.write("                        Email: mail@demolink.com<br/>\n");
      out.write("                    </span>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"columnTable\">\n");
      out.write("                    <table cellspacing=\"5\" cellpadding=\"0\">\n");
      out.write("                        <tr>\n");
      out.write("                            <td><a href=\"\"><div class=\"facebook_link\" id=\"comm_links\">Facebook</div></a></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><a href=\"\"><div class=\"twitter_link\" id=\"comm_links\">Twitter</div></a></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><a href=\"\"><div class=\"myspace_link\" id=\"comm_links\">MySpace</div></a></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><a href=\"\"><div class=\"linkedin_link\" id=\"comm_links\">Linkedin</div></a></td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!------------------------>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <!----------------------->\n");
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
