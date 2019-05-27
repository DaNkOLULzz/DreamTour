<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>DreamTour</title>
    <link href="css/index.css" rel="stylesheet"/>
</head>

<body>

<jsp:include page="components/header.jsp" />

<div class="s002">

    <form method="POST" action="${pageContext.request.contextPath}/HotelListServlet" onsubmit="return validate()">
        <fieldset>
            <legend>You dream - we make</legend>
        </fieldset>
        <jsp:include page="${pageContext.request.contextPath}/GetCountriesServlet"/>
        <div class="inner-form">
            <div class="input-field fouth-wrap">
                <select id="countrySelection" name="chosenCountry">
                    <option value="allCountries">Choose Country</option>
                    <c:forEach var="country" items="${countries}">
                        <option value="${country}"> ${country}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="input-field fouth-wrap">
                <select id="citySelection" name="chosenCity">
                    <option value="allCities">Choose City</option>
                </select>
            </div>
            <div class="input-field second-wrap">
                <div class="icon-wrap">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                         viewBox="0 0 24 24">
                        <path
                                d="M17 12h-5v5h5v-5zM16 1v2H8V1H6v2H5c-1.11 0-1.99.9-1.99 2L3 19c0 1.1.89 2 2 2h14c1.1 0 2-.9 2-2V5c0-1.1-.9-2-2-2h-1V1h-2zm3 18H5V8h14v11z">
                        </path>
                    </svg>
                </div>
                <input class="datepicker" id="depart" type="text"
                       placeholder="Start Date" name="startDate"/>
            </div>
            <div class="input-field third-wrap">
                <div class="icon-wrap">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                         viewBox="0 0 24 24">
                        <path
                                d="M17 12h-5v5h5v-5zM16 1v2H8V1H6v2H5c-1.11 0-1.99.9-1.99 2L3 19c0 1.1.89 2 2 2h14c1.1 0 2-.9 2-2V5c0-1.1-.9-2-2-2h-1V1h-2zm3 18H5V8h14v11z">
                        </path>
                    </svg>
                </div>
                <input class="datepicker" id="return" type="text"
                       placeholder="End Date" name="endDate"/>
            </div>

            <div class="input-field fifth-wrap">
                <button class="btn-search" type="submit">SEARCH</button>
            </div>
        </div>
    </form>
</div>
<script src="js/extention/choices.js"></script>
<script src="js/extention/flatpickr.js"></script>
<script>
    flatpickr(".datepicker", {});
</script>
<script>
    const choices = new Choices('[data-trigger]', {
        searchEnabled: false,
        itemSelectText: '',
    });
</script>
<script>
    $(document).ready(function () {

        $("#countrySelection").change(function () {


            var e = document.getElementById("countrySelection");
            var chosenCountry = e.options[e.selectedIndex].value;

            console.log(chosenCountry != "allCountries");
            let cityListHtml = "";

            if (chosenCountry != "allCountries") {

                let cityList = "";

                $.ajax({
                    type: "POST",
                    async: false,
                    url: "/GetCitiesServlet",
                    data: {country: chosenCountry}
                }).done(function (response) {
                    cityList = response.split(",");
                }).fail(function (response) {
                    alert(response);
                });

                for (var i = 0; i < cityList.length; i++) {
                    console.log(cityList[i]);
                    cityListHtml += "<option value=\'" + cityList[i] + "\'>" + cityList[i] + "</option>";
                }
            } else {
                cityListHtml = "<option value=\"allCities\">Choose City</option>";
            }

            $("#citySelection").html(cityListHtml);
        });


    });
</script>
<script>
    function validate() {

        var chosenCountry = document.getElementById("countrySelection").value;
        var startDate = document.getElementById("depart").value;
        var endDate = document.getElementById("return").value;

        console.log(startDate);

        if (chosenCountry === "allCountries") {
            alert("Please, choose country!");
            return false;
        } else {

            if (endDate !== "" && startDate === "") {
                alert("Please, choose start Date!");
                return false;
            } else {
                return true;
            }
        }
    }
</script>
</body>

</html>