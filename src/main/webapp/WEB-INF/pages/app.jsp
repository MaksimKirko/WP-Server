<%@ page import="com.github.maximkirko.wpserver.datamodel.Ticket" %>
<%@ page import="java.util.*" %>
<%@ page import="com.github.maximkirko.wpserver.datamodel.User" %>
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
    <link href="<c:url value="/resources/css/bootstrap-select.css" />" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs-3.3.6/jq-2.2.3/dt-1.10.12/b-1.2.2/datatables.min.css"/>

    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/v/bs-3.3.6/jq-2.2.3/dt-1.10.12/b-1.2.2/datatables.min.js"></script>
    <script src="<c:url value="/resources/js/bootstrap.js" />"></script>
    <%--<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>--%>
    <script src="<c:url value="/resources/js/bootstrap-select.js" />"></script>
    <script>
        $('.selectpicker').selectpicker({
        });
    </script>
    <script>
        $(document).ready(function() {
            $('#iTickets').DataTable();
            $('#hTickets').DataTable();
            $('#aTickets').DataTable();
        } );
    </script>

    <title>Application</title>

    <style>
        #user {
            background-color: lavender;
            width: 230px;
            border: 4px;
            border-radius: 10px;
            border: #d58512;
            margin-right: 10px;
            margin-left: auto;
        }
        #controls {
            align-content: left;
        }
        .filter-option {
            color: white;
        }
        .violationPick {
            width: 350px;
            /*color: white;*/
        }
        select[title]{
            /*color: white;*/
        }
        body{
            padding:50px;
        }
        .btn-group {
            white-space: nowrap;
            width: 250px;
        }

        .btn-flex {
            display: flex;
            align-items: stretch;
            align-content: stretch;
        }

        .btn-flex .btn:first-child {
            flex-grow: 1;
            text-align: left;
        }

        .btn-group .btn {
            float: none;
            display: inline-block;
        }
        .btn + .dropdown-toggle {
            margin-left: -4px;
        }

        .bootstrap-select:not([class*="col-"]):not([class*="form-control"]):not(.input-group-btn) {
            width: 100%;
        }

        .tab-content {
            background-color: white;
            border-top: transparent;
        }

        .table-responsive {
            overflow-x: visible !important;
            overflow-y: visible !important;
        }
    </style>
</head>
<body style="padding: 20px;" class="well">
    <div class="container" style="width: 100%; padding: 0px; margin: 0px;">
            <c:url value="/logout" var="logoutUrl" />

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

            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <div id="user" class="well">
                    Здравствуйте, ${pageContext.request.userPrincipal.name} | <a
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
        <div class="tab-content table-responsive well">
            <div class="tab-pane active" id="inputTickets">
                <table id="iTickets" class="table table-striped table-bordered table-hover" style="">
                    <thead>
                    <tr>
                        <th class="id">ID</th>
                        <th class="">Вид нарушения</th>
                        <th class="">Номерной знак</th>
                        <th class="">Адрес места нарушения</th>
                        <th class="">Дата</th>
                        <th class="">Заявка...</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${inputTickets}" var="item">
                        <tr>
                            <td class="id"><c:out value="${item.id}"/></td>
                            <td class="violation"><c:out value="${item.violation.type}"/></td>
                            <td class="lPlate"><c:out value="${item.licensePlate}"/></td>
                            <td class="address"><c:out value="${item.address}"/></td>
                            <td class="date"><c:out value="${dateFormat.format(item.date)}"/></td>
                            <td class="">
                                <a href="<c:url value="/ticket/${item.id}"/>" type="button" class="btn btn-info">Просмотреть заявку</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="tab-pane" id="handledTickets">
                <table id="hTickets" class="table table-striped table-bordered table-hover" style="">
                    <thead>
                    <tr>
                        <th class="id">ID</th>
                        <th class="">Вид нарушения</th>
                        <th class="">Номерной знак</th>
                        <th class="">Адрес места нарушения</th>
                        <th class="">Дата</th>
                        <th class="">Заявка...</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${processedTickets}" var="item">
                        <tr>
                            <td class="id"><c:out value="${item.id}"/></td>
                            <td class="violation"><c:out value="${item.violation.type}"/></td>
                            <td class="lPlate"><c:out value="${item.licensePlate}"/></td>
                            <td class="address"><c:out value="${item.address}"/></td>
                            <td class="date"><c:out value="${item.date}"/></td>
                            <td class="">
                                <a href="<c:url value="/ticket/${item.id}"/>" type="button" class="btn btn-info">Просмотреть заявку</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="tab-pane" id="archivedTickets">
                <table id="aTickets" class="table table-striped table-bordered table-hover" style="">
                    <thead>
                    <tr>
                        <th class="id">ID</th>
                        <th class="">Вид нарушения</th>
                        <th class="">Номерной знак</th>
                        <th class="">Адрес места нарушения</th>
                        <th class="">Дата</th>
                        <th class="">Заявка...</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${archivedTickets}" var="item">
                        <tr>
                            <td class="id"><c:out value="${item.id}"/></td>
                            <td class="violation"><c:out value="${item.violation.type}"/></td>
                            <td class="lPlate"><c:out value="${item.licensePlate}"/></td>
                            <td class="address"><c:out value="${item.address}"/></td>
                            <td class="date"><c:out value="${item.date}"/></td>
                            <td class="">
                                <a href="<c:url value="/ticket/${item.id}"/>" type="button" class="btn btn-info">Просмотреть заявку</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
