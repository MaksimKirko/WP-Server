<%--
  Created by IntelliJ IDEA.
  User: Pavel
  Date: 13.11.2016
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Login Page</title>
    <style>
        .error {
            padding: 15px;
            margin-bottom: 20px;
            border: 1px solid transparent;
            border-radius: 4px;
            color: #a94442;
            background-color: #f2dede;
            border-color: #ebccd1;
        }

        .msg {
            padding: 15px;
            margin-bottom: 20px;
            border: 1px solid transparent;
            border-radius: 4px;
            color: #31708f;
            background-color: #d9edf7;
            border-color: #bce8f1;
        }

        #login-box {
            width: 300px;
            padding: 20px;
            margin: 100px auto;
            background: #fff;
            -webkit-border-radius: 2px;
            -moz-border-radius: 2px;
            border: 1px solid #000;
        }
    </style>
</head>
<body onload='document.loginForm.username.focus();'>

<h1>Пожалуйста, авторизуйтесь для продолжения работы с приложением:</h1>

<h3>Enter your username and password</h3>
<form method="post" action="j_spring_security_check">
    UserName :<input name="j_username" type="text" /> <br />
    Password :<input name="j_password" type="password" /> <br />
    <input value="Login" type="submit" />
</form>

<br />
<c:if test="${param.status=='error'}">
    <label style="color:red">Invalid username or password!!</label>
</c:if>
<c:if test="${param.status=='logout'}">
    <label style="color:green">Logged out successfully!</label>
</c:if>

<%--<div id="login-box">--%>

    <%--<h2>Введите имя пользователя и пароль от аккаунта:</h2>--%>

    <%--<c:if test="${not empty error}">--%>
        <%--<div class="error">${error}</div>--%>
    <%--</c:if>--%>
    <%--<c:if test="${not empty msg}">--%>
        <%--<div class="msg">${msg}</div>--%>
    <%--</c:if>--%>

    <%--<form name='loginForm'--%>
          <%--action="<c:url value='j_spring_security_check' />" method='POST'>--%>

        <%--<table>--%>
            <%--<tr>--%>
                <%--<td>Имя:</td>--%>
                <%--<td><input type='text' name='username' value=''></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td>Пароль:</td>--%>
                <%--<td><input type='password' name='password' /></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td></td>--%>
                <%--<td colspan='2'><input name="submit" type="submit"--%>
                                       <%--value="Отправить" /></td>--%>
            <%--</tr>--%>
        <%--</table>--%>

        <%--<input type="hidden" name="${_csrf.parameterName}"--%>
               <%--value="${_csrf.token}" />--%>

    <%--</form>--%>
<%--</div>--%>

</body>
</html>
