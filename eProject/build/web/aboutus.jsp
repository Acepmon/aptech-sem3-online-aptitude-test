<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="resource/icon.png">
        <title>Webster Organization</title>
        <link rel="stylesheet" href="CSS/global_aboutus.css" type="text/css"/>
        <link rel="stylesheet" href="CSS/footer.css" type="text/css"/>
    </head>
    <body style="background-color: #ff9a1d">
        <!--Div to hold all content-->
        <div class="content_wrapper">

            <!--Header Div-->
            <div class="headerDiv">
                <div class="logo-container">
                    <a href="index.jsp" class="logo"><img src="resource/logo.png" alt="Amusement Park"/></a>
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
            <!--Oh, Look! There is An Awesome About us section!------------------>
            <div class="aboutUsSection">
                <div class="aboutUsTitle">About Us</div>
                <div class="wlo">We Love Ourselves
                    <img src="resource/memberAll.jpg" width="450px"/>
                    <div class="wloDesc">You know I learned something today. It is not important who you are. You can be brony, horse head masked man or pegasus riding knight elf. But, most important thing is we all hate gas and oil. So we must unstock gas & oil of earth.</div>
                </div>
                <div class="aboutUsBody">
                    The Company was incorporated in the Republic of Ireland as a public company limited by shares under the name U.S. Oil and Gas plc on 15 June 2009 under the Companies Acts. The Company has the registration number 471932 and is the holding company of the U.S. Oil Group.
                    <br/>
                    <br/>
                    Webster
                    The Company has the following subsidiary undertaking:
                    Major Oil International LLC (registered in Houston, Texas, USA) with company number 801005644), incorporated on 17 July 2008. The registered office of Major Oil International LLC is at 1208 WestDrew, Houston, Texas 77006.  There are 100 shares issued in Major Oil International LLC, all of which are owned by the Company.
                    <br/>
                    <br/>
                    Activities
                    The company's primary focus is on onshore oil and gas exploration in Nevada, USA, where U.S. Oil has a large lease acreage. 
                    <br/><br/><br/>
                    <h1> &nbsp; &nbsp;Our Company Founders: </h1>
                </div>
            </div>
            <div class="FoundersList">
                <div class="FounderClass">
                    <img src="resource/member_1.jpg" width="300px" height="400px"/>
                    <div class="FounderInformation">
                        <h2>&nbsp;Steven Stevenson</h2>
                        <div class="desc">&nbsp; &nbsp; Steven was first found this company with his brother Stefan. Then he welcomed his friend Nerdy April to join their company.</div>
                    </div>
                </div>
                <div class="FounderClass">
                    <img src="resource/member_2.jpg" width="300px" height="400px"/>
                    <div class="FounderInformation">
                        <h2>&nbsp;Mr.Blackwell</h2>
                        <div class="desc">&nbsp; &nbsp; Mr.Blackwell is really rich man. He produced Steven & Stefan's Gas & Oil.</div>                
                    </div>
                </div>
                <div class="FounderClass">
                    <img src="resource/member_3.jpg" width="300px" height="400px"/>
                    <div class="FounderInformation">
                        <h2>&nbsp;Butch April</h2>
                        <div class="desc">&nbsp; &nbsp; He is Steven's best friend. His partners think he is really silly. Because, he named the company 'Webster'.</div>
                    </div>
                </div>
                <div class="FounderClass">
                    <img src="resource/member_4.jpg" width="300px" height="400px"/>
                    <div class="FounderInformation">
                        <h2>&nbsp;Stefan Stevenson</h2>
                        <div class="desc">&nbsp; &nbsp; Steven & Stefan were first found this company. He is really selfie //Look at his picture.</div>
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