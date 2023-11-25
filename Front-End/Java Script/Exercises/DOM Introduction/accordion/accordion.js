function toggle() {
    const divElement = document
        .getElementById("extra");
    const buttonElement = document
        .getElementsByClassName("button")[0];

    if (buttonElement.textContent === "More") {
        buttonElement.textContent = "Less";

        divElement.style.display = "block";
    } else {
        buttonElement.textContent = "More";

        divElement.style.display = "none";
    }
}