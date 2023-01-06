<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function JumpToIndex() {
                parent.location.href = 'RegisterServlet';
            }
        </script>
        <style>
            * {
                margin: 0px;
                padding: 0px;
            }
            body, html {
                width: 100%;
                height: 100%;
            }
            .RegisterSection {
                position: relative;
                width: 100%;
                height: 100%;
                background: white;
            }
            .RegisterSection div {
                position: relative;
                margin: 5px;
                padding: 10px;
                border: 1px lightgray solid;
                border-radius: 2px;
            }
            .RegisterSection table {
                width: auto;
                height: auto;
                margin: 0 auto;
            }
            .RegisterSection table td {
                text-align: right;
                width: 150px;
                padding: 5px;
                margin-top: 10px;
                margin-bottom: 10px;
            }
            .RegisterSection table .Right {
                text-align: left;
                width: 65%;
            }
            .RegisterSection div p {
                font-family: Verdana;
                font-size: 18px;
                font-weight: bold;
                color: #545aff;
            }
            .RegisterSection div span {
                font-family: Times New Roman;
                font-size: 16px;
                font-weight: normal;
                color: #000000;
            }
            .RegisterSection div input[type=text] {
                width: 100%;
                height: 21px;
                padding-left: 5px;
                font-family: Times New Roman;
                font-size: 14px;
                font-weight: bold;
            }
            .RegisterSection div textarea {
                width: 100%;
                height: 50px;
                padding-left: 5px;
                font-family: Times New Roman;
                font-size: 14px;
                font-weight: bold;
            }
            .RegisterSection div select {
                height: 25px;
                font-family: Times New Roman;
                font-size: 16px;
                font-weight: normal;
            }
            .RegisterSection input[type=submit] {
                margin: 5px 0px 0px 10px;
                padding: 5px 10px 5px 10px;
                width: 120px;
                height: 30px;
                float: left;
                background: #3aa3b6;
                border: 1px #3aa3b6 solid;
                font-size: 16px;
                font-weight: bold;
                font-family: Times New Roman, sans-serif;
                color: white;
            }
            .RegisterSection input[type=submit]:hover {
                color: #2f545b;
                background-color: #cde6ea;
                cursor: pointer;
                border: 1px #c9c3c3 solid;
            }
        </style>
    </head>
    <body>
        <!--Body Div-->
        <div class="RegisterSection">
            <form action="RegisterServlet">
                <div class="Personal_info">
                    <table border="0" cellpadding="5" cellspacing="0">
                        <tr><td><p>Personal Info</p></td><td></td></tr>
                        <tr>
                            <td><span>First Name: </span></td>
                            <td class="Right"><input type="text" name="firstname" class="input"/></td>
                        </tr>
                        <tr>
                            <td><span>Last Name: </span></td>
                            <td class="Right"><input type="text" name="lastname" class="input"/></td>
                        </tr>
                        <tr>
                            <td><span>Birth Date: </span></td>
                            <td class="Right"><select name="year" class="select">
                                    <% for (int i = 1950; i <= 2014; i++) {
                                            out.println("<option value='" + i + "'>" + i + "</option>");
                                        }%>
                                </select>
                                <select name="month" class="select">
                                    <option value="01">1</option>
                                    <option value="02">2</option>
                                    <option value="03">3</option>
                                    <option value="04">4</option>
                                    <option value="05">5</option>
                                    <option value="06">6</option>
                                    <option value="07">7</option>
                                    <option value="08">8</option>
                                    <option value="09">9</option>
                                    <option value="10">10</option>
                                    <option value="11">11</option>
                                    <option value="12">12</option>
                                </select>
                                <select name='day' class="select">
                                    <% for (int i = 1; i <= 31; i++) {
                                            out.println("<option value='" + i + "'>" + i + "</option>");
                                        }%>
                                </select></td>
                        </tr>
                        <tr>
                            <td><span>Age: </span></td>
                            <td class="Right"><input type="text" name="age" class="input"/></td>
                        </tr>
                        <tr>
                            <td><span>Gender: </span></td>
                            <td class="Right"><input type="radio" name="gender" value="male" class="radio">&nbsp;Male&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="radio" name="gender" value="female" class="radio">&nbsp;Female</td>
                        </tr>
                    </table>
                </div>

                <div class="contact_info">
                    <table border="0" cellpadding="5" cellspacing="0">
                        <tr>
                            <td><p>Contact Info</p></td><td></td>
                        </tr>
                        <tr>
                            <td><span>Phone number: </span></td>
                            <td class="Right"><input type="text" name="phone" class="input"/></td>
                        </tr>
                        <tr>
                            <td><span>Email: </span></td>
                            <td class="Right"><input type="text" name="email" class="input"/></td>
                        </tr>
                        <tr>
                            <td><span>Address: </span></td>
                            <td class="Right"><input type="text" name="address" class="input"/></td>
                        </tr>
                    </table>
                </div>

                <div class="other_info">
                    <table border="0" cellpadding="5" cellspacing="0">
                        <tr>
                            <td><p>Other Info</p></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><span>Status: </span></td>
                            <td class="Right"><select name="status"><option>Unemployed</option><option>Student</option><option>Part time job</option></select></td>
                        </tr>
                        <tr>
                            <td><span>Academic Degree: </span></td>
                            <td class="Right"><select name="degree"><option>none</option><option>Bachelor</option><option>Masters</option><option>Doctoral</option></select></td>
                        </tr>
                        <tr>
                            <td><span>Major: </span></td>
                            <td class="Right"><select name="category"><option>none</option><option>Engineering</option><option>Computer Technology</option><option>Mathematics</option><option>Physics</option></select></td>
                        </tr>
                        <tr>
                            <td><span>Years of experience: </span></td>
                            <td class="Right"><input type="text" name="yearW" class="input"/></td>
                        </tr>
                        <tr>
                            <td><span>Description: </span></td>
                            <td class="Right"><textarea name="description" class="input"></textarea></td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" name="terms" class="radio"/>I agree</td>
                            <td class="Right"><a href="#" target="_blank">Terms and Privacy Policy</a></td>
                        </tr>
                    </table>
                </div>
                <input type="submit" value="Register" onclick='JumpToIndex()' class="button"/>
            </form>
        </div>
    </body>
</html>
