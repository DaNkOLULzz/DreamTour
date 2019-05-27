<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <link href="css/profile.css" rel="stylesheet"/>
</head>
<body>

<jsp:include page="../components/header.jsp"/>

<main>

    <input id="tab1" type="radio" name="tabs" checked>
    <label for="tab1">Profile</label>

    <input id="tab2" type="radio" name="tabs">
    <label for="tab2">Visa Statistic</label>

    <section id="content1">
        <p>
            profile info
        </p>
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
