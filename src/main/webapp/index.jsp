<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="author" content="colorlib.com">
<link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="css/index.css" rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
</head>

<body>

	<div class="topnav" id="myTopnav">
		<a href="#home">DreamTour</a>
		<a href="#news">News</a>
		<a href="#contact">Contact</a>
		<a href="#about">About</a>
		<a href="javascript:void(0);" class="icon" onclick="myFunction()">
			<i class="fa fa-bars"></i>
		</a>
	</div>

	<div class="s002">

		<form method="POST" action="${pageContext.request.contextPath}/HotelList">
			<fieldset>
				<legend>Choose the Trip of Your Dream</legend>
			</fieldset>
			<jsp:include page="${pageContext.request.contextPath}/GetCountriesServlet" />
			<div class="inner-form">
				<div class="input-field fouth-wrap">
					<select id="countrySelection" name="chosenCountry">
						<option value="allCountries">All Countries</option>
						<c:forEach var="country" items="${countries}">
							<option value="${country}"> ${country}</option>
						</c:forEach>
					</select>
				</div>
				<div class="input-field fouth-wrap">
					<select id="citySelection" name="chosenCity">
						<option value="allCities">All Cities</option>
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
						placeholder="29 Aug 2018" name="startDate"/>
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
						placeholder="30 Aug 2018" name="endDate"/>
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
                
                if (chosenCountry != "allCountries"){
                	
                	let cityList;
                
                	$.ajax({
                        type: "POST",
                        async: false,
                        url: "/GetCitiesServlet",
                        data: { country: chosenCountry }
                    }).done(function (response) {
                    	cityList = response.split(" ");
                    }).fail(function (response) {
                    	alert(response);
                    });
                	
	                for (var i = 0; i < cityList.length; i++) {
						console.log(cityList[i]);
	                	cityListHtml += "<option value=\'" + cityList[i] + "\'>" + cityList[i] + "</option>";
	                }
                } else {
                	cityListHtml = "<option value=\"allCities\">All Cities</option>";
                }
                
                $("#citySelection").html(cityListHtml);
            });


        });
    </script>
	<script>
        function myFunction() {
            var x = document.getElementById("myTopnav");
            if (x.className === "topnav") {
                x.className += " responsive";
            } else {
                x.className = "topnav";
            }
        }
    </script>
</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>