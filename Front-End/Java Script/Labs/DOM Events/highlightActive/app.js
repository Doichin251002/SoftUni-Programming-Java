function focused() {
    const inputElements = Array
        .from(document
            .getElementsByTagName("input"));

    for (const inputElement of inputElements) {
        inputElement.addEventListener("focus", highlightFocusedDiv);
        inputElement.addEventListener("blur", clearUnfocusedDiv);
    }

    function highlightFocusedDiv(e) {
        const divElement = e.currentTarget.parentNode;
        divElement.className = "focused";
    }

    function clearUnfocusedDiv(e) {
        const divElement = e.currentTarget.parentNode;
        divElement.className = "";
    }
}