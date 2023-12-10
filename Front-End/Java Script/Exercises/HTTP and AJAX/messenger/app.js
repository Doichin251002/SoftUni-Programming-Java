function attachEvents() {
    const baseUrl = "http://localhost:3030/jsonstore/messenger";

    const messagesTextArea = document.getElementById("messages");
    const [authorInput, contentInput, sendButton, refreshButton]  =
        document.getElementsByTagName("input");

    let allMessages = {};

    sendButton.addEventListener("click", async () => {
        const isValidMessage = authorInput.value !== "" && contentInput.value !== "";

        if (!isValidMessage) {
            return;
        }

        const messageFormat = {
            author: authorInput.value,
            content: contentInput.value
        };

        await fetch(baseUrl, {
            method: "POST",
            body: JSON.stringify(messageFormat)
        });

        authorInput.value = "";
        contentInput.value = "";

    })

    refreshButton.addEventListener("click", async () => {
        const response = await fetch(baseUrl);
        allMessages = await response.json();

        const displayedMessages = [];

        Object.values(allMessages).forEach(({author, content}) =>
            displayedMessages.push(`${author}: ${content}`));

        messagesTextArea.textContent = displayedMessages.join("\n");
    });
}

attachEvents();