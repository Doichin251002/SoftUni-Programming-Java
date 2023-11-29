function deleteByEmail() {
    const inputTextElement = document
        .getElementsByName("email")[0];
    const inputTextValue = inputTextElement
        .value.trim();

    const divElement = document
        .getElementById("result");

    const tdElements = Array
        .from(document
            .getElementsByTagName("td"));
    for (const tdElement of tdElements) {
        if (tdElement.textContent === inputTextValue) {
            const rowElement = tdElement
                .parentNode;
            rowElement.remove();

            divElement.textContent = "Deleted";

            inputTextElement.value = "";
            return;
        }
    }

    divElement.textContent = "Not found.";

    inputTextElement.value = "";
}