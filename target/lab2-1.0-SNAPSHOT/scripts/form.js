const data = [];

$("#form").submit(function(e) {
    e.preventDefault();

    const form = document.forms[0];
    const error_message = document.createElement("div");
    error_message.className = "error";
    error_message.id = "error";
    const cur_error = document.getElementById("error");
    console.log(this);
    console.log($(this));
    if (cur_error != null) {
        cur_error.parentNode.removeChild(cur_error);
    }
    if (!form["x"].value) {
        error_message.innerHTML = "Invalid X value";
        document.getElementById("x_input").appendChild(error_message);
    }
    else if (!form["y"].value || isNaN(form["y"].value) || (-5 >= parseInt(form["y"].value) || parseInt(form["y"].value) >= 5)) {
        error_message.innerHTML = "Invalid Y value";
        document.getElementById("y_input").appendChild(error_message);
    }
    else if (!form["r"].value) {
        error_message.innerHTML = "Invalid R value";
        document.getElementById("r_input").appendChild(error_message);
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
    data.push(one_data);
    const table = document.querySelector("#tableBody");
    const tr = table.appendChild(document.createElement("tr"));
    const dataX = document.createElement("td");
    dataX.innerHTML = one_data["x"].toFixed(3);
    const dataY = document.createElement("td");
    dataY.innerHTML = one_data["y"].toFixed(3);
    const dataR = document.createElement("td");
    dataR.innerHTML = one_data["r"];
    const dataHitResult = document.createElement("td");
    dataHitResult.innerHTML = one_data["hitResult"];
    const dataCurrentTime = document.createElement("td");
    dataCurrentTime.innerHTML = one_data["currentTime"];
    const dataExecutionTime = document.createElement("td");
    dataExecutionTime.innerHTML = one_data["executionTime"];
    tr.appendChild(dataX);
    tr.appendChild(dataY);
    tr.appendChild(dataR);
    tr.appendChild(dataHitResult);
    tr.appendChild(dataCurrentTime);
    tr.appendChild(dataExecutionTime);
}