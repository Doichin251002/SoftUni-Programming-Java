function addItem() {
    const inputTextElement = document
        .getElementById("newItemText");

    const newLiElement = document
        .createElement("li");
    newLiElement.textContent = inputTextElement.value;

    const ulElement = document
        .getElementById("items");
    ulElement.appendChild(newLiElement);

    inputTextElement.value = "";
}