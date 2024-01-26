const form = document.getElementById("sendToServer");
form.addEventListener("submit", function (event) {
    if (!isValid()) {
        event.preventDefault();
    }
});

function setR(r, button) {
    document.getElementsByName("r")[0].value = r;
    const l = document.getElementsByName("R-button")
    var el;
    for (el of l) {
        el.removeAttribute('disabled');
    }
    button.setAttribute('disabled', 'disabled');
    /*alert(document.getElementsByName("r")[0].value+"1234")*/
}

function isValid() {
    let errorMessage = "";
    if (!validX()) {
        errorMessage += "Incorrect X\n";
    }

    if (!validY()) {
        errorMessage += "Incorrect Y\n";
    }

    if (!validR()) {
        errorMessage += "Incorrect R\n";
    }

    document.getElementById("errorMessage").innerHTML = errorMessage;
    return errorMessage.length === 0;
}

function validR() {
    let r_text = document.getElementById("r").value;
    r_text = parseInt(r_text);
    return !(isNaN(r_text) || 1 > r_text || r_text > 5);
}

function validY() {
    let y_text = document.getElementById("Y-input").value.replaceAll(',', '.');
    if (isNaN(y_text)) {
        return false;
    }
    y_text = parseFloat(y_text)
    return !(isNaN(y_text) || y_text < -5 || y_text > 5);
}

function validX() {
    const x_select_input= parseInt(document.querySelector('input[name="x"]:checked').value);
    return !(isNaN(x_select_input) || -3 > x_select_input || x_select_input > 5);
}

function getR() {
    return parseInt(document.getElementById("r").value);
}