<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <style>
        <%@ include file="/css/hotelList.css"%>
    </style>
    <link href="css/hotelList.css" rel="stylesheet"/>
    <title>List of Hotels</title>

</head>
<body background="../images/bg_1.jpg">
<%--<jsp:include page="../components/header.jsp"/>--%>

<c:forEach items="${hotelList}" var="hotel" varStatus="status">

    <div id="container">

        <div class="product-details">


            <h2><a href="/hotel?idHotel=${hotel.idHotel}&startDate=${startDate}&endDate=${endDate}&country=${chosenCountry}&city=${chosenCity}">
                    ${hotel.hotelName}</a></h2>

            <p>
                <c:forEach var="i" begin="1" end="${hotel.stars}" step="1">
                    <i class="icon"> &#x2605</i>
                </c:forEach>
            </p>

            <p>Price per day:</p>
            <div class="statistics">
                <span>average stay: ${countTourist[status.index]} days |  total tourists: ${averageStay[status.index]}</span>
            </div>

        </div>

        <div class="product-image">

            <img src="https://live.staticflickr.com/65535/32932471367_354f843af3_b.jpg">

            <div class="info">

                <p class="information">${hotel.hotelDescription}</p>
            </div>
        </div>

    </div>

</c:forEach>


</body>
</html>