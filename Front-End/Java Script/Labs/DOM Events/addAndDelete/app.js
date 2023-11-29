function addItem() {
    const inputTextElement = document
        .getElementById("newItemText");

    const newLiElement = document
        .createElement("li");
    newLiElement.textContent = inputTextElement.value;

    const deleteLinkElement = document
        .createElement("a");
    deleteLinkElement.href = "#";
    deleteLinkElement.textContent = "[Delete]";

    deleteLinkElement.addEventListener("click",
        deleteLiElement);

    newLiElement.appendChild(deleteLinkElement);

    const ulElement = document
        .getElementById("items");
    ulElement.appendChild(newLiElement);

    inputTextElement.value = "";

    function deleteLiElement(e) {
        const liElement = e.currentTarget
            .parentNode;
        liElement.remove();
    }
}