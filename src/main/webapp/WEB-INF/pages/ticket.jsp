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

    <link href="<c:url value="http://www.w3schools.com/lib/w3.css"/>" rel="stylesheet">
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
    <script>
        var slideIndex = 1;
        $(document).ready(function() {
            showDivs(slideIndex);
        } );

        function plusDivs(n) {
            showDivs(slideIndex += n);
        }

        function currentDiv(n) {
            showDivs(slideIndex = n);
        }

        function showDivs(n) {
            var i;
            var x = document.getElementsByClassName("mySlides");
            var dots = document.getElementsByClassName("demo");
            if (n > x.length) {slideIndex = 1}
            if (n < 1) {slideIndex = x.length}
            for (i = 0; i < x.length; i++) {
                x[i].style.display = "none";
            }
            for (i = 0; i < dots.length; i++) {
                dots[i].className = dots[i].className.replace(" w3-red", "");
            }
            x[slideIndex-1].style.display = "block";
            dots[slideIndex-1].className += " w3-red";
        }
    </script>

    <style>
        .mySlides {display:none}
        .photoHolder {

        }
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
        .cell {
            text-align: -webkit-center;
        }
    </style>

</head>
<body>
    <div class="container" style="padding: 10px;">
        <div class="row well">
            <table class="table table-bordered">
                <tbody>
                <tr>
                    <td class="col-md-4 cell"><c:out value="${chosenTicket.violation.type}"/></td>
                    <td class="col-md-4 cell"><c:out value="${chosenTicket.location}"/></td>
                    <td class="col-md-4 cell"><c:out value="${dateFormat.format(chosenTicket.date)}"/></td>
                </tr>
                <tr>
                    <td class="col-md-4 cell">
                        <div class="btn-group btn-flex" style="width: 100%;">
                            <select class="selectpicker violationPick" title="Выберите нарушение" data-style="btn-info">
                                <c:forEach var="violation" items="${rusViolations}">
                                    <option value=""><c:out value="${violation}"></c:out></option>
                                </c:forEach>
                            </select>
                        </div>
                    </td>
                    <td class="col-md-4 cell">
                        <div class="btn-group btn-flex" style="width: 100%;">
                            <select class="selectpicker actionPick" multiple title="Выберите действие" data-style="btn-info">
                                <c:forEach var="action" items="${rusActions}">
                                    <option value=""><c:out value="${action}"></c:out></option>
                                </c:forEach>
                            </select>
                        </div>
                    </td>
                    <td class="col-md-4 cell"><c:out value="${chosenTicket.address}"/></td>
                </tr>
                </tbody>
            </table>
        </div>
    <%--<table class="table table-bordered">--%>
        <%--<thead>--%>
        <%--<tr>--%>
            <%--<c:forEach var="photo" items="${chosenStrPhotos}">--%>
                <%--<th>Фото: </th>--%>
            <%--</c:forEach>--%>
            <%--<th class="">Вид нарушения</th>--%>
            <%--<th class="">Действия</th>--%>
            <%--<th class="">Комментарий</th>--%>
        <%--</tr>--%>
        <%--</thead>--%>
        <%--<tbody>--%>
        <%--<tr>--%>
            <%--<c:forEach var="photo" items="${chosenStrPhotos}">--%>
                <%--<td class="photoHolder col-sm-6">--%>
                    <%--<img src="${photo}" style="width: 100%;"/>--%>
                <%--</td>--%>
            <%--</c:forEach>--%>
            <%--<td class="" style="width: 375px;">--%>
                <%--<div class="btn-group btn-flex" style="width: 100%;">--%>
                    <%--<select class="selectpicker violationPick" title="Выберите нарушение" data-style="btn-info">--%>
                        <%--<c:forEach var="violation" items="${rusViolations}">--%>
                            <%--<option value=""><c:out value="${violation}"></c:out></option>--%>
                        <%--</c:forEach>--%>
                    <%--</select>--%>
                <%--</div>--%>
            <%--</td>--%>
            <%--<td style="width: 240px;">--%>
                <%--<div class="btn-group btn-flex" style="width: inherit;">--%>
                    <%--<select class="selectpicker actionPick" multiple title="Выберите действие" data-style="btn-info">--%>
                        <%--<c:forEach var="action" items="${rusActions}">--%>
                            <%--<option value=""><c:out value="${action}"></c:out></option>--%>
                        <%--</c:forEach>--%>
                    <%--</select>--%>
                <%--</div>--%>
            <%--</td>--%>
            <%--<td class="comment"><c:out value="${chosenTicket.comment}"/></td>--%>
        <%--</tr>--%>
        <%--</tbody>--%>
    <%--</table>--%>
        <div class="row well" id="gallery">
            <div class="">
                <div class="w3-content" style="max-width: 800px">
                    <c:forEach var="photo" items="${chosenStrPhotos}">
                        <img class="mySlides" src="${photo}" style="width: 100%;">
                    </c:forEach>
                    <%--<img class="mySlides" src="img_nature_wide.jpg" style="width:100%">--%>
                    <%--<img class="mySlides" src="img_fjords_wide.jpg" style="width:100%">--%>
                    <%--<img class="mySlides" src="img_mountains_wide.jpg" style="width:100%">--%>
                </div>
                <div class="w3-center">
                    <div class="w3-section">
                        <button class="w3-btn" onclick="plusDivs(-1)">❮ Назад</button>
                        <button class="w3-btn" onclick="plusDivs(1)">Далее ❯</button>
                    </div>
                    <c:forEach var="i" end="${chosenStrPhotos.size()}" step="1" begin="1">
                        <button class="w3-btn demo" onclick="currentDiv(i)">${i}</button>
                    </c:forEach>
                    <%--<button class="w3-btn demo" onclick="currentDiv(1)">1</button>--%>
                    <%--<button class="w3-btn demo" onclick="currentDiv(2)">2</button>--%>
                    <%--<button class="w3-btn demo" onclick="currentDiv(3)">3</button>--%>
                </div>
            </div>
        </div>
        <div class="row panel panel-default">
            <div class="panel-heading"><p>Комментарий:</p></div>
            <div class="panel-body">
                <p><c:out value="${chosenTicket.comment}"/></p>
            </div>
        </div>
        <div class="row well" id="controls">
            <div class="btn-group btn-flex">
                <button id type="button" class="btn btn-info btnProcess">Обработать заявку</button>
                <button id type="button" class="btn btn-danger btnDecline">Отклонить заявку</button>
            </div>
        </div>
    </div>
</body>
</html>
