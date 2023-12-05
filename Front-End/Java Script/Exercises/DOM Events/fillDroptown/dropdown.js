function addItem() {
    const inputTextElement = document.getElementById("newItemText");
    const inputValueElement = document.getElementById("newItemValue");

    const optionElement = document.createElement("option");
    optionElement.value = inputValueElement.value;
    optionElement.textContent = inputTextElement.value;

    if (inputTextElement.value && inputValueElement.value) {
        const selectMenuElement = document.getElementById("menu");
        selectMenuElement.appendChild(optionElement);
    }

    inputTextElement.value = "";
    inputValueElement.value = "";
}