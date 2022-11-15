function show_error(element_id, message) {
    $("#error").remove();
    // if (cur_error != null) {
    //     cur_error.parentNode.removeChild(cur_error);
    // }
    const error_message = $(element_id).append($("<div></div>").attr("id", "error").addClass("error").html(message));
}

$("#form").submit(function(e) {
    e.preventDefault();

    const form = document.forms[0];
    if (!form["x"].value) {
        show_error("#x_input", "Invalid X value");
    }
    else if (!form["y"].value || isNaN(form["y"].value) || (-5 >= parseInt(form["y"].value) || parseInt(form["y"].value) >= 3)) {
        show_error("#y_input", "Invalid Y value");
    }
    else if (!form["r"].value) {
        show_error("#y_input", "Invalid R value");
    }
    else {
        $.ajax({
            type: "GET",
            url: "ControllerServlet",
            data: $(this).serialize(),
            dataType: "json",
            encode: true,
            timeout: 2000,
            success: addRay,
            error: function(obj, textStatus, errorThrown) {
                console.log(errorThrown);
                console.log(obj);
            }
        });
    }
});

function addRay(one_data) {
    const tr = $("<tr></tr>");
    const dataX = $("<td></td>").html(one_data["x"].toFixed(3));
    const dataY = $("<td></td>").html(one_data["y"].toFixed(3));
    const dataR = $("<td></td>").html(one_data["r"]);
    const dataHitResult = $("<td></td>").html(one_data["hitResult"]);
    const dataCurrentTime = $("<td></td>").html(one_data["currentTime"]);
    const dataExecutionTime = $("<td></td>").html(one_data["executionTime"]);
    tr.append(dataX);
    tr.append(dataY);
    tr.append(dataR);
    tr.append(dataHitResult);
    tr.append(dataCurrentTime);
    tr.append(dataExecutionTime);
    $("#tableBody").append(tr);
}