import {addRay} from "./form.js";


$(document).ready(function() {
    $.ajax({
        type: "GET",
        url: "GetAllTableServlet",
        data: $(this).serialize(),
        dataType: "json",
        encode: true,
        timeout: 2000,
        success: function (data) {
            for (const json of data) {
                addRay(json);
            }
        },
        error: function(obj, textStatus, errorThrown) {
            console.log(obj);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
});