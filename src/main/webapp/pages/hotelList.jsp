<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<style>
		<%@ include file="/css/hotelList.css"%>
	</style>
	<link href="css/hotelList.css" rel="stylesheet" />
<!--<title>Insert title here</title>-->
</head>
<body background="../images/Beijing.jpeg">



		<c:forEach items="${hotelList}" var="hotel">

			<div id="container">

				<div class="product-details">
					<h2><a href="home.jsp">${hotel.hotelName}</a></h2>
					<p><i class="icon"> &#x2605 &#x2605 &#x2605 &#x2605 &#x2605</i></p>

					<p>Price per day:</p>
					<div class="statistics">
						<span>avarage stay: 7 days |  total tourists: 500</span>
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