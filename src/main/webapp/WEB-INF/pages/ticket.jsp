<%--
  Created by IntelliJ IDEA.
  User: Pavel
  Date: 09.12.2016
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/custom.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap-select.css" />" rel="stylesheet">

    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="<c:url value="/resources/js/bootstrap.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap-select.js" />"></script>
    <script>
        $('.selectpicker').selectpicker({
        });
    </script>

    <style>
        #user {
            border: 4px;
            border-radius: 3px;
            border: #d58512;
            margin-left: 850px;
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

        .table-responsive {
            overflow-x: visible !important;
            overflow-y: visible !important;
        }
    </style>

</head>
<body>
    <div class="container" style="padding: 10px;">
    <table class="table table-bordered">
        <thead>
        <tr>
            <c:forEach var="photo" items="${chosenStrPhotos}">
                <th>Фото: </th>
            </c:forEach>
            <th class="">Вид нарушения</th>
            <th class="">Действия</th>
            <th class="">Комментарий</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <c:forEach var="photo" items="${chosenStrPhotos}">
                <td class="photoHolder">
                    <img src="${photo}" alt="img">
                </td>
            </c:forEach>
            <td class="" style="width: 375px;">
                <div class="btn-group btn-flex" style="width: 100%;">
                    <select class="selectpicker violationPick" title="Выберите нарушение" data-style="btn-info">
                        <c:forEach var="violation" items="${rusViolations}">
                            <option value=""><c:out value="${violation}"></c:out></option>
                        </c:forEach>
                    </select>
                </div>
            </td>
            <td style="width: 240px;">
                <div class="btn-group btn-flex" style="width: inherit;">
                    <select class="selectpicker actionPick" multiple title="Выберите действие" data-style="btn-info">
                        <c:forEach var="action" items="${rusActions}">
                            <option value=""><c:out value="${action}"></c:out></option>
                        </c:forEach>
                    </select>
                </div>
            </td>
            <td class=""></td>
        </tr>
        </tbody>
    </table>
    <div id="controls">
        <div class="btn-group btn-flex">
            <button id type="button" class="btn btn-info btnProcess">Обработать заявку</button>
            <button id type="button" class="btn btn-danger btnDecline">Отклонить заявку</button>
        </div>
    </div>
</div>
</body>
</html>
