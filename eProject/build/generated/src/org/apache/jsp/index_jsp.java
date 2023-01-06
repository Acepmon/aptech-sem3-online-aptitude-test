package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-------------------->\n");
      out.write("\n");
      out.write("            <!--Body Div-->\n");
      out.write("            <div class=\"BodySection\">\n");
      out.write("                <div class=\"ImgSection\">\n");
      out.write("                    <div class=\"Slide\">\n");
      out.write("                        <img src=\"resource/slide-1.jpg\" style=\"display: block;\">\n");
      out.write("                        <img src=\"resource/slide-2.jpg\" style=\"display: none;\">\n");
      out.write("                        <img src=\"resource/slide-3.jpg\" style=\"display: none;\">\n");
      out.write("                        <img src=\"resource/slide-4.jpg\" style=\"display: none;\">\n");
      out.write("                        <img src=\"resource/slide-5.jpg\" style=\"display: none;\">\n");
      out.write("                        <img src=\"resource/slide-6.jpg\" style=\"display: none;\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"blank_space_padding\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"SlideIt\">\n");
      out.write("                        <div class=\"ImgLinkSection\" style=\"display: block;\">\n");
      out.write("                            <span class=\"desc_title\" id=\"Spanners\">About Webster</span><br/>\n");
      out.write("                            <span class=\"desc\" id=\"Spanners\">\n");
      out.write("                                The Webster organisation is the leading organization in the world of Oil-Gas Company.  \n");
      out.write("                                We have various branches throughout the world.  \n");
      out.write("                                It has various bonds with different multi-national company.</span><br/><br/>\n");
      out.write("                            <span id=\"Spanners\"><a href=\"aboutus.jsp\" class=\"desc_link\">LEARN MORE</a></span>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    ");
/*
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
                    
      out.write("\n");
      out.write("                    <iframe src=\"login.jsp\" class=\"LoginFrame\" draggable=\"true\"></iframe>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!------------------->\n");
      out.write("\n");
      out.write("            <div class=\"NewsSection\">\n");
      out.write("                <div class=\"HeadShape\"><img src=\"resource/news_icon.png\" alt=\"News\" title=\"News\"/><a>News</a></div>\n");
      out.write("                <div class=\"NewsHolder\">\n");
      out.write("                    ");

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
                    
      out.write("\n");
      out.write("                    <div class=\"News\">\n");
      out.write("                        <div class=\"NewsTitle\">");
      out.print(title);
      out.write("</div>\n");
      out.write("                        <div class=\"NewsImage\"><img src=\"");
      out.print(purl);
      out.write("\"/></div>\n");
      out.write("                        <div class=\"NewsDesc\" style=\"height: 80px;\">");
      out.print(desc);
      out.write("</div>\n");
      out.write("                    </div>\n");
      out.write("                    ");

                            number[random] = true;
                        }
                    
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div><br/>\n");
      out.write("\n");
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
      out.write("                        Email: webster.company@yahoo.com<br/>\n");
      out.write("                    </span>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"columnTable\">\n");
      out.write("                    <table cellspacing=\"5\" cellpadding=\"0\">\n");
      out.write("                        <tr>\n");
      out.write("                            <td><a href=\"http:\\\\www.facebook.com\" target=\"_blank\"><div class=\"facebook_link\" id=\"comm_links\">Facebook</div></a></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><a href=\"http:\\\\www.twitter.com\" target=\"_blank\"><div class=\"twitter_link\" id=\"comm_links\">Twitter</div></a></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><a href=\"http:\\\\www.myspace.com\" target=\"_blank\"><div class=\"myspace_link\" id=\"comm_links\">MySpace</div></a></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><a href=\"http:\\\\www.linkedi.com\" target=\"_blank\"><div class=\"linkedin_link\" id=\"comm_links\">Linkedin</div></a></td>\n");
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
