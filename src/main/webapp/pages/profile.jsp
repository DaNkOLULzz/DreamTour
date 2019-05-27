<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <p>First Name: ${person.firstName}</p>
        <p>Last Name: ${person.lastName}</p>
        <p>Username: ${person.username}</p>
    </section>

    <section id="content2">
        <p>amount of visas: 15</p>
        <p>
            country 1 - 3 visas
            country 2 - 2 visas
        </p>
    </section>

</main>
</body>
</html>
