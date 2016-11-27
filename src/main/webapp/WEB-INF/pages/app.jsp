<%@ page import="com.github.maximkirko.wpserver.datamodel.Ticket" %>
<%@ page import="java.util.*" %>
<%--
  Created by IntelliJ IDEA.
  User: Pavel
  Date: 16.10.2016
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ taglib uri="http://code.jquery.com/jquery-1.8.3.js" prefix="jq" %>--%>

<%--<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>--%>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/custom.css" />" rel="stylesheet">

    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="<c:url value="/resources/js/bootstrap.js" />"></script>

    <title>Application</title>

    <style>
        .h2 {margin-left: 700px}
    </style>
</head>
<body>
    <div class="container">
        <%--<div class="btn-toolbar" id="topTools">--%>
            <%--<div class="btn-group">--%>
                <%--<button class="btn btn-default">x</button>--%>
                <%--<button class="btn btn-default">y</button>--%>
                <%--<button class="btn btn-default">x</button>--%>
            <%--</div>--%>
        <%--</div>--%>
            <c:url value="/j_spring_security_logout" var="logoutUrl" />

            <!-- csrf for log out-->
            <form action="${logoutUrl}" method="post" id="logoutForm">
                <input type="hidden"
                       name="${_csrf.parameterName}"
                       value="${_csrf.token}" />
            </form>

            <script>
                function formSubmit() {
                    document.getElementById("logoutForm").submit();
                }
            </script>

            <%--Creation of the "tickets" collection--%>
            <jsp:useBean id="ticket" class="com.github.maximkirko.wpserver.datamodel.Ticket" scope="page"/>
            <%
                List<Ticket> tickets = new ArrayList<Ticket>();

                ticket.setId((long)1);
                ticket.setLicensePlate("1234 AB-1");
                ticket.setComment("абвгд");
                tickets.add(ticket);
                ticket = new Ticket();

                ticket.setId((long)2);
                ticket.setLicensePlate("9876 AB-2");
                ticket.setComment("jhgf");
                tickets.add(ticket);

                request.setAttribute("tickets", tickets);
            %>


            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <div class="h2">
                    Здравствуйте : ${pageContext.request.userPrincipal.name} | <a
                        href="javascript:formSubmit()">Выйти</a>
                </div>
            </c:if>
        <ul class="nav nav-tabs" id="myTab" >
            <li class="active">
                <a href="#inputTickets" data-toggle="tab" >Входящие заявки</a>
            </li>
            <li>
                <a href="#handledTickets" data-toggle="tab" >Обработанные заявки</a>
            </li>
            <li>
                <a href="#archivedTickets" data-toggle="tab" >Архив заявок</a>
            </li>
        </ul>
        <div class="tab-content">
            <div class="tab-pane active" id="inputTickets">
                <table class="table table-striped table-bordered table-hover" style="">
                    <thead>
                    <tr>
                        <th class="">Заявка1</th>
                        <th class="">Фотографии</th>
                        <th class="">Вид нарушения</th>
                        <th class="">Номерной знак</th>
                        <th class="">Адрес места нарушения</th>
                        <th class="">Дата</th>
                        <th class="">Комментарий</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${tickets}" var="item">
                        <tr>
                            <td class="id"><c:out value="${item.id}"/></td>
                            <td class="photos">...</td>
                            <td class="violation">...</td>
                            <td class="lPlate"><c:out value="${item.licensePlate}"/></td>
                            <td class="address">...</td>
                            <td class="date">...</td>
                            <td class="comment"><c:out value="${item.comment}"/></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="tab-pane" id="handledTickets">
                <table class="table table-striped table-bordered table-hover">
                    <thead>
                    <tr>
                        <th class="">Заявка2</th>
                        <th class="">Фотографии</th>
                        <th class="">Вид нарушения</th>
                        <th class="">Номерной знак</th>
                        <th class="">Адрес места нарушения</th>
                        <th class="">Дата</th>
                        <th class="">Комментарий</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td class="">..</td>
                        <td class="">..</td>
                        <td class="">..</td>
                        <td class="">..</td>
                        <td class="">..</td>
                        <td class="">..</td>
                        <td class="">..</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="tab-pane" id="archivedTickets">
                <table class="table table-striped table-bordered table-hover">
                    <thead>
                    <tr>
                        <th class="">Заявка3</th>
                        <th class="">Фотографии</th>
                        <th class="">Вид нарушения</th>
                        <th class="">Номерной знак</th>
                        <th class="">Адрес места нарушения</th>
                        <th class="">Дата</th>
                        <th class="">Комментарий</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td class="">..</td>
                        <td class="">..</td>
                        <td class="">..</td>
                        <td class="">..</td>
                        <td class="">..</td>
                        <td class="">..</td>
                        <td class="">..</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
