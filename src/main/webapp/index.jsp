<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="author" content="colorlib.com">
    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500" rel="stylesheet" />
    <link href="css/index.css" rel="stylesheet" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
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
    <select id="type">
    <option value="item1">item1</option>
    <option value="item2">item2</option>
    <option value="item3">item3</option>
</select>

<select id="size">
    <option value="">-- select one -- </option>
</select>
        <form method="POST" action="/main">
            <fieldset>
                <legend>SEARCH HOTEL</legend>
            </fieldset>

            <div class="inner-form">
                <div class="input-field fouth-wrap">
                    <div class="icon-wrap">
                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
                            <path
                                d="M12 12c2.21 0 4-1.79 4-4s-1.79-4-4-4-4 1.79-4 4 1.79 4 4 4zm0 2c-2.67 0-8 1.34-8 4v2h16v-2c0-2.66-5.33-4-8-4z">
                            </path>
                        </svg>
                    </div>
                    <select data-trigger="" name="choices-single-defaul">
                        <option placeholder="">China</option>
                        <option>France</option>
                        <option>Turkey</option>
                        <option>USA</option>
                    </select>
                </div>
                <div class="input-field fouth-wrap">
                    <div class="icon-wrap">
                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
                            <path
                                d="M12 12c2.21 0 4-1.79 4-4s-1.79-4-4-4-4 1.79-4 4 1.79 4 4 4zm0 2c-2.67 0-8 1.34-8 4v2h16v-2c0-2.66-5.33-4-8-4z">
                            </path>
                        </svg>
                    </div>
                    <select data-trigger="" name="choices-single-defaul">
                        <option placeholder="">2 Adults</option>
                        <option>3 Adults</option>
                        <option>4 Adults</option>
                        <option>5 Adults</option>
                    </select>
                </div>
                <div class="input-field second-wrap">
                    <div class="icon-wrap">
                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
                            <path
                                d="M17 12h-5v5h5v-5zM16 1v2H8V1H6v2H5c-1.11 0-1.99.9-1.99 2L3 19c0 1.1.89 2 2 2h14c1.1 0 2-.9 2-2V5c0-1.1-.9-2-2-2h-1V1h-2zm3 18H5V8h14v11z">
                            </path>
                        </svg>
                    </div>
                    <input class="datepicker" id="depart" type="text" placeholder="29 Aug 2018" />
                </div>
                <div class="input-field third-wrap">
                    <div class="icon-wrap">
                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
                            <path
                                d="M17 12h-5v5h5v-5zM16 1v2H8V1H6v2H5c-1.11 0-1.99.9-1.99 2L3 19c0 1.1.89 2 2 2h14c1.1 0 2-.9 2-2V5c0-1.1-.9-2-2-2h-1V1h-2zm3 18H5V8h14v11z">
                            </path>
                        </svg>
                    </div>
                    <input class="datepicker" id="return" type="text" placeholder="30 Aug 2018" />
                </div>
                
                <div class="input-field fifth-wrap">
                    <button class="btn-search" type="button">SEARCH</button>
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
    $(document).ready(function() {

        $("#type").change(function() {
            var val = $(this).val();
            if (val == "item1") {
                $("#size").html("<option value='test'>item1: test 1</option><option value='test2'>item1: test 2</option>");
            } else if (val == "item2") {
                $("#size").html("<option value='test'>item2: test 1</option><option value='test2'>item2: test 2</option>");

            } else if (val == "item3") {
                $("#size").html("<option value='test'>item3: test 1</option><option value='test2'>item3: test 2</option>");

            }
        });


    });</script>
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