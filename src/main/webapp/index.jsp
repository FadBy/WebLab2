<%@ page import="marat.web.lab2.ResultRay" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
    if (!request.getParameterMap().isEmpty()) {
        response.sendError(response.SC_NOT_ACCEPTABLE, "Parameters are not allowed");
    }
    if (request.getReader().lines().findAny().isPresent()) {
        response.sendError(response.SC_NOT_ACCEPTABLE, "BodyContent is not allowed");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lab1</title>
    <link rel="icon" href="style/main_page_icon.png" type="image/x-icon">
    <link rel="stylesheet" href="style/main_page_style.css" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script type="module" src="scripts/canvas.js"></script>
    <script src="scripts/form.js"></script>
    <script type="module" src="scripts/get_all_table.js"></script>
</head>
<body>
<header class="block_section">
    <div>Сафин Марат Радикович P32081</div>
    <div>Вариант 1517</div>
</header>
<main>
    <div>
        <canvas class="block_section" id="canvas" width="350" height="350">
        </canvas>
        <div class="block_section form">
            <form id="form">
                <div id="x_input">
                    <label class="label_form">X</label>
                    <input type="radio" name="x" value="-2">-2
                    <input type="radio" name="x" value="-1.5">-1.5
                    <input type="radio" name="x" value="-1">-1
                    <input type="radio" name="x" value="-0.5">-0.5
                    <input type="radio" name="x" value="0">0<br>
                    <input type="radio" name="x" value="0.5">0.5
                    <input type="radio" name="x" value="1">1
                    <input type="radio" name="x" value="1.5">1.5
                    <input type="radio" name="x" value="2">2
                </div>
                <div id="y_input">
                    <label for="y" class="label_form">Y</label>
                    <input type="text" name="y" id="y">
                </div>
                <div id="r_input">
                    <label class="label_form">R</label>
                    <input type="radio" name="r" value="1">1
                    <input type="radio" name="r" value="2">2
                    <input type="radio" name="r" value="3">3
                    <input type="radio" name="r" value="4">4
                    <input type="radio" name="r" value="5">5
                </div>
                <button type="reset">reset</button>
                <button type="submit">submit</button>
            </form>

        </div>
    </div>
    <div class="block_section hundred_width table_block">
        <table class="hundred_width">
            <thead>
            <tr>
                <th>X</th>
                <th>Y</th>
                <th>R</th>
                <th>Hit result</th>
                <th>Current time</th>
                <th>Execution time</th>
            </tr>
            </thead>
            <tbody id="tableBody">

            </tbody>
        </table>
    </div>

</main>
</body>
</html>