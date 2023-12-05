function encodeAndDecodeMessages() {
    const encodeButton = document.getElementsByTagName("button")[0];
    encodeButton.addEventListener("click", encodeInputText);

    const decodeButton = document.getElementsByTagName("button")[1];
    decodeButton.addEventListener("click", decodeInputText);

    function encodeInputText(e) {
        const parentDiv = e.currentTarget.parentElement;
        const inputTextAreaElement = parentDiv.getElementsByTagName("textarea")[0];

        if (!inputTextAreaElement.value) {
            return;
        }

        const charsFromText = inputTextAreaElement.value;

        let encodedText = "";
        for (let i = 0; i < charsFromText.length; i++) {
            const newCharASCIICode = charsFromText.charCodeAt(i) + 1;
            encodedText += String.fromCharCode(newCharASCIICode);
        }

        const outputTextAreaElement = document.getElementsByTagName("textarea")[1];
        outputTextAreaElement.value = encodedText;

        inputTextAreaElement.value = "";
    }

    function decodeInputText(e) {
        const parentDiv = e.currentTarget.parentElement;
        const inputTextAreaElement = parentDiv.getElementsByTagName("textarea")[0];

        if (!inputTextAreaElement.value) {
            return;
        }

        const charsFromText = inputTextAreaElement.value;

        let encodedText = "";
        for (let i = 0; i < charsFromText.length; i++) {
            const newCharASCIICode = charsFromText.charCodeAt(i) - 1;
            encodedText += String.fromCharCode(newCharASCIICode);
        }

        inputTextAreaElement.value = encodedText;
    }
}