<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Profile</title>
    <link href="css/profile.css" rel="stylesheet"/>
</head>
<body>

<jsp:include page="../components/header.jsp"/>

<main>

    <input id="tab1" class="inp" type="radio" name="tabs" checked>
    <label class="lab" for="tab1">Profile</label>

    <input id="tab2" class="inp" type="radio" name="tabs">
    <label class="lab" for="tab2">Visa Statistic</label>

    <section id="content1">
        <p>First Name: <span>${person.firstName}</span></p>
        <hr>
        <p>Last Name: <span>${person.lastName}</span></p>
        <hr>
        <p>Username: <span>${person.username}</span></p>
        <hr>
    </section>

    <section id="content2">
        <c:forEach var="visa" items="${visaList}" varStatus="status">
            <p>${status.index+1}. country - ${countryList[status.index].countryName} <span>end date - ${visa.endDate}</span></p>
        </c:forEach>
    </section>

</main>
</body>
</html>
