<%--
  Created by IntelliJ IDEA.
  User: lenel
  Date: 5/23/2019
  Time: 9:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/hotelPage.css">
    <title>${hotel.hotelName}</title>
</head>
<body>
<div id="images">
    <p>
        ${hotel.imageUrl}
    </p>
</div>
<div id="rooms">
    <h1>Список вільних кімнат</h1>
</div>
<input id="submit" type="submit" name="Book">
<div id="desc">
    <p>
        ${hotel.hotelDescription}
    </p>
</div>
</body>
</html>
