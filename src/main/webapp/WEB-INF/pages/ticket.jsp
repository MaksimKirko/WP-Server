<%@ page import="com.github.maximkirko.wpserver.datamodel.Ticket" %><%--
  Created by IntelliJ IDEA.
  User: Pavel
  Date: 09.12.2016
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
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
    <script>
        $(document).ready(function () {
            $("#btnUpdate").click(function () {
                var curViol = $("#violPick").val();
                var curId = ${chosenTicket.id};
                var curActions = "";

                var dropDownElem = document.getElementById("aPick");
                var selectedValues = new Array();
                var dropDownLength = dropDownElem.length;

                for ( var i=0; i < dropDownLength; i++ )
                {
                    if ( dropDownElem.options[i].selected )
                    {
//                        selectedValues.push( dropDownElem.options[i].value );
                        document.getElementById("action" + i).value = dropDownElem.options[i];
                    }
                }

//                alert ( selectedValues.toString() );

                document.getElementById("idPlace").value = curId;
                document.getElementById("violPlace").value = curViol;
                document.getElementById("updateForm").submit();
                alert(document.getElementById("idPlace").value);
            });
        });

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
            text-align: -webkit-center;
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
            width: 290px;
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
            <table class="table table-bordered" style="background-color: white">
                <tbody>
                <tr>
                    <td class="col-md-3 cell"><c:out value="Заявка №${chosenTicket.id}"/></td>
                    <td class="col-md-3 cell"><c:out value="${chosenTicket.violation.type}"/></td>
                    <td class="col-md-3 cell"><c:out value="${chosenTicket.location}"/></td>
                    <td class="col-md-3 cell"><c:out value="${dateFormat.format(chosenTicket.date)}"/></td>
                </tr>
                <tr>
                    <td class="col-md-3 cell"><c:out value="Гос. номер: ${chosenTicket.licensePlate}"/></td>
                    <td class="col-md-3 cell">
                        <div class="btn-group btn-flex" style="width: 100%;">
                            <select id ="violPick" class="selectpicker violationPick" title="Выберите нарушение" data-style="btn-info">
                                <c:forEach var="violation" items="${violations}">
                                    <c:if test="${violation.toString() == chosenTicket.violation.type.toString()}">
                                        <option selected value="${violation.toString()}"><c:out value="${violation.toString()}"></c:out></option>
                                    </c:if>
                                    <option value="${violation.toString()}"><c:out value="${violation.toString()}"></c:out></option>
                                </c:forEach>
                            </select>
                        </div>
                    </td>
                    <td class="col-md-3 cell">
                        <div class="btn-group btn-flex" style="width: 100%;">
                            <select id="aPick" class="selectpicker actionPick" multiple title="Выберите действие" data-style="btn-info">
                                <c:forEach var="action" items="${rusActions}">
                                    <option value="${action}"><c:out value="${action}"></c:out></option>
                                </c:forEach>
                            </select>
                        </div>
                    </td>
                    <td class="col-md-3 cell"><c:out value="${chosenTicket.address}"/></td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="row well" id="gallery">
            <div class="">
                <div class="w3-content" style="max-width: 800px">
                    <c:forEach var="photo" items="${chosenStrPhotos}">
                        <img class="mySlides" src="${photo}" style="width: 100%;">
                    </c:forEach>
                </div>
                <div class="w3-center">
                    <div class="w3-section">
                        <button class="btn btn-warning" onclick="plusDivs(-1)">❮ Назад</button>
                        <button class="btn btn-warning" onclick="plusDivs(1)">Далее ❯</button>
                    </div>
                    <c:forEach var="i" end="${chosenStrPhotos.size()}" step="1" begin="1">
                        <button class="btn demo" onclick="currentDiv(${i})">${i}</button>
                    </c:forEach>
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
                <button id="btnUpdate" type="button" class="btn btn-info btnProcess">Обработать заявку</button>
                <button id type="button" class="btn btn-danger btnDecline">Отклонить заявку</button>
            </div>
        </div>
        <form:form id="updateForm" action="/updateTicket" method="post" modelAttribute="ticket">
            <input type="hidden" id="idPlace" name="curId" value=""/>
            <input type="hidden" id="violPlace" name="curViol" value=""/>
            <c:forEach var="i" begin="1" end="3" >
                <input type="hidden" id="action${i}" name="curAction" value=""/>
            </c:forEach>
        </form:form>
    </div>
</body>
</html>
