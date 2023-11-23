function extractText() {
    const listElements = document
        .getElementsByTagName("li");

    let editedTextAreaContent = [];
    for (const listElement of Array.from(listElements)) {
        const content = listElement.textContent;

        editedTextAreaContent.push(content);
    }

    const textAreaElement = document.getElementById("result");

    textAreaElement.textContent = editedTextAreaContent.join("\n");
}