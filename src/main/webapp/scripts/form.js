

$("#form").submit(function(e) {
    e.preventDefault();

    const form = document.forms[0];
    removeError();
    if (!form["x"].value) {
        showError($("#x_input"), "Invalid X value");
    }
    else if (!form["y"].value || isNaN(form["y"].value) || (-5 >= parseInt(form["y"].value) || parseInt(form["y"].value) >= 3)) {
        showError($("#y_input"), "Invalid Y value");
    }
    else if (!form["r"].value) {
        showError($("#r_input"), "Invalid R value");
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

export function addRay(one_data) {
    const tr = $("<tr></tr>");
    const dataX = $("<td></td>").html(one_data["x"].toFixed(3));
    const dataY = $("<td></td>").html(one_data["y"].toFixed(3));
    const dataR = $("<td></td>").html(one_data["r"]);
    const dataHitResult = $("<td></td>").html(one_data["hitResult"].toString());
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

export function showError(element, message) {
    removeError();
    element.append($("<div></div>").attr("id", "error").addClass("error").html(message));
}

export function removeError() {
    $("#error").remove();
}